/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;


public class mensajeg {
    int id;
    empleados id_empleado;
    String descripcion;
    Date fecha;

    public mensajeg() {
    }

    public mensajeg(int id, empleados id_empleado, String descripcion, Date fecha) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public empleados getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(empleados id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
