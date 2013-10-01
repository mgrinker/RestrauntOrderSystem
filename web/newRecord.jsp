<%-- 
    Document   : newRecord
    Created on : Sep 30, 2013, 6:40:55 PM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Record</title>
    </head>
    <body>
        <h1>New Record</h1>
        <form method="POST" action="AdminController?action=save_record">
        <table>
            <tr>
                <td>Item:</td>
                <td><input type="hidden" name ="id" value="0"/>
                    <input type="text" name="item" value=""/> </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value=""/> </td>
            </tr>
        </table>
            <input type="submit" value="Save Record" name="save"/>
        </form>
    </body>
</html>
