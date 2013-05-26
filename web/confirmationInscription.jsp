<%-- 
    Document   : confirmationInscription
    Created on : 26 mai 2013, 20:17:47
    Author     : Tuonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletRenvoiMdp" method="post">
            <h1>Saissez votre mot de passe pour confirmer votre inscription</h1>
            <p> <label>Mot de passe</label><input name="mdp" type="text"> </p>
            
            <input name="cal" type="submit" value="Envoyer" />
        </form>
    </body>
</html>
