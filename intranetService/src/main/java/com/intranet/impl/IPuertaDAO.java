/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.panos;
import com.intranet.beans.puertas;
import com.intranet.dao.PanoDAO;
import com.intranet.dao.PuertaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("puertaDAO")
public class IPuertaDAO extends UtilTemplateDAO implements PuertaDAO{
    @Autowired(required = true)
    PanoDAO panoDAO;
    
    public List<puertas> findAll(int idPano) {
        String sql = "SELECT id, idpano, num, largo, alto, superficie,estandar " +
                "  FROM puertas WHERE idpano=? ";
        List<puertas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano},new RowMapper<puertas>(){
        @Override
            public puertas mapRow(ResultSet rs, int i) throws SQLException {
                puertas e = new puertas();
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
                e.setSuperficie(rs.getFloat("superficie"));
                e.setEstandar(rs.getInt("estandar"));
                return e;
        }
        });
        
        return est;
    }

    public puertas porID(int id) {
        String sql = "SELECT id, idpano, num, largo, alto, superficie,estandar " +
                "  FROM puertas WHERE id=? ";
        puertas est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<puertas>(){
        @Override
            public puertas mapRow(ResultSet rs, int i) throws SQLException {
                puertas e = new puertas();
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
                e.setSuperficie(rs.getFloat("superficie"));
                e.setEstandar(rs.getInt("estandar"));
                return e;
        }
        });
        
        return est;
    }

    public String Insert(puertas v) {
        String sql = "INSERT INTO puertas("+
                "idpano, num, largo, alto, superficie,estandar) "+
                "VALUES (?, ?, ?, ?, ?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getIdpano().getId(),v.getNum(),v.getLargo(),v.getAlto(),v.getSuperficie(),v.getEstandar()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
public String InsertPaso(puertas v) {
        String sql = "INSERT INTO puertas("+
                "idpano, num, largo, alto, superficie,estandar) "+
                "VALUES (?, ?, ?, ?, ?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getId_pano(),v.getNum(),v.getLargo(),v.getAlto(),v.getSuperficie(),v.getEstandar()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    public String Update(puertas v) {
        String sql = "UPDATE puertas SET "+
                " largo=?, alto=?, superficie=? ,estandar=? "+
                "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getLargo(),v.getAlto(),v.getSuperficie(),v.getEstandar(),v.getId()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    public String Delete(Integer id) {
        String sql = "DELETE FROM puertas WHERE id=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
    }

    public String DeletePano(Integer id) {
        String sql = "DELETE FROM puertas WHERE idpano=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
    }
    
}
