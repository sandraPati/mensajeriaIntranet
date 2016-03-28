/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.compra;
import com.intranet.dao.CompraDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("compraService")
public class CompraService {
    @Autowired
    CompraDAO compraDAO;
    
    public List<compra> findAll(){
        return compraDAO.findAll();
    }
    public List<compra> findAllEmpleado(String nif){
        return compraDAO.findAllEmpleado(nif);
    }
    public List<compra> findAllProveedor(int id){
        return compraDAO.findAllProveedor(id);
    }
    public List<compra> porFecha(String fechai,String fechaf){
        return compraDAO.porFecha(fechai, fechaf);
    }
    public compra porId(int id){
        return compraDAO.porId(id);
    }
    public  boolean Insert (compra c){
        return compraDAO.Insert(c);
    }
    public  int ultimocompra (){
        return compraDAO.ultimocompra();
    }
    public  boolean Update (compra c){
        return compraDAO.Update(c);
    }
    public  boolean Delete (int id){
        return compraDAO.Delete(id);
    }
    public  boolean EstadoDePagoT (int id){
        return compraDAO.EstadoDePagoT(id);
    }
    public  boolean EstadoDePagoF (int id){
        return compraDAO.EstadoDePagoF(id);
    }
}
