/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.postulantes;

public interface LoginDAO {
    public  int login (String usuario,String contrasenna);
	public empleados Usuario(String u,String p);
	public  String ISEstadoUsu(String nif);
	public  String CSEstadoUsu(String nif);	
	public  int loginPostulante (String usuario,String contrasenna);
	public  int loginCliente (String usuario,String contrasenna);
	public postulantes UsuarioPostulante(String u,String p);
	public clientes UsuarioCliente(String u,String p);
}
