/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.ingresos;
import java.util.List;

/**
 *
 * @author ESCOBAR
 */
public interface IngresosDAO {
    public  List<ingresos> findAll();
    public  ingresos porID (int id);
    public  List<ingresos> porNIF (String nif);
    public  String Insert (ingresos cap);
    public  String Update (ingresos cap);
    public  String Delete (int id);
    public  boolean EstadoDePagoT (int id);
    public  boolean EstadoDePagoF (int id);
}
