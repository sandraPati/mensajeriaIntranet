/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;


public class presupuesto_superficies_panos {
    int id;
    int idpresup_sup;
    int idpano;
    panos pano;
    float largo;
    
    List<presupuesto_superficies_panos_vpa> lta;
    List<presupuesto_superficies_panos_vpa> ltap;
    List<presupuesto_superficies_panos_vpa> ltaa;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpresup_sup() {
        return idpresup_sup;
    }

    public void setIdpresup_sup(int idpresup_sup) {
        this.idpresup_sup = idpresup_sup;
    }

    public int getIdpano() {
        return idpano;
    }

    public void setIdpano(int idpano) {
        this.idpano = idpano;
    }

    public presupuesto_superficies_panos() {
    }

    public presupuesto_superficies_panos(int idpresup_sup, int idpano) {
        this.idpresup_sup = idpresup_sup;
        this.idpano = idpano;
    }

    public panos getPano() {
        return pano;
    }

    public void setPano(panos pano) {
        this.pano = pano;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public List<presupuesto_superficies_panos_vpa> getLta() {
        return lta;
    }

    public void setLta(List<presupuesto_superficies_panos_vpa> lta) {
        this.lta = lta;
    }

    public List<presupuesto_superficies_panos_vpa> getLtap() {
        return ltap;
    }

    public void setLtap(List<presupuesto_superficies_panos_vpa> ltap) {
        this.ltap = ltap;
    }

    public List<presupuesto_superficies_panos_vpa> getLtaa() {
        return ltaa;
    }

    public void setLtaa(List<presupuesto_superficies_panos_vpa> ltaa) {
        this.ltaa = ltaa;
    }
    
    
}
