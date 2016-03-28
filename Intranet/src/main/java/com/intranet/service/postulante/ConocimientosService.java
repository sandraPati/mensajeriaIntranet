/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.conocimientos;
import com.intranet.dao.ConocimientoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("conocimientosService")
public class ConocimientosService {
    @Autowired 
    ConocimientoDAO conocimientoDAO;
    
    public  List<conocimientos> findAll (String nif){
        return conocimientoDAO.findAll(nif);
    }
    public  conocimientos porId (int id){
        return conocimientoDAO.porId(id);
    }
    public  String Insert (conocimientos cap){
        return conocimientoDAO.Insert(cap);
    }
    public  String Update (conocimientos cap){
        return conocimientoDAO.Update(cap);
    }
    public  String Delete (int id){
        return conocimientoDAO.Delete(id);
    }
}
