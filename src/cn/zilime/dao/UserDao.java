package cn.zilime.dao;

import cn.zilime.domain.User;

public interface UserDao extends BaseDao<User> {

	User getByUserCode(String usercode);


	
	
	
	
}
