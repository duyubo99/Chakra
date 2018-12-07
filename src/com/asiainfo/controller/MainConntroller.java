package com.asiainfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.domain.Jsontext;
import com.asiainfo.service.OtherService;
import com.asiainfo.service.SqlService;
import com.asiainfo.util.MyPage;
import com.asiainfo.webservice.AsiainfoService;

@Controller
@RequestMapping("/main")
public class MainConntroller {
	
	@Resource
	private OtherService otherService;
	@Resource
	private SqlService sqlService;
	@Resource
	private AsiainfoService asiainfoService;
	
	Map<String,String> sqls;
	Map<String,String> sqlsParams;
	@RequestMapping
	public String getMain(){
		return "main";
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "index";
	}
	
	@RequestMapping("/left")
	public String getLeft(){
		return "left";
	}
	
	@RequestMapping("/top")
	public String getTop(){
		return "top";
	}
	
	@RequestMapping("/echartDemo")
	public String getDchartDemo(){
		return "echartdemo";
	}
	@RequestMapping("/toUpdateText")
    public  ModelAndView  toUpdateText(int id){
		Object[] objs = otherService.readEchartById(id);
		ModelAndView view=new ModelAndView();
		view.addObject("jt", objs[0]);
		view.addObject("sqlText", objs[1]);
		view.setViewName("index");
		return view;
    }
	@RequestMapping("/loadList")
	@ResponseBody
    public  Object  loadList(MyPage<Jsontext> page,String busNo,String descText){
		Map<String, Object> map = new HashMap<>();
		Jsontext query = new Jsontext();
		if(busNo!=null&&!busNo.equals(""))
			query.setBusNo(busNo);
		if(descText!=null&&!descText.equals(""))
			query.setDescText(descText);
		page.setQueryModel(query);
		otherService.findJsonTextListByPage(page);
		map.put("total", page.getTotalCount());
		map.put("rows", page.getContent());
		return map;
    }
	@RequestMapping("/toList")
    public  String  toList(){
		return "list";
    }
	@ResponseBody
	@RequestMapping(value="/loadechart",produces="text/html;charset=UTF-8")
	public String loadechart(String eparames,String jsonStr){
		jsonStr=jsonStr.replaceAll(" ", "");
		sqls = new HashMap<String,String>();
		sqlsParams = new HashMap<String,String>();
		if(jsonStr.indexOf("@")!=-1&&eparames!=null&&!eparames.equals("")){
			String[] split = eparames.split(";");
			for (String sqlStr : split) {
				String[] sqlConf = sqlStr.split(",");
				sqls.put(sqlConf[0],sqlConf[1]);
				if(sqlConf.length==3){
					sqlsParams.put(sqlConf[0], sqlConf[2]);
				}
			}
			jsonStr = sqlService.convertJsonPar2Jsontext(jsonStr,sqls,sqlsParams);
		}
		return jsonStr;
	}
	/**
	 * 
	 * @param idStr 不为null则为更新，反之则为新增
	 * @param esrcText
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveechart",produces="text/html;charset=UTF-8")
	public String saveechart(Jsontext jt){
		if(jt.getJsonStr()!=null&&!jt.getJsonStr().equals("")){
			jt.setJsonStr(jt.getJsonStr().replaceAll(" ", ""));
			if(jt.getjId()!=null){
				otherService.updateText(jt,sqls,sqlsParams);
			}else{
				otherService.saveText(jt,sqls,sqlsParams);
			}
			return jt.getJsonStr();
		}
		return null;
	}
	@ResponseBody
	@RequestMapping(value="/queryJson",produces="text/html;charset=UTF-8")
	public String queryTextByNo(String callback,String params,String no){
		@SuppressWarnings("unchecked")
		Map<String,String> paramMap = JSONObject.parseObject(params,Map.class);  
		sqls = new HashMap<String,String>();
		String result = asiainfoService.queryText(no, paramMap);
		return callback+"("+JSONObject.toJSONString(result)+")";
	}
}
