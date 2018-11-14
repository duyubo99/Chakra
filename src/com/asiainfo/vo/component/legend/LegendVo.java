package com.asiainfo.vo.component.legend;

import com.asiainfo.domain.component.Legend;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegendVo extends Legend{
private Object[] data;
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
}
