/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.empleados;
import com.intranet.beans.reporteNomina;
import java.io.FileInputStream;
import java.util.List;

public interface EmpleadoDAO {
    public  List<empleados> findAll (String buscar);
	public  List<empleados> ListaSupervisores (String buscar);
	public  empleados ByNif (String e);
	public  empleados ByNifPropuesta (String e);
	public  String Insert (empleados emp);
	public  String Update (empleados emp);
	public  String UpdateA (empleados emp);
	//actualizar usuario / contraseña
	public  String UpdateUC (empleados emp);
	public  String Delete (String nif);
	public  empleados reporteContrato (String nif,int cont);
	public  reporteNomina reporteNomina (String nif,int cont,int nomi);
	
	public  String UpdateCV (empleados emp,FileInputStream fis, int longitudBytes);
	public  String UpdateImagen (empleados emp);
	public  String UpdateTamanoImagen (empleados emp);
	public void guardarImagenEmpleado(empleados postulante);
        public  boolean updateEstadoAlta (String nif);
        public  boolean updateEstadoBaja (String nif);
}
