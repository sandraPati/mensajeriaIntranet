/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipogasto;
import com.intranet.dao.TipoGastoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoGastoDAO")
public class ITipoGastoDAO extends UtilTemplateDAO implements TipoGastoDAO{
    @Override
    public List<tipogasto> findAll() {
        String sql = "SELECT id, nombre  FROM tipogasto ";
        List<tipogasto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<tipogasto>(){
        @Override
            public tipogasto mapRow(ResultSet rs, int i) throws SQLException {
                tipogasto e = new tipogasto();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public tipogasto porId(int id) {
        String sql = "SELECT id, nombre  FROM tipogasto WHERE id=?";
        tipogasto est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<tipogasto>(){
        @Override
            public tipogasto mapRow(ResultSet rs, int i) throws SQLException {
                tipogasto e = new tipogasto();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    
}
