/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipoiva;
import java.util.List;

public interface TipoIvaDAO {
  public  List<tipoiva> findAll ();
    public  tipoiva porId(int id);  
}
