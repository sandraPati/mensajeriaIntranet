/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.proveedor_presupuesto_asignar;
import com.intranet.dao.ProveedorPresupuestoAsignarDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proveedorPresupuestoAsignarDAO")
public class IProveedorPresupuestoAsignarDAO extends UtilTemplateDAO implements ProveedorPresupuestoAsignarDAO{
    @Override
    public List<proveedor_presupuesto_asignar> findAll(String nif) {
        String sql = "SELECT id, id_prov_presu, id_presupuesto FROM proveedor_presupuesto_asignar";
        List<proveedor_presupuesto_asignar> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<proveedor_presupuesto_asignar>(){
        @Override
            public proveedor_presupuesto_asignar mapRow(ResultSet rs, int i) throws SQLException {
                proveedor_presupuesto_asignar e = new proveedor_presupuesto_asignar();
                e.setId(rs.getInt("id"));
                e.setProv_presu(rs.getInt("id_prov_presu"));
                e.setPresupuesto(rs.getInt("id_presupuesto"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public proveedor_presupuesto_asignar porId(int id) {
        String sql = "SELECT id, id_prov_presu, id_presupuesto FROM proveedor_presupuesto_asignar where id=?";
        proveedor_presupuesto_asignar est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proveedor_presupuesto_asignar>(){
        @Override
            public proveedor_presupuesto_asignar mapRow(ResultSet rs, int i) throws SQLException {
                proveedor_presupuesto_asignar e = new proveedor_presupuesto_asignar();
                e.setId(rs.getInt("id"));
                e.setProv_presu(rs.getInt("id_prov_presu"));
                e.setPresupuesto(rs.getInt("id_presupuesto"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public boolean Insert(proveedor_presupuesto_asignar cap) {
        String sql = "INSERT INTO proveedor_presupuesto_asignar(id_prov_presu, id_presupuesto) VALUES (?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getProv_presu(),cap.getPresupuesto()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    @Override
    public String Update(proveedor_presupuesto_asignar cap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean Delete(int id) {
        String sql = "DELETE FROM proveedor_presupuesto_asignar WHERE id_prov_presu=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            boolean r=false;
            if(c>0){
                r=true;
            }
            return r;
    }
    
}
