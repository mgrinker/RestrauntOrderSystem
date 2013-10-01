
package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IOrderDAO2 {

    List<MenuItem> getLatestMenuListing() throws SQLException, Exception;
    
}
