/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipoidioma;
import java.util.List;

public interface TipoIdiomaDAO {
    public  List<tipoidioma> findAll ();
	public  tipoidioma porId (int id);
}
