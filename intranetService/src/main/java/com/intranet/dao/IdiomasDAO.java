/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.idiomas;
import java.util.List;

public interface IdiomasDAO {
    public  List<idiomas> findAll (String nif);
	public  idiomas porId (int id);
        public  idiomas porNIF (String nif);
	//public  boolean existe (String nombre);
	public  String Insert (idiomas cap);
	public  String Update (idiomas cap);
	public  String Delete (int id);
}
