<%-- 
    Document   : mdpenvoi
    Created on : 20 mai 2013, 16:11:47
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Candidatures</title>
    </head>
    <body>
        <div>
            <h1>Oubli de mot de passe</h1>
            <% out.println(request.getAttribute("dom"));%>
                <x:forEach select="$dom/candidat/mdp" var="mdp">
                  <h2>Votre mot de passe est: <x:out select="$mdp/text()"/></h2>
                </x:forEach>
        </div>

    </body>
</html>
