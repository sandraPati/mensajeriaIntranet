/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.Roles;
import com.intranet.dao.RolesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("rolesDAO")
public class IRolesDAO extends UtilTemplateDAO implements RolesDAO{
    
    @Override
    public List<Roles> getList() {
        String sql = "SELECT  id,nombre FROM roles";
        List<Roles> list = this.getJdbcTemplate().query(sql,new RowMapper<Roles>(){
        @Override
            public Roles mapRow(ResultSet rs, int i) throws SQLException {
                Roles user = new Roles();
                user.setId(rs.getInt("id"));
                user.setRolName(rs.getString("nombre"));
                return user;
        }
        });
        
        return list;
    }
    
    @Override
    public Roles getRolesporId(int id) {
        String sql = "SELECT  id,nombre FROM roles r where r.id=?";
        Roles list = this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Roles>(){
        @Override
            public Roles mapRow(ResultSet rs, int i) throws SQLException {
                Roles user = new Roles();
                user.setId(rs.getInt("id"));
                user.setRolName(rs.getString("nombre"));
                return user;
        }
        });
        
        return list;
    }
    
    @Override
    public Roles getRolesUser(String user_id) {
        String sql = "SELECT  id,nombre FROM roles r where r.id in (select ur.rol_id from userol ur where ur.user_nif=?)";
        Roles list = this.getJdbcTemplate().queryForObject(sql, new Object[]{user_id}, new RowMapper<Roles>(){
        @Override
            public Roles mapRow(ResultSet rs, int i) throws SQLException {
                Roles user = new Roles();
                user.setId(rs.getInt("id"));
                user.setRolName(rs.getString("nombre"));
                return user;
        }
        });
        
        return list;
    }

    @Override
    public Roles getUserById(int id) {
        String sql = "SELECT  id,  nombre FROM roles WHERE id = ?";
        Roles user = (Roles) this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id}, new RowMapper<Roles>(){
        @Override
            public Roles mapRow(ResultSet rs, int i) throws SQLException {
                Roles user = new Roles();
                user.setId(rs.getInt("id"));
                user.setRolName(rs.getString("nombre"));
                return user;
        }
        });
        
        return user;
        
    }

        
    private static final class TUserMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Roles user = new Roles();
            user.setId(rs.getInt("id"));
            user.setRolName(rs.getString("nombre"));
            return user;
        }
    }
}