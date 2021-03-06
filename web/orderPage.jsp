<%-- 
    Document   : orderPage
    Created on : Sep 11, 2013, 9:26:31 PM
    Author     : mgrinker
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="models.MenuItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <title>Order Page</title>
    </head>
    <body>
        <div id="content">
        <h1>Place your order here</h1>
        <hr/>
        <form name ="orderForm" method="POST" action="ReceiptPageController">
           
            <table>

        <%
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            List menuList = (List)request.getAttribute("menuList");
            int arraySize = menuList.size();
            for(int i = 0; i < menuList.size(); i++){
            MenuItem item = (MenuItem)menuList.get(i);
        %>

                <tr>
                    <td><input type="checkbox" name="item<%= i %>" value="<%= item.getItem() %>"><%= item.getItem() %></td>
                    <td><%= nf.format(item.getPrice()) %></td>
                    <td><input type="hidden" name="price<%= i %>" value="<%= item.getPrice()%>"/></td>
                </tr>
        <%
            }
        %>
                <tr>
                    <td><input type="submit" name ="orderSubmit" value="Submit Order"/></td>
                </tr>
            </table>
               <input type="hidden" name="arraySize" value ="<%= arraySize%>"/> 
        </form>
        </div>
    </body>
</html>
