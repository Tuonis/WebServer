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
import org.w3c.dom.Document;

/**
 *
 * @author Kentish
 */
public class ServletModifierCandidature extends HttpServlet {
    private final String PROMOTIONS = "http://localhost:8080/Candidature/promotions";
    private final String ETATS = "http://localhost:8080/Candidature/etats";

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
        int idCandidat = Integer.parseInt(request.getParameter("idCandidat"));
        int idEtat = Integer.parseInt(request.getParameter("idEtat"));
        int idPromotion = Integer.parseInt(request.getParameter("idPromotion"));
        request.setAttribute("idCandidat", idCandidat);
        request.setAttribute("idEtat", idEtat);
        request.setAttribute("idPromotion", idPromotion);
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
