/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.detalleCompra;
import java.util.List;

public interface DetalleCompraDAO {
    public List<detalleCompra> findAll();
    public List<detalleCompra> findAllPorCompra(int idCompra);
    public detalleCompra porId(int id);
    public  String Insert (detalleCompra c);
    public  String Update (detalleCompra c);
    public  String Delete (int id);
    public  String DeleteC (int id);
}
