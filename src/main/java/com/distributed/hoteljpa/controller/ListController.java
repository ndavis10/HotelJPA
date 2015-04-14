/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.controller;

import com.distributed.hoteljpa.entity.*;
import com.distributed.hoteljpa.ejb.HotelsFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author viewt_000
 */
public class ListController extends HttpServlet {
    @Inject
    private HotelsFacade service;

    private static final String RESULTS_PAGE = "/View/all.jsp";
    private static final String ERROR_PAGE = "/error.jsp";
    private static final String DAO_PARAM = "HotelDao";
    private static final int ALL_HOTELS = 0;
    private static final int STATE_SEARCH = 1;
    private static final int CITY_SEARCH = 2;
            
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
        String destination = "";
        try{
            //HotelDaoStrategy hotelDAO = (HotelDaoStrategy)Class.forName(request.getServletContext().getInitParameter(DAO_PARAM)).newInstance();
            int search = 0;
            try{
                //special handling because primitive types and nulls
                search = Integer.parseInt((String)request.getAttribute("search"));
            }
            catch(Exception e)
            {
                //does nothing
            }    
            String searchParam = (String)request.getAttribute("searchParam");
            List<Hotels> hotelList = new ArrayList<>();
            switch(search)
            {
                case CITY_SEARCH:
                    hotelList = service.findByCity(searchParam);
                    break;
                case STATE_SEARCH:
                    hotelList = service.findByState(searchParam);
                    break;
                default:
                    hotelList = service.findAll();
                    break;
            }
            
            destination = RESULTS_PAGE;
            
            request.setAttribute("list", hotelList);
        }
        catch(Exception e)
        {
            //Update this with actual useful exception-handling
            destination = ERROR_PAGE;
            request.setAttribute("msg", e.getMessage());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
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
