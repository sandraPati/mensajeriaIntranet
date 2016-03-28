/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.tipoiva;
import com.intranet.dao.TipoIvaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoIvaService")
public class TipoIvaService {
    @Autowired
    TipoIvaDAO tipoIvaDAO;
    
    public  List<tipoiva> findAll (){
        return tipoIvaDAO.findAll();
    }
    public  tipoiva porId(int id){
        return tipoIvaDAO.porId(id);
    }
}
