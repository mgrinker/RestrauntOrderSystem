<%-- 
    Document   : editRecord
    Created on : Sep 30, 2013, 3:41:37 PM
    Author     : Michael
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="models.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Page</h1>
        <%
            NumberFormat dollar = NumberFormat.getCurrencyInstance();
            MenuItem record = (MenuItem)request.getAttribute("record");
            //String id = request.getAttribute("record").toString();
         
        
        
        
        %>
        <form method="POST" action="AdminController?action=save_record">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id" value="<%= record.getID() %>"</td>
            </tr>
            <tr>
                <td>Item:</td>
                <td><input type="text" name="item" value="<%= record.getItem()%>"</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="<%= record.getPrice()%>"</td>
            </tr>
        </table>
            <input type="submit" value="Save Record" name="save"/>
        </form>
    </body>
</html>
