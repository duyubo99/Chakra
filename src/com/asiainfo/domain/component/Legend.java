package com.asiainfo.domain.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.myenum.LegendType;
import com.asiainfo.myenum.Orient;
import com.asiainfo.myenum.Position;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="COM_LEGEND")
@JsonIgnoreProperties({"lId", "tsId","dataStr"})
public class Legend {
	@Id
	@Column(name="L_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lId;
	@Column(name="TYPE_")
	private LegendType type;
	@Column(name="ID_")
	private Integer id;
	@Column(name="SHOW_")
	private Boolean show;
	@Column(name="ZLEVEL_")
	private Integer zlevel;
	@Column(name="Z_")
	private Integer z;
	@Column(name="TOP_")
	private Position top;
	@Column(name="RIGHT_")
	private Position right;
	@Column(name="BOTTOM_")
	private Position bottom;
	@Column(name="WIDTH_")
	private String width;
	@Column(name="HEIGHT_")
	private String height;
	@Column(name="ORIENT_")
	private Orient orient;
	@Column(name="ALIGN_")
	private Position align;
	@Column(name="PADDING_")
	private Integer padding;
	@Column(name="ITEM_GAP_")
	private Integer itemGap;
	@Column(name="ITEM_WIDTH_")
	private Integer itemWidth;
	@Column(name="ITEM_HEIGHT_")
	private Integer itemHeight;
	@Column(name="SYMBOL_KEEP_ASPECT_")
	private Boolean symbolKeepAspect;
	@Column(name="FORMATTER_")
	private String formatter;
	@Column(name="SELECTED_MODE_")
	private String selectedMode;
	@Column(name="INACTIVE_COLOR_")
	private String inactiveColor;
	@Column(name="TS_ID_")//关联字段TextStyle
	private Integer tsId;
	@Column(name="DATA_STR_")//需转换字段,关联id用“,”分隔，值用“@”分隔
	private String dataStr;
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public LegendType getType() {
		return type;
	}
	public void setType(LegendType type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
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
	public Position getTop() {
		return top;
	}
	public void setTop(Position top) {
		this.top = top;
	}
	public Position getRight() {
		return right;
	}
	public void setRight(Position right) {
		this.right = right;
	}
	public Position getBottom() {
		return bottom;
	}
	public void setBottom(Position bottom) {
		this.bottom = bottom;
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
	public Orient getOrient() {
		return orient;
	}
	public void setOrient(Orient orient) {
		this.orient = orient;
	}
	public Position getAlign() {
		return align;
	}
	public void setAlign(Position align) {
		this.align = align;
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
	public Integer getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(Integer itemWidth) {
		this.itemWidth = itemWidth;
	}
	public Integer getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(Integer itemHeight) {
		this.itemHeight = itemHeight;
	}
	public Boolean getSymbolKeepAspect() {
		return symbolKeepAspect;
	}
	public void setSymbolKeepAspect(Boolean symbolKeepAspect) {
		this.symbolKeepAspect = symbolKeepAspect;
	}
	public String getFormatter() {
		return formatter;
	}
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	public String getSelectedMode() {
		return selectedMode;
	}
	public void setSelectedMode(String selectedMode) {
		this.selectedMode = selectedMode;
	}
	public String getInactiveColor() {
		return inactiveColor;
	}
	public void setInactiveColor(String inactiveColor) {
		this.inactiveColor = inactiveColor;
	}
	public Integer getTsId() {
		return tsId;
	}
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
}
