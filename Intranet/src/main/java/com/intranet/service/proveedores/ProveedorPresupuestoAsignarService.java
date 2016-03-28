/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.proveedor_presupuesto_asignar;
import com.intranet.dao.ProveedorPresupuestoAsignarDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proveedorPresupuestoAsignarService")
public class ProveedorPresupuestoAsignarService {
    @Autowired 
    ProveedorPresupuestoAsignarDAO proveedorPresupuestoAsignarDAO;
    
    public  List<proveedor_presupuesto_asignar> findAll (String nif){
        return proveedorPresupuestoAsignarDAO.findAll(nif);
    }
	public  proveedor_presupuesto_asignar porId (int id){
        return proveedorPresupuestoAsignarDAO.porId(id);
    }
        public  boolean Insert (proveedor_presupuesto_asignar cap){
        return proveedorPresupuestoAsignarDAO.Insert(cap);
    }
	public  String Update (proveedor_presupuesto_asignar cap){
        return proveedorPresupuestoAsignarDAO.Update(cap);
    }
	public  boolean Delete (int id){
        return proveedorPresupuestoAsignarDAO.Delete(id);
    }
}
