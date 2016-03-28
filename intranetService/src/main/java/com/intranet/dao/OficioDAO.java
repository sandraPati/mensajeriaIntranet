/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.oficios;
import java.util.List;

public interface OficioDAO {
    public  List<oficios> findAll ();
	public  oficios porId (int id);
	
	public  String Insert (oficios cap);
	public  String Update (oficios cap);
	public  String Delete (Integer id);
}
