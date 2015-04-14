/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.controller;

import com.distributed.hoteljpa.ejb.*;
import com.distributed.hoteljpa.entity.*;
import com.distributed.hoteljpa.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.mail.MailException;

/**
 *
 * @author viewt_000
 */
public class RegisterController extends HttpServlet {

    @Inject
    private UsersFacade userService;
    @Inject
    private AuthoritiesFacade authorityService;
    
    private final EmailVerificationSender emailService = new EmailVerificationSender();
    
    private static final String LOGIN_PATH = "/login.jsp";
    private static final String SUCCESS_PATH = "/registered.html";
    private static final String ERROR_PATH = "/error.jsp";
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
            out.println("<title>Servlet RegisterController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher view = request.getRequestDispatcher(LOGIN_PATH);
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
        String destination = SUCCESS_PATH;
        
        try{
            Users insertUser = new Users();
            String username = request.getParameter("r_username");
            insertUser.setUsername(username);
            String password = ShaHashGeneratorApp.sha512(request.getParameter("r_password"), username);
            String confirm = ShaHashGeneratorApp.sha512(request.getParameter("r_confirm_password"), username);
            if(!password.equals(confirm))
            {
                throw new IllegalArgumentException("Passwords do not match!");
            }
            insertUser.setPassword(password);
            insertUser.setEnabled(false);
	       
            List<Authorities> auths = new ArrayList<Authorities>();
            Authorities auth = new Authorities();
            auth.setAuthority("ROLE_MEMBER"); // or, use any role you want
            auths.add(auth);
            insertUser.setAuthoritiesCollection(auths);
            auth.setUsername(insertUser);

            userService.create(insertUser); // you need a UserService (UserFacade)
            
            try {
                // you need an email service class
                emailService.sendEmail(insertUser.getUsername(), null); 

            } catch (MailException ex) {
                 throw new RuntimeException("Sorry, the verification email could not be "
                                + "sent. Please notify the webmaster at "
                                + "webmaster@gmail.com and we'll complete the "
                                + "process for you. Thanks for your patience.");
            }
            
            
        }
        catch(Exception e)
        {
            destination = ERROR_PATH;
            request.setAttribute("msg", e.getMessage());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
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
