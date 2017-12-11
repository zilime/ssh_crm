package cn.zilime.service;

import java.util.List;

import cn.zilime.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
