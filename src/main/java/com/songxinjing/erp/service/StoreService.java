package com.songxinjing.erp.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songxinjing.erp.dao.StoreDao;
import com.songxinjing.erp.domain.Store;
import com.songxinjing.erp.service.base.BaseService;

/**
 * 店铺信息服务类
 * 
 * @author songxinjing
 * 
 */
@Service
public class StoreService extends BaseService<Store, Integer> {

	@Autowired
	public void setSuperDao(StoreDao storeDao) {
		super.setDao(storeDao);
	}

	public Integer saveStore(int platform, String storeName, String authUserId, String storeToken, String tokenExp) {

		Store store = new Store();
		store.setStoreName(storeName);
		store.setPlatform(platform);
		store.setAuthUserId(authUserId);
		store.setStoreToken(storeToken);
		store.setTokenExp(new Timestamp(System.currentTimeMillis()));
		return (Integer) this.save(store);

	}

	public boolean isExist(int platform, String authUserId) {
		Store store = new Store();
		store.setPlatform(platform);
		store.setAuthUserId(authUserId);
		if (this.find(store).size() == 0) {
			return false;
		}
		return true;
	}

}
