/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.presupuestom2panos;
import com.intranet.dao.PresupuestoM2PanosDAO;
import com.intranet.dao.PresupuestoSuperficiesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoM2PanosDAO")
public class IPresupuestoM2PanosDAO extends UtilTemplateDAO implements  PresupuestoM2PanosDAO{
    @Autowired(required=true)
    PresupuestoSuperficiesDAO presupuestoSuperficiesDAO;
    
    @Override
    public presupuestom2panos porId(int id) {
        String sql="SELECT id, idpresupuesto, idpropuesta FROM presupuestom2panos WHERE id=?";
        return this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<presupuestom2panos>(){
            public presupuestom2panos mapRow(ResultSet rs, int i) throws SQLException {
                presupuestom2panos p=new presupuestom2panos();
                p.setId(rs.getInt("id"));
                p.setIdpresupuesto(rs.getInt("idpresupuesto"));
                p.setIdpropuesta(rs.getInt("idpropuesta"));
                p.setLtaps(presupuestoSuperficiesDAO.findAll(p.getIdpresupuesto()));
                return p;
            }
        
        });
    }
    @Override
    public presupuestom2panos porIdProp(int idP) {
        String sql="SELECT id, idpresupuesto, idpropuesta FROM presupuestom2panos WHERE idpropuesta=?";
        presupuestom2panos p= this.getJdbcTemplate().queryForObject(sql,new Object[]{idP},new RowMapper<presupuestom2panos>(){
            @Override
            public presupuestom2panos mapRow(ResultSet rs, int i) throws SQLException {
                presupuestom2panos p=new presupuestom2panos();
                p.setId(rs.getInt("id"));
                p.setIdpresupuesto(rs.getInt("idpresupuesto"));
                p.setIdpropuesta(rs.getInt("idpropuesta"));
                
                return p;
            }
        
        });
        return p;
    }
    @Override
    public presupuestom2panos porIdPresup(int idP) {
        String sql="SELECT id, idpresupuesto, idpropuesta FROM presupuestom2panos WHERE idpresupuesto=?";
        presupuestom2panos p= this.getJdbcTemplate().queryForObject(sql,new Object[]{idP},new RowMapper<presupuestom2panos>(){
            @Override
            public presupuestom2panos mapRow(ResultSet rs, int i) throws SQLException {
                presupuestom2panos p=new presupuestom2panos();
                p.setId(rs.getInt("id"));
                p.setIdpresupuesto(rs.getInt("idpresupuesto"));
                p.setIdpropuesta(rs.getInt("idpropuesta"));
                
                return p;
            }
        
        });
        return p;
    }
    @Override
    public int buscar(int idP) {
        String sql="SELECT count(id)as c FROM presupuestom2panos WHERE idpropuesta=?";
        int p= this.getJdbcTemplate().queryForObject(sql,new Object[]{idP},new RowMapper<Integer>(){
            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer p=rs.getInt("c");
                
                return p;
            }
        
        });
        return p;
    }
    @Override
    public int Insert(presupuestom2panos presu) {
       String sql="INSERT INTO presupuestom2panos(idpresupuesto, idpropuesta) VALUES (?, ?) ";
       int c=this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresupuesto(),presu.getIdpropuesta()});
       return c;
    }
    @Override
    public int Update(presupuestom2panos presu) {
        String sql="UPDATE presupuestom2panos SET idpresupuesto=?, idpropuesta=? WHERE id=?";
       int c=this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresupuesto(),presu.getIdpropuesta(),presu.getId()});
       return c;
    }
    @Override
    public int Delete(int id) {
        String sql="DELETE FROM presupuestom2panos WHERE id=?";
       int c=this.getJdbcTemplate().update(sql,new Object[]{id});
       return c;
    }
    @Override
    public int DeleteidPresu(int id) {
        String sql="DELETE FROM presupuestom2panos WHERE idpresupuesto=?";
       int c=this.getJdbcTemplate().update(sql,new Object[]{id});
       return c;
    }
    @Override
    public int DeletePresup(int id) {
        String sql="DELETE FROM presupuestom2panos WHERE idpresupuesto in(select id from presupuesto where presup_id=?)";
       int c=this.getJdbcTemplate().update(sql,new Object[]{id});
       return c;
    }
}
