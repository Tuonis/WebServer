package Servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ServletListeCandidatureByCandidat extends HttpServlet {

    private final String CANDIDATS = "http://localhost:8080/WS_cmsl/candidats/";
    
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
            out.println("<title>Servlet ServletListeCandidatureByCandidat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletListeCandidatureByCandidat at " + request.getContextPath() + "</h1>");
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
        String pass = request.getParameter("pass");
        String url = CANDIDATS + "email=" + mail;
        out.println("URL : " + url);
        ClientResource resource = null;
        try {// Preparer l'appel au service Web distant
            resource = new ClientResource(url);
            // Recuperer la reponse en arbre DOM
            DomRepresentation reponse = new DomRepresentation(resource.get());
            Document doc = reponse.getDocument();
            // Le mettre en post-it de la requete pour le passer a la jsp
            //request.setAttribute("dom", doc);
            NodeList candidatures = doc.getElementsByTagName("infoCandidature");
            request.setAttribute("dom", doc);
            NodeList candi = doc.getElementsByTagName("infoCandidat");
            Element node = (Element) candi.item(0);
            request.setAttribute("nom", node.getAttribute("nom"));
            request.setAttribute("prenom", node.getAttribute("prenom"));
            request.setAttribute("telephone", node.getAttribute("telephone"));
            request.setAttribute("adresse", node.getAttribute("adresse"));
            request.setAttribute("mail", node.getAttribute("mail"));


            HttpSession session=request.getSession();
            session.setAttribute("dom", doc);
            session.setAttribute("id", node.getAttribute("id"));
            session.setAttribute("nom", node.getAttribute("nom"));
            session.setAttribute("prenom", node.getAttribute("prenom"));
            session.setAttribute("mail", node.getAttribute("mail"));


        } catch (ResourceException exc) {
            out.println("Erreur : " + exc.getStatus().getCode() + " ("
                    + exc.getStatus().getDescription() + ") : "
                    + resource.getResponseEntity().getText());
        }
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
