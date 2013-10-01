package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgrinker
 */
public class MenuItem {
    
    private int ID;
    private String item = "";
    private double price = 0.0;
    
    public MenuItem() {
    }

    public MenuItem(int ID, String item, double price) {
        this.ID = ID;
        this.item = item;
        this.price = price;
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

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
}