/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.presupuesto_expres_panos;
import java.util.List;


public interface PresupuestoExpresPanosDAO {
    public List<presupuesto_expres_panos> lta(int idPex);
    public  boolean insert (presupuesto_expres_panos obj);
    public  boolean update (presupuesto_expres_panos obj);
    public  int existe (int idP,int idPex);
    public  boolean delete (int idP,int idPex);
}
