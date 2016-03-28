/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;

public class EstanciasPanos {
    int idPropuesta;
    int idEstancia;
    List<panos> ltaPanos;

    public EstanciasPanos(int idPropuesta, int idEstancia, List<panos> ltaPanos) {
        this.idPropuesta = idPropuesta;
        this.idEstancia = idEstancia;
        this.ltaPanos = ltaPanos;
    }

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public List<panos> getLtaPanos() {
        return ltaPanos;
    }

    public void setLtaPanos(List<panos> ltaPanos) {
        this.ltaPanos = ltaPanos;
    }
    
}
