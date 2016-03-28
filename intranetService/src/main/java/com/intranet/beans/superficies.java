/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class superficies {
    int num;
    float largo=0;
    float alto=0;
    float superficie=0;

    public superficies() {
    }

    public superficies(int num) {
        this.num = num;
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
    
    
    
}
