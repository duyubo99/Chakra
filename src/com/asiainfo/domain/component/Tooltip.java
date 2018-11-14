package com.asiainfo.domain.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="COM_TOOLTIP")
@JsonIgnoreProperties({"tId", "tsId"})
public class Tooltip {
	@Id
	@Column(name="T_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tId;
	@Column(name="SHOW_")
	private Boolean show;
	@Column(name="TRIGGER_")
	private String trigger;
	@Column(name="SHOW_CONTENT_")
	private Boolean showContent;
	@Column(name="ALWAYS_SHOW_CONTENT_")
	private Boolean alwaysShowContent;
	@Column(name="SHOW_DELAY")
	private Integer showDelay;
	@Column(name="HIDE_DELAY")
	private Integer hideDelay;
	@Column(name="ENTERABLE_")
	private Boolean enterable;
	@Column(name="RENDERMODE_")
	private String renderMode;
	@Column(name="CONFINE_")
	private Boolean confine;
	@Column(name="TRANSITION_DURATION_")
	private Double transitionDuration;
	@Column(name="FORMATTER_")
	private String formatter;
	@Column(name="TS_ID_")//关联字段TextStyle
	private Integer tsId;
	@Column(name="EXTRA_CSS_TEXT_")
	private String extraCssText;
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	public Boolean getShowContent() {
		return showContent;
	}
	public void setShowContent(Boolean showContent) {
		this.showContent = showContent;
	}
	public Boolean getAlwaysShowContent() {
		return alwaysShowContent;
	}
	public void setAlwaysShowContent(Boolean alwaysShowContent) {
		this.alwaysShowContent = alwaysShowContent;
	}
	public Integer getShowDelay() {
		return showDelay;
	}
	public void setShowDelay(Integer showDelay) {
		this.showDelay = showDelay;
	}
	public Integer getHideDelay() {
		return hideDelay;
	}
	public void setHideDelay(Integer hideDelay) {
		this.hideDelay = hideDelay;
	}
	public Boolean getEnterable() {
		return enterable;
	}
	public void setEnterable(Boolean enterable) {
		this.enterable = enterable;
	}
	public String getRenderMode() {
		return renderMode;
	}
	public void setRenderMode(String renderMode) {
		this.renderMode = renderMode;
	}
	public Boolean getConfine() {
		return confine;
	}
	public void setConfine(Boolean confine) {
		this.confine = confine;
	}
	public Double getTransitionDuration() {
		return transitionDuration;
	}
	public void setTransitionDuration(Double transitionDuration) {
		this.transitionDuration = transitionDuration;
	}
	public String getFormatter() {
		return formatter;
	}
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	public Integer getTsId() {
		return tsId;
	}
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}
	public String getExtraCssText() {
		return extraCssText;
	}
	public void setExtraCssText(String extraCssText) {
		this.extraCssText = extraCssText;
	}
	
}
