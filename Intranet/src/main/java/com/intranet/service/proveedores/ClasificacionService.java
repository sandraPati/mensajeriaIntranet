/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.clasificaciones;
import com.intranet.beans.proveedores;
import com.intranet.dao.ClasificacionDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clasificacionService")
public class ClasificacionService {
    @Autowired
    ClasificacionDAO clasificacionDAO;
    
    public List<proveedores> lista(String buscar){
        return clasificacionDAO.lista(buscar);
    }
    public List<proveedores> listavisible(String buscar){
        return clasificacionDAO.listavisible(buscar);
    }
    public List<proveedores> listavisibleB(int id){
        return clasificacionDAO.listavisibleB(id);
    }
	public List<proveedores> filtar(int buscar){
        return clasificacionDAO.filtar(buscar);
    }
	public List<clasificaciones> AllcalificacionProveedor(int id){
        return clasificacionDAO.AllcalificacionProveedor(id);
    }
	public clasificaciones calificacionProveedorEmpleado(int id,String nif){
        return clasificacionDAO.calificacionProveedorEmpleado(id,nif);
    }
	public String insertar(clasificaciones p){
        return clasificacionDAO.insertar(p);
    }
	public String update(clasificaciones p){
        return clasificacionDAO.update(p);
    }
	
	public boolean existencia(int id,String nif){
        return clasificacionDAO.existencia(id,nif);
    }
}
