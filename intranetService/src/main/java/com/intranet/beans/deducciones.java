/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class deducciones {
    Integer id;
    empleados nif_empleado;
    Double contingencias_comunes=0.0;
    Double desempleo=0.0;
    Double formacion=0.0;
    Double irpf=0.0;
    Double anticipos=0.0;
    Double valor_productos_recibidos=0.0;
    Double otras_deducciones=0.0;
    nomina nom;
    Double basecotizacion=0.0;
    Double baseirpf=0.0;
    public deducciones() {
    }

    public deducciones(Integer id, empleados nif_empleado, Double contingencias_comunes, Double desempleo, Double formacion, Double irpf, Double anticipos, Double valor_productos_recibidos, Double otras_deducciones, nomina nom) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.contingencias_comunes = contingencias_comunes;
        this.desempleo = desempleo;
        this.formacion = formacion;
        this.irpf = irpf;
        this.anticipos = anticipos;
        this.valor_productos_recibidos = valor_productos_recibidos;
        this.otras_deducciones = otras_deducciones;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public empleados getNif_empleado() {
        return nif_empleado;
    }

    public void setNif_empleado(empleados nif_empleado) {
        this.nif_empleado = nif_empleado;
    }

    public Double getContingencias_comunes() {
        return contingencias_comunes;
    }

    public void setContingencias_comunes(Double contingencias_comunes) {
        this.contingencias_comunes = contingencias_comunes;
    }

    public Double getDesempleo() {
        return desempleo;
    }

    public void setDesempleo(Double desempleo) {
        this.desempleo = desempleo;
    }

    public Double getFormacion() {
        return formacion;
    }

    public void setFormacion(Double formacion) {
        this.formacion = formacion;
    }

    public Double getIrpf() {
        return irpf;
    }

    public void setIrpf(Double irpf) {
        this.irpf = irpf;
    }

    public Double getAnticipos() {
        return anticipos;
    }

    public void setAnticipos(Double anticipos) {
        this.anticipos = anticipos;
    }

    public Double getValor_productos_recibidos() {
        return valor_productos_recibidos;
    }

    public void setValor_productos_recibidos(Double valor_productos_recibidos) {
        this.valor_productos_recibidos = valor_productos_recibidos;
    }

    public Double getOtras_deducciones() {
        return otras_deducciones;
    }

    public void setOtras_deducciones(Double otras_deducciones) {
        this.otras_deducciones = otras_deducciones;
    }

    public nomina getNom() {
        return nom;
    }

    public void setNom(nomina nom) {
        this.nom = nom;
    }

    public Double getBasecotizacion() {
        return basecotizacion;
    }

    public void setBasecotizacion(Double basecotizacion) {
        this.basecotizacion = basecotizacion;
    }

    public Double getBaseirpf() {
        return baseirpf;
    }

    public void setBaseirpf(Double baseirpf) {
        this.baseirpf = baseirpf;
    }
    
    
}
