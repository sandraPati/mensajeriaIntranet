/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.gastosR;


public interface GastosRDAO {
    public gastosR porId(int id);
    public gastosR porIdGasto(int id);
    public boolean existe(String nombreimg);
    public String insertar(gastosR p);
    public String update(gastosR p);
    public String updateGasto(gastosR p);
    public String eliminar(int id);
    public String eliminarGasto(int id);
}
