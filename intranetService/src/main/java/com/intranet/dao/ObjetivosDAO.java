/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.Objetivos;
import java.util.List;

public interface ObjetivosDAO {
    public  List<Objetivos> findAll ();
    public  Objetivos ById (int id);
    public  Objetivos ByNif (String nif);
    public  boolean Insert (Objetivos cont);
    public  boolean Update (Objetivos cont);
    public  boolean existe (String nif);
}
