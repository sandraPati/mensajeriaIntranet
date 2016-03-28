/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.futuro_empleo;
import com.intranet.dao.FuturoEmpleoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("futuroEmpleoService")
public class FuturoEmpleoService {
    @Autowired 
    FuturoEmpleoDAO futuroEmpleoDAO;
    
    public  List<futuro_empleo> findAll (String nif){
        return futuroEmpleoDAO.findAll(nif);
    }
	public  futuro_empleo porPostulante (String nif){
        return futuroEmpleoDAO.porPostulante(nif);
    }
	public  futuro_empleo porNif (String nif){
        return futuroEmpleoDAO.porNif(nif);
    }
	public  boolean existeFEP (String nif){
        return futuroEmpleoDAO.existeFEP(nif);
    }
	public  String Insert (futuro_empleo cap){
        return futuroEmpleoDAO.Insert(cap);
    }
	public  String Update (futuro_empleo cap){
        return futuroEmpleoDAO.Update(cap);
    }
	public  String Delete (int id){
        return futuroEmpleoDAO.Delete(id);
    }
}
