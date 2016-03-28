/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.deducciones;
import com.intranet.dao.DeduccionesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deduccionesService")
public class DeduccionesService {
    @Autowired
    private DeduccionesDAO deduccionesDAO;
    
    public  deducciones ById (int id){
        return deduccionesDAO.ById(id);
    }
	public  deducciones UltimoPorNomina (int idnomina){
        return deduccionesDAO.UltimoPorNomina(idnomina);
    }
	public  boolean siexiste (int idnomina){
        return deduccionesDAO.siexiste(idnomina);
    }
	public  boolean existeDeduccionM (int idnomina){
        return deduccionesDAO.existeDeduccionM(idnomina);
    }
	public  String Insert (deducciones cont){
        return deduccionesDAO.Insert(cont);
    }
	public  String Update (deducciones cont){
        return deduccionesDAO.Update(cont);
    }
	public  String Delete (int id){
        return deduccionesDAO.Delete(id);
    }
}
