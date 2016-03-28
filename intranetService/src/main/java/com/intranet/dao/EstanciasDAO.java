/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.estancias;
import java.util.List;

public interface EstanciasDAO {
    public  List<estancias> findAll (String buscar);
	public  List<estancias> listaPropuesta (int idP);
        public  List<estancias> listaEstanciasPresup (int idP,int idPresup);
	public  estancias porID (int id);
        public  int idultimo (int idP);
	public  Integer porPropuestaEstancia (int idPropuesta,int numero);
	public  int Insert (estancias est);
	public  String Update (estancias est);
	public  String Delete (Integer id);
}
