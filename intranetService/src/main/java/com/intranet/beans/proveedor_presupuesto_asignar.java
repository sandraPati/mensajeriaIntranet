/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class proveedor_presupuesto_asignar {
    int id;
    int prov_presu;
    int presupuesto;

    public proveedor_presupuesto_asignar() {
    }

    public proveedor_presupuesto_asignar(int id, int prov_presu, int presupuesto) {
        this.id = id;
        this.prov_presu = prov_presu;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProv_presu() {
        return prov_presu;
    }

    public void setProv_presu(int prov_presu) {
        this.prov_presu = prov_presu;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    
}
