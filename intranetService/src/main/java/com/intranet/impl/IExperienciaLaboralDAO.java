/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.experiencia_laboral;
import com.intranet.dao.ExperienciaLaboralDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("experienciaLaboralDAO")
public class IExperienciaLaboralDAO extends UtilTemplateDAO implements ExperienciaLaboralDAO{

    @Override
    public List<experiencia_laboral> findAll(String nif) {
        String sql = "SELECT id, postulante_doc_identidad, puesto, empresa, trabajando, fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio  FROM experiencia_laboral WHERE postulante_doc_identidad=?";
        List<experiencia_laboral> e =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},  new RowMapper<experiencia_laboral>(){
        @Override
            public experiencia_laboral mapRow(ResultSet rs, int i) throws SQLException {
                experiencia_laboral e=new experiencia_laboral();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setPuesto(rs.getString("puesto"));
                e.setEmpresa(rs.getString("empresa"));
                e.setTrabajando(rs.getBoolean("trabajando"));
                e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
                e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
                e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
                e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
                e.setFecha_inicio(""+rs.getString("fecha_inicio_mes")+" / "+rs.getString("fecha_inicio_anio"));
                e.setFecha_fin(""+rs.getString("fecha_fin_mes")+" / "+rs.getString("fecha_fin_anio"));
                if(e.getTrabajando()==true) e.setTrabajandoM("Trabajando");
                else e.setTrabajandoM("");
                return e;
        }
        });
        
        return e;
    }

    @Override
    public experiencia_laboral porNif(int id) {
        String sql = "SELECT id, postulante_doc_identidad, puesto, empresa, trabajando, fecha_inicio_mes, fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio  FROM experiencia_laboral WHERE id=?";
        experiencia_laboral e =(experiencia_laboral)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<experiencia_laboral>(){
        @Override
            public experiencia_laboral mapRow(ResultSet rs, int i) throws SQLException {
                experiencia_laboral e=new experiencia_laboral();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setPuesto(rs.getString("puesto"));
                e.setEmpresa(rs.getString("empresa"));
                e.setTrabajando(rs.getBoolean("trabajando"));
                e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
                e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
                e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
                e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
                e.setFecha_inicio(""+rs.getString("fecha_inicio_mes")+" / "+rs.getString("fecha_inicio_anio"));
                e.setFecha_fin(""+rs.getString("fecha_fin_mes")+" / "+rs.getString("fecha_fin_anio"));
                if(e.getTrabajando()==true) e.setTrabajandoM("Trabajando");
                else e.setTrabajandoM("");
                return e;
        }
        });
        
        return e;
    }

    @Override
    public String Insert(experiencia_laboral cap) {
        String sql = "INSERT INTO experiencia_laboral(" +
                    "postulante_doc_identidad, puesto, empresa, trabajando, fecha_inicio_mes, " +
                    "fecha_inicio_anio, fecha_fin_mes, fecha_fin_anio)" +
                    "VALUES (?, upper(?), upper(?), ?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPostulante_doc_identidad(),cap.getPuesto(),cap.getEmpresa(),
        cap.getTrabajando(),cap.getFecha_inicio_mes(),cap.getFecha_inicio_anio(),cap.getFecha_fin_mes(),cap.getFecha_fin_anio()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(experiencia_laboral cap) {
        String sql = "UPDATE experiencia_laboral " +
                    "SET puesto=upper(?), empresa=upper(?), trabajando=?, " +
                    "fecha_inicio_mes=?, fecha_inicio_anio=?, fecha_fin_mes=?, fecha_fin_anio=? " +
                    "WHERE id=? and postulante_doc_identidad=?";
        int c=0;
        if(cap.getTrabajando()==true){
            c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPuesto(),cap.getEmpresa(),
           cap.getTrabajando(),cap.getFecha_inicio_mes(),cap.getFecha_inicio_anio(),"","",
           cap.getId(),cap.getPostulante_doc_identidad()});
        }else{
            c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPuesto(),cap.getEmpresa(),
           cap.getTrabajando(),cap.getFecha_inicio_mes(),cap.getFecha_inicio_anio(),cap.getFecha_fin_mes(),cap.getFecha_fin_anio(),
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
        String sql = "DELETE FROM experiencia_laboral WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            experiencia_laboral e = new experiencia_laboral();
            e.setId(rs.getInt("id"));
            e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
            e.setPuesto(rs.getString("puesto"));
            e.setEmpresa(rs.getString("empresa"));
            e.setTrabajando(rs.getBoolean("trabajando"));
            e.setFecha_inicio_mes(rs.getString("fecha_inicio_mes"));
	    e.setFecha_inicio_anio(rs.getString("fecha_inicio_anio"));
	    e.setFecha_fin_mes(rs.getString("fecha_fin_mes"));
	    e.setFecha_fin_anio(rs.getString("fecha_fin_anio"));
            e.setFecha_inicio(""+rs.getString("fecha_inicio_mes")+" / "+rs.getString("fecha_inicio_anio"));
	    e.setFecha_fin(""+rs.getString("fecha_fin_mes")+" / "+rs.getString("fecha_fin_anio"));
	    if(e.getTrabajando()==true) e.setTrabajandoM("Trabajando");
	    else e.setTrabajandoM("");
            return e;
        }
    }
}
