/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class venta {
    int num;
    String serie;
    clientes cliente_nif;
    Date fecha;
    Date fechavencimiento;
    String referencia;
    String direccionP;
    String direccionE;
    boolean rectificactiva;
    String causa;
    String notas;
    String terminos;
    int estado;

    Double irpf=0.0;
    Double baseimponible=0.0;
    Double ivatotal=0.0;
    Double totalirpf=0.0;
    Double total=0.0;
    
    propuesta propueta_id;
    public venta() {
    }

    public venta(int num, String serie, clientes cliente_nif, Date fecha, Date fechavencimiento, String referencia, String direccionP, String direccionE, boolean rectificactiva, String causa, String notas, String terminos, int estado,propuesta propueta_id) {
        this.num = num;
        this.serie = serie;
        this.cliente_nif = cliente_nif;
        this.fecha = fecha;
        this.fechavencimiento = fechavencimiento;
        this.referencia = referencia;
        this.direccionP = direccionP;
        this.direccionE = direccionE;
        this.rectificactiva = rectificactiva;
        this.causa = causa;
        this.notas = notas;
        this.terminos = terminos;
        this.estado = estado;
        this.propueta_id=propueta_id;
    }

   

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public clientes getCliente_nif() {
        return cliente_nif;
    }

    public void setCliente_nif(clientes cliente_nif) {
        this.cliente_nif = cliente_nif;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public String getDireccionE() {
        return direccionE;
    }

    public void setDireccionE(String direccionE) {
        this.direccionE = direccionE;
    }

    public boolean getRectificactiva() {
        return rectificactiva;
    }

    public void setRectificactiva(boolean rectificactiva) {
        this.rectificactiva = rectificactiva;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Double getIrpf() {
        return irpf;
    }

    public void setIrpf(Double irpf) {
        this.irpf = irpf;
    }

    public Double getBaseimponible() {
        return baseimponible;
    }

    public void setBaseimponible(Double baseimponible) {
        this.baseimponible = baseimponible;
    }

    public Double getIvatotal() {
        return ivatotal;
    }

    public void setIvatotal(Double ivatotal) {
        this.ivatotal = ivatotal;
    }

    public Double getTotalirpf() {
        return totalirpf;
    }

    public void setTotalirpf(Double totalirpf) {
        this.totalirpf = totalirpf;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public propuesta getPropueta_id() {
        return propueta_id;
    }

    public void setPropueta_id(propuesta propueta_id) {
        this.propueta_id = propueta_id;
    }
            
           
}
