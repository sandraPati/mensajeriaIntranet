/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.contrato;
import java.util.List;

public interface ContratoDAO {
    public  List<contrato> findAll (String nif);
	public  contrato verultimo (String nif);
	public  boolean validafechas (contrato cont);
	public  contrato porId (int id);
	//public  boolean existeContratoE (String nif);
	public  String Insert (contrato cont);
	public  String Update (contrato cont);
	public  String Delete (int id);
	
	public  List<contrato> FiltrarCmaD (contrato n);
	public  List<contrato> FiltrarCmaH (contrato n);
	public  List<contrato> FiltrarCmD (contrato n);
	public  List<contrato> FiltrarCmH (contrato n);
	public  List<contrato> FiltrarCaD (contrato n);
	public  List<contrato> FiltrarCaH (contrato n);
        public  int UContratoF (String nif);
        public  int UtieneContratoF (String nif);
}
