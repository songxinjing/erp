package com.songxinjing.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.ItemPictureDao;
import com.songxinjing.erp.domain.ItemPicture;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class ItemPictureService extends BaseService<ItemPicture, Integer> {

	@Autowired
	public void setSuperDao(ItemPictureDao itemDao) {
		super.setDao(itemDao);
	}

}
