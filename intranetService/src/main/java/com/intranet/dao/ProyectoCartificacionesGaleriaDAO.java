/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.proyecto_certificaciones_galeria;
import java.io.FileInputStream;
import java.util.List;

public interface ProyectoCartificacionesGaleriaDAO {
    public List<proyecto_certificaciones_galeria> lista(int id);
    public List<proyecto_certificaciones_galeria> listaProyecto(int id);
	public proyecto_certificaciones_galeria porId(int id);
	public proyecto_certificaciones_galeria porIdNombre(String nombre);
	public boolean existe(String nombreimg);
	public String insertar(proyecto_certificaciones_galeria p);
        public String insertar2(proyecto_certificaciones_galeria p);
	public String update(proyecto_certificaciones_galeria p);
	public String eliminar(int id);
	public void guardarImagenProveedor(int id);
}
