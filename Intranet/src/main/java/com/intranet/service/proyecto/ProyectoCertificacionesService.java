/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proyecto;

import com.intranet.beans.proyecto_certificaciones;
import com.intranet.dao.ProyectoCertificacionesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proyectoCertificacionesService")
public class ProyectoCertificacionesService {
    @Autowired
    ProyectoCertificacionesDAO proyectoCertificacionesDAO;
    
        public  List<proyecto_certificaciones> findAll (int idProyectoPresupuesto){
            return proyectoCertificacionesDAO.findAll(idProyectoPresupuesto);
        }
	public  proyecto_certificaciones porId (int id){
            return proyectoCertificacionesDAO.porId(id);
        }
	public  int maximo (int idProyectoPresupuesto){
            return proyectoCertificacionesDAO.maximo(idProyectoPresupuesto);
        }
        public  int existeCertificaciones (int idPropuesta){
            return proyectoCertificacionesDAO.existeCertificaciones(idPropuesta);
        }
        public  int existeCertificacionesSemana (int idPropuesta,int num){
            return proyectoCertificacionesDAO.existeCertificacionesSemana(idPropuesta,num);
        }
	public  String Insert (proyecto_certificaciones presu){
            return proyectoCertificacionesDAO.Insert(presu);
        }
	public  String Update (proyecto_certificaciones presu){
            return proyectoCertificacionesDAO.Update(presu);
        }
	public  String Delete (Integer id){
            return proyectoCertificacionesDAO.Delete(id);
        }
}
