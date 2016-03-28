/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.List;

public class presupuestosGrupo {
    int id;
    int capitulo_id;
    capitulos cap;
    List<presupuesto> LtaSubcap;
    List<presupuesto_superficie> LtaSuperficies;
    public presupuestosGrupo() {
    }

    public presupuestosGrupo(int id, int capitulo_id, capitulos cap) {
        this.id = id;
        this.capitulo_id = capitulo_id;
        this.cap = cap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapitulo_id() {
        return capitulo_id;
    }

    public void setCapitulo_id(int capitulo_id) {
        this.capitulo_id = capitulo_id;
    }

    public capitulos getCap() {
        return cap;
    }

    public void setCap(capitulos cap) {
        this.cap = cap;
    }

    public List<presupuesto> getLtaSubcap() {
        return LtaSubcap;
    }

    public void setLtaSubcap(List<presupuesto> LtaSubcap) {
        this.LtaSubcap = LtaSubcap;
    }

    public List<presupuesto_superficie> getLtaSuperficies() {
        return LtaSuperficies;
    }

    public void setLtaSuperficies(List<presupuesto_superficie> LtaSuperficies) {
        this.LtaSuperficies = LtaSuperficies;
    }
    
    
}
