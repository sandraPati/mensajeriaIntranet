/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.estudios;
import java.util.List;

public interface EstudiosDAO {
    public  List<estudios> findAll (String postulante_doc);
    public  estudios porNifE (String id);	
    public  estudios porNif (int id);
	//public  boolean existe (String nombre);
	public  String Insert (estudios cap);
	public  String Update (estudios cap);
	public  String Delete (int id);
}
