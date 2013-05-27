/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Chanthavone
 */
public class ServletSaisieCandidat extends HttpServlet {
    
    private final String CANDIDAT = "http://localhost:8080/WebService/candidat";

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
            out.println("<title>Servlet ServletsaisieCandidature</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletsaisieCandidature at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("telephone");
        String mail1 = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        String diplome = request.getParameter("diplome");
        String competence = request.getParameter("competence");
        String situationPro = request.getParameter("situationPro");
        String url5 = CANDIDAT;
        ClientResource resource5 = new ClientResource(url5);
        Form form = new Form("id=" + id + "&nom=" + nom + "&prenom=" + prenom + "&tel=" + tel + "&mail=" + mail1 + "&adresse=" + adresse + "&diplome=" + diplome + "&competence=" + competence + "&situationPro=" + situationPro);
        form.encode(CharacterSet.UTF_8);
        Representation rep = form.getWebRepresentation();
        resource5.put(rep);
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
