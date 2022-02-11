/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author flvivet
 */
@WebServlet(name = "TrainStationServlet", urlPatterns = {"/TrainStation"})
public class TrainStationServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainStationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainStationServlet at " + request.getContextPath() + "</h1>");
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //AccessTrainJPA jpa = new AccessTrainJPA();
        //jpa.createTrainStation(1, "bob", "rue", "ville", 63000, (float) 12.0);
        
        response.sendRedirect("newTrain.jsp");
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) 
        {
           String name = request.getParameter("name");
           
           String road = request.getParameter("road");
           
           String city  = request.getParameter("city");
           
           int postal_code = Integer.parseInt(request.getParameter("postal_code"));
           
           float price = Float.parseFloat(request.getParameter("price"));
           
           int id = new Random().nextInt(10000);
           
           AccessTrainJPA jpa = new AccessTrainJPA();
           jpa.createTrainStation(id, name, road, city , postal_code, price);
           
           response.sendRedirect("index.html");
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
