/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipo_actividades;
import com.intranet.dao.TipoActividadDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoActividadDAO")
public class ITipoActividadDAO extends UtilTemplateDAO implements TipoActividadDAO{

    @Override
    public List<tipo_actividades> all() {
        String sql = "SELECT id, nombre FROM tipo_actividad";
        List<tipo_actividades> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new EMapper());
        
        return e;
    }

    @Override
    public tipo_actividades porId(int id) {
        String sql = "SELECT id, nombre FROM tipo_actividad where id=?";
        tipo_actividades e =(tipo_actividades)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new EMapper());
        
        return e;
    }

    @Override
    public boolean existe(String nombre) {
        String sql = "SELECT count(*)as c FROM tipo_actividad where nombre=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nombre},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public boolean existeU(tipo_actividades t) {
        String sql = "SELECT count(*)as c FROM tipo_actividad where id!=? and nombre=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{t.getId(),t.getNombre()},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public String Insert(tipo_actividades tipopa) {
        String sql = "INSERT INTO tipo_actividad(nombre) VALUES (?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{tipopa.getNombre()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(tipo_actividades tipopa) {
        String sql = "UPDATE tipo_actividad SET nombre=? WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{tipopa.getNombre(),tipopa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM tipo_actividad WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tipo_actividades e = new tipo_actividades();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
