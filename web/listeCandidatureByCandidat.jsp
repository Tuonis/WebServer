<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<table>
    <caption>Informations du candidat</caption>
    <tr> <th>Nom</th> <th>Prenom</th> <th>Telephone</th> <th>Adresse</th> <th>Mail</th> </tr>

    <x:forEach select="$dom/infosCandidature/infoCandidat" var="infos">
         <tr>
             <td><x:out select="$infos/@nom"/></td>
             <td><x:out select="$infos/@prenom"/></td>
             <td><x:out select="$infos/@telephone"/></td>
             <td><x:out select="$infos/@adresse"/></td>
             <td><x:out select="$infos/@mail"/></td>
         </tr>
     </x:forEach>
</table>

<table>
    <caption>Candidatures</caption>
    <tr> <th>Nom promotion</th> <th>Date candidature</th> <th>Etat</th> </th>

    <x:forEach select="$dom/infosCandidature/infoCandidature" var="infos">
        <tr>
            <td><x:out select="$infos/@nomPromotion"/></td>
            <td><x:out select="$infos/@dateCandidature"/></td>
            <td><x:out select="$infos/@etat"/></td>       
        </tr>
    </x:forEach>
</table>

<form action="ServletDispatcher" method="post">
    <input type="hidden"  name="choix"  value="5">
    <input name="cal" type="submit" value="Faire une nouvelle candidature" />
</form>

