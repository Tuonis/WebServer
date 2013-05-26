<%-- 
    Document   : mdp
    Created on : 20 mai 2013, 16:02:15
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mot de passe oublié</title>
    </head>
    <body>
        <form action="ServletRenvoiMdp" method="post">
            <h1>Mot de passe oublié</h1>
            <p> <label> Email </label><input name="mail" type="text"> </p>
            <input type="hidden"  name="choix"  value="1">
            <input name="cal" type="submit" value="Envoyer" />
        </form>
    </body>
</html>
