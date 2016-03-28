/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.objetivos;

import com.intranet.beans.Objetivos;
import com.intranet.dao.ObjetivosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("objetivosService")
public class ObjetivosService {
    @Autowired
    ObjetivosDAO objetivosDAO;
    
    public  List<Objetivos> findAll (){
        return objetivosDAO.findAll();
    }
    public  Objetivos ById (int id){
        return objetivosDAO.ById(id);
    }
    public  Objetivos ByNif (String nif){
        return objetivosDAO.ByNif(nif);
    }
    public  boolean Insert (Objetivos cont){
        return objetivosDAO.Insert(cont);
    }
    public  boolean Update (Objetivos cont){
        return objetivosDAO.Update(cont);
    }
    public  boolean existe (String nif){
        return objetivosDAO.existe(nif);
    }
}
