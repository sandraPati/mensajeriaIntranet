/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.clientes;
import com.intranet.beans.formapago;
import com.intranet.beans.ingresos;
import com.intranet.beans.tipoingreso;
import com.intranet.dao.ClienteDAO;
import com.intranet.dao.FormaPagoDAO;
import com.intranet.dao.IngresosDAO;
import com.intranet.dao.TipoIngresoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ingresosDAO")
public class IIngresosDAO extends UtilTemplateDAO implements IngresosDAO{
    @Autowired(required = true)
    FormaPagoDAO formaPagoDAO;
    @Autowired(required = true)
    TipoIngresoDAO tipoIngresoDAO;
    @Autowired(required = true)
    ClienteDAO clienteDAO;
    
    @Override
    public List<ingresos> findAll() {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipoingreso_id,ti.nombre, i.fechapago, i.cliente_nif,cli.apellidos,cli.nombre, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadoingreso  "+
                "FROM ingresos i inner join formapago fp on(i.formapago_id=fp.id) inner join tipoingreso ti on(i.tipoingreso_id=ti.id) inner join clientes cli on(i.cliente_nif=cli.nif)";
        List<ingresos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<ingresos>(){
        @Override
            public ingresos mapRow(ResultSet rs, int i) throws SQLException {
                ingresos e = new ingresos();
                e.setId(rs.getInt("id"));
               
                try {
                    
                        formapago f=new formapago();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipoingreso ti=new tipoingreso();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipoingreso_id(ti);
                    
                    
                        clientes cli=new clientes();
                        cli.setNif(rs.getString(7));
                        cli.setApellidos(rs.getString(8));
                        cli.setNombre(rs.getString(9));
                        
                        e.setCliente_nif(cli);
                    
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setRefenrecia(rs.getString(10));
	        e.setCuente_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadoingreso(rs.getString(15));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public ingresos porID(int id) {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipoingreso_id,ti.nombre, i.fechapago, i.cliente_nif,cli.apellidos,cli.nombre, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadoingreso  "+
                "FROM ingresos i inner join formapago fp on(i.formapago_id=fp.id) inner join tipoingreso ti on(i.tipoingreso_id=ti.id) inner join clientes cli on(i.cliente_nif=cli.nif) "+
                "WHERE i.id=?";
        
        ingresos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<ingresos>(){
        @Override
            public ingresos mapRow(ResultSet rs, int i) throws SQLException {
                ingresos e = new ingresos();
                e.setId(rs.getInt("id"));
                
                try {
                    formapago f=new formapago();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipoingreso ti=new tipoingreso();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipoingreso_id(ti);
                    
                    
                        clientes cli=new clientes();
                        cli.setNif(rs.getString(7));
                        cli.setApellidos(rs.getString(8));
                        cli.setNombre(rs.getString(9));
                        
                        e.setCliente_nif(cli);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setRefenrecia(rs.getString(10));
	        e.setCuente_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadoingreso(rs.getString(15));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public List<ingresos> porNIF(String nif) {
    String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipoingreso_id,ti.nombre, i.fechapago, i.cliente_nif,cli.apellidos,cli.nombre, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadoingreso  "+
                "FROM ingresos i inner join formapago fp on(i.formapago_id=fp.id) inner join tipoingreso ti on(i.tipoingreso_id=ti.id) inner join clientes cli on(i.cliente_nif=cli.nif) "+
                "WHERE i.cliente_nif=?";
            
        List<ingresos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<ingresos>(){
        @Override
            public ingresos mapRow(ResultSet rs, int i) throws SQLException {
                ingresos e = new ingresos();
                e.setId(rs.getInt("id"));
                
                try {
                    formapago f=new formapago();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipoingreso ti=new tipoingreso();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipoingreso_id(ti);
                    
                    
                        clientes cli=new clientes();
                        cli.setNif(rs.getString(7));
                        cli.setApellidos(rs.getString(8));
                        cli.setNombre(rs.getString(9));
                        
                        e.setCliente_nif(cli);
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setRefenrecia(rs.getString(10));
	        e.setCuente_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadoingreso(rs.getString(15));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public String Insert(ingresos cap) {
        String sql = "INSERT INTO ingresos(formapago_id, tipoingreso_id, fechapago, cliente_nif, referencia, cuentabancaria, totalbruto, porcentajeirpf, estado, estadoingreso)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getFormapago_id().getId(),cap.getTipoingreso_id().getId(),cap.getFechapago(),cap.getCliente_nif().getNif(),
        cap.getRefenrecia(),cap.getCuente_bancaria(),cap.getTotalbruto(),cap.getPorcentaje_irpf(),cap.getEstado(),cap.getEstadoingreso()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String Update(ingresos cap) {
        String sql = "UPDATE ingresos SET formapago_id=?, tipoingreso_id=?, fechapago=?, cliente_nif=?, referencia=?, cuentabancaria=?, totalbruto=?, porcentajeirpf=?, estado=?, estadoingreso=? "+
                "WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getFormapago_id().getId(),cap.getTipoingreso_id().getId(),cap.getFechapago(),cap.getCliente_nif().getNif(),
        cap.getRefenrecia(),cap.getCuente_bancaria(),cap.getTotalbruto(),cap.getPorcentaje_irpf(),cap.getEstado(),cap.getEstadoingreso(),cap.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM ingresos "+
	"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public boolean EstadoDePagoT(int id) {
        String sql = "UPDATE ingresos SET estado=1 WHERE id=?";
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
        String sql = "UPDATE ingresos SET estado=0 WHERE id=?";
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
