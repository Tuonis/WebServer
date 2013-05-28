<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>




<form action="ServletCandidature" method="post"  class="grand_form">
    <h1>Inscription à une promotion</h1>

    <p> <label> Promotion : </label> 
    <select name="promo" size="1">
        <x:forEach select="$dom/promotions/promotion" var="promo">
            <option><x:out select="$promo/@nom"/></option> 
        </x:forEach>
    </select>
    </p>
    <p> <label> Motivation : </label> <textarea type="text" name="motivation" rows="4" cols="35"/></textarea> </p>
    <input type="submit" name="inscrire" value="valider">
</form>
