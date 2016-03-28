/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.gastosR;
import com.intranet.dao.GastosRDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("gastosRDAO")
public class IGastosRDAO extends UtilTemplateDAO implements GastosRDAO{
    @Override
    public gastosR porId(int id) {
        String sql = "SELECT id, idgasto, nombreimg "+
	"FROM gastor where id=? ";
        gastosR est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<gastosR>(){
        @Override
            public gastosR mapRow(ResultSet rs, int i) throws SQLException {
                gastosR e = new gastosR();
                e.setId(rs.getInt("id"));
                e.setIdgasto(rs.getInt("idgasto"));
               
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                return e;
        }
        });
        
        return est;
    }
    @Override
    public gastosR porIdGasto(int id) {
        String sql = "SELECT id, idgasto, nombreimg "+
	"FROM gastor where idgasto=? ";
        gastosR est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<gastosR>(){
        @Override
            public gastosR mapRow(ResultSet rs, int i) throws SQLException {
                gastosR e = new gastosR();
                e.setId(rs.getInt("id"));
                e.setIdgasto(rs.getInt("idgasto"));
               
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                return e;
        }
        });
        
        return est;
    }
    @Override
    public boolean existe(String nombreimg) {
        String sql = "SELECT count(*)as c "+
	"FROM gastor where nombreimg=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nombreimg},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }
    @Override
    public String insertar(gastosR p) {
       String sql = "INSERT INTO gastor("+
	"idgasto, nombreimg)"+
	"VALUES (?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getIdgasto(),p.getNombreimg()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String update(gastosR p) {
        String sql = "UPDATE gastor "+
	"SET nombreimg=? "+
	"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreimg(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String updateGasto(gastosR p) {
        String sql = "UPDATE gastor "+
	"SET nombreimg=? "+
	"WHERE idgasto=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreimg(),p.getIdgasto()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String eliminar(int id) {
       String sql = "DELETE FROM gastor  WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String eliminarGasto(int id) {
       String sql = "DELETE FROM gastor  WHERE idgasto=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
}
