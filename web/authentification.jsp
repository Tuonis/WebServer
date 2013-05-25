<%-- 
    Document   : consulter
    Created on : 20 mai 2013, 15:30:42
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
            <form action="ServletListeCandidatureByCandidat" method="post">
                <label>Email </label><input name="mail" type="text">
                <label>Mot de passe</label><input name="pass" type="password" /> <br/><br/>
                <input type="hidden"  name="choix"  value="2">
                <div class="block" id="pale-blue">
                    <input name="cal" type="submit" value="connect" />
                </div>
            </form>
        </div>

    </body>
</html>
