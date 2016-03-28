/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.presupuesto_superficie;
import com.intranet.dao.PresupuestoSuperficiesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoSuperficiesService")
public class PresupuestoSuperficiesService {
    @Autowired
    PresupuestoSuperficiesDAO presupuestoSuperficiesDAO;
    
        public  List<presupuesto_superficie> findAll (int id_presup){
            return presupuestoSuperficiesDAO.findAll(id_presup);
        }
        public  int tieneRegistros (int id_presup){
            return presupuestoSuperficiesDAO.tieneRegistros(id_presup);
        }
	public  presupuesto_superficie buscar (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.buscar(p);
        }
        public  int buscarcount (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.buscarcount(p);
        }
        public  int buscarid (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.buscarid(p);
        }
        public  presupuesto_superficie porID (int p){
            return presupuestoSuperficiesDAO.porID(p);
        }
	public  boolean existe (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.existe(p);
        }
	public  String Insert (presupuesto_superficie presu){
            return presupuestoSuperficiesDAO.Insert(presu);
        }
	public  String Update (presupuesto_superficie presu){
            return presupuestoSuperficiesDAO.Update(presu);
        }
	public  String Delete (int id){
            return presupuestoSuperficiesDAO.Delete(id);
        }
	public  String DeleteU (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.DeleteU(p);
        }
        public  String DeleteEstancia (presupuesto_superficie p){
            return presupuestoSuperficiesDAO.DeleteEstancia(p);
        }
}
