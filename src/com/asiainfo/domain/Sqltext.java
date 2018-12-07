package com.asiainfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OTHER_SQL_TEXT")
public class Sqltext implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="S_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	@Column(name="SQL_STR")
	private String sqlStr;
	@Column(name="PAR_STR")
	private String parStr;
	@Column(name="UUID")
	private String uuid;//批次编号
	@Column(name="KEY_STR")
	private String keyStr;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getSqlStr() {
		return sqlStr;
	}
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getParStr() {
		return parStr;
	}
	public void setParStr(String parStr) {
		this.parStr = parStr;
	}
	public String getKeyStr() {
		return keyStr;
	}
	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}
}
