/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.proveedor_presupuesto;
import com.intranet.dao.ProveedorPresupuestoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proveedorPresupuestoDAO")
public class IProveedorPresupuestoDAO extends UtilTemplateDAO implements ProveedorPresupuestoDAO{
    @Override
    public List<proveedor_presupuesto> findAll(int id) {
       String sql = "SELECT id, id_proveedor, descripcion, monto, iva, nota, estado FROM proveedor_presupuesto WHERE id_proveedor=?";
        List<proveedor_presupuesto> list = this.getJdbcTemplate().query(sql,new Object[]{id},new RowMapper<proveedor_presupuesto>(){
        @Override
            public proveedor_presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                proveedor_presupuesto user = new proveedor_presupuesto();
                user.setId(rs.getInt("id"));
                user.setId_proveedor(rs.getInt("id_proveedor"));
                user.setDescripcion(rs.getString("descripcion"));
                user.setMonto(rs.getDouble("monto"));
                user.setIva(rs.getDouble("iva"));
                user.setNota(rs.getString("nota"));
                user.setEstado(rs.getInt("estado"));
                return user;
        }
        });
        
        return list;
    }
    @Override
    public List<proveedor_presupuesto> findAllPorProyecto(int id) {
       String sql = "SELECT prop.id, prop.id_proveedor, prop.descripcion, prop.monto, prop.iva, prop.nota, prop.estado "+
               "FROM proveedor_presupuesto_asignar pp inner join proveedor_presupuesto prop on(pp.id_prov_presu=prop.id) inner join presupuesto pre "+
               "on(pp.id_presupuesto=pre.id) where pre.propuesta_id=?";
        List<proveedor_presupuesto> list = this.getJdbcTemplate().query(sql,new Object[]{id},new RowMapper<proveedor_presupuesto>(){
        @Override
            public proveedor_presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                proveedor_presupuesto user = new proveedor_presupuesto();
                user.setId(rs.getInt("id"));
                user.setId_proveedor(rs.getInt("id_proveedor"));
                user.setDescripcion(rs.getString("descripcion"));
                user.setMonto(rs.getDouble("monto"));
                user.setIva(rs.getDouble("iva"));
                user.setNota(rs.getString("nota"));
                user.setEstado(rs.getInt("estado"));
                return user;
        }
        });
        
        return list;
    }
    @Override
    public proveedor_presupuesto porID(int id) {
        String sql = "SELECT id, id_proveedor, descripcion, monto, iva, nota, estado FROM proveedor_presupuesto WHERE id=?";
        proveedor_presupuesto list = this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<proveedor_presupuesto>(){
        @Override
            public proveedor_presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                proveedor_presupuesto user = new proveedor_presupuesto();
                user.setId(rs.getInt("id"));
                user.setId_proveedor(rs.getInt("id_proveedor"));
                user.setDescripcion(rs.getString("descripcion"));
                user.setMonto(rs.getDouble("monto"));
                user.setIva(rs.getDouble("iva"));
                user.setNota(rs.getString("nota"));
                user.setEstado(rs.getInt("estado"));
                return user;
        }
        });
        
        return list;
    }
    @Override
    public boolean Insert(proveedor_presupuesto est) {
        String sql = "INSERT INTO proveedor_presupuesto(id_proveedor, descripcion, monto, iva, nota, estado) VALUES (?, ?, ?, ?, ?, 1) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getId_proveedor(),est.getDescripcion(),est.getMonto(),est.getIva(),est.getNota()});
        boolean r=false;
        if(c>0){
            r=true;
        }
        return r;
    }
    @Override
    public boolean Update(proveedor_presupuesto est) {
        String sql = "UPDATE proveedor_presupuesto SET descripcion=?, monto=?, iva=?, nota=? WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getDescripcion(),est.getMonto(),est.getIva(),est.getNota(),est.getId()});
        boolean r=false;
        if(c>0){
            r=true;
        }
        return r;
    }
    @Override
    public boolean Delete(Integer id) {
        String sql = "DELETE FROM proveedor_presupuesto WHERE id=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            boolean r=false;
            if(c>0){
                r=true;
            }
            return r;
    }
    
    @Override
    public int idultimo() {
        String sql = "SELECT max(id) as c FROM proveedor_presupuesto";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    
    @Override
    public String UpdateAprobado(int id) {
    String sql = "UPDATE proveedor_presupuesto SET estado=2 WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateRechazado(int id) {
    String sql = "UPDATE proveedor_presupuesto SET estado=3 WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
     @Override
    public int existeAsignado(int id) {
        String sql = "SELECT count(*) as c FROM proveedor_presupuesto_asignar WHERE id_prov_presu=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
}
