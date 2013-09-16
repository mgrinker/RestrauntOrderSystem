
package models;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class MenuList {
    
    public List<MenuItems> getMenuList() {
        
        ArrayList<MenuItems> menuList = new ArrayList<MenuItems>();

        menuList.add(new MenuItems("Taco",5.00));
        menuList.add(new MenuItems("Buritto",3.0));
        menuList.add(new MenuItems("Enchilada",3.0));
        menuList.add(new MenuItems("Soda",1.0));
        menuList.add(new MenuItems("Chimichanga",6.99));
        menuList.add(new MenuItems("Chile Con Queso",4.50));
        menuList.add(new MenuItems("Beer",4.95));     
        return menuList;
    }
    
    public static void main(String[] args) {
        MenuList ml = new MenuList();
        List list = ml.getMenuList();
        
        int size = list.size();
        System.out.println(size);
        for(int i = 0; i < list.size(); i++){
            MenuItems item = (MenuItems)list.get(i);
            System.out.println(item.getItem());
            System.out.println(item.getPrice());;
                        
        }
        
        
    }
    
}
