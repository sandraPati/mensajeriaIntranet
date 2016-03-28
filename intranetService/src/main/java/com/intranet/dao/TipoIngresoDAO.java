/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipoingreso;
import java.util.List;

public interface TipoIngresoDAO {
    public  List<tipoingreso> findAll ();
    public  tipoingreso porId(int id);
}
