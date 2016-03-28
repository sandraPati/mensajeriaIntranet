/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.beans.formapago;
import com.intranet.dao.FormaPagoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("formaPagoService")
public class FormaPagoService {
    @Autowired
    FormaPagoDAO formaPagoDAO;
    
    public  List<formapago> findAll (){
        return formaPagoDAO.findAll();
    }
    public  formapago porId(int id){
        return formaPagoDAO.porId(id);
    }
    
}
