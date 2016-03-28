/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.panos;
import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.dao.PresupuestoSuperficiesPanosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoSuperficiesPanosDAO")
public class IPresupuestoSuperficiesPanosDAO extends UtilTemplateDAO implements PresupuestoSuperficiesPanosDAO{

    @Override
    public List<presupuesto_superficies_panos> findAll(int idPSE) {
       String sql="SELECT id, idpresup_sup, idpano,largopresupuesto FROM presupuesto_superficies_panos WHERE idpresup_sup=?";
       List<presupuesto_superficies_panos> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos>(){
           @Override
           public presupuesto_superficies_panos mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos p=new presupuesto_superficies_panos();
               p.setId(rs.getInt("id"));
               p.setIdpano(rs.getInt("idpano"));
               p.setIdpresup_sup(rs.getInt("idpresup_sup"));
               p.setLargo(rs.getFloat("largopresupuesto"));
               return p;
           }
    
        });
    return lta;
    }
    @Override
    public List<presupuesto_superficies_panos> findAllMostrar(int idPSE) {
       String sql="SELECT psp.id, psp.idpresup_sup, psp.idpano,p.nombrepano,p.superficie,psp.largopresupuesto FROM presupuesto_superficies_panos psp inner join panos p on(psp.idpano=p.id) WHERE idpresup_sup=?";
       List<presupuesto_superficies_panos> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos>(){
           @Override
           public presupuesto_superficies_panos mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos p=new presupuesto_superficies_panos();
               p.setId(rs.getInt("id"));
               p.setIdpano(rs.getInt("idpano"));
               p.setIdpresup_sup(rs.getInt("idpresup_sup"));
               panos pano=new panos();
               pano.setId(rs.getInt("idpano"));
               pano.setNombrepano(rs.getString("nombrepano"));
               pano.setSuperficie(rs.getFloat("superficie"));
               
               p.setPano(pano);
               p.setLargo(rs.getFloat("largopresupuesto"));
               return p;
           }
    
        });
    return lta;
    }
    @Override
    public int Insert(presupuesto_superficies_panos presu) {
       String sql="INSERT INTO presupuesto_superficies_panos(idpresup_sup, idpano,largopresupuesto) VALUES (?, ?,?)";
       return this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresup_sup(),presu.getIdpano(),presu.getLargo()});
    }
    
    @Override
    public String UpdateLargoPresup (presupuesto_superficies_panos presu){
    String sql = "UPDATE presupuesto_superficies_panos "+
            "SET largopresupuesto=? "+
            "WHERE idpresup_sup=? and idpano=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getLargo(),presu.getIdpresup_sup(),presu.getIdpano()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public int buscar(int idP, int idPSE) {
        String sql="select id from presupuesto_superficies_panos WHERE idpresup_sup=? and idpano=?";
        int r= this.getJdbcTemplate().queryForObject(sql,new Object[]{idPSE,idP},new RowMapper<Integer>(){
           @Override
           public Integer mapRow(ResultSet rs, int i) throws SQLException {
               int r=rs.getInt("id");
               return r;
           }
        });
        return r;
    }
    
    @Override
     public  presupuesto_superficies_panos buscarID (int id) {
        String sql="select id,idpresup_sup, idpano,largopresupuesto from presupuesto_superficies_panos WHERE id=?";
        presupuesto_superficies_panos r= this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<presupuesto_superficies_panos>(){
           @Override
           public presupuesto_superficies_panos mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos r=new presupuesto_superficies_panos();
               r.setId(rs.getInt(1));
               r.setIdpano(rs.getInt(3));
               r.setIdpresup_sup(rs.getInt(2));
               r.setLargo(rs.getFloat(4));
               
               return r;
           }
        });
        return r;
    }
    @Override
    public int buscarcount(int idP, int idPSE) {
        String sql="select count(id)as id from presupuesto_superficies_panos WHERE idpresup_sup=? and idpano=?";
        int r= this.getJdbcTemplate().queryForObject(sql,new Object[]{idPSE,idP},new RowMapper<Integer>(){
           @Override
           public Integer mapRow(ResultSet rs, int i) throws SQLException {
               int r=rs.getInt("id");
               return r;
           }
        });
        return r;
    }
    @Override
    public int ultimo(int idP, int idPSE) {
        String sql="select max(id)as id from presupuesto_superficies_panos WHERE idpresup_sup=? and idpano=?";
        int r= this.getJdbcTemplate().queryForObject(sql,new Object[]{idPSE,idP},new RowMapper<Integer>(){
           @Override
           public Integer mapRow(ResultSet rs, int i) throws SQLException {
               int r=rs.getInt("id");
               return r;
           }
        });
        return r;
    }
    @Override
    public int buscaridPresupSup(int id) {
        String sql="select idpresup_sup from presupuesto_superficies_panos WHERE id=?";
        int r= this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<Integer>(){
           @Override
           public Integer mapRow(ResultSet rs, int i) throws SQLException {
               int r=rs.getInt("idpresup_sup");
               return r;
           }
        });
        return r;
    }
    @Override
    public int DeleteID(int idP, int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos WHERE idpresup_sup=? and idpano=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE,idP});
    }
    @Override
    public int DeletePorIdPSE(int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos WHERE idpresup_sup=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE});
    }
    
}
