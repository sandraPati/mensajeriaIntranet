/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.capitulos;
import com.intranet.dao.CapituloDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("capitulosService")
public class CapitulosService {
    @Autowired
    CapituloDAO capituloDAO;
    
        public  List<capitulos> findAll (String buscar){
            return capituloDAO.findAll(buscar);
        }
	public  capitulos porId (int id){
            return capituloDAO.porId(id);
        }
	public  boolean existe (String nombre){
            return capituloDAO.existe(nombre);
        }
	public  boolean existeU (capitulos c){
            return capituloDAO.existeU(c);
        }
	public  String Insert (capitulos cap){
            return capituloDAO.Insert(cap);
        }
	public  String Update (capitulos cap){
            return capituloDAO.Update(cap);
        }
	public  String Delete (Integer id){
            return capituloDAO.Delete(id);
        }
    
}
