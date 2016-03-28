/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.formapagogasto;
import com.intranet.dao.FormaPagoGastoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("formaPagoGastoDAO")
public class IFormaPagoGastoDAO extends UtilTemplateDAO implements FormaPagoGastoDAO{
    @Override
    public List<formapagogasto> findAll() {
        String sql = "SELECT id, nombre  FROM formapagogasto ";
        List<formapagogasto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<formapagogasto>(){
        @Override
            public formapagogasto mapRow(ResultSet rs, int i) throws SQLException {
                formapagogasto e = new formapagogasto();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public formapagogasto porId(int id) {
        String sql = "SELECT id, nombre  FROM formapagogasto WHERE id=?";
        formapagogasto est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<formapagogasto>(){
        @Override
            public formapagogasto mapRow(ResultSet rs, int i) throws SQLException {
                formapagogasto e = new formapagogasto();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    
}
