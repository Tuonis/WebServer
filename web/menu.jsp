<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="maPage" value="${param['session']}"/>
<c:choose>
    <c:when test="${maPage == 'user'}">
        <li>
            <a href="index.jsp">Accueil</a> <hr/>
        </li>
        <li>
            <a href="index.jsp?ref=inscriptionCandidat">Nouveau candidat</a> <hr/>
        </li>
        <li>
            <a href="index.jsp?ref=saisieCandidature">D�poser une candidature</a> <hr/>
        </li>
    </c:when>
    <c:otherwise>
        <li>
            <a href="index.jsp">Accueil</a> <hr/>
        </li>
        <li>
            <a href="index.jsp?ref=listeCandidatureByCandidat">Consulter ses candidatures</a> <hr/>
        </li>
        <li>
            <a href="index.jsp?ref=saisieCandidat">Modifier son profil</a> <hr/>
        </li>
        <li>
            <a href="index.jsp?ref=saisieCandidature">D�poser une candidature</a> <hr/>
        </li>
        <li>
            <a href="ServletDeconnexion">D�connexion</a> <hr/>
        </li>
    </c:otherwise>
</c:choose>