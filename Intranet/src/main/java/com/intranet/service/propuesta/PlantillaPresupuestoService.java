/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.estancias;
import com.intranet.beans.plantillaPresupuesto;
import com.intranet.beans.presupuestosGrupo;
import com.intranet.dao.PlantillaPresupuestoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("plantillaPresupuestoService")
public class PlantillaPresupuestoService {
    @Autowired 
    PlantillaPresupuestoDAO plantillaPresupuestoDAO;
    
    
    public  boolean Insert (plantillaPresupuesto pp){
        return plantillaPresupuestoDAO.Insert(pp);
    }
    public  boolean delete (int id){
        return plantillaPresupuestoDAO.delete(id);
    }
    public  List<plantillaPresupuesto> todasPlantillas (){
        return plantillaPresupuestoDAO.todasPlantillas();
    }
    public  int existe (int idP){
        return plantillaPresupuestoDAO.existe(idP);
    }
    public  int existePlantilla (){
        return plantillaPresupuestoDAO.existePlantilla();
    }
    public  plantillaPresupuesto porID (int id){
        return plantillaPresupuestoDAO.porID(id);
    }
    public  plantillaPresupuesto porIDP (int id){
        return plantillaPresupuestoDAO.porIDP(id);
    }
}
