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
		for(Map.Entry entry:itemCollection)
	}

	@Override
	public Boolean add(Item item) {
		return false;
	}
}
