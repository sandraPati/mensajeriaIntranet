/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuesto_superficie;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.PanoDAO;
import com.intranet.dao.PresupuestoDAO;
import com.intranet.dao.PresupuestoSuperficiesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoSuperficiesDAO")
public class IPresupuestoSuperficiesDAO extends UtilTemplateDAO implements PresupuestoSuperficiesDAO{
    
    @Autowired(required = true)
    PresupuestoDAO presupuestoDAO;
    @Autowired(required = true)
    EstanciasDAO estanciasDAO;
    @Autowired(required = true)
    PanoDAO panoDAO;
    
    @Override
    public List<presupuesto_superficie> findAll(int id_presup) {
        String sql = "SELECT id, presupuesto_id, estancia_id FROM presupuesto_superficies WHERE  presupuesto_id=? ";
        List<presupuesto_superficie> est =this.getJdbcTemplate().query(sql, 
                new Object[]{id_presup},new RowMapper<presupuesto_superficie>(){
        @Override
            public presupuesto_superficie mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_superficie e = new presupuesto_superficie();
                e.setId(rs.getInt("id"));
                e.setEstancia(rs.getInt("estancia_id"));
                int idPresup=rs.getInt("presupuesto_id");
                int idEs=rs.getInt("estancia_id");
                try {
                    //presupuesto cu=presupuestoDAO.porID(idPresup);
                    e.setPresupuesto_id(idPresup);
                    estancias cu2=estanciasDAO.porID(idEs);
                    e.setEstancia_id(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public presupuesto_superficie buscar(presupuesto_superficie p) {
        String sql = "SELECT id, presupuesto_id, estancia_id FROM presupuesto_superficies "
	   + "WHERE presupuesto_id=? and estancia_id=? ";
        presupuesto_superficie est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getPresupuesto_id(),p.getEstancia()},new RowMapper<presupuesto_superficie>(){
        @Override
            public presupuesto_superficie mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_superficie e = new presupuesto_superficie();
                e.setId(rs.getInt("id"));
                int idPresup=rs.getInt("presupuesto_id");
                int idEs=rs.getInt("estancia_id");
                try {
                    //presupuesto cu=presupuestoDAO.porID(idPresup);
                    e.setPresupuesto_id(idPresup);
                    estancias cu2=estanciasDAO.porID(idEs);
                    e.setEstancia_id(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public int buscarcount(presupuesto_superficie p) {
        String sql = "SELECT count(id)as id FROM presupuesto_superficies "
	   + "WHERE presupuesto_id=? and estancia_id=? ";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getPresupuesto_id(),p.getEstancia()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("id");
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public int buscarid(presupuesto_superficie p) {
        String sql = "SELECT id FROM presupuesto_superficies "
	   + "WHERE presupuesto_id=? and estancia_id=? ";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getPresupuesto_id(),p.getEstancia()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("id");
                return e;
        }
        });
        
        return est;
    }
    @Override
    public presupuesto_superficie porID(int id) {
        String sql = "SELECT id, presupuesto_id, estancia_id FROM presupuesto_superficies "
	   + "WHERE id=? ";
        presupuesto_superficie est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<presupuesto_superficie>(){
        @Override
            public presupuesto_superficie mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_superficie e = new presupuesto_superficie();
                e.setId(rs.getInt("id"));
                int idPresup=rs.getInt("presupuesto_id");
                int idEs=rs.getInt("estancia_id");
                try {
                    //presupuesto cu=presupuestoDAO.porID(idPresup);
                    e.setPresupuesto_id(idPresup);
                    estancias cu2=estanciasDAO.porID(idEs);
                    e.setEstancia_id(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return e;
        }
        });
        
        return est;
    }
    @Override
    public boolean existe(presupuesto_superficie p) {
        String sql = "SELECT count(*)as c FROM presupuesto_superficies WHERE  presupuesto_id=? and estancia_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getPresupuesto_id(),p.getEstancia_id().getId()},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }
    
    @Override
    public int tieneRegistros(int p) {
        String sql = "SELECT count(*)as c FROM presupuesto_superficies WHERE  presupuesto_id=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public String Insert(presupuesto_superficie presu) {
        String sql = "INSERT INTO presupuesto_superficies("+
	"presupuesto_id, estancia_id)"+
	"VALUES (?, ?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getPresupuesto_id(),
        presu.getEstancia()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(presupuesto_superficie presu) {
        /*String sql = "UPDATE presupuesto_superficies "+
	"SET  estancia_id=? "+
	"WHERE id=? and presupuesto_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{
        presu.getEstancia_id().getId(),presu.getId(),
        presu.getPresupuesto_id()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }*/
        return "";
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM presupuesto_superficies WHERE presupuesto_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String DeleteU(presupuesto_superficie p) {
        /*String sql = "DELETE FROM presupuesto_superficies "+
	"WHERE presupuesto_id=? and estancia_id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{
        p.getPresupuesto_id(),
        p.getEstancia_id().getId()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }*/
        return "";
    }
    @Override
    public String DeleteEstancia(presupuesto_superficie p) {
        String sql = "DELETE FROM presupuesto_superficies "+
	"WHERE presupuesto_id=? and estancia_id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{
        p.getPresupuesto_id(),
        p.getEstancia()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
}
