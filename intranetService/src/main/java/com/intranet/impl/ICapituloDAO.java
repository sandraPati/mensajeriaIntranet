/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.dao.CapituloDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("capituloDAO")
public class ICapituloDAO extends UtilTemplateDAO implements CapituloDAO{

    @Override
    public List<capitulos> findAll(String buscar) {
        String sql = "SELECT id,nombre,cod FROM capitulos ";
        List<capitulos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<capitulos>(){
        @Override
            public capitulos mapRow(ResultSet rs, int i) throws SQLException {
                capitulos e = new capitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCod(rs.getString("cod"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public capitulos porId(int id) {
        
        String sql = "SELECT id,nombre,cod FROM capitulos where id=?";
        capitulos e =(capitulos)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},  new RowMapper<capitulos>(){
        @Override
            public capitulos mapRow(ResultSet rs, int i) throws SQLException {
                capitulos e = new capitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCod(rs.getString("cod"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public boolean existe(String cod) {
        String sql = "SELECT count(*)as c FROM capitulos WHERE cod=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{cod},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public boolean existeU(capitulos c) {
        String sql = "SELECT count(*)as c FROM capitulos WHERE id!="+c.getId()+" and cod='"+c.getCod()+"'";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public String Insert(capitulos cap) {
        String sql = "INSERT INTO capitulos(nombre,cod) VALUES (?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getNombre(),cap.getCod()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(capitulos cap) {
        String sql = "UPDATE capitulos SET nombre=?,cod=? WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getNombre(),cap.getCod(),cap.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM capitulos WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            capitulos e = new capitulos();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            e.setCod(rs.getString("cod"));
            return e;
        }
    }
}
