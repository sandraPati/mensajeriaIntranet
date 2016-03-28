/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.perfiles;
import com.intranet.beans.postulantes;
import com.intranet.dao.LoginDAO;
import com.intranet.dao.PerfilDAO;
import com.intranet.dao.PerfilProfesionalDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class ILoginDAO extends UtilTemplateDAO implements LoginDAO{

    @Autowired(required = true)
    PerfilDAO perfilDAO;
    @Autowired(required = true)
    PerfilProfesionalDAO perfilProfesionalDAO;
    
    @Override
    public int login(String usuario, String contrasenna) {
        String sql = "select count(*)as resultado from empleados e  where e.usuario=? and contrasenna=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{usuario,contrasenna},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = 0;
                if(rs.getInt("resultado")>t)
	        {
	          t= 1;
	        }
	        	   
                return t;
        }
        });
    }

    @Override
    public empleados Usuario(String u, String p) {
        String sql = "SELECT nif,id_perfil,nombre,apellidos FROM empleados where usuario=? and contrasenna=? ";
        empleados est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{u,p},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados e = new empleados();
                e.setNif(rs.getString("nif"));
                int idC=rs.getInt("id_perfil");
                try {
                    perfiles cu=perfilDAO.ById(idC);
                    e.setId_perfil(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombre(rs.getString("nombre"));
	        e.setApellidos(rs.getString("apellidos"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String ISEstadoUsu(String nif) {
        String sql = "update empleados set sesion=true where nif=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String CSEstadoUsu(String nif) {
         String sql = "update empleados set sesion=false where nif=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public int loginPostulante(String usuario, String contrasenna) {
         String sql = "select count(*)as resultado from postulante e  where e.usuario=? and contrasenna=? and estado=1 or estado=2";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{usuario,contrasenna},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = 0;
                if(rs.getInt("resultado")>t)
	        {
	          t= 1;
	        }
	        	   
                return t;
        }
        });
    }

    @Override
    public int loginCliente(String usuario, String contrasenna) {
        String sql = "select count(*)as resultado from clientes e  where e.usuario=? and contrasenna=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{usuario,contrasenna},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = 0;
                if(rs.getInt("resultado")>t)
	        {
	          t= 1;
	        }
	        	   
                return t;
        }
        });
    }

    @Override
    public postulantes UsuarioPostulante(String u, String p) {
        String sql = "SELECT documento_identificacion FROM postulante where usuario=? and contrasenna=? ";
        postulantes est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{u,p},new RowMapper<postulantes>(){
        @Override
            public postulantes mapRow(ResultSet rs, int i) throws SQLException {
                postulantes e = new postulantes();
                e.setDocuemnto_identidad(rs.getString("documento_identificacion"));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public clientes UsuarioCliente(String u, String p) {
        String sql = "SELECT nif,nombre,apellidos FROM clientes where usuario=? and contrasenna=? ";
        clientes est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{u,p},new RowMapper<clientes>(){
        @Override
            public clientes mapRow(ResultSet rs, int i) throws SQLException {
                clientes e = new clientes();
                e.setNif(rs.getString("nif"));
	        e.setNombre(rs.getString("nombre"));
	        e.setApellidos(rs.getString("apellidos"));
                return e;
        }
        });
        
        return est;
    }
    
}
