package com.templateproject.api.controller.payload;
/**
 * *
 * @author smaile
 *
 */
public class PlayerRegister {
	 	private String username;
	    private String email;
	    private String password;
	    private String cpassword;
	    
	    
		public PlayerRegister() {}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCpassword() {
			return cpassword;
		}
		public void setCpassword(String cpassword) {
			this.cpassword = cpassword;
		}  
}
