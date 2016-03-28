/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.gastos;
import com.intranet.dao.GastosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gastosService")
public class GastosService {
    @Autowired
    GastosDAO gastosDAO;
    
    public  List<gastos> findAll(){
        return gastosDAO.findAll();
    }
    public  List<gastos> findAllEmpleado(String nif){
        return gastosDAO.findAllEmpleado(nif);
    }
    public  gastos porID (int id){
        return gastosDAO.porID(id);
    }
    public  int ultimo (gastos g){
        return gastosDAO.ultimo(g);
    }
    public  List<gastos> porIDProv (int idP){
        return gastosDAO.porIDProv(idP);
    }
    public  String Insert (gastos cap){
        return gastosDAO.Insert(cap);
    }
    public  String Update (gastos cap){
        return gastosDAO.Update(cap);
    }
    public  String Delete (int id){
        return gastosDAO.Delete(id);
    }
    public  boolean EstadoDePagoT (int id){
        return gastosDAO.EstadoDePagoT(id);
    }
    public  boolean EstadoDePagoF (int id){
        return gastosDAO.EstadoDePagoF(id);
    }
}
