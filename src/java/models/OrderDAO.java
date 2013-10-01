
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
public class OrderDAO implements IOrderDAO2, IOrderDAO {
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
                int id = Integer.valueOf(record.get("item_id").toString());
                item.setID(id);
                
                String itemName = String.valueOf(record.get("item_name"));
                item.setItem(itemName);
                
                Double itemPrice = Double.valueOf((record.get("item_price")).toString());
                item.setPrice(itemPrice);

                
                items.add(item);
            }

        return items; 
    }
    
    @Override
    public MenuItem findMenuItemByID(String id) throws SQLException, Exception {
        db.openConnection(OrderDAO.DRIVER, OrderDAO.URL, OrderDAO.USER, 
                OrderDAO.PWD);
        
        Map rec;
        
        rec = db.getRecordByID("menu_item", "item_id", new Integer(id), true);
        
        MenuItem item = new MenuItem();
        item.setID(new Integer(rec.get("item_id").toString()));
        item.setItem(rec.get("item_name").toString());
        item.setPrice(Double.valueOf(rec.get("item_price").toString()));
                   
        return item;
    }
    
    @Override
    public void deleteMenuItem(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception {
        db.openConnection(OrderDAO.DRIVER, OrderDAO.URL, OrderDAO.USER, 
                OrderDAO.PWD);
        
        db.deleteRecords("menu_item", "item_id", item.getID(), true);
    }
    
    @Override
    public void save(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception {
        db.openConnection(OrderDAO.DRIVER, OrderDAO.URL, OrderDAO.USER, 
                OrderDAO.PWD);
        
        String tableName = "menu_item";
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("item_name");
        fieldNames.add("item_price");
        
        List fieldValues = new ArrayList();
        fieldValues.add(item.getItem());
        fieldValues.add(item.getPrice());
        
        if (item.getID() == 0) {
            db.insertRecord(
                        tableName, fieldNames,
                        fieldValues, true);
        }
        else {
            db.updateRecords(
                        tableName, fieldNames,
                        fieldValues, "item_id", item.getID(), true);
        }
        
    }
    
    
    public static void main(String[] args) throws Exception {
        
        OrderDAO dao = new OrderDAO();
        List<MenuItem> listItems = new ArrayList<MenuItem>();     
        listItems = dao.getLatestMenuListing();
        
        //Loop through and list items
        for(MenuItem item : listItems) {
//            MenuItem item = (MenuItem)listItems.get(i);
            System.out.println("ID: " + item.getID());
            System.out.println("Item: " + item.getItem());
            System.out.println("Price: " + item.getPrice());
            System.out.println("");
        }
        
        // Get item by ID
//        MenuItem item = dao.findMenuItemByID("12");
//        
//        System.out.println("Item Found:");
//        System.out.println(item.getID());
//        System.out.println(item.getItem());
//        System.out.println(item.getPrice());
        
        // Delete item
//        MenuItem deleteItem = dao.findMenuItemByID("15");
//        dao.deleteMenuItem(deleteItem);
        
        // Save a new item
//        MenuItem item = new MenuItem("Wine",6.95);
//        dao.save(item);
        
        // Update existing item
//        String itemId = "12";
//        MenuItem updateItem = dao.findMenuItemByID(itemId);
//        if (updateItem != null) {
//            updateItem.setPrice(5.95);
//            dao.save(updateItem);
//        }
//        else {
//            System.out.println("Could not find item " + itemId);        }
        
    }
    
    
}
