<%-- 
    Document   : edit
    Created on : Feb 11, 2015, 7:17:06 PM
    Author     : viewt_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%= request.getContextPath() %>/css/materialize.min.css" rel="stylesheet" type="text/css"/>
        <title>Edit Hotel</title>
    </head>
    <body>
        <div class="container">
        <h1>Edit Hotel</h1>
            <form action="Edit" method="POST">
                <div class="row">
                    <input id="id" name="id" type="hidden" value="${hotel.hotelId}">
                    <div class="input-field col s6">
                        <label for="name">Hotel Name</label>
                        <input id="name" name="name" type="text" value="${hotel.hotelName}">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4">
                        <label for="address">Address</label>
                        <input id="address" name="address" type="text" value="${hotel.streetAddress}">
                    </div>
                    <div class="input-field col s4">
                        <label for="city">City</label>
                        <input id="city" name="city" type="text" value="${hotel.city}">
                    </div>
                    <div class="input-field col s4">
                        <label for="state">State</label>
                        <input id="state" name="state" type="text" value="${hotel.stateName}">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4">
                        <label for="postalCode">Postal Code</label>
                        <input id="postalCode" name="postalCode" type="text" value="${hotel.postalCode}">
                    </div>
                    <div class="input-field col s4">
                        <label for="notes">Notes</label>
                        <input id="notes" name="notes" type="text" value="${hotel.notes}">
                    </div>
                    <div class="col s4">
                        <button type="submit" class="btn waves-effect waves-light">
                            Submit<i class="mdi-content-send right"></i>
                        </button>
                    </div>
            </form>
        </div>
                
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="<%= request.getContextPath() %>/js/materialize.min.js" type="text/javascript"></script>
    </body>
</html>
