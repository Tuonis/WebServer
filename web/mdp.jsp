<%-- 
    Document   : mdp
    Created on : 20 mai 2013, 16:02:15
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mot de passe oublié</title>
    </head>
    <body>
        <h1>Mot de passe oublié</h1>
        <div class="formu">
            <h2>Authentification</h2>
            <form action="TestServlet" method="post">
                <label>Email </label><input name="mail" type="text">
                <input type="hidden"  name="choix"  value="1">
                <div class="block" id="pale-blue">
                    <input name="cal" type="submit" value="connect" />
                </div>
            </form>
        </div>

    </body>
</html>
