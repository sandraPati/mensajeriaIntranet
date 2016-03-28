/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.panos;
import com.intranet.beans.presupuesto_expres;
import java.util.List;


public interface PresupuestoExpresDAO {
    public  presupuesto_expres presupExpresIDE (int id);
    public  presupuesto_expres presupExpresIDE2 (int id);
    public  boolean insert (presupuesto_expres obj);
    public  boolean insert2 (presupuesto_expres obj);
    public  boolean update (presupuesto_expres obj);
    public  boolean update2 (presupuesto_expres obj);
    public  int existe (int idP,int idE);
    public  int existecount (int idP,int idE);
    public  boolean delete (int idP,int idE);
    public  boolean deleteP (int idP);
    public List<panos> panosExpres(int idE);
    public List<panos> panosExpresElejidos(int idE);
}
