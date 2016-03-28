/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.clientes;
import java.util.List;


public interface ClienteDAO {
    public  List<clientes> findAll (String buscar);
	public  clientes ByNif (String nif);
	public  boolean validaNIF (String nif);
        public  String updateLogeo (clientes emp);
	public  String Insert (clientes emp);
	public  String Update (clientes emp);
	public  String Delete (String nif);
}
