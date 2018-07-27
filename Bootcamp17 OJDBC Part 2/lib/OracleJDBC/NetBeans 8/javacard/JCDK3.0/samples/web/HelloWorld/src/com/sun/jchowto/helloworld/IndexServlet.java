/*
 * Copyright (c) 2009 Sun Microsystems, Inc.
 * All rights reserved.
 * Use is subject to license terms.
 */
package com.sun.jchowto.helloworld;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet serves the main html page. Instead of repeating the
 * HTML code in Java Strings, two files header.i and footer.i were created
 * to hold the common HTML code.
 * This servlet sends the header.i and then index.i and then footer.i to the 
 * browser. This is ike appending all three files.
 * Other servlets will send the response using out.println() methods
 * which will be included between header.i and footer.i.
 * This avoids unnecessary repetetion of the HTML in Java code, and also 
 * simplifies the Servlet code by avoinding too many our.println() calls.
 */
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = null;

        dispatcher = request.getRequestDispatcher("/WEB-INF/header.i");
        dispatcher.include(request, response);

        dispatcher = request.getRequestDispatcher("/WEB-INF/index.i");
        dispatcher.include(request, response);

        dispatcher = request.getRequestDispatcher("/WEB-INF/footer.i");
        dispatcher.include(request, response);
    }
}
