/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proveedor_presupuesto;
import java.util.List;


public interface ProveedorPresupuestoDAO {
    public  List<proveedor_presupuesto> findAll (int id);
    public  List<proveedor_presupuesto> findAllPorProyecto (int id);
    public  proveedor_presupuesto porID (int id);
    
    public  boolean Insert (proveedor_presupuesto est);
    public  boolean Update (proveedor_presupuesto est);
    public  boolean Delete (Integer id);
    public int idultimo();
    public  String UpdateAprobado (int id);
    public  String UpdateRechazado (int id);
    public int existeAsignado(int id);
}
