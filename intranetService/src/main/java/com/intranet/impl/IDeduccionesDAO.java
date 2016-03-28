/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.deducciones;
import com.intranet.beans.empleados;
import com.intranet.beans.nomina;
import com.intranet.dao.NominaDAO;
import com.intranet.dao.DeduccionesDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("deduccionesDAO")
public class IDeduccionesDAO extends UtilTemplateDAO implements DeduccionesDAO{

    @Autowired(required = true)
    NominaDAO nominaDAO;
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    
    @Override
    public deducciones ById(int id) {
        String sql = "SELECT id, nif_empleado, contingencias_comunes, desempleo, formacion,"
	          + " irpf, anticipos, valor_productos_recibidos, otras_deducciones, nomina_id,basecotizacion,baseirpf "
	          + " FROM deducciones where id=? ";
        deducciones est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<deducciones>(){
        @Override
            public deducciones mapRow(ResultSet rs, int i) throws SQLException {
                deducciones e = new deducciones();
                e.setId(rs.getInt(1));
                String nifE=rs.getString("nif_empleado");
                int idN=rs.getInt("nomina_id");
                try {
                    empleados cu=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(cu);
                    nomina nomi=nominaDAO.ById(idN);
                    e.setNom(nomi);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setContingencias_comunes(rs.getDouble(3));
	               e.setDesempleo(rs.getDouble(4));
	               e.setFormacion(rs.getDouble(5));
	               e.setIrpf(rs.getDouble(6));
	               e.setAnticipos(rs.getDouble(7));
	               e.setValor_productos_recibidos(rs.getDouble(8));
	               e.setOtras_deducciones(rs.getDouble(9));
                       e.setBasecotizacion(rs.getDouble(11));
                       e.setBaseirpf(rs.getDouble(12));
	               
                return e;
        }
        });
        
        return est;
    }

    @Override
    public deducciones UltimoPorNomina(int idnomina) {
        String sql = "SELECT id, nif_empleado, contingencias_comunes, desempleo, formacion,"
	          + " irpf, anticipos, valor_productos_recibidos, otras_deducciones, nomina_id,basecotizacion,baseirpf "
	          + " FROM deducciones where nomina_id=? ";
        deducciones est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idnomina},new RowMapper<deducciones>(){
        @Override
            public deducciones mapRow(ResultSet rs, int i) throws SQLException {
                deducciones e = new deducciones();
                e.setId(rs.getInt(1));
                String nifE=rs.getString("nif_empleado");
                int idN=rs.getInt("nomina_id");
                try {
                    empleados cu=new empleados();
                    cu.setNif(nifE);
                    nomina nomi=new nomina();
                    nomi.setId(idN);
                    e.setNif_empleado(cu);
                    e.setNom(nomi);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	               e.setContingencias_comunes(rs.getDouble(3));
	               e.setDesempleo(rs.getDouble(4));
	               e.setFormacion(rs.getDouble(5));
	               e.setIrpf(rs.getDouble(6));
	               e.setAnticipos(rs.getDouble(7));
	               e.setValor_productos_recibidos(rs.getDouble(8));
	               e.setOtras_deducciones(rs.getDouble(9));
	               e.setBasecotizacion(rs.getDouble(11));
                       e.setBaseirpf(rs.getDouble(12));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public boolean siexiste(int idnomina) {
        String sql = "SELECT count(*)as cuenta FROM deducciones where nomina_id=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idnomina},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("cuenta");
                return t;
        }
        });
    }

    @Override
    public boolean existeDeduccionM(int idnomina) {
        String sql = "SELECT count(*)as cont FROM deducciones where nomina_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idnomina},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = rs.getBoolean("cont");
                return t;
        }
        });
    }

    @Override
    public String Insert(deducciones cont) {
        if(cont.getContingencias_comunes()==null)cont.setContingencias_comunes(0.0);
			if(cont.getDesempleo()==null)cont.setDesempleo(0.0);
			if(cont.getFormacion()==null)cont.setFormacion(0.0);
			if(cont.getIrpf()==null)cont.setIrpf(0.0);
			if(cont.getAnticipos()==null)cont.setAnticipos(0.0);
			if(cont.getValor_productos_recibidos()==null)cont.setValor_productos_recibidos(0.0);
			if(cont.getOtras_deducciones()==null)cont.setOtras_deducciones(0.0);
			
        String sql = "INSERT INTO deducciones(nif_empleado, contingencias_comunes, desempleo, formacion, "
					+ "irpf, anticipos, valor_productos_recibidos, otras_deducciones, nomina_id,basecotizacion,baseirpf )"
					+ " VALUES (?, ?, ?, ?,?, ?, ?, ?,?,?,?)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getNif_empleado().getNif(), cont.getContingencias_comunes(), cont.getDesempleo(),
            cont.getFormacion(), cont.getIrpf(), cont.getAnticipos(), cont.getValor_productos_recibidos(), cont.getOtras_deducciones(),cont.getNom().getId(),cont.getBasecotizacion(),cont.getBaseirpf()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(deducciones cont) {
        if(cont.getContingencias_comunes()==null)cont.setContingencias_comunes(0.0);
			if(cont.getDesempleo()==null)cont.setDesempleo(0.0);
			if(cont.getFormacion()==null)cont.setFormacion(0.0);
			if(cont.getIrpf()==null)cont.setIrpf(0.0);
			if(cont.getAnticipos()==null)cont.setAnticipos(0.0);
			if(cont.getValor_productos_recibidos()==null)cont.setValor_productos_recibidos(0.0);
			if(cont.getOtras_deducciones()==null)cont.setOtras_deducciones(0.0);
					
        String sql = "UPDATE deducciones SET contingencias_comunes=?, desempleo=?, formacion=?, "
					+ "irpf=?, anticipos=?, valor_productos_recibidos=?, otras_deducciones=?,basecotizacion=?,baseirpf=? "
					+ "WHERE id=? and nomina_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{cont.getContingencias_comunes(), cont.getDesempleo(),
            cont.getFormacion(), cont.getIrpf(), cont.getAnticipos(), cont.getValor_productos_recibidos(), cont.getOtras_deducciones(),cont.getBasecotizacion(),cont.getBaseirpf(),cont.getId(),cont.getNom().getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(int id) {
        String sql = "DELETE FROM deducciones "+
		            "WHERE nomina_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
