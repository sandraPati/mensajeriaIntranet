/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;


public class NominaDeduccion {
    nomina nominaId;
    deducciones deduccionId;

    public nomina getNominaId() {
        return nominaId;
    }

    public void setNominaId(nomina nominaId) {
        this.nominaId = nominaId;
    }

    public deducciones getDeduccionId() {
        return deduccionId;
    }

    public void setDeduccionId(deducciones deduccionId) {
        this.deduccionId = deduccionId;
    }

    public NominaDeduccion() {
    }

    public NominaDeduccion(nomina nominaId, deducciones deduccionId) {
        this.nominaId = nominaId;
        this.deduccionId = deduccionId;
    }
    
    
    
    
}
