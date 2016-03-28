/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class TareaPersonal {
    private int id;
	private String nifempleado;
	private String descripcion;
	private String finicio;
	private String ffin;
	private String ccabecera;
	private String ccontenido;
	private String estado;
	private String nota;
	private String cerrado;

    public TareaPersonal() {
    }

    public TareaPersonal(int id, String nifempleado, String descripcion, String finicio, String ffin, String ccabecera, String ccontenido, String estado, String nota, String cerrado) {
        this.id = id;
        this.nifempleado = nifempleado;
        this.descripcion = descripcion;
        this.finicio = finicio;
        this.ffin = ffin;
        this.ccabecera = ccabecera;
        this.ccontenido = ccontenido;
        this.estado = estado;
        this.nota = nota;
        this.cerrado = cerrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNifempleado() {
        return nifempleado;
    }

    public void setNifempleado(String nifempleado) {
        this.nifempleado = nifempleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getCcabecera() {
        return ccabecera;
    }

    public void setCcabecera(String ccabecera) {
        this.ccabecera = ccabecera;
    }

    public String getCcontenido() {
        return ccontenido;
    }

    public void setCcontenido(String ccontenido) {
        this.ccontenido = ccontenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getCerrado() {
        return cerrado;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }
        
        
}
