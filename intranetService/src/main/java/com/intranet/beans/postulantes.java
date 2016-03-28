/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class postulantes {
    int id;
    perfil_profesional perfilprof;
    String nombre;
    String apellidos;
    String email;
    String usuario;
    String contrasenna;
    String contrasenna2;
    Boolean condiciones;
    String docuemnto_identidad;
    String genero;
    String pais;
    String provincia;
    String poblacion;
    String direccion;
    String codigo_postal;
    String telefono;
    String permisoconducir;
    String vehiculopropio;
    String autonomo;
    String nacionalidad;
    String presencia;
    String nombrepresencia;
    String nombrefotografia;
    Byte fotografia;
    String tamanofoto;
    String nombrecv;
    Byte cv;
    int estado;
    oficios oficio;
    String horaregistrado;
    String numero_afiliacionss;
    String nivel_formativo;
    Date fecha_nacimiento;
    
    String otroperfilprofesional;
    boolean estadoinf;
    Date fecharegistrado;
    
    public postulantes() {
    }

    public postulantes(int id, perfil_profesional perfilprof, String nombre, String apellidos, String email, String usuario, String contrasenna, Boolean condiciones, String docuemnto_identidad, String genero, String pais, String provincia, String poblacion, String direccion, String codigo_postal, String telefono, String permisoconducir, String vehiculopropio, String autonomo, String nacionalidad, String presencia, String nombrepresencia, String nombrefotografia, Byte fotografia, String tamanofoto, String nombrecv, Byte cv, int estado, oficios oficio, String horaregistrado, String numero_afiliacionss, String nivel_formativo, Date fecha_nacimiento) {
        this.id = id;
        this.perfilprof = perfilprof;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.condiciones = condiciones;
        this.docuemnto_identidad = docuemnto_identidad;
        this.genero = genero;
        this.pais = pais;
        this.provincia = provincia;
        this.poblacion = poblacion;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
        this.permisoconducir = permisoconducir;
        this.vehiculopropio = vehiculopropio;
        this.autonomo = autonomo;
        this.nacionalidad = nacionalidad;
        this.presencia = presencia;
        this.nombrepresencia = nombrepresencia;
        this.nombrefotografia = nombrefotografia;
        this.fotografia = fotografia;
        this.tamanofoto = tamanofoto;
        this.nombrecv = nombrecv;
        this.cv = cv;
        this.estado = estado;
        this.oficio = oficio;
        this.horaregistrado = horaregistrado;
        this.numero_afiliacionss = numero_afiliacionss;
        this.nivel_formativo = nivel_formativo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public perfil_profesional getPerfilprof() {
        return perfilprof;
    }

    public void setPerfilprof(perfil_profesional perfilprof) {
        this.perfilprof = perfilprof;
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

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Boolean getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(Boolean condiciones) {
        this.condiciones = condiciones;
    }

    public String getDocuemnto_identidad() {
        return docuemnto_identidad;
    }

    public void setDocuemnto_identidad(String docuemnto_identidad) {
        this.docuemnto_identidad = docuemnto_identidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPermisoconducir() {
        return permisoconducir;
    }

    public void setPermisoconducir(String permisoconducir) {
        this.permisoconducir = permisoconducir;
    }

    public String getVehiculopropio() {
        return vehiculopropio;
    }

    public void setVehiculopropio(String vehiculopropio) {
        this.vehiculopropio = vehiculopropio;
    }

    public String getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(String autonomo) {
        this.autonomo = autonomo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public String getTamanofoto() {
        return tamanofoto;
    }

    public void setTamanofoto(String tamanofoto) {
        this.tamanofoto = tamanofoto;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public oficios getOficio() {
        return oficio;
    }

    public void setOficio(oficios oficio) {
        this.oficio = oficio;
    }

    public String getHoraregistrado() {
        return horaregistrado;
    }

    public void setHoraregistrado(String horaregistrado) {
        this.horaregistrado = horaregistrado;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public boolean getEstadoinf() {
        return estadoinf;
    }

    public void setEstadoinf(boolean estadoinf) {
        this.estadoinf = estadoinf;
    }

    public Date getFecharegistrado() {
        return fecharegistrado;
    }

    public void setFecharegistrado(Date fecharegistrado) {
        this.fecharegistrado = fecharegistrado;
    }
    
    
}
