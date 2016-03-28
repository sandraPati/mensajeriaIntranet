/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipo_estancia;
import com.intranet.dao.TipoEstanciaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoEstanciaDAO")
public class ITipoEstanciaDAO extends UtilTemplateDAO implements TipoEstanciaDAO{

    @Override
    public List<tipo_estancia> findAll(String buscar) {
        String sql = "SELECT id,nombre FROM tipo_estancia";
        List<tipo_estancia> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<tipo_estancia>(){
        @Override
            public tipo_estancia mapRow(ResultSet rs, int i) throws SQLException {
                tipo_estancia e = new tipo_estancia();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        return e;
    }

    @Override
    public tipo_estancia porId(int id) {
        String sql = "SELECT id,nombre FROM tipo_estancia where id=?";
        tipo_estancia e =(tipo_estancia)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<tipo_estancia>(){
        @Override
            public tipo_estancia mapRow(ResultSet rs, int i) throws SQLException {
                tipo_estancia e = new tipo_estancia();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public String Insert(tipo_estancia tipopa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Update(tipo_estancia tipopa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tipo_estancia e = new tipo_estancia();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
