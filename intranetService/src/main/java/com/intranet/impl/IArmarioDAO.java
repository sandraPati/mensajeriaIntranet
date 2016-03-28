/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.armarios;
import com.intranet.beans.panos;
import com.intranet.dao.ArmarioDAO;
import com.intranet.dao.PanoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("armarioDAO")
public class IArmarioDAO extends UtilTemplateDAO implements ArmarioDAO{
    
    @Autowired(required = true)
    PanoDAO panoDAO;
    
    public List<armarios> findAll(int idPano) {
        String sql = "SELECT id, idpano, num, largo, alto,fondo, superficie" +
                "  FROM armarios WHERE idpano=? ";
        List<armarios> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano},new RowMapper<armarios>(){
        @Override
            public armarios mapRow(ResultSet rs, int i) throws SQLException {
                armarios e = new armarios();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setFondo(rs.getFloat("fondo"));
                e.setSuperficie(rs.getFloat("superficie"));
                return e;
        }
        });
        
        return est;
    }

    public armarios porID(int id) {
        String sql = "SELECT id, idpano, num, largo, alto,fondo, superficie" +
                "  FROM armarios WHERE id=? ";
        armarios est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<armarios>(){
        @Override
            public armarios mapRow(ResultSet rs, int i) throws SQLException {
                armarios e = new armarios();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setFondo(rs.getFloat("fondo"));
                e.setSuperficie(rs.getFloat("superficie"));
                return e;
        }
        });
        
        return est;
    }

    public String Insert(armarios v) {
        String sql = "INSERT INTO armarios("+
                "idpano, num, largo, alto, superficie,fondo) "+
                "VALUES (?, ?, ?, ?, ?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getIdpano().getId(),v.getNum(),v.getLargo(),v.getAlto(),v.getSuperficie(),v.getFondo()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    public String Update(armarios v) {
        String sql = "UPDATE armarios SET "+
                " largo=?, alto=?, superficie=?,fondo=? "+
                "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getLargo(),v.getAlto(),v.getSuperficie(),v.getFondo(),v.getId()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    public String Delete(Integer id) {
        String sql = "DELETE FROM armarios WHERE id=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
         
    }

    public String DeletePano(Integer id) {
        String sql = "DELETE FROM armarios WHERE idpano=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
    }
    
}
