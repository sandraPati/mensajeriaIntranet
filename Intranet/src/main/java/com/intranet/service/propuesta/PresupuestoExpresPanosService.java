/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.presupuesto_expres_panos;
import com.intranet.dao.PresupuestoExpresPanosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoExpresPanosService")
public class PresupuestoExpresPanosService {
    @Autowired 
    PresupuestoExpresPanosDAO presupuestoExpresPanosDAO;
    
    public List<presupuesto_expres_panos> lta(int idPex){
        return presupuestoExpresPanosDAO.lta(idPex);
    }
    public  boolean insert (presupuesto_expres_panos obj){
        return presupuestoExpresPanosDAO.insert(obj);
    }
    public  boolean update (presupuesto_expres_panos obj){
        return presupuestoExpresPanosDAO.update(obj);
    }
    public  int existe (int idP,int idPex){
        return presupuestoExpresPanosDAO.existe(idP, idPex);
    }
    public  boolean delete (int idP,int idPex){
        return presupuestoExpresPanosDAO.delete(idP, idPex);
    }
}
