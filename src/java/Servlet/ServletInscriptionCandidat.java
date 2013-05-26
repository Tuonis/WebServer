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
public class ServletInscriptionCandidat extends HttpServlet {
    
    private final String CANDIDAT = "http://localhost:8080/Candidature/candidat";

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
            out.println("<title>Servlet ServletInscriptionCandidat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInscriptionCandidat at " + request.getContextPath() + "</h1>");
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
        String nom2 = request.getParameter("nom");
        String prenom2 = request.getParameter("prenom");
        String tel2 = request.getParameter("telephone");
        String mail2 = request.getParameter("mail");
        String adresse2 = request.getParameter("adresse");
        String diplome2 = request.getParameter("diplome");
        String competence2 = request.getParameter("competence");
        String situationPro2 = request.getParameter("situationPro");
        String url6 = CANDIDAT;
        ClientResource resource6 = new ClientResource(url6);
        Form form2 = new Form("nom=" + nom2 + "&prenom=" + prenom2 + "&tel=" + tel2 + "&mail=" + mail2 + "&adresse=" + adresse2 + "&diplome=" + diplome2 + "&competence=" + competence2 + "&situationPro=" + situationPro2);
        form2.encode(CharacterSet.UTF_8);
        Representation rep2 = form2.getWebRepresentation();
        resource6.post(rep2);
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
