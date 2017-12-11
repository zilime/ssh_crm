package cn.zilime.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.zilime.dao.BaseDictDao;
import cn.zilime.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {


	@Override
	public List getListByTypeCode(String dict_type_code) {
		DetachedCriteria dc=DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list=(List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
		
	}



}
