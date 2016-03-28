/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.perfiles;
import java.util.List;

public interface PerfilDAO {
    public  List<perfiles> findAll();
    public  perfiles ById(int id);
}
