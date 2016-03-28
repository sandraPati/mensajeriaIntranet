/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class cvpostulante {
    String fecha;
    int estado1;
	int cantidad1;
	int estado2;
	int cantidad2;
	int estado3;
	int cantidad3;
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado1() {
        return estado1;
    }

    public void setEstado1(int estado1) {
        this.estado1 = estado1;
    }

    public int getCantidad1() {
        return cantidad1;
    }

    public void setCantidad1(int cantidad1) {
        this.cantidad1 = cantidad1;
    }

    public int getEstado2() {
        return estado2;
    }

    public void setEstado2(int estado2) {
        this.estado2 = estado2;
    }

    public int getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(int cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public int getEstado3() {
        return estado3;
    }

    public void setEstado3(int estado3) {
        this.estado3 = estado3;
    }

    public int getCantidad3() {
        return cantidad3;
    }

    public void setCantidad3(int cantidad3) {
        this.cantidad3 = cantidad3;
    }

    public cvpostulante() {
    }

    public cvpostulante(String fecha, int estado1, int cantidad1, int estado2, int cantidad2, int estado3, int cantidad3) {
        this.fecha = fecha;
        this.estado1 = estado1;
        this.cantidad1 = cantidad1;
        this.estado2 = estado2;
        this.cantidad2 = cantidad2;
        this.estado3 = estado3;
        this.cantidad3 = cantidad3;
    }
    
    
}
