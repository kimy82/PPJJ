package login.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	private String userName;
	private String password;
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) { 
		    
		ActionErrors errors = new ActionErrors(); 
		    
		if (userName == null || userName.length() < 1) { 
		        
		errors.add("userName", new ActionMessage("error.userName.required")); 
		    
		} 
		    
		if (password == null || password.length() < 1) { 
		        
		errors.add("password", new ActionMessage("error.password.required")); 
		    
		} 
		    
		return errors; 
		}
}
