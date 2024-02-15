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

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		   PrintWriter writer = response.getWriter();
		   
		   HttpSession session = request.getSession(false);

	if(session!=null&&session.getAttribute("user")!=null) {
		
		UserDTO dto=(UserDTO) session.getAttribute("user");
		
		writer.print("<form action='UpdareServlet' method='post'>"+

              "<input type='hidden' name='username' value='"+dto.getUsername()+"'><br>"
              
+"<input type='hidden' name='password' value='"+dto.getPassword()+"'><br>"+
"<input type='text' name='address' value='"+dto.getAddress()+"'><br>"+
"<input type='number' name='phone' value='"+dto.getPhone()+"'><br>"+
"<input type='submit' value='Update'><br>"+
"</form>)");
		
		//writer.print(dto.getUsername()+"<br>");
		//writer.print(dto.getPassword()+"<br>");
		//writer.print(dto.getAddress()+"<br>");
		//writer.print(dto.getPhone()+"<br>");
		//Object object = session.getAttribute("user");
		//UserDTO dto=(UserDTO) object;
	}else {
		writer.print("please login first");
		request.getRequestDispatcher("login.html").include(request, response);
	}
	}
 }
