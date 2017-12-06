package cn.zilime.dao;

import cn.zilime.domain.User;

public interface UserDao {

	User getByUserCode(String usercode);

	void save(User u);
	
	
	
	
}
