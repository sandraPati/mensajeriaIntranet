/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;


public class clientes {
    String nif;
    String nombre;
    String apellidos;
    String direccion;
    String pais;
    String codigo_postal;
    String provincia;
    String poblacion;
    String nacionalidad;
    String telefono;
    String otro_telefono;
    String email;
    String usuario;
    String contrsenna;
    String contrasenna1;
    Date fecharegistro;
    public clientes() {
    }

    public clientes(String nif, String nombre, String apellidos, String direccion, String pais, String codigo_postal, String provincia, String poblacion, String nacionalidad, String telefono, String otro_telefono, String email, String usuario, String contrsenna, String contrasenna1) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.pais = pais;
        this.codigo_postal = codigo_postal;
        this.provincia = provincia;
        this.poblacion = poblacion;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.otro_telefono = otro_telefono;
        this.email = email;
        this.usuario = usuario;
        this.contrsenna = contrsenna;
        this.contrasenna1 = contrasenna1;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOtro_telefono() {
        return otro_telefono;
    }

    public void setOtro_telefono(String otro_telefono) {
        this.otro_telefono = otro_telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrsenna() {
        return contrsenna;
    }

    public void setContrsenna(String contrsenna) {
        this.contrsenna = contrsenna;
    }

    public String getContrasenna1() {
        return contrasenna1;
    }

    public void setContrasenna1(String contrasenna1) {
        this.contrasenna1 = contrasenna1;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    
}
