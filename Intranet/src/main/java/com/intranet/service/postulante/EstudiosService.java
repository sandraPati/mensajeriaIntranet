/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.estudios;
import com.intranet.dao.EstudiosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("estudiosService")
public class EstudiosService {
    @Autowired 
    EstudiosDAO estudiosDAO;
    
    public  List<estudios> findAll (String postulante_doc){
        return estudiosDAO.findAll(postulante_doc);
    }
	public  estudios porNif (int id){
            return estudiosDAO.porNif(id);
        }
        public  estudios porNifE (String id){
            return estudiosDAO.porNifE(id);
        }
	//public  boolean existe (String nombre);
	public  String Insert (estudios cap){
            return estudiosDAO.Insert(cap);
        }
	public  String Update (estudios cap){
            return estudiosDAO.Update(cap);
        }
	public  String Delete (int id){
            return estudiosDAO.Delete(id);
        }
}
