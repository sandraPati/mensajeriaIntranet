/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipoingreso;
import com.intranet.dao.TipoIngresoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoIngresoDAO")
public class ITipoIngresoDAO extends UtilTemplateDAO implements TipoIngresoDAO{
    
    @Override
    public List<tipoingreso> findAll() {
        String sql = "SELECT id, nombre  FROM tipoingreso ";
        List<tipoingreso> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<tipoingreso>(){
        @Override
            public tipoingreso mapRow(ResultSet rs, int i) throws SQLException {
                tipoingreso e = new tipoingreso();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public tipoingreso porId(int id) {
        String sql = "SELECT id, nombre  FROM tipoingreso WHERE id=?";
        tipoingreso est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<tipoingreso>(){
        @Override
            public tipoingreso mapRow(ResultSet rs, int i) throws SQLException {
                tipoingreso e = new tipoingreso();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    
}
