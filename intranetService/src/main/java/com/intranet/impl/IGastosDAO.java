/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.empleados;
import com.intranet.beans.formapago;
import com.intranet.beans.formapagogasto;
import com.intranet.beans.gastos;
import com.intranet.beans.gastosR;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipogasto;
import com.intranet.beans.tipoingreso;
import com.intranet.dao.ClienteDAO;
import com.intranet.dao.FormaPagoDAO;
import com.intranet.dao.GastosDAO;
import com.intranet.dao.GastosRDAO;
import com.intranet.dao.TipoIngresoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("gastosDAO")
public class IGastosDAO extends UtilTemplateDAO implements GastosDAO {
    @Autowired(required = true)
    FormaPagoDAO formaPagoDAO;
    @Autowired(required = true)
    TipoIngresoDAO tipoIngresoDAO;
    @Autowired(required = true)
    ClienteDAO clienteDAO;
    @Autowired(required = true)
    GastosRDAO gastosRDAO;
    @Override
    public List<gastos> findAll() {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipogasto_id,ti.nombre, i.fechapago, i.proveedor_id,pro.nombre,pro.persona_contacto, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadogasto,i.porcentajededuccion,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  "+
        "FROM gastos i inner join formapagogasto fp on(i.formapago_id=fp.id) inner join tipogasto ti on(i.tipogasto_id=ti.id) inner join proveedores pro on(i.proveedor_id=pro.id) inner join empleados emp on(i.nifempleado=emp.nif) ";
        List<gastos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<gastos>(){
        @Override
            public gastos mapRow(ResultSet rs, int i) throws SQLException {
                gastos e = new gastos();
                e.setId(rs.getInt("id"));
               
                try {
                    
                        formapagogasto f=new formapagogasto();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipogasto ti=new tipogasto();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipogasto_id(ti);
                    
                    
                        proveedores prov=new proveedores();
                        prov.setId(rs.getInt(7));
                        prov.setNombre(rs.getString(8));
                        prov.setPersona_contacto(rs.getString(9));
                        e.setProveedor_id(prov);
                        
                    
                        
                        e.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(e.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        e.setNifempleado(emp);
                        gastosR gg=gastosRDAO.porIdGasto(e.getId());
                        if(gg.getId()!=0)
                        e.setImgfactura(1);
                        else e.setImgfactura(0);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setReferencia(rs.getString(10));
	        e.setCuenta_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadogasto(rs.getString(15));
                e.setPorcentaje_deduccion(rs.getDouble(16));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public List<gastos> findAllEmpleado(String nif) {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipogasto_id,ti.nombre, i.fechapago, i.proveedor_id,pro.nombre,pro.persona_contacto, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadogasto,i.porcentajededuccion,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  "+
        "FROM gastos i inner join formapagogasto fp on(i.formapago_id=fp.id) inner join tipogasto ti on(i.tipogasto_id=ti.id) inner join proveedores pro on(i.proveedor_id=pro.id) inner join empleados emp on(i.nifempleado=emp.nif) where i.nifempleado=?";
        List<gastos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<gastos>(){
        @Override
            public gastos mapRow(ResultSet rs, int i) throws SQLException {
                gastos e = new gastos();
                e.setId(rs.getInt("id"));
               
                try {
                    
                        formapagogasto f=new formapagogasto();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipogasto ti=new tipogasto();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipogasto_id(ti);
                    
                    
                        proveedores prov=new proveedores();
                        prov.setId(rs.getInt(7));
                        prov.setNombre(rs.getString(8));
                        prov.setPersona_contacto(rs.getString(9));
                        e.setProveedor_id(prov);
                       
                    
                        
                        e.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(e.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        e.setNifempleado(emp);
                        
                        gastosR gg=gastosRDAO.porIdGasto(e.getId());
                        if(gg.getId()!=0)
                        e.setImgfactura(1);
                        else e.setImgfactura(0);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setReferencia(rs.getString(10));
	        e.setCuenta_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadogasto(rs.getString(15));
                e.setPorcentaje_deduccion(rs.getDouble(16));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public gastos porID(int id) {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipogasto_id,ti.nombre, i.fechapago, i.proveedor_id,pro.nombre,pro.persona_contacto, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadogasto,i.porcentajededuccion,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  "+
        "FROM gastos i inner join formapagogasto fp on(i.formapago_id=fp.id) inner join tipogasto ti on(i.tipogasto_id=ti.id) inner join proveedores pro on(i.proveedor_id=pro.id) inner join empleados emp on(i.nifempleado=emp.nif) "+
                "WHERE i.id=?";
        gastos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<gastos>(){
        @Override
            public gastos mapRow(ResultSet rs, int i) throws SQLException {
                gastos e = new gastos();
                e.setId(rs.getInt("id"));
               
                try {
                    
                        formapagogasto f=new formapagogasto();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipogasto ti=new tipogasto();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipogasto_id(ti);
                    
                    
                        proveedores prov=new proveedores();
                        prov.setId(rs.getInt(7));
                        prov.setNombre(rs.getString(8));
                        prov.setPersona_contacto(rs.getString(9));
                        e.setProveedor_id(prov);
                    
                     
                        
                        e.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(e.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        e.setNifempleado(emp);
                        
                        gastosR gg=gastosRDAO.porIdGasto(e.getId());
                        if(gg.getId()!=0)
                        e.setImgfactura(1);
                        else e.setImgfactura(0);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setReferencia(rs.getString(10));
	        e.setCuenta_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadogasto(rs.getString(15));
                e.setPorcentaje_deduccion(rs.getDouble(16));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public int ultimo(gastos g) {
        String sql = "SELECT max(id)as c "+
        "FROM gastos WHERE proveedor_id=? and fechapago=?";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{g.getProveedor_id().getId(),g.getFechapago()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                int e = rs.getInt(1);
                
                return e;
        }
        });
        
        return est;
    }
    @Override
    public List<gastos> porIDProv(int idP) {
        String sql = "SELECT i.id,i.formapago_id,fp.nombre, i.tipogasto_id,ti.nombre, i.fechapago, i.proveedor_id,pro.nombre,pro.persona_contacto, i.referencia, i.cuentabancaria, i.totalbruto, i.porcentajeirpf, i.estado, i.estadogasto,i.porcentajededuccion,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp "+
        "FROM gastos i inner join formapagogasto fp on(i.formapago_id=fp.id) inner join tipogasto ti on(i.tipogasto_id=ti.id) inner join proveedores pro on(i.proveedor_id=pro.id) inner join empleados emp on(i.nifempleado=emp.nif) "+
                "WHERE i.proveedor_id=?";
        List<gastos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idP},new RowMapper<gastos>(){
        @Override
            public gastos mapRow(ResultSet rs, int i) throws SQLException {
                gastos e = new gastos();
                e.setId(rs.getInt("id"));
               
                try {
                    
                        formapagogasto f=new formapagogasto();
                        f.setId(rs.getInt(2));
                        f.setNombre(rs.getString(3));
                        e.setFormapago_id(f);
                    
                    
                        tipogasto ti=new tipogasto();
                        ti.setId(rs.getInt(4));
                        ti.setNombre(rs.getString(5));
                        e.setTipogasto_id(ti);
                    
                    
                        proveedores prov=new proveedores();
                        prov.setId(rs.getInt(7));
                        prov.setNombre(rs.getString(8));
                        prov.setPersona_contacto(rs.getString(9));
                        e.setProveedor_id(prov);
                    
                    
                        
                        e.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(e.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        e.setNifempleado(emp);
                        
                        gastosR gg=gastosRDAO.porIdGasto(e.getId());
                        if(gg.getId()!=0)
                        e.setImgfactura(1);
                        else e.setImgfactura(0);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFechapago(rs.getDate(6));
	        e.setReferencia(rs.getString(10));
	        e.setCuenta_bancaria(rs.getString(11));
                e.setTotalbruto(rs.getDouble(12));
                e.setPorcentaje_irpf(rs.getDouble(13));
                e.setEstado(rs.getInt(14));
                e.setEstadogasto(rs.getString(15));
                e.setPorcentaje_deduccion(rs.getDouble(16));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public String Insert(gastos cap) {
        String sql = "INSERT INTO gastos(formapago_id, tipogasto_id, fechapago, proveedor_id, referencia,cuentabancaria, totalbruto, porcentajeirpf, porcentajededuccion, estado, estadogasto,nifempleado)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getFormapago_id().getId(),cap.getTipogasto_id().getId(),cap.getFechapago(),cap.getProveedor_id().getId(),
        cap.getReferencia(),cap.getCuenta_bancaria(),cap.getTotalbruto(),cap.getPorcentaje_irpf(),cap.getPorcentaje_deduccion(),cap.getEstado(),cap.getEstadogasto(),cap.getNif()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String Update(gastos cap) {
        String sql = "UPDATE gastos SET formapago_id=?, tipogasto_id=?, fechapago=?, proveedor_id=?, referencia=?,cuentabancaria=?, totalbruto=?, porcentajeirpf=?, porcentajededuccion=?, estado=?, estadogasto=? "+
                "WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getFormapago_id().getId(),cap.getTipogasto_id().getId(),cap.getFechapago(),cap.getProveedor_id().getId(),
        cap.getReferencia(),cap.getCuenta_bancaria(),cap.getTotalbruto(),cap.getPorcentaje_irpf(),cap.getPorcentaje_deduccion(),cap.getEstado(),cap.getEstadogasto(),cap.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String Delete(int id) {
         String sql = "DELETE FROM gastos "+
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
        String sql = "UPDATE gastos SET estado=1 WHERE id=?";
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
        String sql = "UPDATE gastos SET estado=0 WHERE id=?";
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
