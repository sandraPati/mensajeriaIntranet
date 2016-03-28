/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proyecto_certificaciones;
import java.util.List;

public interface ProyectoCertificacionesDAO {
    public  List<proyecto_certificaciones> findAll (int idProyectoPresupuesto);
	public  proyecto_certificaciones porId (int id);
	public  int maximo (int idProyectoPresupuesto);
        public  int existeCertificaciones (int idPropuesta);
        public  int existeCertificacionesSemana (int idPropuesta,int num);
	public  String Insert (proyecto_certificaciones presu);
	public  String Update (proyecto_certificaciones presu);
	public  String Delete (Integer id);
}
