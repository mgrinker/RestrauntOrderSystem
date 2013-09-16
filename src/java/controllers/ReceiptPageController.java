package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.MenuItems;
import models.ReceiptCalculator;

/**
 *
 * @author Michael
 */
@WebServlet(name = "ReceiptPageController", urlPatterns = {"/ReceiptPageController"})
public class ReceiptPageController extends HttpServlet {
    private static final String DESTINATION_PAGE = "receipt.jsp";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        List items = new ArrayList();
        List prices = new ArrayList();
        
        String arraySize = request.getParameter("arraySize");
        int iArraySize = Integer.valueOf(arraySize);
        
        for(int i = 0; i < iArraySize; i++){
            String item = request.getParameter("item" + i);
            String price = request.getParameter("price" + i);
            
            if(item != null) {
                items.add(item);
                prices.add(price);
            }
        }
        
        ReceiptCalculator calc = new ReceiptCalculator();
        
        String sTotal = "";
        double total = calc.getTotal(prices);
        sTotal = "" + total;
        
        String sTax = "";
        double tax = calc.getTax();
        sTax = "" + tax;

                       
        String sFianlTotal = "";
        double finalTotal = calc.getFinalTotal();
        sFianlTotal = "" + finalTotal;
        
        
        
        
        
        request.setAttribute("items", items);
        request.setAttribute("prices", prices);
        request.setAttribute("total", sTotal);
        request.setAttribute("tax", sTax);
        request.setAttribute("finalTotal", sFianlTotal);
        
        
        
        
        
        
        
        RequestDispatcher view =
                request.getRequestDispatcher(DESTINATION_PAGE);
        view.forward(request, response);
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
