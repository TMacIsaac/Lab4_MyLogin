/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author 838771
 */
public class User {
    
    private String username;
    private String password;
    
    public User(String username){
        this.username = username;
        password = null;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
   public String getUsername(){
       return username;
   }
}
