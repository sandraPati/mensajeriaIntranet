/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.nomina;
import com.intranet.dao.NominaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("nominaService")
public class NominaService {
    @Autowired
    NominaDAO nominaDAO;
    
    public  List<nomina> findAll (String a,String m,int cont){
        return nominaDAO.findAll(a, m, cont);
    }
	public  int tieneNominas (int cont){
        return nominaDAO.tieneNominas(cont);
    }
	public  nomina ById (int id){
        return nominaDAO.ById(id);
    }
	public  List<nomina> FiltrarMA (nomina n){
        return nominaDAO.FiltrarMA(n);
    }
	public  List<nomina> FiltrarM (nomina n){
        return nominaDAO.FiltrarM(n);
    }
	public  List<nomina> FiltrarA (nomina n){
        return nominaDAO.FiltrarA(n);
    }
	public  List<nomina> Filtrar (nomina n){
        return nominaDAO.Filtrar(n);
    }
	
	
	
	public  nomina UltimoPorEmpleado (String nif){
        return nominaDAO.UltimoPorEmpleado(nif);
    }
	public  boolean existeNominaM (String nif,String mes,String anio){
        return nominaDAO.existeNominaM(nif,mes,anio);
    }
        
        public  boolean existeNominaMporID (String nif,String mes,String anio,int id){
        return nominaDAO.existeNominaMporID(nif,mes,anio,id);
    }
	public  boolean Insert (nomina cont){
        return nominaDAO.Insert(cont);
    }
	public  String Update (nomina cont){
        return nominaDAO.Update(cont);
    }
	public  String Delete (int id){
        return nominaDAO.Delete(id);
    }
}
