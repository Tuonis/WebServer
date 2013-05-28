<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="ServletListeCandidatureByCandidat" method="post">
    <!-- <h1>Authentification</h1> -->
    <p> <label> Email </label><input name="mail" type="text"> </p>
    <p> <label>Mot de passe</label><input name="pass" type="password" /> </p>
    <p> <a href="index.jsp?ref=demandeMdp"> Mot de passe oublié? </a> </p>
    
    <c:if test="${erreur!=null}">
        <div id="erreur">${erreur}</div>
    </c:if>
    <input name="cal" type="submit" value="connect" />
</form>

