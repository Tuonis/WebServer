<%-- 
    Document   : choixCandidature
    Created on : 24 mai 2013, 21:17:49
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
    </head>
    <body>
        <h1>Consulter les candidatures</h1>
        <div class="formu">
            <h2>Authentification</h2>
            <form action="ServletlisteCandidatureByPromoEtat" method="post">
                <label>Promotion </label><input name="promo" type="text">
                <label>Etat</label><input name="etat" type="text" /> <br/><br/>
                <input type="hidden"  name="choix"  value="3">
                <div class="block" id="pale-blue">
                    <input name="cal" type="submit" value="connect" />
                </div>
            </form>
        </div>

    </body>
</html>
