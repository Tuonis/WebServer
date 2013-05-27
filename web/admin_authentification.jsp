<%-- 
    Document   : index
    Created on : 9 avr. 2013, 09:34:04
    Author     : Chanthavone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Page d'authentification</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form name="useraccess" action="ServletAdminAuthentification" method="POST">
            <h1>Authentification administrateur</h1>
            <p> <label> Mail </label> <input type="text" name="mail" value="" size="10" /> </p>
            <p> <label> Mot de passe </label> <input type="password" name="password" value="" size="10" /></p>
            <input type="submit" value="Se connecter" name="connect" />
        </form>
    </body>
</html>
