package com.asiainfo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.asiainfo.domain.cell.DataDes;
import com.asiainfo.domain.component.Axis;
import com.asiainfo.domain.component.Serie;
import com.asiainfo.domain.component.Title;
import com.asiainfo.domain.component.Tooltip;
import com.asiainfo.vo.cell.DataDesVo;
import com.asiainfo.vo.component.AxisVo;
import com.asiainfo.vo.component.TitleVo;
import com.asiainfo.vo.component.TooltipVo;
import com.asiainfo.vo.component.serie.SerieDataVo;
import com.asiainfo.vo.component.serie.SerieVo;

/**
 * 业务逻辑数据处理工具
 * @author Mr.du
 */
public class DataUtil {

	/**
	 * Axis直角坐标系实体数据到业务层数据转换
	 */
	public static AxisVo modelToVo(Axis model) {
		AxisVo vo = new AxisVo();
		BeanUtils.copyProperties(model, vo);
		if(model.getDataStr()!=null){
			vo.setData(model.getDataStr().split(","));
		}
		return vo;
	}
	
	/**
	 * Tooltip实体数据到业务层数据转换
	 */
	public static TooltipVo modelToVo(Tooltip model) {
		TooltipVo vo = new TooltipVo();
		BeanUtils.copyProperties(model, vo);
		return vo;
	}
	
	/**
	 * Axis直角坐标系业务层数据到实体数据转换
	 */
	public static Axis voToModel(AxisVo vo) {
		Axis model = new Axis();
		BeanUtils.copyProperties(vo , model);
		if(vo.getData()!=null&&vo.getData().length!=0){
			model.setDataStr(StringUtil.arr2Str(vo.getData(),","));
		}
		return model;
	}
	
	/**
	 * Trigger业务层数据到实体数据转换
	 */
	public static Tooltip voToModel(TooltipVo vo) {
		Tooltip model = new Tooltip();
		BeanUtils.copyProperties(vo , model);
		return model;
	}
	
	/**
	 * title标题实体数据到业务层数据转换
	 */
	public static TitleVo modelToVo(Title model) {
		TitleVo vo = new TitleVo();
		BeanUtils.copyProperties(model, vo);
		return vo;
	}
	/**
	 * title标题业务层数据到实体数据转换
	 */
	public static Title voToModel(TitleVo vo) {
		Title model = new Title();
		BeanUtils.copyProperties(vo , model);
		return model;
	}
	
	/**
	 * Serie实体数据到业务层数据转换
	 */
	public static SerieVo modelToVo(Serie model) {
		SerieVo vo = new SerieVo();
		BeanUtils.copyProperties(model, vo);
		if(model.getDataStr()!=null){
			if(model.getDataStr().indexOf(",")!=-1){
				vo.setData(model.getDataStr().split(","));
			}else{
				vo.setData(model.getDataStr().split("@"));
			}
		}
		return vo;
	}
	/**
	 * Serie实体数据到业务层数据转换
	 */
	public static SerieDataVo modelToDataVo(Serie model,DataCallback callback) {
		SerieDataVo vo = new SerieDataVo();
		BeanUtils.copyProperties(model, vo);
		List<DataDesVo> dataDess = new ArrayList<DataDesVo>();
		if(model.getDataStr()!=null){
			String[] dIds = model.getDataStr().split(",");
			for (String dId : dIds) {
				DataDes dataDes = callback.getDataDes(Integer.parseInt(dId));
				DataDesVo dataDesVo = modelToVo(dataDes);
				dataDess.add(dataDesVo);
			}
			vo.setData(dataDess);
		}
		return vo;
	}
	/**
	 * DataDes实体数据到业务层数据转换
	 */
	public static DataDesVo modelToVo(DataDes model) {
		DataDesVo vo = new DataDesVo();
		BeanUtils.copyProperties(model, vo);
		return vo;
	}
	/**
	 * Serie业务层数据到实体数据转换
	 */
	public static Serie voToModel(SerieVo vo) {
		Serie model = new Serie();
		BeanUtils.copyProperties(vo , model);
		if(vo.getData()!=null && vo.getData().length!=0){
			model.setDataStr(StringUtil.arr2Str(vo.getData(),"@"));
		}
		return model;
	}
	
	/**
	 * Serie业务层数据到实体数据转换
	 */
	public static Serie voToModel(SerieDataVo vo,DataCallback callback) {
		Serie model = new Serie();
		BeanUtils.copyProperties(vo , model);
		if(ValidateUtil.isValid(vo.getData())){
			List<DataDesVo> data = vo.getData();
			String strs = callback.saveDataDes(data);
			model.setDataStr(strs);
		}
		return model;
	}
	
	/**
	 * DataDes业务层数据到实体数据转换
	 */
	public static DataDes voToModel(DataDesVo vo) {
		DataDes model = new DataDes();
		BeanUtils.copyProperties(vo , model);
		return model;
	}
	
	
	
	/**
	 * 静态内部类：数据处理回调函数
	 * @author Administrator
	 *
	 */
	public static interface DataCallback {
		/**
		 * 保存DataDes并反回id
		 */
		String saveDataDes(List<DataDesVo> list);
		/**
		 * 加载DataDes
		 */
		DataDes getDataDes(int i);
	}
}
