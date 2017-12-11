package cn.zilime.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.zilime.domain.Customer;
import cn.zilime.service.CustomerService;
import cn.zilime.utils.PageBean;



public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService	customerService;
	private Customer customer=new Customer();
	private Integer currentPage;
	private Integer pageSize;
	

	
	
	
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService= customerService;
	}
	
	
	public String add() throws Exception{
		customerService.save(customer);
				
		return "tolist";
	}
   
	
	public String delete() throws Exception {
		
		customerService.delete(customer);
			
			return "tolist";
		}
	
	
	public String toEdit() throws Exception {
	Customer c=customerService.getByID(customer.getCust_id());
	ActionContext.getContext().put("customer", c);	
		
		return "edit";
	}


	public String list() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));			
		}
		
		
		PageBean pagebean=customerService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pagebean);
		
		return "list";
	}


	@Override
	public Customer getModel() {
		 
		return customer;
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
