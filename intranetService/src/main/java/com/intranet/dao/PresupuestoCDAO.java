/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.estancias;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoc;
import java.util.List;

public interface PresupuestoCDAO {
    public  presupuestoc porId (int id);
    public  List<presupuesto> findAll (int idProp);
    public  List<presupuestoc> grupo (int idProp,int idE);
    public  int ultimoPresupuestoC (int idProp,int idCap);
    public  int ultimoPresupuestoCid (int idProp,int idCap);
    public  boolean Insert (presupuestoc presu);
    public  boolean Upd (presupuestoc presu);
    public  boolean Delete (int id); 
    public  boolean DeletePC(int idP,int idC); 
    public  List<presupuesto> presupuestos (int idPresuC);
    
    
    public  boolean presupPropuesta (int idP);
    public  List<presupuestoc> presupuestoCapitulos (int idP);
    public  List<presupuestoc> presupuestoCapitulosADD (int idP);
    public  String UpdateEstado (int idP);
}
