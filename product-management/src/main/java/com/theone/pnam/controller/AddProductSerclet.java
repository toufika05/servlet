package com.theone.pnam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.theone.pnam.dao.ProductDAO;
import com.theone.pnam.model.ProductDTO;

@WebServlet("/AddProductSerclet")
public class AddProductSerclet extends HttpServlet {
	
	int id;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		String price1 = request.getParameter("price");
		int price=Integer.parseInt(price1);
		String brand = request.getParameter("brand");
		
		
		ProductDTO dto=new ProductDTO(++id, name, price, brand); 
		
		ProductDAO dao=new ProductDAO();
		dao.add(dto);
		
	} 

}
