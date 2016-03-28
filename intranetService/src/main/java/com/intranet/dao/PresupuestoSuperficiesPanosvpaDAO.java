/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.beans.presupuesto_superficies_panos_vpa;
import java.util.List;


public interface PresupuestoSuperficiesPanosvpaDAO {
    //idPSE es el id de la tabla presupuesto_superficies_panos
    //el idP es id de ventanas/pertas/armarios
    public  List<presupuesto_superficies_panos_vpa> findAll (int idPSE);
    public  List<presupuesto_superficies_panos_vpa> findAllMostrar (int idPSE);
    public  List<presupuesto_superficies_panos_vpa> findAllMostrarP(int idPSE);
    public  List<presupuesto_superficies_panos_vpa> findAllMostrarA (int idPSE);
    public  int Insert (presupuesto_superficies_panos_vpa presu);
    public  int InsertP (presupuesto_superficies_panos_vpa presu);
    public  int InsertA (presupuesto_superficies_panos_vpa presu);
    public  int buscar (int idP,int idPSE);
    public  int buscarcount (int idP,int idPSE);
    public  int buscarcountP (int idP,int idPSE);
    public  int buscarcountA (int idP,int idPSE);
    public  int DeleteID (int idP,int idPSE);
    public  int DeleteIDPuerta (int idP,int idPSE);
    public  int DeleteIDArmario (int idP,int idPSE);
    public  int DeletePorIdPSE (int idPSE);
}
