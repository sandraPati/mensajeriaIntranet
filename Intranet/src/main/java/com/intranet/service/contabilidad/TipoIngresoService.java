/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.tipoingreso;
import com.intranet.dao.TipoIngresoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoIngresoService")
public class TipoIngresoService {
    @Autowired
    TipoIngresoDAO tipoIngresoDAO;
    
    public  List<tipoingreso> findAll (){
        return tipoIngresoDAO.findAll();
    }
    public  tipoingreso porId(int id){
        return tipoIngresoDAO.porId(id);
    }
}
