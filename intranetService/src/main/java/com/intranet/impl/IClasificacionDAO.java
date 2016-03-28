/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.clasificaciones;
import com.intranet.beans.empleados;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipo_actividades;
import com.intranet.dao.ClasificacionDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.ProveedorDAO;
import com.intranet.dao.TipoActividadDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("clasificacionDAO")
public class IClasificacionDAO extends UtilTemplateDAO implements ClasificacionDAO{

    @Autowired(required = true)
    TipoActividadDAO tipoActividadDAO;
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    ProveedorDAO proveedorDAO;
    
    @Override
    public List<proveedores> lista(String buscar) {
        String sql = "SELECT * FROM ((select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,"+
			"p.telefono,p.link, sum(c.calificacion)as calificado,latitud,longitud,p.id,p.cif,p.aprobado "+
			"from proveedores p INNER JOIN clasificaciones c on(p.id=c.proveedor_id) "+
			"group by p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,p.latitud,p.longitud,p.id,p.cif,p.aprobado "+
			"order by sum(c.calificacion)desc) "+
			"union "+
			"(select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,0 as calificado,latitud,longitud,p.id,p.cif,p.aprobado "+
			"from proveedores  p "+
			"where p.estadocalificado=false "+
			"))s ORDER BY calificado DESC ";
        List<proveedores> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<proveedores>(){
        @Override
            public proveedores mapRow(ResultSet rs, int i) throws SQLException {
                proveedores p = new proveedores();
                p.setNum_cuenta(rs.getString(1));
		p.setNombre(rs.getString(2));
		p.setNombreFoto(rs.getString(3));
		p.setDireccion(rs.getString(4));
                int idC=rs.getInt("id_actividad");
                
                try {
                    tipo_actividades cu=tipoActividadDAO.porId(idC);
                    p.setId_actividad(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
		p.setEmail(rs.getString(6));
		p.setTelefono(rs.getString(7));
		p.setLink(rs.getString(8));
		p.setCantCalificacion(rs.getInt(9));
		p.setLatitud(rs.getDouble(10));
		p.setLongitud(rs.getDouble(11));
		p.setLat(rs.getDouble(10));
		p.setLongt(rs.getDouble(11));
                p.setId(rs.getInt(12));
                p.setCif(rs.getString(13));
                p.setAprobado(rs.getBoolean(14));
               
                return p;
        }
        });
        
        return e;
    }
    
    @Override
    public List<proveedores> listavisible(String buscar) {
        String sql = "SELECT * FROM ((select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,"+
			"p.telefono,p.link, sum(c.calificacion)as calificado,latitud,longitud,p.id,p.cif,p.aprobado,p.visible "+
			"from proveedores p INNER JOIN clasificaciones c on(p.id=c.proveedor_id) where p.visible=true "+
			"group by p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,p.latitud,p.longitud,p.id,p.cif,p.aprobado,p.visible "+
			"order by sum(c.calificacion)desc) "+
			"union "+
			"(select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,0 as calificado,latitud,longitud,p.id,p.cif,p.aprobado,p.visible "+
			"from proveedores  p "+
			"where p.estadocalificado=false and p.visible=true "+
			"))s ORDER BY calificado DESC ";
        List<proveedores> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<proveedores>(){
        @Override
            public proveedores mapRow(ResultSet rs, int i) throws SQLException {
                proveedores p = new proveedores();
                p.setNum_cuenta(rs.getString(1));
		p.setNombre(rs.getString(2));
		p.setNombreFoto(rs.getString(3));
		p.setDireccion(rs.getString(4));
                int idC=rs.getInt("id_actividad");
                
                try {
                    tipo_actividades cu=tipoActividadDAO.porId(idC);
                    p.setId_actividad(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
		p.setEmail(rs.getString(6));
		p.setTelefono(rs.getString(7));
		p.setLink(rs.getString(8));
		p.setCantCalificacion(rs.getInt(9));
		p.setLatitud(rs.getDouble(10));
		p.setLongitud(rs.getDouble(11));
		p.setLat(rs.getDouble(10));
		p.setLongt(rs.getDouble(11));
                p.setId(rs.getInt(12));
                p.setCif(rs.getString(13));
                p.setAprobado(rs.getBoolean(14));
                return p;
        }
        });
        
        return e;
    }
    @Override
    public List<proveedores> listavisibleB(int id) {
        String sql = "SELECT * FROM ((select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,"+
			"p.telefono,p.link, sum(c.calificacion)as calificado,latitud,longitud,p.id,p.cif,p.aprobado,p.visible "+
			"from proveedores p INNER JOIN clasificaciones c on(p.id=c.proveedor_id) where p.id=? and p.visible=true "+
			"group by p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,p.latitud,p.longitud,p.id,p.cif,p.aprobado,p.visible "+
			"order by sum(c.calificacion)desc) "+
			"union "+
			"(select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,0 as calificado,latitud,longitud,p.id,p.cif,p.aprobado,p.visible "+
			"from proveedores  p "+
			"where p.id=? and p.estadocalificado=false and p.visible=true "+
			"))s ORDER BY calificado DESC ";
        List<proveedores> e =this.getJdbcTemplate().query(sql, 
                new Object[]{id,id},new RowMapper<proveedores>(){
        @Override
            public proveedores mapRow(ResultSet rs, int i) throws SQLException {
                proveedores p = new proveedores();
                p.setNum_cuenta(rs.getString(1));
		p.setNombre(rs.getString(2));
		p.setNombreFoto(rs.getString(3));
		p.setDireccion(rs.getString(4));
                int idC=rs.getInt("id_actividad");
                
                try {
                    tipo_actividades cu=tipoActividadDAO.porId(idC);
                    p.setId_actividad(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
		p.setEmail(rs.getString(6));
		p.setTelefono(rs.getString(7));
		p.setLink(rs.getString(8));
		p.setCantCalificacion(rs.getInt(9));
		p.setLatitud(rs.getDouble(10));
		p.setLongitud(rs.getDouble(11));
		p.setLat(rs.getDouble(10));
		p.setLongt(rs.getDouble(11));
                p.setId(rs.getInt(12));
                p.setCif(rs.getString(13));
                p.setAprobado(rs.getBoolean(14));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public List<proveedores> filtar(int buscar) {
        String sql = "SELECT * FROM ((select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,"+
			"p.telefono,p.link, sum(c.calificacion)as calificado ,p.latitud,p.longitud,p.id "+
			"from proveedores p INNER JOIN clasificaciones c on(p.id=c.proveedor_id) "+
			"where p.id_actividad=? "+
			"group by p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link ,p.latitud,p.longitud,p.id "+
			"order by sum(c.calificacion)desc) "+
			"union "+
			"(select p.num_cuenta,p.nombre,p.nombrefoto,p.direccion,p.id_actividad,p.email,p.telefono,p.link,0 as calificado ,p.latitud,p.longitud,p.id "+
			"from proveedores  p "+
			"where p.estadocalificado=false and p.id_actividad=? "+
			"))s ORDER BY calificado DESC";
        List<proveedores> e =this.getJdbcTemplate().query(sql, 
                new Object[]{buscar,buscar},new RowMapper<proveedores>(){
        @Override
            public proveedores mapRow(ResultSet rs, int i) throws SQLException {
                proveedores p = new proveedores();
                p.setNum_cuenta(rs.getString(1));
		p.setNombre(rs.getString(2));
		p.setNombreFoto(rs.getString(3));
		p.setDireccion(rs.getString(4));
                int idC=rs.getInt("id_actividad");
                
                try {
                    tipo_actividades cu=tipoActividadDAO.porId(idC);
                    p.setId_actividad(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
		p.setEmail(rs.getString(6));
		p.setTelefono(rs.getString(7));
		p.setLink(rs.getString(8));
		p.setCantCalificacion(rs.getInt(9));
		p.setLatitud(rs.getDouble(10));
		p.setLongitud(rs.getDouble(11));
		p.setLat(rs.getDouble(10));
		p.setLongt(rs.getDouble(11));
                p.setId(rs.getInt(12));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public List<clasificaciones> AllcalificacionProveedor(int id) {
        String sql = "select id,empleado_nif, proveedor_id, calificacion, comentario ,calidadtrabajo,limpiezaorden, plazos, cumplimiento "+
			"from clasificaciones c "+
			"where c.proveedor_id=? ORDER BY calificacion DESC";
        List<clasificaciones> e =this.getJdbcTemplate().query(sql, 
                new Object[]{id},new RowMapper<clasificaciones>(){
        @Override
            public clasificaciones mapRow(ResultSet rs, int i) throws SQLException {
                clasificaciones p = new clasificaciones();
                p.setId(rs.getInt(1));
                String idE=rs.getString("empleado_nif");
                int idP=rs.getInt("proveedor_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idE);
                    p.setEmpleado_nif(cu);
                    proveedores prov=proveedorDAO.porId(idP);
                    p.setProveedor_numcuenta(prov);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
		p.setCalificacion(rs.getInt(4));
		p.setComentario(rs.getString(5));
                p.setCalidadtrabajo(rs.getInt(6));
                p.setLimpiezaorden(rs.getInt(7));
                p.setPlazos(rs.getInt(8));
                p.setCumplimiento(rs.getInt(9));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public clasificaciones calificacionProveedorEmpleado(int id, String nif) {
        String sql = "select id,empleado_nif, proveedor_id, calificacion, "
                + "comentario,calidadtrabajo,limpiezaorden,plazos,cumplimiento from clasificaciones where proveedor_id=? and empleado_nif=?";
        clasificaciones e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id,nif},new RowMapper<clasificaciones>(){
        @Override
            public clasificaciones mapRow(ResultSet rs, int i) throws SQLException {
                clasificaciones p = new clasificaciones();
                p.setId(rs.getInt(1));
                String idE=rs.getString("empleado_nif");
                int idP=rs.getInt("proveedor_id");
                try {
                    if(idE!=null && idE!=""){
                        empleados cu=empleadoDAO.ByNif(idE);
                        p.setEmpleado_nif(cu);
                    }
                    if(idP!=0){
                        proveedores prov=proveedorDAO.porId(idP);
                        p.setProveedor_numcuenta(prov);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
		p.setCalificacion(rs.getInt(4));
		p.setComentario(rs.getString(5));
                p.setCalidadtrabajo(rs.getInt(6));
                p.setLimpiezaorden(rs.getInt(7));
                p.setPlazos(rs.getInt(8));
                p.setCumplimiento(rs.getInt(9));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public String insertar(clasificaciones p) {
        String sql = "UPDATE proveedores SET estadocalificado=true  WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getProveedor_numcuenta().getId()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        String sql2 = "INSERT INTO clasificaciones("+
            "empleado_nif, proveedor_id, calificacion, comentario,calidadtrabajo,limpiezaorden,plazos,cumplimiento) "+
            "VALUES (?, ?,?, ?,?,?,?,?)";
        int c2=this.getJdbcTemplate().update(sql2, new Object[]{p.getEmpleado_nif().getNif(),p.getProveedor_numcuenta().getId(),
        p.getCalificacion(),p.getComentario(),p.getCalidadtrabajo(),p.getLimpiezaorden(),p.getPlazos(),p.getCumplimiento()});
        String rpta2="ERROR!... No se pudo INSERTAR el Registro";
        if(c2>0){
            rpta2="Se INSERTO Satisfactoriamente...!";
        }
        return rpta2;
    }
    
    @Override
    public String update(clasificaciones p) {
        String sql = "UPDATE clasificaciones "+
            "SET calificacion=?, comentario=?,calidadtrabajo=?,limpiezaorden=?,plazos=?,cumplimiento=? "+
            "WHERE empleado_nif=? and proveedor_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getCalificacion(),p.getComentario(),p.getCalidadtrabajo(),p.getLimpiezaorden(),
            p.getPlazos(),p.getCumplimiento(),
        p.getEmpleado_nif().getNif(),p.getProveedor_numcuenta().getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public boolean existencia(int id, String nif) {
        String sql = "select count(*)as c from clasificaciones where proveedor_id=? and empleado_nif=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id,nif},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }
    
}
