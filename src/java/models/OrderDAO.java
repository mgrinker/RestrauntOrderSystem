
package models;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Michael
 */
public class OrderDAO implements IOrderDAO {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant";
    private static final String USER = "root";
    private static final String PWD = "admin";
    
    private DBAccessor db;

    public OrderDAO() {
        db = new DB_Generic();
    }
    
    @Override
            public List<MenuItem> getLatestMenuListing() throws SQLException,Exception {
        List<MenuItem> items = new ArrayList<MenuItem>();
        
        db.openConnection(OrderDAO.DRIVER, OrderDAO.URL, OrderDAO.USER, 
                OrderDAO.PWD);
        
        String sql = "select * from menu_item";
        
        List<Map> rawData = db.findRecords(sql, true);
        
        
            for(Map record : rawData) {
                
                MenuItem item = new MenuItem();
                String itemName = String.valueOf(record.get("item_name"));
                item.setItem(itemName);
                
                Double itemPrice = Double.valueOf((record.get("item_price")).toString());
                item.setPrice(itemPrice);

                
                items.add(item);
            }

        return items; 
    }
    
    
    public static void main(String[] args) throws Exception {
        
        OrderDAO dao = new OrderDAO();
        List<MenuItem> listItems = new ArrayList<MenuItem>();     
        listItems = dao.getLatestMenuListing();
        
        for(int i = 0; i < listItems.size(); i++) {
            MenuItem item = (MenuItem)listItems.get(i);
            System.out.println("Item: " + item.getItem());
            System.out.println("Price: " + item.getPrice());
        }
    }
}
