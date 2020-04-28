package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContact extends HttpServlet {
	String name;
	String number;
	String email;
	String address;

	public void getInputs(HttpServletRequest request, HttpServletResponse response) {
		this.name =  request.getParameter("name");
		this.number =  request.getParameter("number");
		this.email =  request.getParameter("email");
		this.address =  request.getParameter("address");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		getInputs(request, response);
		try {

			List<String> contactNames = (List<String>) context.getAttribute("names");
			if (name == null || number == null || email == null || address == null) {
				throw new Exception("<h4>Please enter valid inputs!!! Try again!! ");

			} else if (contactNames.contains(name)) {
				throw new Exception("<h4>Contact name already exist ! Try again!</h4><br>");

			} else {
				Contact contact = new Contact(name,Long.parseLong(number),email,address);
				context.setAttribute(name, contact);
				contactNames.add(name);
				response.sendRedirect("/profile");
				System.out.println("contacts added!");
			}
		} catch (Exception e) {
			out.print("<h4>" + e + " Try again!!</h4>");
			out.print("<br><a href=\"addContacts.html\" > Add Contact</a>");
			out.print("<br><a href=\"/logout\" > Logout</a>");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
