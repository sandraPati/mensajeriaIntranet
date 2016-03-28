/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.users;
import java.util.List;

public interface UsuariosDAO {
    public List<users> getList();
    public users getByNif(String id);
    public users ResuperarUC(String email);
    public users porACargo(String nif);
    public boolean validaExiste(users t);
    public int validaExisteUC(users t);
    public int validaExisteUCcorreo(users t);
    public int validaExisteUCNif(users t);
    public int validaExisteUCNifcorreo(users t);
    public int validaNIF(String nif);
    public users getByLogin(String u);
    public String insertar(users t);
    public String anadirRolaUser(String nif,int rol);
    public String updateRolaUser(String nif,int rol);
    public String update(users t);
    public String updateEstado(users t);
    public String updateCorreo(users t);
    public String updateEmail(users t);
    public String updateRol(String nif,int idR);
    public String darBaja(String nif,boolean e);
    public boolean ISEstadoUsu(String nif);
    public boolean CSEstadoUsu(String nif);
}
