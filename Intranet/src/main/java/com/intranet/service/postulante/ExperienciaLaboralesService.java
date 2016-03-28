/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.experiencia_laboral;
import com.intranet.dao.ExperienciaLaboralDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("experienciaLaboralesService")
public class ExperienciaLaboralesService {
    @Autowired
    ExperienciaLaboralDAO experienciaLaboralDAO;
    
    public  List<experiencia_laboral> findAll (String nif){
        return experienciaLaboralDAO.findAll(nif);
    }
	public  experiencia_laboral porNif (int id){
        return experienciaLaboralDAO.porNif(id);
    }
	//public  boolean existe (String nombre);
	public  String Insert (experiencia_laboral cap){
        return experienciaLaboralDAO.Insert(cap);
    }
	public  String Update (experiencia_laboral cap){
        return experienciaLaboralDAO.Update(cap);
    }
	public  String Delete (int cap){
        return experienciaLaboralDAO.Delete(cap);
    }
}
