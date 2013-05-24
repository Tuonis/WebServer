

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Candidatures</title>
    </head>
    <body>
        <h1>Candidatures</h1>
        <table border=2>
            <th>Nom promotion</th>
            <th>Date candidature</th>
            <th>Etat</th>

            <x:forEach select="$dom/infosCandidature/infoCandidature" var="infos">
                <tr>
                    <td><x:out select="$infos/@nomPromotion"/></td>
                    <td><x:out select="$infos/@dateCandidature"/></td>
                    <td><x:out select="$infos/@etat"/></td>       
                </tr>
            </x:forEach>
        </table>

        <br/>
        <br/>

        <table border=2>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Telephone</th>
            <th>Adresse</th>
            <th>Mail</th>

            <tr> 
                <td>${nom}</td>
                <td> ${prenom}</td>
                <td> ${telephone}</td>
                <td>${adresse}</td>
                <td> ${mail}</td>
            </tr>
            <%-- <x:forEach select="$dom/infosCandidature/infoCandidat" var="infos">
                 <tr>
                     <td><x:out select="$infos/nom/text()"/></td>
                     <td><x:out select="$infos/prenom/text()"/></td>
                     <td><x:out select="$infos/telephone/text()"/></td>
                     <td><x:out select="$infos/adresse/text()"/></td>
                     <td><x:out select="$infos/mail/text()"/></td>
                 </tr>
             </x:forEach>--%>
        </table>



    </body>
</html>

