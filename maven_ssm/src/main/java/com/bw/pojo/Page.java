package com.bw.pojo;

import java.util.List;

/**分页表*/
public class Page<T> {
	private int pageNum;//总记录数
	private int pageSize;//每页大小
	private int pageCount;//总页数
	private int pageIndex;//当前页
	private List<T> list;//当前页的数据
	public Page() {
		super();
	}
	public Page(int pageNum, int pageSize, int pageCount, int pageIndex, List<T> list) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
