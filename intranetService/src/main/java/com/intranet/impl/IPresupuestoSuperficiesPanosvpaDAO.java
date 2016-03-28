/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.armarios;
import com.intranet.beans.presupuesto_superficies_panos_vpa;
import com.intranet.beans.puertas;
import com.intranet.beans.ventanas;
import com.intranet.dao.PresupuestoSuperficiesPanosvpaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoSuperficiesPanosvpaDAO")
public class IPresupuestoSuperficiesPanosvpaDAO extends UtilTemplateDAO implements PresupuestoSuperficiesPanosvpaDAO{
    @Override
    public List<presupuesto_superficies_panos_vpa> findAll(int idPSE) {
       String sql="SELECT id, idpresup_sup_pano, idpva,idpuerta,idarmario FROM presupuesto_superficies_panos_vpa where idpresup_sup_pano=? ";
       List<presupuesto_superficies_panos_vpa> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos_vpa>() {
           public presupuesto_superficies_panos_vpa mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos_vpa p=new presupuesto_superficies_panos_vpa();
               p.setId(rs.getInt(1));
               p.setIdpresup_sup_pano(rs.getInt(2));
               p.setIdvpa(rs.getInt(3));
               p.setIdpuerta(rs.getInt(4));
               p.setIdarmario(rs.getInt(5));
               return p;
           }
       });
       return lta;
    }
    @Override
    public List<presupuesto_superficies_panos_vpa> findAllMostrar(int idPSE) {
       String sql="SELECT p.id, p.idpresup_sup_pano, p.idpva,v.num,v.largo,v.alto,v.superficie FROM presupuesto_superficies_panos_vpa p inner join ventanas v on(p.idpva=v.id)where p.idpresup_sup_pano=? ";
       List<presupuesto_superficies_panos_vpa> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos_vpa>() {
           public presupuesto_superficies_panos_vpa mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos_vpa p=new presupuesto_superficies_panos_vpa();
               p.setId(rs.getInt(1));
               p.setIdpresup_sup_pano(rs.getInt(2));
               p.setIdvpa(rs.getInt(3));
               ventanas v=new ventanas();
               v.setId(rs.getInt(3));
               v.setNum(rs.getInt(4));
               v.setLargo(rs.getFloat(5));
               v.setAlto(rs.getFloat(6));
               v.setSuperficie(rs.getFloat(7));
               p.setV(v);
               return p;
           }
       });
       return lta;
    }
    @Override
    public List<presupuesto_superficies_panos_vpa> findAllMostrarP(int idPSE) {
       String sql="SELECT p.id, p.idpresup_sup_pano, p.idpva,v.num,v.largo,v.alto,v.superficie FROM presupuesto_superficies_panos_vpa p inner join puertas v on(p.idpuerta=v.id)where p.idpresup_sup_pano=? ";
       List<presupuesto_superficies_panos_vpa> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos_vpa>() {
           public presupuesto_superficies_panos_vpa mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos_vpa p=new presupuesto_superficies_panos_vpa();
               p.setId(rs.getInt(1));
               p.setIdpresup_sup_pano(rs.getInt(2));
               p.setIdvpa(rs.getInt(3));
               puertas v=new puertas();
               v.setId(rs.getInt(3));
               v.setNum(rs.getInt(4));
               v.setLargo(rs.getFloat(5));
               v.setAlto(rs.getFloat(6));
               v.setSuperficie(rs.getFloat(7));
               p.setP(v);
               return p;
           }
       });
       return lta;
    }
    @Override
    public List<presupuesto_superficies_panos_vpa> findAllMostrarA(int idPSE) {
       String sql="SELECT p.id, p.idpresup_sup_pano, p.idpva,v.num,v.largo,v.alto,v.superficie FROM presupuesto_superficies_panos_vpa p inner join armarios v on(p.idarmario=v.id)where p.idpresup_sup_pano=? ";
       List<presupuesto_superficies_panos_vpa> lta=this.getJdbcTemplate().query(sql, new Object[]{idPSE},new RowMapper<presupuesto_superficies_panos_vpa>() {
           public presupuesto_superficies_panos_vpa mapRow(ResultSet rs, int i) throws SQLException {
               presupuesto_superficies_panos_vpa p=new presupuesto_superficies_panos_vpa();
               p.setId(rs.getInt(1));
               p.setIdpresup_sup_pano(rs.getInt(2));
               p.setIdvpa(rs.getInt(3));
               armarios v=new armarios();
               v.setId(rs.getInt(3));
               v.setNum(rs.getInt(4));
               v.setLargo(rs.getFloat(5));
               v.setAlto(rs.getFloat(6));
               v.setSuperficie(rs.getFloat(7));
               p.setA(v);
               return p;
           }
       });
       return lta;
    }
    @Override
    public int Insert(presupuesto_superficies_panos_vpa presu) {
        String sql="INSERT INTO presupuesto_superficies_panos_vpa(idpresup_sup_pano, idpva,idpuerta,idarmario) VALUES (?, ?,0,0)";
        return this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresup_sup_pano(),presu.getIdvpa()});
    }
    @Override
    public int InsertP(presupuesto_superficies_panos_vpa presu) {
        String sql="INSERT INTO presupuesto_superficies_panos_vpa(idpresup_sup_pano, idpuerta,idpva,idarmario) VALUES (?, ?,0,0)";
        return this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresup_sup_pano(),presu.getIdpuerta()});
    }
    @Override
    public int InsertA(presupuesto_superficies_panos_vpa presu) {
        String sql="INSERT INTO presupuesto_superficies_panos_vpa(idpresup_sup_pano,idarmario, idpva,idpuerta) VALUES (?,?, 0,0)";
        return this.getJdbcTemplate().update(sql,new Object[]{presu.getIdpresup_sup_pano(),presu.getIdarmario()});
    }
    @Override
    public int buscar(int idP, int idPSE) {
        String sql="select id from presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idpva=?";
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
    public int buscarcount(int idP, int idPSE) {
        String sql="select count(id)as id from presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idpva=?";
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
    public int buscarcountP(int idP, int idPSE) {
        String sql="select count(id)as id from presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idpuerta=?";
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
    public int buscarcountA(int idP, int idPSE) {
        String sql="select count(id)as id from presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idarmario=?";
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
    public int DeleteID(int idP, int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idpva=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE,idP});
    }
    @Override
    public int DeleteIDPuerta(int idP, int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idpuerta=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE,idP});
    }
    @Override
    public int DeleteIDArmario(int idP, int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=? and idarmario=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE,idP});
    }
    @Override
    public int DeletePorIdPSE(int idPSE) {
        String sql="DELETE FROM presupuesto_superficies_panos_vpa WHERE idpresup_sup_pano=?";
       return this.getJdbcTemplate().update(sql,new Object[]{idPSE});
    }
    
}
