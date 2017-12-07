package cn.zilime.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;  //��ǰҳ��
	private Integer totalCount;  //�ܼ�¼����
	private Integer pageSize;  //ÿҳ��ʾ����
	private Integer totalPage;  //��ҳ��
	private List list;   //�������
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		if(this.currentPage==null){   //Ĭ�ϵ�ǰҳ��
			this.currentPage=1;
		}
		
		if(this.pageSize==null){    //Ĭ��ÿҳ��ʾ����
			this.pageSize=4;
		}
		
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;  //������ҳ��
		
		
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

