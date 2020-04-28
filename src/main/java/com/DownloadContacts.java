package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadContacts extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment; filename=MyContacts.csv") ;
		response.setContentType("text/csv");
		PrintWriter out=response.getWriter();
		ServletContext context = request.getServletContext();
		List<String> contactNames=(List<String>) context.getAttribute("names");
		if(contactNames.isEmpty()) {
			out.print("No Contacts!!");
		}
		else {
			out.println("Name,Number,Email,Address");
			for(String name:contactNames) {
				Contact contact=(Contact) context.getAttribute(name);
				out.println(contact.toStringForFile());
			}
		}
		out.flush();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 doGet(req,res);
	}
}
