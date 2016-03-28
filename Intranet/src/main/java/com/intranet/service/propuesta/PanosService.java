/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.panos;
import com.intranet.dao.PanoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("panosService")
public class PanosService {
    @Autowired
    PanoDAO panoDAO;
    
        public  List<panos> findAll (int idEstancia){
            return panoDAO.findAll(idEstancia);
        }
        public  List<panos> findAllPresupSuperf (int idE,int idPresu){
            return panoDAO.findAllPresupSuperf(idE,idPresu);
        }
	public  panos porID (int id){
            return panoDAO.porID(id);
        }
        public  int idultimo (int idE){
            return panoDAO.idultimo(idE);
        }
	public  int Insert (panos pa){
            return panoDAO.Insert(pa);
        }
        public  int InsertVolcar (panos pa){
            return panoDAO.InsertVolcar(pa);
        }
	public  String Update (panos pa){
            return panoDAO.Update(pa);
        }
        public  String Updateu (panos pa){
            return panoDAO.Updateu(pa);
        }
        public  String UpdateVentana (panos pa){
            return panoDAO.UpdateVentana(pa);
        }
        public  String UpdatePuerta (panos pa){
            return panoDAO.UpdatePuerta(pa);
        }
        public  String UpdateArmario (panos pa){
            return panoDAO.UpdateArmario(pa);
        }
        
        
	public  String Delete (Integer id){
            return panoDAO.Delete(id);
        }
	public  String DeleteEstancia (Integer id){
            return panoDAO.DeleteEstancia(id);
        }
}
