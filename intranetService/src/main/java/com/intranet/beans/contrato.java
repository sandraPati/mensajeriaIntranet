/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class contrato {
    int id;
    empleados nif_empleado;
    String categoria_profesional;
    String nivel_profesional;
    tipo_contrato id_tipo_contrato;
    String jornada;
    int num_horas;
    String num_horas1;
    String num_horas2;
    String tiempo_rango;
    String tiempo_rango1;
    String tiempo_rango2;
    String corresponde_contrato;
    String pacto_horas_complementarias;
    String distribucion_tiempo;
    Date duracion_contrato_desde;
    Date duracion_contrato_hasta;
    String periodo_prueba;
    String contrato_relevo;
    Double retribucion_total;
    String fecha_pago;
    String tipo_pago;
    String vacaciones;
    String mes;
    String anio;
    String clausulas;
    String conceptos_salariales;
    Date fecha_contrato;
    String fequito;
    public contrato() {
    }

    public contrato(int id, empleados nif_empleado, String categoria_profesional, String nivel_profesional, tipo_contrato id_tipo_contrato, String jornada, int num_horas, String num_horas1, String num_horas2, String tiempo_rango, String tiempo_rango1, String tiempo_rango2, String corresponde_contrato, String pacto_horas_complementarias, String distribucion_tiempo, Date duracion_contrato_desde, Date duracion_contrato_hasta, String periodo_prueba, String contrato_relevo, Double retribucion_total, String fecha_pago, String tipo_pago, String vacaciones, String mes, String anio, String clausulas, String conceptos_salariales, Date fecha_contrato,String fequito) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.categoria_profesional = categoria_profesional;
        this.nivel_profesional = nivel_profesional;
        this.id_tipo_contrato = id_tipo_contrato;
        this.jornada = jornada;
        this.num_horas = num_horas;
        this.num_horas1 = num_horas1;
        this.num_horas2 = num_horas2;
        this.tiempo_rango = tiempo_rango;
        this.tiempo_rango1 = tiempo_rango1;
        this.tiempo_rango2 = tiempo_rango2;
        this.corresponde_contrato = corresponde_contrato;
        this.pacto_horas_complementarias = pacto_horas_complementarias;
        this.distribucion_tiempo = distribucion_tiempo;
        this.duracion_contrato_desde = duracion_contrato_desde;
        this.duracion_contrato_hasta = duracion_contrato_hasta;
        this.periodo_prueba = periodo_prueba;
        this.contrato_relevo = contrato_relevo;
        this.retribucion_total = retribucion_total;
        this.fecha_pago = fecha_pago;
        this.tipo_pago = tipo_pago;
        this.vacaciones = vacaciones;
        this.mes = mes;
        this.anio = anio;
        this.clausulas = clausulas;
        this.conceptos_salariales = conceptos_salariales;
        this.fecha_contrato = fecha_contrato;
        this.fequito=fequito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public empleados getNif_empleado() {
        return nif_empleado;
    }

    public void setNif_empleado(empleados nif_empleado) {
        this.nif_empleado = nif_empleado;
    }

    public String getCategoria_profesional() {
        return categoria_profesional;
    }

    public void setCategoria_profesional(String categoria_profesional) {
        this.categoria_profesional = categoria_profesional;
    }

    public String getNivel_profesional() {
        return nivel_profesional;
    }

    public void setNivel_profesional(String nivel_profesional) {
        this.nivel_profesional = nivel_profesional;
    }

    public tipo_contrato getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(tipo_contrato id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public int getNum_horas() {
        return num_horas;
    }

    public void setNum_horas(int num_horas) {
        this.num_horas = num_horas;
    }

    public String getNum_horas1() {
        return num_horas1;
    }

    public void setNum_horas1(String num_horas1) {
        this.num_horas1 = num_horas1;
    }

    public String getNum_horas2() {
        return num_horas2;
    }

    public void setNum_horas2(String num_horas2) {
        this.num_horas2 = num_horas2;
    }

    public String getTiempo_rango() {
        return tiempo_rango;
    }

    public void setTiempo_rango(String tiempo_rango) {
        this.tiempo_rango = tiempo_rango;
    }

    public String getTiempo_rango1() {
        return tiempo_rango1;
    }

    public void setTiempo_rango1(String tiempo_rango1) {
        this.tiempo_rango1 = tiempo_rango1;
    }

    public String getTiempo_rango2() {
        return tiempo_rango2;
    }

    public void setTiempo_rango2(String tiempo_rango2) {
        this.tiempo_rango2 = tiempo_rango2;
    }

    public String getCorresponde_contrato() {
        return corresponde_contrato;
    }

    public void setCorresponde_contrato(String corresponde_contrato) {
        this.corresponde_contrato = corresponde_contrato;
    }

    public String getPacto_horas_complementarias() {
        return pacto_horas_complementarias;
    }

    public void setPacto_horas_complementarias(String pacto_horas_complementarias) {
        this.pacto_horas_complementarias = pacto_horas_complementarias;
    }

    public String getDistribucion_tiempo() {
        return distribucion_tiempo;
    }

    public void setDistribucion_tiempo(String distribucion_tiempo) {
        this.distribucion_tiempo = distribucion_tiempo;
    }

    public Date getDuracion_contrato_desde() {
        return duracion_contrato_desde;
    }

    public void setDuracion_contrato_desde(Date duracion_contrato_desde) {
        this.duracion_contrato_desde = duracion_contrato_desde;
    }

    public Date getDuracion_contrato_hasta() {
        return duracion_contrato_hasta;
    }

    public void setDuracion_contrato_hasta(Date duracion_contrato_hasta) {
        this.duracion_contrato_hasta = duracion_contrato_hasta;
    }

    public String getPeriodo_prueba() {
        return periodo_prueba;
    }

    public void setPeriodo_prueba(String periodo_prueba) {
        this.periodo_prueba = periodo_prueba;
    }

    public String getContrato_relevo() {
        return contrato_relevo;
    }

    public void setContrato_relevo(String contrato_relevo) {
        this.contrato_relevo = contrato_relevo;
    }

    public Double getRetribucion_total() {
        return retribucion_total;
    }

    public void setRetribucion_total(Double retribucion_total) {
        this.retribucion_total = retribucion_total;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(String vacaciones) {
        this.vacaciones = vacaciones;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getClausulas() {
        return clausulas;
    }

    public void setClausulas(String clausulas) {
        this.clausulas = clausulas;
    }

    public String getConceptos_salariales() {
        return conceptos_salariales;
    }

    public void setConceptos_salariales(String conceptos_salariales) {
        this.conceptos_salariales = conceptos_salariales;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getFequito() {
        return fequito;
    }

    public void setFequito(String fequito) {
        this.fequito = fequito;
    }
    
    
}
