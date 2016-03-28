/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.subcapitulos;
import com.intranet.dao.CapituloDAO;
import com.intranet.dao.SubCapitulosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("subCapitulosService")
public class SubCapitulosService {
    @Autowired
    SubCapitulosDAO subCapitulosDAO;
    
        public  List<subcapitulos> findAll (String buscar){
            return subCapitulosDAO.findAll(buscar);
        }
	public  List<subcapitulos> listaPorCapitulo (int idCapitulo){
            return subCapitulosDAO.listaPorCapitulo(idCapitulo);
        }
	public  List<subcapitulos> filtro (int idCapitulo){
            return subCapitulosDAO.filtro(idCapitulo);
        }
	public  subcapitulos porCapitulo (int idCapitulo,int id){
            return subCapitulosDAO.porCapitulo(idCapitulo,id);
        }
	public  subcapitulos porId (int id){
            return subCapitulosDAO.porId(id);
        }
	public  boolean existe (String nombre){
            return subCapitulosDAO.existe(nombre);
        }
	public  boolean existeU (subcapitulos s){
            return subCapitulosDAO.existeU(s);
        }
	public  String Insert (subcapitulos subcap){
            return subCapitulosDAO.Insert(subcap);
        }
	public  String Update (subcapitulos subcap){
            return subCapitulosDAO.Update(subcap);
        }
	public  String Delete (Integer id){
            return subCapitulosDAO.Delete(id);
        }
}
