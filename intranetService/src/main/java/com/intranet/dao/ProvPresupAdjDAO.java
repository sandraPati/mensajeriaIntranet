/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.prov_presup_adj;
import java.util.List;


public interface ProvPresupAdjDAO {
    public  List<prov_presup_adj> findAll (int idPP);
    public  prov_presup_adj porID (int id);
    
    public  boolean Insert (prov_presup_adj est);
    public  boolean Update (prov_presup_adj est);
    public  boolean Delete (Integer id);
    public  boolean DeleteID (Integer id);
}
