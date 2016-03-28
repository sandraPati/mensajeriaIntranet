/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.perfil_profesional;
import com.intranet.dao.PerfilProfesionalDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("perfilProfesionalDAO")
public class IPerfilProfesionalDAO extends UtilTemplateDAO implements PerfilProfesionalDAO{

    @Override
    public List<perfil_profesional> findAll() {
        String sql = "SELECT id,nombre FROM perfilprofesional";
        List<perfil_profesional> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new IPerfilProfesionalDAO.EMapper());
        
        return e;
    }
    
    

    @Override
    public perfil_profesional porId(int id) {
        
        String sql = "SELECT id,nombre FROM perfilprofesional where id=?";
        perfil_profesional e =(perfil_profesional)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<perfil_profesional>(){
        @Override
            public perfil_profesional mapRow(ResultSet rs, int i) throws SQLException {
                perfil_profesional eee = new perfil_profesional();
                eee.setId(rs.getInt("id"));
                eee.setNombre(rs.getString("nombre"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public boolean Insert(perfil_profesional cap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(perfil_profesional cap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            perfil_profesional e = new perfil_profesional();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
