/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;
import java.sql.Time;

public class relacion_mensajes {
    int id;
    int id_mgrupo;
    String asunto;
    empleados nif_amigog;
    Date fecha;
    Time hora;

    public relacion_mensajes() {
    }

    public relacion_mensajes(int id, int id_mgrupo, String asunto, empleados nif_amigog, Date fecha, Time hora) {
        this.id = id;
        this.id_mgrupo = id_mgrupo;
        this.asunto = asunto;
        this.nif_amigog = nif_amigog;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mgrupo() {
        return id_mgrupo;
    }

    public void setId_mgrupo(int id_mgrupo) {
        this.id_mgrupo = id_mgrupo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public empleados getNif_amigog() {
        return nif_amigog;
    }

    public void setNif_amigog(empleados nif_amigog) {
        this.nif_amigog = nif_amigog;
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
    
    
}
