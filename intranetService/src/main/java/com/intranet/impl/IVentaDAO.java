/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.clientes;
import com.intranet.beans.propuesta;
import com.intranet.beans.venta;
import com.intranet.dao.VentaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ventaDAO")
public class IVentaDAO extends UtilTemplateDAO implements VentaDAO{
    @Override
    public List<venta> findAll() {
        String sql="SELECT c.num, c.serie, c.cliente_nif,p.nombre,p.apellidos, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccionp,c.direccione, c.rectificativa, c.notas, c.estado,c.irpf,c.causa,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,c.terminos,p.email FROM venta c inner join clientes p on(c.cliente_nif=p.nif) ";
        
        List<venta> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<venta>(){
                   @Override
            public venta mapRow(ResultSet rs, int i) throws SQLException {
                venta p = new venta(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                clientes pro=new clientes();
                pro.setNif(rs.getString(3));
                pro.setNombre(rs.getString(4));
                pro.setApellidos(rs.getString(5));
                pro.setEmail(rs.getString(21));
                p.setCliente_nif(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccionP(rs.getString(9));
                p.setDireccionE(rs.getString(10));
                p.setRectificactiva(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausa(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                p.setTotal(rs.getDouble(19));
                p.setTerminos(rs.getString(20));
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public List<venta> porFecha(String fechai, String fechaf) {
        String sql="SELECT c.num, c.serie, c.cliente_nif,p.nombre,p.apellidos, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccionp,c.direccione, c.rectificativa, c.notas, c.estado,c.irpf,c.causa,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,c.terminos,p.email FROM venta c inner join clientes p on(c.cliente_nif=p.nif)  "+
                "WHERE c.fecha BETWEEN ? AND ?";
        
        List<venta> e =this.getJdbcTemplate().query(sql, 
                new Object[]{fechai,fechaf},new RowMapper<venta>(){
                   @Override
            public venta mapRow(ResultSet rs, int i) throws SQLException {
                venta p = new venta(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                clientes pro=new clientes();
                pro.setNif(rs.getString(3));
                pro.setNombre(rs.getString(4));
                pro.setApellidos(rs.getString(5));
                pro.setEmail(rs.getString(21));
                p.setCliente_nif(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccionP(rs.getString(9));
                p.setDireccionE(rs.getString(10));
                p.setRectificactiva(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausa(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                p.setTotal(rs.getDouble(19));
                p.setTerminos(rs.getString(20));
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public venta porId(int id) {
        String sql="SELECT c.num, c.serie, c.cliente_nif,p.nombre,p.apellidos, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccionp,c.direccione, c.rectificativa, c.notas, c.estado,c.irpf,c.causa,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,c.terminos,p.email FROM venta c inner join clientes p on(c.cliente_nif=p.nif)  "+
                "WHERE c.num=?";
        
        venta e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<venta>(){
                   @Override
            public venta mapRow(ResultSet rs, int i) throws SQLException {
                venta p = new venta(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                clientes pro=new clientes();
                pro.setNif(rs.getString(3));
                pro.setNombre(rs.getString(4));
                pro.setApellidos(rs.getString(5));
                pro.setEmail(rs.getString(21));
                p.setCliente_nif(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccionP(rs.getString(9));
                p.setDireccionE(rs.getString(10));
                p.setRectificactiva(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausa(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                p.setTotal(rs.getDouble(19));
                p.setTerminos(rs.getString(20));
                
                return p;
            }
        });
        
        return e;
    }

    @Override
    public boolean Insert(venta c) {
        String sql = "INSERT INTO venta(" +
                     "serie, cliente_nif, fecha, fechavencimiento, referencia," +
                     "direccionp, direccione, rectificativa, causa, notas, terminos, estado, baseimponible, ivatotal, irpf, totalirpf, total) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getSerie(),c.getCliente_nif().getNif(),c.getFecha(),c.getFechavencimiento(),
                c.getReferencia(),c.getDireccionP(),c.getDireccionE(),c.getRectificactiva(),c.getCausa(),c.getNotas(),c.getTerminos(),c.getEstado(),
                c.getBaseimponible(),c.getIvatotal(),c.getIrpf(),c.getTotalirpf(),c.getTotal()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean respu=false;
        if(cr>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            respu=true;
        }
        return respu;
    }

    @Override
    public int ultimocompra() {
        String sql = "SELECT max(num) as c FROM venta";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                int t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public boolean Update(venta c) {
        String sql = "UPDATE venta " +
                     "SET serie=?, cliente_nif=?, fecha=?, fechavencimiento=?, referencia=?, " +
                     "direccionp=?, direccione=?, rectificativa=?, causa=?, notas=?, terminos=?, estado=?, baseimponible=?, ivatotal=?, irpf=?, totalirpf=?, total=? " +
                     "WHERE num=?";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getSerie(),c.getCliente_nif().getNif(),c.getFecha(),c.getFechavencimiento(),
                c.getReferencia(),c.getDireccionP(),c.getDireccionE(),c.getRectificactiva(),c.getCausa(),c.getNotas(),c.getTerminos(),c.getEstado(),
                c.getBaseimponible(),c.getIvatotal(),c.getIrpf(),c.getTotalirpf(),c.getTotal(),c.getNum()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        boolean respu=false;
        if(cr>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
             respu=true;
        }
        return respu;
    }

    @Override
    public boolean Delete(int id) {
        String sql = "DELETE FROM venta WHERE num=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        boolean respu=false;
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
             respu=true;
        }
        return respu;
    }
    @Override
    public boolean EstadoDePagoT(int id) {
        String sql = "UPDATE venta SET estado=1 WHERE num=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        boolean respu=false;
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
             respu=true;
        }
        return respu;
    }
    
    @Override
    public boolean EstadoDePagoF(int id) {
        String sql = "UPDATE venta SET estado=0 WHERE num=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        boolean respu=false;
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
             respu=true;
        }
        return respu;
    }
}
