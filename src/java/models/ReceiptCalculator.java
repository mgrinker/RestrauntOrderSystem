
package models;

import java.text.DecimalFormat;
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
    
DecimalFormat dollar = new DecimalFormat("#.00");
    
   public double getTotal(List prices) {
       List price = new ArrayList(prices);
       for(int i = 0; i < price.size(); i++) {
           double dPrice = Double.valueOf((price.get(i)).toString());
           double subtotal = dPrice;
           total += subtotal;
           total = Math.round(total * 100.0) / 100.0;
       }
       return total;
   }
   
   public double getTax() {
       tax = total * .05;
       tax = Math.round(tax * 100.0) / 100.0;
       
       return tax;
   }
   
   public double getFinalTotal() {
       finalTot = total + tax;
       finalTot = Math.round(finalTot * 100.0) / 100.0;
       return finalTot;
   }
}



