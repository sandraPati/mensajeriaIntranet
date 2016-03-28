/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.futuro_empleo;
import com.intranet.dao.FuturoEmpleoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("futuroEmpleoDAO")
public class IFuturoEmpleoDAO extends UtilTemplateDAO implements FuturoEmpleoDAO{

    @Override
    public List<futuro_empleo> findAll(String nif) {
        String sql = "SELECT id,postulante_doc_identidad, puesto, cambiar_residencia, destinos, espectativas_salariales_minimo, salario_deseado, buscas_trabajo, viajar, jornada_laboral_preferida," +
                    "tipo_contrato FROM futuro_empleo WHERE postulante_doc_identidad=?";
        List<futuro_empleo> e =this.getJdbcTemplate().query(sql, 
                new Object[]{nif}, new RowMapper<futuro_empleo>(){
        @Override
            public futuro_empleo mapRow(ResultSet rs, int i) throws SQLException {
                futuro_empleo e=new futuro_empleo();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setPuesto(rs.getString("puesto"));
                e.setCambiar_residencia(rs.getString("cambiar_residencia"));
                e.setDestinos(rs.getString("destinos"));
                e.setExpectativas_salariales_minimo(rs.getString("espectativas_salariales_minimo"));
                e.setSalario_deseado(rs.getString("salario_deseado"));
                e.setBuscas_trabajo(rs.getString("buscas_trabajo"));
                e.setViajar(rs.getString("viajar"));
                e.setJornada_laboral_preferida(rs.getString("jornada_laboral_preferida"));
                e.setTipo_contrato(rs.getString("tipo_contrato"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public futuro_empleo porPostulante(String nif) {
        String sql = "SELECT id,postulante_doc_identidad, puesto, cambiar_residencia, destinos, espectativas_salariales_minimo, salario_deseado, buscas_trabajo, viajar, jornada_laboral_preferida," +
                "tipo_contrato FROM futuro_empleo WHERE postulante_doc_identidad=?";
        futuro_empleo e =(futuro_empleo)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<futuro_empleo>(){
        @Override
            public futuro_empleo mapRow(ResultSet rs, int i) throws SQLException {
                futuro_empleo e=new futuro_empleo();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setPuesto(rs.getString("puesto"));
                e.setCambiar_residencia(rs.getString("cambiar_residencia"));
                e.setDestinos(rs.getString("destinos"));
                e.setExpectativas_salariales_minimo(rs.getString("espectativas_salariales_minimo"));
                e.setSalario_deseado(rs.getString("salario_deseado"));
                e.setBuscas_trabajo(rs.getString("buscas_trabajo"));
                e.setViajar(rs.getString("viajar"));
                e.setJornada_laboral_preferida(rs.getString("jornada_laboral_preferida"));
                e.setTipo_contrato(rs.getString("tipo_contrato"));
                return e;
        }
        });
        
        
        return e;
    }

    @Override
    public futuro_empleo porNif(String nif) {
        String sql = "SELECT id,postulante_doc_identidad, puesto, cambiar_residencia, destinos, espectativas_salariales_minimo, salario_deseado, buscas_trabajo, viajar, jornada_laboral_preferida," +
                "tipo_contrato FROM futuro_empleo WHERE postulante_doc_identidad=?";
        futuro_empleo e =(futuro_empleo)this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif}, new RowMapper<futuro_empleo>(){
        @Override
            public futuro_empleo mapRow(ResultSet rs, int i) throws SQLException {
                futuro_empleo e=new futuro_empleo();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                e.setPuesto(rs.getString("puesto"));
                e.setCambiar_residencia(rs.getString("cambiar_residencia"));
                e.setDestinos(rs.getString("destinos"));
                e.setExpectativas_salariales_minimo(rs.getString("espectativas_salariales_minimo"));
                e.setSalario_deseado(rs.getString("salario_deseado"));
                e.setBuscas_trabajo(rs.getString("buscas_trabajo"));
                e.setViajar(rs.getString("viajar"));
                e.setJornada_laboral_preferida(rs.getString("jornada_laboral_preferida"));
                e.setTipo_contrato(rs.getString("tipo_contrato"));
                return e;
        }
        });
        
        
        return e;
    }

    @Override
    public boolean existeFEP(String nif) {
        String sql = "SELECT count(*)as existe FROM futuro_empleo WHERE postulante_doc_identidad=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("existe");
                return t;
        }
        });
    }

