/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proyecto;

import com.intranet.beans.empleados;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.dao.ProyectoTrabajadoresDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proyectoTrabajadoresService")
public class ProyectoTrabajadoresService {
    @Autowired
    ProyectoTrabajadoresDAO proyectoTrabajadoresDAO;
    
    public  List<proyecto_trabajadores> findAll (int idProyectoPresupuesto){
        return proyectoTrabajadoresDAO.findAll(idProyectoPresupuesto);
    }
	public  List<proyecto_trabajadores> findAllPlanObra (int idProyectoPresupuesto){
        return proyectoTrabajadoresDAO.findAllPlanObra(idProyectoPresupuesto);
    }
        public int tienePlanobra (int idPropuesta){
        return proyectoTrabajadoresDAO.tienePlanobra(idPropuesta);
    }
	public  List<proyecto_trabajadores> findAllPropuesta (int idPropuesta){
        return proyectoTrabajadoresDAO.findAllPropuesta(idPropuesta);
    }
	public  List<proyecto_trabajadores> findAllPropuestaE (empleados e){
        return proyectoTrabajadoresDAO.findAllPropuestaE(e);
    }
	public  List<proyecto_trabajadores> findAllPropuestaPlanObraDes (int idPropuesta,String desPlanObra){
        return proyectoTrabajadoresDAO.findAllPropuestaPlanObraDes(idPropuesta,desPlanObra);
    }
	public  proyecto_trabajadores porId (int id){
        return proyectoTrabajadoresDAO.porId(id);
    }
	public  boolean agregarnuevoSuperaCantidad (int idProyectoPresupuesto){
        return proyectoTrabajadoresDAO.agregarnuevoSuperaCantidad(idProyectoPresupuesto);
    
    }
	public  String cantidademeplados (int idProyectoPresupuesto){
        return proyectoTrabajadoresDAO.cantidademeplados(idProyectoPresupuesto);
    }
	public  boolean existe (proyecto_trabajadores presu){
        return proyectoTrabajadoresDAO.existe(presu);
    }
	public  String Insert (proyecto_trabajadores presu){
        return proyectoTrabajadoresDAO.Insert(presu);
    }
	public  String Update (proyecto_trabajadores presu){
        return proyectoTrabajadoresDAO.Update(presu);
    }
	
	public  String UpdateEstadoNota (proyecto_trabajadores presu){
        return proyectoTrabajadoresDAO.UpdateEstadoNota(presu);
    }
	public String updateCondicion(proyecto_trabajadores t){
        return proyectoTrabajadoresDAO.updateCondicion(t);
    }
	public String cerrarRecordatorio(proyecto_trabajadores t){
        return proyectoTrabajadoresDAO.cerrarRecordatorio(t);
    }
	public List<proyecto_trabajadores> getTareasE(String nif){
        return proyectoTrabajadoresDAO.getTareasE(nif);
    }
	
	public  String Delete (Integer id){
        return proyectoTrabajadoresDAO.Delete(id);
    }
}
