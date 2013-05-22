

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
            <x:forEach select="$dom/infosCandidature/infos" var="infos">
                <tr>
                    <td><x:out select="$infos/nomPromotion/text()"/></td>
                    <td><x:out select="$infos/dateCandidature/text()"/></td>
                    <td><x:out select="$infos/etat/text()"/></td>    
                </tr>
            </x:forEach>
        </table>



    </body>
</html>

