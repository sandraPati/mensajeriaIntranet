/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.propuesta;
import com.intranet.dao.PropuestaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("propuestasService")
public class PropuestasService {
    @Autowired
    PropuestaDAO propuestaDAO;
    
        public  List<propuesta> findAll (String buscar){
            return propuestaDAO.findAll(buscar);
        }
	public  List<propuesta> findAllE (String buscar){
            return propuestaDAO.findAllE(buscar);
        }
	public  List<propuesta> filtroC (String nifC){
            return propuestaDAO.filtroC(nifC);
        }
        public  List<propuesta> filtroCProy (String nifC){
            return propuestaDAO.filtroCProy(nifC);
        }
	public  List<propuesta> filtroCE (String nifE,String nifC){
            return propuestaDAO.filtroCE(nifE,nifC);
        }
        public  List<propuesta> filtroCEProy (String nifE,String nifC){
            return propuestaDAO.filtroCEProy(nifE,nifC);
        }
	public  List<propuesta> filtroE (String nifE){
            return propuestaDAO.filtroE(nifE);
        }
	public  propuesta porId (int id){
            return propuestaDAO.porId(id);
        }
        public  propuesta porIdDescuento (int id){
            return propuestaDAO.porIdDescuento(id);
        }
        public  int porIdNifCEmpleado (String cliente,String empl){
            return propuestaDAO.porIdNifCEmpleado(cliente,empl);
        }
	public  Integer porFechaEmpleadoCliente (propuesta p){
            return propuestaDAO.porFechaEmpleadoCliente(p);
        }
	public  String Insert (propuesta pro){
            return propuestaDAO.Insert(pro);
        }
        public  String InsertPaso (propuesta pro){
            return propuestaDAO.InsertPaso(pro);
        }
	public  String Update (propuesta pro){
            return propuestaDAO.Update(pro);
        }
	public  String UpdateC (propuesta pro){
            return propuestaDAO.UpdateC(pro);
        }
        public  boolean UpdateDescuento (propuesta pro){
            return propuestaDAO.UpdateDescuento(pro);
        }
	public  String Delete (Integer id){
            return propuestaDAO.Delete(id);
        }
	
	public  int contrataraProyecto (propuesta pro){
            return propuestaDAO.contrataraProyecto(pro);
        }
        public  int rechazar (int id){
            return propuestaDAO.rechazar(id);
        }
         public  int activar (int id){
            return propuestaDAO.activar(id);
        }
}
