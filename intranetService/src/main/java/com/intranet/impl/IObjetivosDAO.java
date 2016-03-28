/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.Objetivos;
import com.intranet.dao.ObjetivosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("objetivosDAO")
public class IObjetivosDAO extends UtilTemplateDAO implements ObjetivosDAO{
    @Override
    public List<Objetivos> findAll() {
        String sql = "SELECT id, nif_empleado, num_visitas, num_presupuesto, num_contratos, importe FROM objetivos ";
        List<Objetivos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<Objetivos>(){
        @Override
            public Objetivos mapRow(ResultSet rs, int i) throws SQLException {
                Objetivos e = new Objetivos();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNum_visitas(rs.getInt("num_visitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public Objetivos ById(int id) {
        String sql = "SELECT id, nif_empleado, num_visitas, num_presupuesto, num_contratos, importe FROM objetivos WHERE id=?";
        Objetivos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<Objetivos>(){
        @Override
            public Objetivos mapRow(ResultSet rs, int i) throws SQLException {
                Objetivos e = new Objetivos();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNum_visitas(rs.getInt("num_visitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public Objetivos ByNif(String nif) {
        String sql = "SELECT id, nif_empleado, num_visitas, num_presupuesto, num_contratos, importe FROM objetivos WHERE nif_empleado=?";
        Objetivos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Objetivos>(){
        @Override
            public Objetivos mapRow(ResultSet rs, int i) throws SQLException {
                Objetivos e = new Objetivos();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNum_visitas(rs.getInt("num_visitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                return e;
        }
        });
        
        return est;
    }
   
    @Override
    public boolean Insert(Objetivos cont) {
        String sql = "INSERT INTO objetivos(nif_empleado, num_visitas, num_presupuesto, num_contratos, importe) VALUES (?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado(),cont.getNum_visitas(),cont.getNum_presupuesto(),cont.getNum_contratos(),cont.getImporte()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    @Override
    public boolean Update(Objetivos cont) {
        String sql = "UPDATE objetivos SET num_visitas=?, num_presupuesto=?, num_contratos=?, importe=? WHERE nif_empleado=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNum_visitas(),cont.getNum_presupuesto(),cont.getNum_contratos(),cont.getImporte(),cont.getNif_empleado()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    @Override
    public boolean existe(String nif) {
        String sql = "SELECT count(*)as c FROM objetivos WHERE nif_empleado=?";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("c");
                return e;
        }
        });
        boolean r=false;
        if(est!=0)r=true;
        return r;
    }
}
