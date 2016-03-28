/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.Roles;
import com.intranet.beans.users;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws BadCredentialsException, 
            UsernameNotFoundException, DataAccessException {
        
        userName = userName.trim();

        if (userName.isEmpty()) {
            throw new BadCredentialsException("El nombre del usuario esta en blanco.");
        }

        userName = userName.replaceAll("Ã±", "ñ");

        if (userName.endsWith("@")) {
            userName = userName.substring(0, userName.length() - 1);
        }
        users usuario = usuarioService.getByLogin(userName);
        Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        //for(Roles role:usuario.getRol()){
            //System.out.println(role.getRolName());
            authorities.add(new GrantedAuthorityImpl(usuario.getRol().getRolName()));
        //}
        if (usuario != null) {
            System.out.println(String.format("Iniciando sesión como %s", userName));
            return new User(usuario.getUsuario(), usuario.getContrasenna(), true, true, true, true, authorities);
        }
        throw new BadCredentialsException("Los datos ingresados son incorrectos.");
    }
}
