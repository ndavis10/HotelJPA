<%-- 
    Document   : confirm
    Created on : Feb 11, 2015, 7:42:37 PM
    Author     : viewt_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%= request.getContextPath() %>/css/materialize.min.css" rel="stylesheet" type="text/css"/>
        <title>Confirm Deletion</title>
    </head>
    <body>
        <div class="container">
            <h1>Delete?</h1>
            <p>Do you <em>really</em> want to delete the following hotel?</p>
            <dl>
                <dt>Name:</dt>
                <dd>${hotel.hotelName}
                <dt>Address:</dt>
                <dd>${hotel.streetAddress}
                <dt>City:</dt>
                <dd>${hotel.city}
                <dt>State:</dt>
                <dd>${hotel.stateName}
                <dt>Postal Code:</dt>
                <dd>${hotel.postalCode}
                <dt>Notes:</dt>
                <dd>${hotel.notes}
            </dl>
            <p>This action cannot be undone!</p>
            <form action="Delete" method="POST">
                <input type="hidden" value="${hotel.hotelId}" name="id" id="id">
                <button type="submit" class="btn waves-effect waves-light">
                    Submit<i class="mdi-content-send right"></i>
                </button>
            </form>
        </div>
            
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="<%= request.getContextPath() %>/js/materialize.min.js" type="text/javascript"></script>
    </body>
</html>
