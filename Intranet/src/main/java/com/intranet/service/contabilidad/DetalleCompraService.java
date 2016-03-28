/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.detalleCompra;
import com.intranet.dao.DetalleCompraDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detalleCompraService")
public class DetalleCompraService {
    @Autowired
    DetalleCompraDAO detalleCompraDAO;
    
    public List<detalleCompra> findAll(){
        return detalleCompraDAO.findAll();
    }
    
    public List<detalleCompra> findAllPorCompra(int idCompra){
        return detalleCompraDAO.findAllPorCompra(idCompra);
    }
    
    public detalleCompra porId(int id){
        return detalleCompraDAO.porId(id);
    }
    public  String Insert (detalleCompra c){
        return detalleCompraDAO.Insert(c);
    }
    public  String Update (detalleCompra c){
        return detalleCompraDAO.Update(c);
    }
    public  String Delete (int id){
        return detalleCompraDAO.Delete(id);
    }
    public  String DeleteC (int id){
        return detalleCompraDAO.DeleteC(id);
    }
}
