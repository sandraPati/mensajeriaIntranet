/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.estancias;
import com.intranet.beans.plantillaPresupuesto;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.presupuestosGrupo;
import java.util.List;


public interface PlantillaPresupuestoDAO {
   
    public  boolean Insert (plantillaPresupuesto pp);
    public  boolean delete (int id);
    public  List<plantillaPresupuesto> todasPlantillas ();
    public  int existe (int idP);
    public  int existePlantilla ();
    public  plantillaPresupuesto porID (int id);
    public  plantillaPresupuesto porIDP (int idP);
}
