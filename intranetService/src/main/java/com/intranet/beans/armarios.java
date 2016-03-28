/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class armarios {
    int id;
    panos idpano;
    int num;
    float largo;
    float alto;
    float fondo;
    float superficie=0;
    
    int agregado=0;
    
    
    public armarios() {
    }

    public armarios(int id, panos idpano, int num) {
        this.id = id;
        this.idpano = idpano;
        this.num = num;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public panos getIdpano() {
        return idpano;
    }

    public void setIdpano(panos idpano) {
        this.idpano = idpano;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public float getFondo() {
        return fondo;
    }

    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    public int getAgregado() {
        return agregado;
    }

    public void setAgregado(int agregado) {
        this.agregado = agregado;
    }
    
    
}
