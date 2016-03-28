/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.presupuesto_superficie;
import java.util.List;

public interface PresupuestoSuperficiesDAO {
    public  List<presupuesto_superficie> findAll (int id_presup);
	public  presupuesto_superficie buscar (presupuesto_superficie p);
        public  int buscarcount (presupuesto_superficie p);
        public  int buscarid (presupuesto_superficie p);
        public  int tieneRegistros (int p);
        public  presupuesto_superficie porID (int id);
	public  boolean existe (presupuesto_superficie p);
	public  String Insert (presupuesto_superficie presu);
	public  String Update (presupuesto_superficie presu);
	public  String Delete (int id);
	public  String DeleteU (presupuesto_superficie p);
        public  String DeleteEstancia (presupuesto_superficie p);
}
