/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.contrato;
import com.intranet.beans.empleados;
import com.intranet.beans.nomina;
import com.intranet.dao.ContratoDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.NominaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("nominaDAO")
public class INominaDAO extends UtilTemplateDAO implements NominaDAO{
    
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    ContratoDAO contratoDAO;
    
    @Override
    public List<nomina> findAll(String a, String m, int cont) {
        String sql = "SELECT n.id, n.nif_empleado, n.mes, n.anio, n.salario_base, n.pagas_extras_prorrateadas,    "
		        + "n.prorrateo_vacaciones, n.gratificaciones_extraordinarias, n.salario_especie,  "
		        + "n.indemnizaciones_suplidos, n.prestaciones_indemnizaciones_ss, n.otras_percepciones_no_salariales,  "
		        + "n.horas_extraordinarias, n.contrato_id,numdias,antiguedad,e.nombre,e.apellidos FROM nomina n inner join empleados e on(n.nif_empleado=e.nif) where contrato_id=? ";
        List<nomina> est =this.getJdbcTemplate().query(sql, 
                new Object[]{cont},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
               /* try {
                            if(idC!=null && idC!=""){
                                empleados cu=empleadoDAO.ByNif(rs.getString(2));
                                e.setNif_empleado(cu);
                            }
                           
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }*/
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
                       e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));
                        int contid=rs.getInt("contrato_id");
                        try {
                            
                            if(contid!=0){
                                String nifE=idC;
                                empleados empl=new empleados();
                                empl.setNif(nifE);
                                empl.setNombre(rs.getString(16));
                                empl.setApellidos(rs.getString(17));
                                contrato tc=new contrato();
                                tc.setId(contid);
                                //contrato tc=contratoDAO.porId(rs.getInt(16));
                                e.setC(tc);
                                e.setNif_empleado(empl);
                            }
                            
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               

                return e;
        }
        });
        
        return est;
    }

    @Override
    public int tieneNominas(int cont) {
        String sql = "select count(*)as c from nomina where contrato_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{cont},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    @Override
    public nomina ById(int id) {
        
        String sql = "SELECT n.id, n.nif_empleado, n.mes, n.anio, n.salario_base, n.pagas_extras_prorrateadas,    "
		        + "n.prorrateo_vacaciones, n.gratificaciones_extraordinarias, n.salario_especie,  "
		        + "n.indemnizaciones_suplidos, n.prestaciones_indemnizaciones_ss, n.otras_percepciones_no_salariales,  "
		        + "n.horas_extraordinarias, n.contrato_id,numdias,antiguedad,e.nombre,e.apellidos FROM nomina n inner join empleados e on(n.nif_empleado=e.nif) where id=? ";
        
        nomina est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt("id"));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                   
                    if(contid!=0){
                                String nifE=idC;
                                empleados empl=new empleados();
                                empl.setNif(nifE);
                                empl.setNombre(rs.getString("nombre"));
                                empl.setApellidos(rs.getString("apellidos"));
                                contrato tc=new contrato();
                                tc.setId(contid);
                                //contrato tc=contratoDAO.porId(rs.getInt(16));
                                e.setC(tc);
                                e.setNif_empleado(empl);
                            }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString("mes"));
	               e.setAnio(rs.getString("anio"));
	               e.setSalario_base(rs.getDouble("salario_base"));
	               e.setPagas_extras_prorrateadas(rs.getDouble("pagas_extras_prorrateadas"));
	               e.setProrrateo_vacaciones(rs.getDouble("prorrateo_vacaciones"));
	               e.setGratificaciones_extraordinarias(rs.getDouble("gratificaciones_extraordinarias"));
	               e.setSalario_especie(rs.getDouble("salario_especie"));
	               e.setIndemnizaciones_suplidos(rs.getDouble("indemnizaciones_suplidos"));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble("prestaciones_indemnizaciones_ss"));
	               e.setOtras_percepciones_no_salariales(rs.getDouble("otras_percepciones_no_salariales"));
	               e.setHoras_extraordinarias(rs.getDouble("horas_extraordinarias"));
	               e.setNumdias(rs.getString("numdias"));
                       e.setAntiguedad(rs.getString("antiguedad"));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<nomina> FiltrarMA(nomina n) {
        String sql = "SELECT id, nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,  "
		        + "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie, "
		        + "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
		        + "horas_extraordinarias,numdias,antiguedad, contrato_id FROM nomina where contrato_id=? and mes like'%?%' and anio like'%?%' ";
        List<nomina> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getC().getId(),n.getMes(),n.getAnio()},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idC);
                    e.setNif_empleado(cu);
                    contrato contt=contratoDAO.porId(contid);
                    e.setC(contt);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
	               e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<nomina> FiltrarM(nomina n) {
        String sql = "SELECT id, nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,  "
		        + "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie, "
		        + "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
		        + "horas_extraordinarias,numdias,antiguedad, contrato_id FROM nomina where contrato_id=? and mes like'%?%' ";
        List<nomina> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getC().getId(),n.getMes()},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idC);
                    e.setNif_empleado(cu);
                    contrato contt=contratoDAO.porId(contid);
                    e.setC(contt);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
	               e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<nomina> FiltrarA(nomina n) {
        String sql = "SELECT id, nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,  "
		        + "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie, "
		        + "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
		        + "horas_extraordinarias,numdias,antiguedad, contrato_id FROM nomina where contrato_id=? and anio like'%?%'";
        List<nomina> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getC().getId(),n.getAnio()},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idC);
                    e.setNif_empleado(cu);
                    contrato contt=contratoDAO.porId(contid);
                    e.setC(contt);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
	               e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<nomina> Filtrar(nomina n) {
        String sql = "SELECT id, nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,  "
		        + "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie, "
		        + "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
		        + "horas_extraordinarias,numdias,antiguedad, contrato_id FROM nomina where contrato_id=?";
        List<nomina> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getC().getId()},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idC);
                    e.setNif_empleado(cu);
                    contrato contt=contratoDAO.porId(contid);
                    e.setC(contt);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
	               e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public nomina UltimoPorEmpleado(String nif) {
        String sql = "SELECT id, nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,  "
	           + "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie, "
	           + "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
	           + "horas_extraordinarias,numdias,antiguedad, contrato_id FROM nomina where nif_empleado=? and id=(select max(id)as id from nomina where nif_empleado=?)";
        nomina est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif,nif},new RowMapper<nomina>(){
        @Override
            public nomina mapRow(ResultSet rs, int i) throws SQLException {
                nomina e = new nomina();
                e.setId(rs.getInt(1));
                String idC=rs.getString("nif_empleado");
                int contid=rs.getInt("contrato_id");
                try {
                    empleados cu=empleadoDAO.ByNif(idC);
                    e.setNif_empleado(cu);
                    contrato contt=contratoDAO.porId(contid);
                    e.setC(contt);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setMes(rs.getString(3));
	               e.setAnio(rs.getString(4));
	               e.setSalario_base(rs.getDouble(5));
	               e.setPagas_extras_prorrateadas(rs.getDouble(6));
	               e.setProrrateo_vacaciones(rs.getDouble(7));
	               e.setGratificaciones_extraordinarias(rs.getDouble(8));
	               e.setSalario_especie(rs.getDouble(9));
	               e.setIndemnizaciones_suplidos(rs.getDouble(10));
	               e.setPrestaciones_indemnizaciones_ss(rs.getDouble(11));
	               e.setOtras_percepciones_no_salariales(rs.getDouble(12));
	               e.setHoras_extraordinarias(rs.getDouble(13));
	               e.setNumdias(rs.getString(14));
                       e.setAntiguedad(rs.getString(15));

                return e;
        }
        });
        
        return est;
    }

    @Override
    public boolean existeNominaM(String nif, String mes, String anio) {
        String sql = "SELECT count(*)as cont FROM nomina where nif_empleado="+nif+" and anio="+anio+" and mes="+mes;
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("cont");
                return t;
        }
        });
    }

    
    @Override
    public boolean existeNominaMporID(String nif, String mes, String anio,int id) {
        String sql = "SELECT count(*)as cont FROM nomina where id!="+id+" and nif_empleado="+nif+" and anio="+anio+" and mes="+mes;
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("cont");
                return t;
        }
        });
    }
    @Override
    public boolean Insert(nomina cont) {
        if(cont.getSalario_base()==null)cont.setSalario_base(0.0);
			if(cont.getPagas_extras_prorrateadas()==null)cont.setPagas_extras_prorrateadas(0.0);
			if(cont.getProrrateo_vacaciones()==null)cont.setProrrateo_vacaciones(0.0);
			if(cont.getGratificaciones_extraordinarias()==null)cont.setGratificaciones_extraordinarias(0.0);
			if(cont.getSalario_especie()==null)cont.setSalario_especie(0.0);
			if(cont.getIndemnizaciones_suplidos()==null)cont.setIndemnizaciones_suplidos(0.0);
			if(cont.getPrestaciones_indemnizaciones_ss()==null)cont.setPrestaciones_indemnizaciones_ss(0.0);
			if(cont.getOtras_percepciones_no_salariales()==null)cont.setOtras_percepciones_no_salariales(0.0);
			if(cont.getHoras_extraordinarias()==null)cont.setHoras_extraordinarias(0.0);
			
        String sql = "INSERT INTO nomina(nif_empleado, mes, anio, salario_base, pagas_extras_prorrateadas,"
					+ "prorrateo_vacaciones, gratificaciones_extraordinarias, salario_especie,  "
					+ "indemnizaciones_suplidos, prestaciones_indemnizaciones_ss, otras_percepciones_no_salariales, "
					+ "horas_extraordinarias, contrato_id,numdias,antiguedad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado().getNif(),cont.getMes(),cont.getAnio(), cont.getSalario_base(),
            cont.getPagas_extras_prorrateadas(), cont.getProrrateo_vacaciones(), cont.getGratificaciones_extraordinarias(), cont.getSalario_especie(),
            cont.getIndemnizaciones_suplidos(), cont.getPrestaciones_indemnizaciones_ss(), cont.getOtras_percepciones_no_salariales(),
            cont.getHoras_extraordinarias(),cont.getC().getId(),cont.getNumdias(),cont.getAntiguedad()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }

    @Override
    public String Update(nomina cont) {
        if(cont.getSalario_base()==null)cont.setSalario_base(0.0);
			if(cont.getPagas_extras_prorrateadas()==null)cont.setPagas_extras_prorrateadas(0.0);
			if(cont.getProrrateo_vacaciones()==null)cont.setProrrateo_vacaciones(0.0);
			if(cont.getGratificaciones_extraordinarias()==null)cont.setGratificaciones_extraordinarias(0.0);
			if(cont.getSalario_especie()==null)cont.setSalario_especie(0.0);
			if(cont.getIndemnizaciones_suplidos()==null)cont.setIndemnizaciones_suplidos(0.0);
			if(cont.getPrestaciones_indemnizaciones_ss()==null)cont.setPrestaciones_indemnizaciones_ss(0.0);
			if(cont.getOtras_percepciones_no_salariales()==null)cont.setOtras_percepciones_no_salariales(0.0);
			if(cont.getHoras_extraordinarias()==null)cont.setHoras_extraordinarias(0.0);
					
        String sql = "UPDATE nomina SET salario_base=?, pagas_extras_prorrateadas=?,"
					+ "prorrateo_vacaciones=?, gratificaciones_extraordinarias=?, salario_especie=?,"
					+ "indemnizaciones_suplidos=?, prestaciones_indemnizaciones_ss=?, "
					+ "otras_percepciones_no_salariales=?, horas_extraordinarias=?,anio=?,mes=?,numdias=?,antiguedad=? "
					+ "WHERE id=? and nif_empleado=? and contrato_id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getSalario_base(),
            cont.getPagas_extras_prorrateadas(), cont.getProrrateo_vacaciones(), cont.getGratificaciones_extraordinarias(), cont.getSalario_especie(),
            cont.getIndemnizaciones_suplidos(), cont.getPrestaciones_indemnizaciones_ss(), cont.getOtras_percepciones_no_salariales(),
            cont.getHoras_extraordinarias(),cont.getAnio(),cont.getMes(),cont.getNumdias(),cont.getAntiguedad(),cont.getId(),cont.getNif_empleado().getNif(),cont.getC().getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM nomina WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
