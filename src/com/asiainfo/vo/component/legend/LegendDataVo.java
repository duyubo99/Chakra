package com.asiainfo.vo.component.legend;

import java.util.List;

import com.asiainfo.domain.component.Legend;
import com.asiainfo.vo.cell.DataDesVo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegendDataVo extends Legend{
	private List<DataDesVo> data;
	public List<DataDesVo> getData() {
		return data;
	}

	public void setData(List<DataDesVo> data) {
		this.data = data;
	}
}
