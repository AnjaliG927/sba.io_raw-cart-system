package com.github.perscholas;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TheSystem {
    private HashMap<String, Item> itemCollection;

    TheSystem() {
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {
            itemCollection = fileItems();
        }

    }

    public HashMap<String, Item> fileItems() {
        HashMap<String, Item> itemMap = new HashMap<>();
        Path filepath = Paths.get("resources/sample.txt");
        try {
            Stream<String> lines = Files.lines(filepath);
            List<String[]> lineList = lines
                    .map(str -> str.split(" "))
                    .collect(Collectors.toList());

            for (String[] temp : lineList) {
                Item item = new Item();
                item.setItemName(temp[0]);
                item.setItemDesc(temp[1]);
                item.setItemPrice(Double.valueOf(temp[2]));
                item.setAvailableQuantity(Integer.valueOf(temp[3]));
                itemMap.put(temp[0], item);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemMap;
    }

    public Boolean checkAvailability(Item item) {
        if (itemCollection.containsKey(item.getItemName())) {
        if (!(item.getQuantity() >= item.getAvailableQuantity())) {
                return true;
            } else
                System.out.println("System is unable to add [" + item.getItemName()
                        + "] to the card. System only has [" + item.getAvailableQuantity() + "] ["
                        + item.getItemName() + "]");
        }
        return false;
    }

    public Boolean add(Item item) {
        if(item==null){
            return false;
        }else {
            if (itemCollection.containsKey(item.getItemName()) && item.getAvailableQuantity() >= 1) {
                item.setAvailableQuantity(item.getAvailableQuantity() + 1);
            } else {
                itemCollection.put(item.getItemName(), item);
            }
            return true;
        }
    }

    public Item remove(String itemName) {
       if(itemCollection.containsKey(itemName)){
           Item item=itemCollection.get(itemName);
           itemCollection.remove(itemName);
           return item;
       }
        return null;
    }

    public abstract void display();

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }
}
