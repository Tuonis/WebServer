<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
<form action="ServletSaisieDeCandidature" method="post">
    <h1>Saisie Candidature</h1>
    <p> <label> idPromotion : </label> <input type="text" name="idPromo"/> </p>
    <p> <label> idCandidat : </label> <input type="text" name="idCandidat"/> </p>
    <p> <label> Motivation : </label> <input type="text" name="motivation"/> </p>
    <input type="hidden" name="dateCandidature" value="<fmt:formatDate type='date' value='${now}'/>"> <br/>
    <input type="hidden" name="idEtat" value="7">
    <input type="hidden"  name="choix"  value="4">
    <input type="submit" name="inscrire" value="valider">
</form>
            