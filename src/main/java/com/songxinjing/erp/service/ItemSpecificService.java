package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.ItemSpecificDao;
import com.songxinjing.erp.domain.ItemSpecific;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class ItemSpecificService extends BaseService<ItemSpecific, Integer> {

	@Autowired
	public void setSuperDao(ItemSpecificDao itemDao) {
		super.setDao(itemDao);
	}

}
