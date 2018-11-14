package com.asiainfo.vo.cell;

import com.asiainfo.domain.cell.DataDes;

/**
 * @author Mr.du
 */
public class DataDesVo extends DataDes{
	
	public DataDesVo() {
		super();
	}
	public DataDesVo(Integer value, String name) {
		super.setValue(value);
		super.setName(name);
	}
}
