package com.asiainfo.domain.cell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.myenum.FontStyle;
import com.asiainfo.myenum.FontWeight;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 标题文字样式
 * @author Mr.du
 */
@Entity
@Table(name="CELL_TEXT_STYLE")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"tId"})
public class TextStyle {
	@Id
	@Column(name="T_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tId;
	@Column(name="COLOR_")
	private String color;
	@Column(name="FONT_STYLE_")
	private FontStyle fontStyle;
	@Column(name="FONT_WEIGHT_")
	private FontWeight fontWeight;
	@Column(name="FONT_FAMILY_")
	private String fontFamily;
	@Column(name="FONT_SIZE_")
	private Integer fontSize;
	@Column(name="ALIGN_")
	private String align;
	@Column(name="VERTICAL_ALIGN_")
	private String verticalAlign;
	@Column(name="LINE_HEIGHT_")
	private String lineHeight;
	@Column(name="WIDTH_")
	private String width;
	@Column(name="HEIGHT_")
	private String height;
	@Column(name="TEXT_BORDER_COLOR_")
	private String textBorderColor;
	@Column(name="TEXT_BORDER_WIDTH_")
	private Integer textBorderWidth;
	@Column(name="TEXT_SHADOW_COLOR_")
	private String textShadowColor;
	@Column(name="TEXT_SHADOW_BLUR_")
	private Integer textShadowBlur;
	@Column(name="TEXT_SHADOW_OFFSET_X_")
	private Integer textShadowOffsetX;
	@Column(name="TEXT_SHADOW_OFFSET_Y_")
	private Integer textShadowOffsetY;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public FontStyle getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}
	public FontWeight getFontWeight() {
		return fontWeight;
	}
	public void setFontWeight(FontWeight fontWeight) {
		this.fontWeight = fontWeight;
	}
	public String getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getVerticalAlign() {
		return verticalAlign;
	}
	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}
	public String getLineHeight() {
		return lineHeight;
	}
	public void setLineHeight(String lineHeight) {
		this.lineHeight = lineHeight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getTextBorderColor() {
		return textBorderColor;
	}
	public void setTextBorderColor(String textBorderColor) {
		this.textBorderColor = textBorderColor;
	}
	public Integer getTextBorderWidth() {
		return textBorderWidth;
	}
	public void setTextBorderWidth(Integer textBorderWidth) {
		this.textBorderWidth = textBorderWidth;
	}
	public String getTextShadowColor() {
		return textShadowColor;
	}
	public void setTextShadowColor(String textShadowColor) {
		this.textShadowColor = textShadowColor;
	}
	public Integer getTextShadowBlur() {
		return textShadowBlur;
	}
	public void setTextShadowBlur(Integer textShadowBlur) {
		this.textShadowBlur = textShadowBlur;
	}
	public Integer getTextShadowOffsetX() {
		return textShadowOffsetX;
	}
	public void setTextShadowOffsetX(Integer textShadowOffsetX) {
		this.textShadowOffsetX = textShadowOffsetX;
	}
	public Integer getTextShadowOffsetY() {
		return textShadowOffsetY;
	}
	public void setTextShadowOffsetY(Integer textShadowOffsetY) {
		this.textShadowOffsetY = textShadowOffsetY;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	
}
