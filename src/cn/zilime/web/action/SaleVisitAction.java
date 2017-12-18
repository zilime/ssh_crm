package cn.zilime.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.zilime.domain.Customer;
import cn.zilime.domain.SaleVisit;
import cn.zilime.domain.User;
import cn.zilime.service.CustomerService;
import cn.zilime.service.SaleVisitService;
import cn.zilime.utils.PageBean;



public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisitService	saleVisitService;
	private SaleVisit saleVisit=new SaleVisit();
	private Integer currentPage;
	private Integer pageSize;
	

	
	
	
	

	
	
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}


	public String add() throws Exception{
		User u=(User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		if(saleVisit.getVisit_id().equals(""))
		{
			saleVisit.setVisit_id(null);
		}
		saleVisitService.save(saleVisit);
				
		return "tolist";
	}
   
	
	public String delete() throws Exception {
		
		saleVisitService.delete(saleVisit);
			
			return "tolist";
		}
	
	
	public String toEdit() throws Exception {
		
		
		return "edit";
	}


	public String list() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(SaleVisit.class);
		if (saleVisit.getCustomer()!=null && saleVisit.getCustomer().getCust_id()!=null ) {
			dc.add(Restrictions.like("customer.cust_id",saleVisit.getCustomer().getCust_id()));			
		}
		
		
		PageBean pagebean=saleVisitService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pagebean);
		
		return "list";
	}


	@Override
	public SaleVisit getModel() {
		 
		return saleVisit;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}




	
	
	
	
	
}
