/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.detalleVenta;
import com.intranet.beans.tipoiva;
import com.intranet.beans.venta;
import com.intranet.dao.DetalleVentaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("detalleVentaDAO")
public class IDetalleVentaDAO extends UtilTemplateDAO implements DetalleVentaDAO{

    @Override
    public List<detalleVenta> findAll() {
        String sql="SELECT dc.id, dc.venta_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp "+
                "FROM detalle_venta dc inner join tipoiva ti on(dc.tipoiva_id=ti.id)";
        
        List<detalleVenta> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<detalleVenta>(){
                   @Override
            public detalleVenta mapRow(ResultSet rs, int i) throws SQLException {
                detalleVenta p = new detalleVenta(); 
                p.setId(rs.getInt(1));
                venta c=new venta();
                c.setNum(rs.getInt(2));
                p.setVenta_id(c);
                p.setProductoservicio(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                p.setTotalcp(rs.getDouble(6));
                p.setPorcentajedescuento(rs.getDouble(7));
                p.setDescuento(rs.getDouble(8));
                tipoiva ti=new tipoiva();
                ti.setId(rs.getInt(9));
                ti.setDescripcion(rs.getString(10));
                p.setTipoiva_id(ti);
                p.setImpuesto(rs.getDouble(11));
                p.setTotalimp(rs.getDouble(12));
                
                
                return p;
            }
        });
        
        return e;
    }
    
    @Override
    public List<detalleVenta> findAllPorVenta(int idV) {
        String sql="SELECT dc.id, dc.venta_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp "+
                "FROM detalle_venta dc inner join tipoiva ti on(dc.tipoiva_id=ti.id) WHERE dc.venta_id=?";
        
        List<detalleVenta> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idV},new RowMapper<detalleVenta>(){
                   @Override
            public detalleVenta mapRow(ResultSet rs, int i) throws SQLException {
                detalleVenta p = new detalleVenta(); 
                p.setId(rs.getInt(1));
                venta c=new venta();
                c.setNum(rs.getInt(2));
                p.setVenta_id(c);
                p.setProductoservicio(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                p.setTotalcp(rs.getDouble(6));
                p.setPorcentajedescuento(rs.getDouble(7));
                p.setDescuento(rs.getDouble(8));
                tipoiva ti=new tipoiva();
                ti.setId(rs.getInt(9));
                ti.setDescripcion(rs.getString(10));
                p.setTipoiva_id(ti);
                p.setImpuesto(rs.getDouble(11));
                p.setTotalimp(rs.getDouble(12));
                
                
                return p;
            }
        });
        
        return e;
    }
    
    @Override
    public detalleVenta porId(int id) {
        String sql="SELECT dc.id, dc.venta_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp "+
                "FROM detalle_venta dc inner join tipoiva ti on(dc.tipoiva_id=ti.id) WHERE dc.id=?";
        
        detalleVenta e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<detalleVenta>(){
                   @Override
            public detalleVenta mapRow(ResultSet rs, int i) throws SQLException {
                detalleVenta p = new detalleVenta(); 
                p.setId(rs.getInt(1));
                venta c=new venta();
                c.setNum(rs.getInt(2));
                p.setVenta_id(c);
                p.setProductoservicio(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                p.setTotalcp(rs.getDouble(6));
                p.setPorcentajedescuento(rs.getDouble(7));
                p.setDescuento(rs.getDouble(8));
                tipoiva ti=new tipoiva();
                ti.setId(rs.getInt(9));
                ti.setDescripcion(rs.getString(10));
                p.setTipoiva_id(ti);
                p.setImpuesto(rs.getDouble(11));
                p.setTotalimp(rs.getDouble(12));
                
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public String Insert(detalleVenta c) {
        String sql = "INSERT INTO detalle_venta(" +
                     "venta_id, productoservicio, cantidad, precio, totalcp, porcentajedescuento, " +
                     "descuento, tipoiva_id, impuesto, totalimp) " +
                     "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getVenta_id().getNum(),c.getProductoservicio(),c.getCantidad(),c.getPrecio(),
                c.getTotalcp(),c.getPorcentajedescuento(),c.getDescuento(),c.getTipoiva_id().getId(),c.getImpuesto(),c.getTotalimp()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(cr>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(detalleVenta c) {
        String sql = "UPDATE detalle_venta " +
                     "SET venta_id=?, productoservicio=?, cantidad=?, precio=?, totalcp=?, porcentajedescuento=?, " +
                     "descuento=?, tipoiva_id=?, impuesto=?, totalimp=? " +
                     "WHERE id=?";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getVenta_id().getNum(),c.getProductoservicio(),c.getCantidad(),c.getPrecio(),
                c.getTotalcp(),c.getPorcentajedescuento(),c.getDescuento(),c.getTipoiva_id().getId(),c.getImpuesto(),c.getTotalimp(),c.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(cr>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM detalle_venta WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String DeleteC(int id) {
        String sql = "DELETE FROM detalle_venta WHERE venta_id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
