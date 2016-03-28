/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("validaInterfacesRoles")
public class ValidaInterfacesRoles {
    public String valida(){
     try{
        String rpta="";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            int d=authorities.size();
            for(GrantedAuthority r:authorities){
                if(d==1){
                    if(r.getAuthority().equals("ROLE_ADMIN")){
                        System.out.println("role_ADMIN - menu1");
                        rpta="menu1";
                        return rpta; 
                    }else if(r.getAuthority().equals("ROLE_SUPERVISOR")){
                        System.out.println("role_SUPERVISOR - menu2");
                        rpta="menu2";
                        return rpta; 
                    }else if(r.getAuthority().equals("ROLE_EMPLEADO")){
                        System.out.println("role_EMPLEADO - menu3");
                        rpta="menu3";
                        return rpta; 
                    }else if(r.getAuthority().equals("ROLE_POSTULANTE")){
                        System.out.println("role_EMPLEADO - menu4");
                        rpta="menu4";
                        return rpta; 
                    }else if(r.getAuthority().equals("ROLE_CLIENTE")){
                        System.out.println("role_EMPLEADO - menu5");
                        rpta="menu5";
                        return rpta; 
                    }else if(r.getAuthority().equals("ROLE_PROVEEDOR")){
                        System.out.println("role_EMPLEADO - menu6");
                        rpta="menu6";
                        return rpta; 
                    }
                    
                }else if(d==2){
                    if(r.getAuthority().equals("ROLE_SUPERVISOR")){
                        System.out.println("role_SUPERVISOR - menu2");
                        rpta="menu2";
                        return rpta; 
                    }
                }else if(d==3){
                    if(r.getAuthority().equals("ROLE_ADMIN")){
                        System.out.println("role_ADMIN - menu1");
                        rpta="menu1";
                        return rpta; 
                    }
                }
                
            }           
            
        }
     }catch(Exception e){
         e.getMessage();
     }
    return "login";
     
    }
}
