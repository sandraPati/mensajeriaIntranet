/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.cursos;
import com.intranet.dao.CursosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("cursosDAO")
public class ICursosDAO extends UtilTemplateDAO implements CursosDAO{

    @Override
    public List<cursos> findAll() {
        String sql = "SELECT id,nombre FROM curso";
        List<cursos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<cursos>(){
        @Override
            public cursos mapRow(ResultSet rs, int i) throws SQLException {
                cursos e = new cursos();
                 e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public cursos porId(int id) {
        String sql = "SELECT id,nombre FROM curso where id=?";
        cursos e =(cursos)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<cursos>(){
        @Override
            public cursos mapRow(ResultSet rs, int i) throws SQLException {
                cursos e = new cursos();
                 e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        
        return e;
    }
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            cursos e = new cursos();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
