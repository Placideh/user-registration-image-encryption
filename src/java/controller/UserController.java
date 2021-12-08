/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.Guest;
import model.Role;
import model.User;

/**
 *
 * @author jumpman
 */
@WebServlet(name = "UserController", urlPatterns = {"/register"})
public class UserController extends HttpServlet {
     private Map<String,String>errors;
     private final Integer GUEST_PASSWORD_SIZE=5;
     private final Integer ADMIN_PASSWORD_SIZE=10;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//getting all data from view via parameters
	String username=req.getParameter("username").trim();
	String firstName=req.getParameter("firstName").trim();
	String lastName=req.getParameter("lastName").trim();
	String password=req.getParameter("password").trim();
	String age=req.getParameter("age").trim();
	String sex=req.getParameter("sex").trim();
	String phoneNumber=req.getParameter("phone").trim();
	String role=req.getParameter("role").trim();
	
	try{
	    Boolean checkValid=isUserValid(username, password, firstName, lastName, age, phoneNumber, sex, role);
	    if(checkValid)userRegistry(username, password, firstName, lastName, age, phoneNumber, sex, role, req, resp);
	}catch(IllegalArgumentException ex){
	    errors.put("global", ex.getMessage());
	    req.getSession().setAttribute("error", errors);
	    resp.sendRedirect("index.jsp");
	    
	}
	
    }
   
    //login method which returns a view according to entered password and username
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("username").trim();
	String password=req.getParameter("password").trim();
	try{
	    Boolean logins=loginValidation(username, password);
	    if(logins)
		checkValidLogin(username, password, req, resp);
	    
	}catch(IllegalArgumentException ex){
	    errors.put("global", ex.getMessage());
	    req.getSession().setAttribute("error", errors);
	    resp.sendRedirect("login.jsp");
	    
	}
	
	
    }
     private void userRegistry(String username,String password
	    ,String firstName,String lastName,
	    String age,String phoneNumber,
	    String sex,String role,
	    HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//checking user role and password
		User user=null;
		Boolean registered=false;
		if(role.equals("GUEST")){
		    user=new Guest();
		    
		    
		}else if(role.equals("ADMIN")){
		    user=new Admin();
		}
		registered=user.register(username, firstName,lastName, password, age, sex, phoneNumber, Role.valueOf(role));
		System.out.println(registered);
		resp.sendRedirect("login.jsp");
		String message=registered ? " User Registered ":" Password rules not met";
		    
    

    }
    private Boolean isUserValid(String username,String password
	    ,String firstName,String lastName,
	    String age,String phoneNumber,
	    String sex,String role){
	    errors=new HashMap<>();
	    if(username.isEmpty())errors.put("username","username must be filled");
	    if(password.isEmpty()||(password.length()!=5&&password.length()!=10))errors.put("password","password rules not met");
	    if(password.length()==5&& role.equals("ADMIN"))errors.put("password","Password rules not met");
	    if(password.length()==10&&role.equals("GUEST")) errors.put("password","Password rules not met");
	    if(firstName.isEmpty())errors.put("firstName","firstName must be filled");
	    if(lastName.isEmpty())errors.put("lastName","lastName must be filled");
	    if(age.isEmpty()|| !age.matches("[0-9]+"))errors.put("age","age must be filled or be a number");
	    if(phoneNumber.isEmpty()||!phoneNumber.matches("[0-9]+"))errors.put("phoneNumber","phoneNumber must be filled or be a number");
	    if(sex.isEmpty())errors.put("gender","gender must be selected");
	    if(role.toString().isEmpty())errors.put("role","role must be selected");
	    if(errors.isEmpty()){
		return true;
	    }
	    throw new IllegalArgumentException("one or more fields contains an error");
    }
    private void checkValidLogin(String username ,String password,
				HttpServletRequest req, HttpServletResponse resp) throws IOException{
	User user=null;
	if(password.length()==GUEST_PASSWORD_SIZE){
	     user=new Guest();
	   Boolean logins= user.login(username, password);
	    if(logins){
		resp.sendRedirect("profile.jsp?username="+username);
	    }else{
		errors.put("global", "Invalid username/password");
		req.getSession().setAttribute("error", errors);
		resp.sendRedirect("login.jsp");
	    }
	    
	}else if(password.length()==ADMIN_PASSWORD_SIZE){
	     user=new Admin();
	    Boolean logins=user.login(username, password);
	     if(logins){
		resp.sendRedirect("profile2.jsp?username="+username);
	    }else{
		 errors.put("global", "Invalid username/password");
		req.getSession().setAttribute("error", errors);
		resp.sendRedirect("login.jsp");
	    }
	}else {
	    errors.put("global", "Invalid username/password");
	    req.getSession().setAttribute("error", errors);
	    resp.sendRedirect("login.jsp");
	}
	
    }
    private Boolean loginValidation(String username,String password){
	errors=new HashMap<>();
	    if(username.isEmpty())errors.put("username","username must be filled");
	    if(password.isEmpty())errors.put("password","password must be filled");
	    if(errors.isEmpty()){
		return true;
	    }
	    throw new IllegalArgumentException("one or more field contains ");
    }
    
}
