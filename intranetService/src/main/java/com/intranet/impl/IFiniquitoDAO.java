/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.finiquito;
import com.intranet.dao.FiniquitoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("finiquitoDAO")
public class IFiniquitoDAO extends UtilTemplateDAO implements FiniquitoDAO{
     @Override
    public List<finiquito> findAll(String postulante_doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public finiquito porId(int id) {
        String sql = "SELECT id, nif_empleado, id_contrato, fecha, monto  FROM finiquito WHERE id=?";
        finiquito e =(finiquito)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<finiquito>(){
        @Override
            public finiquito mapRow(ResultSet rs, int i) throws SQLException {
                finiquito e=new finiquito();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setId_contrato(rs.getInt("id_contrato"));
                e.setFecha(rs.getDate("fecha"));
                e.setMonto(rs.getFloat("monto"));
                return e;
        }
        });
        
        return e;
    }
     @Override
    public boolean Insert(finiquito cap) {
        String sql = "INSERT INTO finiquito(nif_empleado, id_contrato, fecha, monto) VALUES (?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getNif_empleado(),cap.getId_contrato(),cap.getFecha(),cap.getMonto()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
     @Override
    public finiquito ultimo(String nif_empleado) {
        String sql = "SELECT id, nif_empleado, id_contrato, fecha, monto  FROM finiquito WHERE nif_empleado=? and id=(SELECT max(f.id)  FROM finiquito f WHERE f.nif_empleado=?)";
        finiquito e =(finiquito)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif_empleado},new RowMapper<finiquito>(){
        @Override
            public finiquito mapRow(ResultSet rs, int i) throws SQLException {
                finiquito e=new finiquito();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setId_contrato(rs.getInt("id_contrato"));
                e.setFecha(rs.getDate("fecha"));
                e.setMonto(rs.getFloat("monto"));
                return e;
        }
        });
        
        return e;
    }
    
}
