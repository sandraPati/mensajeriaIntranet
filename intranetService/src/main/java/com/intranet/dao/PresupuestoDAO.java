/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.capitulos;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import java.util.List;

public interface PresupuestoDAO {
    
    public  presupuesto porID (int id);
	public  int buscar (presupuesto p);
	public  List<presupuesto> findAll (int idPc);
	public   List<presupuesto> presupuestoPropuesta (int idPresupC);
	public   List<presupuesto> presupuestoEstancia (int idestancia);
	public  estancias estanciasPropuesta (int idpropuesta);
	public  List<panos> panosPropuesta (int idestancia);
	public  String Insert (presupuesto presu);
        public  String InsertT (presupuesto presu);
	public  String Update (presupuesto presu);
        public  String UpdateM (presupuesto presu);
        public  String UpdateMedida (presupuesto presu);
	public  String UpdateMonto (presupuesto presu);
        public  int DeleteSC (int idPresup,int idSc);
	public  int Delete (Integer id);
	public  int DeleteU (Integer id);
        public  int DeleteP (Integer id);
	public   List<capitulos> capitulosEnPresupuestosdePropuesta (int idpropuesta);
	public   List<presupuesto> subcapPresupuesto (int idpropuesta,int idcapitulo);
        
        public  List<presupuesto> presupuestoSUBCapitulos (int idP);
        public  List<presupuesto> presupuestoSUBCapitulosADD (int idP,int idC);
        
        public  presupuesto buscarPresupSC (int idPre,int idSc);
        public  int buscarPresupSCid (int idPre,int idSc);
        public  int buscarPresupSCcount (int idPre,int idSc);
}
