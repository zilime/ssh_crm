package cn.zilime.test;

import javax.annotation.Resource;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import cn.zilime.dao.UserDao;
import cn.zilime.domain.User;
import cn.zilime.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Resource(name="userDao")
	private UserDao ud;
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun1(){
		User u = new User();
		u.setUser_name("fuck");
		u.setUser_code("FUCK");
		u.setUser_password("114514");
		
		us.saveUser(u);
	}
}
