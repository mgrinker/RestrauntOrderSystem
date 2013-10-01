/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.MenuItem;
import models.MenuList;
import models.OrderService;

/**
 *
 * @author mgrinker
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {
    private  String Destination_page = "menuAdmin.jsp";
    OrderService os = new OrderService();
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
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
//        OrderService os = new OrderService();
        String action_id = request.getParameter("action");
        
        if(action_id.equals("listItems")) {
            List menuList = os.getMenuList();
            
            request.setAttribute("menuList", menuList);
        }
        else if(action_id.equals("edit_record")) {
            MenuItem record = new MenuItem();
            String id = request.getParameter("id");
            record = os.getMenuItemByID(id);
            Destination_page = "editRecord.jsp";
            request.setAttribute("record", record);
        }
        else if(action_id.equals("save_record")) {
            int id = Integer.valueOf(request.getParameter("id"));
            String newItem = request.getParameter("item");
            Double newPrice = Double.valueOf(request.getParameter("price"));
            MenuItem item = new MenuItem();
            item.setID(id);
            item.setItem(newItem);
            item.setPrice(newPrice);
            
            os.save(item);
            List menuList = os.getMenuList();
            request.setAttribute("menuList", menuList);
            Destination_page = "menuAdmin.jsp";
        }
        else if(action_id.equals("delete_record")) {
            String id = request.getParameter("id");            
            os.deleteItem(id);
            List menuList = os.getMenuList();
            request.setAttribute("menuList", menuList);
            Destination_page = "menuAdmin.jsp";
        }
        
        
        
        RequestDispatcher view =
                request.getRequestDispatcher(Destination_page);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
