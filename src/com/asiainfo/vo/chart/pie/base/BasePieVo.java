package com.asiainfo.vo.chart.pie.base;

import java.util.List;

import com.asiainfo.vo.component.TitleVo;
import com.asiainfo.vo.component.TooltipVo;
import com.asiainfo.vo.component.serie.SerieDataVo;

/**
 * 	饼图超类
 * @author Mr.du
 */
public abstract class BasePieVo{
	private TitleVo title;
	
	private TooltipVo tooltip;
	
	private List<SerieDataVo> series;
	
	public TitleVo getTitle() {
		return title;
	}
	public void setTitle(TitleVo title) {
		this.title = title;
	}
	public List<SerieDataVo> getSeries() {
		return series;
	}
	public void setSeries(List<SerieDataVo> series) {
		this.series = series;
	}
	public TooltipVo getTooltip() {
		return tooltip;
	}
	public void setTooltip(TooltipVo tooltip) {
		this.tooltip = tooltip;
	}
}
