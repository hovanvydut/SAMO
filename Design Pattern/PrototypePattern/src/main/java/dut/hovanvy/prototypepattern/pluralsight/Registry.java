/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.prototypepattern.pluralsight;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author hovanvydut
 */

public class Registry {
    
    private Map<String, Item> items = new HashMap<>();
    
    public Registry() {
        loadItems();
    }
    
    public Item createItem(String type) {
        Item item = null;
        
        try {
            item = (Item)this.items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            
        }
        
        return item;
    }
    
    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        this.items.put("Movie", movie);
        
        Book book = new Book();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("Basic Book");
        this.items.put("Book", book);
    }
}
