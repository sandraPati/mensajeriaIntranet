/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.dao.PresupuestoSuperficiesPanosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoSuperficiesPanosService")
public class PresupuestoSuperficiesPanosService {
    @Autowired 
    PresupuestoSuperficiesPanosDAO presupuestoSuperficiesPanosDAO;
    
    public  List<presupuesto_superficies_panos> findAll (int idPSE){
        return presupuestoSuperficiesPanosDAO.findAll(idPSE);
    }
    public  List<presupuesto_superficies_panos> findAllMostrar (int idPSE){
        return presupuestoSuperficiesPanosDAO.findAllMostrar(idPSE);
    }
    public  int Insert (presupuesto_superficies_panos presu){
        return presupuestoSuperficiesPanosDAO.Insert(presu);
    }
    public  int buscarcount (int idP,int idPSE){
        return presupuestoSuperficiesPanosDAO.buscarcount(idP, idPSE);
    }
    public  int ultimo (int idP,int idPSE){
        return presupuestoSuperficiesPanosDAO.ultimo(idP, idPSE);
    }
    public  int buscaridPresupSup (int id){
        return presupuestoSuperficiesPanosDAO.buscaridPresupSup(id);
    }
    public  String UpdateLargoPresup (presupuesto_superficies_panos presu){
        return presupuestoSuperficiesPanosDAO.UpdateLargoPresup(presu);
    }
    public  int buscar (int idP,int idPSE){
        return presupuestoSuperficiesPanosDAO.buscar(idP, idPSE);
    }
    public  presupuesto_superficies_panos buscarID (int id){
        return presupuestoSuperficiesPanosDAO.buscarID(id);
    }
    public  int DeleteID (int idP,int idPSE){
        return presupuestoSuperficiesPanosDAO.DeleteID(idP, idPSE);
    }
    public  int DeletePorIdPSE (int idPSE){
        return presupuestoSuperficiesPanosDAO.DeletePorIdPSE(idPSE);
    }
}
