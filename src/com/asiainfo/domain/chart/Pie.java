package com.asiainfo.domain.chart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 饼图
 * @author Mr.du
 */
@Entity
@Table(name="CHART_PIE")
@JsonIgnoreProperties({"pId", "seriesIdsStr"})
public class Pie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="P_ID")
	private Integer pId;
	@Column(name="T_ID_")
	private Integer titleId;
	@Column(name="TOOLTIP_ID_")
	private Integer tooltipId;
	@Column(name="SERIES_IDS_STR_")//需转换字段
	private String seriesIdsStr;
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getSeriesIdsStr() {
		return seriesIdsStr;
	}
	public void setSeriesIdsStr(String seriesIdsStr) {
		this.seriesIdsStr = seriesIdsStr;
	}
	public Integer getTooltipId() {
		return tooltipId;
	}
	public void setTooltipId(Integer tooltipId) {
		this.tooltipId = tooltipId;
	}
}
