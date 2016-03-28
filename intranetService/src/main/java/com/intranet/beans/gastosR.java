/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;


public class gastosR {
    int id;
    String nombreimg;
    int idgasto;
    String ruta;
    Date fecha;
    public gastosR() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreimg() {
        return nombreimg;
    }

    public void setNombreimg(String nombreimg) {
        this.nombreimg = nombreimg;
    }

    public int getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
