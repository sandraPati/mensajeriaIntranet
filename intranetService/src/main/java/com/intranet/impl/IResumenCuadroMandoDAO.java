/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.dao.ResumenCuadroMandoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("resumenCuadroMandoDAO")
public class IResumenCuadroMandoDAO extends UtilTemplateDAO implements ResumenCuadroMandoDAO{
    @Override
    public Double TotalIngresos() {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    @Override
    public Double TotalGastos() {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    @Override
    public Double TotalBeneficio() {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    @Override
    public Double TotalIngresosPFecha(String fecha) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=1 and fecha=to_date(?, 'yyyy-MM-dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and fechapago=to_date(?, 'yyyy-MM-dd')  )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    @Override
    public Double TotalIngresosIFecha(String fecha) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=0 and fecha=to_date(?, 'yyyy-MM-dd')  "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and fechapago=to_date(?, 'yyyy-MM-dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    

    public Double TotalIngresosP(String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=? )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalIngresosP(String mes, String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
                
        }
        });
    }

    public Double TotalGastosP(String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=? )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosP(String mes, String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=? "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=? )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosPFecha(String fecha) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=1 and fecha=to_date(?, 'yyyy-MM-dd') "+
                "union select sum(totalbruto)as t from gastos where estado=1 and fechapago=to_date(?, 'yyyy-MM-dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioP(String anio) {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=? )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=? )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio,anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioP(String mes, String anio) {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=?  "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes,anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioPFecha(String fecha) {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=1 and fecha=to_date(?, 'yyyy-MM-dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and fechapago=to_date(?, 'yyyy-MM-dd')  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=1 and fecha=to_date(?, 'yyyy-MM-dd')  "+
                "union select sum(totalbruto)as t from gastos where estado=1 and fechapago=to_date(?, 'yyyy-MM-dd')  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha,fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalIngresosI(String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=?  "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=?  )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalIngresosI(String mes, String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=?  "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosI(String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=?   "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=?   )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosI(String mes, String anio) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=?  "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosIFecha(String fecha) {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=0 and fecha=to_date(?, 'yyyy-MM-dd') "+
                "union select sum(totalbruto)as t from gastos where estado=0 and fechapago=to_date(?, 'yyyy-MM-dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioI(String anio) {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=? )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=? "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=? )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,anio,anio,anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioI(String mes, String anio) {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=? "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=? and to_char(fecha,'mm')=?  "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=? and to_char(fechapago,'mm')=?  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes,anio,mes,anio,mes,anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioIFecha(String fecha) {
       String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=0 and fecha=to_date(?, 'yyyy-MM-dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and fechapago=to_date(?, 'yyyy-MM-dd')  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=0 and fecha=to_date(?, 'yyyy-MM-dd')  "+
                "union select sum(totalbruto)as t from gastos where estado=0 and fechapago=to_date(?, 'yyyy-MM-dd')  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha,fecha,fecha,fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double clienteF(String anio) {
        String sql = "select count(*)as sum from clientes where to_char(fecharegistro,'yyyy')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double clienteF(String mes, String anio) {
        String sql = "select count(*)as sum from clientes where to_char(fecharegistro,'yyyy')=? and to_char(fecharegistro,'mm')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double clienteFFecha(String fecha) {
        String sql = "select count(*)as sum from clientes where fecharegistro=to_date(?, 'yyyy-MM-dd')";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalIngresosP() {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalGastosP() {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioP() {
         String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd')  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=1 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd')  "+
                "union select sum(totalbruto)as t from gastos where estado=1 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd')  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalIngresosI() {
        String sql = "select sum(t)as c from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }

    public Double TotalBeneficioI() {
        String sql = "select (select sum(t) from (select sum(total)as t from venta where estado=0 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from ingresos where estado=0 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd')  )d)- "+
                "( select sum(t) from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd')  "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd')  )d) as sum";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    
    public Double TotalGastosI() {
        String sql = "select sum(t)as c from (select sum(total)as t from compra where estado=0 and to_char(fecha,'yyyy')=to_char(current_date,'yyyy') and to_char(fecha,'mm')=to_char(current_date,'mm') and to_char(fecha,'dd')=to_char(current_date,'dd') "+
                "union select sum(totalbruto)as t from gastos where estado=0 and to_char(fechapago,'yyyy')=to_char(current_date,'yyyy') and to_char(fechapago,'mm')=to_char(current_date,'mm') and to_char(fechapago,'dd')=to_char(current_date,'dd') )d";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("c");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    
    public Double clienteF() {
        String sql = "select count(*)as sum from clientes where to_char(fecharegistro,'yyyy')=to_char(current_date,'yyyy') and to_char(fecharegistro,'mm')=to_char(current_date,'mm') and to_char(fecharegistro,'dd')=to_char(current_date,'dd')";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Double>(){
        @Override
            public Double mapRow(ResultSet rs, int i) throws SQLException {
                Double t = rs.getDouble("sum");
                Double res=0.0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    
    public Integer visitasFecha(String fecha) {
        String sql = "select count(*)as c from agenda_supervisor_empleado where tipotarea='Visita' and estado='SI' and to_date(ffin, 'MM/dd/yyyy')=to_date(?, 'yyyy-MM-dd')";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer visitas(String mes, String anio) {
        String sql = "select count(*)as c from agenda_supervisor_empleado where tipotarea='Visita' and estado='SI' and to_char(to_date(ffin, 'MM/dd/yyyy') ,'yyyy')=? and to_char(to_date(ffin, 'MM/dd/yyyy'),'MM')=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer visitas(String anio) {
        String sql = "select count(*)as c from agenda_supervisor_empleado where tipotarea='Visita' and estado='SI' and to_char(to_date(ffin, 'MM/dd/yyyy') ,'yyyy')=?  ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     public Integer visitas() {
        String sql = "select count(*)as c from agenda_supervisor_empleado where tipotarea='Visita' and estado='SI' and to_date(ffin, 'MM/dd/yyyy')=current_date ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     
      public Integer presupuestoFecha(String fecha) {
        String sql = "select count(distinct pre.propuesta_id)as c from presupuestoc pre inner join propuesta p on(pre.propuesta_id=p.id) where pre.estadoenviado=1 and pre.fecha=to_date(?, 'yyyy-MM-dd')";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuesto(String mes, String anio) {
        String sql = "select count(distinct pre.propuesta_id)as c from presupuestoc pre inner join propuesta p on(pre.propuesta_id=p.id) where pre.estadoenviado=1 and to_char(pre.fecha,'yyyy')=? and to_char(pre.fecha,'MM')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuesto(String anio) {
        String sql = "select count(distinct pre.propuesta_id)as c from presupuestoc pre inner join propuesta p on(pre.propuesta_id=p.id) where pre.estadoenviado=1 and to_char(pre.fecha,'yyyy')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     public Integer presupuesto() {
        String sql = "select count(distinct pre.propuesta_id)as c from presupuestoc pre inner join propuesta p on(pre.propuesta_id=p.id) where  pre.estadoenviado=1 and pre.fecha=current_date";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     
     public Integer presupuestoAceptadosFecha(String fecha) {
        String sql = "select count(*)as c from propuesta where estado=4 and fechaproyecto=to_date(?, 'yyyy-MM-dd') ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoAceptados(String mes, String anio) {
        String sql = "select count(*)as c from propuesta where estado=4 and to_char(fechaproyecto,'yyyy')=? and to_char(fechaproyecto,'MM')=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoAceptados(String anio) {
        String sql = "select count(*)as c from propuesta where estado=4 and to_char(fechaproyecto,'yyyy')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     public Integer presupuestoAceptados() {
        String sql = "select count(*)as c from propuesta where estado=4 and fechaproyecto=current_date";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     
      public Integer presupuestoRechazadosFecha(String fecha) {
        String sql = "select count(*)as c from propuesta where estado=3 and fechaproyecto=to_date(?, 'yyyy-MM-dd') ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoRechazados(String mes, String anio) {
        String sql = "select count(*)as c from propuesta where estado=3 and to_char(fechaproyecto,'yyyy')=? and to_char(fechaproyecto,'MM')=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoRechazados(String anio) {
        String sql = "select count(*)as c from propuesta where estado=3 and to_char(fechaproyecto,'yyyy')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     public Integer presupuestoRechazados() {
        String sql = "select count(*)as c from propuesta where estado=3 and fechaproyecto=current_date";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     
      public Integer presupuestoPendientesFecha(String fecha) {
        String sql = "select count(*)as c from propuesta where estado=1 and dia=to_date(?, 'yyyy-MM-dd') ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{fecha},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoPendientes(String mes, String anio) {
        String sql = "select count(*)as c from propuesta where estado=1 and to_char(dia,'yyyy')=? and to_char(dia,'MM')=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio,mes},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
    public Integer presupuestoPendientes(String anio) {
        String sql = "select count(*)as c from propuesta where estado=1 and to_char(dia,'yyyy')=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{anio},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
     public Integer presupuestoPendientes() {
        String sql = "select count(*)as c from propuesta where estado=1 and dia=current_date";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Integer res=0;
                if(t>0)res=t;
                return res;
        }
        });
    }
}
