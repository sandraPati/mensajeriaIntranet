/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.propuesta;
import com.intranet.dao.ClienteDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.PlantillaPresupuestoDAO;
import com.intranet.dao.PresupuestoCDAO;
import com.intranet.dao.PropuestaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("propuestaDAO")
public class IPropuestaDAO extends UtilTemplateDAO implements PropuestaDAO{

    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    ClienteDAO clienteDAO;
    @Autowired(required = true)
    PlantillaPresupuestoDAO plantillaPresupuestoDAO;
    @Autowired(required = true)
    PresupuestoCDAO presupuestoCDAO;
    
    @Override
    public List<propuesta> findAll(String buscar) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) ";
        
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<propuesta> findAllE(String buscar) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE p.empleado_nif=?";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{buscar},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<propuesta> filtroC(String nifC) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE p.cliente_nif=? and p.estado!=2";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifC},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<propuesta> filtroCProy(String nifC) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE p.cliente_nif=? and p.estado=2";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifC},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    
    @Override
    public List<propuesta> filtroCE(String nifE, String nifC) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedorp.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE empleado_nif=? and cliente_nif=? and p.estado!=2";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifE,nifC},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<propuesta> filtroCEProy(String nifE, String nifC) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE empleado_nif=? and cliente_nif=? and p.estado=2";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifE,nifC},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public List<propuesta> filtroE(String nifE) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE empleado_nif=? ";
        List<propuesta> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifE},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public propuesta porId(int id) {
        String sql = "SELECT p.id,p.empleado_nif,p.dia,p.hora,p.cliente_nif,p.direccion,p.pais, "+
        "p.codigo_postal,p.provincia,p.poblacion,p.nacionalidad,p.descripcion,p.estado, "+
        "e.nombre as empnombre,e.apellidos as empapellidos,c.nombre as clinombre,c.apellidos as cliapellidos,p.descuentoproveedor,p.tipopropuesta "+
        "FROM propuesta p inner join empleados e on(p.empleado_nif=e.nif) inner join clientes c on(p.cliente_nif=c.nif) "+
        "WHERE id=? ";
        propuesta est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                //String nifE=rs.getString("empleado_nif");
                //String nifC=rs.getString("cliente_nif");
                try {
                    empleados emp=new empleados();
                    emp.setNif(rs.getString("empleado_nif"));
                    emp.setNombre(rs.getString("empnombre"));
                    emp.setApellidos(rs.getString("empapellidos"));
                    
                    clientes cli=new clientes();
                    cli.setNif(rs.getString("cliente_nif"));
                    cli.setNombre(rs.getString("clinombre"));
                    cli.setApellidos(rs.getString("cliapellidos"));
                    
                    e.setEmpleado_nif(emp);
                    e.setCliente_nif(cli);
                    
                    e.setPlantilla(plantillaPresupuestoDAO.existe(e.getId()));
                    boolean res=presupuestoCDAO.presupPropuesta(e.getId());
                    if(res==true) e.setTienePresupuesto(1);
                    if(e.getPlantilla()>0)e.setObjplantilla(plantillaPresupuestoDAO.porIDP(e.getId()));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setDia(rs.getDate(3));
	               e.setHora(rs.getString(4));
	               e.setDireccion(rs.getString(6));
	               e.setPais(rs.getString(7));
	               e.setCodigo_postal(rs.getString(8));
	               e.setProvincia(rs.getString(9));
	               e.setPoblacion(rs.getString(10));
	               e.setNacionalidad(rs.getString(11));
	               e.setDescipcion(rs.getString(12));
	               e.setEstado(rs.getInt(13));
                       e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                       e.setTipopropuesta(rs.getInt("tipopropuesta"));
                return e;
        }
        });
        
        return est;
    }

    
    @Override
    public propuesta porIdDescuento(int id) {
        String sql = "SELECT p.id,p.descuentoproveedor "+
        "FROM propuesta p "+
        "WHERE p.id=? ";
        propuesta est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<propuesta>(){
        @Override
            public propuesta mapRow(ResultSet rs, int i) throws SQLException {
                propuesta e = new propuesta();
                e.setId(rs.getInt(1));
                e.setDescuentoproveedor(rs.getFloat("descuentoproveedor"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public int porIdNifCEmpleado(String nifC,String empl) {
        String sql = "select max(id)as c from propuesta where empleado_nif=? and cliente_nif=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{empl,nifC},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public Integer porFechaEmpleadoCliente(propuesta p) {
        String sql = "select max(id) from propuesta where dia=current_date and empleado_nif=? "+
		"and cliente_nif=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getEmpleado_nif().getNif(),p.getCliente_nif().getNif()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public String Insert(propuesta pro) {
        String sql = "INSERT INTO propuesta("+
		"empleado_nif,  cliente_nif, direccion, pais, provincia,poblacion,descripcion,tipopropuesta,estado,dia, hora) "+
		"VALUES (?,  ?, upper(?), upper(?), upper(?),upper(?),upper(?),?,1,current_date, to_char(current_timestamp, 'HH12:MI:SS')) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pro.getEmpleado_nif().getNif(), pro.getCliente_nif().getNif(), pro.getDireccion(),
            pro.getPais(), pro.getProvincia(), pro.getPoblacion(), pro.getDescipcion(),pro.getTipopropuesta()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String InsertPaso(propuesta pro) {
        String sql = "INSERT INTO propuesta("+
		"empleado_nif,  cliente_nif, direccion, pais, provincia,poblacion,descripcion,tipopropuesta,estado,dia, hora) "+
		"VALUES (?,  ?, upper(?), upper(?), upper(?),upper(?),upper(?),?,1,current_date, to_char(current_timestamp, 'HH12:MI:SS')) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pro.getEmpleado_nif().getNif(), pro.getNifCliente(), pro.getDireccion(),
            pro.getPais(), pro.getProvincia(), pro.getPoblacion(), pro.getDescipcion(),pro.getTipopropuesta()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String Update(propuesta pro) {
        String sql = "UPDATE propuesta "+
		"SET direccion=upper(?), pais=upper(?),  "+
		" provincia=upper(?), poblacion=upper(?), descripcion=upper(?) "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pro.getDireccion(),
            pro.getPais(), pro.getProvincia(), pro.getPoblacion(),pro.getDescipcion(),pro.getId()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateC(propuesta pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateDescuento(propuesta pro) {
        String sql = "UPDATE propuesta "+
		"SET descuentoproveedor=? "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pro.getDescuentoproveedor(),pro.getId()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            return true;
        }
        return false;
    }
    
    @Override
    public String Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contrataraProyecto(propuesta pro) {
        String sql = "UPDATE propuesta "+
		"SET estado=2,fechaproyecto=current_date "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pro.getId()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
    
     @Override
    public int rechazar(int id) {
        String sql = "UPDATE propuesta "+
		"SET estado=3,fechaproyecto=current_date  "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
    @Override
    public int activar(int id) {
        String sql = "UPDATE propuesta "+
		"SET estado=4,fechaproyecto=current_date  "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
}
