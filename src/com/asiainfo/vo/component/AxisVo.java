package com.asiainfo.vo.component;

import com.asiainfo.domain.cell.TextStyle;
import com.asiainfo.domain.component.Axis;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxisVo extends Axis{
	
	private TextStyle nameTextStyle;
	
	private Object[] data;
	
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
	public TextStyle getNameTextStyle() {
		return nameTextStyle;
	}
	public void setNameTextStyle(TextStyle nameTextStyle) {
		this.nameTextStyle = nameTextStyle;
	}
}
