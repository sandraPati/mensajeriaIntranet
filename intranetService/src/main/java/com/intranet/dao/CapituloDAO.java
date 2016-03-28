/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.capitulos;
import java.util.List;

public interface CapituloDAO {
    public  List<capitulos> findAll (String buscar);
	public  capitulos porId (int id);
	public  boolean existe (String nombre);
	public  boolean existeU (capitulos c);
	public  String Insert (capitulos cap);
	public  String Update (capitulos cap);
	public  String Delete (Integer id);
}
