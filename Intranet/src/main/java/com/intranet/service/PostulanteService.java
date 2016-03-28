/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.cvpostulante;
import com.intranet.beans.postulantes;
import com.intranet.dao.PostulanteDAO;
import java.io.FileInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postulanteService")
public class PostulanteService {
    @Autowired
    PostulanteDAO postulanteDAO;
    
        public  List<postulantes> findAll (){
           return postulanteDAO.findAll();
        }
	public  List<postulantes> enproceso (){
            return postulanteDAO.enproceso();
        }
	public  List<postulantes> descartados (){
            return postulanteDAO.descartados();
        }
	
	public  int cantidadDia (){
            return postulanteDAO.cantidadDia();
        }
	public  cvpostulante cantidadesEstado (){
            return postulanteDAO.cantidadesEstado();
        }
	public  postulantes ByNif (String nif){
            return postulanteDAO.ByNif(nif);
        }
	//public  postulantes ByDocI (String doc);
	public  boolean Insert (postulantes emp){
            return postulanteDAO.Insert(emp);
        }
	public  int validaEmail (String email){
            return postulanteDAO.validaEmail(email);
        }
	public  boolean validaNIf (String nif){
            return postulanteDAO.validaNIF(nif);
        }
	public  int enProceso (String nif){
            return postulanteDAO.enProceso(nif);
        }
	public  String enProcesoFin (postulantes p){
            return postulanteDAO.enProcesoFin(p);
        }
	public  int descartado (String nif){
            return postulanteDAO.descartado(nif);
        }
	public  int restaurar (postulantes p){
            return postulanteDAO.restaurar(p);
        }
	public  String UpdateSinImagenSinCV (postulantes emp){
            return postulanteDAO.UpdateSinImagenSinCV(emp);
        }
	public  String UpdateUC (postulantes emp){
            return postulanteDAO.UpdateUC(emp);
        }
	//public  boolean UpdateImagenCV (postulantes emp,Media media,Media mediaPdf);
	
	public  String UpdateCV (postulantes emp,FileInputStream fis, int longitudBytes){
            return postulanteDAO.UpdateCV(emp,fis,longitudBytes);
        }
	public  String UpdateImagen (postulantes emp){
            return postulanteDAO.UpdateImagen(emp);
        }
	public  String UpdateTamanoImagen (postulantes emp){
            return postulanteDAO.UpdateTamanoImagen(emp);
        }
	public String guardarImagenProveedor(postulantes postulante){
            return postulanteDAO.guardarImagenProveedor(postulante);
        }
	
	public  int volcaraEmpleado (postulantes emp){
            return postulanteDAO.volcaraEmpleado(emp);
        }
        
        public  boolean updateEstadoInf (postulantes emp){
            return postulanteDAO.updateEstadoInf(emp);
        }
        
}
