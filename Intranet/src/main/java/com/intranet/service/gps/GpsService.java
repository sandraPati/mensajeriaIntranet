/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.gps;

import com.intranet.beans.gps;
import com.intranet.dao.GpsDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gpsService")
public class GpsService {
    @Autowired 
    GpsDAO gpsDAO;
    
    public  gps findAll (String nif){
        return gpsDAO.findAll(nif);
    }
    public  List<gps> findAllHoy (String nif){
        return gpsDAO.findAllHoy(nif);
    }
    public  List<gps> findFecha (String nif,String fecha){
        return gpsDAO.findFecha(nif,fecha);
    }
    public  boolean validaExiste (String nif){
        return gpsDAO.validaExiste(nif);
    }
}
