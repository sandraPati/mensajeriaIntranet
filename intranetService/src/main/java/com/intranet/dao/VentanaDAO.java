/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.armarios;
import com.intranet.beans.puertas;
import com.intranet.beans.ventanas;
import java.util.List;


public interface VentanaDAO {
    public  List<ventanas> findAll (int idPano);
    public  List<ventanas> findAllEstanciaVentanas (int idE);
    public  float findAllEstancia (int idE);
    public  List<ventanas> findAllPresupSuperficies (int idPano,int idPresupSupPano);
    public  List<puertas> findAllPresupSuperficiesP (int idPano,int idPresupSupPano);
    public  List<armarios> findAllPresupSuperficiesA (int idPano,int idPresupSupPano);
    public  ventanas porID (int id);
    
    public  String Insert (ventanas v);
	public  String Update (ventanas v);
	public  String Delete (Integer id);
	public  String DeletePano (Integer id);
}
