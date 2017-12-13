package cn.zilime.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.dao.LinkManDao;
import cn.zilime.domain.Customer;
import cn.zilime.domain.LinkMan;
import cn.zilime.service.LinkManService;
import cn.zilime.utils.PageBean;

public class linkManServiceImpl implements LinkManService {

	LinkManDao lmd;
	
	
	
	
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalcount=lmd.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalcount,pageSize);
		
		
		List<LinkMan> list= lmd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void delete(LinkMan linkMan) {
		lmd.delete(linkMan.getLkm_id());
		
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		LinkMan linkMan = lmd.getById(lkm_id);
		return linkMan;
	}

}
