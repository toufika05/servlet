package com.theone.pnam.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

import com.theone.pnam.dao.ProductDAO;
import com.theone.pnam.model.ProductDTO;


@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		
		ProductDAO dao=new ProductDAO();
		List<ProductDTO> dtos=dao.getProducts();
		
writer.print("<h3 align='center'><table border='1'>"+    
    "<tr>"+
       "<th>product name</th>"+ 
       "<th>product price</th>"+ 
       "<th>Brand name</th>"+
       "<th>Edit/Update</th>"+
       "<th>Delete</th>"+
       
       "</tr>");
 
for(ProductDTO dto : dtos) {
	writer.print(
      "<tr>"+
         "<td>"+dto.getName()+"</td>"+
         "<td>"+dto.getPrice()+"</td>"+ 
         "<td>"+dto.getBrand()+"</td>"+
         "<td><a href='EditServlet?id="+dto.getId()+"'>Edit</a></td>"+
         "<td><a href='DeleteServlet?id="+dto.getId()+"'>Delete</a></td>"+ 
         
    "</tr>");
	}

writer.print("</table></h3>");
	}

}
 












