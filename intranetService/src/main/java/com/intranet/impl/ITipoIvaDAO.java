/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipoiva;
import com.intranet.dao.TipoIvaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoIvaDAO")
public class ITipoIvaDAO extends UtilTemplateDAO implements TipoIvaDAO{
    
    @Override
    public List<tipoiva> findAll() {
        String sql = "SELECT id, descripcion  FROM tipoiva ";
        List<tipoiva> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<tipoiva>(){
        @Override
            public tipoiva mapRow(ResultSet rs, int i) throws SQLException {
                tipoiva e = new tipoiva();
                e.setId(rs.getInt("id"));
                e.setDescripcion(rs.getString("descripcion"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public tipoiva porId(int id) {
        String sql = "SELECT id, descripcion  FROM tipoiva WHERE id=?";
        tipoiva est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<tipoiva>(){
        @Override
            public tipoiva mapRow(ResultSet rs, int i) throws SQLException {
                tipoiva e = new tipoiva();
                e.setId(rs.getInt("id"));
                e.setDescripcion(rs.getString("descripcion"));
                return e;
        }
        });
        
        return est;
    }
    
}
