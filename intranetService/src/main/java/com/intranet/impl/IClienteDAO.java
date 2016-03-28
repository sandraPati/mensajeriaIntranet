/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.beans.clientes;
import com.intranet.dao.ClienteDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("clienteDAO")
public class IClienteDAO extends UtilTemplateDAO implements ClienteDAO{

    @Override
    public List<clientes> findAll(String buscar) {
        String sql = "SELECT nif, nombre, apellidos, direccion, pais, codigo_postal, provincia, " +
        "telefono, otro_telefono, email, poblacion, nacionalidad,usuario " +
        "FROM clientes where nif like '%"+buscar+"%' or nombre like '%"+buscar+"%' or apellidos like '%"+buscar+"%'";
        List<clientes> e =this.getJdbcTemplate().query(sql, 
                new Object[]{}, new RowMapper<clientes>(){
        @Override
            public clientes mapRow(ResultSet rs, int i) throws SQLException {
                clientes e = new clientes();
            e.setNif(rs.getString("nif"));
            e.setNombre(rs.getString("nombre"));
            e.setApellidos(rs.getString("apellidos"));
            e.setDireccion(rs.getString("direccion"));
            e.setPais(rs.getString("pais"));
            e.setCodigo_postal(rs.getString("codigo_postal"));
            e.setProvincia(rs.getString("provincia"));
            e.setTelefono(rs.getString("telefono"));
            e.setOtro_telefono(rs.getString("otro_telefono"));
            e.setEmail(rs.getString("email"));
            e.setPoblacion(rs.getString("poblacion"));
            e.setNacionalidad(rs.getString("nacionalidad"));
            e.setUsuario(rs.getString("usuario"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public boolean validaNIF(String nif) {
        String sql = "SELECT  count(*) as cuenta FROM users where nif=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("cuenta");
                return t;
        }
        });
    }
    
    
    
    @Override
    public clientes ByNif(String nif) {
        String sql = "SELECT nif, nombre, apellidos, direccion, pais, codigo_postal, provincia, " +
        "telefono, otro_telefono, email, poblacion, nacionalidad, usuario " +
        "FROM clientes where nif=?";
        clientes e =(clientes)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif}, new RowMapper<clientes>(){
        @Override
            public clientes mapRow(ResultSet rs, int i) throws SQLException {
                clientes e = new clientes();
            e.setNif(rs.getString("nif"));
            e.setNombre(rs.getString("nombre"));
            e.setApellidos(rs.getString("apellidos"));
            e.setDireccion(rs.getString("direccion"));
            e.setPais(rs.getString("pais"));
            e.setCodigo_postal(rs.getString("codigo_postal"));
            e.setProvincia(rs.getString("provincia"));
            e.setTelefono(rs.getString("telefono"));
            e.setOtro_telefono(rs.getString("otro_telefono"));
            e.setEmail(rs.getString("email"));
            e.setPoblacion(rs.getString("poblacion"));
            e.setNacionalidad(rs.getString("nacionalidad"));
            e.setUsuario(rs.getString("usuario"));
            return e;
        }
        });
        
        return e;
    }

    @Override
    public String updateLogeo(clientes emp) {
        String sql = "UPDATE clientes " +
                     "SET usuario=?, contrasenna=? " +
                     "WHERE nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getUsuario(),emp.getContrsenna(),emp.getNif()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Insert(clientes emp) {
        String sql = "INSERT INTO clientes(" +
                     "nif, nombre, apellidos, direccion, pais, codigo_postal, provincia," +
                     "telefono, otro_telefono, email,poblacion, nacionalidad,fecharegistro) " +
                     "VALUES (?,upper(?),upper(?),upper(?),upper(?), ?, upper(?),?,?,?,upper(?),upper(?),current_date)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNif(),emp.getNombre(),emp.getApellidos(),emp.getDireccion(),emp.getPais(),emp.getCodigo_postal(),
                      emp.getProvincia(),emp.getTelefono(),emp.getOtro_telefono(),emp.getEmail(),emp.getPoblacion(),emp.getNacionalidad()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(clientes emp) {
        String sql = "UPDATE clientes " +
                     "SET nombre=upper(?), apellidos=upper(?), direccion=upper(?), pais=upper(?), codigo_postal=?, provincia=upper(?), " +
                     "telefono=?, otro_telefono=?, email=?, poblacion=upper(?), nacionalidad=upper(?) " +
                     "WHERE nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombre(),emp.getApellidos(),emp.getDireccion(),emp.getPais(),emp.getCodigo_postal(),
                      emp.getProvincia(),emp.getTelefono(),emp.getOtro_telefono(),emp.getEmail(),emp.getPoblacion(),emp.getNacionalidad(),emp.getNif()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(String nif) {
        String sql = "DELETE FROM clientes WHERE nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            clientes e = new clientes();
            e.setNif(rs.getString("nif"));
            e.setNombre(rs.getString("nombre"));
            e.setApellidos(rs.getString("apellidos"));
            e.setDireccion(rs.getString("direccion"));
            e.setPais(rs.getString("pais"));
            e.setCodigo_postal(rs.getString("codigo_postal"));
            e.setProvincia(rs.getString("provincia"));
            e.setTelefono(rs.getString("telefono"));
            e.setOtro_telefono(rs.getString("otro_telefono"));
            e.setEmail(rs.getString("email"));
            e.setPoblacion(rs.getString("poblacion"));
            e.setNacionalidad(rs.getString("nacionalidad"));
            e.setUsuario(rs.getString("usuario"));
             
            return e;
        }
    }
}
