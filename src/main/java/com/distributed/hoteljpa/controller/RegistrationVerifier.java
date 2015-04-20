/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.controller;


import com.distributed.hoteljpa.ejb.UsersFacade;
import com.distributed.hoteljpa.entity.Users;
import com.distributed.hoteljpa.util.EmailVerificationSender;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.codec.Base64;

/**
 * This class is used to process the verification link sent via email to 
 * prospective new members of Bit Bay. It does this by converting the
 * base64 representation of the user email address back to a String and then
 * using that String to lookup the user. If the user exists, the 'enabled'
 * status in the database is set to true, else the user is redirected to
 * an error page.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class RegistrationVerifier extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Note that we are using @Inject vs. @EJB. Inject is better. But
    // you must have bean.xml installed in your web app under the
    // "WEB-INF" directory.
    @Inject
    UsersFacade userService;
    @Inject 
    EmailVerificationSender emailService;

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
        String errMsg = "";
        String destination = "/registrationVerified.jsp";
        
        try {
            String id = request.getParameter("id");
            byte[] decoded = Base64.decode(id.getBytes());
            String username = new String(decoded);
            
            Users user = userService.findByUsername(username).get(0);
            if(user == null) {
                throw new RuntimeException("Sorry, that user is not in our system");
            }
            user.setEnabled(true);
            userService.edit(user);
                        
        } catch(Exception dae) {
            errMsg = "VERIFICATION ERROR: " + dae.getLocalizedMessage();
            request.setAttribute("errMsg", errMsg);
            destination = "/verificationError.jsp";
        }
        
                    
        RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(destination);
                dispatcher.forward(request, response);     
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
