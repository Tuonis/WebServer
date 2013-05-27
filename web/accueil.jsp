<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="bloc_gauche">
    <h1> Vous êtes déjà candidat?</h1>
    Authentifiez vous pour accéder à votre compte <br/>
    <jsp:include page="authentification.jsp"/>
</div>
<div id="bloc_droite">
    <h1> Candidatez pour une formation </h1>
    Une formation vous interesse? <br/>
    Inscrivez vous ici en remplissant le formulaire de candidature. <br/>
    <br/>
    <a href="index.jsp?ref=inscriptionCandidat">Accéder à la candidature >></a>
</div>
