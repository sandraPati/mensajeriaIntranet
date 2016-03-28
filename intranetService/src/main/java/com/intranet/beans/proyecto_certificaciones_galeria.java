/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class proyecto_certificaciones_galeria {
    int id;
	proyecto_certificaciones id_proyecto_certificaciones;
	String nombreimg;
	Byte foto;
	Date fecha;
	String ruta;
        int idPropuesta;
    public proyecto_certificaciones_galeria() {
    }

    public proyecto_certificaciones_galeria(int id, proyecto_certificaciones id_proyecto_certificaciones, String nombreimg, Byte foto, String ruta) {
        this.id = id;
        this.id_proyecto_certificaciones = id_proyecto_certificaciones;
        this.nombreimg = nombreimg;
        this.foto = foto;
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public proyecto_certificaciones getId_proyecto_certificaciones() {
        return id_proyecto_certificaciones;
    }

    public void setId_proyecto_certificaciones(proyecto_certificaciones id_proyecto_certificaciones) {
        this.id_proyecto_certificaciones = id_proyecto_certificaciones;
    }

    public String getNombreimg() {
        return nombreimg;
    }

    public void setNombreimg(String nombreimg) {
        this.nombreimg = nombreimg;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
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

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }
        
        
}
