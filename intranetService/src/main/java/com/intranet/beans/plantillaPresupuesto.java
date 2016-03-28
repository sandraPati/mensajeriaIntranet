/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class plantillaPresupuesto {
    int id;
    int propuesta_id;
    String descripcion;

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

    

    public plantillaPresupuesto() {
    }

    public plantillaPresupuesto(int id, int propuesta_id, String descripcion) {
        this.id = id;
        this.propuesta_id = propuesta_id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
    
}
