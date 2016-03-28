/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class gastos {
    int id;
    formapagogasto formapago_id;
    tipogasto tipogasto_id;
    Date fechapago;
    proveedores proveedor_id;
    String referencia;
    String cuenta_bancaria;
    Double totalbruto=0.0;
    Double porcentaje_irpf=0.0;
    Double porcentaje_deduccion=0.0;
    int estado;
    String estadogasto;
    int imgfactura;
    empleados nifempleado;
    String nif;
    
    String nombreimg;
    public gastos() {
    }

    public gastos(int id, formapagogasto formapago_id, tipogasto tipogasto_id, Date fechapago, proveedores proveedor_id, String referencia, String cuenta_bancaria, int estado, String estadogasto) {
        this.id = id;
        this.formapago_id = formapago_id;
        this.tipogasto_id = tipogasto_id;
        this.fechapago = fechapago;
        this.proveedor_id = proveedor_id;
        this.referencia = referencia;
        this.cuenta_bancaria = cuenta_bancaria;
        this.estado = estado;
        this.estadogasto = estadogasto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public formapagogasto getFormapago_id() {
        return formapago_id;
    }

    public void setFormapago_id(formapagogasto formapago_id) {
        this.formapago_id = formapago_id;
    }

    public tipogasto getTipogasto_id() {
        return tipogasto_id;
    }

    public void setTipogasto_id(tipogasto tipogasto_id) {
        this.tipogasto_id = tipogasto_id;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public proveedores getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(proveedores proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(String cuenta_bancaria) {
        this.cuenta_bancaria = cuenta_bancaria;
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

    public Double getPorcentaje_deduccion() {
        return porcentaje_deduccion;
    }

    public void setPorcentaje_deduccion(Double porcentaje_deduccion) {
        this.porcentaje_deduccion = porcentaje_deduccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEstadogasto() {
        return estadogasto;
    }

    public void setEstadogasto(String estadogasto) {
        this.estadogasto = estadogasto;
    }

    public int getImgfactura() {
        return imgfactura;
    }

    public void setImgfactura(int imgfactura) {
        this.imgfactura = imgfactura;
    }

    public empleados getNifempleado() {
        return nifempleado;
    }

    public void setNifempleado(empleados nifempleado) {
        this.nifempleado = nifempleado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombreimg() {
        return nombreimg;
    }

    public void setNombreimg(String nombreimg) {
        this.nombreimg = nombreimg;
    }
    
    
}
