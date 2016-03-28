/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.proveedores;

import com.intranet.beans.proveedores;
import com.intranet.dao.ProveedorDAO;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proveedoresService")
public class ProveedoresService {
    @Autowired
    ProveedorDAO proveedorDAO;
    
        public List<proveedores> lista(String buscar){
            return proveedorDAO.lista(buscar);
        }
	public proveedores porId(int id){
            return proveedorDAO.porId(id);
        }
	public boolean insertar(proveedores p){
            return proveedorDAO.insertar(p);
        }
	public boolean insertarSinImagen(proveedores p){
            return proveedorDAO.insertarSinImagen(p);
        }
	public String upd(proveedores p){
            return proveedorDAO.upd(p);
        }
	public String update(proveedores p){
            return proveedorDAO.update(p);
        }
	public String updateSinImagen(proveedores p){
            return proveedorDAO.updateSinImagen(p);
        }
	public String delete(int id){
            return proveedorDAO.delete(id);
        }
	public String estadoCalificasion(proveedores p){
            return proveedorDAO.estadoCalificasion(p);
        }
	public  String UpdateImagen (proveedores p){
            return proveedorDAO.UpdateImagen(p);
        }
        public  String UpdateAprobado (int id){
            return proveedorDAO.UpdateAprobado(id);
        }
        public  String UpdateDesaprobado (int id){
            return proveedorDAO.UpdateDesaprobado(id);
        }
	public void guardarImagenProveedor(String num_cuenta){
             proveedorDAO.guardarImagenProveedor(num_cuenta);
        }
         public  String UpdateContrato (Date fechaContrato,int id){
            return proveedorDAO.UpdateContrato(fechaContrato,id);
        }
         
         public boolean updvisible(proveedores p){
            return proveedorDAO.updvisible(p);
        }
}
