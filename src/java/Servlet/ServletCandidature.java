/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Servlet permettant d'envoyer les informations d'une candidature vers la ressource
 * @author Tuonis
 */
public class ServletCandidature extends HttpServlet {

    private final String CANDIDATURE = "http://miage-ng-dev.math-info.univ-paris5.fr:8080/WS_cmsl/candidature";
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCandidature</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCandidature at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

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
     *
     * Appelé lors d'une candidature à une promotion
     * Appelle la méthode post de CandidatureRessource
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // Récupération des paramètres de la requête
        String idPromo = request.getParameter("promo");
        int idCandidat = Integer.parseInt(request.getParameter("candidat"));
        String mail = request.getParameter("mail");
        int idEtat = 7;
        String motivation = request.getParameter("motivation");
        Date dateCandidature = new Date();
        java.sql.Date dateSQL = new java.sql.Date(dateCandidature.getYear(), dateCandidature.getMonth(), dateCandidature.getDate());        
        String url6 = CANDIDATURE;
        
        // Preparation l'appel au service Web distant
        ClientResource resource = new ClientResource(url6);
        // Préparation du formulaire
        Form form = new Form("idPromo=" + idPromo + "&idCandidat=" + idCandidat + "&idEtat=" + idEtat + "&motivation=" + motivation + "&dateCandidature=" + dateSQL + "&mail=" + mail /*session.getAttribute("mail")*/);
        form.encode(CharacterSet.UTF_8);
        Representation rep = form.getWebRepresentation();
        // Envoi à la ressource
        resource.post(rep);
        // Redirection vers la page du candidat
        response.sendRedirect("ServletListeCandidature");
       
        
        
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
