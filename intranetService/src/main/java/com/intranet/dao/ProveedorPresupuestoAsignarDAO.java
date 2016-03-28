/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proveedor_presupuesto_asignar;
import java.util.List;

public interface ProveedorPresupuestoAsignarDAO {
    public  List<proveedor_presupuesto_asignar> findAll (String nif);
	public  proveedor_presupuesto_asignar porId (int id);
        public  boolean Insert (proveedor_presupuesto_asignar cap);
	public  String Update (proveedor_presupuesto_asignar cap);
	public  boolean Delete (int id);
}
