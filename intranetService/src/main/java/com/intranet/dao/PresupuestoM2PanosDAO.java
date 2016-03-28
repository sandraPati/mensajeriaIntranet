/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.presupuestom2panos;


public interface PresupuestoM2PanosDAO {
    public  presupuestom2panos porId (int id);
    public  presupuestom2panos porIdProp (int idP);
    public  presupuestom2panos porIdPresup (int idP);
    public  int buscar (int idP);
    public  int Insert (presupuestom2panos presu);
    public  int Update (presupuestom2panos presu);
    public  int Delete (int id);
    public  int DeleteidPresu (int id);
    public  int DeletePresup (int id);
}
