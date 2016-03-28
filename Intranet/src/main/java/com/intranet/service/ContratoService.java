/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.contrato;
import com.intranet.dao.ContratoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contratoService")
public class ContratoService {
    @Autowired
    ContratoDAO contratoDAO;
    
    public  List<contrato> findAll (String nif){
        return contratoDAO.findAll(nif);
    }
	public  contrato verultimo (String nif){
        return contratoDAO.verultimo(nif);
    }
	public  boolean validafechas (contrato cont){
        return contratoDAO.validafechas(cont);
    }
	public  contrato porId (int id){
        return contratoDAO.porId(id);
    }
	//public  boolean existeContratoE (String nif);
	public  String Insert (contrato cont){
        return contratoDAO.Insert(cont);
    }
	public  String Update (contrato cont){
        return contratoDAO.Update(cont);
    }
	public  String Delete (int id){
        return contratoDAO.Delete(id);
    }
	
	public  List<contrato> FiltrarCmaD (contrato n){
        return contratoDAO.FiltrarCmaD(n);
    }
	public  List<contrato> FiltrarCmaH (contrato n){
        return contratoDAO.FiltrarCmaH(n);
    }
	public  List<contrato> FiltrarCmD (contrato n){
        return contratoDAO.FiltrarCmD(n);
    }
	public  List<contrato> FiltrarCmH (contrato n){
        return contratoDAO.FiltrarCmH(n);
    }
	public  List<contrato> FiltrarCaD (contrato n){
        return contratoDAO.FiltrarCaD(n);
    }
	public  List<contrato> FiltrarCaH (contrato n){
        return contratoDAO.FiltrarCaH(n);
    }
         public  int UContratoF (String nif){
             return contratoDAO.UContratoF(nif);
         }
          public  int UtieneContratoF (String nif){
             return contratoDAO.UtieneContratoF(nif);
         }
}
