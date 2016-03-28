/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.nomina;
import java.util.List;

public interface NominaDAO {
    public  List<nomina> findAll (String a,String m,int cont);
	public  int tieneNominas (int cont);
	public  nomina ById (int id);
	public  List<nomina> FiltrarMA (nomina n);
	public  List<nomina> FiltrarM (nomina n);
	public  List<nomina> FiltrarA (nomina n);
	public  List<nomina> Filtrar (nomina n);
	
	
	
	public  nomina UltimoPorEmpleado (String nif);
	public  boolean existeNominaM (String nif,String mes,String anio);
        public  boolean existeNominaMporID (String nif,String mes,String anio,int id);
	public  boolean Insert (nomina cont);
	public  String Update (nomina cont);
	public  String Delete (int id);
}
