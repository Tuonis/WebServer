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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidat</title>
    </head>
    <body>
        <h1>Saisie candidat</h1>
        <form action="ServletSaisieCandidat" method="post">
            <x:forEach select="$dom/infosCandidature/infoCandidat" var="infos">
                Nom : <input type="text" name="nom" value="<x:out select="$infos/@nom"/>"/> <br/>
                Prénom : <input type="text" name="prenom" value="<x:out select="$infos/@prenom"/>"/> <br/>
                Téléphone : <input type="text" name="telephone" value="<x:out select="$infos/@telephone"/>"/> <br/>
                Email : <input type="text" name="mail" value="<x:out select="$infos/@mail"/>"/> <br/>
                Adresse : <input type="text" name="adresse" value="<x:out select="$infos/@adresse"/>"/> <br/>
                Diplomes : <input type="text" name="diplome" value="<x:out select="$infos/@diplomes"/>"/> <br/>
                Compétences : <input type="text" name="competence" value="<x:out select="$infos/@competences"/>"/> <br/>
                Situation professionnelle : <input type="text" name="situationPro" value="<x:out select="$infos/@situation"/>"/> <br/>
                <input type="hidden" name="id" value="<x:out select="$infos/@id"/>"/>
            </x:forEach>
            <input type="hidden"  name="choix"  value="4">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
