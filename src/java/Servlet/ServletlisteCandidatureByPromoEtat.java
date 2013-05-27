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
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Chanthavone
 */
public class ServletlisteCandidatureByPromoEtat extends HttpServlet {
    
    private final String PROMOCANDIDATURE = "http://localhost:8080/Candidature/candidatures/promotion=";
    private final String ETATCANDIDATURE = "http://localhost:8080/Candidature/candidatures/etat=";
    private final String CANDIDATURE = "http://localhost:8080/Candidature/candidatures";

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
            out.println("<title>Servlet ServletlisteCandidatureByPromoEtat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletlisteCandidatureByPromoEtat at " + request.getContextPath() + "</h1>");
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
        String promo = request.getParameter("promo");
        String etat = request.getParameter("etat");
        String url3 = "";
        if (etat.equals("") && promo.equals("")) {
            url3 = CANDIDATURE;
        }
        else if (!promo.equals("")) {
            url3 = PROMOCANDIDATURE + promo;
        }
        else if (!etat.equals("")) {
            url3 = ETATCANDIDATURE + etat;
        }
        ClientResource resource3 = null;
        try {// Preparer l'appel au service Web distant
            resource3 = new ClientResource(url3);
            // Recuperer la reponse en arbre DOM
            DomRepresentation reponse = new DomRepresentation(resource3.get());
            Document doc = reponse.getDocument();
            // Le mettre en post-it de la requete pour le passer a la jsp
            //request.setAttribute("dom", doc);
            request.setAttribute("dom", doc);


        } catch (ResourceException exc) {
            out.println("Erreur : " + exc.getStatus().getCode() + " ("
                    + exc.getStatus().getDescription() + ") : "
                    + resource3.getResponseEntity().getText());
        }
        RequestDispatcher rd4 = request.getRequestDispatcher("listeCandidatureByPromoEtat.jsp");
        rd4.forward(request, response);
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
