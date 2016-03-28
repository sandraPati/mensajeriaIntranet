/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class conocimientos {
    int id;
    String postulante_doc_identidad;
    String descripcion;
    String nivel;

    public conocimientos() {
    }

    public conocimientos(int id, String postulante_doc_identidad, String descripcion, String nivel) {
        this.id = id;
        this.postulante_doc_identidad = postulante_doc_identidad;
        this.descripcion = descripcion;
        this.nivel = nivel;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
