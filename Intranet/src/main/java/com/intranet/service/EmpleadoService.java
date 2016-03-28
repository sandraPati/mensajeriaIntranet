/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.empleados;
import com.intranet.beans.reporteNomina;
import com.intranet.dao.EmpleadoDAO;
import java.io.FileInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empleadoService")
public class EmpleadoService {
    @Autowired
    private EmpleadoDAO empleadoDAO;
    
        public  List<empleados> findAll (String buscar){
            return empleadoDAO.findAll(buscar);
        }
	public  List<empleados> ListaSupervisores (String buscar){
            return empleadoDAO.ListaSupervisores(buscar);
        }
	public  empleados ByNif (String e){
            return empleadoDAO.ByNif(e);
        }
	public  empleados ByNifPropuesta (String e){
            return empleadoDAO.ByNifPropuesta(e);
        }
	public  String Insert (empleados emp){
            return empleadoDAO.Insert(emp);
        }
	public  String Update (empleados emp){
            return empleadoDAO.Update(emp);
        }
	public  String UpdateA (empleados emp){
            return empleadoDAO.UpdateA(emp);
        }
	//actualizar usuario / contraseña
	public  String UpdateUC (empleados emp){
            return empleadoDAO.UpdateUC(emp);
        }
	public  String Delete (String nif){
            return empleadoDAO.Delete(nif);
        }
	public  empleados reporteContrato (String nif,int cont){
            return empleadoDAO.reporteContrato(nif,cont);
        }
	public  reporteNomina reporteNomina (String nif,int cont,int nomi){
            return empleadoDAO.reporteNomina(nif,cont,nomi);
        }
	
	public  String UpdateCV (empleados emp,FileInputStream fis, int longitudBytes){
            return empleadoDAO.UpdateCV(emp,fis,longitudBytes);
        }
	public  String UpdateImagen (empleados emp){
            return empleadoDAO.UpdateImagen(emp);
        }
	
        public  String UpdateTamanoImagen (empleados emp){
            return empleadoDAO.UpdateTamanoImagen(emp);
        }
	
	public void guardarImagenEmpleado(empleados postulante){
             empleadoDAO.guardarImagenEmpleado(postulante);
        }
        public  boolean updateEstadoAlta (String nif){
            return empleadoDAO.updateEstadoAlta(nif);
        }
        public  boolean updateEstadoBaja (String nif){
            return empleadoDAO.updateEstadoBaja(nif);
        }
}
