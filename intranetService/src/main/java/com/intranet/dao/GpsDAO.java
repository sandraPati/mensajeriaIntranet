/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.gps;
import java.util.List;


public interface GpsDAO {
    public  gps findAll (String nif);
    public  List<gps> findAllHoy (String nif);
    public  List<gps> findFecha (String nif,String fecha);
    public boolean validaExiste(String nif);
}
