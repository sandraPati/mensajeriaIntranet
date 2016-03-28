/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.cvpostulante;
import com.intranet.beans.postulantes;
import java.io.FileInputStream;
import java.util.List;

public interface PostulanteDAO {
    public  List<postulantes> findAll ();
	public  List<postulantes> enproceso ();
	public  List<postulantes> descartados ();
	
	public  int cantidadDia ();
	public  cvpostulante cantidadesEstado ();
	public  postulantes ByNif (String nif);
	//public  postulantes ByDocI (String doc);
	public  boolean Insert (postulantes emp);
	public  int validaEmail (String email);
	public  boolean validaNIF (String nif);
	public  int enProceso (String nif);
	public  String enProcesoFin (postulantes p);
	public  int descartado (String nif);
	public  int restaurar (postulantes p);
	public  String UpdateSinImagenSinCV (postulantes emp);
	public  String UpdateUC (postulantes emp);
	//public  boolean UpdateImagenCV (postulantes emp,Media media,Media mediaPdf);
	
	public  String UpdateCV (postulantes emp,FileInputStream fis, int longitudBytes);
	public  String UpdateImagen (postulantes emp);
        public  String UpdateTamanoImagen (postulantes emp);
	
	public String guardarImagenProveedor(postulantes postulante);
        public String guardaFotoCarpeta(byte[] p);
	
	public  int volcaraEmpleado (postulantes emp);
        public  boolean updateEstadoInf (postulantes emp);
        
}
