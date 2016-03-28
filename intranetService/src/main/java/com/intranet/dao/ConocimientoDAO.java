/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.conocimientos;
import java.util.List;


public interface ConocimientoDAO {
    public  List<conocimientos> findAll (String nif);
    public  conocimientos porId (int id);
    public  String Insert (conocimientos cap);
    public  String Update (conocimientos cap);
    public  String Delete (int id);
}
