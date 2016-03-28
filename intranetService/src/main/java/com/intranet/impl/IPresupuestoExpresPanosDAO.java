/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.presupuesto_expres_panos;
import com.intranet.dao.PresupuestoExpresPanosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoExpresPanosDAO")
public class IPresupuestoExpresPanosDAO extends UtilTemplateDAO implements PresupuestoExpresPanosDAO{

    public List<presupuesto_expres_panos> lta(int idPex) {
        String sql = "SELECT id, idpano, idpresupexpres, medialtura FROM presupuesto_expres_panos "+
	   "WHERE idpresupexpres=? ";
        List<presupuesto_expres_panos> lta=this.getJdbcTemplate().query(sql, 
                new Object[]{idPex},new RowMapper<presupuesto_expres_panos>(){
        @Override
            public presupuesto_expres_panos mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_expres_panos t = new presupuesto_expres_panos();
                t.setId(rs.getInt(1));
                t.setIdpano(rs.getInt(2));
                t.setIdpresupexpres(rs.getInt(3));
                t.setMedialtura(rs.getInt(4));
                return t;
        }
        });
        return lta;
    }

    public boolean insert(presupuesto_expres_panos obj) {
       String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuesto_expres_panos(idpano, idpresupexpres, medialtura) "+
            "VALUES (?, ?, ?)";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getIdpano(),obj.getIdpresupexpres(),obj.getMedialtura()});
       if(r>0) return true;
       else return false;
    }

    public boolean update(presupuesto_expres_panos obj) {
         String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto_expres_panos SET  medialtura=? "+
            "WHERE idpresupexpres=? and idpano=?";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getMedialtura(),obj.getIdpresupexpres(),obj.getIdpano()});
       if(r>0) return true;
       else return false;
    }

    public int existe(int idP, int idPex) {
        String sql = "SELECT count(id)as c FROM presupuesto_expres_panos "+
	   "WHERE idpresupexpres=? and idpano=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPex,idP},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    public boolean delete(int idP, int idPex) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuesto_expres_panos "+
            "WHERE idpresupexpres=? and idpano=?";
        int r= this.getJdbcTemplate().update(sql, new Object[]{idPex,idP});
       if(r>0) return true;
       else return false;
    }
    
}
