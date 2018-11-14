package com.asiainfo.vo.component.serie;

import com.asiainfo.domain.component.Serie;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SerieVo  extends Serie{
	private Object[] data;
	
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
}
