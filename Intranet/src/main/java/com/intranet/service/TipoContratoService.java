/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.tipo_contrato;
import com.intranet.dao.TipoContratoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoContratoService")
public class TipoContratoService {
    @Autowired
    TipoContratoDAO tipocontratoDAO;
    
    public  List<tipo_contrato> findAll (){
        return tipocontratoDAO.findAll();
    }
    public  tipo_contrato porId (int id){
        return tipocontratoDAO.porId(id);
    }
}
