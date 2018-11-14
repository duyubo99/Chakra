package com.asiainfo.vo.component;

import com.asiainfo.domain.cell.TextStyle;
import com.asiainfo.domain.component.Title;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 标题组件
 * @author Mr.du
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TitleVo extends Title{
	
	private TextStyle textStyle;
	
	private TextStyle subtextStyle;

	public TextStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}

	public TextStyle getSubtextStyle() {
		return subtextStyle;
	}

	public void setSubtextStyle(TextStyle subtextStyle) {
		this.subtextStyle = subtextStyle;
	}
}




