/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipo_pano;
import com.intranet.dao.TipoPanoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoPanoDAO")
public class ITipoPanoDAO extends UtilTemplateDAO implements TipoPanoDAO{

    @Override
    public List<tipo_pano> findAll(String buscar) {
        String sql = "SELECT id,nombre FROM tipo_pano";
        List<tipo_pano> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<tipo_pano>(){
        @Override
            public tipo_pano mapRow(ResultSet rs, int i) throws SQLException {
                tipo_pano e = new tipo_pano();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public tipo_pano porId(int id) {
        String sql = "SELECT id,nombre FROM tipo_pano WHERE id=?";
        tipo_pano e =(tipo_pano)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},  new RowMapper<tipo_pano>(){
        @Override
            public tipo_pano mapRow(ResultSet rs, int i) throws SQLException {
                tipo_pano e = new tipo_pano();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public boolean Insert(tipo_pano tipopa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(tipo_pano tipopa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tipo_pano e = new tipo_pano();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
