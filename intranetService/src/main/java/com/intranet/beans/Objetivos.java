/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class Objetivos {
   int id;
   String nif_empleado;
   int num_visitas;
   int num_presupuesto;
   int num_contratos;
   Double importe;

    public Objetivos() {
    }

    public Objetivos(int id, String nif_empleado, int num_visitas, int num_presupuesto, int num_contratos, Double importe) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.num_visitas = num_visitas;
        this.num_presupuesto = num_presupuesto;
        this.num_contratos = num_contratos;
        this.importe = importe;
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

    public int getNum_visitas() {
        return num_visitas;
    }

    public void setNum_visitas(int num_visitas) {
        this.num_visitas = num_visitas;
    }

    public int getNum_presupuesto() {
        return num_presupuesto;
    }

    public void setNum_presupuesto(int num_presupuesto) {
        this.num_presupuesto = num_presupuesto;
    }

    public int getNum_contratos() {
        return num_contratos;
    }

    public void setNum_contratos(int num_contratos) {
        this.num_contratos = num_contratos;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
   
   
   
}
