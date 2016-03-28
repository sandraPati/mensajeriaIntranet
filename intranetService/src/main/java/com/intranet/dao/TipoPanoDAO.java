/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipo_pano;
import java.util.List;

public interface TipoPanoDAO {
    public  List<tipo_pano> findAll (String buscar);
	public  tipo_pano porId (int id);
	public  boolean Insert (tipo_pano tipopa);
	public  boolean Update (tipo_pano tipopa);
	public  boolean Delete (Integer id);
}
