package com.asiainfo.vo.chart.pie;

import com.asiainfo.vo.chart.pie.base.BasePieVo;
import com.asiainfo.vo.component.legend.LegendDataVo;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 	饼图
 * @author Mr.du
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PieDataDesVo extends BasePieVo{
	private LegendDataVo legend;

	public LegendDataVo getLegend() {
		return legend;
	}

	public void setLegend(LegendDataVo legend) {
		this.legend = legend;
	}
}
