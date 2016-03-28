/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class proyecto_presupuestos {
    int id;
	presupuesto id_presupuesto;
	int num_trabajadores;
	int numhoras;
	boolean estado;

    public proyecto_presupuestos() {
    }

    public proyecto_presupuestos(int id, presupuesto id_presupuesto, int num_trabajadores, int numhoras, boolean estado) {
        this.id = id;
        this.id_presupuesto = id_presupuesto;
        this.num_trabajadores = num_trabajadores;
        this.numhoras = numhoras;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public presupuesto getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(presupuesto id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public int getNum_trabajadores() {
        return num_trabajadores;
    }

    public void setNum_trabajadores(int num_trabajadores) {
        this.num_trabajadores = num_trabajadores;
    }

    public int getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(int numhoras) {
        this.numhoras = numhoras;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
        
        
}
