<%-- 
    Document   : index
    Created on : 20 mai 2013, 18:20:40
    Author     : Kentish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <li>
                                <a href="index.jsp">Accueil</a> <hr/>
                            </li>
                            <li>
                                <a href="inscriptionCandidat.jsp">Nouveau candidat</a> <hr/>
                            </li>
                            <li>
                                <a href="saisieCandidature.jsp">Déposer une candidature</a> <hr/>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="principal_droite">
                    <div id="principal_droite_haut">
                        <h1> Bienvenue sur la plaforme de candidature! </h1>
                        Vous êtes étudiant et vous avez soif d'apprendre? <br/>
                        Une de nos formation vous intéresse? <br/>
                        Inscrivez-vous dès maintenant à une de nos session de formation. <br/>
                        Déposez votre candidature qui sera étudié de près.
                    </div>
                    <div id="principal_droite_bas">
                        <div id="bloc_gauche">
                            <h1> Vous êtes déjà candidat?</h1>
                            Authentifiez vous pour accéder à votre compte <br/>
                            <jsp:include page="authentification.jsp"/>
                        </div>
                        <div id="bloc_droite">
                            <h1> Candidatez pour une formation </h1>
                            Une formation vous interesse? <br/>
                            Inscrivez vous ici en ramplissant le formulaire de candidature. <br/>
                            <br/>
                            <a href="inscriptionCandidat.jsp">Accéder à la candidature >></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="footer">
                
            </div>
        </div>
    </body>
</html>
