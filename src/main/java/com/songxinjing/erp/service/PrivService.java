package com.songxinjing.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.PrivDao;
import com.songxinjing.erp.domain.Privilege;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 配置信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class PrivService extends BaseService<Privilege, String>{

	@Autowired
	public void setSuperDao(PrivDao privDao) {
		super.setDao(privDao);
	}
	
	/**
	 * 获取已经激活的权限列表
	 */
	public List<Privilege> findEnable() {
		Privilege temp = new Privilege();
		temp.setEnable(true);
		return this.find(temp);
	}

}
