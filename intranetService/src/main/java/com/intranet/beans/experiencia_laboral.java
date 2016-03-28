/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class experiencia_laboral {
        int id;
	String postulante_doc_identidad;
	String puesto;
	String Empresa;
	Boolean trabajando;
	String fecha_inicio_mes;
	String fecha_inicio_anio;
	String fecha_fin_mes;
	String fecha_fin_anio;
	
	String fecha_inicio;
	String fecha_fin;
	String trabajandoM;  

    public experiencia_laboral(int id, String postulante_doc_identidad, String puesto, String Empresa, Boolean trabajando, String fecha_inicio_mes, String fecha_inicio_anio, String fecha_fin_mes, String fecha_fin_anio, String fecha_inicio, String fecha_fin, String trabajandoM) {
        this.id = id;
        this.postulante_doc_identidad = postulante_doc_identidad;
        this.puesto = puesto;
        this.Empresa = Empresa;
        this.trabajando = trabajando;
        this.fecha_inicio_mes = fecha_inicio_mes;
        this.fecha_inicio_anio = fecha_inicio_anio;
        this.fecha_fin_mes = fecha_fin_mes;
        this.fecha_fin_anio = fecha_fin_anio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.trabajandoM = trabajandoM;
    }

    public experiencia_laboral() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostulante_doc_identidad() {
        return postulante_doc_identidad;
    }

    public void setPostulante_doc_identidad(String postulante_doc_identidad) {
        this.postulante_doc_identidad = postulante_doc_identidad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public Boolean getTrabajando() {
        return trabajando;
    }

    public void setTrabajando(Boolean trabajando) {
        this.trabajando = trabajando;
    }

    public String getFecha_inicio_mes() {
        return fecha_inicio_mes;
    }

    public void setFecha_inicio_mes(String fecha_inicio_mes) {
        this.fecha_inicio_mes = fecha_inicio_mes;
    }

    public String getFecha_inicio_anio() {
        return fecha_inicio_anio;
    }

    public void setFecha_inicio_anio(String fecha_inicio_anio) {
        this.fecha_inicio_anio = fecha_inicio_anio;
    }

    public String getFecha_fin_mes() {
        return fecha_fin_mes;
    }

    public void setFecha_fin_mes(String fecha_fin_mes) {
        this.fecha_fin_mes = fecha_fin_mes;
    }

    public String getFecha_fin_anio() {
        return fecha_fin_anio;
    }

    public void setFecha_fin_anio(String fecha_fin_anio) {
        this.fecha_fin_anio = fecha_fin_anio;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTrabajandoM() {
        return trabajandoM;
    }

    public void setTrabajandoM(String trabajandoM) {
        this.trabajandoM = trabajandoM;
    }
        
        
}
