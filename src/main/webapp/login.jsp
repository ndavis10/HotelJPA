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
            <form class="col s6" id="signInForm" role="form" method='POST' action="<c:url value='j_spring_security_check' />">
                <div>
                    <h3>Sign in </h3>
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
            <form class="col s6" id="registerForm" role="form" method="POST" action="Register">
                <div>
                    <h3>Register</h3>
                    <div class="input-field">
                        <label for="r_username">Email address</label>
                        <input tabindex="4" class="form-control" id="r_username" name="r_username" type="email" value="${user.username}" />
                    </div>
                    <div class="input-field">
                        <label for="r_password">Password</label>
                        <input tabindex="5" class="form-control" id="r_password" name="r_password" type="password" />
                    </div>
                    <div class="input-field">
                        <label for="r_confirm_password">Confirm Password</label>
                        <input tabindex="6" class="form-control" id="r_confirm_password" name="r_confirm_password" type="password" />
                    </div>
                    <button class="btn waves-effect waves-light" name="submit" type="submit">Register</button>
                </div>
            </form>
       </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="js/materialize.min.js" type="text/javascript"></script>
    </body>
</html>