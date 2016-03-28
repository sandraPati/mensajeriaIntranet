/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.empleados;
import com.intranet.beans.proyecto_trabajadores;
import java.util.List;

public interface ProyectoTrabajadoresDAO {
    public  List<proyecto_trabajadores> findAll (int idProyectoPresupuesto);
	public  List<proyecto_trabajadores> findAllPlanObra (int idProyectoPresupuesto);
        public int tienePlanobra (int idPropuesta);
	public  List<proyecto_trabajadores> findAllPropuesta (int idPropuesta);
        
	public  List<proyecto_trabajadores> findAllPropuestaE (empleados e);
	public  List<proyecto_trabajadores> findAllPropuestaPlanObraDes (int idPropuesta,String desPlanObra);
	public  proyecto_trabajadores porId (int id);
	public  boolean agregarnuevoSuperaCantidad (int idProyectoPresupuesto);
	public  String cantidademeplados (int idProyectoPresupuesto);
	public  boolean existe (proyecto_trabajadores presu);
	public  String Insert (proyecto_trabajadores presu);
	public  String Update (proyecto_trabajadores presu);
	
	public  String UpdateEstadoNota (proyecto_trabajadores presu);
	public String updateCondicion(proyecto_trabajadores t);
	public String cerrarRecordatorio(proyecto_trabajadores t);
	public List<proyecto_trabajadores> getTareasE(String nif);
	
	public  String Delete (Integer id);
}
