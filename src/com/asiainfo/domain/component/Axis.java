package com.asiainfo.domain.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asiainfo.myenum.AxisType;
import com.asiainfo.myenum.NameLocation;
import com.asiainfo.myenum.Position;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="COM_AXIS")
@JsonIgnoreProperties({"aId", "ntsId","dataStr"})
public class Axis {
	@Id
	@Column(name="A_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aId;
	@Column(name="ID_")
	private Integer id;
	@Column(name="SHOW_")
	private Boolean show;
	@Column(name="GRID_INDEX_")
	private Integer gridIndex;
	@Column(name="POSITION_")
	private Position position;
	@Column(name="OFFSET_")
	private Integer offset;
	@Column(name="TYPE_")
	private AxisType type;
	@Column(name="NAME_")
	private String name;
	@Column(name="NAME_LOCATION_")
	private NameLocation nameLocation;
	@Column(name="NTS_ID_")//关联字段
	private Integer ntsId;
	@Column(name="NAME_GAP_")
	private Integer nameGap;
	@Column(name="NAME_ROTATE_")
	private Integer nameRotate;
	@Column(name="INVERSE_")
	private Boolean inverse;
	@Column(name="BOUNDARY_GAP_")
	private Boolean boundaryGap;
	@Column(name="MIN_")
	private String min;
	@Column(name="MAX_")
	private String max;
	@Column(name="SCALE_")
	private Boolean scale;
	@Column(name="SPLIT_NUMBER_")
	private Integer splitNumber;
	@Column(name="MIN_INTERVAL_")
	private Integer minInterval;
	@Column(name="MAX_INTERVAL_")
	private Integer maxInterval;
	@Column(name="INTERVAL_")
	private Integer interval;
	@Column(name="LOGBASE_")
	private Integer logBase;
	@Column(name="SILENT_")
	private Boolean silent;
	@Column(name="TRIGGER_EVENT_")
	private Boolean triggerEvent;
	@Column(name="DATA_STR_")//需转换字段
	private String dataStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean isShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	public Integer getGridIndex() {
		return gridIndex;
	}
	public void setGridIndex(Integer gridIndex) {
		this.gridIndex = gridIndex;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public AxisType getType() {
		return type;
	}
	public void setType(AxisType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NameLocation getNameLocation() {
		return nameLocation;
	}
	public void setNameLocation(NameLocation nameLocation) {
		this.nameLocation = nameLocation;
	}
	public Integer getNameGap() {
		return nameGap;
	}
	public void setNameGap(Integer nameGap) {
		this.nameGap = nameGap;
	}
	public Integer getNameRotate() {
		return nameRotate;
	}
	public void setNameRotate(Integer nameRotate) {
		this.nameRotate = nameRotate;
	}
	public Boolean isInverse() {
		return inverse;
	}
	public void setInverse(Boolean inverse) {
		this.inverse = inverse;
	}
	public Boolean isBoundaryGap() {
		return boundaryGap;
	}
	public void setBoundaryGap(Boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public Boolean isScale() {
		return scale;
	}
	public void setScale(Boolean scale) {
		this.scale = scale;
	}
	public Integer getSplitNumber() {
		return splitNumber;
	}
	public void setSplitNumber(Integer splitNumber) {
		this.splitNumber = splitNumber;
	}
	public Integer getMinInterval() {
		return minInterval;
	}
	public void setMinInterval(Integer minInterval) {
		this.minInterval = minInterval;
	}
	public Integer getMaxInterval() {
		return maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public Integer getInterval() {
		return interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public Integer getLogBase() {
		return logBase;
	}
	public void setLogBase(Integer logBase) {
		this.logBase = logBase;
	}
	public Boolean isSilent() {
		return silent;
	}
	public void setSilent(Boolean silent) {
		this.silent = silent;
	}
	public Boolean isTriggerEvent() {
		return triggerEvent;
	}
	public void setTriggerEvent(Boolean triggerEvent) {
		this.triggerEvent = triggerEvent;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public Integer getNtsId() {
		return ntsId;
	}
	public void setNtsId(Integer ntsId) {
		this.ntsId = ntsId;
	}
	public Boolean getShow() {
		return show;
	}
	public Boolean getInverse() {
		return inverse;
	}
	public Boolean getBoundaryGap() {
		return boundaryGap;
	}
	public Boolean getScale() {
		return scale;
	}
	public Boolean getSilent() {
		return silent;
	}
	public Boolean getTriggerEvent() {
		return triggerEvent;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
}
