/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.TareaPersonal;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.TareaPersonalDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tareaPersonalDAO")
public class ITareaPersonalDAO extends UtilTemplateDAO implements TareaPersonalDAO{
    
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    
    @Override
    public List<TareaPersonal> getTareas(String nif) {
        String sql = "SELECT id, nif_empleado, descripcion, finicio, ffin, ccabecera, contenido, estado FROM agenda_personal WHERE nif_empleado=?";
        List<TareaPersonal> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<TareaPersonal>(){
        @Override
            public TareaPersonal mapRow(ResultSet rs, int i) throws SQLException {
                TareaPersonal e = new TareaPersonal();
                e.setId(rs.getInt("id"));
                e.setNifempleado(rs.getString("nif_empleado"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setFinicio(rs.getString("finicio"));
                e.setFfin(rs.getString("ffin"));
                e.setCcabecera(rs.getString("ccabecera"));
                e.setCcontenido(rs.getString("contenido"));
                e.setEstado(rs.getString("estado"));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String insertTarea(TareaPersonal t) {
        String sql = "INSERT INTO agenda_personal("+
            "nif_empleado, descripcion, finicio, ffin, ccabecera, contenido,"+ 
            "estado)"+
            "VALUES (?, ?, ?, ?, ?, ?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getNifempleado(), t.getDescripcion(),
            t.getFinicio(), t.getFfin(), t.getCcabecera(), t.getCcontenido(), "SI"});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String updateTarea(TareaPersonal t) {
        String sql = "UPDATE agenda_personal "+
        "SET  descripcion=?, ccabecera=?, contenido=?,"+ 
        "finicio=?, ffin=? "+
        "WHERE id=? and nif_empleado=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getDescripcion(),t.getCcabecera(),t.getCcontenido(),
            t.getFinicio(), t.getFfin(), t.getId(),t.getNifempleado()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String deleteTarea(TareaPersonal t) {
        String sql = 
        "DELETE FROM agenda_personal "+
	"WHERE id=? and nif_empleado=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getId(),t.getNifempleado()});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
