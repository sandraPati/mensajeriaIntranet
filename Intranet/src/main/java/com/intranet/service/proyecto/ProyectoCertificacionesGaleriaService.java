/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proyecto;

import com.intranet.beans.proyecto_certificaciones_galeria;
import com.intranet.dao.ProyectoCartificacionesGaleriaDAO;
import java.io.FileInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proyectoCertificacionesGaleriaService")
public class ProyectoCertificacionesGaleriaService {
    @Autowired
    ProyectoCartificacionesGaleriaDAO proyectoCartificacionesGaleriaDAO;
    
    public List<proyecto_certificaciones_galeria> lista(int id){
        return proyectoCartificacionesGaleriaDAO.lista(id);
    }
    public List<proyecto_certificaciones_galeria> listaProyecto(int id){
        return proyectoCartificacionesGaleriaDAO.listaProyecto(id);
    }
	public proyecto_certificaciones_galeria porId(int id){
        return proyectoCartificacionesGaleriaDAO.porId(id);
    }
	public proyecto_certificaciones_galeria porIdNombre(String nombre){
        return proyectoCartificacionesGaleriaDAO.porIdNombre(nombre);
    }
	public boolean existe(String nombreimg){
        return proyectoCartificacionesGaleriaDAO.existe(nombreimg);
    }
	public String insertar(proyecto_certificaciones_galeria p){
        return proyectoCartificacionesGaleriaDAO.insertar(p);
    }
        public String insertar2(proyecto_certificaciones_galeria p){
        return proyectoCartificacionesGaleriaDAO.insertar2(p);
    }
	public String update(proyecto_certificaciones_galeria p){
        return proyectoCartificacionesGaleriaDAO.update(p);
    }
	public String eliminar(int id){
        return proyectoCartificacionesGaleriaDAO.eliminar(id);
    }
	public void guardarImagenProveedor(int id){
         proyectoCartificacionesGaleriaDAO.guardarImagenProveedor(id);
    }
        
}
