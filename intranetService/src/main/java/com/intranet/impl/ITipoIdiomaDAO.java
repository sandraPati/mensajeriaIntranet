/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipoidioma;
import com.intranet.dao.TipoIdiomaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoIdiomaDAO")
public class ITipoIdiomaDAO  extends UtilTemplateDAO implements TipoIdiomaDAO{

    @Override
    public List<tipoidioma> findAll() {
        String sql = "SELECT id,nombre FROM tipoidioma";
        List<tipoidioma> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<tipoidioma>(){
        @Override
            public tipoidioma mapRow(ResultSet rs, int i) throws SQLException {
                tipoidioma e = new tipoidioma();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public tipoidioma porId(int id) {
        String sql = "SELECT id,nombre FROM tipoidioma where id=?";
        tipoidioma e =(tipoidioma)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<tipoidioma>(){
        @Override
            public tipoidioma mapRow(ResultSet rs, int i) throws SQLException {
                tipoidioma e = new tipoidioma();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return e;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tipoidioma e = new tipoidioma();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
