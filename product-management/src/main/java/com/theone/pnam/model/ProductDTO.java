package com.theone.pnam.model;

public class ProductDTO {
	private int id;
	private String name;
	private int price;
	private String brand;
	
	   public void setId(int id) {
		   this.id=id;
		
		}
	   public int getId() {
		   return id;
	   }
	   public void setName(String name) {
		   this.name=name;
		
		}
	   public String getName() {
		   return name;
	   }
	   public void setPrice(int price) {
		   this.price=price;
		
		}
	   public int getPrice() {
		   return price;
	   }
	   public void setBrand(String brand) {
		   this.brand=brand;
		
		}
	   public String getBrand() {
		   return brand;
	   }
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int id, String name, int price, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}

}
