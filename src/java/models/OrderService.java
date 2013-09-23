
package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class OrderService {
    private IOrderDAO orderDAO;
    private List<MenuItem> menuList;
    
    
    
    public List<MenuItem> getMenuList() throws SQLException, Exception {
        orderDAO = new OrderDAO();
        menuList = orderDAO.getLatestMenuListing();
        return menuList;
    }
    
    public static void main(String[] args) throws SQLException, Exception {
        OrderService os = new OrderService();
        List<MenuItem> listItems = new ArrayList<MenuItem>();     
        listItems = os.getMenuList();
        for(int i = 0; i < listItems.size(); i++) {
            MenuItem item = (MenuItem)listItems.get(i);
            System.out.println("Item: " + item.getItem());
            System.out.println("Price: " + item.getPrice());
        }
    }
    
}
