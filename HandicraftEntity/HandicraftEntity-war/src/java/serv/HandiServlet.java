/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import Handi.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author tsecit
 */
public class HandiServlet extends HttpServlet {
    @EJB
    private HandicraftFacadeLocal handicraftFacade;

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
        String pro=request.getParameter("subitemname1");
        String cname=request.getParameter("username1");
        String cnameup=request.getParameter("username2");
        
        
        Handicraft h=new Handicraft();
        String pro1=request.getParameter("subitemname2");
        //int z=Integer.parseInt(pro1);
       int qty;
       if(!(pro.isEmpty()))
            //if(!(pro.equalsIgnoreCase("0")))
            {
                qty=Integer.parseInt(request.getParameter("quan1"));
            
                h.setUsername(cname);
                h.setSubitem(pro);
                h.setQuantity(qty);
                if(pro.equalsIgnoreCase("Miniaturecat"))
                    h.setCost(2500*qty);
                if(pro.equalsIgnoreCase("BanbooElephant"))
                    h.setCost(3000*qty);
                if(pro.equalsIgnoreCase("WovenBuddha"))
                    h.setCost(1500*qty);
                if(pro.equalsIgnoreCase("WoodenBamboo"))
                    h.setCost(1570*qty);
                if(pro.equalsIgnoreCase("Coil"))
                    h.setCost(700*qty);
                if(pro.equalsIgnoreCase("MatchstickFigure"))
                    h.setCost(250*qty);
            }
        
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HandiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(!(pro.isEmpty()))
            {
                //.println("<h2>"+pro+"</h2>");
                handicraftFacade.create(h);
        
                out.println("<h1>"+"Record Created Successfully..!!"+ "</h1>");
            }
            if(!(pro1.isEmpty()))
            {
                    //out.println("<h2>"+pro1+"hello"+"</h2>");
                    //Handicraft p1=new Handicraft();
                    List<Handicraft> result;
                    int qty1=Integer.parseInt(request.getParameter("newquan"));
                    result=handicraftFacade.findAll();
                    int count=handicraftFacade.count();
                    
                 /*   for(int i=0; i<count; i++)
            {   
                Football li = new Football();
                li = resultList.get(i);
                if(li.getPlayernames().equalsIgnoreCase(name))
                {
                    Football fo = new Football();
                    fo = li;
                    footballFacade.remove(fo);
                    break;
                }
            }
                */
                    
                    for(int i=0;i<count;i++)
                    {
                        Handicraft p1=new Handicraft();
                        p1=result.get(i);
                   
                       if(p1.getUsername().equalsIgnoreCase(cnameup))
                       {
                           //out.println("<h3>"+"heyyy"+"</h3>");
                            Handicraft fo=new Handicraft();
                            fo=p1;
                            fo.setSubitem(pro1);
                            fo.setQuantity(qty1);
                            if(pro1.equalsIgnoreCase("MiniatureCat"))
                                fo.setCost(2500*qty1);
                            if(pro1.equalsIgnoreCase("BambooElephant"))
                                fo.setCost(3000*qty1);
                            if(pro1.equalsIgnoreCase("WovenBuddha"))
                                fo.setCost(1500*qty1);
                            if(pro1.equalsIgnoreCase("WoodenBamboo"))
                                fo.setCost(1570*qty1);
                            if(pro1.equalsIgnoreCase("Coil"))
                                fo.setCost(700*qty1);
                            if(pro.equalsIgnoreCase("MatchstickFigure"))
                                fo.setCost(250*qty1);
                           handicraftFacade.edit(fo);
                       }
                    }
            
                    out.println("<h1>"+"Your order has been updated"+"</h2>");
            
            
                
            }
            
            String cname4=request.getParameter("username4");
            //out.println("<h2>"+"*****"+cname4+"</h2>");
            if(!(cname4.isEmpty()))
            {
                //out.println("<h2>"+pro1+"</h2>");
                    //Handicraft p1=new Handicraft();
                    List<Handicraft> result;
                    
                    result=handicraftFacade.findAll();
                    int count=handicraftFacade.count();
                
                for(int i=0;i<count;i++)
                    {
                        Handicraft p1=new Handicraft();
                        p1=result.get(i);
                   
                       if(p1.getUsername().equalsIgnoreCase(cname4))
                       {
                           //out.println("<h3>"+cname4+"heyyy"+"</h3>");
                           Handicraft fo=new Handicraft();
                           fo=p1;
                          
                           handicraftFacade.remove(p1);
                       }
                    }
            
                    out.println("<h1>"+"Your record has been deleted"+"</h2>");
            
            
                
            }
            
            
            
            String cname3=request.getParameter("username5");
            //out.println("<h2>"+"*****"+cname4+"</h2>");
            if(!(cname3.isEmpty()))
            {
                //out.println("<h2>"+pro1+"</h2>");
                    //Handicraft p1=new Handicraft();
                    List<Handicraft> result;
                    
                    result=handicraftFacade.findAll();
                    int count=handicraftFacade.count();
                
                    for(int i=0;i<count;i++)
                    {
                        Handicraft p1=new Handicraft();
                        p1=result.get(i);
                   
                       if(p1.getUsername().equalsIgnoreCase(cnameup))
                       {
                           //out.println("<h3>"+"heyyy"+"</h3>");
                            Handicraft fo=new Handicraft();
                            fo=p1;
                            fo.setSubitem(null);
                            fo.setQuantity(0);
                            
                            fo.setCost(0);
                           handicraftFacade.edit(fo);
                       }
                    }
            
                    out.println("<h1>"+"Your order has been cancelled"+"</h2>");
            
            
                    
            
            
                
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

}
