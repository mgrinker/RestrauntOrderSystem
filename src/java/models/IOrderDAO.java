/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IOrderDAO {

    void deleteMenuItem(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;

    MenuItem findMenuItemByID(String id) throws SQLException, Exception;

    List<MenuItem> getLatestMenuListing() throws SQLException, Exception;

    void save(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;
    
}
