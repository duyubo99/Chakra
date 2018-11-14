package com.asiainfo.domain.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.myenum.Target;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 标题组件
 * @author Mr.du
 */
@Entity
@Table(name="COM_TITLE")
@JsonIgnoreProperties({"tId", "tsId","stsId"})
public class Title {
	@Id
	@Column(name="T_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tId;
	@Column(name="ID_")
	private String id;
	@Column(name="SHOW_")
	private Boolean show;
	@Column(name="TEXT_")
	private String text;
	@Column(name="LINK_")
	private String link;
	@Column(name="TARGET_")
	private Target target;
	@Column(name="TS_ID_")//关联字段TextStyle
	private Integer tsId;
	@Column(name="SUBTEXT_")
	private String subtext;
	@Column(name="SUBLINK_")
	private String sublink;
	@Column(name="SUBTARGET_")
	private Target subtarget;
	@Column(name="STS_ID_")//关联字段TextStyle
	private Integer stsId;
	@Column(name="TRIGGER_EVENT_")
	private Boolean triggerEvent;
	@Column(name="PADDING_")
	private Integer padding;
	@Column(name="ITEM_GAP_")
	private Integer itemGap;
	@Column(name="ZLEVEL_")
	private Integer zlevel;
	@Column(name="Z_")
	private Integer z;
	@Column(name="LEFT_")
	private String left;
	@Column(name="TOP_")
	private String top;
	@Column(name="RIGHT_")
	private String right;
	@Column(name="BOTTOM_")
	private String bottom;
	@Column(name="BACKGROUND_COLOR_")
	private String backgroundColor;
	@Column(name="BORDER_COLOR_")
	private String borderColor;
	@Column(name="BORDER_WIDTH_")
	private Integer borderWidth;
	@Column(name="BORDER_RADIUS_")
	private Integer borderRadius;
	@Column(name="SHADOW_BLUR_")
	private Integer shadowBlur;
	@Column(name="SHADOW_COLOR_")
	private String shadowColor;
	@Column(name="SHADOW_OFFSET_X_")
	private Integer shadowOffsetX;
	@Column(name="SHADOW_OFFSET_Y_")
	private Integer shadowOffsetY;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean isShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public String getSubtext() {
		return subtext;
	}
	public void setSubtext(String subtext) {
		this.subtext = subtext;
	}
	public String getSublink() {
		return sublink;
	}
	public void setSublink(String sublink) {
		this.sublink = sublink;
	}
	public Target getSubtarget() {
		return subtarget;
	}
	public void setSubtarget(Target subtarget) {
		this.subtarget = subtarget;
	}
	public Boolean isTriggerEvent() {
		return triggerEvent;
	}
	public void setTriggerEvent(Boolean triggerEvent) {
		this.triggerEvent = triggerEvent;
	}
	public Integer getPadding() {
		return padding;
	}
	public void setPadding(Integer padding) {
		this.padding = padding;
	}
	public Integer getItemGap() {
		return itemGap;
	}
	public void setItemGap(Integer itemGap) {
		this.itemGap = itemGap;
	}
	public Integer getZlevel() {
		return zlevel;
	}
	public void setZlevel(Integer zlevel) {
		this.zlevel = zlevel;
	}
	public Integer getZ() {
		return z;
	}
	public void setZ(Integer z) {
		this.z = z;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public String getBottom() {
		return bottom;
	}
	public void setBottom(String bottom) {
		this.bottom = bottom;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public Integer getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
	public Integer getBorderRadius() {
		return borderRadius;
	}
	public void setBorderRadius(Integer borderRadius) {
		this.borderRadius = borderRadius;
	}
	public Integer getShadowBlur() {
		return shadowBlur;
	}
	public void setShadowBlur(Integer shadowBlur) {
		this.shadowBlur = shadowBlur;
	}
	public String getShadowColor() {
		return shadowColor;
	}
	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}
	public Integer getShadowOffsetX() {
		return shadowOffsetX;
	}
	public void setShadowOffsetX(Integer shadowOffsetX) {
		this.shadowOffsetX = shadowOffsetX;
	}
	public Integer getShadowOffsetY() {
		return shadowOffsetY;
	}
	public void setShadowOffsetY(Integer shadowOffsetY) {
		this.shadowOffsetY = shadowOffsetY;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getTsId() {
		return tsId;
	}
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}
	public Integer getStsId() {
		return stsId;
	}
	public void setStsId(Integer stsId) {
		this.stsId = stsId;
	}
	public Boolean getShow() {
		return show;
	}
	public Boolean getTriggerEvent() {
		return triggerEvent;
	}
	
}




