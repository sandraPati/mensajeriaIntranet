/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class metasEmpleado {
    int id;
    String nif_empleado;
    int numvisitas;
    int num_presupuesto;
    int num_contratos;
    Double importe;
    int mes;
    int anio;
    int meta1;
    int meta2;
    int meta3;
    Double meta4;
    float porcentaje1;
    float porcentaje2;
    float porcentaje3;
    double porcentaje4;
    public metasEmpleado() {
    }

    public metasEmpleado(int id, String nif_empleado, int numvisitas, int num_presupuesto, int num_contratos, Double importe, int mes, int anio, int meta1, int meta2, int meta3, Double meta4) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.numvisitas = numvisitas;
        this.num_presupuesto = num_presupuesto;
        this.num_contratos = num_contratos;
        this.importe = importe;
        this.mes = mes;
        this.anio = anio;
        this.meta1 = meta1;
        this.meta2 = meta2;
        this.meta3 = meta3;
        this.meta4 = meta4;
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

    public int getNumvisitas() {
        return numvisitas;
    }

    public void setNumvisitas(int numvisitas) {
        this.numvisitas = numvisitas;
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

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMeta1() {
        return meta1;
    }

    public void setMeta1(int meta1) {
        this.meta1 = meta1;
    }

    public int getMeta2() {
        return meta2;
    }

    public void setMeta2(int meta2) {
        this.meta2 = meta2;
    }

    public int getMeta3() {
        return meta3;
    }

    public void setMeta3(int meta3) {
        this.meta3 = meta3;
    }

    public Double getMeta4() {
        return meta4;
    }

    public void setMeta4(Double meta4) {
        this.meta4 = meta4;
    }

    public float getPorcentaje1() {
        return porcentaje1;
    }

    public void setPorcentaje1(float porcentaje1) {
        this.porcentaje1 = porcentaje1;
    }

    public float getPorcentaje2() {
        return porcentaje2;
    }

    public void setPorcentaje2(float porcentaje2) {
        this.porcentaje2 = porcentaje2;
    }

    public float getPorcentaje3() {
        return porcentaje3;
    }

    public void setPorcentaje3(float porcentaje3) {
        this.porcentaje3 = porcentaje3;
    }

    public double getPorcentaje4() {
        return porcentaje4;
    }

    public void setPorcentaje4(double porcentaje4) {
        this.porcentaje4 = porcentaje4;
    }
    
            
}
