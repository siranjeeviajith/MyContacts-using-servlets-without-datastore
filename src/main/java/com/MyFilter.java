package com;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context=filterConfig.getServletContext();
		List<String> contactNames=new ArrayList();
		context.setAttribute("names", contactNames);
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse )response;
		
		 HttpSession session =httpRequest.getSession(false);
		 if(session == null) {
			 httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	            httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	            httpResponse.setDateHeader("Expires", 0);
			 httpResponse.sendRedirect(httpRequest.getContextPath()+"welcome.html");
			 
		 }
		 else {
			 chain.doFilter(request,response);
		 }
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
