
package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class OrderService {
    private IOrderDAO orderDAO = new OrderDAO();
    private List<MenuItem> menuList;
    
    
    
    public List<MenuItem> getMenuList() throws SQLException, Exception {
        menuList = orderDAO.getLatestMenuListing();
        return menuList;
    }
    
    public MenuItem getMenuItemByID(String id) throws SQLException, Exception {
        MenuItem item = new MenuItem();
        item = orderDAO.findMenuItemByID(id);
        return item;
        
    }
    
    public void deleteItem(String id) throws SQLException, Exception {
        MenuItem item = new MenuItem();
        item = orderDAO.findMenuItemByID(id);
        orderDAO.deleteMenuItem(item);
    }
    
    public void save(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception {
        orderDAO.save(item);
    }
    

    
    public static void main(String[] args) throws SQLException, Exception {
        OrderService os = new OrderService();
        List<MenuItem> listItems = new ArrayList<MenuItem>();     
        listItems = os.getMenuList();
//        for(MenuItem item : listItems) {
////            MenuItem item = (MenuItem)listItems.get(i);
//            System.out.println("ID: " + item.getID());
//            System.out.println("Item: " + item.getItem());
//            System.out.println("Price: " + item.getPrice());
//        }
        
//        MenuItem item = new MenuItem();
//        item = os.getMenuItemByID("1");
//        System.out.println(item.getID());
//        System.out.println(item.getItem());
//        System.out.println(item.getPrice());
        
        os.deleteItem("18");
        
//        MenuItem update = os.getMenuItemByID("15");
//        update.setItem("Good Drinks That are tasty");
//        update.setPrice(26.35);
//        os.save(update);
        
        
        
        
    }
    
}
