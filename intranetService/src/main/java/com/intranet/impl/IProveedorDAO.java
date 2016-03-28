/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.proveedores;
import com.intranet.beans.tipo_actividades;
import com.intranet.dao.ProveedorDAO;
import com.intranet.dao.TipoActividadDAO;
import com.intranet.util.UtilTemplateDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proveedorDAO")
public class IProveedorDAO extends UtilTemplateDAO implements ProveedorDAO{
    byte[] imgBytes = null;
    
    @Autowired(required = true)
    TipoActividadDAO tipoActividadDAO;
    
    @Override
    public List<proveedores> lista(String buscar) {
        String sql = "SELECT num_cuenta, nombre, nombrefoto, direccion, id_actividad,"+
                    "email, telefono, link, estadocalificado,latitud,longitud,id,banco,persona_contacto,cif,aprobado,visible "+
                    "FROM proveedores ";
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
				 //p.setId_actividad(tipoActividadS.porId(rs.getInt(5)));
				 p.setEmail(rs.getString(6));
				 p.setTelefono(rs.getString(7));
				 p.setLink(rs.getString(8));
				 p.setEstadoCalificado(rs.getBoolean(9));
				 p.setLatitud(rs.getDouble(10));
				 p.setLongitud(rs.getDouble(11));
				 p.setLat(rs.getDouble(10));
				 p.setLongt(rs.getDouble(11));
                                 p.setId(rs.getInt(12));
                                 p.setBanco(rs.getString(13));
                                 p.setPersona_contacto(rs.getString(14));
                                 p.setCif(rs.getString(15));
                                 p.setAprobado(rs.getBoolean(16));
                                 p.setVisible(rs.getBoolean(17));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public proveedores porId(int id) {
        String sql = "SELECT num_cuenta, nombre, nombrefoto, direccion, id_actividad,"+
                    "email, telefono, link, estadocalificado,latitud,longitud,id,banco,persona_contacto,cif,aprobado,visible "+
                    "FROM proveedores where id=?";
        proveedores e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proveedores>(){
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
				 //p.setId_actividad(tipoActividadS.porId(rs.getInt(5)));
				 p.setEmail(rs.getString(6));
				 p.setTelefono(rs.getString(7));
				 p.setLink(rs.getString(8));
				 p.setEstadoCalificado(rs.getBoolean(9));
				 p.setLatitud(rs.getDouble(10));
				 p.setLongitud(rs.getDouble(11));
				 p.setLat(rs.getDouble(10));
				 p.setLongt(rs.getDouble(11));
                                 p.setId(rs.getInt(12));
                                 p.setBanco(rs.getString(13));
                                 p.setPersona_contacto(rs.getString(14));
                                 p.setCif(rs.getString(15));
                                 p.setAprobado(rs.getBoolean(16));
                                 p.setVisible(rs.getBoolean(17));
                return p;
        }
        });
        
