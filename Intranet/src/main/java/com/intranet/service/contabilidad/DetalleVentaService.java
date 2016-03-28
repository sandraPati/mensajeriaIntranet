/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.detalleVenta;
import com.intranet.dao.DetalleVentaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detalleVentaService")
public class DetalleVentaService {
    @Autowired
    DetalleVentaDAO detalleVentaDAO;
    
    public List<detalleVenta> findAll(){
        return detalleVentaDAO.findAll();
    }
    
    public List<detalleVenta> findAllPorVenta(int idV){
        return detalleVentaDAO.findAllPorVenta(idV);
    }
    
    public detalleVenta porId(int id){
        return detalleVentaDAO.porId(id);
    }
    public  String Insert (detalleVenta c){
        return detalleVentaDAO.Insert(c);
    }
    public  String Update (detalleVenta c){
        return detalleVentaDAO.Update(c);
    }
    public  String Delete (int id){
        return detalleVentaDAO.Delete(id);
    }
    public  String DeleteV (int id){
        return detalleVentaDAO.DeleteC(id);
    }
}
