package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Profile extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
			out.print("<h2>Welcome "+session.getAttribute("uname")+" !</h2><br>");
			out.print("<h4>Contacts List:</h4><br>");
			ServletContext context=request.getServletContext();
			List<String> contactNames=(List<String>) context.getAttribute("names");
			if(contactNames.isEmpty()) {
				out.print("<h4>No Contacts added!!</h4><br>");
			}
			else {
				for(String name:contactNames) {
					Contact contact=(Contact) context.getAttribute(name);
					out.println("<h4>"+contact+"</h4>");
					
				}
			}
			out.print("<br><a href=\"addContacts.html\" > Add Contact</a>");
			out.print("<br><a href=\"/downloadContacts\" > Download Contacts</a>");			
			out.print("<br><a href=\"/logout\" > Logout</a>");
			
			
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 doGet(request,response);
	}
}
