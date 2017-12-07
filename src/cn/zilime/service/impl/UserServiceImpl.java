package cn.zilime.service.impl;

import javax.management.RuntimeErrorException;

import cn.zilime.dao.UserDao;
import cn.zilime.domain.User;
import cn.zilime.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) 
	{
		User existU = ud.getByUserCode(u.getUser_code());
		if (existU==null){
			throw new RuntimeException("用户不存在");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误");
		}	
		return null;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
		
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
