package com.asiainfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OTHER_JSON_TEXT")
public class Jsontext implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="J_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jId;
	@Column(name="JSON_STR", columnDefinition="TEXT", nullable=true)
	private String jsonStr;
	@Column(name="UUID")
	private String uuid;//批次编号
	@Column(name="BUS_NO")
	private String busNo;//业务编号
	@Column(name="IS_VALID")
	private String isValid;//图表是否有效
	@Column(name="DESC_TEXT")
	private String descText;//描述
	public Integer getjId() {
		return jId;
	}
	public void setjId(Integer jId) {
		this.jId = jId;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getDescText() {
		return descText;
	}
	public void setDescText(String descText) {
		this.descText = descText;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
}
