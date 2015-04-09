<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Jim Lombardo">

        <title>Spring Security Login Page</title>
        <link rel="stylesheet" href="css/materialize.min.css" /> 
    </head>

    <body>
       <div class="container">
            <form id="signInForm" role="form" method='POST' action="<c:url value='j_spring_security_check' />">
                <div class="col s6">
                    <h3 style="font-weight: 200;">Sign in </h3>
                    <div class="input-field">
                        <label for="j_username">Email address</label>
                        <input tabindex="1" class="form-control" id="j_username" name="j_username" type="text" autofocus />
                    </div>
                    <div class="input-field">
                        <label for="j_password">Password</label>
                        <input tabindex="2" class="form-control" id="j_password" name="j_password" type="password" />
                    </div>
                    <button class="btn waves-effect waves-light" name="submit" type="submit">Sign in</button>
                </div>
            </form>
       </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="js/materialize.min.js" type="text/javascript"></script>
    </body>
</html>