/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.TareaPersonal;
import java.util.List;

public interface TareaPersonalDAO {
    public List<TareaPersonal> getTareas(String nif);
	public String insertTarea(TareaPersonal t);
	public String updateTarea(TareaPersonal t);
	public String deleteTarea(TareaPersonal t);
}
