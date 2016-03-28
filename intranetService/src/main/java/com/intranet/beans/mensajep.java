/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;
import java.sql.Time;


public class mensajep {
    int id;
    String nifEmisor;
    String nifReceptor;
    String asunto;
    String nif_emisor;
    String nif_receptor;
    Date fecha;
    Time hora;
    String nombrefotografia;
    String nombreEmisor;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNifEmisor() {
        return nifEmisor;
    }

    public void setNifEmisor(String nifEmisor) {
        this.nifEmisor = nifEmisor;
    }

    public String getNifReceptor() {
        return nifReceptor;
    }

    public void setNifReceptor(String nifReceptor) {
        this.nifReceptor = nifReceptor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNif_emisor() {
        return nif_emisor;
    }

    public void setNif_emisor(String nif_emisor) {
        this.nif_emisor = nif_emisor;
    }

    public String getNif_receptor() {
        return nif_receptor;
    }

    public void setNif_receptor(String nif_receptor) {
        this.nif_receptor = nif_receptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public mensajep() {
    }

    public mensajep(int id, String nifEmisor, String nifReceptor, String asunto, String nif_emisor, String nif_receptor, Date fecha, Time hora) {
        this.id = id;
        this.nifEmisor = nifEmisor;
        this.nifReceptor = nifReceptor;
        this.asunto = asunto;
        this.nif_emisor = nif_emisor;
        this.nif_receptor = nif_receptor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombrefotografia() {
        return nombrefotografia;
    }

    public void setNombrefotografia(String nombrefotografia) {
        this.nombrefotografia = nombrefotografia;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }
    
    
}
