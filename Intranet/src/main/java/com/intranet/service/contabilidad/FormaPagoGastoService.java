/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.formapagogasto;
import com.intranet.dao.FormaPagoGastoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("formaPagoGastoService")
public class FormaPagoGastoService {
    @Autowired
    FormaPagoGastoDAO formaPagoGastoDAO;
    
    public  List<formapagogasto> findAll (){
        return formaPagoGastoDAO.findAll();
    }
    public  formapagogasto porId(int id){
        return formaPagoGastoDAO.porId(id);
    }
}
