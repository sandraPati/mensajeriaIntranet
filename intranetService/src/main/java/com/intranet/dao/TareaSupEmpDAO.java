/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.TareaSupEmp;
import java.util.List;

public interface TareaSupEmpDAO {
    public List<TareaSupEmp> getTareasECRecordatorios(String nifs);
	public List<TareaSupEmp> getTareasECRecordatoriosE(String nifs);
	public List<TareaSupEmp> getTareasECRecordatoriosC(String nifs);
	public List<TareaSupEmp> getTareasS();
	public List<TareaSupEmp> getTareas(String nifs,String nif);
	public List<TareaSupEmp> getTareasE(String nif);
	public List<TareaSupEmp> getTareasC(String nif);
        public TareaSupEmp porId(int id);
	public String insertTarea(TareaSupEmp t);
	public String updateTarea(TareaSupEmp t);
	public String updateCondicion(TareaSupEmp t);
	public String cerrarRecordatorio(TareaSupEmp t);
	//public boolean updateCerrarTareaEmpleado(TareaSupEmp t);
	public String deleteTarea(TareaSupEmp t);
}
