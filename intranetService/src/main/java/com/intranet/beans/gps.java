/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class gps {
    int id;
    String nif_user;
    String direccion;
    String lat;
    String longitud;
    String fecha;
    String hora;
    String turno;
    public gps() {
    }

    public gps(int id, String nif_user, String direccion, String lat, String longitud, String fecha, String hora) {
        this.id = id;
        this.nif_user = nif_user;
        this.direccion = direccion;
        this.lat = lat;
        this.longitud = longitud;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif_user() {
        return nif_user;
    }

    public void setNif_user(String nif_user) {
        this.nif_user = nif_user;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
}
