/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.prov_presup_adj;
import com.intranet.dao.ProvPresupAdjDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("provPresupAdjDAO")
public class IProvPresupAdjDAO extends UtilTemplateDAO implements ProvPresupAdjDAO{
    @Override
    public List<prov_presup_adj> findAll(int idPP) {
        String sql = "SELECT id, id_prov_presup, nombre,tipo FROM prov_presup_adj WHERE id_prov_presup=?";
        List<prov_presup_adj> list = this.getJdbcTemplate().query(sql,new Object[]{idPP},new RowMapper<prov_presup_adj>(){
        @Override
            public prov_presup_adj mapRow(ResultSet rs, int i) throws SQLException {
                prov_presup_adj user = new prov_presup_adj();
                user.setId(rs.getInt("id"));
                user.setId_prov_presup(rs.getInt("id_prov_presup"));
                user.setNombre(rs.getString("nombre"));
                user.setTipo(rs.getString("tipo"));
                return user;
        }
        });
        
        return list;
    }
    @Override
    public prov_presup_adj porID(int id) {
        String sql = "SELECT id, id_prov_presup, nombre,tipo FROM prov_presup_adj WHERE id=?";
        prov_presup_adj list = this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<prov_presup_adj>(){
        @Override
            public prov_presup_adj mapRow(ResultSet rs, int i) throws SQLException {
                prov_presup_adj user = new prov_presup_adj();
                user.setId(rs.getInt("id"));
                user.setId_prov_presup(rs.getInt("id_prov_presup"));
                user.setNombre(rs.getString("nombre"));
                user.setTipo(rs.getString("tipo"));
                return user;
        }
        });
        
        return list;
    }
    @Override
    public boolean Insert(prov_presup_adj est) {
        String sql = "INSERT INTO prov_presup_adj(id_prov_presup,nombre,tipo) VALUES (?, ?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getId_prov_presup(),est.getNombre(),est.getTipo()});
        boolean r=false;
        if(c>0){
            r=true;
        }
        return r;
    }
    @Override
    public boolean Update(prov_presup_adj est) {
        String sql = "UPDATE prov_presup_adj SET nombre=?,tipo=? WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getNombre(),est.getTipo(),est.getId()});
        boolean r=false;
        if(c>0){
            r=true;
        }
        return r;
    }
    @Override
    public boolean Delete(Integer id) {
        String sql = "DELETE FROM prov_presup_adj WHERE id_prov_presup=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            boolean r=false;
            if(c>0){
                r=true;
            }
            return r;
    }
   @Override
    public boolean DeleteID(Integer id) {
        String sql = "DELETE FROM prov_presup_adj WHERE id=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            boolean r=false;
            if(c>0){
                r=true;
            }
            return r;
    } 
}
