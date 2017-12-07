package cn.zilime.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.domain.Customer;

public interface CustomerDao {

	Integer getTotalCount(DetachedCriteria dc);

	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
