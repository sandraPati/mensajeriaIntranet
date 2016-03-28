/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.contrato;
import com.intranet.beans.empleados;
import com.intranet.beans.tipo_contrato;
import com.intranet.dao.ContratoDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.TipoContratoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("contratoDAO")
public class IContratoDAO extends UtilTemplateDAO implements ContratoDAO{

    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    TipoContratoDAO tipoContratoDAO;
    
    @Override
    public List<contrato> findAll(String nif) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones "+
       "FROM contrato where nif_empleado=? ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            if(nifE!=null && nifE!=""){
                                empleados cu=empleadoDAO.ByNif(nifE);
                                e.setNif_empleado(cu);
                            }
                            if(idC!=0){
                                tipo_contrato tc=tipoContratoDAO.porId(idC);
                                e.setId_tipo_contrato(tc);
                            }
                            
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public contrato verultimo(String nif) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones "+
       "FROM contrato where nif_empleado=? and fecha_contrato_hasta in(select max(fecha_contrato_hasta) from contrato where nif_empleado=?) ";
        contrato est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif,nif},new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public boolean validafechas(contrato cont) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public contrato porId(int id) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato "+
       "FROM contrato where id=? ";
        contrato est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt("id"));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                       try {
                            if(nifE!=null && nifE!=""){
                                empleados cu=empleadoDAO.ByNif(nifE);
                                e.setNif_empleado(cu);
                            }
                            if(idC!=0){
                                tipo_contrato tc=tipoContratoDAO.porId(idC);
                                e.setId_tipo_contrato(tc);
                            }
                            
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString("categoria_profesional"));
	               e.setNivel_profesional(rs.getString("nivel_profesional"));
	               e.setJornada(rs.getString("jornada"));
	               e.setNum_horas(rs.getInt("num_horas"));
	               e.setTiempo_rango(rs.getString("tiempo_rango"));
	               e.setCorresponde_contrato(rs.getString("corresponde_contrato"));
	               e.setPacto_horas_complementarias(rs.getString("pacto_horas_complementarias"));
	               e.setDistribucion_tiempo(rs.getString("distribucion_tiempo"));
	               e.setDuracion_contrato_desde(rs.getDate("fecha_contrato_desde"));
	               e.setDuracion_contrato_hasta(rs.getDate("fecha_contrato_hasta"));
	               e.setPeriodo_prueba(rs.getString("periodo_prueba"));
	               e.setContrato_relevo(rs.getString("contrato_relevo"));
	               e.setRetribucion_total(rs.getDouble("retribucion_total"));
	               e.setFecha_pago(rs.getString("fecha_pago"));
	               e.setTipo_pago(rs.getString("tipo_pago"));
	               e.setVacaciones(rs.getString("vacaciones"));
                       e.setClausulas(rs.getString("clausulas"));
	               e.setConceptos_salariales(rs.getString("conceptos_salariales"));
	               e.setFecha_contrato(rs.getDate("fecha_contrato"));
                       if(e.getClausulas()==null){
	            	   e.setClausulas("");
	               }
	               if(e.getConceptos_salariales()==null){
	            	   e.setConceptos_salariales("");
	               }
	               if(e.getDistribucion_tiempo()==null){
	            	   e.setDistribucion_tiempo("");
	               }
	               if(e.getVacaciones()==null){
	            	   e.setVacaciones("");
	               }
                       
                       if(e.getJornada()!=null){
		               if(e.getJornada().equals("Completo")){
		            	   if(e.getTiempo_rango()!=null && e.getTiempo_rango()!="")
		            		   e.setTiempo_rango1(e.getTiempo_rango());
		            	   else e.setTiempo_rango1("");
		            	   e.setTiempo_rango2("");
		            	   e.setNum_horas1(""+e.getNum_horas());
		            	   e.setNum_horas2("");
		            	   e.setCorresponde_contrato("");
		            	   e.setPacto_horas_complementarias("");
		               }else{
		            	   e.setTiempo_rango1("");
		            	   if(e.getTiempo_rango()!=null && e.getTiempo_rango()!="")
		            		   e.setTiempo_rango2(e.getTiempo_rango());
		            	   else e.setTiempo_rango2("");
		            	   e.setNum_horas1("");
		            	   e.setNum_horas2(""+e.getNum_horas());
		            	   if(e.getCorresponde_contrato()!=null && e.getCorresponde_contrato()!=""){
		            		   e.setCorresponde_contrato(""+e.getCorresponde_contrato());
		            	   }else e.setCorresponde_contrato("");
		            	   
		            	   if(e.getPacto_horas_complementarias()!=null && e.getPacto_horas_complementarias()!=""){
		            		   e.setPacto_horas_complementarias(""+e.getPacto_horas_complementarias());
		            	   }else e.setPacto_horas_complementarias("");
		               }
	               }else{
	            	   e.setTiempo_rango1("");
	            	   e.setTiempo_rango2("");
	            	   e.setNum_horas1("");
	            	   e.setNum_horas2("");
	            	   e.setCorresponde_contrato("");
	            	   e.setPacto_horas_complementarias("");
	               }
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String Insert(contrato cont) {
       int c=0;
       
       if(cont.getJornada().equals("Completo")){
            System.out.println("completo");
           String sql = "INSERT INTO contrato("+
                "nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato,jornada, num_horas, tiempo_rango, "+
                "distribucion_tiempo,periodo_prueba,contrato_relevo, retribucion_total,tipo_pago,vacaciones,clausulas,"+
                "conceptos_salariales,fecha_contrato_desde, fecha_contrato_hasta,fecha_pago, fecha_contrato) "+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado().getNif(), cont.getCategoria_profesional(),
                cont.getNivel_profesional(), cont.getId_tipo_contrato().getId(),cont.getJornada(), cont.getNum_horas(),
                cont.getTiempo_rango(), cont.getDistribucion_tiempo(),cont.getPeriodo_prueba(),cont.getContrato_relevo(),cont.getRetribucion_total(),
                cont.getTipo_pago(),cont.getVacaciones(),cont.getClausulas(),cont.getConceptos_salariales(),cont.getDuracion_contrato_desde(),cont.getDuracion_contrato_hasta(),cont.getFecha_pago(),cont.getFecha_contrato()
            });
        }else  if(cont.getJornada().equals("Parcial")){
              System.out.println("parcial");
            String sql = "INSERT INTO contrato("+
                "nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato,jornada, num_horas, tiempo_rango, "+
                "corresponde_contrato, pacto_horas_complementarias,distribucion_tiempo,periodo_prueba,contrato_relevo, retribucion_total,tipo_pago,vacaciones,clausulas,"+
                "conceptos_salariales,fecha_contrato_desde, fecha_contrato_hasta,fecha_pago, fecha_contrato) "+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado().getNif(), cont.getCategoria_profesional(),
                cont.getNivel_profesional(), cont.getId_tipo_contrato().getId(),cont.getJornada(), cont.getNum_horas(),
                cont.getTiempo_rango(), cont.getCorresponde_contrato(), cont.getPacto_horas_complementarias(), cont.getDistribucion_tiempo(),cont.getPeriodo_prueba(),cont.getContrato_relevo(),cont.getRetribucion_total(),
                cont.getTipo_pago(),cont.getVacaciones(),cont.getClausulas(),cont.getConceptos_salariales(),cont.getDuracion_contrato_desde(),cont.getDuracion_contrato_hasta(),cont.getFecha_pago(),cont.getFecha_contrato()
            });
            
        }
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(contrato cont) {
        int c=0;
        if(cont.getJornada().equals("Completo")){
            System.out.println("completo");
           String sql = "UPDATE contrato SET "+
                "categoria_profesional=?, nivel_profesional=?, id_tipo_contrato=?,jornada=?, num_horas=?,tiempo_rango=?, "+
                "corresponde_contrato=?, pacto_horas_complementarias=?,distribucion_tiempo=?,periodo_prueba=?,contrato_relevo=?, retribucion_total=?,tipo_pago=?,vacaciones=?,clausulas=?, "+
                "conceptos_salariales=?,fecha_contrato_desde=?, fecha_contrato_hasta=?,fecha_pago=?,fecha_contrato=? "+
                "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{cont.getCategoria_profesional(),
                cont.getNivel_profesional(), cont.getId_tipo_contrato().getId(),cont.getJornada(), cont.getNum_horas(),
                cont.getTiempo_rango(),"","",cont.getDistribucion_tiempo(),cont.getPeriodo_prueba(),cont.getContrato_relevo(),cont.getRetribucion_total(),
                cont.getTipo_pago(),cont.getVacaciones(),cont.getClausulas(),
                cont.getConceptos_salariales(),cont.getDuracion_contrato_desde(),cont.getDuracion_contrato_hasta(),cont.getFecha_pago(),cont.getFecha_contrato(),
                cont.getId()
            });
        }else  if(cont.getJornada().equals("Parcial")){
              System.out.println("parcial");
              String sql = "UPDATE contrato SET "+
                "categoria_profesional=?, nivel_profesional=?, id_tipo_contrato=?,jornada=?, num_horas=?,tiempo_rango=?, "+
                "corresponde_contrato=?, pacto_horas_complementarias=?,distribucion_tiempo=?,periodo_prueba=?,contrato_relevo=?, retribucion_total=?,tipo_pago=?,vacaciones=?,clausulas=?, "+
                "conceptos_salariales=?,fecha_contrato_desde=?, fecha_contrato_hasta=?,fecha_pago=?,fecha_contrato=? "+
                "WHERE id=?";
            c=this.getJdbcTemplate().update(sql, new Object[]{cont.getCategoria_profesional(),
                cont.getNivel_profesional(), cont.getId_tipo_contrato().getId(),cont.getJornada(), cont.getNum_horas(),
                cont.getTiempo_rango(),cont.getCorresponde_contrato(), cont.getPacto_horas_complementarias(),cont.getDistribucion_tiempo(),cont.getPeriodo_prueba(),cont.getContrato_relevo(),cont.getRetribucion_total(),
                cont.getTipo_pago(),cont.getVacaciones(),cont.getClausulas(),
                cont.getConceptos_salariales(),cont.getDuracion_contrato_desde(),cont.getDuracion_contrato_hasta(),cont.getFecha_pago(),cont.getFecha_contrato(),
                cont.getId()
            });
            
            
        }
        
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM contrato WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public List<contrato> FiltrarCmaD(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_desde, 'yyyy') like'%?%' and to_char(fecha_contrato_desde, 'mm') like'%?%' ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getAnio(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<contrato> FiltrarCmaH(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_hasta, 'yyyy') like'%?%' and to_char(fecha_contrato_hasta, 'mm') like'%?%' ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getAnio(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<contrato> FiltrarCmD(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_desde, 'mm') like'%?%'  ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<contrato> FiltrarCmH(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_desde, 'mm') like'%?%'  ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<contrato> FiltrarCaD(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_desde, 'yyyy') like'%?%' ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<contrato> FiltrarCaH(contrato n) {
        String sql = "SELECT id, nif_empleado, categoria_profesional, nivel_profesional, id_tipo_contrato, "+
       "jornada, num_horas, tiempo_rango, corresponde_contrato, pacto_horas_complementarias, "+
       "distribucion_tiempo, fecha_contrato_desde, fecha_contrato_hasta, "+
       "periodo_prueba, contrato_relevo, retribucion_total, fecha_pago, "+
       "tipo_pago, vacaciones,clausulas,conceptos_salariales,fecha_contrato  "+
       "FROM contrato where nif_empleado=? and to_char(fecha_contrato_hasta, 'yyyy') like'%?%' ";
        List<contrato> est =this.getJdbcTemplate().query(sql, 
                new Object[]{n.getNif_empleado().getNif(),n.getMes() },new RowMapper<contrato>(){
        @Override
            public contrato mapRow(ResultSet rs, int i) throws SQLException {
                contrato e = new contrato();
                       e.setId(rs.getInt(1));
                       String nifE=rs.getString("nif_empleado");
                       int idC=rs.getInt("id_tipo_contrato");
                        try {
                            empleados cu=empleadoDAO.ByNif(nifE);
                            e.setNif_empleado(cu);
                            tipo_contrato tc=tipoContratoDAO.porId(idC);
                            e.setId_tipo_contrato(tc);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
	               e.setCategoria_profesional(rs.getString(3));
	               e.setNivel_profesional(rs.getString(4));
	               e.setJornada(rs.getString(6));
	               e.setNum_horas(rs.getInt(7));
	               e.setTiempo_rango(rs.getString(8));
	               e.setCorresponde_contrato(rs.getString(9));
	               e.setPacto_horas_complementarias(rs.getString(10));
	               e.setDistribucion_tiempo(rs.getString(11));
	               e.setDuracion_contrato_desde(rs.getDate(12));
	               e.setDuracion_contrato_hasta(rs.getDate(13));
	               e.setPeriodo_prueba(rs.getString(14));
	               e.setContrato_relevo(rs.getString(15));
	               e.setRetribucion_total(rs.getDouble(16));
	               e.setFecha_pago(rs.getString(17));
	               e.setTipo_pago(rs.getString(18));
	               e.setVacaciones(rs.getString(19));
                       e.setClausulas(rs.getString(20));
	               e.setConceptos_salariales(rs.getString(21));
	               e.setFecha_contrato(rs.getDate(22));
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public int UContratoF(String nif) {
       
        String sql = "select cc.id as c from contrato cc where cc.nif_empleado=? and fecha_contrato =(select max(c3.fecha_contrato) from contrato c3 where c3.nif_empleado=?)";
        int id= this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif,nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
        return id;
    }
    
    
    @Override
    public int UtieneContratoF(String nif) {
       
        String sql = "select cc.id as c from contrato cc where cc.nif_empleado=?";
        int id= this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{nif},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
        return id;
    }
    
}
