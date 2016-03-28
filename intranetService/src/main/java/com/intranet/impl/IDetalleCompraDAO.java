/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.compra;
import com.intranet.beans.detalleCompra;
import com.intranet.beans.tipogasto;
import com.intranet.beans.tipoiva;
import com.intranet.dao.DetalleCompraDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("detalleCompraDAO")
public class IDetalleCompraDAO extends UtilTemplateDAO implements DetalleCompraDAO{

    @Override
    public List<detalleCompra> findAll() {
        String sql="SELECT dc.id, dc.compra_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp,dc.tipogasto_id,tg.nombre "+
                "FROM detalle_compra dc inner join tipoiva ti on(dc.tipoiva_id=ti.id) inner join tipogasto tg on(dc.tipogasto_id=tg.id)";
        
        List<detalleCompra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<detalleCompra>(){
                   @Override
            public detalleCompra mapRow(ResultSet rs, int i) throws SQLException {
                detalleCompra p = new detalleCompra(); 
                p.setId(rs.getInt(1));
                compra c=new compra();
                c.setNum(rs.getInt(2));
                p.setCompra_id(c);
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
                tipogasto tipg=new tipogasto();
                tipg.setId(rs.getInt(13));
                tipg.setNombre(rs.getString(14));
                p.setTipogasto_id(tipg);
                
                return p;
            }
        });
        
        return e;
    }
    @Override
    public List<detalleCompra> findAllPorCompra(int idCompra) {
        String sql="SELECT dc.id, dc.compra_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp,dc.tipogasto_id,tg.nombre "+
                "FROM detalle_compra dc inner join tipoiva ti on(dc.tipoiva_id=ti.id) inner join tipogasto tg on(dc.tipogasto_id=tg.id) "+
                "WHERE dc.compra_id=?";
        
        List<detalleCompra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idCompra},new RowMapper<detalleCompra>(){
                   @Override
            public detalleCompra mapRow(ResultSet rs, int i) throws SQLException {
                detalleCompra p = new detalleCompra(); 
                p.setId(rs.getInt(1));
                compra c=new compra();
                c.setNum(rs.getInt(2));
                p.setCompra_id(c);
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
                tipogasto tipg=new tipogasto();
                tipg.setId(rs.getInt(13));
                tipg.setNombre(rs.getString(14));
                p.setTipogasto_id(tipg);
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public detalleCompra porId(int id) {
        String sql="SELECT dc.id, dc.compra_id, dc.productoservicio, dc.cantidad, dc.precio, dc.totalcp, dc.porcentajedescuento,   "+
                "dc.descuento, dc.tipoiva_id,ti.descripcion, dc.impuesto, dc.totalimp,dc.tipogasto_id,tg.nombre "+
                "FROM detalle_compra dc inner join tipoiva ti on(dc.tipoiva_id=ti.id) inner join tipogasto tg on(dc.tipogasto_id=tg.id) WHERE dc.id=?";
        
        detalleCompra e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<detalleCompra>(){
                   @Override
            public detalleCompra mapRow(ResultSet rs, int i) throws SQLException {
                detalleCompra p = new detalleCompra(); 
                p.setId(rs.getInt(1));
                compra c=new compra();
                c.setNum(rs.getInt(2));
                p.setCompra_id(c);
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
                tipogasto tipg=new tipogasto();
                tipg.setId(rs.getInt(13));
                tipg.setNombre(rs.getString(14));
                p.setTipogasto_id(tipg);
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public String Insert(detalleCompra c) {
        String sql = "INSERT INTO detalle_compra(" +
                     "compra_id, productoservicio, cantidad, precio, totalcp, porcentajedescuento, " +
                     "descuento, tipoiva_id, impuesto, totalimp,tipogasto_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?,?)";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getCompra_id().getNum(),c.getProductoservicio(),c.getCantidad(),c.getPrecio(),
                c.getTotalcp(),c.getPorcentajedescuento(),c.getDescuento(),c.getTipoiva_id().getId(),c.getImpuesto(),c.getTotalimp(),c.getTipogasto_id().getId()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(cr>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    public String Update(detalleCompra c) {
        String sql = "UPDATE detalle_compra " +
                     "SET compra_id=?, productoservicio=?, cantidad=?, precio=?, totalcp=?, porcentajedescuento=?, " +
                     "descuento=?, tipoiva_id=?, impuesto=?, totalimp=?,tipogasto_id=? " +
                     "WHERE id=?";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getCompra_id().getNum(),c.getProductoservicio(),c.getCantidad(),c.getPrecio(),
                c.getTotalcp(),c.getPorcentajedescuento(),c.getDescuento(),c.getTipoiva_id().getId(),c.getImpuesto(),c.getTotalimp(),c.getTipogasto_id().getId(),c.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(cr>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM detalle_compra WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String DeleteC(int id) {
        String sql = "DELETE FROM detalle_compra WHERE compra_id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
