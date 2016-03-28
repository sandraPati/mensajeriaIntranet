/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;

public class users {
    String nif;
    String usuario;
    String contrasenna;
    String contrasenna2;
    int estado;
    String email;
    private Roles rol;
    
    String correoUsuario;
    String correoContreasenna;
    
    public users() {
    }

    public users(String nif, String usuario, String contrasenna, String contrasenna2, int estado, String email, Roles rol, String correoUsuario, String correoContreasenna) {
        this.nif = nif;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.contrasenna2 = contrasenna2;
        this.estado = estado;
        this.email = email;
        this.rol = rol;
        this.correoUsuario = correoUsuario;
        this.correoContreasenna = correoContreasenna;
    }

    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna2() {
        return contrasenna2;
    }

    public void setContrasenna2(String contrasenna2) {
        this.contrasenna2 = contrasenna2;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getCorreoContreasenna() {
        return correoContreasenna;
    }

    public void setCorreoContreasenna(String correoContreasenna) {
        this.correoContreasenna = correoContreasenna;
    }

    
    
}
