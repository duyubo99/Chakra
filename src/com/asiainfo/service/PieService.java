package com.asiainfo.service;

import com.asiainfo.vo.chart.pie.PieVo;

public interface PieService{
	public void savePie(PieVo vo);

	public PieVo loadPie(int i);
}
