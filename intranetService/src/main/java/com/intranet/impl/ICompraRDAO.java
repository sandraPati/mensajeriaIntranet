/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.compraR;
import com.intranet.dao.CompraRDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("compraRDAO")
public class ICompraRDAO extends UtilTemplateDAO implements CompraRDAO  {
    @Override
    public compraR porId(int id) {
        String sql = "SELECT id, idcompra, nombreimg "+
	"FROM comprar where id=? ";
        compraR est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<compraR>(){
        @Override
            public compraR mapRow(ResultSet rs, int i) throws SQLException {
                compraR e = new compraR();
                e.setId(rs.getInt("id"));
                e.setIdcompra(rs.getInt("idcompra"));
               
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                return e;
        }
        });
        
        return est;
    }
    @Override
    public compraR porIdCompra(int id) {
        String sql = "SELECT id, idcompra, nombreimg "+
	"FROM comprar where idcompra=? ";
        compraR est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<compraR>(){
        @Override
            public compraR mapRow(ResultSet rs, int i) throws SQLException {
                compraR e = new compraR();
                e.setId(rs.getInt("id"));
                e.setIdcompra(rs.getInt("idcompra"));
               
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                return e;
        }
        });
        
        return est;
    }
    @Override
    public boolean existe(String nombreimg) {
        String sql = "SELECT count(*)as c "+
	"FROM comprar where nombreimg=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nombreimg},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }
    @Override
    public String insertar(compraR p) {
         String sql = "INSERT INTO comprar("+
	"idcompra, nombreimg)"+
	"VALUES (?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getIdcompra(),p.getNombreimg()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String update(compraR p) {
        String sql = "UPDATE comprar "+
	"SET nombreimg=? "+
	"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreimg(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String updateCompra(compraR p) {
         String sql = "UPDATE comprar "+
	"SET nombreimg=? "+
	"WHERE idcompra=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreimg(),p.getIdcompra()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String eliminar(int id) {
       String sql = "DELETE FROM comprar  WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String eliminarGasto(int id) {
         String sql = "DELETE FROM comprar  WHERE idcompra=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
