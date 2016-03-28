/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.agenda;

import com.intranet.beans.TareaSupEmp;
import com.intranet.dao.TareaSupEmpDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tareaSupEmpService")
public class TareaSupEmpService {
    @Autowired 
    TareaSupEmpDAO tareaSupEmpDAO;
    
        public List<TareaSupEmp> getTareasECRecordatorios(String nifs){
            return tareaSupEmpDAO.getTareasECRecordatorios(nifs);
        }
	public List<TareaSupEmp> getTareasECRecordatoriosE(String nifs){
            return tareaSupEmpDAO.getTareasECRecordatoriosE(nifs);
        }
	public List<TareaSupEmp> getTareasECRecordatoriosC(String nifs){
            return tareaSupEmpDAO.getTareasECRecordatoriosC(nifs);
        }
	public List<TareaSupEmp> getTareasS(){
            return tareaSupEmpDAO.getTareasS();
        }
	public List<TareaSupEmp> getTareas(String nifs,String nif){
            return tareaSupEmpDAO.getTareas(nifs,nif);
        }
	public List<TareaSupEmp> getTareasE(String nif){
            return tareaSupEmpDAO.getTareasE(nif);
        }
	public List<TareaSupEmp> getTareasC(String nif){
            return tareaSupEmpDAO.getTareasC(nif);
        }
        public TareaSupEmp porId(int id){
            return tareaSupEmpDAO.porId(id);
        }
	public String insertTarea(TareaSupEmp t){
            return tareaSupEmpDAO.insertTarea(t);
        }
	public String updateTarea(TareaSupEmp t){
            return tareaSupEmpDAO.updateTarea(t);
        }
	public String updateCondicion(TareaSupEmp t){
            return tareaSupEmpDAO.updateCondicion(t);
        }
	public String cerrarRecordatorio(TareaSupEmp t){
            return tareaSupEmpDAO.cerrarRecordatorio(t);
        }
	//public boolean updateCerrarTareaEmpleado(TareaSupEmp t);
	public String deleteTarea(TareaSupEmp t){
            return tareaSupEmpDAO.deleteTarea(t);
        }
}
