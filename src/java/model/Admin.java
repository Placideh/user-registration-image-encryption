/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedHashMap;
import static model.Guest.userRepo;

/**
 *
 * @author jumpman
 */
public class Admin implements User{
     private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String age;
    private String sex;
    private String phoneNumber;
    private Role role;

    public Admin() {
    }
    static  LinkedHashMap<String, Object> userRepo=new LinkedHashMap<>();
   
    public Admin(String username, String firstName, String lastName, String password, String age, String sex, String phoneNumber, Role role) {
	this.username = username;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.age = age;
	this.sex = sex;
	this.phoneNumber = phoneNumber;
	this.role = role;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }
    

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getAge() {
	return age;
    }

    public void setAge(String age) {
	this.age = age;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "Admin{" + "username=" + username + ", firstName=" + firstName + ", password=" + password + ", age=" + age + ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", role=" + role + '}';
    }
    

    @Override
    public Boolean register(String username, String firstName,String lastName, String password,String  age,String  sex, String phoneNumber, Role role) {
	if(!password.matches("[0-9A-Za-z]{10}")){
	    return false;
	}
	String pass=hashPassword(password,age);

	setPassword(pass);
	setUsername(username);
	setFirstName(firstName);
	setAge(age);
	setLastName(lastName);
	setPhoneNumber(phoneNumber);
	setRole(role);
	setSex(sex);
	userRepo.put(username,this);
	
	return true;
    }

    @Override
    public Boolean login(String username, String password) {
	Admin obj = (Admin) userRepo.get(username);
	if(obj!=null){
	    String plainPassword = reverseHashed(obj.password);
	    if (password.equals(plainPassword)) {
	    return true;
	}
	}
	
	
	return false;
    }
     //the method reverses the string and append two stars front and back plus the age of the user

    private String hashPassword(String password, String age) {
	String end = "**";
	String symbols = age + "**";
	StringBuilder sb = new StringBuilder(password + end);
	sb.reverse();
	return sb.toString() + symbols;
    }

    //the method returns back the hashed password to normal plain text.
    private String reverseHashed(String password) {
	StringBuilder sb = new StringBuilder(password);
	String hashed = sb.reverse().toString();
	String removeSymbols = hashed.substring(4, hashed.length() - 2);
	return removeSymbols;
    }
   
    public LinkedHashMap<String, Object> getList(){
	return userRepo;
    }
    
}
