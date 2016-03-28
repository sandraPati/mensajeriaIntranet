/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.tipo_actividades;
import com.intranet.dao.TipoActividadDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tipoActividadService")
public class TipoActividadService {
    @Autowired
    TipoActividadDAO tipoActividadDAO;
    
        public List<tipo_actividades> all(){
            return tipoActividadDAO.all();
        }
	public tipo_actividades porId(int id){
            return tipoActividadDAO.porId(id);
        }
	public  boolean existe (String nombre){
            return tipoActividadDAO.existe(nombre);
        }
	public  boolean existeU (tipo_actividades t){
            return tipoActividadDAO.existeU(t);
        }
	public  String Insert (tipo_actividades tipopa){
            return tipoActividadDAO.Insert(tipopa);
        }
	public  String Update (tipo_actividades tipopa){
            return tipoActividadDAO.Update(tipopa);
        }
	public  String Delete (Integer id){
            return tipoActividadDAO.Delete(id);
        }
}
