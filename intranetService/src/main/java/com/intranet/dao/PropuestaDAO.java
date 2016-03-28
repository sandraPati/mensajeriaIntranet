/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.propuesta;
import java.util.List;

public interface PropuestaDAO {
    public  List<propuesta> findAll (String buscar);
	public  List<propuesta> findAllE (String buscar);
	public  List<propuesta> filtroC (String nifC);
        public  List<propuesta> filtroCProy (String nifC);
	public  List<propuesta> filtroCE (String nifE,String nifC);
        public  List<propuesta> filtroCEProy (String nifE,String nifC);
        
	public  List<propuesta> filtroE (String nifE);
	public  propuesta porId (int id);
        public  propuesta porIdDescuento (int id);
        public  int porIdNifCEmpleado (String cliente,String empl);
	public  Integer porFechaEmpleadoCliente (propuesta p);
	public  String Insert (propuesta pro);
        public  String InsertPaso (propuesta pro);
	public  String Update (propuesta pro);
	public  String UpdateC (propuesta pro);
        public  boolean UpdateDescuento (propuesta pro);
	public  String Delete (Integer id);
	
	public  int contrataraProyecto (propuesta pro);
        public  int rechazar (int id);
        public  int activar (int id);
}
