/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.beans.estancias;
import com.intranet.beans.plantillaPresupuesto;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuesto_superficie;
import com.intranet.beans.presupuestosGrupo;
import com.intranet.beans.propuesta;
import com.intranet.beans.tipo_estancia;
import com.intranet.dao.PanoDAO;
import com.intranet.dao.PlantillaPresupuestoDAO;
import com.intranet.dao.PresupuestoCDAO;
import com.intranet.dao.PresupuestoSuperficiesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("plantillaPresupuestoDAO")
public class IPlantillaPresupuestoDAO extends UtilTemplateDAO implements PlantillaPresupuestoDAO{
    @Autowired(required = true)
    PresupuestoCDAO presupuestoCDAO;
    @Autowired(required = true)
    PresupuestoSuperficiesDAO presupuestoSuperficiesDAO;
    @Autowired(required = true)
    PanoDAO panoDAO;
    

    @Override
    public plantillaPresupuesto porID(int id) {
        String sql = "SELECT id,propuesta_id,descripcion "+
	      "FROM plantillapresupuesto  WHERE id=? ";
        plantillaPresupuesto est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<plantillaPresupuesto>(){
        @Override
            public plantillaPresupuesto mapRow(ResultSet rs, int i) throws SQLException {
                plantillaPresupuesto pre = new plantillaPresupuesto();
                pre.setId(rs.getInt(1));
                pre.setPropuesta_id(rs.getInt(2));
                pre.setDescripcion(rs.getString(3));
                
                return pre;
        }
        });
        
        return est;
    }
    @Override
    public plantillaPresupuesto porIDP(int id) {
        String sql = "SELECT id,propuesta_id,descripcion "+
	      "FROM plantillapresupuesto  WHERE propuesta_id=? ";
        plantillaPresupuesto est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<plantillaPresupuesto>(){
        @Override
            public plantillaPresupuesto mapRow(ResultSet rs, int i) throws SQLException {
                plantillaPresupuesto pre = new plantillaPresupuesto();
                pre.setId(rs.getInt(1));
                pre.setPropuesta_id(rs.getInt(2));
                pre.setDescripcion(rs.getString(3));
                
                return pre;
        }
        });
        
        return est;
    }
    @Override
    public boolean Insert(plantillaPresupuesto pp) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO plantillapresupuesto("+
            "propuesta_id, descripcion)"+
            "VALUES (?, ?)";
        c=this.getJdbcTemplate().update(sql, new Object[]{pp.getPropuesta_id(),pp.getDescripcion()});
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
   @Override
    public boolean delete(int id) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "DELETE from  plantillapresupuesto WHERE propuesta_id=?";
        c=this.getJdbcTemplate().update(sql, new Object[]{id});
        boolean r=false;
        if(c>0){
            rpta="Se elimino Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    @Override
    public int existe(int idP) {
        String sql = "SELECT count(id) as m FROM plantillapresupuesto "+
	   "WHERE propuesta_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idP},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("m");
                return t;
        }
        });
    }
    @Override
    public List<plantillaPresupuesto> todasPlantillas() {
        String sql = "SELECT id,propuesta_id,descripcion FROM plantillapresupuesto";
        List<plantillaPresupuesto> lta=this.getJdbcTemplate().query(sql,new RowMapper<plantillaPresupuesto>(){
        @Override
            public plantillaPresupuesto mapRow(ResultSet rs, int i) throws SQLException {
                plantillaPresupuesto t = new plantillaPresupuesto();
                t.setId( rs.getInt("id"));
                t.setPropuesta_id( rs.getInt("propuesta_id"));
                t.setDescripcion( rs.getString("descripcion"));
                return t;
        }
        });
        return lta;
    }
    @Override
    public int existePlantilla() {
        String sql = "SELECT count(id) as m FROM plantillapresupuesto";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("m");
                return t;
        }
        });
    }
}
