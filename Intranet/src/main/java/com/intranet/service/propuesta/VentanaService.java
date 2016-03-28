/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.armarios;
import com.intranet.beans.puertas;
import com.intranet.beans.ventanas;
import com.intranet.dao.VentanaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ventanaService")
public class VentanaService {
    @Autowired
    VentanaDAO ventanaDAO;
    
    public  List<ventanas> findAll (int idPano){
        return ventanaDAO.findAll(idPano);
    }
     public  List<ventanas> findAllEstanciaVentanas (int idE){
        return ventanaDAO.findAllEstanciaVentanas(idE);
    }
    public float findAllEstancia (int idE){
        return ventanaDAO.findAllEstancia(idE);
    }
    
    public  List<ventanas> findAllPresupSuperficies (int idPano,int idPresupSupPano){
        return ventanaDAO.findAllPresupSuperficies(idPano,idPresupSupPano);
    }
    public  List<puertas> findAllPresupSuperficiesP (int idPano,int idPresupSupPano){
        return ventanaDAO.findAllPresupSuperficiesP(idPano,idPresupSupPano);
    }
    public  List<armarios> findAllPresupSuperficiesA (int idPano,int idPresupSupPano){
        return ventanaDAO.findAllPresupSuperficiesA(idPano,idPresupSupPano);
    }
    public  ventanas porID (int id){
        return ventanaDAO.porID(id);
    }
    
    public  String Insert (ventanas v){
        return ventanaDAO.Insert(v);
    }
	public  String Update (ventanas v){
        return ventanaDAO.Update(v);
    }
	public  String Delete (Integer id){
        return ventanaDAO.Delete(id);
    }
	public  String DeletePano (Integer id){
        return ventanaDAO.DeletePano(id);
    }
}
