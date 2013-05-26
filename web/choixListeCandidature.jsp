<%-- 
    Document   : choixCandidature
    Created on : 24 mai 2013, 21:17:49
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulter les candidatures</title>
    </head>
    <body>
        <form action="ServletlisteCandidatureByPromoEtat" method="post">
            <h1>Consulter les candidatures</h1>
            <p> <label> Promotion </label><input name="promo" type="text"> </p>
            <p> <label> Etat </label><input name="etat" type="text" /> </p>
            <input type="hidden"  name="choix"  value="3">
            <input name="cal" type="submit" value="Afficher" />
        </form>
    </body>
</html>
