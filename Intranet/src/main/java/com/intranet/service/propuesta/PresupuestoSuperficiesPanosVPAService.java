/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.presupuesto_superficies_panos_vpa;
import com.intranet.dao.PresupuestoSuperficiesPanosvpaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("presupuestoSuperficiesPanosVPAService")
public class PresupuestoSuperficiesPanosVPAService {
    @Autowired 
    PresupuestoSuperficiesPanosvpaDAO presupuestoSuperficiesPanosvpaDAO;
    
    public  List<presupuesto_superficies_panos_vpa> findAll (int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.findAll(idPSE);
    }
    public  List<presupuesto_superficies_panos_vpa> findAllMostrar (int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.findAllMostrar(idPSE);
    }
    public  List<presupuesto_superficies_panos_vpa> findAllMostrarP (int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.findAllMostrarP(idPSE);
    }
    public  List<presupuesto_superficies_panos_vpa> findAllMostrarA (int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.findAllMostrarA(idPSE);
    }
    public  int Insert (presupuesto_superficies_panos_vpa presu){
        return presupuestoSuperficiesPanosvpaDAO.Insert(presu);
    }
    public  int InsertP (presupuesto_superficies_panos_vpa presu){
        return presupuestoSuperficiesPanosvpaDAO.InsertP(presu);
    }
    public  int InsertA (presupuesto_superficies_panos_vpa presu){
        return presupuestoSuperficiesPanosvpaDAO.InsertA(presu);
    }
    public  int buscar (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.buscar(idP, idPSE);
    }
    public  int buscarcount (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.buscarcount(idP, idPSE);
    }
    public  int buscarcountP (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.buscarcountP(idP, idPSE);
    }
    public  int buscarcountA (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.buscarcountA(idP, idPSE);
    }
    public  int DeleteID (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.DeleteID(idP, idPSE);
    }
    public  int DeleteIDPuerta (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.DeleteIDPuerta(idP, idPSE);
    }
    public  int DeleteIDArmario (int idP,int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.DeleteIDArmario(idP, idPSE);
    }
    public  int DeletePorIdPSE (int idPSE){
        return presupuestoSuperficiesPanosvpaDAO.DeletePorIdPSE(idPSE);
    }
}
