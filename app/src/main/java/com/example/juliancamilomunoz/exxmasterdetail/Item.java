package com.example.juliancamilomunoz.exxmasterdetail;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Xingke on 25/05/2015.
 */

public class Item implements Serializable{
    private static final long serialVersionUID = -1213949467658913456L;
    private String title;
    private String body;

    public Item(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Item 1", "This is the first item"));
        items.add(new Item("Item 2", "This is the second item"));
        items.add(new Item("Item 3", "This is the third item"));
        return items;
    }
}
