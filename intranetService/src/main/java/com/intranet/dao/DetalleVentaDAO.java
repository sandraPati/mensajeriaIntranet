/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.detalleVenta;
import java.util.List;

public interface DetalleVentaDAO {
    public List<detalleVenta> findAll();
    public List<detalleVenta> findAllPorVenta(int idV);
    public detalleVenta porId(int id);
    public  String Insert (detalleVenta c);
    public  String Update (detalleVenta c);
    public  String Delete (int id);
    public  String DeleteC (int id);
}
