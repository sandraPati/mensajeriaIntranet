/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.postulante;

import com.intranet.beans.tipoidioma;
import com.intranet.dao.TipoIdiomaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoIdiomaService")
public class TipoIdiomaService {
    @Autowired
    TipoIdiomaDAO tipoIdiomaDAO;
    public  List<tipoidioma> findAll (){
        return tipoIdiomaDAO.findAll();
    }
	public  tipoidioma porId (int id){
        return tipoIdiomaDAO.porId(id);
        }
}
