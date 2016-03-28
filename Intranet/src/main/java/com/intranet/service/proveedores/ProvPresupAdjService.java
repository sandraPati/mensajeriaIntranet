/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.prov_presup_adj;
import com.intranet.dao.ProvPresupAdjDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provPresupAdjService")
public class ProvPresupAdjService {
    @Autowired 
    ProvPresupAdjDAO provPresupAdjDAO;
    
    public  List<prov_presup_adj> findAll (int idPP){
        return provPresupAdjDAO.findAll(idPP);
    }
    public  prov_presup_adj porID (int id){
        return provPresupAdjDAO.porID(id);
    }
    
    public  boolean Insert (prov_presup_adj est){
        return provPresupAdjDAO.Insert(est);
    }
    public  boolean Update (prov_presup_adj est){
        return provPresupAdjDAO.Update(est);
    }       
    public  boolean Delete (Integer id){
        return provPresupAdjDAO.Delete(id);
    }
    public  boolean DeleteID (Integer id){
        return provPresupAdjDAO.DeleteID(id);
    }
}
