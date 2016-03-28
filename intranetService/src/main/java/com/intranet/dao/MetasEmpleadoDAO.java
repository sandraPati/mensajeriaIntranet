/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.metasEmpleado;
import java.util.List;

public interface MetasEmpleadoDAO {
    public  List<metasEmpleado> findAllNif (String nif);
    public  metasEmpleado ById (int id);
    public  metasEmpleado ByNif (String nif,int mes,int anio);
    public  metasEmpleado ByNifHome (String nif,int mes,int anio);
    public  boolean Insert (metasEmpleado cont);
    public  boolean Update (metasEmpleado cont);
}
