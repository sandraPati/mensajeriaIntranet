/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.idiomas;
import com.intranet.dao.IdiomasDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("idiomasService")
public class IdiomasService {
    @Autowired
    IdiomasDAO idiomasDAO;
    
    public  List<idiomas> findAll (String nif){
        return idiomasDAO.findAll(nif);
    }
	public  idiomas porId (int id){
            return idiomasDAO.porId(id);
        }
        public  idiomas porNif (String nif){
            return idiomasDAO.porNIF(nif);
        }
	//public  boolean existe (String nombre);
	public  String Insert (idiomas cap){
            return idiomasDAO.Insert(cap);
        }
	public  String Update (idiomas cap){
            return idiomasDAO.Update(cap);
        }
	public  String Delete (int id){
            return idiomasDAO.Delete(id);
        }
}
