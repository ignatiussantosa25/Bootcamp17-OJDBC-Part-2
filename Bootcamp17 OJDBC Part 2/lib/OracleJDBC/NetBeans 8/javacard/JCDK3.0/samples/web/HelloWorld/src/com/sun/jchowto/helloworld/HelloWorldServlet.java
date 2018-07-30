/*
 * Copyright (c) 2009 Sun Microsystems, Inc.
 * All rights reserved.
 * Use is subject to license terms.
 */
package com.sun.jchowto.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class HelloWorldServlet extends HttpServlet {

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = null;
        
        dispatcher = request.getRequestDispatcher("/WEB-INF/header.i");
        dispatcher.include(request, response);
        
        out.println("        <tr>");
        out.println("            <td bgcolor=\"#FFFFFF\" align=\"center\" valign=\"middle\">");
        out.println("                <table bgcolor=\"#000000\" border=\"0\" width=\"100%\" cellspacing=\"1\" cellpadding=\"15\">");
        out.println("                    <tr>");
        out.println("                        <td align=\"center\" bgcolor=\"#FFFFFF\">");       
        out.println("                            <b>Hello " + request.getParameter("name") + "!</b>");
        out.println("                        </td>");
        out.println("                    </tr>");
        out.println("                </table>");
        out.println("            </td>");
        out.println("        </tr>");
        
        dispatcher = request.getRequestDispatcher("/WEB-INF/footer.i");
        dispatcher.include(request, response);
    }
    
}