    @Override
    public String Insert(futuro_empleo cap) {
        String rpta="";
        if(cap.getBuscas_trabajo()!=null){
        if(cap.getPuesto()!=null){
	if(cap.getCambiar_residencia()==null)cap.setCambiar_residencia("NO");
	if(cap.getDestinos()==null)cap.setDestinos("");
	if(cap.getViajar()==null)cap.setViajar("Mala");
	if(cap.getJornada_laboral_preferida()==null)cap.setJornada_laboral_preferida("Indiferente");
	if(cap.getTipo_contrato()==null)cap.setTipo_contrato("Indiferente");
	if(cap.getExpectativas_salariales_minimo()!=null && cap.getSalario_deseado()!=null){
	if(cap.getCambiar_residencia()==null)cap.setCambiar_residencia("NO");
	         
        String sql = "INSERT INTO futuro_empleo(" +
                "puesto, cambiar_residencia, destinos, espectativas_salariales_minimo, " +
                "salario_deseado, buscas_trabajo, viajar, jornada_laboral_preferida," +
                "tipo_contrato, postulante_doc_identidad) " +
                "VALUES (upper(?), ?, upper(?), ?, ?, ?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPuesto(),cap.getCambiar_residencia(),cap.getDestinos(),Integer.parseInt(cap.getExpectativas_salariales_minimo()),
        Integer.parseInt(cap.getSalario_deseado()),cap.getBuscas_trabajo(),cap.getViajar(),cap.getJornada_laboral_preferida(),cap.getTipo_contrato(),
        cap.getPostulante_doc_identidad()});
         rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        }
        }
        }
        return rpta;
    }

    @Override
    public String Update(futuro_empleo cap) {
        String rpta="";
        if(cap.getBuscas_trabajo()!=null){
        if(cap.getPuesto()!=null){
	if(cap.getCambiar_residencia()==null)cap.setCambiar_residencia("NO");
	if(cap.getDestinos()==null)cap.setDestinos("");
	if(cap.getViajar()==null)cap.setViajar("Mala");
	if(cap.getJornada_laboral_preferida()==null)cap.setJornada_laboral_preferida("Indiferente");
	if(cap.getTipo_contrato()==null)cap.setTipo_contrato("Indiferente");
	if(cap.getExpectativas_salariales_minimo()!=null && cap.getSalario_deseado()!=null){
	if(cap.getCambiar_residencia()==null)cap.setCambiar_residencia("NO");
	   
        String sql = "UPDATE futuro_empleo " +
                "SET puesto=upper(?), cambiar_residencia=?, destinos=upper(?), espectativas_salariales_minimo=?, " +
                "salario_deseado=?, buscas_trabajo=?, viajar=?, jornada_laboral_preferida=?," +
                "tipo_contrato=? " +
                "WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cap.getPuesto(),cap.getCambiar_residencia(),cap.getDestinos(),Integer.parseInt(cap.getExpectativas_salariales_minimo()),
        Integer.parseInt(cap.getSalario_deseado()),cap.getBuscas_trabajo(),cap.getViajar(),cap.getJornada_laboral_preferida(),cap.getTipo_contrato(),
        cap.getId()});
        
         rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        }
        }
        }
        System.out.println(""+rpta);
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM futuro_empleo WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    private static final class EMapper implements RowMapper {
        
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            futuro_empleo e = new futuro_empleo();
            e.setId(rs.getInt("id"));
            e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
            e.setPuesto(rs.getString("puesto"));
            e.setCambiar_residencia(rs.getString("cambiar_residencia"));
            e.setDestinos(rs.getString("destinos"));
            e.setExpectativas_salariales_minimo(rs.getString("espectativas_salariales_minimo"));
            e.setSalario_deseado(rs.getString("salario_deseado"));
            e.setBuscas_trabajo(rs.getString("buscas_trabajo"));
            e.setViajar(rs.getString("viajar"));
            e.setJornada_laboral_preferida(rs.getString("jornada_laboral_preferida"));
            e.setTipo_contrato(rs.getString("tipo_contrato"));
            
            return e;
        }
    }
    
}
