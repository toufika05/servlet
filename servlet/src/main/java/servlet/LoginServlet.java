package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet{
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init() invoked");
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("service() invoked");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<h1>Hello from LoginServlet class</h1>");
	}


	@Override
	public void destroy() {
		System.out.println("destroy() invoked");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null; 
	}

	@Override
	public String getServletInfo() {
		return null;
	}


	

}
