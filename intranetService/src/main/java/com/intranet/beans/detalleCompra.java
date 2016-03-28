/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class detalleCompra {
    int id;
    compra compra_id;
    String productoservicio;
    int cantidad=1;
    Double precio=0.0;
    Double totalcp=0.0;
    Double porcentajedescuento=0.0;
    Double descuento=0.0; 
    tipoiva tipoiva_id;
    Double impuesto=0.0;
    Double totalimp=0.0;
    tipogasto tipogasto_id;
    public detalleCompra() {
    }

    public detalleCompra(int id, compra compra_id, String productoservicio, int cantidad, Double precio, Double totalcp, Double porcentajedescuento, Double descuento, tipoiva tipoiva_id, Double impuesto, Double totalimp,tipogasto tipogasto_id) {
        this.id = id;
        this.compra_id = compra_id;
        this.productoservicio = productoservicio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.totalcp = totalcp;
        this.porcentajedescuento = porcentajedescuento;
        this.descuento = descuento;
        this.tipoiva_id = tipoiva_id;
        this.impuesto = impuesto;
        this.totalimp = totalimp;
        this.tipogasto_id=tipogasto_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public compra getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(compra compra_id) {
        this.compra_id = compra_id;
    }

    public String getProductoservicio() {
        return productoservicio;
    }

    public void setProductoservicio(String productoservicio) {
        this.productoservicio = productoservicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotalcp() {
        return totalcp;
    }

    public void setTotalcp(Double totalcp) {
        this.totalcp = totalcp;
    }

    public Double getPorcentajedescuento() {
        return porcentajedescuento;
    }

    public void setPorcentajedescuento(Double porcentajedescuento) {
        this.porcentajedescuento = porcentajedescuento;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public tipoiva getTipoiva_id() {
        return tipoiva_id;
    }

    public void setTipoiva_id(tipoiva tipoiva_id) {
        this.tipoiva_id = tipoiva_id;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getTotalimp() {
        return totalimp;
    }

    public void setTotalimp(Double totalimp) {
        this.totalimp = totalimp;
    }

    public tipogasto getTipogasto_id() {
        return tipogasto_id;
    }

    public void setTipogasto_id(tipogasto tipogasto_id) {
        this.tipogasto_id = tipogasto_id;
    }
    
    
}
