package cn.zilime.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.dao.CustomerDao;
import cn.zilime.domain.Customer;
import cn.zilime.service.CustomerService;
import cn.zilime.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
private CustomerDao cd;
	
	
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalcount=cd.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalcount,pageSize);
		
		
		List<Customer> list= cd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}



	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
