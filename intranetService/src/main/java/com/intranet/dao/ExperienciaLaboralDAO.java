/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.experiencia_laboral;
import java.util.List;

public interface ExperienciaLaboralDAO {
        public  List<experiencia_laboral> findAll (String nif);
	public  experiencia_laboral porNif (int id);
	//public  boolean existe (String nombre);
	public  String Insert (experiencia_laboral cap);
	public  String Update (experiencia_laboral cap);
	public  String Delete (int cap);

}
