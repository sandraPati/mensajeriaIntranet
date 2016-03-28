/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.empleados;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.perfiles;
import com.intranet.dao.PerfilDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

@Repository("perfilDAO")
public class IPerfilDAO extends UtilTemplateDAO implements PerfilDAO{
    
    @Override
    public List<perfiles> findAll() {
        String sql = "SELECT id,nombre FROM perfiles";
        List<perfiles> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new EMapper());
        
        return e;
    }

    @Override
    public perfiles ById(int id) {
        String sql = "SELECT id,nombre FROM perfiles where id=?";
        perfiles e =(perfiles)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<perfiles>(){
        @Override
            public perfiles mapRow(ResultSet rs, int i) throws SQLException {
                perfiles eee = new perfiles();
                eee.setIdp(rs.getInt("id"));
                eee.setNombrep(rs.getString("nombre"));
                return eee;
        }
        });
        
        return e;
    }
    
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            perfiles e = new perfiles();
            e.setIdp(rs.getInt("id"));
            e.setNombrep(rs.getString("nombre"));
            return e;
        }
    }
}
