package com.theone.smm;

public class UserDTO {
	  private  String username;
	   private  String password;
	   private String address;
	   private  long phone;
	   
	   public void setUsername(String username) {
		   this.username=username;
		
		}
	   public String getUsername() {
		   return username;
	   }
	   public void setPassword(String password) {
		   this.password=password;
		
		}
	   public String getPassword() {
		   return password;
	   }
	   public void setAddress(String address) {
		   this.address=address;
		
		}
	   public String getAddress() {
		   return address;
	   }
	   public void setPhone(long phone) {
		   this.phone=phone;
		
		}
	   public long getPhone() {
		   return phone;
	   }
}
