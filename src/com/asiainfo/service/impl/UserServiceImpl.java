package com.asiainfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.domain.other.User;
import com.asiainfo.hdao.BaseDao;
import com.asiainfo.service.UserService;

@Service("userService")
public class UserServiceImpl implements
	UserService {
	@Resource(name="userDao")
	private BaseDao<User> userDao ;
	
	@Override
	public User toLogin(User user) {
		User u = (User) userDao.uniqueResult("FROM User u where u.userName=? and u.password=?",
				user.getUserName(),user.getPassword());
		return u;
	}
}
