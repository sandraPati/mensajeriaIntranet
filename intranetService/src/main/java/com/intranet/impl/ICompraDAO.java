/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.compra;
import com.intranet.beans.compraR;
import com.intranet.beans.empleados;
import com.intranet.beans.gastosR;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipoiva;
import com.intranet.dao.CompraDAO;
import com.intranet.dao.CompraRDAO;
import com.intranet.dao.ProveedorDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("compraDAO")
public class ICompraDAO extends UtilTemplateDAO implements CompraDAO {
    @Autowired(required = true)
    ProveedorDAO proveedorDAO;
    @Autowired(required = true)
    CompraRDAO compraRDAO;
    @Override
    public List<compra> findAllProveedor(int id) {
        String sql="SELECT c.num, c.serie, c.proveedor_id,p.nombre,p.persona_contacto, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccion, c.tipocuenta,c.retificativo, c.notas, c.estado,c.irpf,c.causaretificativo,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  FROM compra c inner join proveedores p on(c.proveedor_id=p.id)  inner join empleados emp on(c.nifempleado=emp.nif) WHERE c.proveedor_id=?";
        
        List<compra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{id},new RowMapper<compra>(){
                   @Override
            public compra mapRow(ResultSet rs, int i) throws SQLException {
                compra p = new compra(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                proveedores pro=new proveedores();
                pro.setId(rs.getInt(3));
                pro.setNombre(rs.getString(4));
                pro.setPersona_contacto(rs.getString(5));
                p.setProveeedor_id(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setTipocuenta(rs.getString(10));
                p.setRetificativo(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausaretificativo(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                try{
                p.setTotal(rs.getDouble(19));
                p.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(p.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        p.setNifempleado(emp);
                        compraR gg=compraRDAO.porIdCompra(p.getNum());
                        if(gg.getId()!=0)
                        p.setImgfactura(1);
                        else p.setImgfactura(0);
                }catch(Exception ex){}
                return p;
            }
        });
        
        return e;
    }

    
    @Override
    public List<compra> findAll() {
        String sql="SELECT c.num, c.serie, c.proveedor_id,p.nombre,p.persona_contacto, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccion, c.tipocuenta,c.retificativo, c.notas, c.estado,c.irpf,c.causaretificativo,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  FROM compra c inner join proveedores p on(c.proveedor_id=p.id)  inner join empleados emp on(c.nifempleado=emp.nif) ";
        
        List<compra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<compra>(){
                   @Override
            public compra mapRow(ResultSet rs, int i) throws SQLException {
                compra p = new compra(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                proveedores pro=new proveedores();
                pro.setId(rs.getInt(3));
                pro.setNombre(rs.getString(4));
                pro.setPersona_contacto(rs.getString(5));
                p.setProveeedor_id(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setTipocuenta(rs.getString(10));
                p.setRetificativo(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausaretificativo(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                 try{
                p.setTotal(rs.getDouble(19));
                p.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(p.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        p.setNifempleado(emp);
                        compraR gg=compraRDAO.porIdCompra(p.getNum());
                        if(gg.getId()!=0)
                        p.setImgfactura(1);
                        else p.setImgfactura(0);
                }catch(Exception ex){}
                return p;
            }
        });
        
        return e;
    }
    @Override
    public List<compra> findAllEmpleado(String nif) {
        String sql="SELECT c.num, c.serie, c.proveedor_id,p.nombre,p.persona_contacto, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccion, c.tipocuenta,c.retificativo, c.notas, c.estado,c.irpf,c.causaretificativo,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  FROM compra c inner join proveedores p on(c.proveedor_id=p.id)  inner join empleados emp on(c.nifempleado=emp.nif) "+
                "where c.nifempleado=?";
        
        List<compra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<compra>(){
                   @Override
            public compra mapRow(ResultSet rs, int i) throws SQLException {
                compra p = new compra(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                proveedores pro=new proveedores();
                pro.setId(rs.getInt(3));
                pro.setNombre(rs.getString(4));
                pro.setPersona_contacto(rs.getString(5));
                p.setProveeedor_id(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setTipocuenta(rs.getString(10));
                p.setRetificativo(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausaretificativo(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                 try{
                p.setTotal(rs.getDouble(19));
                p.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(p.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        p.setNifempleado(emp);
                        compraR gg=compraRDAO.porIdCompra(p.getNum());
                        if(gg.getId()!=0)
                        p.setImgfactura(1);
                        else p.setImgfactura(0);
                }catch(Exception ex){}
                return p;
            }
        });
        
        return e;
    }

    @Override
    public List<compra> porFecha(String fechai, String fechaf) {
        String sql="SELECT c.num, c.serie, c.proveedor_id,p.nombre,p.persona_contacto, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccion, c.tipocuenta,c.retificativo, c.notas, c.estado,c.irpf,c.causaretificativo,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp  FROM compra c inner join proveedores p on(c.proveedor_id=p.id)  inner join empleados emp on(c.nifempleado=emp.nif)  "+
                "WHERE c.fecha BETWEEN ? AND ?";
        
        List<compra> e =this.getJdbcTemplate().query(sql, 
                new Object[]{fechai,fechaf},new RowMapper<compra>(){
                   @Override
            public compra mapRow(ResultSet rs, int i) throws SQLException {
                compra p = new compra(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                proveedores pro=new proveedores();
                pro.setId(rs.getInt(3));
                pro.setNombre(rs.getString(4));
                pro.setPersona_contacto(rs.getString(5));
                p.setProveeedor_id(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setTipocuenta(rs.getString(10));
                p.setRetificativo(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausaretificativo(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                p.setTotal(rs.getDouble(19));
                 try{
                p.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(p.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        p.setNifempleado(emp);
                        compraR gg=compraRDAO.porIdCompra(p.getNum());
                        if(gg.getId()!=0)
                        p.setImgfactura(1);
                        else p.setImgfactura(0);
                }catch(Exception ex){}
                return p;
            }
        });
        
        return e;
    }
    @Override
    public compra porId(int id) {
        String sql="SELECT c.num, c.serie, c.proveedor_id,p.nombre,p.persona_contacto, c.fecha, c.fechavencimiento, c.referencia,  "+
                "c.direccion, c.tipocuenta,c.retificativo, c.notas, c.estado,c.irpf,c.causaretificativo,c.baseimponible, c.ivatotal, "+
                "c.totalirpf, c.total,emp.nif,emp.nombre||', '||emp.apellidos as nombreemp FROM compra c inner join proveedores p on(c.proveedor_id=p.id)  inner join empleados emp on(c.nifempleado=emp.nif)  "+
                "WHERE c.num=?";
        
        compra e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<compra>(){
                   @Override
            public compra mapRow(ResultSet rs, int i) throws SQLException {
                compra p = new compra(); 
                p.setNum(rs.getInt(1));
                p.setSerie(rs.getString(2));
                
                proveedores pro=new proveedores();
                pro.setId(rs.getInt(3));
                pro.setNombre(rs.getString(4));
                pro.setPersona_contacto(rs.getString(5));
                p.setProveeedor_id(pro);
                
                p.setFecha(rs.getDate(6));
                p.setFechavencimiento(rs.getDate(7));
                p.setReferencia(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setTipocuenta(rs.getString(10));
                p.setRetificativo(rs.getBoolean(11));
                p.setNotas(rs.getString(12));
                p.setEstado(rs.getInt(13));
                p.setIrpf(rs.getDouble(14));
                p.setCausaretificativo(rs.getString(15));
                p.setBaseimponible(rs.getDouble(16));
                p.setIvatotal(rs.getDouble(17));
                p.setTotalirpf(rs.getDouble(18));
                
                p.setTotal(rs.getDouble(19));
                try{
                p.setNif(rs.getString("nif"));
                        empleados emp=new empleados();
                        emp.setNif(p.getNif());
                        emp.setNombre(rs.getString("nombreemp"));
                        p.setNifempleado(emp);
                        compraR gg=compraRDAO.porIdCompra(p.getNum());
                        if(gg.getId()!=0)
                        p.setImgfactura(1);
                        else p.setImgfactura(0);
                }catch(Exception ex){}
                return p;
            }
        });
        
        return e;
    }
    
    @Override
    public int ultimocompra() {
        String sql = "SELECT max(num) as c FROM compra";
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
    public boolean Insert(compra c) {
        String sql = "INSERT INTO compra(" +
                     "serie, proveedor_id, fecha, fechavencimiento, referencia, " +
                     "direccion, tipocuenta, retificativo, notas, estado, irpf, causaretificativo, baseimponible, ivatotal, totalirpf, total,nifempleado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getSerie(),c.getProveeedor_id().getId(),c.getFecha(),c.getFechavencimiento(),
                c.getReferencia(),c.getDireccion(),c.getTipocuenta(),c.getRetificativo(),c.getNotas(),c.getEstado(),c.getIrpf(),c.getCausaretificativo(),
                c.getBaseimponible(),c.getIvatotal(),c.getTotalirpf(),c.getTotal(),c.getNif()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean respu=false;
        if(cr>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            respu=true;
        }
        return respu;
    }
    @Override
    public boolean Update(compra c) {
        String sql = "UPDATE compra " +
                     "SET serie=?, proveedor_id=?, fecha=?, fechavencimiento=?, referencia=?, " +
                     "direccion=?, tipocuenta=?, retificativo=?, notas=?, estado=?, irpf=?, causaretificativo=?,"+
                     "baseimponible=?, ivatotal=?, totalirpf=?, total=? "+
                     "WHERE num=?";
        int cr=this.getJdbcTemplate().update(sql, new Object[]{c.getSerie(),c.getProveeedor_id().getId(),c.getFecha(),c.getFechavencimiento(),
                c.getReferencia(),c.getDireccion(),c.getTipocuenta(),c.getRetificativo(),c.getNotas(),c.getEstado(),c.getIrpf(),c.getCausaretificativo(),
                c.getBaseimponible(),c.getIvatotal(),c.getTotalirpf(),c.getTotal(),c.getNum()});
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
        String sql = "DELETE FROM compra WHERE num=?";
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
        String sql = "UPDATE compra SET estado=1 WHERE num=?";
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
        String sql = "UPDATE compra SET estado=0 WHERE num=?";
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
