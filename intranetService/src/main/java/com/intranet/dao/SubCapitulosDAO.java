/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.subcapitulos;
import java.util.List;

public interface SubCapitulosDAO {
    public  List<subcapitulos> findAll (String buscar);
	public  List<subcapitulos> listaPorCapitulo (int idCapitulo);
	public  List<subcapitulos> filtro (int idCapitulo);
	public  subcapitulos porCapitulo (int idCapitulo,int id);
	public  subcapitulos porId (int id);
	public  boolean existe (String nombre);
	public  boolean existeU (subcapitulos s);
	public  String Insert (subcapitulos subcap);
	public  String Update (subcapitulos subcap);
	public  String Delete (Integer id);
}
