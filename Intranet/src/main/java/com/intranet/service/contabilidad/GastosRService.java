/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.gastosR;
import com.intranet.dao.GastosRDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gastosRService")
public class GastosRService {
    @Autowired
    GastosRDAO gastosRDAO;
    
    public gastosR porId(int id){
        return gastosRDAO.porId(id);
    }
    public gastosR porIdGasto(int id){
        return gastosRDAO.porIdGasto(id);
    }
    public boolean existe(String nombreimg){
        return gastosRDAO.existe(nombreimg);
    }
    public String insertar(gastosR p){
        return gastosRDAO.insertar(p);
    }
    public String update(gastosR p){
        return gastosRDAO.update(p);
    }
    public String updateGasto(gastosR p){
        return gastosRDAO.updateGasto(p);
    }
    public String eliminar(int id){
        return gastosRDAO.eliminar(id);
    }
    public String eliminarGasto(int id){
        return gastosRDAO.eliminarGasto(id);
    }
}
