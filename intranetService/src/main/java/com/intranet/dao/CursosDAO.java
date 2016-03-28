/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.cursos;
import java.util.List;

public interface CursosDAO {
    public  List<cursos> findAll ();
    public  cursos porId (int id);
}
