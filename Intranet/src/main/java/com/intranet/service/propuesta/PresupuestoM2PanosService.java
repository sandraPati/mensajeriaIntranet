/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.presupuestom2panos;
import com.intranet.dao.PresupuestoM2PanosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PresupuestoM2PanosService")
public class PresupuestoM2PanosService {
    @Autowired
    PresupuestoM2PanosDAO presupuestoM2PanosDAO;
    
    public  presupuestom2panos porId (int id){
        return presupuestoM2PanosDAO.porId(id);
    }
    public  presupuestom2panos porIdProp (int idP){
        return presupuestoM2PanosDAO.porIdProp(idP);
    }
    public  presupuestom2panos porIdPresup (int idP){
        return presupuestoM2PanosDAO.porIdPresup(idP);
    }
    public  int buscar (int idP){
        return presupuestoM2PanosDAO.buscar(idP);
    }
    public  int Insert (presupuestom2panos presu){
        return presupuestoM2PanosDAO.Insert(presu);
    }
    public  int Update (presupuestom2panos presu){
        return presupuestoM2PanosDAO.Update(presu);
    }
    public  int Delete (int id){
        return presupuestoM2PanosDAO.Delete(id);
    }
    public  int DeleteidPresu (int id){
        return presupuestoM2PanosDAO.DeleteidPresu(id);
    }
    public  int DeletePresup (int id){
        return presupuestoM2PanosDAO.DeletePresup(id);
    }
}
