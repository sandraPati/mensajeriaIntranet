/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proyecto;

import com.intranet.beans.proyecto_presupuestos;
import com.intranet.dao.ProyectoPresupuestoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proyectoPresupuestoService")
public class ProyectoPresupuestoService {
     @Autowired
     ProyectoPresupuestoDAO proyectoPresupuestoDAO;
     
     
        public  List<proyecto_presupuestos> findAll (int idPropuesta,int idcap){
            return proyectoPresupuestoDAO.findAll(idPropuesta,idcap);
        }
        public  List<proyecto_presupuestos> findAllPPres (int idPresup){
            return proyectoPresupuestoDAO.findAllPPres(idPresup);
        }
	public  List<proyecto_presupuestos> findAll2 (int idPropuesta){
            return proyectoPresupuestoDAO.findAll2(idPropuesta);
        }
	public  proyecto_presupuestos porId (int id){
            return proyectoPresupuestoDAO.porId(id);
        }
	public  String Insert (proyecto_presupuestos presu){
            return proyectoPresupuestoDAO.Insert(presu);
        }
	public  String Update (proyecto_presupuestos presu){
            return proyectoPresupuestoDAO.Update(presu);
        }
	public  String Delete (Integer id){
            return proyectoPresupuestoDAO.Delete(id);
        }
}
