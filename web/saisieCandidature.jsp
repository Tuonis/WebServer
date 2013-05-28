<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>




<form action="ServletCandidature" method="post">
    <h1>Choix Candidature</h1>

    <select name="promo" size="1">
        <x:forEach select="$dom/promotions/promotion" var="promo">
            <option><x:out select="$promo/@nom"/></option> 
        </x:forEach>
    </select>

    <p> <label> Motivation : </label> <input type="text" name="motivation"/> </p>
    <%  session= request.getSession(); 
        String id=(String)session.getAttribute("id");
       System.out.println("attribut session : "+id);
       String mail = (String) session.getAttribute("mail");
       System.out.println("attribut session mail : "+mail);
    %>
    <input type="hidden" name="candidat" value="<%=id %>" />
    <input type="hidden" name="mail" value="<%=mail%>" />
    <input type="submit" name="inscrire" value="valider">
</form>
