/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.empleados;
import com.intranet.beans.mensajeg;
import com.intranet.beans.mensajep;
import com.intranet.beans.relacion_mensajes;
import com.intranet.dao.MensajeriaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mensajeriaDAO")
public class IMensajeriaDAO extends UtilTemplateDAO implements MensajeriaDAO{

    public int cantidadEmp() {
        String sql = "select count(e.nif) from empleados e where e.sesion=true and estadoaltabaja=1";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e =rs.getInt(1);
                
                return e;
        }
        });
        
        return est;
    }
    public empleados usuario(String nif) {
        String sql = "select e.nif,e.nombre,e.apellidos,e.email,e.nombrefotografia,e.sesion from empleados e WHERE e.nif=?";
        empleados est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados e = new empleados();
                e.setNif(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setApellidos(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setNombrefotografia(rs.getString(5));
                if(rs.getBoolean(6)==true){
                    e.setInicioS(1);
                }else e.setInicioS(0);
                return e;
        }
        });
        
        return est;
    }
    public List<empleados> ltaEmpleados(String nif) {
        String sql = "select e.nif,e.nombre||', '||e.apellidos as nombre,e.apellidos,e.email,e.nombrefotografia,e.sesion from empleados e where e.estadoaltabaja=1 and e.nif!=?";
        List<empleados> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados e = new empleados();
                e.setNif(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setApellidos(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setNombrefotografia(rs.getString(5));
                if(rs.getBoolean(6)==true){
                    e.setInicioS(1);
                }else e.setInicioS(0);
                return e;
        }
        });
        
        return est;
    }

    public List<mensajep> mensajePrivadoUsu(String nif_empleado, String nif_amigo) {
        String sql = "SELECT * FROM(SELECT * FROM((SELECT m.id,m.nif_receptor,m.asunto,m.nif_emisor,m.fecha,m.hora as hora,e.nombrefotografia,e.nombre||', '||e.apellidos as nombre "+
                    "FROM mensajep m inner join empleados e on (m.nif_emisor=e.nif) "+
                    "where m.nif_emisor=? and m.nif_receptor=? and m.fecha=current_date) union"+
                    "(SELECT m.id,m.nif_receptor,m.asunto,m.nif_emisor,m.fecha,m.hora as hora,e.nombrefotografia,e.nombre||', '||e.apellidos as nombre "+
                    "FROM mensajep m inner join empleados e on (m.nif_emisor=e.nif) where m.nif_emisor=? and m.nif_receptor=? and m.fecha=current_date) )s ORDER BY  hora desc LIMIT 6)d  ORDER BY  hora asc LIMIT 6";
        List<mensajep> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif_empleado,nif_amigo,nif_amigo,nif_empleado},new RowMapper<mensajep>(){
        @Override
            public mensajep mapRow(ResultSet rs, int i) throws SQLException {
                mensajep e = new mensajep();
                e.setId(rs.getInt(1));
                e.setNifReceptor(rs.getString(2));
                e.setAsunto(rs.getString(3));
                e.setNifEmisor(rs.getString(4));
                e.setFecha(rs.getDate(5));
                e.setHora(rs.getTime(6));
                e.setNombrefotografia(rs.getString(7));
                e.setNombreEmisor(rs.getString(8));
                return e;
        }
        });
        
        return est;
    }

    public boolean enviarMensaje(mensajep men) {
        String sql = "insert into mensajep(nif_receptor,asunto,nif_emisor,fecha,hora) values(?,?,?,current_date,current_time)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{men.getNifReceptor(),men.getAsunto(),men.getNifEmisor()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            r=true;
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return r;
    }

    public boolean crearGrupo(mensajeg m, List<empleados> empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<mensajeg> ListaMensajesGrupo(String nif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<relacion_mensajes> MensajesaGrupo(int id_mgrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean enviarMensajeaGrupo(relacion_mensajes mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<empleados> amigosPorGrupo(int id_mgrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
