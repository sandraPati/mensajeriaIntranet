/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.cursos;
import com.intranet.beans.estudios;
import com.intranet.dao.CursosDAO;
import com.intranet.dao.EstudiosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("estudiosDAO")
public class IEstudiosDAO extends UtilTemplateDAO implements EstudiosDAO{

    @Autowired(required = true)
    CursosDAO cursosDAO;
    
    @Override
    public List<estudios> findAll(String postulante_doc) {
        String sql = "SELECT id, postulante_doc_identidad, curso_id, fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio,cursando, centro,otro_curso,especificacion_curso  FROM estudios WHERE postulante_doc_identidad=?";
        List<estudios> est =this.getJdbcTemplate().query(sql, 
                new Object[]{postulante_doc},new RowMapper<estudios>(){
        @Override
            public estudios mapRow(ResultSet rs, int i) throws SQLException {
                estudios e = new estudios();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("curso_id");
                try {
                    cursos cu=cursosDAO.porId(idC);
                    e.setCurso_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
                e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
                e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
                e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
                e.setCursando(rs.getBoolean("cursando"));
                e.setCentro(rs.getString("centro"));
                e.setOtro_curso(rs.getString("otro_curso"));
                e.setEspecificacion_curso(rs.getString("especificacion_curso"));
                e.setFecha_inicio(""+e.getFecha_inicio_mes()+" / "+e.getFecha_inicio_anio());
	               e.setFecha_fin(""+e.getFecha_fin_mes()+" / "+e.getFecha_fin_anio());
	               if(e.getCursando()==true)e.setCursandoM("Cursando");
	               else e.setCursandoM("");
                return e;
        }
        });
        
        return est;
    }

    @Override
    public estudios porNif(int id) {
        String sql = "SELECT id, postulante_doc_identidad, curso_id, fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio,cursando, centro,otro_curso,especificacion_curso  FROM estudios WHERE id=?";
        estudios est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<estudios>(){
        @Override
            public estudios mapRow(ResultSet rs, int i) throws SQLException {
                estudios e = new estudios();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("curso_id");
                try {
                    cursos cu=cursosDAO.porId(idC);
                    e.setCurso_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
                e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
                e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
                e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
                e.setCursando(rs.getBoolean("cursando"));
                e.setCentro(rs.getString("centro"));
                e.setOtro_curso(rs.getString("otro_curso"));
                e.setEspecificacion_curso(rs.getString("especificacion_curso"));
                e.setFecha_inicio(""+e.getFecha_inicio_mes()+" / "+e.getFecha_inicio_anio());
	               e.setFecha_fin(""+e.getFecha_fin_mes()+" / "+e.getFecha_fin_anio());
	               if(e.getCursando()==true)e.setCursandoM("Cursando");
	               else e.setCursandoM("");
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public estudios porNifE(String nif) {
        String sql = "SELECT id, postulante_doc_identidad, curso_id, fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio,cursando, centro,otro_curso,especificacion_curso  FROM estudios WHERE postulante_doc_identidad=?";
        estudios est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<estudios>(){
        @Override
            public estudios mapRow(ResultSet rs, int i) throws SQLException {
                estudios e = new estudios();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("curso_id");
                try {
                    cursos cu=cursosDAO.porId(idC);
                    e.setCurso_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
                e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
                e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
                e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
                e.setCursando(rs.getBoolean("cursando"));
                e.setCentro(rs.getString("centro"));
                e.setOtro_curso(rs.getString("otro_curso"));
                e.setEspecificacion_curso(rs.getString("especificacion_curso"));
                e.setFecha_inicio(""+e.getFecha_inicio_mes()+" / "+e.getFecha_inicio_anio());
	               e.setFecha_fin(""+e.getFecha_fin_mes()+" / "+e.getFecha_fin_anio());
	               if(e.getCursando()==true)e.setCursandoM("Cursando");
	               else e.setCursandoM("");
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String Insert(estudios cap) {
        if(cap.getCursando()==null)cap.setCursando(false);
	if(cap.getFecha_fin_anio()==null || cap.getFecha_fin_anio()=="")cap.setFecha_fin_anio("");
	if(cap.getFecha_fin_mes()==null || cap.getFecha_fin_mes()=="")cap.setFecha_fin_mes("");
        if(cap.getCurso_id().getId()==1 || cap.getCurso_id().getId()==2){
	       cap.setOtro_curso(cap.getOtro_curso()); 	
	}else{
	    cap.setOtro_curso("");
	}
        String sql = "INSERT INTO estudios(postulante_doc_identidad, curso_id,fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio, cursando, centro,otro_curso,especificacion_curso) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, upper(?),upper(?),upper(?))";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPostulante_doc_identidad(),cap.getCurso_id().getId(),cap.getFecha_inicio_mes(),
                        cap.getFecha_inicio_anio(),cap.getFecha_fin_mes(),cap.getFecha_fin_anio(),cap.getCursando(),cap.getCentro(),cap.getOtro_curso(),cap.getEspecificacion_curso()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(estudios cap) {
        String sql = "UPDATE estudios SET curso_id=?, fecha_inicio_mes=?,fecha_inicio_anio=?, fecha_fin_mes=?, fecha_fin_anio=?,cursando=?, centro=upper(?),otro_curso=upper(?),especificacion_curso=upper(?) " +
                     "WHERE id=? and postulante_doc_identidad=?";
        int c=0;
        if(cap.getCurso_id().getId()!=1 && cap.getCurso_id().getId()!=2){
            cap.setOtro_curso("");
	}
        if(cap.getCursando()==true){
        
            c=this.getJdbcTemplate().update(sql, new Object[]{cap.getCurso_id().getId(),cap.getFecha_inicio_mes(),
                        cap.getFecha_inicio_anio(),"","",cap.getCursando(),cap.getCentro(),cap.getOtro_curso(),cap.getEspecificacion_curso(),
                        cap.getId(),cap.getPostulante_doc_identidad()});
        }else{
            if(cap.getCurso_id().getId()==1 || cap.getCurso_id().getId()==2){
	       cap.setOtro_curso(cap.getOtro_curso()); 	
            }else{
                cap.setOtro_curso("");
            }
            c=this.getJdbcTemplate().update(sql, new Object[]{cap.getCurso_id().getId(),cap.getFecha_inicio_mes(),
                        cap.getFecha_inicio_anio(),cap.getFecha_fin_mes(),cap.getFecha_fin_anio(),cap.getCursando(),cap.getCentro(),cap.getOtro_curso(),cap.getEspecificacion_curso(),
                        cap.getId(),cap.getPostulante_doc_identidad()});
        
        }
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM estudios WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
