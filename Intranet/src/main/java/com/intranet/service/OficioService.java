/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.oficios;
import com.intranet.dao.OficioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("oficioService")
public class OficioService {
    @Autowired
    private OficioDAO oficioDAO;
    
        public  List<oficios> findAll (){
            return oficioDAO.findAll();
        }
	public  oficios porId (int id){
            return oficioDAO.porId(id);
        }
	
	public  String Insert (oficios cap){
            return oficioDAO.Insert(cap);
        }
	public  String Update (oficios cap){
            return oficioDAO.Update(cap);
        }
	public  String Delete (Integer id){
            return oficioDAO.Delete(id);
        }
}
