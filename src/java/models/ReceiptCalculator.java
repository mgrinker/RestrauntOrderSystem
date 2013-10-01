
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ReceiptCalculator {
    private  double total = 0.0;
    private  double tax = 0.0;
    private double finalTot = 0.0;
    
    
   public double getTotal(List prices) {
       List price = new ArrayList(prices);
       for(int i = 0; i < price.size(); i++) {
           double dPrice = Double.valueOf((price.get(i)).toString());
           double subtotal = dPrice;
           total += subtotal;
       }
       return total;
   }
   
   public double getTax() {
       tax = total * .05;
       return tax;
   }
   
   public double getFinalTotal() {
       finalTot = total + tax;
       return finalTot;
   }
}



