/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;

public class presupuestom2panos {
    int id;
    int idpresupuesto;
    int idpropuesta;
    List<presupuesto_superficie> ltaps;
    public presupuestom2panos() {
    }

    public presupuestom2panos(int idpresupuesto, int idpropuesta) {
        this.idpresupuesto = idpresupuesto;
        this.idpropuesta = idpropuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(int idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public int getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(int idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public List<presupuesto_superficie> getLtaps() {
        return ltaps;
    }

    public void setLtaps(List<presupuesto_superficie> ltaps) {
        this.ltaps = ltaps;
    }
    
    
}
