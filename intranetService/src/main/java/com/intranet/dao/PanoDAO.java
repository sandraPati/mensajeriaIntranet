/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.panos;
import java.util.List;

public interface PanoDAO {
    public  List<panos> findAll (int idEstancia);
    public  List<panos> findAllPresupSuperf (int idE,int idPresu);
	public  panos porID (int id);
        public  int idultimo (int idE);
        
	public  int Insert (panos pa);
        public  int InsertVolcar (panos pa);
        public  String Updateu (panos pa);
	public  String Update (panos pa);
        public  String UpdateVentana (panos pa);
        public  String UpdatePuerta (panos pa);
        public  String UpdateArmario (panos pa);
        
	public  String Delete (Integer id);
	public  String DeleteEstancia (Integer id);
}
