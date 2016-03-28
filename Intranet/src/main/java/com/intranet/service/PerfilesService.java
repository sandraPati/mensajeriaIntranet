/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.perfiles;
import com.intranet.dao.PerfilDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("perfilesService")
public class PerfilesService {
    @Autowired
    private PerfilDAO perfilDAO;
    
    public  List<perfiles> findAll(){
        return perfilDAO.findAll();
    }
    public  perfiles ById(int id){
        return perfilDAO.ById(id);
    }
}
