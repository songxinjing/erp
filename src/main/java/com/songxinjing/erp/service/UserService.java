package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.UserDao;
import com.songxinjing.erp.domain.User;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 配置信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class UserService extends BaseService<User, String>{

	@Autowired
	public void setSuperDao(UserDao userDao) {
		super.setDao(userDao);
	}

}
