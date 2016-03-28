/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.Roles;
import com.intranet.beans.users;
import com.intranet.dao.RolesDAO;
import com.intranet.dao.UsuariosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("usuariosDAO")
public class IUsuariosDAO extends UtilTemplateDAO implements UsuariosDAO{
    
    @Autowired(required = true)
    RolesDAO rolesDAO;
    
    @Override
    public List<users> getList() {
        String sql = "SELECT  nif,usuario,contrasenna,estado,email,correousuario,correocontrasenna FROM users";
        List<users> list = this.getJdbcTemplate().query(sql, new RowMapper<users>(){
        @Override
            public users mapRow(ResultSet rs, int i) throws SQLException {
                users user = new users();
                user.setNif(rs.getString("nif"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setEstado(rs.getInt("estado"));
                user.setEmail(rs.getString("email"));
                user.setCorreoUsuario(rs.getString("correousuario"));
                user.setCorreoContreasenna(rs.getString("correocontrasenna"));
                String user_id=user.getNif();
                Roles rl;
                try {
                    
                    rl=(Roles)rolesDAO.getRolesUser(user_id);
                    user.setRol(rl);
                } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                return user;
        }
        });
        return list;
    }

    @Override
    public users getByNif(String id) {
        String sql = "SELECT  nif,usuario,contrasenna,estado,email,correousuario,correocontrasenna FROM users WHERE nif=?";
        users list = this.getJdbcTemplate().queryForObject(sql,new Object[]{id}, new RowMapper<users>(){
        @Override
            public users mapRow(ResultSet rs, int i) throws SQLException {
                users user = new users();
                user.setNif(rs.getString("nif"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setEstado(rs.getInt("estado"));
                user.setEmail(rs.getString("email"));
                user.setCorreoUsuario(rs.getString("correousuario"));
                user.setCorreoContreasenna(rs.getString("correocontrasenna"));
                String user_id=user.getNif();
                Roles rl;
                try {
                    
                    rl=(Roles)rolesDAO.getRolesUser(user_id);
                    user.setRol(rl);
                } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                return user;
        }
        });
        return list;
    }
    
    @Override
    public users ResuperarUC(String email) {
        String sql = "SELECT  nif,usuario,contrasenna,estado,email,correousuario,correocontrasenna FROM users WHERE email=?";
        users list = this.getJdbcTemplate().queryForObject(sql,new Object[]{email}, new RowMapper<users>(){
        @Override
            public users mapRow(ResultSet rs, int i) throws SQLException {
                users user = new users();
                user.setNif(rs.getString("nif"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setEstado(rs.getInt("estado"));
                user.setEmail(rs.getString("email"));
                user.setCorreoUsuario(rs.getString("correousuario"));
                user.setCorreoContreasenna(rs.getString("correocontrasenna"));
                String user_id=user.getNif();
                Roles rl;
                try {
                    
                    rl=(Roles)rolesDAO.getRolesUser(user_id);
                    user.setRol(rl);
                } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                return user;
        }
        });
        return list;
    }

    @Override
    public users porACargo(String nif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validaExiste(users t) {
        String sql = "SELECT count(*) as c FROM users WHERE nif = ?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getNif()},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public int validaExisteUC(users t) {
        String sql = "SELECT count(*) as c FROM users WHERE usuario=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getUsuario()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    @Override
    public int validaExisteUCcorreo(users t) {
        String sql = "SELECT count(*) as c FROM users WHERE correousuario=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getCorreoUsuario()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public int validaExisteUCNif(users t) {
        String sql = "SELECT count(*) as c FROM users WHERE nif!=? and usuario=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getNif(),t.getUsuario()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public int validaExisteUCNifcorreo(users t) {
        String sql = "SELECT count(*) as c FROM users WHERE nif!=? and correousuario=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getNif(),t.getCorreoUsuario()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public int validaNIF(String nif) {
        String sql = "SELECT count(*) as c FROM users WHERE nif=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public users getByLogin(String u) {
        System.out.println("fundion byLofin");
        String sql = "SELECT  nif,usuario,contrasenna,estado,email,correousuario,correocontrasenna FROM users WHERE usuario=?";
        users list = this.getJdbcTemplate().queryForObject(sql,new Object[]{u}, new RowMapper<users>(){
        @Override
            public users mapRow(ResultSet rs, int i) throws SQLException {
                users user = new users();
                System.out.println("nuevo usuario");
                user.setNif(rs.getString("nif"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setEstado(rs.getInt("estado"));
                user.setEmail(rs.getString("email"));
                user.setCorreoUsuario(rs.getString("correousuario"));
                user.setCorreoContreasenna(rs.getString("correocontrasenna"));
                System.out.println("nif :"+user.getNif()+" usu "+user.getUsuario()+" pass:"+user.getContrasenna());
                String user_id=user.getNif();
                Roles rl;
                try {
                    
                    rl=(Roles)rolesDAO.getRolesUser(user_id);
                    user.setRol(rl);
                } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                return user;
        }
        });
        return list;
    }

    @Override
    public String insertar(users t) {
        String sql = "INSERT INTO users( nif, usuario, contrasenna,email,estado) VALUES (?, ?, ?, ?, 1)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getNif(),t.getUsuario(),t.getContrasenna(),t.getEmail()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String anadirRolaUser(String nif,int rol) {
        String sql = "INSERT INTO userol(user_nif, rol_id) VALUES ( ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif,rol});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String updateRolaUser(String nif,int rol) {
        String sql = "UPDATE userol SET rol_id=? WHERE user_nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{rol,nif});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String update(users t) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(t.getContrasenna().length()>0){
            String sql = "UPDATE users SET usuario=?, contrasenna=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getUsuario(),t.getContrasenna(),t.getNif()});

        }else{
            String sql = "UPDATE users SET usuario=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getUsuario(),t.getNif()});

        }
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    
    }
    
    @Override
    public String updateCorreo(users t) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(t.getCorreoContreasenna().length()>0){
            String sql = "UPDATE users SET correousuario=?, correocontrasenna=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getCorreoUsuario(),t.getCorreoContreasenna(),t.getNif()});

        }else{
            String sql = "UPDATE users SET correousuario=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getCorreoUsuario(),t.getNif()});

        }
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String updateEmail(users t) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
            String sql = "UPDATE users SET email=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getEmail(),t.getNif()});

        
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String updateEstado(users t) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
            String sql = "UPDATE users SET estado=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{t.getEmail(),t.getNif()});

        
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
   @Override
    public String updateRol(String nif,int idR) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        
            String sql = "UPDATE userol SET rol_id=? WHERE user_nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{idR,nif});

        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String darBaja(String nif, boolean e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean ISEstadoUsu(String nif) {
        String sql = "update empleados set sesion=true where nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        boolean result=false;
        if(c!=0)result=true;
        return result;
    }
    
    @Override
    public boolean CSEstadoUsu(String nif) {
        String sql = "update empleados set sesion=false where nif=?";
        int c= this.getJdbcTemplate().update(sql, new Object[]{nif});
        boolean result=false;
        if(c!=0)result=true;
        return result;
    }
}
