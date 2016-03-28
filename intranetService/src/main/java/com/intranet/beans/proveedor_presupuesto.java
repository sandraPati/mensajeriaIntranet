/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class proveedor_presupuesto {
    int id;
    int id_proveedor;
    String descripcion;
    Double monto=0.0;
    Double iva=0.0;
    String nota;
    int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public proveedor_presupuesto() {
    }

    public proveedor_presupuesto(int id, int id_proveedor, String descripcion, String nota, int estado) {
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.descripcion = descripcion;
        this.nota = nota;
        this.estado = estado;
    }
    
    
            
}
