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
public class ServletListeCandidature extends HttpServlet {

    private final String CANDIDATS = "http://miage-ng-dev.math-info.univ-paris5.fr:8080/WS_cmsl/candidats/";
    
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
            out.println("<title>Servlet ServletListeCandidature</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletListeCandidature at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Récupération des paramètres de la requête
        HttpSession session = request.getSession();
        String mail = (String) session.getAttribute("mail");
        String pass = (String) session.getAttribute("pass");
        String url = CANDIDATS + "email=" + mail;
        out.println("URL : " + url + mail + pass);
        ClientResource resource = null;
        try {
            // Preparer l'appel au service Web distant
            resource = new ClientResource(url);
            ChallengeResponse authentication = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, mail, pass);
            resource.setChallengeResponse(authentication);
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
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?ref=listeCandidatureByCandidat");
            rd.forward(request, response);

        } catch (ResourceException exc) {
            // Si le candidat n'est pas trouvé, on envoie une erreur
            request.setAttribute("erreur", "erreur");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?ref=authentification");
            rd.forward(request, response);
        }
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
        // Récupération des paramètres de la requête
        HttpSession session = request.getSession();
        String mail = (String) session.getAttribute("mail");
        String pass = (String) session.getAttribute("mdp");
        String url = CANDIDATS + "email=" + mail;
        out.println("URL : " + url);
        ClientResource resource = null;
        try {
            // Preparer l'appel au service Web distant
            resource = new ClientResource(url);
            ChallengeResponse authentication = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, mail, pass);
            resource.setChallengeResponse(authentication);
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
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?ref=listeCandidatureByCandidat");
            rd.forward(request, response);

        } catch (ResourceException exc) {
            // Si le candidat n'est pas trouvé, on envoie une erreur
            request.setAttribute("erreur", "erreur");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?ref=authentification");
            rd.forward(request, response);
        }
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
