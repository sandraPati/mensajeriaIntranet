/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class ingresos {
    int id;
    formapago formapago_id;
    tipoingreso tipoingreso_id;
    Date fechapago;
    clientes cliente_nif;
    String refenrecia;
    String cuente_bancaria;
    Double totalbruto=0.0;
    Double porcentaje_irpf=0.0;
    int estado;
    String estadoingreso;

    public ingresos() {
    }

    public ingresos(int id, formapago formapago_id, tipoingreso tipoingreso_id, Date fechapago, clientes cliente_nif, String refenrecia, String cuente_bancaria, Double totalbruto, Double porcentaje_irpf, int estado, String estadoingreso) {
        this.id = id;
        this.formapago_id = formapago_id;
        this.tipoingreso_id = tipoingreso_id;
        this.fechapago = fechapago;
        this.cliente_nif = cliente_nif;
        this.refenrecia = refenrecia;
        this.cuente_bancaria = cuente_bancaria;
        this.totalbruto = totalbruto;
        this.porcentaje_irpf = porcentaje_irpf;
        this.estado = estado;
        this.estadoingreso = estadoingreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public formapago getFormapago_id() {
        return formapago_id;
    }

    public void setFormapago_id(formapago formapago_id) {
        this.formapago_id = formapago_id;
    }

    public tipoingreso getTipoingreso_id() {
        return tipoingreso_id;
    }

    public void setTipoingreso_id(tipoingreso tipoingreso_id) {
        this.tipoingreso_id = tipoingreso_id;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public clientes getCliente_nif() {
        return cliente_nif;
    }

    public void setCliente_nif(clientes cliente_nif) {
        this.cliente_nif = cliente_nif;
    }

    public String getRefenrecia() {
        return refenrecia;
    }

    public void setRefenrecia(String refenrecia) {
        this.refenrecia = refenrecia;
    }

    public String getCuente_bancaria() {
        return cuente_bancaria;
    }

    public void setCuente_bancaria(String cuente_bancaria) {
        this.cuente_bancaria = cuente_bancaria;
    }

    public Double getTotalbruto() {
        return totalbruto;
    }

    public void setTotalbruto(Double totalbruto) {
        this.totalbruto = totalbruto;
    }

    public Double getPorcentaje_irpf() {
        return porcentaje_irpf;
    }

    public void setPorcentaje_irpf(Double porcentaje_irpf) {
        this.porcentaje_irpf = porcentaje_irpf;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEstadoingreso() {
        return estadoingreso;
    }

    public void setEstadoingreso(String estadoingreso) {
        this.estadoingreso = estadoingreso;
    }
    
    
    
}
