package com.asiainfo.service;

import com.asiainfo.vo.chart.dendrogram.base.BaseDendrogramVo;

public interface DendrogramService{
	public void saveDendrogram(BaseDendrogramVo vo);

	public BaseDendrogramVo loadDendrogram(int i);
}
