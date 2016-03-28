/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class nomina {
    Integer id;
    empleados nif_empleado;
    String mes;
    String anio;
    Double salario_base=0.0;
    Double pagas_extras_prorrateadas=0.0;
    Double prorrateo_vacaciones=0.0;
    Double horas_extraordinarias=0.0;
    Double gratificaciones_extraordinarias=0.0;
    Double salario_especie=0.0;
    Double indemnizaciones_suplidos=0.0;
    Double prestaciones_indemnizaciones_ss=0.0;
    Double otras_percepciones_no_salariales=0.0;
    contrato c;
    String numdias; 
    String antiguedad;
    public nomina() {
    }

    public nomina(Integer id, empleados nif_empleado, String mes, String anio, Double salario_base, Double pagas_extras_prorrateadas, Double prorrateo_vacaciones, Double horas_extraordinarias, Double gratificaciones_extraordinarias, Double salario_especie, Double indemnizaciones_suplidos, Double prestaciones_indemnizaciones_ss, Double otras_percepciones_no_salariales, contrato c) {
        this.id = id;
        this.nif_empleado = nif_empleado;
        this.mes = mes;
        this.anio = anio;
        this.salario_base = salario_base;
        this.pagas_extras_prorrateadas = pagas_extras_prorrateadas;
        this.prorrateo_vacaciones = prorrateo_vacaciones;
        this.horas_extraordinarias = horas_extraordinarias;
        this.gratificaciones_extraordinarias = gratificaciones_extraordinarias;
        this.salario_especie = salario_especie;
        this.indemnizaciones_suplidos = indemnizaciones_suplidos;
        this.prestaciones_indemnizaciones_ss = prestaciones_indemnizaciones_ss;
        this.otras_percepciones_no_salariales = otras_percepciones_no_salariales;
        this.c = c;
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

    public Double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(Double salario_base) {
        this.salario_base = salario_base;
    }

    public Double getPagas_extras_prorrateadas() {
        return pagas_extras_prorrateadas;
    }

    public void setPagas_extras_prorrateadas(Double pagas_extras_prorrateadas) {
        this.pagas_extras_prorrateadas = pagas_extras_prorrateadas;
    }

    public Double getProrrateo_vacaciones() {
        return prorrateo_vacaciones;
    }

    public void setProrrateo_vacaciones(Double prorrateo_vacaciones) {
        this.prorrateo_vacaciones = prorrateo_vacaciones;
    }

    public Double getHoras_extraordinarias() {
        return horas_extraordinarias;
    }

    public void setHoras_extraordinarias(Double horas_extraordinarias) {
        this.horas_extraordinarias = horas_extraordinarias;
    }

    public Double getGratificaciones_extraordinarias() {
        return gratificaciones_extraordinarias;
    }

    public void setGratificaciones_extraordinarias(Double gratificaciones_extraordinarias) {
        this.gratificaciones_extraordinarias = gratificaciones_extraordinarias;
    }

    public Double getSalario_especie() {
        return salario_especie;
    }

    public void setSalario_especie(Double salario_especie) {
        this.salario_especie = salario_especie;
    }

    public Double getIndemnizaciones_suplidos() {
        return indemnizaciones_suplidos;
    }

    public void setIndemnizaciones_suplidos(Double indemnizaciones_suplidos) {
        this.indemnizaciones_suplidos = indemnizaciones_suplidos;
    }

    public Double getPrestaciones_indemnizaciones_ss() {
        return prestaciones_indemnizaciones_ss;
    }

    public void setPrestaciones_indemnizaciones_ss(Double prestaciones_indemnizaciones_ss) {
        this.prestaciones_indemnizaciones_ss = prestaciones_indemnizaciones_ss;
    }

    public Double getOtras_percepciones_no_salariales() {
        return otras_percepciones_no_salariales;
    }

    public void setOtras_percepciones_no_salariales(Double otras_percepciones_no_salariales) {
        this.otras_percepciones_no_salariales = otras_percepciones_no_salariales;
    }

    public contrato getC() {
        return c;
    }

    public void setC(contrato c) {
        this.c = c;
    }

    public String getNumdias() {
        return numdias;
    }

    public void setNumdias(String numdias) {
        this.numdias = numdias;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    

}
