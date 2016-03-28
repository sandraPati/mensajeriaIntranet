/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.io.Serializable;
import java.sql.Date;

public class presupuesto implements Serializable{
    Integer id;
    int presup_id;
    int prop;
    subcapitulos subcapitulo;
    capitulos capitulo;
    float monto=0;
    String descripcion;
    String tipoCantidad;
    float cantidad=0;
    float precio=0;
    int estadoenviado;
    Date fecha;
    int idCap;
    int idSubCap;
    int tienePanosM2;
    public presupuesto() {
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public subcapitulos getSubcapitulo() {
        return subcapitulo;
    }

    public void setSubcapitulo(subcapitulos subcapitulo) {
        this.subcapitulo = subcapitulo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(String tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getEstadoenviado() {
        return estadoenviado;
    }

    public void setEstadoenviado(int estadoenviado) {
        this.estadoenviado = estadoenviado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdSubCap() {
        return idSubCap;
    }

    public void setIdSubCap(int idSubCap) {
        this.idSubCap = idSubCap;
    }

    public int getIdCap() {
        return idCap;
    }

    public void setIdCap(int idCap) {
        this.idCap = idCap;
    }

    public int getPresup_id() {
        return presup_id;
    }

    public void setPresup_id(int presup_id) {
        this.presup_id = presup_id;
    }

    public capitulos getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(capitulos capitulo) {
        this.capitulo = capitulo;
    }

    public int getProp() {
        return prop;
    }

    public void setProp(int prop) {
        this.prop = prop;
    }

    public int getTienePanosM2() {
        return tienePanosM2;
    }

    public void setTienePanosM2(int tienePanosM2) {
        this.tienePanosM2 = tienePanosM2;
    }
        
        
}
