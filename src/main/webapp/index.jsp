<%-- 
    Document   : index
    Created on : Apr 1, 2015, 8:06:32 PM
    Author     : viewt_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotels Project</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <!-- put in a header here to use everywhere -->
            <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
                Logged in as: <sec:authentication property="principal.username"></sec:authentication> ::
                <a href='<%= this.getServletContext().getContextPath() + "/j_spring_security_logout"%>'>Log Me Out</a>
            </sec:authorize>
        </div>
        <div class="container flow-text">
            <h1>Find some hotels!</h1>
            <p>Welcome to the Hotel project! Something about hotels or something!</p>
            
            <form action="Wizard" method="POST">
                <select name="wizard" id="wizard">
                    <option value="" selected="selected">Choose an option</option>
                    <option value="0">Find all hotels</option>
                    <option value="1">Find by state</option>
                    <option value="2">Find by city</option>
                </select>
                <div class="input-field">
                    <input class="stateInput" type="text" name="state" id="state" hidden="hidden">
                    <label class="stateInput" hidden="hidden" for="state">State</label>
                </div>
                <div class="input-field">
                    <input class="cityInput" type="text" name="city" id="city" hidden="hidden">
                    <label class="cityInput" hidden="hidden" for="city">City</label>
                </div>
                <button type="submit" class="btn waves-effect waves-light">Go!</button>
            </form>
        </div>
        
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
    </body>
</html>
