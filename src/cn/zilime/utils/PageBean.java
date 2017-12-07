package cn.zilime.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;  //当前页码
	private Integer totalCount;  //总记录数量
	private Integer pageSize;  //每页显示数量
	private Integer totalPage;  //总页数
	private List list;   //结果集合
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		if(this.currentPage==null){   //默认当前页码
			this.currentPage=1;
		}
		
		if(this.pageSize==null){    //默认每页显示数量
			this.pageSize=4;
		}
		
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;  //计算总页数
		
		
		if(this.currentPage<1){
			this.currentPage=1;
		}
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
		
		
	}
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	
  
	
	
	
	
}

