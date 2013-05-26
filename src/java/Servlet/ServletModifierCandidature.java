/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.resource.ClientResource;
import org.w3c.dom.Document;

/**
 *
 * @author Kentish
 */
public class ServletModifierCandidature extends HttpServlet {

    private final String PROMOTIONS = "http://localhost:8080/WebService/promotions";
    private final String ETATS = "http://localhost:8080/WebService/etats";

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
            out.println("<title>Servlet ServletModifierCandidature</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletModifierCandidature at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        int val = Integer.parseInt(request.getParameter("choix"));
        switch (val) {
            /*ce traitement va permettre de verifier l'identite de l'utilisateur et ses droits via les parametres 
             * login et pass qu'il aura transmis via le formulaire useracess. On le redirige soit vers la page des 
             * produits s'il est identifie, soit vers une page d'erreur
             */
            case 1:
                int idCandidat = Integer.parseInt(request.getParameter("idCandidat"));
                int idEtat = Integer.parseInt(request.getParameter("idEtat"));
                int idPromotion = Integer.parseInt(request.getParameter("idPromotion"));
                String motivation = request.getParameter("motivation");
                String dateCandidature = request.getParameter("dateCandidature");
                HttpSession session = request.getSession();
                session.setAttribute("idCandidat", idCandidat);
                session.setAttribute("idEtat", idEtat);
                session.setAttribute("idPromotion", idPromotion);
                session.setAttribute("motivation", motivation);
                session.setAttribute("dateCandidature", dateCandidature);
                String url1 = PROMOTIONS;
                String url2 = ETATS;
                ClientResource resource1 = new ClientResource(url1);
                ClientResource resource2 = new ClientResource(url2);
                DomRepresentation reponse1 = new DomRepresentation(resource1.get());
                Document doc1 = reponse1.getDocument();
                DomRepresentation reponse2 = new DomRepresentation(resource2.get());
                Document doc2 = reponse2.getDocument();
                request.setAttribute("dom1", doc1);
                request.setAttribute("dom2", doc2);
                RequestDispatcher rd = request.getRequestDispatcher("modifierCandidature.jsp");
                rd.forward(request, response);
                break;

            /*ce traitement va permettre de prendre en compte la demande de l'utilisateur via le radiobutton de la jsp
             * affichecontenu. Ainsi, on initialise des attributs selon qu'il demande les produits ou les produits
             * non vendus ou alors on le redirige vers la jsp insertionproduit s'il veut inserer un produit
             */
            case 2:
                HttpSession s=request.getSession();
                out.println(s.getAttribute("motivation"));
                out.println(request.getParameter("etat"));
                
                
                break;

        }


    }
}
