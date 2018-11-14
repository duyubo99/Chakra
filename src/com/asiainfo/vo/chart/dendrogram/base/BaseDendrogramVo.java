package com.asiainfo.vo.chart.dendrogram.base;

import com.asiainfo.vo.component.AxisVo;
import com.asiainfo.vo.component.TitleVo;

/**
 * 	树状图超类
 * @author Mr.du
 */
public abstract class BaseDendrogramVo{
	private TitleVo title;
	private AxisVo xAxis;
	private AxisVo yAxis;
	
	public TitleVo getTitle() {
		return title;
	}
	public void setTitle(TitleVo title) {
		this.title = title;
	}
	public AxisVo getxAxis() {
		return xAxis;
	}
	public void setxAxis(AxisVo xAxis) {
		this.xAxis = xAxis;
	}
	public AxisVo getyAxis() {
		return yAxis;
	}
	public void setyAxis(AxisVo yAxis) {
		this.yAxis = yAxis;
	}
}
