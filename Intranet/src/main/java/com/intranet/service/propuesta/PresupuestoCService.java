/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.estancias;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoc;
import com.intranet.dao.PresupuestoCDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoCService")
public class PresupuestoCService {
    @Autowired 
    PresupuestoCDAO presupuestoCDAO;
    
    public  List<presupuesto> findAll (int idProp){
        return presupuestoCDAO.findAll(idProp);
    }
    public  List<presupuestoc> grupo (int idProp,int idE){
        return presupuestoCDAO.grupo(idProp,idE);
    }
    
    public  presupuestoc porid (int id){
        return presupuestoCDAO.porId(id);
    }
    public  int ultimoPresupuestoC (int idProp,int idCap){
        return presupuestoCDAO.ultimoPresupuestoC(idProp, idCap);
    }
    public  int ultimoPresupuestoCid (int idProp,int idCap){
        return presupuestoCDAO.ultimoPresupuestoCid(idProp, idCap);
    }
    public  boolean Insert (presupuestoc presu){
        return presupuestoCDAO.Insert(presu);
    }
    public  boolean Upd (presupuestoc presu){
        return presupuestoCDAO.Upd(presu);
    }
    public  boolean Delete (int id){
        return presupuestoCDAO.Delete(id);
    }
    public  boolean DeletePC (int idP,int idC){
        return presupuestoCDAO.DeletePC(idP,idC);
    }
    public  List<presupuesto> presupuestos (int idPresuC){
        return presupuestoCDAO.presupuestos(idPresuC);
    }
    
    public  boolean presupPropuesta (int idP){
        return presupuestoCDAO.presupPropuesta(idP);
    }
    public  List<presupuestoc> presupuestoCapitulos (int idP){
        return presupuestoCDAO.presupuestoCapitulos(idP);
    }
    public  List<presupuestoc> presupuestoCapitulosADD (int idP){
        return presupuestoCDAO.presupuestoCapitulosADD(idP);
    }
    public  String UpdateEstado (int idP){
        return presupuestoCDAO.UpdateEstado(idP);
    }
}
