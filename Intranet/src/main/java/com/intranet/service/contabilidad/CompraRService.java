/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.compraR;
import com.intranet.dao.CompraRDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("compraRService")
public class CompraRService {
    @Autowired
    CompraRDAO compraRDAO;
    
    public compraR porId(int id){
        return compraRDAO.porId(id);
    }
    public compraR porIdCompra(int id){
        return compraRDAO.porIdCompra(id);
    }
    public boolean existe(String nombreimg){
        return compraRDAO.existe(nombreimg);
    }
    public String insertar(compraR p){
        return compraRDAO.insertar(p);
    }
    public String update(compraR p){
        return compraRDAO.update(p);
    }
    public String updateCompra(compraR p){
        return compraRDAO.updateCompra(p);
    }
    public String eliminar(int id){
        return compraRDAO.eliminar(id);
    }
    public String eliminarGasto(int id){
        return compraRDAO.eliminarGasto(id);
    }
}
