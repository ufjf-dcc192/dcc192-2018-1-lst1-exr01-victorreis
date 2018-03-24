/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "ListaDeFrutasServlet", urlPatterns = {"/index.html"})
public class ListaDeFrutasServlet extends HttpServlet {

    private List<String> frutas;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.frutas = new ArrayList<>();
        this.frutas.add("Manga");
        this.frutas.add("Caju");
        this.frutas.add("Damasco");
        this.frutas.add("Banana");
        this.frutas.add("Mamão");
        this.frutas.add("Amora");

        String ordena = request.getParameter("ordena");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaDeFrutasServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ListaDeFrutasServlet - " + request.getContextPath() + "</h1>");

            if (ordena != null) {
                if ("alf".equals(ordena)) {
                    Collections.sort(frutas);
                } else if ("num".equals(ordena)) {
//                    a.length() < b.length() ? a : b;
//                    Collections.sort(frutas, (a, b) -> b.compareTo(a));
                    Collections.sort(frutas, (a, b) -> a.length()-b.length());
                } else if ("ale".equals(ordena)) {
                    Collections.shuffle(frutas);
                }
            }

            out.println("<ul>");
            for (String fruta : frutas) {
                out.println("<li>" + fruta + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Escolha uma ordenação</h3>");
            out.println("<a href='" + request.getContextPath() + "?ordena=alf'>Ordem Alfabética</a>");
            out.println("<a href='" + request.getContextPath() + "?ordena=num'>Número de Letras</a>");
            out.println("<a href='" + request.getContextPath() + "?ordena=ale'>Aleatória</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
