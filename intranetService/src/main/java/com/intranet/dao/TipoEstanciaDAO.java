/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipo_estancia;
import java.util.List;

public interface TipoEstanciaDAO {
    public  List<tipo_estancia> findAll (String buscar);
	public  tipo_estancia porId (int id);
	public  String Insert (tipo_estancia tipopa);
	public  String Update (tipo_estancia tipopa);
	public  String Delete (Integer id);
}
