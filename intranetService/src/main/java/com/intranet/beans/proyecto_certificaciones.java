/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class proyecto_certificaciones {
    int id;
	proyecto_presupuestos id_proyecto_presupuesto;
	int porcentaje_terminado;
	float monto_semana;
	Date fecha;
	int numsemana;

    public proyecto_certificaciones() {
    }

    public proyecto_certificaciones(int id, proyecto_presupuestos id_proyecto_presupuesto, int porcentaje_terminado, float monto_semana, Date fecha, int numsemana) {
        this.id = id;
        this.id_proyecto_presupuesto = id_proyecto_presupuesto;
        this.porcentaje_terminado = porcentaje_terminado;
        this.monto_semana = monto_semana;
        this.fecha = fecha;
        this.numsemana = numsemana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public proyecto_presupuestos getId_proyecto_presupuesto() {
        return id_proyecto_presupuesto;
    }

    public void setId_proyecto_presupuesto(proyecto_presupuestos id_proyecto_presupuesto) {
        this.id_proyecto_presupuesto = id_proyecto_presupuesto;
    }

    public int getPorcentaje_terminado() {
        return porcentaje_terminado;
    }

    public void setPorcentaje_terminado(int porcentaje_terminado) {
        this.porcentaje_terminado = porcentaje_terminado;
    }

    public float getMonto_semana() {
        return monto_semana;
    }

    public void setMonto_semana(float monto_semana) {
        this.monto_semana = monto_semana;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumsemana() {
        return numsemana;
    }

    public void setNumsemana(int numsemana) {
        this.numsemana = numsemana;
    }
        
        
}
