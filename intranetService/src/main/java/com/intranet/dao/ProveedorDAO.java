/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proveedores;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.List;

public interface ProveedorDAO {
    public List<proveedores> lista(String buscar);
	public proveedores porId(int id);
	public boolean insertar(proveedores p);
	public boolean insertarSinImagen(proveedores p);
	public String upd(proveedores p);
	public String update(proveedores p);
	public String updateSinImagen(proveedores p);
	public String delete(int id);
	public String estadoCalificasion(proveedores p);
	public  String UpdateImagen (proveedores p);
        public  String UpdateAprobado (int id);
        public  String UpdateDesaprobado (int id);
	public void guardarImagenProveedor(String num_cuenta);
        public  String UpdateContrato (Date fechaContrato,int id);
        public boolean updvisible(proveedores p);
}
