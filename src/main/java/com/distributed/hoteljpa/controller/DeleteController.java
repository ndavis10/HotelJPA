/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.controller;

import com.distributed.hoteljpa.ejb.HotelsFacade;
import com.distributed.hoteljpa.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

/**
 *
 * @author viewt_000
 */
@WebServlet(name = "DeleteController", urlPatterns = {"/Delete"})
public class DeleteController extends HttpServlet {
    @EJB
    private HotelsFacade service;

    private static final String CONFIRM_PATH = "/View/confirm.jsp";
    private static final String COMPLETE_PATH = "List";
    private static final String ERROR_PATH = "/error.jsp";
    private static final String DAO_PARAM = "HotelDao";

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
            out.println("<title>Servlet DeleteController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteController at " + request.getContextPath() + "</h1>");
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
        
        String destination = CONFIRM_PATH;
        
        try
        {
            //HotelDaoStrategy hotelDAO = (HotelDaoStrategy)Class.forName(request.getServletContext().getInitParameter(DAO_PARAM)).newInstance();
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            Hotels hotel = service.find(id);
            
            request.setAttribute("hotel", hotel);
        }
        catch(Exception e)
        {
            destination = ERROR_PATH;
            request.setAttribute("msg", e.getMessage());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(response.encodeRedirectURL(destination));
        view.forward(request, response);
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
        
        String destination = COMPLETE_PATH;
        
        try
        {
            //HotelDaoStrategy hotelDAO = (HotelDaoStrategy)Class.forName(request.getServletContext().getInitParameter(DAO_PARAM)).newInstance();
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            service.remove(service.find(id));
        }
        catch(Exception e)
        {
            destination = ERROR_PATH;
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher view = request.getRequestDispatcher(response.encodeRedirectURL(destination));
            view.forward(request, response);
        }
        response.sendRedirect(response.encodeRedirectURL(destination));
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
