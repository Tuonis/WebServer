/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Servlet de modification d'un candidat
 * @author Chanthavone
 */
public class ServletSaisieCandidat extends HttpServlet {
    
    private final String CANDIDAT = "http://miage-ng-dev.math-info.univ-paris5.fr:8080/WS_cmsl/candidat";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletsaisieCandidature</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletsaisieCandidature at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     * Appelé par saisieCandidat.jsp
     * Appelle la méthode doPut de la ressource CandidatResource
     * Envoie les informations du candidat au WebService
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String mail = (String) session.getAttribute("mail");
        String pass = (String) session.getAttribute("pass");
        // Récupération des paramètres de la requête
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("telephone");
        String mail1 = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        String diplome = request.getParameter("diplome");
        String competence = request.getParameter("competence");
        String situationPro = request.getParameter("situationPro");
        String url5 = CANDIDAT;
        // Preparation l'appel au service Web distant
        ClientResource resource5 = new ClientResource(url5);
        ChallengeResponse authentication = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, mail, pass);
        resource5.setChallengeResponse(authentication);
        // Préparation du formulaire
        Form form = new Form("id=" + id + "&nom=" + nom + "&prenom=" + prenom + "&tel=" + tel + "&mail=" + mail1 + "&adresse=" + adresse + "&diplome=" + diplome + "&competence=" + competence + "&situationPro=" + situationPro);
        form.encode(CharacterSet.UTF_8);
        Representation rep = form.getWebRepresentation();
        // Envoi à la ressource
        resource5.put(rep);
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?ref=listeCandidatureByCandidat");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
