package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgrinker
 */
public class MenuItem {
    
    private String item = "";
    private double price = 0.0;

    public MenuItem() {
    }

    public MenuItem(String item, double price) {
        this.item = item;
        this.price = price;
    }
    
    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}