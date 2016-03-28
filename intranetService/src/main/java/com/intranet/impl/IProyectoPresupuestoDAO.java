/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.presupuesto;
import com.intranet.beans.proyecto_presupuestos;
import com.intranet.dao.PresupuestoDAO;
import com.intranet.dao.ProyectoPresupuestoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proyectoPresupuestoDAO")
public class IProyectoPresupuestoDAO extends UtilTemplateDAO implements ProyectoPresupuestoDAO{
    
    @Autowired(required = true)
    PresupuestoDAO presupuestoDAO;
    
    @Override
    public List<proyecto_presupuestos> findAll(int idPropuesta, int idcap) {
        String sql = "SELECT proy.id, proy.id_presupuesto, proy.num_trabajadores, proy.numhoras, proy.estado "+
	  "FROM proyecto_presupuesto proy INNER JOIN presupuesto pre on(proy.id_presupuesto=pre.id) INNER JOIN  capitulos c on(pre.capitulo_id=c.id) "+
	  "where pre.propuesta_id=? and c.id=?";
        List<proyecto_presupuestos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPropuesta,idcap},new RowMapper<proyecto_presupuestos>(){
        @Override
            public proyecto_presupuestos mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_presupuestos e = new proyecto_presupuestos();
                e.setId(rs.getInt("id"));
                
                int idC=rs.getInt("id_presupuesto");
                try {
                    presupuesto cu=presupuestoDAO.porID(idC);
                    e.setId_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNum_trabajadores(rs.getInt(3));
                e.setNumhoras(rs.getInt(4));
                e.setEstado(rs.getBoolean(5));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_presupuestos> findAllPPres(int idPresup) {
        String sql = "SELECT proy.id, proy.id_presupuesto, proy.num_trabajadores, proy.numhoras, proy.estado "+
	  "FROM proyecto_presupuesto proy INNER JOIN presupuesto pre on(proy.id_presupuesto=pre.id)  "+
	  "where pre.id=? ";
        List<proyecto_presupuestos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPresup},new RowMapper<proyecto_presupuestos>(){
        @Override
            public proyecto_presupuestos mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_presupuestos e = new proyecto_presupuestos();
                e.setId(rs.getInt("id"));
                
                int idC=rs.getInt("id_presupuesto");
                try {
                    presupuesto cu=presupuestoDAO.porID(idC);
                    e.setId_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNum_trabajadores(rs.getInt(3));
                e.setNumhoras(rs.getInt(4));
                e.setEstado(rs.getBoolean(5));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_presupuestos> findAll2(int idPropuesta) {
        String sql = "SELECT proy.id, proy.id_presupuesto, proy.num_trabajadores, proy.numhoras, proy.estado "+
	"FROM proyecto_presupuesto proy INNER JOIN presupuesto pre on(proy.id_presupuesto=pre.id)  "+
	"where pre.propuesta_id=? ";
        List<proyecto_presupuestos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPropuesta},new RowMapper<proyecto_presupuestos>(){
        @Override
            public proyecto_presupuestos mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_presupuestos e = new proyecto_presupuestos();
                e.setId(rs.getInt("id"));
                
                int idC=rs.getInt("id_presupuesto");
                try {
                    presupuesto cu=presupuestoDAO.porID(idC);
                    e.setId_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNum_trabajadores(rs.getInt(3));
                e.setNumhoras(rs.getInt(4));
                e.setEstado(rs.getBoolean(5));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public proyecto_presupuestos porId(int id) {
        String sql = "SELECT proy.id, proy.id_presupuesto, proy.num_trabajadores, proy.numhoras, proy.estado "+
	   "FROM proyecto_presupuesto proy INNER JOIN presupuesto pre on(proy.id_presupuesto=pre.id) "+
	   "where proy.id=? ";
        proyecto_presupuestos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proyecto_presupuestos>(){
        @Override
            public proyecto_presupuestos mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_presupuestos e = new proyecto_presupuestos();
                e.setId(rs.getInt("id"));
                
                int idC=rs.getInt("id_presupuesto");
                try {
                    presupuesto cu=presupuestoDAO.porID(idC);
                    e.setId_presupuesto(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNum_trabajadores(rs.getInt(3));
                e.setNumhoras(rs.getInt(4));
                e.setEstado(rs.getBoolean(5));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String Insert(proyecto_presupuestos presu) {
        String sql = "INSERT INTO proyecto_presupuesto(id_presupuesto, num_trabajadores, numhoras, estado) "+
	"VALUES (?, ?, ?, false)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getId_presupuesto().getId(),presu.getNum_trabajadores(),presu.getNumhoras()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(proyecto_presupuestos presu) {
        String sql = "UPDATE proyecto_presupuesto "+
	"SET num_trabajadores=?, numhoras=?"+
	"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getNum_trabajadores(),presu.getNumhoras(),presu.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM proyecto_presupuesto WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
