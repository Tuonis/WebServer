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

/**
 * Servlet permettant d'obtenir la liste des promotions disponibles
 * @author Kentish
 */
public class ServletListePromotion extends HttpServlet {

    private final String CANDIDATURE = "http://miage-ng-dev.math-info.univ-paris5.fr:8080/WS_cmsl/promotions";

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
            out.println("<title>Servlet ServletListePromotion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletListePromotion at " + request.getContextPath() + "</h1>");
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
              response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url3 = CANDIDATURE;
        ClientResource resource3 = null;
        try {
            // Preparer l'appel au service Web distant
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
        // Redirection vers la page de modification d'un candidat
        RequestDispatcher rd4 = request.getRequestDispatcher("index.jsp?ref=saisieCandidature");
        rd4.forward(request, response);
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
        String url3 = CANDIDATURE;
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
        RequestDispatcher rd4 = request.getRequestDispatcher("index.jsp?ref=saisieCandidature");
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
