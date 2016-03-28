/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.users;
import com.intranet.dao.UsuariosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioService {
    @Autowired
    UsuariosDAO usuariosDAO;
    public List<users> getList() {        
        return usuariosDAO.getList();
    }

    public users getById(String id) {
        return usuariosDAO.getByNif(id);
    }
    
     public users ResuperarUC(String email) {
        return usuariosDAO.ResuperarUC(email);
    }
    
     public users porACargo(String id) {
        return usuariosDAO.porACargo(id);
    }

    public boolean validaExiste(users t) {
        return usuariosDAO.validaExiste(t);
    }
    
    public int validaExisteUC(users t) {
        return usuariosDAO.validaExisteUC(t);
    }
    public int validaExisteUCcorreo(users t) {
        return usuariosDAO.validaExisteUCcorreo(t);
    }
    public int validaExisteUCNif(users t) {
        return usuariosDAO.validaExisteUCNif(t);
    }
    public int validaExisteUCNifcorreo(users t) {
        return usuariosDAO.validaExisteUCNifcorreo(t);
    }

     public int validaNIF(String nif) {
        return usuariosDAO.validaNIF(nif);
    }

    public String insertar(users t) {
        return usuariosDAO.insertar(t);
    }

    public String anadirRolaUser(String nif,int rol) {
        return usuariosDAO.anadirRolaUser(nif,rol);
    }
    
    public String update(users t) {
        return usuariosDAO.update(t);
    }
    public String updateEstado(users t) {
        return usuariosDAO.updateEstado(t);
    }
    public String updateCorreo(users t) {
        return usuariosDAO.updateCorreo(t);
    }
    public String updateEmail(users t) {
        return usuariosDAO.updateEmail(t);
    }
    public String updateRol(String nif,int idR) {
        return usuariosDAO.updateRol(nif,idR);
    }

    public users getByLogin(String u) {
        return usuariosDAO.getByLogin(u);
    }

    public String darBaja(String codT,boolean e) {
        return usuariosDAO.darBaja(codT,e);
    }
    
    public boolean ISEstadoUsu(String nif){
        return usuariosDAO.ISEstadoUsu(nif);
    }
    public boolean CSEstadoUsu(String nif){
        return usuariosDAO.CSEstadoUsu(nif);
    }
}
