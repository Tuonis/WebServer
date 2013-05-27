<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
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

<table>
    <caption>Informations du candidat</caption>
    <tr> <th>Nom</th> <th>Prenom</th> <th>Telephone</th> <th>Adresse</th> <th>Mail</th> </tr>

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

<form action="ServletDispatcher" method="post">
    <input type="hidden"  name="choix"  value="5">
    <input name="cal" type="submit" value="Faire une nouvelle candidature" />
</form>

