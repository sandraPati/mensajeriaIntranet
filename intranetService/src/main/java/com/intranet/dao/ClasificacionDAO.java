/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.clasificaciones;
import com.intranet.beans.proveedores;
import java.util.List;

public interface ClasificacionDAO {
    public List<proveedores> lista(String buscar);
    public List<proveedores> listavisible(String buscar);
    public List<proveedores> listavisibleB(int id);
	public List<proveedores> filtar(int buscar);
	public List<clasificaciones> AllcalificacionProveedor(int id);
	public clasificaciones calificacionProveedorEmpleado(int id,String nif);
	public String insertar(clasificaciones p);
	public String update(clasificaciones p);
	
	public boolean existencia(int id,String nif);
}
