package com.asiainfo.util;

import java.io.Serializable;
import java.util.List;

public class MyPage<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页
	 */
	private int page;
	/**
	 * 每页大小
	 */
	private int rows;
	/**
    *  总条数
    */
	private int totalCount;
	/**
	 * 起始下标
	 */
	private int startIndex;
	/**
	 * 排序字段
	 */
	private String sort;
	/**
	 * 排序方式
	 */
	private String order="asc";
	 /**
	  * content 每页的内容
	  */
	private List<T> content;
	/**
	 * 查询条件
	 */
	private T queryModel;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartIndex() {
		this.startIndex=(page-1)*rows;
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public T getQueryModel() {
		return queryModel;
	}
	public void setQueryModel(T queryModel) {
		this.queryModel = queryModel;
	}
	
}
