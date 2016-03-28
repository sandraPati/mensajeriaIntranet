/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.gastos;
import java.util.List;

public interface GastosDAO {
    public  List<gastos> findAll();
    public  List<gastos> findAllEmpleado(String nif);
    public  gastos porID (int id);
    public  int ultimo (gastos g);
    public  List<gastos> porIDProv (int idP);
    public  String Insert (gastos cap);
    public  String Update (gastos cap);
    public  String Delete (int id);
    public  boolean EstadoDePagoT (int id);
    public  boolean EstadoDePagoF (int id);
}
