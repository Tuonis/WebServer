<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<h1>Oubli de mot de passe</h1>

    <x:forEach select="$dom/candidat/@mdp" var="mdp">
      <h2>Votre mot de passe est: <x:out select="$mdp"/></h2>
    </x:forEach>