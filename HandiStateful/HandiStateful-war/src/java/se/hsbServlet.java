/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

import hsb.HandiStatefulBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prachi
 */
public class hsbServlet extends HttpServlet {
    HandiStatefulBeanLocal handiStatefulBean = lookupHandiStatefulBeanLocal();

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
            String b=request.getParameter("sub");
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hsbServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             if(b.equalsIgnoreCase("buy"))
             {
                 int q=Integer.parseInt(request.getParameter("quantity")); 
                 String pr=request.getParameter("productname");
            
            if(handiStatefulBean.buy(pr, q)>0)
                out.println("<h4>You have to Pay Rs. "+handiStatefulBean.buy(pr, q) + "</h4>");
            else
                out.println("<h3>Sorry! The requested product is not available!</h3>");    
             
             }
             if(b.equalsIgnoreCase("bill"))
             {
                 out.println("<h1>Your total bill amount is Rs."+ handiStatefulBean.bill() + "</h1>");
             }
            
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

    private HandiStatefulBeanLocal lookupHandiStatefulBeanLocal() {
        try {
            Context c = new InitialContext();
            return (HandiStatefulBeanLocal) c.lookup("java:global/HandiStateful/HandiStateful-ejb/HandiStatefulBean!hsb.HandiStatefulBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
