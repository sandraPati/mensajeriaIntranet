/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.finiquito;
import com.intranet.dao.FiniquitoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("finiquitoService")
public class FiniquitoService {
    @Autowired
    private FiniquitoDAO finiquitoDAO;
    
    public  List<finiquito> findAll (String postulante_doc){
        return finiquitoDAO.findAll(postulante_doc);
    }
     public  finiquito porId (int id){
         return finiquitoDAO.porId(id);
     }
     public  boolean Insert (finiquito cap){
         return finiquitoDAO.Insert(cap);
     }
     public  finiquito ultimo (String nif_empleado){
         return finiquitoDAO.ultimo(nif_empleado);
     }
}
