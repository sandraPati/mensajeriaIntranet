/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class clasificaciones {
    int id;
	empleados empleado_nif;
	proveedores proveedor_numcuenta;
	int calificacion=0;
	String comentario;
        int calidadtrabajo=0;
        int limpiezaorden=0;
        int plazos=0;
        int cumplimiento=0;
    public clasificaciones() {
    }

    public clasificaciones(int id, empleados empleado_nif, proveedores proveedor_numcuenta, String comentario) {
        this.id = id;
        this.empleado_nif = empleado_nif;
        this.proveedor_numcuenta = proveedor_numcuenta;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public empleados getEmpleado_nif() {
        return empleado_nif;
    }

    public void setEmpleado_nif(empleados empleado_nif) {
        this.empleado_nif = empleado_nif;
    }

    public proveedores getProveedor_numcuenta() {
        return proveedor_numcuenta;
    }

    public void setProveedor_numcuenta(proveedores proveedor_numcuenta) {
        this.proveedor_numcuenta = proveedor_numcuenta;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalidadtrabajo() {
        return calidadtrabajo;
    }

    public void setCalidadtrabajo(int calidadtrabajo) {
        this.calidadtrabajo = calidadtrabajo;
    }

    public int getLimpiezaorden() {
        return limpiezaorden;
    }

    public void setLimpiezaorden(int limpiezaorden) {
        this.limpiezaorden = limpiezaorden;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    public int getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(int cumplimiento) {
        this.cumplimiento = cumplimiento;
    }
        
        
}
