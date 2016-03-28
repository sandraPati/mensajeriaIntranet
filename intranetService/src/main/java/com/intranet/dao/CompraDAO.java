/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.compra;
import java.util.List;

public interface CompraDAO {
    public List<compra> findAllProveedor(int id);
    public List<compra> findAll();
    public List<compra> findAllEmpleado(String nif);
    public List<compra> porFecha(String fechai,String fechaf);
    public compra porId(int id);
    public  boolean Insert (compra c);
    public  int ultimocompra ();
    public  boolean Update (compra c);
    public  boolean Delete (int id);
    public  boolean EstadoDePagoT (int id);
    public  boolean EstadoDePagoF (int id);
}
