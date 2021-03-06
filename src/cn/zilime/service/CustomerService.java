package cn.zilime.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.domain.Customer;
import cn.zilime.utils.PageBean;


public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getByID(Long cust_id);

	void delete(Customer customer);

}
