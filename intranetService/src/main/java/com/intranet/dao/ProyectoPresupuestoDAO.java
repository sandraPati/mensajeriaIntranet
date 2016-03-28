/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proyecto_presupuestos;
import java.util.List;

public interface ProyectoPresupuestoDAO {
    public  List<proyecto_presupuestos> findAll (int idPropuesta,int idcap);
    public  List<proyecto_presupuestos> findAllPPres (int idPres);
	public  List<proyecto_presupuestos> findAll2 (int idPropuesta);
	public  proyecto_presupuestos porId (int id);
	public  String Insert (proyecto_presupuestos presu);
	public  String Update (proyecto_presupuestos presu);
	public  String Delete (Integer id);
}
