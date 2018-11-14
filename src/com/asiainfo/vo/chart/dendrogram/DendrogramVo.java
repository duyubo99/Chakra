package com.asiainfo.vo.chart.dendrogram;

import java.util.List;

import com.asiainfo.vo.chart.dendrogram.base.BaseDendrogramVo;
import com.asiainfo.vo.component.serie.SerieVo;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 	树状图vo
 * @author Mr.du
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DendrogramVo extends BaseDendrogramVo{
	private List<SerieVo> series;

	public List<SerieVo> getSeries() {
		return series;
	}

	public void setSeries(List<SerieVo> series) {
		this.series = series;
	}
}
