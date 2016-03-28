/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.tipo_pano;
import com.intranet.dao.TipoPanoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoPanosService")
public class TipoPanosService {
    @Autowired
    TipoPanoDAO tipoPanoDAO;
    
        public  List<tipo_pano> findAll (String buscar){
            return tipoPanoDAO.findAll(buscar);
        }
	public  tipo_pano porId (int id){
            return tipoPanoDAO.porId(id);
        }
	public  boolean Insert (tipo_pano tipopa){
            return tipoPanoDAO.Insert(tipopa);
        }
	public  boolean Update (tipo_pano tipopa){
            return tipoPanoDAO.Update(tipopa);
        }
	public  boolean Delete (Integer id){
            return tipoPanoDAO.Delete(id);
        }
}
