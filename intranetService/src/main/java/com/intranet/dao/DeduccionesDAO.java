/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.deducciones;

public interface DeduccionesDAO {
    public  deducciones ById (int id);
	public  deducciones UltimoPorNomina (int idnomina);
	public  boolean siexiste (int idnomina);
	public  boolean existeDeduccionM (int idnomina);
	public  String Insert (deducciones cont);
	public  String Update (deducciones cont);
	public  String Delete (int id);
}
