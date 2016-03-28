/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;
import java.util.List;

public class empleados {
    String nif;
    String nombre;
    String apellidos;
    Date fecha_nacimiento;
    String direccion;
    String pais;
    String provincia;
    String poblacion;
    String codigo_postal;
    String estado;
    String telefono;
    String otro_telefono;
    String email;
    String otro_email;
    String numero_seguridad_social;
    String doba;
    Date fecha_alta;
    String observacion;
    String usuario;
    String contrasenna;
     String contrasenna2;
    perfiles id_perfil;
    boolean sesion;
    String numero_afiliacionss;
    String nivel_formativo;
    String nacionalidad;
    String nombrefotografia;
    Byte fotografia;
    perfil_profesional perfilprof;
    oficios oficio;
    String permiso_conducir;
    String vehiculo_propio;
    String autonomo;
    String presencia;
    String nombrepresencia;
    String nombrecv;
    Byte cv;
    String tamanofoto;
    String genero;
    
    String otroperfilprofesional;
    int estadoaltabaja;
    int inicioS;
private List<Roles> rol;

public List<Roles> getRol() {
        return rol;
    }

    public void setRol(List<Roles> rol) {
        this.rol = rol;
    }
    
    public empleados() {
    }

    public empleados(String nif, String nombre, String apellidos, Date fecha_nacimiento, String direccion, String pais, String provincia, String poblacion, String codigo_postal, String estado, String telefono, String otro_telefono, String email, String otro_email, String numero_seguridad_social, String doba, Date fecha_alta, String observacion, String usuario, String contrasenna, perfiles id_perfil, boolean sesion, String numero_afiliacionss, String nivel_formativo, String nacionalidad, String nombrefotografia, Byte fotografia, perfil_profesional perfilprof, oficios oficio, String permiso_conducir, String vehiculo_propio, String autonomo, String presencia, String nombrepresencia, String nombrecv, Byte cv, String tamanofoto, String genero,int estadoaltabaja) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.pais = pais;
        this.provincia = provincia;
        this.poblacion = poblacion;
        this.codigo_postal = codigo_postal;
        this.estado = estado;
        this.telefono = telefono;
        this.otro_telefono = otro_telefono;
        this.email = email;
        this.otro_email = otro_email;
        this.numero_seguridad_social = numero_seguridad_social;
        this.doba = doba;
        this.fecha_alta = fecha_alta;
        this.observacion = observacion;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.id_perfil = id_perfil;
        this.sesion = sesion;
        this.numero_afiliacionss = numero_afiliacionss;
        this.nivel_formativo = nivel_formativo;
        this.nacionalidad = nacionalidad;
        this.nombrefotografia = nombrefotografia;
        this.fotografia = fotografia;
        this.perfilprof = perfilprof;
        this.oficio = oficio;
        this.permiso_conducir = permiso_conducir;
        this.vehiculo_propio = vehiculo_propio;
        this.autonomo = autonomo;
        this.presencia = presencia;
        this.nombrepresencia = nombrepresencia;
        this.nombrecv = nombrecv;
        this.cv = cv;
        this.tamanofoto = tamanofoto;
        this.genero = genero;
        this.estadoaltabaja=estadoaltabaja;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getOtro_email() {
        return otro_email;
    }

    public void setOtro_email(String otro_email) {
        this.otro_email = otro_email;
    }

    public String getNumero_seguridad_social() {
        return numero_seguridad_social;
    }

    public void setNumero_seguridad_social(String numero_seguridad_social) {
        this.numero_seguridad_social = numero_seguridad_social;
    }

    public String getDoba() {
        return doba;
    }

    public void setDoba(String doba) {
        this.doba = doba;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public perfiles getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(perfiles id_perfil) {
        this.id_perfil = id_perfil;
    }

    public boolean isSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
    }

    public String getNumero_afiliacionss() {
        return numero_afiliacionss;
    }

    public void setNumero_afiliacionss(String numero_afiliacionss) {
        this.numero_afiliacionss = numero_afiliacionss;
    }

    public String getNivel_formativo() {
        return nivel_formativo;
    }

    public void setNivel_formativo(String nivel_formativo) {
        this.nivel_formativo = nivel_formativo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombrefotografia() {
        return nombrefotografia;
    }

    public void setNombrefotografia(String nombrefotografia) {
        this.nombrefotografia = nombrefotografia;
    }

    public Byte getFotografia() {
        return fotografia;
    }

    public void setFotografia(Byte fotografia) {
        this.fotografia = fotografia;
    }

    public perfil_profesional getPerfilprof() {
        return perfilprof;
    }

    public void setPerfilprof(perfil_profesional perfilprof) {
        this.perfilprof = perfilprof;
    }

    public oficios getOficio() {
        return oficio;
    }

    public void setOficio(oficios oficio) {
        this.oficio = oficio;
    }

    public String getPermiso_conducir() {
        return permiso_conducir;
    }

    public void setPermiso_conducir(String permiso_conducir) {
        this.permiso_conducir = permiso_conducir;
    }

    public String getVehiculo_propio() {
        return vehiculo_propio;
    }

    public void setVehiculo_propio(String vehiculo_propio) {
        this.vehiculo_propio = vehiculo_propio;
    }

    public String getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(String autonomo) {
        this.autonomo = autonomo;
    }

    public String getPresencia() {
        return presencia;
    }

    public void setPresencia(String presencia) {
        this.presencia = presencia;
    }

    public String getNombrepresencia() {
        return nombrepresencia;
    }

    public void setNombrepresencia(String nombrepresencia) {
        this.nombrepresencia = nombrepresencia;
    }

    public String getNombrecv() {
        return nombrecv;
    }

    public void setNombrecv(String nombrecv) {
        this.nombrecv = nombrecv;
    }

    public Byte getCv() {
        return cv;
    }

    public void setCv(Byte cv) {
        this.cv = cv;
    }

    public String getTamanofoto() {
        return tamanofoto;
    }

    public void setTamanofoto(String tamanofoto) {
        this.tamanofoto = tamanofoto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasenna2() {
        return contrasenna2;
    }

    public void setContrasenna2(String contrasenna2) {
        this.contrasenna2 = contrasenna2;
    }

    public String getOtroperfilprofesional() {
        return otroperfilprofesional;
    }

    public void setOtroperfilprofesional(String otroperfilprofesional) {
        this.otroperfilprofesional = otroperfilprofesional;
    }

    public int getEstadoaltabaja() {
        return estadoaltabaja;
    }

    public void setEstadoaltabaja(int estadoaltabaja) {
        this.estadoaltabaja = estadoaltabaja;
    }

    public int getInicioS() {
        return inicioS;
    }

    public void setInicioS(int inicioS) {
        this.inicioS = inicioS;
    }
    
    
}
