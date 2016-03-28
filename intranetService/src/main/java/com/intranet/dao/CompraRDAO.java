/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.compraR;


public interface CompraRDAO {
    public compraR porId(int id);
    public compraR porIdCompra(int id);
    public boolean existe(String nombreimg);
    public String insertar(compraR p);
    public String update(compraR p);
    public String updateCompra(compraR p);
    public String eliminar(int id);
    public String eliminarGasto(int id);
}
