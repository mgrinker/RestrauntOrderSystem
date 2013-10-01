
<%@page import="java.text.NumberFormat"%>
<%@page import="models.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <title>Receipt</title>
    </head>
    <body>
        <div id="content">
        <h1>Receipt</h1>
        <hr/>
        <table>
        
        
       <% 
           NumberFormat nf = NumberFormat.getCurrencyInstance();
           
           String fianlTot = "No Final Total available";
                Object finTotalObj = request.getAttribute("finalTotal");
                if(finTotalObj != null) {
                    fianlTot = finTotalObj.toString();
                }
           String tot = "No Total available";
                Object totalObj = request.getAttribute("total");
                if(totalObj != null) {
                    tot = totalObj.toString();
                }
            String tax = "No Tax available";
            Object taxObj = request.getAttribute("tax");
                if(taxObj != null) {
                    tax = taxObj.toString();
                }
           List items = (List)request.getAttribute("items");
           List prices = (List)request.getAttribute("prices");
           int arraySize = items.size();
           for(int i = 0; i < items.size(); i++){
           
        %>


            <tr>
                <td><%= items.get(i) %></td>
                <td>$<%= prices.get(i).toString() %></td>

            </tr>
        <%
            }
        %>
        <tr>
            <td colspan="2"><hr/></td>
        </tr>
        <tr>
            <td style="text-align: right">Sub-Total: </td>
            <td><%= tot %></td>
        </tr>
        
        <tr>
            <td style="text-align: right">Tax: </td>
            <td><%= tax %></td>
        </tr>
        
        <tr>
            <td style="text-align: right">Total: </td>
            <td><%= fianlTot %></td>
        </tr>
        </table>
        <br/>

        <a href="index.jsp" style="font-size: 20px">Home</a>
        </div>
    </body>
</html>
