/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.objetivos;

import com.intranet.beans.metasEmpleado;
import com.intranet.dao.MetasEmpleadoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("metasEmpleadoService")
public class MetasEmpleadoService {
    @Autowired
    MetasEmpleadoDAO metasEmpleadoDAO;
    
    public  List<metasEmpleado> findAllNif (String nif){
        return metasEmpleadoDAO.findAllNif(nif);
    }
    public  metasEmpleado ById (int id){
        return metasEmpleadoDAO.ById(id);
    }
    public  metasEmpleado ByNif (String nif,int mes,int anio){
        return metasEmpleadoDAO.ByNif(nif, mes, anio);
    }
    public  metasEmpleado ByNifHome (String nif,int mes,int anio){
        return metasEmpleadoDAO.ByNifHome(nif, mes, anio);
    }
    public  boolean Insert (metasEmpleado cont){
        return metasEmpleadoDAO.Insert(cont);
    }
    public  boolean Update (metasEmpleado cont){
        return metasEmpleadoDAO.Update(cont);
    }
}
