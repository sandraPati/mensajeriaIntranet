/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.finiquito;
import java.util.List;

public interface FiniquitoDAO {
     public  List<finiquito> findAll (String postulante_doc);
     public  finiquito porId (int id);
     public  boolean Insert (finiquito cap);
     public  finiquito ultimo (String nif_empleado);
}
