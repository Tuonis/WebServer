<%-- 
    Document   : saisieCandidature
    Created on : 25 mai 2013, 23:50:28
    Author     : Chanthavone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidature</title>
    </head>
    <body>
        <c:set var="now" value="<%=new java.util.Date()%>" />
        <form action="ServletSaisieDeCandidature" method="post">
            <h1>Saisie Candidature</h1>
            <p> <label> idPromotion : </label> <input type="text" name="idPromo"/> </p>
            <p> <label> idCandidat : </label> <input type="text" name="idCandidat"/> </p>
            <p> <label> Motivation : </label> <input type="text" name="motivation"/> </p>
            <input type="hidden" name="dateCandidature" value="<fmt:formatDate type="date" value="${now}" />"/> <br/>
            <input type="hidden" name="idEtat" value="7"/>
            <input type="hidden"  name="choix"  value="4">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
