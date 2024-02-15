package com.theone.smm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.theone.smm.UserDTO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter writer = response.getWriter();
		   
		   String username = request.getParameter("username");
		   String password = request.getParameter("password");
		   
		   if(username.equals("azam")&&password.equals("1234")) {
			   HttpSession session = request.getSession(true);
			   UserDTO dto=new UserDTO();
			   dto.setUsername(username);
			   dto.setPassword(password);
			   dto.setAddress("west bangal");
			   dto.setPhone(7336363636l);
			   session.setAttribute("user", dto);
			   writer.print("Login successfull");
		   }else {
			   writer.print("login failed");
		   }
	}

}
