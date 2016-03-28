/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.puertas;
import java.util.List;

public interface PuertaDAO {
    public  List<puertas> findAll (int idPano);
    public  puertas porID (int id);
    
    public  String Insert (puertas v);
    public  String InsertPaso (puertas v);
	public  String Update (puertas v);
	public  String Delete (Integer id);
	public  String DeletePano (Integer id);
}
