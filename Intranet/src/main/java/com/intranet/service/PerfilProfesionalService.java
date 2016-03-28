/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.perfil_profesional;
import com.intranet.dao.PerfilProfesionalDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("perfilProfesionalService")
public class PerfilProfesionalService {
    @Autowired
    private PerfilProfesionalDAO perfilProfesionalDAO;
    
        public  List<perfil_profesional> findAll (){
            return perfilProfesionalDAO.findAll();
        }
	public  perfil_profesional porId (int id){
            return perfilProfesionalDAO.porId(id);
        }
	
	public  boolean Insert (perfil_profesional cap){
            return perfilProfesionalDAO.Insert(cap);
        }
	public  boolean Update (perfil_profesional cap){
            return perfilProfesionalDAO.Update(cap);
        }
	public  boolean Delete (Integer id){
            return perfilProfesionalDAO.Delete(id);
        }
}
