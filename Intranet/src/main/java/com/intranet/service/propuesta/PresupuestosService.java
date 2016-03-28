/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.capitulos;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.dao.PresupuestoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestosService")
public class PresupuestosService {
    @Autowired
    PresupuestoDAO presupuestoDAO;
    
        public  presupuesto porID (int id){
            return presupuestoDAO.porID(id);
        }
	public  int buscar (presupuesto p){
            return presupuestoDAO.buscar(p);
        }
	public  List<presupuesto> findAll (int idPc){
            return presupuestoDAO.findAll(idPc);
        }
	public   List<presupuesto> presupuestoPropuesta (int idpropuesta){
            return presupuestoDAO.presupuestoPropuesta(idpropuesta);
        }
	public   List<presupuesto> presupuestoEstancia (int idestancia){
            return presupuestoDAO.presupuestoEstancia(idestancia);
        }
	public  estancias estanciasPropuesta (int idpropuesta){
            return presupuestoDAO.estanciasPropuesta(idpropuesta);
        }
	public  List<panos> panosPropuesta (int idestancia){
            return presupuestoDAO.panosPropuesta(idestancia);
        }
	public  String Insert (presupuesto presu){
            return presupuestoDAO.Insert(presu);
        }
        public  String InsertT (presupuesto presu){
            return presupuestoDAO.InsertT(presu);
        }
	public  String Update (presupuesto presu){
            return presupuestoDAO.Update(presu);
        }
        public  String UpdateM (presupuesto presu){
            return presupuestoDAO.UpdateM(presu);
        }
        public  String UpdateMedida (presupuesto presu){
            return presupuestoDAO.UpdateMedida(presu);
        }
	public  String UpdateMonto (presupuesto presu){
            return presupuestoDAO.UpdateMonto(presu);
        }
        public  int DeleteSC (int idPresup,int idSc){
            return presupuestoDAO.DeleteSC(idPresup, idSc);
        }
	public  int Delete (Integer id){
            return presupuestoDAO.Delete(id);
        }
	public  int DeleteU (Integer id){
            return presupuestoDAO.DeleteU(id);
        }
        public  int DeleteP (Integer id){
            return presupuestoDAO.DeleteP(id);
        }
	public   List<capitulos> capitulosEnPresupuestosdePropuesta (int idpropuesta){
            return presupuestoDAO.capitulosEnPresupuestosdePropuesta(idpropuesta);
        }
	public   List<presupuesto> subcapPresupuesto (int idpropuesta,int idcapitulo){
            return presupuestoDAO.subcapPresupuesto(idpropuesta,idcapitulo);
        }
        
        public List<presupuesto> presupuestoSUBCapitulos(int idP) {
            return presupuestoDAO.presupuestoSUBCapitulos(idP);
        }
        
        public List<presupuesto> presupuestoSUBCapitulosADD(int idP,int idC){
            return presupuestoDAO.presupuestoSUBCapitulosADD(idP,idC);
        }
        
        public  presupuesto buscarPresupSC (int idPre,int idSc){
            return presupuestoDAO.buscarPresupSC(idPre,idSc);
        }
        public  int buscarPresupSCid (int idPre,int idSc){
            return presupuestoDAO.buscarPresupSCid(idPre,idSc);
        }
        
        public  int buscarPresupSCcount (int idPre,int idSc){
            return presupuestoDAO.buscarPresupSCcount(idPre,idSc);
        }
}
