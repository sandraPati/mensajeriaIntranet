/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.venta;
import com.intranet.dao.VentaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ventaService")
public class VentaService {
    @Autowired
    VentaDAO ventaDAO;
    
    public List<venta> findAll(){
        return ventaDAO.findAll();
    }
    public List<venta> porFecha(String fechai,String fechaf){
        return ventaDAO.porFecha(fechai, fechaf);
    }
    public venta porId(int id){
        return ventaDAO.porId(id);
    }
    public  boolean Insert (venta c){
        return ventaDAO.Insert(c);
    }
    public  int ultimocompra (){
        return ventaDAO.ultimocompra();
    }
    public  boolean Update (venta c){
        return ventaDAO.Update(c);
    }
    public  boolean Delete (int id){
        return ventaDAO.Delete(id);
    }
     public  boolean EstadoDePagoT (int id){
        return ventaDAO.EstadoDePagoT(id);
    }
    public  boolean EstadoDePagoF (int id){
        return ventaDAO.EstadoDePagoF(id);
    }
}
