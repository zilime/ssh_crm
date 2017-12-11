package cn.zilime.service.impl;

import java.util.List;

import cn.zilime.dao.BaseDictDao;
import cn.zilime.domain.BaseDict;
import cn.zilime.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
private BaseDictDao bdd;


	public List<BaseDict> getListByTypeCode(String dict_type_code) {
         List list=bdd.getListByTypeCode(dict_type_code);
         return list;
	}


	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
