

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
            <th>Nom</th>
            <th>Prenom</th>
            <th>Telephone</th>
            <th>Adresse</th>
            <th>Mail</th>

            <x:forEach select="$dom/infosCandidature/infoCandidature" var="infos">
                <tr>
                    <td><x:out select="$dom/infosCandidature/@promo"/></td>
                    <td><x:out select="$infos/@dateCandidature"/></td>
                    <td><x:out select="$infos/@etat"/></td>
                    <td><x:out select="$infos/@nom"/></td>    
                    <td><x:out select="$infos/@prenom"/></td>  
                    <td><x:out select="$infos/@telephone"/></td>  
                    <td><x:out select="$infos/@adresse"/></td>  
                    <td><x:out select="$infos/@mail"/></td>  
                    
                </tr>
            </x:forEach>
        </table>

        <br/>
        <br/>

       
    </body>
</html>

