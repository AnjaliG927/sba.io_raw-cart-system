package com.github.perscholas;


import java.util.HashMap;
import java.util.Map;

public class AppSystem extends TheSystem {
	private HashMap<String, Item> itemCollection;
	AppSystem() {
		super();
		itemCollection=super.fileItems();
	}

	@Override
	public void display() {
		for(Map.Entry entry:itemCollection.entrySet()){
			String itemName= (String) entry.getKey();
			Item item= (Item) entry.getValue();
			System.out.println("item name:"+itemName);
			System.out.println("item description:"+item.getItemDesc());
			System.out.println("item price:"+item.getItemPrice());
			System.out.println("item availability:"+item.getAvailableQuantity());
		}
	}

	@Override
	public Boolean add(Item item) {
		if(item==null){
			return false;
		}
			if(itemCollection.containsKey(item.getItemName())){
				System.out.println("item name:"+item.getItemName()+" is already in the App System");
				return false;
			}else {
				itemCollection.put(item.getItemName(), item);
				return true;
			}

	}
}
