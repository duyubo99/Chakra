package com.asiainfo.service;

import com.asiainfo.domain.User;


public interface UserService{
	User toLogin(User user);

	void updatePassword(User user);
}
