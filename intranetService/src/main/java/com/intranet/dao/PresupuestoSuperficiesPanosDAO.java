/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.presupuesto_superficies_panos;
import java.util.List;


public interface PresupuestoSuperficiesPanosDAO {
    //idPSE el id de la tabla presupuesto_superficies
    public  List<presupuesto_superficies_panos> findAll (int idPSE);
    public  List<presupuesto_superficies_panos> findAllMostrar (int idPSE);
    public  int Insert (presupuesto_superficies_panos presu);
    public  String UpdateLargoPresup (presupuesto_superficies_panos presu);
    public  int buscar (int idP,int idPSE);
    public  presupuesto_superficies_panos buscarID (int id);
    public  int buscarcount (int idP,int idPSE);
    public  int ultimo (int idP,int idPSE);
    public  int buscaridPresupSup (int id);
    public  int DeleteID (int idP,int idPSE);
    public  int DeletePorIdPSE (int idPSE);
}
