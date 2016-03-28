/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.conocimientos;
import com.intranet.dao.ConocimientoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("conocimientoDAO")
public class IConocimientoDAO extends UtilTemplateDAO implements ConocimientoDAO{

    @Override
    public List<conocimientos> findAll(String nif) {
        String sql = "SELECT id, postulante_doc_identidad, descripcion, nivel FROM conocimientos WHERE postulante_doc_identidad=?";
        List<conocimientos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{nif}, new RowMapper<conocimientos>(){
        @Override
            public conocimientos mapRow(ResultSet rs, int i) throws SQLException {
                conocimientos e = new conocimientos();
                 e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setNivel(rs.getString("nivel"));
                return e;
        }
        });
        
        
        return e;
    }

    @Override
    public conocimientos porId(int id) {
        String sql = "SELECT id, postulante_doc_identidad, descripcion, nivel FROM conocimientos where id=?";
        conocimientos e =(conocimientos)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},  new RowMapper<conocimientos>(){
        @Override
            public conocimientos mapRow(ResultSet rs, int i) throws SQLException {
                conocimientos e = new conocimientos();
                 e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setNivel(rs.getString("nivel"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public String Insert(conocimientos cap) {
        String sql = "INSERT INTO conocimientos(postulante_doc_identidad, descripcion, nivel) VALUES (?, upper(?), ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPostulante_doc_identidad(),cap.getDescripcion(),cap.getNivel()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(conocimientos cap) {
        String sql = "UPDATE conocimientos SET descripcion=upper(?), nivel=? where id=? and postulante_doc_identidad=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getDescripcion(),cap.getNivel(),cap.getId(),cap.getPostulante_doc_identidad()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM conocimientos WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
     private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            conocimientos e = new conocimientos();
            e.setId(rs.getInt("id"));
            e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
            e.setDescripcion(rs.getString("descripcion"));
            e.setNivel(rs.getString("nivel"));
            return e;
        }
    }
}
