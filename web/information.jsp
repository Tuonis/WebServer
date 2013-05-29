<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="info" value="${param['ref']}"/>
<c:if test="${info == null}">
    <h1> Bienvenue sur la plaforme de candidature! </h1>
    Vous êtes étudiant et vous avez soif d'apprendre? <br/>
    Une de nos formation vous intéresse? <br/>
    Inscrivez-vous dès maintenant à une de nos session de formation. <br/>
    Déposez votre candidature qui sera étudié de près.
</c:if>
<c:if test="${info == 'accueil'}">
    <h1> Bienvenue sur la plaforme de candidature! </h1>
    Vous êtes étudiant et vous avez soif d'apprendre? <br/>
    Une de nos formation vous intéresse? <br/>
    Inscrivez-vous dès maintenant à une de nos session de formation. <br/>
    Déposez votre candidature qui sera étudié de près.
</c:if>
<c:if test="${info == 'authentification'}">
    <h1> Authentification </h1>
    Indiquez vos identifiants pour accéder à votre compte. <br/>
    Vous pourrez ainsi déposer des candidatures et aussi les consulter. <br/>
</c:if>
<c:if test="${info == 'inscriptionCandidat'}">
    <h1> Inscription à la plateforme </h1>
    Créez tout d'abord votre compte sur notre plateforme pour pouvoir candidater à une de nos formations.
    Remplissez tous les champs pour renseigner votre profil. <br/>
</c:if>
<c:if test="${info == 'listeCandidatureByCandidat'}">
    <h1> Vos candidatures </h1>
    Voici le récapitulatif de vos informations et de vos candidatures. <br/>
    C'est ici que vous pouvez consulter l'état de vos candidature. <br/>
</c:if>
<c:if test="${info == 'saisieCandidat'}">
    <h1> Modification de votre profil </h1>
    Si vos informations ont été modifiées, c'est sur cette page que vous pouvez les corriger. <br/>
    Remplacez les informations erronées et laissez celles qui sont inchangées. <br/>
</c:if>
<c:if test="${info == 'saisieCandidature'}">
    <h1> Candidature pour une formation </h1>
    Candidatez pour une formation. <br/>
    Indiquez la formation que vous voulez suivre ainsi que votre motivation. <br/>
    Votre candidature sera étudié par nos professionnels. <br/>
</c:if>
<c:if test="${info == 'demandeMdp'}">
    <h1> Demande de renvoi de mot de passe </h1>
    Vous avez oublié votre mot de passe? <br/>
    Indiquez votre email et votre mot de passe vous sera envoyé à cette adresse. <br/>
</c:if>