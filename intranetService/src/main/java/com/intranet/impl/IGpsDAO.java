/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.gps;
import com.intranet.dao.GpsDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("gpsDAO")
public class IGpsDAO extends UtilTemplateDAO implements GpsDAO{
    @Override
    public gps findAll(String nif) {
        String sql = "SELECT id, nif_user, direccion, lat, longi, fecha, hora,turno FROM gps WHERE nif_user='"+nif+"' and fecha=to_char(current_date,'yyyy-mm-dd') and hora=(SELECT max(hora)as h FROM gps g WHERE g.nif_user='"+nif+"' and g.fecha=to_char(current_date,'yyyy-mm-dd') )";
        gps est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<gps>(){
        @Override
            public gps mapRow(ResultSet rs, int i) throws SQLException {
                gps e = new gps();
                e.setId(rs.getInt("id"));
                e.setNif_user(rs.getString("nif_user"));
                e.setDireccion(rs.getString("direccion"));
                e.setLat(rs.getString("lat"));
                e.setLongitud(rs.getString("longi"));
                e.setFecha(rs.getString("fecha"));
                e.setHora(rs.getString("hora"));
                e.setTurno(rs.getString("turno"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public List<gps> findAllHoy(String nif) {
        String sql = "SELECT id, nif_user, direccion, lat, longi, fecha, hora,turno FROM gps WHERE nif_user=? and fecha=to_char(current_date,'yyyy-mm-dd') ";
        List<gps> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<gps>(){
        @Override
            public gps mapRow(ResultSet rs, int i) throws SQLException {
                gps e = new gps();
                e.setId(rs.getInt("id"));
                e.setNif_user(rs.getString("nif_user"));
                e.setDireccion(rs.getString("direccion"));
                e.setLat(rs.getString("lat"));
                e.setLongitud(rs.getString("longi"));
                e.setFecha(rs.getString("fecha"));
                e.setHora(rs.getString("hora"));
                e.setTurno(rs.getString("turno"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public List<gps> findFecha(String nif,String fecha) {
        String sql = "SELECT id, nif_user, direccion, lat, longi, fecha, hora,turno FROM gps WHERE nif_user=? and fecha=?";
        List<gps> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif,fecha},new RowMapper<gps>(){
        @Override
            public gps mapRow(ResultSet rs, int i) throws SQLException {
                gps e = new gps();
                e.setId(rs.getInt("id"));
                e.setNif_user(rs.getString("nif_user"));
                e.setDireccion(rs.getString("direccion"));
                e.setLat(rs.getString("lat"));
                e.setLongitud(rs.getString("longi"));
                e.setFecha(rs.getString("fecha"));
                e.setHora(rs.getString("hora"));
                e.setTurno(rs.getString("turno"));
                return e;
        }
        });
        
        return est;
    }
    
     @Override
    public boolean validaExiste(String nif) {
        String sql = "SELECT count(*) as c FROM gps WHERE nif_user=? and fecha=to_char(current_date,'yyyy-mm-dd')";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }
}
