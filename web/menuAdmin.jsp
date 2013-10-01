<%-- 
    Document   : menuAdmin
    Created on : Sep 25, 2013, 9:42:20 PM
    Author     : mgrinker
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="models.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Page</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Edit Item</th>
                <th>Delete Item</th>
            </tr>
            <%
                NumberFormat dollar = NumberFormat.getCurrencyInstance();
                List<MenuItem> items = (List<MenuItem>)request.getAttribute("menuList");
                for(MenuItem item : items) {
            %>
            <tr>
                <td><%= item.getID() %></td>
                <td><%= item.getItem() %></td>
                <td><%= dollar.format(item.getPrice())%></td>
                <td><a href="AdminController?action=edit_record&id=<%= item.getID()%>">Edit Record</a></td>
                <td><a href="AdminController?action=delete_record&id=<%= item.getID()%>">Delete Record</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <form method="POST" action="newRecord.jsp">
            <input type="submit" value="New Record" name="newRecord"/>
        </form>
        </body>
</html>