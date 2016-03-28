/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.Roles;
import com.intranet.beans.empleados;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.perfiles;
import com.intranet.beans.reporteNomina;
import com.intranet.dao.PerfilDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.OficioDAO;
import com.intranet.dao.PerfilProfesionalDAO;
import com.intranet.dao.RolesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("empleadoDAO")
public class IEmpleadoDAO extends UtilTemplateDAO implements EmpleadoDAO{

    byte[] imgBytes = null;
    byte[] imgBytesCV = null;
    
    @Autowired(required = true)
    PerfilDAO perfilDAO;
    @Autowired(required = true)
    PerfilProfesionalDAO perfilProfesionalDAO;
    @Autowired(required = true)
    OficioDAO oficioDAO;
    @Autowired(required = true)
    private RolesDAO rolesDAO;
    
    @Override
    public List<empleados> findAll(String buscar) {
        String sql = "SELECT e.nif,e.nombre,e.apellidos,e.fecha_nacimiento,e.direccion,e.pais,e.provincia,e.codigo_postal,e.estado,e.telefono, e.otro_telefono,e.email,e.otro_email,e.numero_seguridad_social,e.doba,e.fecha_alta,e.observaciones,e.usuario,e.contrasenna,e.id_perfil,e.poblacion,e.numero_afiliacionss,e.nivel_formativo, " +
                "e.nacionalidad, e.nombrefotografia, e.perfil_profesional, " +
                "e.oficio, e.permiso_conducir, e.vehiculo_propio, e.autonomo, e.presencia, " +
                "e.nombre_presencia, e.nombrecv, e.tamano_foto, e.genero,e.otro_perfil_profesional,e.estadoaltabaja,pp.nombre as nombrepp " +
                " FROM empleados e inner join perfilprofesional pp on(e.perfil_profesional=pp.id)";
        List<empleados> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados eee = new empleados();
                eee.setNif(rs.getString("nif"));
	               eee.setNombre(rs.getString("nombre"));
	               eee.setApellidos(rs.getString("apellidos"));
	               eee.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
	               eee.setDireccion(rs.getString("direccion"));
	               eee.setPais(rs.getString("pais"));
	               eee.setProvincia(rs.getString("provincia"));
	               eee.setCodigo_postal(rs.getString("codigo_postal"));
	               eee.setEstado(rs.getString("estado"));
	               eee.setTelefono(rs.getString("telefono"));
	               if(rs.getString("otro_telefono")==null)eee.setOtro_telefono("-");
	               else eee.setOtro_telefono(rs.getString("otro_telefono"));
	               
	               eee.setEmail(rs.getString("email"));
	               if(rs.getString("otro_email")==null)eee.setOtro_email("-");
	               else eee.setOtro_email(rs.getString("otro_email"));
	               eee.setNumero_seguridad_social(rs.getString("numero_seguridad_social"));
	               eee.setDoba(rs.getString("doba"));
	               eee.setFecha_alta(rs.getDate("fecha_alta"));
	               eee.setObservacion(rs.getString("observaciones"));
	               eee.setUsuario(rs.getString("usuario"));
	               eee.setContrasenna(rs.getString("contrasenna"));
	               
                       eee.setPoblacion(rs.getString("poblacion"));
	               eee.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
	               eee.setNivel_formativo(rs.getString("nivel_formativo"));
	               
	               eee.setNacionalidad(rs.getString("nacionalidad"));
	               eee.setNombrefotografia(rs.getString("nombrefotografia"));
	               
                       int idP=rs.getInt("id_perfil");
                       int idPP=rs.getInt("perfil_profesional");
                       int idO=rs.getInt("oficio");
                        try {
                            if(idP!=0){
                                perfiles cu=perfilDAO.ById(idP);
                                eee.setId_perfil(cu);
                            }
                            if(idPP!=0){
                                perfil_profesional perfp=new perfil_profesional();
                                perfp.setId(idPP);
                                perfp.setNombre(rs.getString("nombrepp"));
                                eee.setPerfilprof(perfp);
                            }
                            if(idO!=0){
                                oficios of=oficioDAO.porId(idO);
                                eee.setOficio(of);
                            }
                            
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               eee.setPermiso_conducir(rs.getString("permiso_conducir"));
	               eee.setVehiculo_propio(rs.getString("vehiculo_propio"));
	               eee.setAutonomo(rs.getString("autonomo"));
	               eee.setPresencia(rs.getString("presencia"));
	               eee.setNombrepresencia(rs.getString("nombre_presencia"));
	               eee.setNombrecv(rs.getString("nombrecv"));
	               eee.setTamanofoto(rs.getString("tamano_foto"));
	               eee.setGenero(rs.getString("genero"));
                       eee.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                       eee.setEstadoaltabaja(rs.getInt("estadoaltabaja"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public List<empleados> ListaSupervisores(String buscar) {
        String sql = "SELECT nif,nombre,apellidos,fecha_nacimiento,direccion,pais,provincia,codigo_postal,estado,telefono, otro_telefono,email,otro_email,numero_seguridad_social,doba,fecha_alta,observaciones,usuario,contrasenna,id_perfil,poblacion,numero_afiliacionss,nivel_formativo, " +
                "nacionalidad, nombrefotografia, perfil_profesional, " +
                "oficio, permiso_conducir, vehiculo_propio, autonomo, presencia, " +
                "nombre_presencia, nombrecv, tamano_foto, genero,otro_perfil_profesional,estadoaltabaja " +
                " FROM empleados where id_perfil=1";
        List<empleados> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados eee = new empleados();
                eee.setNif(rs.getString("nif"));
	               eee.setNombre(rs.getString("nombre"));
	               eee.setApellidos(rs.getString("apellidos"));
	               eee.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
	               eee.setDireccion(rs.getString("direccion"));
	               eee.setPais(rs.getString("pais"));
	               eee.setProvincia(rs.getString("provincia"));
	               eee.setCodigo_postal(rs.getString("codigo_postal"));
	               eee.setEstado(rs.getString("estado"));
	               eee.setTelefono(rs.getString("telefono"));
	               if(rs.getString("otro_telefono")==null)eee.setOtro_telefono("-");
	               else eee.setOtro_telefono(rs.getString("otro_telefono"));
	               
	               eee.setEmail(rs.getString("email"));
	               if(rs.getString("otro_email")==null)eee.setOtro_email("-");
	               else eee.setOtro_email(rs.getString("otro_email"));
	               eee.setNumero_seguridad_social(rs.getString("numero_seguridad_social"));
	               eee.setDoba(rs.getString("doba"));
	               eee.setFecha_alta(rs.getDate("fecha_alta"));
	               eee.setObservacion(rs.getString("observaciones"));
	               eee.setUsuario(rs.getString("usuario"));
	               eee.setContrasenna(rs.getString("contrasenna"));
	               
                       eee.setPoblacion(rs.getString("poblacion"));
	               eee.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
	               eee.setNivel_formativo(rs.getString("nivel_formativo"));
	               
	               eee.setNacionalidad(rs.getString("nacionalidad"));
	               eee.setNombrefotografia(rs.getString("nombrefotografia"));
	               
                       int idP=rs.getInt("id_perfil");
                       int idPP=rs.getInt("perfil_profesional");
                       int idO=rs.getInt("oficio");
                        try {
                            if(idP!=0){
                                perfiles cu=perfilDAO.ById(idP);
                                eee.setId_perfil(cu);
                            }
                            if(idPP!=0){
                                perfil_profesional perfp=perfilProfesionalDAO.porId(idPP);
                                eee.setPerfilprof(perfp);
                            }
                            if(idO!=0){
                                oficios of=oficioDAO.porId(idO);
                                eee.setOficio(of);
                            }
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               eee.setPermiso_conducir(rs.getString("permiso_conducir"));
	               eee.setVehiculo_propio(rs.getString("vehiculo_propio"));
	               eee.setAutonomo(rs.getString("autonomo"));
	               eee.setPresencia(rs.getString("presencia"));
	               eee.setNombrepresencia(rs.getString("nombre_presencia"));
	               eee.setNombrecv(rs.getString("nombrecv"));
	               eee.setTamanofoto(rs.getString("tamano_foto"));
	               eee.setGenero(rs.getString("genero"));
                       eee.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                       eee.setEstadoaltabaja(rs.getInt("estadoaltabaja"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public empleados ByNif(String nif) {
        System.out.println("el nif enviado por NIF: "+nif);
        String sql = "SELECT nif,nombre,apellidos,fecha_nacimiento,direccion,pais,provincia,codigo_postal,estado,telefono, otro_telefono,email,otro_email,numero_seguridad_social,doba,fecha_alta,observaciones,id_perfil,poblacion,numero_afiliacionss,nivel_formativo, " +
                "nacionalidad, nombrefotografia, perfil_profesional, " +
                "oficio, permiso_conducir, vehiculo_propio, autonomo, presencia, " +
                "nombre_presencia, nombrecv, tamano_foto, genero,otro_perfil_profesional,estadoaltabaja " +
                " FROM empleados where nif=?";
        empleados e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados eee = new empleados();
               eee.setNif(rs.getString("nif"));
	               eee.setNombre(rs.getString("nombre"));
	               eee.setApellidos(rs.getString("apellidos"));
	               eee.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
	               eee.setDireccion(rs.getString("direccion"));
	               eee.setPais(rs.getString("pais"));
	               eee.setProvincia(rs.getString("provincia"));
	               eee.setCodigo_postal(rs.getString("codigo_postal"));
	               eee.setEstado(rs.getString("estado"));
	               eee.setTelefono(rs.getString("telefono"));
	               if(rs.getString("otro_telefono")==null)eee.setOtro_telefono("-");
	               else eee.setOtro_telefono(rs.getString("otro_telefono"));
	               
	               eee.setEmail(rs.getString("email"));
	               if(rs.getString("otro_email")==null)eee.setOtro_email("-");
	               else eee.setOtro_email(rs.getString("otro_email"));
	               eee.setNumero_seguridad_social(rs.getString("numero_seguridad_social"));
	               eee.setDoba(rs.getString("doba"));
	               eee.setFecha_alta(rs.getDate("fecha_alta"));
	               eee.setObservacion(rs.getString("observaciones"));
	               
                       eee.setPoblacion(rs.getString("poblacion"));
	               eee.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
	               eee.setNivel_formativo(rs.getString("nivel_formativo"));
	               
	               eee.setNacionalidad(rs.getString("nacionalidad"));
	               eee.setNombrefotografia(rs.getString("nombrefotografia"));
	               
                       int idP=rs.getInt("id_perfil");
                       int idPP=rs.getInt("perfil_profesional");
                       int idO=rs.getInt("oficio");
                        try {
                            if(idP!=0){
                                perfiles cu=perfilDAO.ById(idP);
                                eee.setId_perfil(cu);
                            }
                            if(idPP!=0){
                                perfil_profesional perfp=perfilProfesionalDAO.porId(idPP);
                                eee.setPerfilprof(perfp);
                            }
                            if(idO!=0){
                                oficios of=oficioDAO.porId(idO);
                                eee.setOficio(of);
                            }
                           
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               eee.setPermiso_conducir(rs.getString("permiso_conducir"));
	               eee.setVehiculo_propio(rs.getString("vehiculo_propio"));
	               eee.setAutonomo(rs.getString("autonomo"));
	               eee.setPresencia(rs.getString("presencia"));
	               eee.setNombrepresencia(rs.getString("nombre_presencia"));
	               eee.setNombrecv(rs.getString("nombrecv"));
	               eee.setTamanofoto(rs.getString("tamano_foto"));
	               eee.setGenero(rs.getString("genero"));
                       eee.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                       eee.setEstadoaltabaja(rs.getInt("estadoaltabaja"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public empleados ByNifPropuesta(String nif) {
        String sql = "SELECT nif,nombre,apellidos FROM empleados where nif=?";
        empleados e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados eee = new empleados();
                eee.setNif(rs.getString("nif"));
	               eee.setNombre(rs.getString("nombre"));
	               eee.setApellidos(rs.getString("apellidos"));
                return eee;
        }
        });
        
        return e;
    }

    @Override
    public String Insert(empleados emp) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        if(emp.getId_perfil()!=null &&emp.getPerfilprof()!=null){
	  if(emp.getOficio()!=null){
            if(emp.getPerfilprof().getId()==2){
                String sql = "INSERT INTO empleados(" +
                "nif, nombre, apellidos, direccion, pais, provincia, codigo_postal, " +
                "telefono, otro_telefono, email, otro_email, numero_seguridad_social, " +
                "doba, observaciones,id_perfil, fecha_nacimiento, " +
                "fecha_alta, poblacion, numero_afiliacionss, nivel_formativo, " +
                "nacionalidad, perfil_profesional, " +
                "oficio, permiso_conducir, vehiculo_propio, autonomo, presencia, " +
                "nombre_presencia, genero,estadoaltabaja)" +
                "VALUES (?, upper(?), upper(?), upper(?), upper(?), upper(?), ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, upper(?), ?, upper(?), upper(?), ?, " +
                "?, ?, ?, ?, ?, upper(?), upper(?),1)";
                c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNif(),
                 emp.getNombre(), emp.getApellidos(),emp.getDireccion(), emp.getPais(), emp.getPoblacion(), emp.getCodigo_postal(), emp.getTelefono(),
                 emp.getOtro_telefono(), emp.getEmail(), emp.getOtro_email(), emp.getNumero_seguridad_social(), emp.getDoba(), emp.getObservacion(),
                 emp.getId_perfil().getIdp(), emp.getFecha_nacimiento(), emp.getFecha_alta(), emp.getPoblacion(), emp.getNumero_afiliacionss(),
                 emp.getNivel_formativo(), emp.getNacionalidad(), emp.getPerfilprof().getId(), emp.getOficio().getId(), emp.getPermiso_conducir(),
                 emp.getVehiculo_propio(), emp.getAutonomo(), emp.getPresencia(), emp.getNombrepresencia(), emp.getGenero()});
            }else{
                String sql = "INSERT INTO empleados(" +
                "nif, nombre, apellidos, direccion, pais, provincia, codigo_postal, " +
                "telefono, otro_telefono, email, otro_email, numero_seguridad_social, " +
                "doba, observaciones,id_perfil, fecha_nacimiento, " +
                "fecha_alta, poblacion, numero_afiliacionss, nivel_formativo, " +
                "nacionalidad, perfil_profesional, " +
                "permiso_conducir, vehiculo_propio, autonomo, presencia, " +
                "nombre_presencia, genero,otro_perfil_profesional,estadoaltabaja)" +
                "VALUES (?, upper(?), upper(?), upper(?), upper(?), upper(?), ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, upper(?), ?, upper(?), upper(?), " +
                "?, ?, ?, ?, ?, upper(?), upper(?),upper(?),1)";
                c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNif(),
                 emp.getNombre(), emp.getApellidos(),emp.getDireccion(), emp.getPais(), emp.getPoblacion(), emp.getCodigo_postal(), emp.getTelefono(),
                 emp.getOtro_telefono(), emp.getEmail(), emp.getOtro_email(), emp.getNumero_seguridad_social(), emp.getDoba(), emp.getObservacion(),
                 emp.getId_perfil().getIdp(), emp.getFecha_nacimiento(), emp.getFecha_alta(), emp.getPoblacion(), emp.getNumero_afiliacionss(),
                 emp.getNivel_formativo(), emp.getNacionalidad(), emp.getPerfilprof().getId(),emp.getPermiso_conducir(),
                 emp.getVehiculo_propio(), emp.getAutonomo(), emp.getPresencia(), emp.getNombrepresencia(), emp.getGenero(),emp.getOtroperfilprofesional()});
            }
          }else{
             String sql = "INSERT INTO empleados(" +
                "nif, nombre, apellidos, direccion, pais, provincia, codigo_postal, " +
                "telefono, otro_telefono, email, otro_email, numero_seguridad_social, " +
                "doba, observaciones,id_perfil, fecha_nacimiento, " +
                "fecha_alta, poblacion, numero_afiliacionss, nivel_formativo, " +
                "nacionalidad, perfil_profesional, " +
                "permiso_conducir, vehiculo_propio, autonomo, presencia, " +
                "nombre_presencia, genero,otro_perfil_profesional,estadoaltabaja)" +
                "VALUES (?, upper(?), upper(?), upper(?), upper(?), upper(?), ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, upper(?), ?, upper(?), upper(?), " +
                "?, ?, ?, ?, ?, upper(?), upper(?),upper(?),1)";
                c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNif(),
                 emp.getNombre(), emp.getApellidos(),emp.getDireccion(), emp.getPais(), emp.getPoblacion(), emp.getCodigo_postal(), emp.getTelefono(),
                 emp.getOtro_telefono(), emp.getEmail(), emp.getOtro_email(), emp.getNumero_seguridad_social(), emp.getDoba(), emp.getObservacion(),
                 emp.getId_perfil().getIdp(), emp.getFecha_nacimiento(), emp.getFecha_alta(), emp.getPoblacion(), emp.getNumero_afiliacionss(),
                 emp.getNivel_formativo(), emp.getNacionalidad(), emp.getPerfilprof().getId(),emp.getPermiso_conducir(),
                 emp.getVehiculo_propio(), emp.getAutonomo(), emp.getPresencia(), emp.getNombrepresencia(), emp.getGenero(),emp.getOtroperfilprofesional()});
          }
        }
        
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(empleados emp) {
        if(emp.getPerfilprof().getId()!=2){
            oficios o=new oficios();
            o.setId(0);
            emp.setOficio(o);
	}
            String sql = "UPDATE empleados " +
                    "SET nombre=upper(?), apellidos=upper(?), fecha_nacimiento=?, " +
                    "direccion=upper(?), pais=upper(?), provincia=upper(?), codigo_postal=?, " +
                    "telefono=?, otro_telefono=?, email=?, otro_email=?, numero_seguridad_social=?, " +
                    "doba=?, fecha_alta=?, observaciones=?," +
                    "poblacion=upper(?),numero_afiliacionss=?,nivel_formativo=upper(?)," +
                    "nacionalidad=upper(?),  perfil_profesional=?, " +
                    "oficio=?, permiso_conducir=?, vehiculo_propio=?, autonomo=?, presencia=?," +
                    "nombre_presencia=upper(?), genero=upper(?),otro_perfil_profesional=upper(?) " +
                    "WHERE nif=?";
            int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombre(),emp.getApellidos(),emp.getFecha_nacimiento(),emp.getDireccion(),emp.getPais(),
            emp.getProvincia(),emp.getCodigo_postal(),emp.getTelefono(),emp.getOtro_telefono(),emp.getEmail(),emp.getOtro_email(),emp.getNumero_seguridad_social(),
            emp.getDoba(),emp.getFecha_alta(),emp.getObservacion(),emp.getPoblacion(),emp.getNumero_afiliacionss(),emp.getNivel_formativo(),emp.getNacionalidad(),
            emp.getPerfilprof().getId(),emp.getOficio().getId(),emp.getPermiso_conducir(),emp.getVehiculo_propio(),emp.getAutonomo(),emp.getPresencia(),
            emp.getNombrepresencia(),emp.getGenero(),emp.getOtroperfilprofesional(),emp.getNif()});
            String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateA(empleados emp) {
        if(emp.getPerfilprof().getId()!=2){
            oficios o=new oficios();
            o.setId(0);
            emp.setOficio(o);
	}
            String sql = "UPDATE empleados "+
               "SET nombre=upper(?), apellidos=upper(?), fecha_nacimiento=?, "+
		       "direccion=upper(?), pais=upper(?), provincia=upper(?), codigo_postal=?, "+
		       "telefono=?, otro_telefono=?, email=?, otro_email=?, numero_seguridad_social=?, "+
		       "doba=?, fecha_alta=?, observaciones=?, "+
		       "poblacion=upper(?),numero_afiliacionss=?,nivel_formativo=upper(?),"
		       + "nacionalidad=upper(?),  perfil_profesional=?, "
			    + "oficio=?, permiso_conducir=?, vehiculo_propio=?, autonomo=?, presencia=?, "
			    + "nombre_presencia=?, genero=upper(?),id_perfil=?,otro_perfil_profesional=upper(?) "+
		       "WHERE nif=?";
            int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombre(),emp.getApellidos(),emp.getFecha_nacimiento(),
                emp.getDireccion(),emp.getPais(),emp.getProvincia(), emp.getCodigo_postal(), emp.getTelefono(),emp.getOtro_telefono(),
                    emp.getEmail(),emp.getOtro_email(), emp.getNumero_seguridad_social(),emp.getDoba(),emp.getFecha_alta(),emp.getObservacion(),
                emp.getPoblacion(), emp.getNumero_afiliacionss(), emp.getNivel_formativo(), emp.getNacionalidad(), emp.getPerfilprof().getId(),
                emp.getOficio().getId(), emp.getPermiso_conducir(), emp.getVehiculo_propio(), emp.getAutonomo(), emp.getPresencia(),
                emp.getNombrepresencia(), emp.getGenero(), emp.getId_perfil().getIdp(),emp.getOtroperfilprofesional(),emp.getNif()});
            String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateUC(empleados emp) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(emp.getContrasenna()!=null && emp.getContrasenna()!=""){
            String sql = "UPDATE empleados SET usuario=?, contrasenna=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getUsuario(),emp.getContrasenna(),emp.getNif()});       
        
        }else{
            String sql = "UPDATE empleados SET usuario=? WHERE nif=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getUsuario(),emp.getNif()});  
        }
        
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(String nif) {
        String sql = "DELETE FROM empleados WHERE nif =?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public empleados reporteContrato(String nif, int cont) {
        String sql = "SELECT e.nif,e.nombre||' '||e.apellidos as nombres,e.direccion||' '||e.poblacion||' '||e.provincia||' ('||e.pais||')' as domicilio,to_char(fecha_contrato_desde, 'DD Mon YYYY') FROM empleados e  INNER JOIN contrato c on(e.nif=c.nif_empleado)   where e.nif='"+nif+"' and c.id="+cont;
        empleados e =(empleados)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{}, new RowMapper<empleados>(){
        @Override
            public empleados mapRow(ResultSet rs, int i) throws SQLException {
                empleados e = new empleados();
                e.setNif(rs.getString("nif"));
                e.setNombre(rs.getString("nombres"));
                e.setDireccion(rs.getString("domicilio"));
                e.setObservacion(rs.getString(4));
                return e;
        }
        });
        return e;
    }

