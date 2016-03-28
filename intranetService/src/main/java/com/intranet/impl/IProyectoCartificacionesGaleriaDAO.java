/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.proyecto_certificaciones;
import com.intranet.beans.proyecto_certificaciones_galeria;
import com.intranet.dao.ProyectoCartificacionesGaleriaDAO;
import com.intranet.dao.ProyectoCertificacionesDAO;
import com.intranet.util.UtilTemplateDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proyectoCartificacionesGaleriaDAO")
public class IProyectoCartificacionesGaleriaDAO extends UtilTemplateDAO implements ProyectoCartificacionesGaleriaDAO{
    byte[] imgBytes = null;
    
    @Autowired(required = true)
    ProyectoCertificacionesDAO proyectoCertificacionesDAO;
    
    @Override
    public List<proyecto_certificaciones_galeria> lista(int id) {
        String sql = "SELECT id, id_proyecto_certificaciones, nombreimg,fecha "+
	"FROM proyecto_certificaciones_galeria where id_proyecto_certificaciones=? ";
        List<proyecto_certificaciones_galeria> est =this.getJdbcTemplate().query(sql, 
                new Object[]{id},new RowMapper<proyecto_certificaciones_galeria>(){
        @Override
            public proyecto_certificaciones_galeria mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones_galeria e = new proyecto_certificaciones_galeria();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_certificaciones");
                try {
                    proyecto_certificaciones cu=proyectoCertificacionesDAO.porId(idC);
                    e.setId_proyecto_certificaciones(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                e.setFecha(rs.getDate("fecha"));
                return e;
        }
        });
        
        return est;
    }

    
    @Override
    public List<proyecto_certificaciones_galeria> listaProyecto(int id) {
        String sql = "SELECT pg.id, pg.id_proyecto_certificaciones, pg.nombreimg,pg.fecha " +
            "FROM proyecto_certificaciones_galeria pg  where pg.idpropuesta=? ";
        List<proyecto_certificaciones_galeria> est =this.getJdbcTemplate().query(sql, 
                new Object[]{id},new RowMapper<proyecto_certificaciones_galeria>(){
        @Override
            public proyecto_certificaciones_galeria mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones_galeria e = new proyecto_certificaciones_galeria();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_certificaciones");
                try {
                    proyecto_certificaciones cu=proyectoCertificacionesDAO.porId(idC);
                    e.setId_proyecto_certificaciones(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                e.setFecha(rs.getDate("fecha"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public proyecto_certificaciones_galeria porId(int id) {
        String sql = "SELECT id, id_proyecto_certificaciones, nombreimg,fecha "+
	"FROM proyecto_certificaciones_galeria where id=? ";
        proyecto_certificaciones_galeria est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proyecto_certificaciones_galeria>(){
        @Override
            public proyecto_certificaciones_galeria mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones_galeria e = new proyecto_certificaciones_galeria();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_certificaciones");
                try {
                    proyecto_certificaciones cu=proyectoCertificacionesDAO.porId(idC);
                    e.setId_proyecto_certificaciones(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                e.setFecha(rs.getDate("fecha"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public proyecto_certificaciones_galeria porIdNombre(String nombre) {
        String sql = "SELECT id, id_proyecto_certificaciones, nombreimg,fecha "+
	"FROM proyecto_certificaciones_galeria where nombreimg like'?' ";
        proyecto_certificaciones_galeria est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nombre},new RowMapper<proyecto_certificaciones_galeria>(){
        @Override
            public proyecto_certificaciones_galeria mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_certificaciones_galeria e = new proyecto_certificaciones_galeria();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_certificaciones");
                try {
                    proyecto_certificaciones cu=proyectoCertificacionesDAO.porId(idC);
                    e.setId_proyecto_certificaciones(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNombreimg(rs.getString(3));
                e.setRuta("../galeriaSeguimientoProyecto/"+e.getNombreimg());
                e.setFecha(rs.getDate("fecha"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public boolean existe(String nombreimg) {
        String sql = "SELECT count(*)as c "+
	"FROM proyecto_certificaciones_galeria where nombreimg=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nombreimg},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public String insertar(proyecto_certificaciones_galeria p) {
        String sql = "INSERT INTO proyecto_certificaciones_galeria("+
	"id_proyecto_certificaciones, nombreimg,fecha)"+
	"VALUES (?, ?,current_date)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getId_proyecto_certificaciones().getId(),p.getNombreimg(),p.getFecha()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
     @Override
    public String insertar2(proyecto_certificaciones_galeria p) {
        String sql = "INSERT INTO proyecto_certificaciones_galeria("+
	"idpropuesta, nombreimg,fecha)"+
	"VALUES (?, ?,current_date)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getIdPropuesta(),p.getNombreimg()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String update(proyecto_certificaciones_galeria p) {
        String sql = "UPDATE proyecto_certificaciones_galeria "+
	"SET nombreimg=? "+
	"WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{p.getNombreimg(),p.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String eliminar(int id) {
        String sql = "DELETE FROM proyecto_certificaciones_galeria  WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public void guardarImagenProveedor(int id) {
        String sql = "SELECT img,nombreimg FROM proyecto_certificaciones_galeria where id=?";
        this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<Object>(){
        @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                try {
                if(rs.getBytes("img")!=null){
                    imgBytes = rs.getBytes("img"); 
                    FileOutputStream fileOuputStream;
                    
                        fileOuputStream = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\Seleccion\\galeriaSeguimientoProyecto\\"+rs.getString(2));
                    
	               
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
    
}
