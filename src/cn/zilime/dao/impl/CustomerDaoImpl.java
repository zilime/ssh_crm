package cn.zilime.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.zilime.dao.CustomerDao;
import cn.zilime.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {





	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
	  dc.setProjection(Projections.rowCount());
	  List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
	  dc.setProjection(null);
	  
	  if (list!=null&&list.size()>0){
		  Long count=list.get(0);
		  return count.intValue();
	  }
	  else{
		  return null;
	  }
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

}
