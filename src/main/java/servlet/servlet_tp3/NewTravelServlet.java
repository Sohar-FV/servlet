/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

/**
 *
 * @author flvivet
 */
@WebServlet(name = "NewTravelServlet", urlPatterns = {"/NewTravel"})
public class NewTravelServlet extends HttpServlet {

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
            out.println("<title>Servlet TravelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TravelServlet at " + request.getContextPath() + "</h1>");
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
        AccessTrainJPA jpa = new AccessTrainJPA();
        List<TrainStation> stations = jpa.getAllTrainStation();
        
        
        request.setAttribute("stations", stations);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTravel.jsp");
        dispatcher.forward(request, response);
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
        
            int id = new Random().nextInt(1000000);
            int depart_station_id = Integer.parseInt(request.getParameter("depart_station"));          
            int arrival_station_id = Integer.parseInt(request.getParameter("arrival_station")); 
           
            AccessTrainJPA trainJpa = new AccessTrainJPA();
           
            TrainStation departureStation = trainJpa.getStationById(depart_station_id);
            TrainStation arrivalStation = trainJpa.getStationById(arrival_station_id);
                
            AccessTravelJPA travelJpa = new AccessTravelJPA();
            travelJpa.createTravel(id, departureStation, arrivalStation);
           
            List<Travel> travels = travelJpa.getAllTravels();
        
        request.setAttribute("travels", travels);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/travels.jsp");
        dispatcher.forward(request, response);
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
