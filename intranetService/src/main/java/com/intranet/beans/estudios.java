/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class estudios {
        int id;
	String postulante_doc_identidad;
	cursos curso_id;
	String fecha_inicio_mes;
	String fecha_inicio_anio;
	String fecha_fin_mes;
	String fecha_fin_anio;
	Boolean cursando;
	String centro;
	
	String fecha_inicio;
	String fecha_fin;
	String cursandoM;
	
	String otro_curso;
	String especificacion_curso; 

    public estudios(int id, String postulante_doc_identidad, cursos curso_id, String fecha_inicio_mes, String fecha_inicio_anio, String fecha_fin_mes, String fecha_fin_anio, Boolean cursando, String centro, String fecha_inicio, String fecha_fin, String cursandoM, String otro_curso, String especificacion_curso) {
        this.id = id;
        this.postulante_doc_identidad = postulante_doc_identidad;
        this.curso_id = curso_id;
        this.fecha_inicio_mes = fecha_inicio_mes;
        this.fecha_inicio_anio = fecha_inicio_anio;
        this.fecha_fin_mes = fecha_fin_mes;
        this.fecha_fin_anio = fecha_fin_anio;
        this.cursando = cursando;
        this.centro = centro;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cursandoM = cursandoM;
        this.otro_curso = otro_curso;
        this.especificacion_curso = especificacion_curso;
    }

    public estudios() {
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

    public cursos getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(cursos curso_id) {
        this.curso_id = curso_id;
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

    public Boolean getCursando() {
        return cursando;
    }

    public void setCursando(Boolean cursando) {
        this.cursando = cursando;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
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

    public String getCursandoM() {
        return cursandoM;
    }

    public void setCursandoM(String cursandoM) {
        this.cursandoM = cursandoM;
    }

    public String getOtro_curso() {
        return otro_curso;
    }

    public void setOtro_curso(String otro_curso) {
        this.otro_curso = otro_curso;
    }

    public String getEspecificacion_curso() {
        return especificacion_curso;
    }

    public void setEspecificacion_curso(String especificacion_curso) {
        this.especificacion_curso = especificacion_curso;
    }
        
        
}
