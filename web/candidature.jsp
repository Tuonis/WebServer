<%-- 
    Document   : candidature
    Created on : 20 mai 2013, 15:45:05
    Author     : Kentish
--%>

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
    <ol>
      <x:forEach select="$dom/candidatures/candidature" var="candidature">
        <li>
         
            <x:out select="concat($candidature/idCandidat/text(), ' ', $candidature/motivation/text())"/>
        </li>
      </x:forEach>
    </ol>
    
  </body>
</html>
