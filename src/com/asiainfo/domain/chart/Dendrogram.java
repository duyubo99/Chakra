package com.asiainfo.domain.chart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 树状图
 * @author Mr.du
 */
@Entity
@Table(name="CHART_DENDROGRAM")
@JsonIgnoreProperties({"dId", "seriesType","xAxisId","yAxisId"})
public class Dendrogram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="D_ID")
	private Integer dId;
	/**
	 *  series_type:
	 * 	1-SerieVo
	 * 	2-SerieDataVo
	 */
	@Column(name="SERIES_TYPE")
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Integer seriesType;
	@Column(name="T_ID_")
	private Integer titleId;
	@Column(name="XAXIS_ID_")//关联字段
	private Integer xAxisId;
	@Column(name="YAXIS_ID_")//关联字段
	private Integer yAxisId;
	@Column(name="SERIES_IDS_STR_")//需转换字段
	private String seriesIdsStr;
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public Integer getxAxisId() {
		return xAxisId;
	}
	public void setxAxisId(Integer xAxisId) {
		this.xAxisId = xAxisId;
	}
	public Integer getyAxisId() {
		return yAxisId;
	}
	public void setyAxisId(Integer yAxisId) {
		this.yAxisId = yAxisId;
	}
	public String getSeriesIdsStr() {
		return seriesIdsStr;
	}
	public void setSeriesIdsStr(String seriesIdsStr) {
		this.seriesIdsStr = seriesIdsStr;
	}
	public Integer getSeriesType() {
		return seriesType;
	}
	public void setSeriesType(Integer seriesType) {
		this.seriesType = seriesType;
	}
	
}
