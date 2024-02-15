package com.theone.cookiee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("un");
		
		if(request.getParameter("pw").equals("1234")) {
			
			
			Cookie ck=new Cookie("user",username);
			response.addCookie(ck);
			writer.print("Login successful  "+username);
			
		}
		else {
			writer.print("Login failed please try again");
		}
	}

}
