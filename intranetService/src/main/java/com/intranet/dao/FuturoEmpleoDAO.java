/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.futuro_empleo;
import java.util.List;

public interface FuturoEmpleoDAO {
    public  List<futuro_empleo> findAll (String nif);
	public  futuro_empleo porPostulante (String nif);
	public  futuro_empleo porNif (String nif);
	public  boolean existeFEP (String nif);
	public  String Insert (futuro_empleo cap);
	public  String Update (futuro_empleo cap);
	public  String Delete (int id);

}
