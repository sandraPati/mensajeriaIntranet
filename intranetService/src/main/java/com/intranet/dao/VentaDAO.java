/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.venta;
import java.util.List;

public interface VentaDAO {
    public List<venta> findAll();
    public List<venta> porFecha(String fechai,String fechaf);
    public venta porId(int id);
    public  boolean Insert (venta c);
    public  int ultimocompra ();
    public  boolean Update (venta c);
    public  boolean Delete (int id);
    public  boolean EstadoDePagoT (int id);
    public  boolean EstadoDePagoF (int id);
}
