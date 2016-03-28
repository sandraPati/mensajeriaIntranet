/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.ingresos;
import com.intranet.dao.IngresosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ingresosService")
public class IngresosService {
    @Autowired
    IngresosDAO ingresosDAO;
    
    public  List<ingresos> findAll(){
        return ingresosDAO.findAll();
    }
    public  ingresos porID (int id){
        return ingresosDAO.porID(id);
    }
    public  List<ingresos> porNIF (String nif){
        return ingresosDAO.porNIF(nif);
    }
    public  String Insert (ingresos cap){
        return ingresosDAO.Insert(cap);
    }
    public  String Update (ingresos cap){
        return ingresosDAO.Update(cap);
    }
    public  String Delete (int id){
        return ingresosDAO.Delete(id);
    }
     public  boolean EstadoDePagoT (int id){
        return ingresosDAO.EstadoDePagoT(id);
    }
    public  boolean EstadoDePagoF (int id){
        return ingresosDAO.EstadoDePagoF(id);
    }
}
