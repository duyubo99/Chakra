package com.asiainfo.vo.chart.dendrogram;

import java.util.List;

import com.asiainfo.vo.chart.dendrogram.base.BaseDendrogramVo;
import com.asiainfo.vo.component.serie.SerieDataVo;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 	树状图vo
 * @author Mr.du
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DendrogramDataDesVo extends BaseDendrogramVo{
	private List<SerieDataVo> series;

	public List<SerieDataVo> getSeries() {
		return series;
	}

	public void setSeries(List<SerieDataVo> series) {
		this.series = series;
	}
}