        return e;
    }

    @Override
    public boolean insertar(proveedores p) {
        String sql = "INSERT INTO proveedores("+
		            "num_cuenta, nombre,nombrefoto, direccion, id_actividad, "+
		            "email, telefono, link,latitud,longitud,banco,persona_contacto,cif,visible,aprobado) "+
		            "VALUES (?,?,?,?,?, ?,?,?,?,?,?,?,?,?,false)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNum_cuenta(), p.getNombre(), p.getNombreFoto(), 
			p.getDireccion(), p.getId_actividad().getId(), p.getEmail(), p.getTelefono(), p.getLink(), p.getLatitud(), 
                        p.getLongitud(),p.getBanco(),p.getPersona_contacto(),p.getCif(),p.getVisible()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
         boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }

    @Override
    public boolean insertarSinImagen(proveedores p) {
        String sql = "INSERT INTO proveedores("+
		            "num_cuenta, nombre,direccion, id_actividad, "+
		            "email, telefono, link,latitud,longitud,banco,persona_contacto,cif,visible,aprobado) "+
		            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,false)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNum_cuenta(), p.getNombre(),
			p.getDireccion(), p.getId_actividad().getId(), p.getEmail(), p.getTelefono(), p.getLink(), 
                        p.getLatitud(), p.getLongitud(),p.getBanco(),p.getPersona_contacto(),p.getCif(),p.getVisible()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }

    @Override
    public String upd(proveedores p) {
        String sql = "UPDATE proveedores "+
                    "SET num_cuenta=?,nombre=?, "+
                    "direccion=?, id_actividad=?, "+
                    "email=?, telefono=?, link=?,latitud=?,longitud=?,banco=?,persona_contacto=?,cif=?,visible=? "+
                    "WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNum_cuenta(),p.getNombre(),p.getDireccion(),p.getId_actividad().getId(),
        p.getEmail(),p.getTelefono(),p.getLink(),p.getLatitud(),p.getLongitud(),p.getBanco(),p.getPersona_contacto(),p.getCif(),p.getVisible(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String update(proveedores p) {
        String sql = "UPDATE proveedores "+
			"SET num_cuenta=?,nombre=?,nombrefoto=?, "+
			"direccion=?, id_actividad=?, "+
			"email=?, telefono=?, link=?,latitud=?,longitud=?,banco=?,persona_contacto=?,cif=?,visible=? "+
			"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNum_cuenta(),p.getNombre(), p.getNombreFoto(),
			p.getDireccion(), p.getId_actividad().getId(), p.getEmail(), p.getTelefono(), p.getLink(), 
                        p.getLatitud(), p.getLongitud(),p.getBanco(),p.getPersona_contacto(),p.getCif(),p.getVisible(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String updateSinImagen(proveedores p) {
        String sql = "UPDATE proveedores "+
			"SET num_cuenta=?,nombre=?, "+
			"direccion=?, id_actividad=?, "+
			"email=?, telefono=?, link=?,banco=?,persona_contacto=?,cif=?,visible=? "+
			"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNum_cuenta(),p.getNombre(),
			p.getDireccion(), p.getId_actividad().getId(), p.getEmail(), p.getTelefono(), p.getLink(),p.getBanco(),p.getPersona_contacto(),p.getCif(),p.getVisible(), p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String delete(int id) {
        String sql = "DELETE FROM proveedores WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String estadoCalificasion(proveedores p) {
        String sql = "UPDATE proveedores "+
			"SET estadocalificado=? "+
			"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getEstadoCalificado(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateImagen(proveedores p) {
    String sql = "UPDATE proveedores SET nombrefoto=? WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreFoto(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateAprobado(int id) {
    String sql = "UPDATE proveedores SET aprobado=true WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateDesaprobado(int id) {
    String sql = "UPDATE proveedores SET aprobado=false WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public void guardarImagenProveedor(String num_cuenta) {
        String sql = "SELECT foto,nombrefoto FROM proveedores where id=?";
        this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{num_cuenta},new RowMapper<Object>(){
        @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                try {
                if(rs.getBytes("foto")!=null){
                    imgBytes = rs.getBytes("foto"); 
                    FileOutputStream fileOuputStream;
                    
                        fileOuputStream = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\Seleccion\\imagenesproveedor\\"+rs.getString(2));
                    
	               
	            fileOuputStream.write(imgBytes);
	            fileOuputStream.close();
	         
                      //String img="sun.jpg";
	            InputStream in = new ByteArrayInputStream(rs.getBytes(1));
	        	   
	            BufferedImage image = ImageIO.read(in);
	            System.out.println("image"+image);
                }
                
	        	  
                }catch(Exception exc){
                }
               return null; 
            }
        });
        
    }
     @Override
    public String UpdateContrato(Date fechaContrato,int id) {
    String sql = "UPDATE proveedores SET fechacontrato=? WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{fechaContrato,id});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
   public boolean updvisible(proveedores p){
    String sql = "UPDATE proveedores SET visible=? WHERE id=?";
    
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getVisible(),p.getId()});
        boolean rpta=false;
        if(c>0){
            rpta=true;
        }
        return rpta;
    }
}
