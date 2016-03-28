/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;

public class presupuesto_superficie {
    int id;
	int presupuesto_id;
        int estancia;
	estancias estancia_id;
        int ageregado=0;
        List<presupuesto_superficies_panos> lta;
    public presupuesto_superficie() {
    }

    public presupuesto_superficie(int id, int presupuesto_id, estancias estancia_id) {
        this.id = id;
        this.presupuesto_id = presupuesto_id;
        this.estancia_id = estancia_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresupuesto_id() {
        return presupuesto_id;
    }

    public void setPresupuesto_id(int presupuesto_id) {
        this.presupuesto_id = presupuesto_id;
    }

    public estancias getEstancia_id() {
        return estancia_id;
    }

    public void setEstancia_id(estancias estancia_id) {
        this.estancia_id = estancia_id;
    }

   
    public int getAgeregado() {
        return ageregado;
    }

    public void setAgeregado(int ageregado) {
        this.ageregado = ageregado;
    }

    public int getEstancia() {
        return estancia;
    }

    public void setEstancia(int estancia) {
        this.estancia = estancia;
    }

    public List<presupuesto_superficies_panos> getLta() {
        return lta;
    }

    public void setLta(List<presupuesto_superficies_panos> lta) {
        this.lta = lta;
    }

   
        
        
}
