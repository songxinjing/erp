package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.ItemSpecificValueDao;
import com.songxinjing.erp.domain.ItemSpecificValue;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class ItemSpecificValueService extends BaseService<ItemSpecificValue, Integer> {

	@Autowired
	public void setSuperDao(ItemSpecificValueDao itemDao) {
		super.setDao(itemDao);
	}

}
