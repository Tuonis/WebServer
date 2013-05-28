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
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Chanthavone
 */
public class ServletAdminAuthentification extends HttpServlet {

    private final String ADMIN = "http://localhost:8080/WS_cmsl/admin/";

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
            out.println("<title>Servlet ServletAdminAuthentification</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAdminAuthentification at " + request.getContextPath() + "</h1>");
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
        String mail = request.getParameter("mail");
        String pass = request.getParameter("password");
        String url = ADMIN + "email=" + mail;
        out.println("URL : " + url);
        ClientResource resource = null;
        try {// Preparer l'appel au service Web distant
            resource = new ClientResource(url);
            // Recuperer la reponse en arbre DOM
            DomRepresentation reponse = new DomRepresentation(resource.get());
            Document doc = reponse.getDocument();
            // Le mettre en post-it de la requete pour le passer a la jsp
            //request.setAttribute("dom", doc);
            NodeList admin = doc.getElementsByTagName("admin");
            request.setAttribute("dom", doc);
            NodeList candi = doc.getElementsByTagName("infoCandidat");
            Element node = (Element) candi.item(0);
            HttpSession session=request.getSession();
            session.setAttribute("id", node.getAttribute("id"));
            session.setAttribute("nom", node.getAttribute("nom"));
            session.setAttribute("prenom", node.getAttribute("prenom"));
            session.setAttribute("mail", node.getAttribute("mail"));
            session.setAttribute("admin", "admin");


        } catch (ResourceException exc) {
            out.println("Erreur : " + exc.getStatus().getCode() + " ("
                    + exc.getStatus().getDescription() + ") : "
                    + resource.getResponseEntity().getText());
        }
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
