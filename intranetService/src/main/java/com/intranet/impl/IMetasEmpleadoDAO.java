/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.metasEmpleado;
import com.intranet.dao.MetasEmpleadoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("metasEmpleadoDAO")
public class IMetasEmpleadoDAO extends UtilTemplateDAO implements MetasEmpleadoDAO {
    @Override
    public List<metasEmpleado> findAllNif(String nif) {
        String sql = "SELECT id, nif_empleado, numvisitas, num_presupuesto, num_contratos,importe, mes, m1, m2, m3, m4, anio FROM metasempleado WHERE nif_empleado=?";
        List<metasEmpleado> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<metasEmpleado>(){
        @Override
            public metasEmpleado mapRow(ResultSet rs, int i) throws SQLException {
                metasEmpleado e = new metasEmpleado();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNumvisitas(rs.getInt("numvisitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                e.setMes(rs.getInt("mes"));
                e.setAnio(rs.getInt("anio"));
                e.setMeta1(rs.getInt("m1"));
                e.setMeta2(rs.getInt("m2"));
                e.setMeta3(rs.getInt("m3"));
                e.setMeta4(rs.getDouble("m4"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public metasEmpleado ById(int id) {
        String sql = "SELECT id, nif_empleado, numvisitas, num_presupuesto, num_contratos,importe, mes, m1, m2, m3, m4, anio FROM metasempleado WHERE id=?";
        metasEmpleado est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<metasEmpleado>(){
        @Override
            public metasEmpleado mapRow(ResultSet rs, int i) throws SQLException {
                metasEmpleado e = new metasEmpleado();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNumvisitas(rs.getInt("numvisitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                e.setMes(rs.getInt("mes"));
                e.setAnio(rs.getInt("anio"));
                e.setMeta1(rs.getInt("m1"));
                e.setMeta2(rs.getInt("m2"));
                e.setMeta3(rs.getInt("m3"));
                e.setMeta4(rs.getDouble("m4"));
                return e;
        }
        });
        
        return est;
    }
    @Override
    public metasEmpleado ByNif(String nif, int mes, int anio) {
        String sql = "SELECT id, nif_empleado, numvisitas, num_presupuesto, num_contratos,importe, mes, m1, m2, m3, m4, anio FROM metasempleado WHERE nif_empleado=? and anio=? and mes=? ";
        metasEmpleado est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif,anio,mes},new RowMapper<metasEmpleado>(){
        @Override
            public metasEmpleado mapRow(ResultSet rs, int i) throws SQLException {
                metasEmpleado e = new metasEmpleado();
                e.setId(rs.getInt("id"));
                e.setNif_empleado(rs.getString("nif_empleado"));
                e.setNumvisitas(rs.getInt("numvisitas"));
                e.setNum_presupuesto(rs.getInt("num_presupuesto"));
                e.setNum_contratos(rs.getInt("num_contratos"));
                e.setImporte(rs.getDouble("importe"));
                e.setMes(rs.getInt("mes"));
                e.setAnio(rs.getInt("anio"));
                e.setMeta1(rs.getInt("m1"));
                e.setMeta2(rs.getInt("m2"));
                e.setMeta3(rs.getInt("m3"));
                e.setMeta4(rs.getDouble("m4"));
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public metasEmpleado ByNifHome(String nif, int mes, int anio) {
        String sql = "select count(*)as c from agenda_supervisor_empleado where nif_empleado=? and condicion=3 and tipotarea='Visita' and estado='SI' and to_char(to_date(ffin, 'MM/dd/yyyy') ,'yyyy')=to_char(now(),'yyyy') and to_char(to_date(ffin, 'MM/dd/yyyy'),'MM')=to_char(now(),'MM')";
        int numVisitas =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("c");
                return e;
        }
        });
        String sql2 = "select count(distinct pre.propuesta_id)as c from presupuestoc pre inner join propuesta p on(pre.propuesta_id=p.id) where p.empleado_nif=? and pre.estadoenviado=1 and to_char(pre.fecha,'yyyy')=to_char(now(),'yyyy') and to_char(pre.fecha,'MM')=to_char(now(),'MM')";
        int numPresupuesto =this.getJdbcTemplate().queryForObject(sql2, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("c");
                return e;
        }
        });
        String sql3 = "select count(*)as c from propuesta where empleado_nif=? and estado=2 and to_char(fechaproyecto,'yyyy')=to_char(now(),'yyyy') and to_char(fechaproyecto,'MM')=to_char(now(),'MM')";
        int numContrato =this.getJdbcTemplate().queryForObject(sql3, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer e = rs.getInt("c");
                return e;
        }
        });
         String sql4 = "select sum(pc.monto_semana) as c "+
                "from proyecto_certificaciones pc "+
                "inner join proyecto_presupuesto pp on(pc.id_proyecto_presupuesto=pp.id) "+
                "inner join presupuesto pre on(pp.id_presupuesto=pre.id) inner join presupuestoc precap on(pre.presup_id=precap.id) "+
                "inner join propuesta pro on(precap.propuesta_id=pro.id)  "+
                "where pro.empleado_nif=? and to_char(pc.fecha,'yyyy')=to_char(now(),'yyyy') and to_char(pc.fecha,'MM')=to_char(now(),'MM') ";
        Double Importe =this.getJdbcTemplate().queryForObject(sql4, 
                new Object[]{nif},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double e = rs.getDouble("c");
                return e;
        }
        });
        metasEmpleado m=new metasEmpleado();
        m.setNumvisitas(numVisitas);
        m.setNum_presupuesto(numPresupuesto);
        m.setNum_contratos(numContrato);
        m.setImporte(Importe);
        return m;
    }
    @Override
    public boolean Insert(metasEmpleado cont) {
        String sql = "INSERT INTO metasempleado(nif_empleado, numvisitas, num_presupuesto, num_contratos,importe, mes, m1, m2, m3, m4, anio) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado(),cont.getNumvisitas(),cont.getNum_presupuesto(),cont.getNum_contratos(),cont.getImporte(),
        cont.getMes(),cont.getMeta1(),cont.getMeta2(),cont.getMeta3(),cont.getMeta4(),cont.getAnio()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    @Override
    public boolean Update(metasEmpleado cont) {
        String sql = "UPDATE metasempleado SET numvisitas=?, num_presupuesto=?, num_contratos=?,importe=?,  m1=?, m2=?, m3=?, m4=? where nif_empleado=? and anio=? and mes=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNumvisitas(),cont.getNum_presupuesto(),cont.getNum_contratos(),cont.getImporte(),
        cont.getMeta1(),cont.getMeta2(),cont.getMeta3(),cont.getMeta4(),cont.getNif_empleado(),cont.getAnio(),cont.getMes()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    
}
