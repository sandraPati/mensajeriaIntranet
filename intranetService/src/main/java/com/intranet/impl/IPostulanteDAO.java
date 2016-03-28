/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.cvpostulante;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.postulantes;
import com.intranet.beans.users;
import com.intranet.dao.OficioDAO;
import com.intranet.dao.PerfilProfesionalDAO;
import com.intranet.dao.PostulanteDAO;
import com.intranet.dao.UsuariosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("postulanteDAO")
public class IPostulanteDAO extends UtilTemplateDAO implements PostulanteDAO{

    @Autowired(required = true)
    PerfilProfesionalDAO perfilProfesionalDAO;
    @Autowired(required = true)
    OficioDAO oficioDAO;
    @Autowired(required = true)
    UsuariosDAO usuariosDAO;
    
    byte[] imgBytes = null;
    byte[] imgBytesCV = null;
    
    @Override
    public List<postulantes> findAll() {
        String sql = "SELECT id, perfil_profesional,oficio, nombre, apellidos, email, usuario, " +
                "contrasenna, documento_identificacion, genero, pais, " +
                "provincia, poblacion, direccion, codigo_postal, telefono, permisoconducir, " +
                "vehiculopropio, autonomo, nacionalidad, presencia, nombrepresencia, " +
                "nombrefotografia, tamanofoto, nombrecv,numero_afiliacionss,nivel_formativo,fecha_nacimiento,otro_perfil_profesional,estadoinf,fecharegistrado " +
                "FROM postulante where estado=1";
        List<postulantes> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<postulantes>(){
        @Override
            public postulantes mapRow(ResultSet rs, int i) throws SQLException {
                postulantes e = new postulantes();
                e.setId(rs.getInt("id"));
                int idPP=rs.getInt("perfil_profesional");
                int idO=rs.getInt("oficio");
                try {
                    if(idPP!=0){
                    perfil_profesional cu=perfilProfesionalDAO.porId(idPP);
                    e.setPerfilprof(cu);
                    }
                    if(idO!=0){
                    oficios cu2=oficioDAO.porId(idO);
                    e.setOficio(cu2);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setEmail(rs.getString("email"));
                e.setUsuario(rs.getString("usuario"));
                e.setContrasenna(rs.getString("contrasenna"));
                e.setDocuemnto_identidad(rs.getString("documento_identificacion"));
                e.setGenero(rs.getString("genero"));
                e.setPais(rs.getString("pais"));
                e.setProvincia(rs.getString("provincia"));
                e.setPoblacion(rs.getString("poblacion"));
                e.setDireccion(rs.getString("direccion"));
                e.setCodigo_postal(rs.getString("codigo_postal"));
                e.setTelefono(rs.getString("telefono"));
                e.setPermisoconducir(rs.getString("permisoconducir"));
                e.setVehiculopropio(rs.getString("vehiculopropio"));
                e.setAutonomo(rs.getString("autonomo"));
                e.setNacionalidad(rs.getString("nacionalidad"));
                e.setPresencia(rs.getString("presencia"));
                e.setNombrepresencia(rs.getString("nombrepresencia"));
                e.setNombrefotografia(rs.getString("nombrefotografia"));
                e.setTamanofoto(rs.getString("tamanofoto"));
                e.setNombrecv(rs.getString("nombrecv"));
                e.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
                e.setNivel_formativo(rs.getString("nivel_formativo"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                e.setEstadoinf(rs.getBoolean("estadoinf"));
                e.setFecharegistrado(rs.getDate("fecharegistrado"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public List<postulantes> enproceso() {
         String sql = "SELECT id, perfil_profesional,oficio, nombre, apellidos, email, usuario, " +
                "contrasenna, documento_identificacion, genero, pais, " +
                "provincia, poblacion, direccion, codigo_postal, telefono, permisoconducir, " +
                "vehiculopropio, autonomo, nacionalidad, presencia, nombrepresencia, " +
                "nombrefotografia, tamanofoto, nombrecv,numero_afiliacionss,nivel_formativo,fecha_nacimiento,otro_perfil_profesional,estadoinf,fecharegistrado " +
                "FROM postulante where estado=2";
        List<postulantes> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<postulantes>(){
        @Override
            public postulantes mapRow(ResultSet rs, int i) throws SQLException {
                postulantes e = new postulantes();
                e.setId(rs.getInt("id"));
                int idPP=rs.getInt("perfil_profesional");
                int idO=rs.getInt("oficio");
                try {
                    if(idPP!=0){
                    perfil_profesional cu=perfilProfesionalDAO.porId(idPP);
                    e.setPerfilprof(cu);
                    }
                    if(idO!=0){
                    oficios cu2=oficioDAO.porId(idO);
                    e.setOficio(cu2);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setEmail(rs.getString("email"));
                e.setUsuario(rs.getString("usuario"));
                e.setContrasenna(rs.getString("contrasenna"));
                e.setDocuemnto_identidad(rs.getString("documento_identificacion"));
                e.setGenero(rs.getString("genero"));
                e.setPais(rs.getString("pais"));
                e.setProvincia(rs.getString("provincia"));
                e.setPoblacion(rs.getString("poblacion"));
                e.setDireccion(rs.getString("direccion"));
                e.setCodigo_postal(rs.getString("codigo_postal"));
                e.setTelefono(rs.getString("telefono"));
                e.setPermisoconducir(rs.getString("permisoconducir"));
                e.setVehiculopropio(rs.getString("vehiculopropio"));
                e.setAutonomo(rs.getString("autonomo"));
                e.setNacionalidad(rs.getString("nacionalidad"));
                e.setPresencia(rs.getString("presencia"));
                e.setNombrepresencia(rs.getString("nombrepresencia"));
                e.setNombrefotografia(rs.getString("nombrefotografia"));
                e.setTamanofoto(rs.getString("tamanofoto"));
                e.setNombrecv(rs.getString("nombrecv"));
                e.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
                e.setNivel_formativo(rs.getString("nivel_formativo"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                e.setEstadoinf(rs.getBoolean("estadoinf"));
                e.setFecharegistrado(rs.getDate("fecharegistrado"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public List<postulantes> descartados() {
         String sql = "SELECT id, perfil_profesional,oficio, nombre, apellidos, email, usuario, " +
                "contrasenna, documento_identificacion, genero, pais, " +
                "provincia, poblacion, direccion, codigo_postal, telefono, permisoconducir, " +
                "vehiculopropio, autonomo, nacionalidad, presencia, nombrepresencia, " +
                "nombrefotografia, tamanofoto, nombrecv,numero_afiliacionss,nivel_formativo,fecha_nacimiento,otro_perfil_profesional,estadoinf,fecharegistrado " +
                "FROM postulante where estado=3";
        List<postulantes> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<postulantes>(){
        @Override
            public postulantes mapRow(ResultSet rs, int i) throws SQLException {
                postulantes e = new postulantes();
                e.setId(rs.getInt("id"));
                int idPP=rs.getInt("perfil_profesional");
                int idO=rs.getInt("oficio");
                try {
                    perfil_profesional cu=perfilProfesionalDAO.porId(idPP);
                    e.setPerfilprof(cu);
                    
                    oficios cu2=oficioDAO.porId(idO);
                    e.setOficio(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setEmail(rs.getString("email"));
                e.setUsuario(rs.getString("usuario"));
                e.setContrasenna(rs.getString("contrasenna"));
                e.setDocuemnto_identidad(rs.getString("documento_identificacion"));
                e.setGenero(rs.getString("genero"));
                e.setPais(rs.getString("pais"));
                e.setProvincia(rs.getString("provincia"));
                e.setPoblacion(rs.getString("poblacion"));
                e.setDireccion(rs.getString("direccion"));
                e.setCodigo_postal(rs.getString("codigo_postal"));
                e.setTelefono(rs.getString("telefono"));
                e.setPermisoconducir(rs.getString("permisoconducir"));
                e.setVehiculopropio(rs.getString("vehiculopropio"));
                e.setAutonomo(rs.getString("autonomo"));
                e.setNacionalidad(rs.getString("nacionalidad"));
                e.setPresencia(rs.getString("presencia"));
                e.setNombrepresencia(rs.getString("nombrepresencia"));
                e.setNombrefotografia(rs.getString("nombrefotografia"));
                e.setTamanofoto(rs.getString("tamanofoto"));
                e.setNombrecv(rs.getString("nombrecv"));
                e.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
                e.setNivel_formativo(rs.getString("nivel_formativo"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                e.setEstadoinf(rs.getBoolean("estadoinf"));
                e.setFecharegistrado(rs.getDate("fecharegistrado"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public int cantidadDia() {
        String sql = "SELECT count(*)as contar FROM postulante where estado=1";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public cvpostulante cantidadesEstado() {
        final cvpostulante cpresult=new cvpostulante();
        String sql = "SELECT estado,count(*)as contar FROM postulante group by estado order by estado";
        List<cvpostulante> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<cvpostulante>(){
        @Override
            public cvpostulante mapRow(ResultSet rs, int i) throws SQLException {
                cvpostulante ee = new cvpostulante();
                          if(rs.getInt("estado")==1){
	        		   ee.setEstado1(rs.getInt("estado"));
		        	   ee.setCantidad1(rs.getInt("contar"));
                                   cpresult.setEstado1(ee.getEstado1());
                                   cpresult.setCantidad1(ee.getCantidad1());
	        	   }else if(rs.getInt("estado")==2){
	        		   ee.setEstado2(rs.getInt("estado"));
		        	   ee.setCantidad2(rs.getInt("contar"));
                                   cpresult.setEstado2(ee.getEstado2());
                                   cpresult.setCantidad2(ee.getCantidad2());
	        	   }else if(rs.getInt("estado")==3){
	        		   ee.setEstado3(rs.getInt("estado"));
		        	   ee.setCantidad3(rs.getInt("contar"));
                                   cpresult.setEstado3(ee.getEstado3());
                                   cpresult.setCantidad3(ee.getCantidad3());
	        	   }
                
                return ee;
        }
        });
        
        return cpresult;
    }

    @Override
    public postulantes ByNif(String nif) {
        String sql = "SELECT id, perfil_profesional,oficio, nombre, apellidos, email,  " +
                    "documento_identificacion, genero, pais, " +
                    "provincia, poblacion, direccion, codigo_postal, telefono, permisoconducir, " +
                    "vehiculopropio, autonomo, nacionalidad, presencia, nombrepresencia, " +
                    "nombrefotografia, tamanofoto, nombrecv,numero_afiliacionss,nivel_formativo,fecha_nacimiento,otro_perfil_profesional,estadoinf,fecharegistrado " +
                    "FROM postulante where documento_identificacion=?";
        postulantes e =(postulantes)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<postulantes>(){
        @Override
            public postulantes mapRow(ResultSet rs, int i) throws SQLException {
                postulantes e = new postulantes();
                e.setId(rs.getInt("id"));
                int idPP=rs.getInt("perfil_profesional");
                int idO=rs.getInt("oficio");
                try {
                    if(idPP!=0){
                    perfil_profesional cu=perfilProfesionalDAO.porId(idPP);
                    e.setPerfilprof(cu);
                    }
                    if(idO!=0){
                    oficios cu2=oficioDAO.porId(idO);
                    e.setOficio(cu2);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setEmail(rs.getString("email"));
                e.setDocuemnto_identidad(rs.getString("documento_identificacion"));
                e.setGenero(rs.getString("genero"));
                e.setPais(rs.getString("pais"));
                e.setProvincia(rs.getString("provincia"));
                e.setPoblacion(rs.getString("poblacion"));
                e.setDireccion(rs.getString("direccion"));
                e.setCodigo_postal(rs.getString("codigo_postal"));
                e.setTelefono(rs.getString("telefono"));
                e.setPermisoconducir(rs.getString("permisoconducir"));
                e.setVehiculopropio(rs.getString("vehiculopropio"));
                e.setAutonomo(rs.getString("autonomo"));
                e.setNacionalidad(rs.getString("nacionalidad"));
                e.setPresencia(rs.getString("presencia"));
                e.setNombrepresencia(rs.getString("nombrepresencia"));
                e.setNombrefotografia(rs.getString("nombrefotografia"));
                e.setTamanofoto(rs.getString("tamanofoto"));
                e.setNombrecv(rs.getString("nombrecv"));
                e.setNumero_afiliacionss(rs.getString("numero_afiliacionss"));
                e.setNivel_formativo(rs.getString("nivel_formativo"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setOtroperfilprofesional(rs.getString("otro_perfil_profesional"));
                e.setEstadoinf(rs.getBoolean("estadoinf"));
                e.setFecharegistrado(rs.getDate("fecharegistrado"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public boolean Insert(postulantes emp) {
        int c=0;
        boolean result=false;
        //if(emp.getOficio()!=null){
            if(emp.getPerfilprof().getId()==2){
                String sql = "INSERT INTO postulante(" +
                "perfil_profesional, nombre, apellidos, email, usuario, " +
                "contrasenna, condiciones,oficio,documento_identificacion,numero_afiliacionss,nivel_formativo,otro_perfil_profesional,estadoinf,estado,fecharegistrado,horaregistrado)" +
                "VALUES (?,upper(?),upper(?),?,?,?,?,?,?,?,upper(?),?,false,1,current_date, to_char(current_timestamp, 'HH12:MI:SS'))";
                c=this.getJdbcTemplate().update(sql, new Object[]{emp.getPerfilprof().getId(),emp.getNombre(),emp.getApellidos(),
                emp.getEmail(),emp.getUsuario(),emp.getContrasenna(),emp.getCondiciones(),emp.getOficio().getId(),emp.getDocuemnto_identidad(),
                emp.getNumero_afiliacionss(),emp.getNivel_formativo(),""});
                
            }else{
                String sql = "INSERT INTO postulante(" +
                "perfil_profesional, nombre, apellidos, email, usuario, " +
                "contrasenna, condiciones,documento_identificacion,numero_afiliacionss,nivel_formativo,otro_perfil_profesional,estadoinf,estado,fecharegistrado,horaregistrado)" +
                "VALUES (?,upper(?),upper(?),?,?,?,?,?,?,upper(?),upper(?),false,1,current_date, to_char(current_timestamp, 'HH12:MI:SS'))";
                c=this.getJdbcTemplate().update(sql, new Object[]{emp.getPerfilprof().getId(),emp.getNombre(),emp.getApellidos(),
                emp.getEmail(),emp.getUsuario(),emp.getContrasenna(),emp.getCondiciones(),emp.getDocuemnto_identidad(),
                emp.getNumero_afiliacionss(),emp.getNivel_formativo(),emp.getOtroperfilprofesional()});
                
            }
        
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            result=true;
            rpta="Se INSERTO Satisfactoriamente...!";
            userRol(emp);
        }
        return result;
    }

    public void userRol(postulantes emp){
        try{
        users u=new users();
                u.setNif(emp.getDocuemnto_identidad());
                u.setUsuario(emp.getUsuario());
                u.setContrasenna(emp.getContrasenna());
                u.setEmail(emp.getEmail());
                usuariosDAO.insertar(u);
                usuariosDAO.anadirRolaUser(emp.getDocuemnto_identidad(), 4);
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public int validaEmail(String email) {
        String sql = "SELECT  count(*) as cuenta FROM users where email=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{email},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("cuenta");
                return t;
        }
        });
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
    public int enProceso(String nif) {
        String sql = "UPDATE postulante SET estado=2 where documento_identificacion=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        
        return c;
    }

    @Override
    public String enProcesoFin(postulantes p) {
        String sql = "UPDATE postulante SET estado=4 where id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public int descartado(String nif) {
        String sql = "UPDATE postulante SET estado=3 where documento_identificacion=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{nif});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return c;
    }

    @Override
    public int restaurar(postulantes p) {
        String sql = "UPDATE postulante SET estado=1 where id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return c;
    }

    @Override
    public String UpdateSinImagenSinCV(postulantes emp) {
        int c=0;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        //if(emp.getOficio()!=null){
            if(emp.getPerfilprof().getId()==2){
            String sql = "UPDATE postulante " +
                    "SET perfil_profesional=?, oficio=?, nombre=upper(?), apellidos=upper(?), " +
                    "email=?, " +
                    "genero=?, pais=upper(?), provincia=upper(?), poblacion=upper(?), direccion=upper(?), codigo_postal=?, " +
                    "telefono=?, permisoconducir=?, vehiculopropio=?, autonomo=?, " +
                    "nacionalidad=upper(?), presencia=?, nombrepresencia=?,numero_afiliacionss=?,nivel_formativo=upper(?),fecha_nacimiento=?,otro_perfil_profesional=upper(?) " +
                    "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getPerfilprof().getId(),
            emp.getOficio().getId(),
            emp.getNombre(),emp.getApellidos(),
            emp.getEmail(),emp.getGenero(),
            emp.getPais(),emp.getProvincia(),
            emp.getPoblacion(),emp.getDireccion(),
            emp.getCodigo_postal(),emp.getTelefono(),
            emp.getPermisoconducir(),emp.getVehiculopropio(),
            emp.getAutonomo(),emp.getNacionalidad(),
            emp.getPresencia(),emp.getNombrepresencia(),
            emp.getNumero_afiliacionss(),
            emp.getNivel_formativo(),emp.getFecha_nacimiento(),"",emp.getId()});
            
            }else{
                 String sql = "UPDATE postulante " +
                    "SET perfil_profesional=?,  nombre=upper(?), apellidos=upper(?), " +
                    "email=?, " +
                    "genero=?, pais=upper(?), provincia=upper(?), poblacion=upper(?), direccion=upper(?), codigo_postal=?, " +
                    "telefono=?, permisoconducir=?, vehiculopropio=?, autonomo=?, " +
                    "nacionalidad=upper(?), presencia=?, nombrepresencia=?,numero_afiliacionss=?,nivel_formativo=upper(?),fecha_nacimiento=?,otro_perfil_profesional=upper(?) " +
                    "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getPerfilprof().getId(),
            
            emp.getNombre(),emp.getApellidos(),
            emp.getEmail(),emp.getGenero(),
            emp.getPais(),emp.getProvincia(),
            emp.getPoblacion(),emp.getDireccion(),
            emp.getCodigo_postal(),emp.getTelefono(),
            emp.getPermisoconducir(),emp.getVehiculopropio(),
            emp.getAutonomo(),emp.getNacionalidad(),
            emp.getPresencia(),emp.getNombrepresencia(),
            emp.getNumero_afiliacionss(),
            emp.getNivel_formativo(),emp.getFecha_nacimiento(),emp.getOtroperfilprofesional(),emp.getId()});
            
            }
        
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateUC(postulantes emp) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        if(emp.getContrasenna()!=null && emp.getContrasenna()!=""){
            String sql = "UPDATE postulante SET usuario=?, contrasenna=? WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getUsuario(),emp.getContrasenna(),emp.getId()});
        }else{
            String sql = "UPDATE postulante SET usuario=? WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getUsuario(),emp.getId()});
        }
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    FileInputStream fis;
    int longitudBytes;
    @Override
    public String UpdateCV(postulantes emp, FileInputStream fis, int longitudBytes) {
        String sql = "UPDATE postulante SET nombrecv=?,cv=? WHERE id=?";
        
        //InputStream getBinaryStream(fis,longitudBytes)throws SQLException;
        int c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombrecv(),fis,longitudBytes,emp.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateImagen(postulantes emp) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
            String sql = "UPDATE postulante " +
            "SET nombrefotografia=? " +
            "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getNombrefotografia(),emp.getId()});
        
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    
    @Override
    public String UpdateTamanoImagen(postulantes emp) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
            String sql = "UPDATE postulante " +
                "SET tamanofoto=? " +
                "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{emp.getTamanofoto(),emp.getId()});
       
        return rpta;
    }
    @Override
    public String guardarImagenProveedor(postulantes postulante) {
        
        String sql = "SELECT fotografia,nombrefotografia,cv,nombrecv FROM postulante where id=?";
        this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Object>(){
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
        
        return "";
        
    }
    
    @Override
    public String guardaFotoCarpeta(byte[] p) {
       /* 
        String sql = "SELECT fotografia,nombrefotografia,cv,nombrecv FROM postulante where id=?";
        this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Object>(){
        @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                */try {
                if(p!=null){
                    imgBytes = p; 
                    FileOutputStream fileOuputStream;
                    
                        fileOuputStream = new FileOutputStream("C:\\reportesIntranetDecorakia\\fotos"+p);
                    
	               
	            fileOuputStream.write(imgBytes);
	            fileOuputStream.close();
	         
                      //String img="sun.jpg";
	            InputStream in = new ByteArrayInputStream(p);
	        	   
	            BufferedImage image = ImageIO.read(in);
	            System.out.println("image"+image);
                }
              /*  if(rs.getBytes(3)!=null){
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
		}*/
	        	  
                }catch(Exception exc){
                }
               
         
        return "";
        
    }

    @Override
    public int volcaraEmpleado(postulantes emp) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        if(emp.getPerfilprof().getId()==2){
        String sql = "INSERT INTO empleados(nif, nombre, apellidos, direccion, pais, provincia,poblacion, telefono," +
                "email, usuario, contrasenna, numero_afiliacionss,nivel_formativo,fecha_nacimiento," +
                "codigo_postal," +
                "nacionalidad,nombrefotografia,perfil_profesional," +
                "oficio,permiso_conducir,vehiculo_propio, autonomo, presencia," +
                "nombre_presencia, nombrecv, tamano_foto, genero,otro_perfil_profesional,id_perfil,estadoaltabaja " +
                ")" +
                "VALUES (?,upper(?),upper(?),upper(?),upper(?),upper(?),upper(?),?,?,?,?,?,upper(?),?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,2,1)";
       
        c=this.getJdbcTemplate().update(sql, new Object[]{emp.getDocuemnto_identidad(),
        emp.getNombre(),emp.getApellidos(),emp.getDireccion(),emp.getPais(),emp.getProvincia(),
        emp.getPoblacion(),emp.getTelefono(),emp.getEmail(),emp.getUsuario(),emp.getContrasenna(),emp.getNumero_afiliacionss(),
        emp.getNivel_formativo(),emp.getFecha_nacimiento(),emp.getCodigo_postal(),emp.getNacionalidad(),emp.getNombrefotografia(),
        emp.getPerfilprof().getId(),emp.getOficio().getId(),emp.getPermisoconducir(),emp.getVehiculopropio(),emp.getAutonomo(),
        emp.getPresencia(),emp.getNombrepresencia(),emp.getNombrecv(),emp.getTamanofoto(),emp.getGenero(),emp.getOtroperfilprofesional()});
        
        }else{
            String sql = "INSERT INTO empleados(nif, nombre, apellidos, direccion, pais, provincia,poblacion, telefono," +
                "email, usuario, contrasenna, numero_afiliacionss,nivel_formativo,fecha_nacimiento," +
                " codigo_postal, " +
                "nacionalidad, nombrefotografia, perfil_profesional, " +
                "permiso_conducir, vehiculo_propio, autonomo, presencia," +
                "nombre_presencia, nombrecv, tamano_foto, genero,otro_perfil_profesional,id_perfil,estadoaltabaja " +
                ")" +
                "VALUES (?,upper(?),upper(?),upper(?),upper(?),upper(?),upper(?),?,?,?,?,?,upper(?),?," +
                "?,upper(?),?,?,upper(?),upper(?),upper(?),?,?,?,?,upper(?),upper(?),2,1)";
        c=this.getJdbcTemplate().update(sql, new Object[]{emp.getDocuemnto_identidad(),
        emp.getNombre(),emp.getApellidos(),emp.getDireccion(),emp.getPais(),emp.getProvincia(),
        emp.getPoblacion(),emp.getTelefono(),emp.getEmail(),emp.getUsuario(),emp.getContrasenna(),emp.getNumero_afiliacionss(),
        emp.getNivel_formativo(),emp.getFecha_nacimiento(),emp.getCodigo_postal(),emp.getNacionalidad(),emp.getNombrefotografia(),
        emp.getPerfilprof().getId(),emp.getPermisoconducir(),emp.getVehiculopropio(),emp.getAutonomo(),
        emp.getPresencia(),emp.getNombrepresencia(),emp.getNombrecv(),emp.getTamanofoto(),emp.getGenero(),emp.getOtroperfilprofesional()});
        
        }
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            
               // usuariosDAO.anadirRolaUser(emp.getDocuemnto_identidad(), 3);
            
        }
        return c;
    }
    
    @Override
    public boolean updateEstadoInf(postulantes p) {
        String sql = "UPDATE postulante SET estadoinf=true where id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getId()});
        boolean result=false;
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            result=true;
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return result;
    }
    
    
    
}
