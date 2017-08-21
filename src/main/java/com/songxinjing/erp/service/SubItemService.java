package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.SubItemDao;
import com.songxinjing.erp.domain.SubItem;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class SubItemService extends BaseService<SubItem, Integer> {

	@Autowired
	public void setSuperDao(SubItemDao itemDao) {
		super.setDao(itemDao);
	}

}
