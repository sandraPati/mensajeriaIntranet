/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.clientes;
import com.intranet.dao.ClienteDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientesService")
public class ClientesService {
    @Autowired
    ClienteDAO clienteDAO;
    
        public  List<clientes> findAll (String buscar){
            return clienteDAO.findAll(buscar);
        }
	public  clientes ByNif (String nif){
            return clienteDAO.ByNif(nif);
        }
	public  String updateLogeo (clientes emp){
            return clienteDAO.updateLogeo(emp);
        }
	public  boolean validaNIf (String nif){
            return clienteDAO.validaNIF(nif);
        }
       
        public  String Insert (clientes emp){
            return clienteDAO.Insert(emp);
        }
	public  String Update (clientes emp){
            return clienteDAO.Update(emp);
        }
	public  String Delete (String nif){
            return clienteDAO.Delete(nif);
        }
}
