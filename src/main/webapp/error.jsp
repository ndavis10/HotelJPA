<%-- 
    Document   : error
    Created on : Jan 26, 2015, 8:59:58 PM
    Author     : viewt_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% final String ERROR_MSG = "Unable to retrive message!"; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href=css/materialize.min.css" rel="stylesheet" type="text/css"/>
        <title>Error!</title>
    </head>
    <body>
        <h1>Error!</h1>
        <p>There appears to have been an error, the message provided with that error is:</p>
        <% Object msg = request.getAttribute("msg");
           String printMsg = msg == null ? ERROR_MSG : msg.toString(); %>
           <p><% out.println(printMsg); %></p>
    </body>
</html>
