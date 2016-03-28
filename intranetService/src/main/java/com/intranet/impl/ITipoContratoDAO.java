/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.tipo_contrato;
import com.intranet.dao.TipoContratoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tipoContratoDAO")
public class ITipoContratoDAO extends UtilTemplateDAO implements TipoContratoDAO{

    @Override
    public List<tipo_contrato> findAll() {
        String sql = "SELECT id,nombre FROM tipo_contrato";
        List<tipo_contrato> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new EMapper());
        
        return e;
    }

    @Override
    public tipo_contrato porId(int id) {
        String sql = "SELECT id,nombre FROM tipo_contrato where id=?";
        tipo_contrato e =(tipo_contrato)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<tipo_contrato>(){
        @Override
            public tipo_contrato mapRow(ResultSet rs, int i) throws SQLException {
                tipo_contrato e = new tipo_contrato();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));       
                return e;
        }
        });
        
        return e;
    }
    
     private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tipo_contrato e = new tipo_contrato();
            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            return e;
        }
    }
}
