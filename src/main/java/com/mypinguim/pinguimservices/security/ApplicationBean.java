/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypinguim.pinguimservices.security;

import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author ricar
 */

public class ApplicationBean {
    
    private static HashMap<String , User> map  = new HashMap<>();

    public static HashMap<String, User> getMap() {
        return map;
    }

    public static void setMap(HashMap<String, User> map) {
        ApplicationBean.map = map;
    }
    
    
}
