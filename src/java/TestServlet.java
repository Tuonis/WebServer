/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Kentish
 */
public class TestServlet extends HttpServlet {

    private final String CANDIDAT = "http://localhost:8080/Candidature/candidats/";
    private final String CANDIDATURE = "http://localhost:8080/Candidature/candidature/idCandidat=";

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

        response.setContentType("text/html;charset=UTF-8");
        int val = Integer.parseInt(request.getParameter("choix"));
        PrintWriter out = response.getWriter();
        //le switch va permettre de faire un traitement specifique selon l'appelant qui transmet un certain nombre
        switch (val) {

            case 1:
                
                String email = request.getParameter("mail");
                String url2 = CANDIDAT +"mail="+ email;
                out.println("URL : " + url2);
                ClientResource resource2 = null;
                try {// Preparer l'appel au service Web distant
                    resource2 = new ClientResource(url2);
                    // Recuperer la reponse en arbre DOM
                    Document doc = resource2.get(Document.class);
                    // Le mettre en post-it de la requete pour le passer a la jsp
                    request.setAttribute("dom", doc);
                } catch (ResourceException exc) {
                    out.println("Erreur : " + exc.getStatus().getCode() + " ("
                            + exc.getStatus().getDescription() + ") : "
                            + resource2.getResponseEntity().getText());
                }
                RequestDispatcher rd2 = request.getRequestDispatcher("mdpenvoi.jsp");
                rd2.forward(request, response);
                
                

                break;


            case 2:
                String mail = request.getParameter("mail");
                String pass = request.getParameter("pass");
                String url = CANDIDAT + "email="+mail+"&mdp="+pass;
                out.println("URL : " + url);
                ClientResource resource = null;
                try {// Preparer l'appel au service Web distant
                    resource = new ClientResource(url);
                    // Recuperer la reponse en arbre DOM
                    Document doc = resource.get(Document.class);
                    // Le mettre en post-it de la requete pour le passer a la jsp
                    request.setAttribute("dom", doc);
                } catch (ResourceException exc) {
                    out.println("Erreur : " + exc.getStatus().getCode() + " ("
                            + exc.getStatus().getDescription() + ") : "
                            + resource.getResponseEntity().getText());
                }
                RequestDispatcher rd = request.getRequestDispatcher("candidatures.jsp");
                rd.forward(request, response);
               
                break;


            case 3:

                break;

            case 4:
                request.getSession().invalidate();
                response.sendRedirect("useracess.html");
                break;
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
