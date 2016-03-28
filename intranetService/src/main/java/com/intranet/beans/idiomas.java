/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class idiomas {
    int id;
	String postulante_doc_identidad;
	tipoidioma tipoidioma_id;
	String nivelhablado;
	String nivelescrito;
	String nivelleido;

    public idiomas() {
    }

    public idiomas(int id, String postulante_doc_identidad, tipoidioma tipoidioma_id, String nivelhablado, String nivelescrito, String nivelleido) {
        this.id = id;
        this.postulante_doc_identidad = postulante_doc_identidad;
        this.tipoidioma_id = tipoidioma_id;
        this.nivelhablado = nivelhablado;
        this.nivelescrito = nivelescrito;
        this.nivelleido = nivelleido;
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

    public tipoidioma getTipoidioma_id() {
        return tipoidioma_id;
    }

    public void setTipoidioma_id(tipoidioma tipoidioma_id) {
        this.tipoidioma_id = tipoidioma_id;
    }

    public String getNivelhablado() {
        return nivelhablado;
    }

    public void setNivelhablado(String nivelhablado) {
        this.nivelhablado = nivelhablado;
    }

    public String getNivelescrito() {
        return nivelescrito;
    }

    public void setNivelescrito(String nivelescrito) {
        this.nivelescrito = nivelescrito;
    }

    public String getNivelleido() {
        return nivelleido;
    }

    public void setNivelleido(String nivelleido) {
        this.nivelleido = nivelleido;
    }
        
        
}
