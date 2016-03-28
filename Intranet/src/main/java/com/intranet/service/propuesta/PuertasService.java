/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.puertas;
import com.intranet.dao.PuertaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("puertasService")
public class PuertasService {
    @Autowired
    PuertaDAO puertaDAO;
    public  List<puertas> findAll (int idPano){
        return puertaDAO.findAll(idPano);
    }
    public  puertas porID (int id){
        return puertaDAO.porID(id);
    }
    
    public  String Insert (puertas v){
        return puertaDAO.Insert(v);
    }
    public  String InsertPaso (puertas v){
        return puertaDAO.InsertPaso(v);
    }
	public  String Update (puertas v){
        return puertaDAO.Update(v);
    }
	public  String Delete (Integer id){
        return puertaDAO.Delete(id);
    }
	public  String DeletePano (Integer id){
        return puertaDAO.DeletePano(id);
    }
}
