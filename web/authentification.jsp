<%-- 
    Document   : consulter
    Created on : 20 mai 2013, 15:30:42
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
    </head>
    <body>
        <form action="ServletListeCandidatureByCandidat" method="post">
            <h1>Authentification</h1>
            <p> <label> Email </label><input name="mail" type="text"> </p>
            <p> <label>Mot de passe</label><input name="pass" type="password" /> </p>
            <input type="hidden"  name="choix"  value="2">
            <input name="cal" type="submit" value="connect" />
        </form>
    </body>
</html>
