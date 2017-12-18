package cn.zilime.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.dao.SaleVisitDao;

import cn.zilime.domain.SaleVisit;
import cn.zilime.service.SaleVisitService;
import cn.zilime.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {
    
	SaleVisitDao svd;
		
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	@Override
	public void save(SaleVisit saleVisit) {
	svd.save(saleVisit);
	}

	@Override
	public void delete(SaleVisit saleVisit) {
	svd.delete(saleVisit.getVisit_id());

	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalcount=svd.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalcount,pageSize);
		
		
		List<SaleVisit> list= svd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

}
