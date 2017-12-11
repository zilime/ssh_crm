package cn.zilime.dao;

import java.util.List;

import cn.zilime.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List getListByTypeCode(String dict_type_code);

}
