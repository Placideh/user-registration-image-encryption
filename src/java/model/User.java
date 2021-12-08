/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jumpman
 */
public interface User {
    public Boolean register(String username, String firstName,String lastName, String password,String  age,String  sex, String phoneNumber, Role role);
    public Boolean login(String username,String password);
}
