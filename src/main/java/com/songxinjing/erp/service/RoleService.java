package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.RoleDao;
import com.songxinjing.erp.domain.Role;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 配置信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class RoleService extends BaseService<Role, String>{

	@Autowired
	public void setSuperDao(RoleDao roleDao) {
		super.setDao(roleDao);
	}

}