    @Override
    public reporteNomina reporteNomina(String nif, int cont, int nomi) {
        String sql = "SELECT e.nif,e.nombre||' '||e.apellidos as nombres, "+
	"e.numero_seguridad_social as nss,c.categoria_profesional as cp,'De '||to_char(fecha_contrato_desde, 'DD mon')||' a '||to_char(c.fecha_contrato_hasta, 'DD mon') as periodo, "+
	"c.fecha_contrato_hasta::DATE - c.fecha_contrato_desde::DATE +1 as dias, "+
	"n.salario_base, "+
	"n.pagas_extras_prorrateadas as pep, "+
	"n.prorrateo_vacaciones as pv, "+
	"n.horas_extraordinarias as he, "+
	"n.gratificaciones_extraordinarias as ge, "+
	"n.salario_especie, "+
	"n.indemnizaciones_suplidos as isup, "+
	"n.prestaciones_indemnizaciones_ss as piss, "+
	"n.otras_percepciones_no_salariales as opns, "+
	"(n.salario_base+ "+
	"n.pagas_extras_prorrateadas+ "+
	"n.prorrateo_vacaciones+  "+
	"n.horas_extraordinarias+ "+
	"n.gratificaciones_extraordinarias+ "+
	"n.salario_especie+ "+
	"n.indemnizaciones_suplidos + "+
	"n.prestaciones_indemnizaciones_ss + "+
	"n.otras_percepciones_no_salariales)as total_devengado, "+
	"d.contingencias_comunes as cm, "+
	"d.desempleo, "+
	"d.formacion, "+
	"d.irpf, "+
	"d.anticipos, "+
	"d.valor_productos_recibidos as vpr, "+
	"d.otras_deducciones, "+
	"(d.contingencias_comunes+ "+
	"d.desempleo+ "+
	"d.formacion+ "+
	"d.irpf+ "+
	"d.anticipos+ "+
	"d.valor_productos_recibidos+ "+
	"d.otras_deducciones)as total_deducciones, "+
	"((n.salario_base+ "+
	"n.pagas_extras_prorrateadas+ "+
	"n.prorrateo_vacaciones+ "+
	"n.gratificaciones_extraordinarias+ "+
	"n.salario_especie+ "+
	"n.indemnizaciones_suplidos + "+
	"n.prestaciones_indemnizaciones_ss + "+
	"n.otras_percepciones_no_salariales)-(d.contingencias_comunes+ "+
	"d.desempleo+ "+
	"d.formacion+ "+
	"d.irpf+ "+
	"d.anticipos+ "+
	"d.valor_productos_recibidos+ "+
	"d.otras_deducciones))as liquido,nivel_profesional nivp  "+
	"FROM empleados e  INNER JOIN contrato c on(e.nif=c.nif_empleado)  "+
	"INNER JOIN nomina n on(e.nif=n.nif_empleado) "+
	"INNER JOIN deducciones d on(e.nif=d.nif_empleado) "+
	"where e.nif=? and c.id=? and n.id=? and d.nomina_id=?";
        reporteNomina e =(reporteNomina)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif,cont,nomi,nomi}, new RowMapper<reporteNomina>(){
        @Override
            public reporteNomina mapRow(ResultSet rs, int i) throws SQLException {
                reporteNomina e = new reporteNomina();
                e.setNif(rs.getString(1));
	               e.setNombres(rs.getString(2));
	               e.setNss(rs.getString(3));
	               e.setCp(rs.getString(4));
	               e.setPeriodo(rs.getString(5));
	               e.setDias(rs.getString(6));
	               e.setSalario_base(rs.getString(7));
	               e.setPep(rs.getString(8));
	               e.setPv(rs.getString(9));
	               e.setHe(rs.getString(10));
	               e.setGe(rs.getString(11));
	               e.setSalario_especie(rs.getString(12));
	               e.setIsup(rs.getString(13));
	               e.setPiss(rs.getString(14));
	               e.setOpns(rs.getString(15));
	               e.setTotal_devengado(rs.getString(16));
	               e.setCm(rs.getString(17));
	               e.setDesempleo(rs.getString(18));
	               e.setFormacion(rs.getString(19));
	               e.setIrpf(rs.getString(20));
	               e.setAnticipos(rs.getString(21));
	               e.setVpr(rs.getString(22));
	               e.setOtras_deducciones(rs.getString(23));
	               e.setTotal_deducciones(rs.getString(24));
	               e.setLiquido(rs.getString(25));
	               e.setNivp(rs.getString(26));
                return e;
        }
        });
        return e;
    }

    @Override
    public String UpdateCV(empleados emp, FileInputStream fis, int longitudBytes) {
        String sql = " UPDATE empleados SET nombrecv=?,cv=? WHERE nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombrecv(),fis,longitudBytes,emp.getNif()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateImagen(empleados emp) {
        String sql = "UPDATE empleados SET nombrefotografia=? WHERE nif=?";
        
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombrefotografia(),emp.getNif()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String UpdateTamanoImagen(empleados emp) {
        String sql = "UPDATE empleados SET tamano_foto=? WHERE nif=?";
        
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getTamanofoto(),emp.getNif()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public void guardarImagenEmpleado(empleados emp) {
        String sql = "SELECT fotografia,nombrefotografia,cv,nombrecv FROM empleados where nif=?";
        this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{emp.getNif()},new RowMapper<Object>(){
        @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                try {
                if(rs.getBytes("fotografia")!=null){
                    imgBytes = rs.getBytes("fotografia"); 
                    FileOutputStream fileOuputStream;
                    
                        fileOuputStream = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\Seleccion\\imagenespostulante\\"+rs.getString(2));
                    
	               
	            fileOuputStream.write(imgBytes);
	            fileOuputStream.close();
	         
                      //String img="sun.jpg";
	            InputStream in = new ByteArrayInputStream(rs.getBytes(1));
	        	   
	            BufferedImage image = ImageIO.read(in);
	            System.out.println("image"+image);
                }
                if(rs.getBytes(3)!=null){
                       imgBytesCV = rs.getBytes(3); 
	        	   
	        	   //FileInputStream fileInputStream2 = null;
	               
	               FileOutputStream fileOuputStream2 =
	                         new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\Seleccion\\cvpostulante\\"+rs.getString(4));
	               
	               fileOuputStream2.write(imgBytesCV);
	               fileOuputStream2.close();
	         
	        	   //String img2="sun.jpg";
                       InputStream in2 = new ByteArrayInputStream(rs.getBytes(3));
	        	   
                       BufferedImage image2 = ImageIO.read(in2);
                       System.out.println("image"+image2);
		}
	        	  
                }catch(Exception exc){
                }
               return null; 
            }
        });
        
    }
    @Override
    public boolean updateEstadoAlta(String nif) {
        String sql = "UPDATE empleados SET estadoaltabaja=1 where nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        boolean result=false;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            result=true;
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return result;
    }
    
    @Override
    public boolean updateEstadoBaja(String nif) {
        String sql = "UPDATE empleados SET estadoaltabaja=2 where nif=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        boolean result=false;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            result=true;
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return result;
    }
}
