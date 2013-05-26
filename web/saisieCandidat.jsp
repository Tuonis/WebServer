<%-- 
    Document   : saisieCandidature
    Created on : 24 mai 2013, 13:16:34
    Author     : Chanthavone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidat</title>
    </head>
    <body>
        <form action="ServletSaisieCandidat" method="post">
            <h1>Saisie candidat</h1>
            <x:forEach select="$dom/infosCandidature/infoCandidat" var="infos">
                <p> <label> Nom : </label> <input type="text" name="nom" value="<x:out select="$infos/@nom"/>"/> </p>
                <p> <label> Prénom : </label> <input type="text" name="prenom" value="<x:out select="$infos/@prenom"/>"/> </p>
                <p> <label> Téléphone : </label> <input type="text" name="telephone" value="<x:out select="$infos/@telephone"/>"/> </p>
                <p> <label> Email : </label> <input type="text" name="mail" value="<x:out select="$infos/@mail"/>"/> </p>
                <p> <label> Adresse : </label> <input type="text" name="adresse" value="<x:out select="$infos/@adresse"/>"/> </p>
                <p> <label> Diplomes : </label> <input type="text" name="diplome" value="<x:out select="$infos/@diplomes"/>"/> </p>
                <p> <label> Compétences : </label> <input type="text" name="competence" value="<x:out select="$infos/@competences"/>"/> </p>
                <p> <label> Situation professionnelle : </label> <input type="text" name="situationPro" value="<x:out select="$infos/@situation"/>"/> </p>
                <input type="hidden" name="id" value="<x:out select="$infos/@id"/>"/>
            </x:forEach>
            <input type="hidden"  name="choix"  value="4">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
