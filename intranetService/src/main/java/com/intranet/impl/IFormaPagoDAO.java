/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.formapago;
import com.intranet.dao.FormaPagoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("formaPagoDAO")
public class IFormaPagoDAO extends UtilTemplateDAO implements FormaPagoDAO{
    
    
    @Override
    public List<formapago> findAll() {
        String sql = "SELECT id, nombre  FROM formapago ";
        List<formapago> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<formapago>(){
        @Override
            public formapago mapRow(ResultSet rs, int i) throws SQLException {
                formapago e = new formapago();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public formapago porId(int id) {
        String sql = "SELECT id, nombre FROM formapago WHERE id=?";
        formapago est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<formapago>(){
        @Override
            public formapago mapRow(ResultSet rs, int i) throws SQLException {
                formapago e = new formapago();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return est;
    }
    
}
