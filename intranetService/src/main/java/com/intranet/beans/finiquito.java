/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;


public class finiquito {
    int id;
    String nif_empleado;
    int id_contrato;
    Date fecha;
    float monto;

    public finiquito() {
    }

    public finiquito(int id, String nif_empleado, int id_contrato, Date fecha, float monto) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.id_contrato = id_contrato;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif_empleado() {
        return nif_empleado;
    }

    public void setNif_empleado(String nif_empleado) {
        this.nif_empleado = nif_empleado;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    
    
}
