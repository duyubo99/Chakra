package com.asiainfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.myenum.AxisType;
import com.asiainfo.myenum.SerieType;
import com.asiainfo.service.DendrogramService;
import com.asiainfo.service.PieService;
import com.asiainfo.vo.cell.DataDesVo;
import com.asiainfo.vo.chart.dendrogram.DendrogramDataDesVo;
import com.asiainfo.vo.chart.dendrogram.DendrogramVo;
import com.asiainfo.vo.chart.pie.PieVo;
import com.asiainfo.vo.component.AxisVo;
import com.asiainfo.vo.component.TitleVo;
import com.asiainfo.vo.component.TooltipVo;
import com.asiainfo.vo.component.serie.SerieDataVo;
import com.asiainfo.vo.component.serie.SerieVo;

@Controller
@RequestMapping("/test")
public class TestConntroller {
	
	@Resource
	private DendrogramService dendrogramService;
	
	@Resource
	private PieService pieService ;
	
	@ResponseBody
	@RequestMapping("/testLoadEcharts")
    public  PieVo testLoadEcharts(){
//		DendrogramVo vo = loadDendrogramVo();
//		DendrogramDataDesVo vo = loadDendrogramDataVo();
//		PieVo vo = loadPieVo();
		PieVo vo = pieService.loadPie(2);
		
//		DendrogramVo vo=(DendrogramVo) dendrogramService.loadDendrogram(1);
//		DendrogramDataDesVo vo=loadDendrogramDataVo();
//		BaseDendrogramVo dendrogram = dendrogramService.loadDendrogram(1);
//		if(dendrogram instanceof DendrogramVo){
//			DendrogramVo vo= (DendrogramVo) dendrogram;
//			return vo;
//		}
//		if(dendrogram instanceof DendrogramDataDesVo){
//			DendrogramDataDesVo vo= (DendrogramDataDesVo) dendrogram;
//			 return vo;
//		}
        return vo;
//		return null;
    }
	/**
	 * 测试饼图
	 * @return
	 */
	public PieVo loadPieVo() {
    	PieVo vo = new PieVo();
    	TitleVo t = new TitleVo();
		t.setText("helloPie");
		vo.setTitle(t);
		List<SerieDataVo> series = new ArrayList<SerieDataVo>();
		SerieDataVo sdvo = new SerieDataVo();
		sdvo.setName("访问来源");
		sdvo.setType(SerieType.pie);
		List<DataDesVo> datas = new ArrayList<DataDesVo>();
		datas.add(new DataDesVo(335,"直接访问"));
		datas.add(new DataDesVo(310,"邮件营销"));
		datas.add(new DataDesVo(234,"联盟广告"));
		datas.add(new DataDesVo(135,"视频广告"));
		datas.add(new DataDesVo(1548,"搜索引擎"));
		sdvo.setData(datas);
		series.add(sdvo);
		vo.setSeries(series);
		TooltipVo tooltip = new TooltipVo();
		tooltip.setTrigger("item");
		tooltip.setFormatter("{a} <br/>{b} : {c} ({d}%)");
		vo.setTooltip(tooltip);
		pieService.savePie(vo);
		return vo;
	}

    /**
     * 测试树状图
     * @return
     */
	public  DendrogramVo loadDendrogramVo(){
		DendrogramVo u = new DendrogramVo();
		AxisVo x = new AxisVo();
		x.setData(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
		x.setType(AxisType.category);
		AxisVo y = new AxisVo();
		y.setType(AxisType.value);
		SerieVo s = new SerieVo();
		s.setType(SerieType.bar);
		s.setData(new Integer[]{120, 200, 150, 80, 70, 110, 130});
		TitleVo t = new TitleVo();
		t.setText("hello`.`");
		List<SerieVo> series = new ArrayList<SerieVo>();
		series.add(s);
		series.add(s);
		u.setSeries(series);
		u.setxAxis(x);
		u.setyAxis(y);
		u.setTitle(t);
		dendrogramService.saveDendrogram(u);
        return u;
    }
	/**
     * 测试树状图-DataDes
     * @return
     */
	public  DendrogramDataDesVo loadDendrogramDataVo(){
		DendrogramDataDesVo u = new DendrogramDataDesVo();
		AxisVo x = new AxisVo();
		x.setData(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
		x.setType(AxisType.category);
		AxisVo y = new AxisVo();
		y.setType(AxisType.value);
		SerieDataVo s = new SerieDataVo();
		s.setType(SerieType.bar);
		DataDesVo ddvo = new DataDesVo();
		List<DataDesVo> ddvos = new ArrayList<DataDesVo>();
		ddvo.setName("t1");
		ddvo.setValue(1);
		ddvos.add(ddvo);
		ddvo.setName("t2");
		ddvo.setValue(2);
		ddvos.add(ddvo);
		s.setData(ddvos);
		TitleVo t = new TitleVo();
		t.setText("hello");
		List<SerieDataVo> series = new ArrayList<SerieDataVo>();
		series.add(s);
		series.add(s);
		u.setSeries(series);
		u.setxAxis(x);
		u.setyAxis(y);
		u.setTitle(t);
		dendrogramService.saveDendrogram(u);
//		u=dendrogramService.loadDendrogram(1);
        return u;
    }
}
