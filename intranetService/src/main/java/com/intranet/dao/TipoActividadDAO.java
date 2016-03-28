/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipo_actividades;
import java.util.List;

public interface TipoActividadDAO {
    public List<tipo_actividades> all();
	public tipo_actividades porId(int id);
	public  boolean existe (String nombre);
	public  boolean existeU (tipo_actividades t);
	public  String Insert (tipo_actividades tipopa);
	public  String Update (tipo_actividades tipopa);
	public  String Delete (Integer id);
}
