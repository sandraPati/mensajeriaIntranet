/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class perfiles {
    int idp;
    String nombrep;

    public perfiles() {
    }

    public perfiles(int idp, String nombrep) {
        this.idp = idp;
        this.nombrep = nombrep;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }
        
        
}
