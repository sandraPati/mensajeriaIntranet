/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.propuesta;

import com.intranet.beans.estancias;
import com.intranet.dao.EstanciasDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("estanciasService")
public class EstanciasService {
    @Autowired
    EstanciasDAO estanciasDAO;
    
        public  List<estancias> findAll (String buscar){
            return estanciasDAO.findAll(buscar);
        }
	public  List<estancias> listaPropuesta (int idP){
            return estanciasDAO.listaPropuesta(idP);
        }
        public  List<estancias> listaEstanciasPresup (int idP,int idPresup){
            return estanciasDAO.listaEstanciasPresup(idP,idPresup);
        }
	public  estancias porID (int id){
            return estanciasDAO.porID(id);
        }
        public  int idultimo (int idP){
            return estanciasDAO.idultimo(idP);
        }
	public  Integer porPropuestaEstancia (int idPropuesta,int numero){
            return estanciasDAO.porPropuestaEstancia(idPropuesta,numero);
        }
	public  int Insert (estancias est){
            return estanciasDAO.Insert(est);
        }
	public  String Update (estancias est){
            return estanciasDAO.Update(est);
        }
	public  String Delete (Integer id){
            return estanciasDAO.Delete(id);
        }
}
