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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidature</title>
    </head>
    <body>
        <h1>Saisie Candidature</h1>
        <c:set var="now" value="<%=new java.util.Date()%>" />
        <form action="ServletSaisieDeCandidature" method="post">
                idPromotion : <input type="text" name="idPromo"/> <br/>
                idCandidat : <input type="text" name="idCandidat"/> <br/>
                Motivation : <input type="text" name="motivation"/> <br/>
                <input type="hidden" name="dateCandidature" value="<fmt:formatDate type="date" value="${now}" />"/> <br/>
                <input type="hidden" name="idEtat" value="7"/>
            <input type="hidden"  name="choix"  value="4">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
