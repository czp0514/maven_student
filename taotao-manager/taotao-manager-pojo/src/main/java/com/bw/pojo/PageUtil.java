package com.bw.pojo;

/**
 * 功能描述:分页功能的工具类
 * 类名称：PageUtil   
 * 创建人：Administrator 
 * 创建时间：2019年1月15日 上午11:05:14   
 */
public class PageUtil {
	private int pageSize;//每页显示条数
	private int currentPage;//当前页
	private int totalPage;//总页数
	private int totalRecord;//总记录数
	private int upPage;//上一页
	private int nextPage;//下一页 
	private int onsetPage;//起始页
	public PageUtil(String currentPage, int pageSize, int totalRecord) {
		super();
		this.pageSize = pageSize;
		//设置当前页
		this.setCP(currentPage);
		this.totalRecord = totalRecord;
		//总页数
		this.setTP();
		//上一页
		this.setUP();
		//下一页
		this.setNP();
		//起始索引页
		this.setOP();
	}
	//设置当前页
	public void setCP(String cp) {
		if(cp==null || cp=="") {
			this.currentPage=1;
		}else {
			this.currentPage=Integer.valueOf(cp);
		}
	}
	//总页数
	public void setTP() {
		if(this.totalRecord % this.pageSize ==0) {
			this.totalPage=this.totalRecord / this.pageSize;
		}else {
			this.totalPage=this.totalRecord / this.pageSize+1;
		}
	}
	//设置上一页
	public void setUP() {
		if(this.currentPage==1) {
			this.upPage=1;
		}else {
			this.upPage=this.currentPage-1;
		}
	}
	//设置下一页
	public void setNP() {
		if(this.currentPage==this.totalPage) {
			this.nextPage=this.totalPage;
		}else {
			this.nextPage=this.currentPage+1;
		}
	}
	//设置起始页
	private void setOP() {
		this.onsetPage=(this.currentPage-1)*this.pageSize;

	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getUpPage() {
		return upPage;
	}
	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getOnsetPage() {
		return onsetPage;
	}
	public void setOnsetPage(int onsetPage) {
		this.onsetPage = onsetPage;
	}
	public PageUtil() {
		super();
	}
	@Override
	public String toString() {
		return "PageUtil [pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", totalRecord=" + totalRecord + ", upPage=" + upPage + ", nextPage=" + nextPage + ", onsetPage="
				+ onsetPage + "]";
	}
	
	
}