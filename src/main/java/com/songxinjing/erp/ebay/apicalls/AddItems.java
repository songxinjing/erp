package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.AddItemsCall;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.AddItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class AddItems extends SDKTestCase{
	private String[] categories = new String[]{"50253","29792","279","279","14111"};
	public void testAddItems()throws Exception{
		if(TestData.itemIDs != null){
			this.endItems(TestData.itemIDs);
			TestData.itemIDs = null;
		}
		
		AddItemsCall api = new AddItemsCall(this.apiContext);
		AddItemRequestContainerType[] container = new AddItemRequestContainerType[categories.length];
		for(int i = 0;i < categories.length; i++){
			container[i] = new AddItemRequestContainerType();
			container[i].setMessageID(Integer.toString(i+1));
			ItemType item = AddItem.buildItem();
			item.getPrimaryCategory().setCategoryID(categories[i]);
			container[i].setItem(item);
		}
		api.setAddItemRequestContainer(container);
		api.addItems();
		
		String[] itemIDs = new String[api.getReturnedAddItemResponseContainer().length];
		
		for(int i = 0 ;i < api.getReturnedAddItemResponseContainer().length; i++){
			itemIDs[i] = api.getReturnedAddItemResponseContainer()[i].getItemID();
		}
		TestData.itemIDs = itemIDs;
	}
}
