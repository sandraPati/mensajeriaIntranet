/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.tipo_contrato;
import java.util.List;

public interface TipoContratoDAO {
    public  List<tipo_contrato> findAll ();
	public  tipo_contrato porId (int id);
}
