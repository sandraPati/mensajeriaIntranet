/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.armarios;
import com.intranet.dao.ArmarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("armariosService")
public class ArmariosService {
    @Autowired
    ArmarioDAO armarioDAO;
    
    public  List<armarios> findAll (int idPano){
        return armarioDAO.findAll(idPano);
    }
    public  armarios porID (int id){
        return armarioDAO.porID(id);
    }
    
    public  String Insert (armarios v){
        return armarioDAO.Insert(v);
    }
	public  String Update (armarios v){
        return armarioDAO.Update(v);
    }
	public  String Delete (Integer id){
        return armarioDAO.Delete(id);
    }
	public  String DeletePano (Integer id){
        return armarioDAO.DeletePano(id);
    }
        
}
