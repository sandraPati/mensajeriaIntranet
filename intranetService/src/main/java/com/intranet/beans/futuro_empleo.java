/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class futuro_empleo {
        int id;
	String postulante_doc_identidad;
	String buscas_trabajo;
	String puesto;
	String cambiar_residencia;
	String destinos;
	String viajar;
	String jornada_laboral_preferida;
	String tipo_contrato;
	String expectativas_salariales_minimo;
	String salario_deseado;

    public futuro_empleo() {
    }

    public futuro_empleo(int id, String postulante_doc_identidad, String buscas_trabajo, String puesto, String cambiar_residencia, String destinos, String viajar, String jornada_laboral_preferida, String tipo_contrato, String expectativas_salariales_minimo, String salario_deseado) {
        this.id = id;
        this.postulante_doc_identidad = postulante_doc_identidad;
        this.buscas_trabajo = buscas_trabajo;
        this.puesto = puesto;
        this.cambiar_residencia = cambiar_residencia;
        this.destinos = destinos;
        this.viajar = viajar;
        this.jornada_laboral_preferida = jornada_laboral_preferida;
        this.tipo_contrato = tipo_contrato;
        this.expectativas_salariales_minimo = expectativas_salariales_minimo;
        this.salario_deseado = salario_deseado;
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

    public String getBuscas_trabajo() {
        return buscas_trabajo;
    }

    public void setBuscas_trabajo(String buscas_trabajo) {
        this.buscas_trabajo = buscas_trabajo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCambiar_residencia() {
        return cambiar_residencia;
    }

    public void setCambiar_residencia(String cambiar_residencia) {
        this.cambiar_residencia = cambiar_residencia;
    }

    public String getDestinos() {
        return destinos;
    }

    public void setDestinos(String destinos) {
        this.destinos = destinos;
    }

    public String getViajar() {
        return viajar;
    }

    public void setViajar(String viajar) {
        this.viajar = viajar;
    }

    public String getJornada_laboral_preferida() {
        return jornada_laboral_preferida;
    }

    public void setJornada_laboral_preferida(String jornada_laboral_preferida) {
        this.jornada_laboral_preferida = jornada_laboral_preferida;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getExpectativas_salariales_minimo() {
        return expectativas_salariales_minimo;
    }

    public void setExpectativas_salariales_minimo(String expectativas_salariales_minimo) {
        this.expectativas_salariales_minimo = expectativas_salariales_minimo;
    }

    public String getSalario_deseado() {
        return salario_deseado;
    }

    public void setSalario_deseado(String salario_deseado) {
        this.salario_deseado = salario_deseado;
    }
        
        
}
