package cn.zilime.service;

import cn.zilime.domain.User;

public interface UserService {
	
User getUserByCodePassword(User u);
void saveUser(User u);
}
