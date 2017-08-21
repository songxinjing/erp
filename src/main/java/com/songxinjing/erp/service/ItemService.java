package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.ItemDao;
import com.songxinjing.erp.domain.Item;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class ItemService extends BaseService<Item, Integer> {

	@Autowired
	public void setSuperDao(ItemDao itemDao) {
		super.setDao(itemDao);
	}

}
