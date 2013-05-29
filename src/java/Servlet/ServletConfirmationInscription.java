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
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Servlet de confirmation d'inscription
 * @author Tuonis
 */
public class ServletConfirmationInscription extends HttpServlet {

    
     private final String INSCRIPTION = "http://localhost:8080/WS_cmsl/inscription";
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
            out.println("<title>Servlet ServletConfirmationInscription</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConfirmationInscription at " + request.getContextPath() + "</h1>");
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
     *
     * Appelé lors de la confirmation d'inscription d'un candidat
     * On récupère son mot de passe (qui lui avait été envoyé par mail)
     * Et on appelle la méthode put de InscriptionRessource
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Récupération des paramètres de la requête
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");
        String url5 = INSCRIPTION;
        // Preparation l'appel au service Web distant
        ClientResource resource5 = new ClientResource(url5);
        // Préparation du formulaire
        Form form = new Form("nom="+nom+"&mdp=" +mdp);
        form.encode(CharacterSet.UTF_8);
        Representation rep = form.getWebRepresentation();
        // Envoi à la ressource
        resource5.put(rep);
        // Redirection vers l'accueil
        response.sendRedirect("index.jsp?ref=accueil");
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
