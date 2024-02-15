package com.theone.pnam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.theone.pnam.model.ProductDTO;

public class ProductDAO {

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase?user=root&password=root");
			
			return connection;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} 
		
	}
		
	
	
	public void add(ProductDTO dto) {
		try {	
			Connection connection=getConnection();
			
			PreparedStatement prepareStatement = connection.prepareStatement("insert into productt values(?,?,?,?)");
			prepareStatement.setInt(1, dto.getId());
			prepareStatement.setString(2, dto.getName());
			prepareStatement.setInt(3, dto.getPrice());
			prepareStatement.setString(4, dto.getBrand());
			prepareStatement.execute();
			System.out.println("data added");
			
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<ProductDTO> getProducts() {
		Connection connection=getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select*  from productt");
			
			List<ProductDTO> list=new ArrayList<>();
			
			
			 while(resultSet.next()) {
				 ProductDTO dto=new ProductDTO();
				 dto.setId(resultSet.getInt("id"));
				 dto.setName(resultSet.getString("name"));
				 dto.setPrice(resultSet.getInt("price"));
				 dto.setBrand(resultSet.getString("brand"));
				 list.add(dto);
				  
				// System.out.println( resultSet.getInt("id")+" "+ resultSet.getString("name")+" "
			   //+ resultSet.getInt("price")+" "+ resultSet.getString("brand")  );
			 }
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	
	}



	public ProductDTO editProduct(int id) {
		Connection connection=getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select* from productt where id=?");
			 prepareStatement.setInt(1, id);
			 ResultSet resultSet = prepareStatement.executeQuery();
			 resultSet.next();
			 ProductDTO dto=new ProductDTO();
			 dto.setId(resultSet.getInt("id"));
			 dto.setName(resultSet.getString("name"));
			 dto.setPrice(resultSet.getInt("price"));
			 dto.setBrand(resultSet.getString("brand"));
			 return dto;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}



	public int update(ProductDTO dto) {
		Connection connection=getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("update productt set name=?, price=? ,brand=? where id=?");
			
			prepareStatement.setString(1, dto.getName());
			prepareStatement.setInt(2, dto.getPrice());
			prepareStatement.setString(3, dto.getBrand());
			prepareStatement.setInt(4, dto.getId());
			int update = prepareStatement.executeUpdate();
			return update;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	
}
