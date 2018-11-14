package com.asiainfo.vo.chart.pie;

import com.asiainfo.vo.chart.pie.base.BasePieVo;
import com.asiainfo.vo.component.legend.LegendVo;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 	饼图
 * @author Mr.du
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PieVo extends BasePieVo{
	private LegendVo legend;

	public LegendVo getLegend() {
		return legend;
	}

	public void setLegend(LegendVo legend) {
		this.legend = legend;
	}
}
