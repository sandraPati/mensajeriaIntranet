/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.proveedor_presupuesto;
import com.intranet.dao.ProveedorPresupuestoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proveedorPresupuestoService")
public class ProveedorPresupuestoService {
    @Autowired
    ProveedorPresupuestoDAO proveedorPresupuestoDAO;
    
    public  List<proveedor_presupuesto> findAll (int id){
        return proveedorPresupuestoDAO.findAll(id);
    }
    public  List<proveedor_presupuesto> findAllPorProyecto (int id){
        return proveedorPresupuestoDAO.findAllPorProyecto(id);
    }
    public  proveedor_presupuesto porID (int id){
        return proveedorPresupuestoDAO.porID(id);
    }
    
    public  boolean Insert (proveedor_presupuesto est){
        return proveedorPresupuestoDAO.Insert(est);
    }
    public  boolean Update (proveedor_presupuesto est){
        return proveedorPresupuestoDAO.Update(est);
    }
    public  boolean Delete (Integer id){
        return proveedorPresupuestoDAO.Delete(id);
    }
    public int idultimo(){
        return proveedorPresupuestoDAO.idultimo();
    }
     public  String UpdateAprobado (int id){
            return proveedorPresupuestoDAO.UpdateAprobado(id);
    }
    public  String UpdateRechazado (int id){
        return proveedorPresupuestoDAO.UpdateRechazado(id);
    }
    
    public int existeAsignado(int id){
        return proveedorPresupuestoDAO.existeAsignado(id);
    }
}
