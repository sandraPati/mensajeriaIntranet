/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class compra {
    int num;
    String serie;
    proveedores proveeedor_id;
    Date fecha;
    Date fechavencimiento;
    String referencia;
    String direccion;
    
    String tipocuenta;
    
    boolean retificativo;
    String notas;
    int estado;
    Double irpf=0.0;
    String causaretificativo;
    Double baseimponible=0.0;
    Double ivatotal=0.0;
    Double totalirpf=0.0;
    Double total=0.0;
    empleados nifempleado;
    String nif;
    int imgfactura;
    public compra() {
    }

    public compra(int num, String serie, proveedores proveeedor_id, Date fecha, Date fechavencimiento, String referencia, String direccion, String tipocuenta, boolean retificativo, String notas, int estado, Double irpf, String causaretificativo, Double baseimponible, Double ivatotal, Double totalirpf, Double total) {
        this.num = num;
        this.serie = serie;
        this.proveeedor_id = proveeedor_id;
        this.fecha = fecha;
        this.fechavencimiento = fechavencimiento;
        this.referencia = referencia;
        this.direccion = direccion;
        this.tipocuenta = tipocuenta;
        this.retificativo = retificativo;
        this.notas = notas;
        this.estado = estado;
        this.irpf = irpf;
        this.causaretificativo = causaretificativo;
        this.baseimponible = baseimponible;
        this.ivatotal = ivatotal;
        this.totalirpf = totalirpf;
        this.total = total;
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

    public proveedores getProveeedor_id() {
        return proveeedor_id;
    }

    public void setProveeedor_id(proveedores proveeedor_id) {
        this.proveeedor_id = proveeedor_id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    

    public boolean getRetificativo() {
        return retificativo;
    }

    public void setRetificativo(boolean retificativo) {
        this.retificativo = retificativo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
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

    public String getCausaretificativo() {
        return causaretificativo;
    }

    public void setCausaretificativo(String causaretificativo) {
        this.causaretificativo = causaretificativo;
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

    public int getImgfactura() {
        return imgfactura;
    }

    public void setImgfactura(int imgfactura) {
        this.imgfactura = imgfactura;
    }

    
}
