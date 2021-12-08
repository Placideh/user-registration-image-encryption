/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.LinkedHashMap;
import model.Guest;

/**
 *
 * @author jumpman
 */
public class UserDao {
    static LinkedHashMap<String, Guest> userRepo=new LinkedHashMap<>();
    
    public static void saveUser(Guest user){
	String password=hashPassword(user.getPassword());
	user.setPassword(password);
	userRepo.put(user.getUsername(), user);
    }
    
    public static Boolean login(String username,String password){
	String plainPassword=reverseHashed(password);
	if(userRepo.containsKey(username)&&userRepo.containsValue(plainPassword))
	    return true;
	return false;
    }
    
     //the method reverses the string and append two stars front and back plus the age of the user
    private static String hashPassword(String password){
	String age="21";
	String end="**";
	String symbols=age+"**";
	 StringBuilder sb=new StringBuilder(password+end);  
	 sb.reverse();  
	 return sb.toString()+symbols;  
    }
    //the method returns back the hashed password to normal plain text.
    private static String reverseHashed(String password){
	StringBuilder sb=new StringBuilder(password);  
	String hashed=sb.reverse().toString();  
	String removeSymbols=hashed.substring(4,hashed.length()-2);
	return removeSymbols;
    }
    public static void main(String[] args) {
	System.out.println(hashPassword("hel126"));
	System.out.println(reverseHashed(hashPassword("hel126")));
    }
}
