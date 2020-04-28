package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);

		PrintWriter out = response.getWriter();
//		if (session == null) {
//			String uname = request.getParameter("uname");
//			String psw = request.getParameter("psw");
//			if (uname.equalsIgnoreCase(psw)) {
		   out.println("query"+request.getQueryString());
		        
				StringBuilder stringBuilder = new StringBuilder(1000);
			    Scanner scanner = new Scanner(request.getInputStream());
			    while (scanner.hasNextLine()) {
			        stringBuilder.append(""+scanner.nextLine()+"\n");
			    }

			    String body = stringBuilder.toString();

			    //System.out.println(body);
			    out.println("body:"+body);
//				session = request.getSession();
//				session.setAttribute("uname", uname);
//				//response.sendRedirect("/profile");
//
//			} else {
//				out.print("<h3>Username or Password is wrong Try again!<h3><br>");
//				out.print("<a href=\"welcome.html\" > Login </a>");
//
//			}
//		} else {
//			response.sendRedirect("/profile");
//		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
