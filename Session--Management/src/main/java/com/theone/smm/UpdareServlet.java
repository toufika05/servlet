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


@WebServlet("/UpdareServlet")
public class UpdareServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   PrintWriter writer = response.getWriter();
		   
		   HttpSession session = request.getSession(false);
		   UserDTO dto=(UserDTO) session.getAttribute("user");
		   
		   String username = request.getParameter("username");
		   String password = request.getParameter("password");
		   
		   if(username.equals("azam")&&password.equals("1234")){
			   String address = request.getParameter("address");
			   String phone = request.getParameter("phone");
			   long phone1=Long.parseLong(phone);
			   dto.setAddress(address);
			   dto.setPhone(phone1);
			   writer.print(dto.getUsername()+"our profile has been updated");
			   session.setAttribute("user", dto);
			   
			   
		   }else {
			   writer.print("please loginbn first");
		   }
		
	}

}
