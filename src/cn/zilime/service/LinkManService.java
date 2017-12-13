package cn.zilime.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.zilime.domain.LinkMan;
import cn.zilime.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void delete(LinkMan linkMan);

	LinkMan getById(Long lkm_id);

}
