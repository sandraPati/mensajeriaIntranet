/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.panos;
import com.intranet.beans.presupuesto_expres;
import com.intranet.dao.PresupuestoExpresDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoExpresService")
public class PresupuestoExpresService {
    @Autowired 
    PresupuestoExpresDAO presupuestoExpresDAO;
    
    public  presupuesto_expres presupExpresIDE (int id){
        return presupuestoExpresDAO.presupExpresIDE(id);
    }
    public  presupuesto_expres presupExpresIDE2 (int id){
        return presupuestoExpresDAO.presupExpresIDE2(id);
    }
    
    public  boolean insert (presupuesto_expres obj){
        return presupuestoExpresDAO.insert(obj);
    }
    public  boolean insert2 (presupuesto_expres obj){
        return presupuestoExpresDAO.insert2(obj);
    }
    public  boolean update (presupuesto_expres obj){
        return presupuestoExpresDAO.update(obj);
    }
     public  boolean update2 (presupuesto_expres obj){
        return presupuestoExpresDAO.update2(obj);
    }
    public  int existe (int idP,int idE){
        return presupuestoExpresDAO.existe(idP,idE);
    }
    public  int existecount (int idP,int idE){
        return presupuestoExpresDAO.existecount(idP,idE);
    }
    public  boolean delete (int idP,int idE){
        return presupuestoExpresDAO.delete(idP,idE);
    }
    public  boolean deleteP (int idP){
        return presupuestoExpresDAO.deleteP(idP);
    }
    
    public List<panos> panosExpres(int idE){
        return presupuestoExpresDAO.panosExpres(idE);
    }
    public List<panos> panosExpresElejidos(int idE){
        return presupuestoExpresDAO.panosExpresElejidos(idE);
    }
}
