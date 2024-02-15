package com.theone.cookiee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//receiving cookie

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		     Cookie[] cookies = request.getCookies();
		     if(cookies!=null&& cookies.length>0) {
		    	 Cookie ck=cookies[0];
		    	 writer.print("welcome to your profile "+ck.getValue());
		     }else {
		    	 writer.print("please login first");
		    	 request.getRequestDispatcher("login.html").include(request, response);
		     }
	}

}

