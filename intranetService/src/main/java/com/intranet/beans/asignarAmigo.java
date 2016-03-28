/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class asignarAmigo {
    int id;
    int id_mgrupo;
    empleados nif_amigo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mgrupo() {
        return id_mgrupo;
    }

    public void setId_mgrupo(int id_mgrupo) {
        this.id_mgrupo = id_mgrupo;
    }

    public empleados getNif_amigo() {
        return nif_amigo;
    }

    public void setNif_amigo(empleados nif_amigo) {
        this.nif_amigo = nif_amigo;
    }

    public asignarAmigo(int id, int id_mgrupo, empleados nif_amigo) {
        this.id = id;
        this.id_mgrupo = id_mgrupo;
        this.nif_amigo = nif_amigo;
    }

    public asignarAmigo() {
    }
    
    
}
