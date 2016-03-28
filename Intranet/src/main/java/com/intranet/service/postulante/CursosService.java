/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.cursos;
import com.intranet.dao.CursosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cursosService")
public class CursosService {
    @Autowired
    CursosDAO cursosDAO;
    
    public  List<cursos> findAll (){
        return cursosDAO.findAll();
    }
    public  cursos porId (int id){
        return cursosDAO.porId(id);
    }
}
