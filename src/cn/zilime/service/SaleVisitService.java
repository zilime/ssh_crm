package cn.zilime.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.domain.SaleVisit;
import cn.zilime.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	void delete(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
