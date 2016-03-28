/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.perfil_profesional;
import java.util.List;

public interface PerfilProfesionalDAO {
    public  List<perfil_profesional> findAll ();
	public  perfil_profesional porId (int id);
	
	public  boolean Insert (perfil_profesional cap);
	public  boolean Update (perfil_profesional cap);
	public  boolean Delete (Integer id);
}
