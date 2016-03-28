/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.beans.subcapitulos;
import com.intranet.dao.CapituloDAO;
import com.intranet.dao.SubCapitulosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("subCapitulosDAO")
public class ISubCapitulosDAO extends UtilTemplateDAO implements SubCapitulosDAO{

    @Autowired(required = true)
    CapituloDAO capituloDAO;
    
    @Override
    public List<subcapitulos> findAll(String buscar) {
        String sql = "SELECT id,nombre,cantidad,tipo,id_capitulo,cod,nota FROM subcapitulos ";
        List<subcapitulos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<subcapitulos>(){
        @Override
            public subcapitulos mapRow(ResultSet rs, int i) throws SQLException {
                subcapitulos e = new subcapitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCantidad(rs.getFloat("cantidad"));
                if(rs.getString("tipo").isEmpty()) e.setTipo("-");
	        else e.setTipo(rs.getString("tipo"));
                int idC=rs.getInt("id_capitulo");
                try {
                    capitulos cu=capituloDAO.porId(idC);
                    e.setId_capitulo(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(rs.getString("cod")==null) e.setCod("-");
	        else e.setCod(rs.getString("cod"));
                
	        if(rs.getString("nota")==null) e.setNota("-");
	        else e.setNota(rs.getString("nota"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public List<subcapitulos> listaPorCapitulo(int idCapitulo) {
        String sql = "SELECT id,nombre,cantidad,tipo,id_capitulo,cod,nota FROM subcapitulos where id_capitulo=?";
        List<subcapitulos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idCapitulo},new RowMapper<subcapitulos>(){
        @Override
            public subcapitulos mapRow(ResultSet rs, int i) throws SQLException {
                subcapitulos e = new subcapitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCantidad(rs.getFloat("cantidad"));
                if(rs.getString("tipo").isEmpty()) e.setTipo("-");
	        else e.setTipo(rs.getString("tipo"));
                int idC=rs.getInt("id_capitulo");
                try {
                    capitulos cu=capituloDAO.porId(idC);
                    e.setId_capitulo(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(rs.getString("cod")==null) e.setCod("-");
	        else e.setCod(rs.getString("cod"));
                
	        if(rs.getString("nota")==null) e.setNota("-");
	        else e.setNota(rs.getString("nota"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public List<subcapitulos> filtro(int idCapitulo) {
        String sql = "SELECT id,nombre,cantidad,tipo,id_capitulo,cod,nota FROM subcapitulos where id_capitulo=?";
        List<subcapitulos> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idCapitulo},new RowMapper<subcapitulos>(){
        @Override
            public subcapitulos mapRow(ResultSet rs, int i) throws SQLException {
                subcapitulos e = new subcapitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCantidad(rs.getFloat("cantidad"));
                if(rs.getString("tipo").isEmpty()) e.setTipo("-");
	        else e.setTipo(rs.getString("tipo"));
                int idC=rs.getInt("id_capitulo");
                try {
                    capitulos cu=capituloDAO.porId(idC);
                    e.setId_capitulo(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(rs.getString("cod")==null) e.setCod("-");
	        else e.setCod(rs.getString("cod"));
                
	        if(rs.getString("nota")==null) e.setNota("-");
	        else e.setNota(rs.getString("nota"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public subcapitulos porCapitulo(int idCapitulo, int id) {
        String sql = "SELECT id,nombre,cantidad,tipo,id_capitulo,cod,nota FROM subcapitulos where id_capitulo="+idCapitulo+" and id="+id;
        subcapitulos e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<subcapitulos>(){
        @Override
            public subcapitulos mapRow(ResultSet rs, int i) throws SQLException {
                subcapitulos e = new subcapitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCantidad(rs.getFloat("cantidad"));
                if(rs.getString("tipo").isEmpty()) e.setTipo("-");
	        else e.setTipo(rs.getString("tipo"));
                int idC=rs.getInt("id_capitulo");
                try {                                                                                                                                           
                    capitulos cu=capituloDAO.porId(idC);
                    e.setId_capitulo(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(rs.getString("cod")==null) e.setCod("-");
	        else e.setCod(rs.getString("cod"));
                
	        if(rs.getString("nota")==null) e.setNota("-");
	        else e.setNota(rs.getString("nota"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public subcapitulos porId(int id) {
        String sql = "SELECT id,nombre,cantidad,tipo,id_capitulo,cod,nota FROM subcapitulos where id=?";
        subcapitulos e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<subcapitulos>(){
        @Override
            public subcapitulos mapRow(ResultSet rs, int i) throws SQLException {
                subcapitulos e = new subcapitulos();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCantidad(rs.getFloat("cantidad"));
                if(rs.getString("tipo").isEmpty()) e.setTipo("-");
	        else e.setTipo(rs.getString("tipo"));
                int idC=rs.getInt("id_capitulo");
                try {
                    capitulos cu=capituloDAO.porId(idC);
                    e.setId_capitulo(cu);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(rs.getString("cod")==null) e.setCod("-");
	        else e.setCod(rs.getString("cod"));
                
	        if(rs.getString("nota")==null) e.setNota("-");
	        else e.setNota(rs.getString("nota"));
                return e;
        }
        });
        
        return e;
    }

    @Override
    public boolean existe(String cod) {
        String sql = "SELECT count(*)as c FROM subcapitulos WHERE cod=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{cod},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public boolean existeU(subcapitulos s) {
        String sql = "SELECT count(*)as c FROM subcapitulos WHERE id!="+s.getId()+" and cod='"+s.getCod()+"'";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("c");
                return t;
        }
        });
    }

    @Override
    public String Insert(subcapitulos subcap) {
        String sql = "INSERT INTO subcapitulos(nombre,cantidad,tipo,id_capitulo,cod,nota) VALUES(?,?,?,?,?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{subcap.getNombre(),subcap.getCantidad(),subcap.getTipo(),
        subcap.getId_capitulo().getId(),subcap.getCod(),subcap.getNota()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(subcapitulos subcap) {
        String sql = "UPDATE subcapitulos SET nombre=?,cantidad=?,tipo=?,id_capitulo=?,cod=?,nota=? WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{subcap.getNombre(),subcap.getCantidad(),subcap.getTipo(),
        subcap.getId_capitulo().getId(),subcap.getCod(),subcap.getNota(),subcap.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM  subcapitulos WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
