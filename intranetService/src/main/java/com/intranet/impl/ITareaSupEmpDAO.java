/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.dao.ClienteDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.TareaSupEmpDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("tareaSupEmpDAO")
public class ITareaSupEmpDAO extends UtilTemplateDAO implements TareaSupEmpDAO{
    
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    ClienteDAO clienteDAO;
    
    @Override
    public List<TareaSupEmp> getTareasECRecordatorios(String nifs) {
        String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif)  "+
        "WHERE a.nif_supervisor=? and a.condicion=3 and a.fecharecordatorio=current_date ";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifs},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                e.setCliasignado(rs.getString(18));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareasECRecordatoriosE(String nifs) {
        String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif)  "+
        "WHERE a.nif_empleado=? and a.condicion=3 and a.fecharecordatorio=current_date ";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifs},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareasECRecordatoriosC(String nifs) {
        String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif) "+
        "WHERE a.nif_cliente=? and a.condicion=1 and date(a.ffin)>=current_date";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifs},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareasS() {
        String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif) "+
        "WHERE a.nif_supervisor=? and a.condicion=1 ";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareas(String nifs, String nif) {
        String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif)  "+
        " WHERE a.nif_supervisor=? and a.nif_empleado=? and a.condicion=1 ";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nifs,nif},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareasE(String nif) {
        String sql =  "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif) "+
        "  WHERE a.nif_empleado=? and a.condicion=1 ";
        List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<TareaSupEmp> getTareasC(String nif) {
         String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif)  "+
        " WHERE a.nif_cliente=? and a.condicion=1 ";
         List<TareaSupEmp> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                return e;
        }
        });
        
        return est;
    }
 @Override
    public TareaSupEmp porId(int id) {
         String sql = "SELECT a.id, a.nif_supervisor, a.nif_empleado, a.descripcion, a.ccabecera, a.contenido, a.finicio, a.ffin,a.estado,a.nota,a.nif_cliente,a.condicion,a.tipotarea, "+
        "e.nombre as empnombre, e.apellidos as empapellidos, e2.nombre as supnombre,e2.apellidos as supapellidos,a.cliasignado "+
        "FROM agenda_supervisor_empleado a inner join empleados e on(a.nif_empleado=e.nif) inner join empleados e2 on(a.nif_supervisor=e2.nif)  "+
        " WHERE a.id=? and a.condicion=1 ";
         TareaSupEmp est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<TareaSupEmp>(){
        @Override
            public TareaSupEmp mapRow(ResultSet rs, int i) throws SQLException {
                TareaSupEmp e = new TareaSupEmp();
                e.setId(rs.getInt(1));
                e.setNifsupervisor(rs.getString(2));
                e.setNifempleado(rs.getString(3));
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setCcontenido(rs.getString(6));
                e.setFinicio(rs.getString(7));
                e.setFfin(rs.getString(8));
                e.setEstado(rs.getString(9));
                e.setNota(rs.getString(10));
                e.setNifcliente(rs.getString(11));
                e.setCondicion(rs.getInt(12));
                e.setTipotarea_id(rs.getString(13));
                 empleados emp=new empleados();
                emp.setNif(e.getNifempleado());
                emp.setNombre(rs.getString(14));
                emp.setApellidos(rs.getString(15));
                empleados sup=new empleados();
                sup.setNif(e.getNifsupervisor());
                sup.setNombre(rs.getString(16));
                sup.setApellidos(rs.getString(17));
                clientes cli=new clientes();
                cli.setNif(e.getNifcliente());
                cli.setNombre("");
                cli.setApellidos("");
                e.setCli(cli);
		e.setSup(sup);
		e.setEmpl(emp);
                e.setCliasignado(rs.getString(18));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public String insertTarea(TareaSupEmp t) {
        String sql = "INSERT INTO agenda_supervisor_empleado("+
            "nif_supervisor, nif_empleado, descripcion, finicio, ffin, ccabecera, contenido,estado,nota,nif_cliente,tipotarea,cliasignado,condicion"+ 
            ")"+
            "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,1)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getNifsupervisor(), t.getNifempleado(), t.getDescripcion(),
            t.getFinicio(), t.getFfin(), t.getCcabecera(), t.getCcontenido(), t.getEstado(), t.getNota(), t.getNifcliente(), t.getTipotarea_id(),t.getCliasignado()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String updateTarea(TareaSupEmp t) {
        String sql = "UPDATE agenda_supervisor_empleado "+
        "SET  descripcion=?, ccabecera=?, contenido=?,"+ 
        "finicio=?, ffin=?,estado=?,nota=?,tipotarea=?,cliasignado=?,nif_cliente=? "+
        "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getDescripcion(),
            t.getCcabecera(), t.getCcontenido(),t.getFinicio(), t.getFfin(), t.getEstado(), t.getNota(),t.getTipotarea_id(),t.getCliasignado(),t.getNifcliente(),t.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String updateCondicion(TareaSupEmp t) {
        String sql = "UPDATE agenda_supervisor_empleado "+
        "SET  descripcion=?, ccabecera=?, contenido=?,finicio=?, ffin=?,estado=?,nota=?,tipotarea=?,cliasignado=?,nif_cliente=?,condicion=?, fecharecordatorio=(current_date::DATE +3) "+
        "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getDescripcion(),t.getCcabecera(), t.getCcontenido(),t.getFinicio(), t.getFfin(), t.getEstado(), t.getNota(),t.getTipotarea_id(),t.getCliasignado(),t.getNifcliente(),t.getCondicion(),t.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String cerrarRecordatorio(TareaSupEmp t) {
        String sql = "UPDATE agenda_supervisor_empleado "+
        "SET  condicion=4 "+ 
        "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String deleteTarea(TareaSupEmp t) {
        String sql = "DELETE FROM agenda_supervisor_empleado "+
	"WHERE id=? and nif_supervisor=? and nif_empleado=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getId(),t.getNifsupervisor(),t.getNifempleado()});
            String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
