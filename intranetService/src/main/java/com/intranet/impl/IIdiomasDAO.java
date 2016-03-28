/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.idiomas;
import com.intranet.beans.tipoidioma;
import com.intranet.dao.PostulanteDAO;
import com.intranet.dao.IdiomasDAO;
import com.intranet.dao.TipoIdiomaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("idiomasDAO")
public class IIdiomasDAO extends UtilTemplateDAO implements IdiomasDAO{
    
    @Autowired(required = true)
    PostulanteDAO postulanteDAO;
    @Autowired(required = true)
    TipoIdiomaDAO tipoIdiomaDAO;
    
    @Override
    public List<idiomas> findAll(String nif) {
        String sql = "SELECT id,postulante_doc_identidad, idioma_id, nivel_hablado, nivel_escrito,nivel_leido FROM idiomas WHERE postulante_doc_identidad=?";
        List<idiomas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<idiomas>(){
        @Override
            public idiomas mapRow(ResultSet rs, int i) throws SQLException {
                idiomas e = new idiomas();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("idioma_id");
                try {
                    tipoidioma cu=tipoIdiomaDAO.porId(idC);
                    e.setTipoidioma_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNivelhablado(rs.getString(4));
	        e.setNivelescrito(rs.getString(5));
	        e.setNivelleido(rs.getString(6));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public idiomas porId(int id) {
        String sql = "SELECT id,postulante_doc_identidad, idioma_id, nivel_hablado, nivel_escrito,nivel_leido FROM idiomas where id=?";
        idiomas est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<idiomas>(){
        @Override
            public idiomas mapRow(ResultSet rs, int i) throws SQLException {
                idiomas e = new idiomas();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("idioma_id");
                try {
                    tipoidioma cu=tipoIdiomaDAO.porId(idC);
                    e.setTipoidioma_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNivelhablado(rs.getString(4));
	        e.setNivelescrito(rs.getString(5));
	        e.setNivelleido(rs.getString(6));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public idiomas porNIF(String nif) {
        String sql = "SELECT id,postulante_doc_identidad, idioma_id, nivel_hablado, nivel_escrito,nivel_leido FROM idiomas where postulante_doc_identidad=?";
        idiomas est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<idiomas>(){
        @Override
            public idiomas mapRow(ResultSet rs, int i) throws SQLException {
                idiomas e = new idiomas();
                e.setId(rs.getInt("id"));
                e.setPostulante_doc_identidad(rs.getString("postulante_doc_identidad"));
                int idC=rs.getInt("idioma_id");
                try {
                    tipoidioma cu=tipoIdiomaDAO.porId(idC);
                    e.setTipoidioma_id(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setNivelhablado(rs.getString(4));
	        e.setNivelescrito(rs.getString(5));
	        e.setNivelleido(rs.getString(6));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String Insert(idiomas idio) {
        String sql = "INSERT INTO idiomas(postulante_doc_identidad, idioma_id, nivel_hablado, nivel_escrito, nivel_leido) VALUES (?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{idio.getPostulante_doc_identidad(),
        idio.getTipoidioma_id().getId(),idio.getNivelhablado(),idio.getNivelescrito(),idio.getNivelleido()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(idiomas idio) {
        String sql = "UPDATE idiomas SET idioma_id=?, nivel_hablado=?,nivel_escrito=?, nivel_leido=? "+
	"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{idio.getTipoidioma_id().getId(),idio.getNivelhablado(),idio.getNivelescrito(),idio.getNivelleido(),
        idio.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM idiomas "+
	"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    
}
