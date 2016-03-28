/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class puertas {
    int id;
    panos idpano;
    int id_pano;
    int num;
    float largo;
    float alto;
    float superficie=0;
    int estandar;
    
    int agregado=0;
    public puertas() {
    }

    public puertas(int id, panos idpano, int num) {
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

    public int getId_pano() {
        return id_pano;
    }

    public void setId_pano(int id_pano) {
        this.id_pano = id_pano;
    }

    public int getEstandar() {
        return estandar;
    }

    public void setEstandar(int estandar) {
        this.estandar = estandar;
    }

    public int getAgregado() {
        return agregado;
    }

    public void setAgregado(int agregado) {
        this.agregado = agregado;
    }
    
    
}
