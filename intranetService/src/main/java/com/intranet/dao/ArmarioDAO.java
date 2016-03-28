/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.armarios;
import java.util.List;


public interface ArmarioDAO {
    public  List<armarios> findAll (int idPano);
    public  armarios porID (int id);
    
    public  String Insert (armarios v);
	public  String Update (armarios v);
	public  String Delete (Integer id);
	public  String DeletePano (Integer id);
}
