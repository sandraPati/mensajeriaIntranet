/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class proveedores {
    String cif;
    String num_cuenta;
	String nombre;
	String nombreFoto;
	Byte foto;
	String direccion;
	tipo_actividades id_actividad;
	String email;
	String telefono;
	String link;
	boolean estadoCalificado;
	
	Double latitud;
	Double longitud;
	Double lat;
	Double longt;
	int cantCalificacion;
        int id;
        String banco;
        String persona_contacto;
    //BinaryStream fotoI;
    boolean aprobado;
    
    
    String usuario;
    String contrasenna;
    String contrasenna2;
    
    Date fechaContrato;
    boolean visible;
    
    
    public proveedores() {
    }

    public proveedores(String cif, String num_cuenta, String nombre, String nombreFoto, Byte foto, String direccion, tipo_actividades id_actividad, String email, String telefono, String link, boolean estadoCalificado, Double latitud, Double longitud, Double lat, Double longt, int cantCalificacion, int id, String banco, String persona_contacto, boolean aprobado) {
        this.cif = cif;
        this.num_cuenta = num_cuenta;
        this.nombre = nombre;
        this.nombreFoto = nombreFoto;
        this.foto = foto;
        this.direccion = direccion;
        this.id_actividad = id_actividad;
        this.email = email;
        this.telefono = telefono;
        this.link = link;
        this.estadoCalificado = estadoCalificado;
        this.latitud = latitud;
        this.longitud = longitud;
        this.lat = lat;
        this.longt = longt;
        this.cantCalificacion = cantCalificacion;
        this.id = id;
        this.banco = banco;
        this.persona_contacto = persona_contacto;
        this.aprobado = aprobado;
    }

    

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public tipo_actividades getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(tipo_actividades id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getEstadoCalificado() {
        return estadoCalificado;
    }

    public void setEstadoCalificado(boolean estadoCalificado) {
        this.estadoCalificado = estadoCalificado;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongt() {
        return longt;
    }

    public void setLongt(Double longt) {
        this.longt = longt;
    }

    public int getCantCalificacion() {
        return cantCalificacion;
    }

    public void setCantCalificacion(int cantCalificacion) {
        this.cantCalificacion = cantCalificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getPersona_contacto() {
        return persona_contacto;
    }

    public void setPersona_contacto(String persona_contacto) {
        this.persona_contacto = persona_contacto;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
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

    public String getContrasenna2() {
        return contrasenna2;
    }

    public void setContrasenna2(String contrasenna2) {
        this.contrasenna2 = contrasenna2;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
        
        
}
