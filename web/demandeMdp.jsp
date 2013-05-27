<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="ServletRenvoiMdp" method="post">
    <h1>Mot de passe oublié</h1>
    <p> <label> Email </label><input name="mail" type="text"> </p>
    <input type="hidden"  name="choix"  value="1">
    <input name="cal" type="submit" value="Envoyer" />
</form>
