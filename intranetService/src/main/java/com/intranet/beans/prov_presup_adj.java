/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class prov_presup_adj {
    int id;
    int id_prov_presup;
    String nombre;
    String tipo;
    public prov_presup_adj() {
    }

    public prov_presup_adj(int id, int id_prov_presup, String nombre) {
        this.id = id;
        this.id_prov_presup = id_prov_presup;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prov_presup() {
        return id_prov_presup;
    }

    public void setId_prov_presup(int id_prov_presup) {
        this.id_prov_presup = id_prov_presup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
