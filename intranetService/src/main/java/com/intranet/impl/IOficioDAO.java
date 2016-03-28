/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.oficios;
import com.intranet.dao.OficioDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("oficioDAO")
public class IOficioDAO extends UtilTemplateDAO implements OficioDAO{

    @Override
    public List<oficios> findAll() {
        String sql = "SELECT id,nombre FROM oficios";
        List<oficios> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new IOficioDAO.EMapper());
        
        return e;
    }

    @Override
    public oficios porId(int id) {
        String sql = "SELECT id,nombre FROM oficios where id=?";
        oficios e =(oficios)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<oficios>(){
        @Override
            public oficios mapRow(ResultSet rs, int i) throws SQLException {
                oficios eee = new oficios();
                eee.setId(rs.getInt("id"));
                eee.setNombre(rs.getString("nombre"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public String Insert(oficios cap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Update(oficios cap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            oficios e = new oficios();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
