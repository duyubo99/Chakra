package com.asiainfo.domain.cell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Mr.du
 */
@Entity
@Table(name="CELL_DATA_DES")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"dId"})
public class DataDes {
	@Id
	@Column(name="D_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dId;
	@Column(name="VALUE_")
	private Integer value;
	@Column(name="NAME_")
	private String name;
	@Column(name="ICON_")
	private String icon;
	@Column(name="TS_ID_")//关联字段
	private Integer tsId;
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getTsId() {
		return tsId;
	}
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}
	
	
}
