/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.tipo_estancia;
import com.intranet.dao.TipoEstanciaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoEstanciasService")
public class TipoEstanciasService {
    @Autowired
    TipoEstanciaDAO tipoEstanciaDAO;
    
        public  List<tipo_estancia> findAll (String buscar){
            return tipoEstanciaDAO.findAll(buscar);
        }
	public  tipo_estancia porId (int id){
            return tipoEstanciaDAO.porId(id);
        }
	public  String Insert (tipo_estancia tipopa){
            return tipoEstanciaDAO.Insert(tipopa);
        }
	public  String Update (tipo_estancia tipopa){
            return tipoEstanciaDAO.Update(tipopa);
        }
	public  String Delete (Integer id){
            return tipoEstanciaDAO.Delete(id);
        }
}
