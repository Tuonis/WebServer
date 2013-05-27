<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="ServletInscriptionCandidat" method="post">
    <h1>Saisie candidat</h1>
    <p> <label> Nom : </label> <input type="text" name="nom"/> </p>
    <p> <label> Prénom : </label> <input type="text" name="prenom"/> </p>
    <p> <label> Téléphone : </label> <input type="text" name="telephone"/> </p>
    <p> <label> Email : </label> <input type="text" name="mail"/> </p>
    <p> <label> Adresse : </label> <input type="text" name="adresse"/> </p>
    <p> <label> Diplomes : </label> <input type="text" name="diplome"/> </p>
    <p> <label> Compétences : </label> <input type="text" name="competence"/> </p>
    <p> <label> Situation professionnelle : </label> <input type="text" name="situationPro"/> </p>
    <input type="hidden"  name="choix"  value="6">
    <input type="submit" name="inscrire" value="valider"/>
</form>
