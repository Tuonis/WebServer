<%-- 
    Document   : index
    Created on : 20 mai 2013, 18:20:40
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style2.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site de candidature</title>
    </head>
    <body>
        <div id="content">
            <div id="header">
                <div id="logo">
                    
                </div>
                <div id="sloggan">
                    
                </div>
            </div>
            <div id="principal">
                <div id="principal_gauche">
                    <div id="div-menu">
                        <ul id="menu">
                            <c:set var="maSession" value="${sessionScope['nom']}"/>
                            <c:choose>
                                <c:when test="${maSession == null}">
                                    <jsp:include page="menu.jsp?session=user"/>
                                </c:when>
                                <c:otherwise>
                                    <jsp:include page="menu.jsp?session=candidat"/>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
                <div id="principal_droite">
                    <div id="principal_droite_haut">
                        <jsp:include page="information.jsp"/>
                    </div>
                    <div id="principal_droite_bas">
                        <c:set var="maPage" value="${param['ref']}.jsp"/>
                        <c:choose>
                            <c:when test="${maPage == '.jsp'}">
                                <jsp:include page="accueil.jsp"/>
                            </c:when>
                            <c:otherwise>
                                <jsp:include page="${maPage}"/>
                            </c:otherwise>
                        </c:choose>
                        
                    </div>
                </div>
            </div>
            <div id="footer">
                
            </div>
        </div>
    </body>
</html>
