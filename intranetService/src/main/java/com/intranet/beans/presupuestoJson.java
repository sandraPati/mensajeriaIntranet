/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.io.Serializable;
import java.util.List;

public class presupuestoJson implements Serializable{
    int propuesta_id;
    int idCap;    
    int idSubCap;
    String tipoCantidad;
    List<presupuesto> lta;
    public presupuestoJson() {
    }

    public presupuestoJson(int propuesta_id, int idCap, int idSubCap, String tipoCantidad) {
        this.propuesta_id = propuesta_id;
        this.idCap = idCap;
        this.idSubCap = idSubCap;
        this.tipoCantidad = tipoCantidad;
    }

    public int getPropuesta_id() {
        return propuesta_id;
    }

    public void setPropuesta_id(int propuesta_id) {
        this.propuesta_id = propuesta_id;
    }

    public int getIdCap() {
        return idCap;
    }

    public void setIdCap(int idCap) {
        this.idCap = idCap;
    }

    public int getIdSubCap() {
        return idSubCap;
    }

    public void setIdSubCap(int idSubCap) {
        this.idSubCap = idSubCap;
    }

    public String getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(String tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    public List<presupuesto> getLta() {
        return lta;
    }

    public void setLta(List<presupuesto> lta) {
        this.lta = lta;
    }
    
    
}
