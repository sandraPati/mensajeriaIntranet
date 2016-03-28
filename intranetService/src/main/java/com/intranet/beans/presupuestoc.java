/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;
import java.util.List;

public class presupuestoc {
    int id;
    int propuesta_id;
    int capitulo_id;
    capitulos cap;
    int estadoenviado;
    Date fecha;
    List<presupuesto> ltaPresup;

    public presupuestoc() {
    }

    public presupuestoc(int id, int propuesta_id, int capitulo_id, capitulos cap, int estadoenviado, Date fecha, List<presupuesto> ltaPresup) {
        this.id = id;
        this.propuesta_id = propuesta_id;
        this.capitulo_id = capitulo_id;
        this.cap = cap;
        this.estadoenviado = estadoenviado;
        this.fecha = fecha;
        this.ltaPresup = ltaPresup;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropuesta_id() {
        return propuesta_id;
    }

    public void setPropuesta_id(int propuesta_id) {
        this.propuesta_id = propuesta_id;
    }

    public int getCapitulo_id() {
        return capitulo_id;
    }

    public void setCapitulo_id(int capitulo_id) {
        this.capitulo_id = capitulo_id;
    }

    public capitulos getCap() {
        return cap;
    }

    public void setCap(capitulos cap) {
        this.cap = cap;
    }

    public int getEstadoenviado() {
        return estadoenviado;
    }

    public void setEstadoenviado(int estadoenviado) {
        this.estadoenviado = estadoenviado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<presupuesto> getLtaPresup() {
        return ltaPresup;
    }

    public void setLtaPresup(List<presupuesto> ltaPresup) {
        this.ltaPresup = ltaPresup;
    }

    
    
}
