/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class presupuesto_superficies_panos_vpa {
    int id;
    int idpresup_sup_pano;
    int idvpa;
    int idpuerta;
    int idarmario;
    ventanas v;
    puertas p;
    armarios a;
    public presupuesto_superficies_panos_vpa() {
    }

    public presupuesto_superficies_panos_vpa(int id, int idpresup_sup_pano, int idvpa) {
        this.id = id;
        this.idpresup_sup_pano = idpresup_sup_pano;
        this.idvpa = idvpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpresup_sup_pano() {
        return idpresup_sup_pano;
    }

    public void setIdpresup_sup_pano(int idpresup_sup_pano) {
        this.idpresup_sup_pano = idpresup_sup_pano;
    }

    public int getIdvpa() {
        return idvpa;
    }

    public void setIdvpa(int idvpa) {
        this.idvpa = idvpa;
    }

    public ventanas getV() {
        return v;
    }

    public void setV(ventanas v) {
        this.v = v;
    }

    public puertas getP() {
        return p;
    }

    public void setP(puertas p) {
        this.p = p;
    }

    public armarios getA() {
        return a;
    }

    public void setA(armarios a) {
        this.a = a;
    }

    public int getIdpuerta() {
        return idpuerta;
    }

    public void setIdpuerta(int idpuerta) {
        this.idpuerta = idpuerta;
    }

    public int getIdarmario() {
        return idarmario;
    }

    public void setIdarmario(int idarmario) {
        this.idarmario = idarmario;
    }
    
    
}
