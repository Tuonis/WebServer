<%-- 
    Document   : modifierCandidature
    Created on : 26 mai 2013, 11:57:58
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form>
            <select name="etat" size="1">
                <x:forEach select="$dom2/etats/etat" var="etat">
                    <option><x:out select="$etat/@etat"/></option> 
                </x:forEach>
            </select>
        </form>
        
        <form>
            <select name="promo" size="1">
                <x:forEach select="$dom1/promotions/promotion" var="promo">
                    <option><x:out select="$promo/@nom"/></option> 
                </x:forEach>
            </select>
        </form>
        
    </body>
</html>
