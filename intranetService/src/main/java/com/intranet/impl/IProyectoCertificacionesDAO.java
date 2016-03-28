/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.proyecto_certificaciones;
import com.intranet.beans.proyecto_presupuestos;
import com.intranet.dao.ProyectoCertificacionesDAO;
import com.intranet.dao.ProyectoPresupuestoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proyectoCertificacionesDAO")
public class IProyectoCertificacionesDAO extends UtilTemplateDAO implements ProyectoCertificacionesDAO{
    
    @Autowired(required = true)
    ProyectoPresupuestoDAO proyectoPresupuestoDAO;
    
    @Override
    public List<proyecto_certificaciones> findAll(int idProyectoPresupuesto) {
        String sql = "SELECT id, id_proyecto_presupuesto, porcentaje_terminado, monto_semana,fecha,numsemana "+
	"FROM proyecto_certificaciones where id_proyecto_presupuesto=? ";
        List<proyecto_certificaciones> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<proyecto_certificaciones>(){
        @Override
            public proyecto_certificaciones mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones e = new proyecto_certificaciones();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setPorcentaje_terminado(rs.getInt(3));
                e.setMonto_semana(rs.getFloat(4));
	        e.setFecha(rs.getDate(5));
	        e.setNumsemana(rs.getInt(6));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public proyecto_certificaciones porId(int id) {
        String sql = "SELECT id, id_proyecto_presupuesto, porcentaje_terminado, monto_semana,fecha,numsemana "+
	"FROM proyecto_certificaciones where id=? ";
        proyecto_certificaciones est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proyecto_certificaciones>(){
        @Override
            public proyecto_certificaciones mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones e = new proyecto_certificaciones();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setPorcentaje_terminado(rs.getInt(3));
                e.setMonto_semana(rs.getFloat(4));
	        e.setFecha(rs.getDate(5));
	        e.setNumsemana(rs.getInt(6));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public int maximo(int idProyectoPresupuesto) {
        String sql = "SELECT max(id)as c FROM proyecto_certificaciones where id_proyecto_presupuesto=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public int existeCertificaciones(int idPropuesta) {
        String sql = "select count(*)as c from proyecto_certificaciones pc inner join proyecto_presupuesto pp on(pc.id_proyecto_presupuesto=pp.id) "+
                "inner join presupuesto p on(pp.id_presupuesto=p.id) inner join presupuestoc pre on(p.presup_id=pre.id)  where pre.propuesta_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPropuesta},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public int existeCertificacionesSemana(int idPropuesta,int num) {
        String sql = "select count(*)as c from proyecto_certificaciones pc inner join proyecto_presupuesto pp on(pc.id_proyecto_presupuesto=pp.id) "+
                "inner join presupuesto p on(pp.id_presupuesto=p.id)  inner join presupuestoc pre on(p.presup_id=pre.id) where pre.propuesta_id=? and pc.numsemana=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPropuesta,num},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public String Insert(proyecto_certificaciones presu) {
        String sql = "INSERT INTO proyecto_certificaciones( "+
	"id_proyecto_presupuesto, porcentaje_terminado, monto_semana,fecha,numsemana)"+
	"VALUES (?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getId_proyecto_presupuesto().getId(),
            presu.getPorcentaje_terminado(), presu.getMonto_semana(),
            presu.getFecha(), presu.getNumsemana()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(proyecto_certificaciones presu) {
        String sql = "UPDATE proyecto_certificaciones "+
	"SET porcentaje_terminado=?, monto_semana=?,fecha=?,numsemana=? "+
	"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{
            presu.getPorcentaje_terminado(), presu.getMonto_semana(),
            presu.getFecha(), presu.getNumsemana(),presu.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM proyecto_certificaciones WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{
            id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
