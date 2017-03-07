/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypinguim.pinguimservices.security;

import com.mypinguim.pinguimservices.enumerated.Role;
import java.io.Serializable;
import javax.enterprise.inject.Model;

/**
 *
 * @author ricar
 */
@Model
public class User implements Serializable {

    private String username;
  
    private String password;
    
    private String token;

    private Role role;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    

}