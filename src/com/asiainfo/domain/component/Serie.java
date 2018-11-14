package com.asiainfo.domain.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.myenum.SerieType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="COM_SERIE")
@JsonIgnoreProperties({"sId", "dataStr"})
public class Serie {
	@Id
	@Column(name="S_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	@Column(name="NAME_")
	private String name;
	@Column(name="STACK_")
	private String stack;
	@Column(name="TYPE_")
	private SerieType type;
	@Column(name="DATA_STR_")//需转换字段,关联id用“,”分隔，值用“@”分隔
	private String dataStr;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	public SerieType getType() {
		return type;
	}
	public void setType(SerieType type) {
		this.type = type;
	}
	
}
