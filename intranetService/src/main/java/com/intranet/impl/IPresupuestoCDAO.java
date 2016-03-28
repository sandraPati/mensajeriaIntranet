/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.beans.estancias;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.subcapitulos;
import com.intranet.dao.CapituloDAO;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.PresupuestoCDAO;
import com.intranet.dao.SubCapitulosDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoCDAO")
public class IPresupuestoCDAO extends UtilTemplateDAO implements PresupuestoCDAO{
    @Autowired(required = true)
    EstanciasDAO estanciasDAO;
    @Autowired(required = true)
    CapituloDAO capituloDAO;
    @Autowired(required = true)
    SubCapitulosDAO subCapituloDAO;
    
    @Override
    public List<presupuesto> findAll(int idProp) {
        /*String sql = "SELECT p.id, p.propuesta_id, p.capitulo_id,c.cod,c.nombre,p.descripcion,p.cantidad,p.descripcionmetros,p.cantidadmetros "+
	      "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) WHERE p.propuesta_id=? ";
        */
        /*
        String sql="(SELECT ps.estancia_id,0 as id,'' as cod,'' as nombre,0 as capid "+
            "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) inner join  presupuesto_superficies ps on(p.id=ps.presupuesto_id) "+
            "WHERE p.propuesta_id=? "+
            "group by ps.estancia_id) "+
            "union "+
            "(SELECT 0 as estancia_id,p.id,c.cod,c.nombre,c.id as capid "+
            "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) "+
            "WHERE p.propuesta_id=? and "+ 
            "p.id not in(select distinct ps.presupuesto_id from presupuesto_superficies ps "+
            "inner join presupuestoc pre on(ps.presupuesto_id=pre.id) where pre.propuesta_id=?))";
                List<presupuesto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idProp,idProp,idProp},new RowMapper<presupuesto>(){
        @Override
            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto pre = new presupuesto();
                int idE=rs.getInt(1);
                pre.setPresup_id(rs.getInt(2));
                try {
                    if(idE!=0){
                        pre.setEstancia_id(estanciasDAO.porID(idE));
                        capitulos cap=new capitulos();

                        pre.setCapitulo_id(cap);
                    }else{
                        estancias est=new estancias();
                        est.setId(0);
                        pre.setEstancia_id(est);
                        capitulos cap=new capitulos();
                        cap.setCod(rs.getString(3));
                        cap.setNombre(rs.getString(4));
                        cap.setId(rs.getInt(5));

                        pre.setCapitulo_id(cap);
                    }
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return pre;
        }
        });
        */
        return null;
    }
    
    @Override
    public List<presupuestoc> grupo(int idProp,int idE) {
        /*String sql = "SELECT p.id, p.propuesta_id, p.capitulo_id,c.cod,c.nombre,p.descripcion,p.cantidad,p.descripcionmetros,p.cantidadmetros "+
	      "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) WHERE p.propuesta_id=? and p.id in( select distinct ps.presupuesto_id "+
              "from presupuesto_superficies ps inner join presupuestoc pre on(ps.presupuesto_id=pre.id) "+
              "where pre.propuesta_id=? and ps.estancia_id=?)";
        
        
        
                List<presupuestoc> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idProp,idProp,idE},new RowMapper<presupuestoc>(){
        @Override
            public presupuestoc mapRow(ResultSet rs, int i) throws SQLException {
               presupuestoc pre = new presupuestoc();
                pre.setId(rs.getInt(1));
                pre.setPropuesta_id(rs.getInt(2));
                pre.setCapitulo_id(rs.getInt(3));
               
                try {
                    capitulos c=new capitulos();
                    c.setCod(rs.getString(4));
                    c.setNombre(rs.getString(5));
                    pre.setCap(c);
                    pre.setDescripcion(rs.getString(6));
                    pre.setCantidad(rs.getFloat(7));
                    pre.setDescripcionmetros(rs.getString(8));
                    pre.setCantidadmetros(rs.getFloat(9));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return pre;
        }
        });
        */
        return null;
    }

    @Override
    public presupuestoc porId(int id) {
        String sql = "SELECT p.id, p.propuesta_id, p.capitulo_id,c.cod,c.nombre "+
	      "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) WHERE p.id=? ";
        presupuestoc est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<presupuestoc>(){
        @Override
            public presupuestoc mapRow(ResultSet rs, int i) throws SQLException {
                presupuestoc pre = new presupuestoc();
                pre.setId(rs.getInt(1));
                pre.setPropuesta_id(rs.getInt(2));
                pre.setCapitulo_id(rs.getInt(3));
               
                try {
                    capitulos c=new capitulos();
                    c.setCod(rs.getString(4));
                    c.setNombre(rs.getString(5));
                    pre.setCap(c);
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                return pre;
        }
        });
        
        return est;
    }

    public int ultimoPresupuestoC(int idProp,int idCap) {
        String sql = "SELECT count(id)as m FROM presupuestoc "+
	   "WHERE propuesta_id=? and capitulo_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idProp,idCap},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("m");
                return t;
        }
        });
    }
    
    public int ultimoPresupuestoCid(int idProp,int idCap) {
        String sql = "SELECT id FROM presupuestoc "+
	   "WHERE propuesta_id=? and capitulo_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idProp,idCap},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("id");
                return t;
        }
        });
    }

    public boolean Insert(presupuestoc presu) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuestoc("+
            "propuesta_id, capitulo_id)"+
            "VALUES (?, ?)";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getPropuesta_id(), presu.getCapitulo_id()});
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    
    public boolean Upd(presupuestoc presu) {
       /* String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuestoc SET  "+
            "descripcion=?,cantidad=?,descripcionmetros=?,cantidadmetros=? "+
            "WHERE id=?";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getDescripcion(),presu.getCantidad(),presu.getDescripcionmetros(),presu.getCantidadmetros(),presu.getId()});
        boolean r=false;
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
            r=true;
        }*/
        return false;
    }

    public boolean Delete(int id) {
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuestoc WHERE id=? ";
        c=this.getJdbcTemplate().update(sql, new Object[]{id});
        boolean r=false;
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }

    public boolean DeletePC(int idP,int idC){
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuestoc WHERE propuesta_id=? and capitulo_id=? ";
        c=this.getJdbcTemplate().update(sql, new Object[]{idP, idC});
        boolean r=false;
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
            r=true;
        }
        return r;
    }
    
    public List<presupuesto> presupuestos(int idPresuC) {
        String sql = "SELECT id, subcapitulo_id, monto, "+
	      "descripcion, tipocantidad, cantidad, precio,presup_id "+
	      "FROM presupuesto WHERE presup_id=? ";
        List<presupuesto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPresuC},new RowMapper<presupuesto>(){
        @Override
            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto pre = new presupuesto();
                pre.setId(rs.getInt(1));
               
                int idSC=rs.getInt("subcapitulo_id");
                try {
                    
                    if(idSC!=0){
                        subcapitulos cu3=subCapituloDAO.porId(idSC);
                        pre.setSubcapitulo(cu3);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                pre.setMonto(rs.getFloat(3));
                pre.setDescripcion(rs.getString(4));
                pre.setTipoCantidad(rs.getString(5));
                pre.setCantidad(rs.getFloat(6));
                pre.setPrecio(rs.getFloat(7));
                pre.setPresup_id(rs.getInt(8));
                return pre;
        }
        });
        
        return est;
    }
    
    public List<presupuestoc> presupuestoCapitulos(int idP) {
        String sql="SELECT p.id, p.propuesta_id, p.capitulo_id,c.cod,c.nombre FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) WHERE p.propuesta_id=?";
        List<presupuestoc> lta=this.getJdbcTemplate().query(sql,new Object[]{idP},new RowMapper<presupuestoc>(){

            public presupuestoc mapRow(ResultSet rs, int i) throws SQLException {
                presupuestoc p=new presupuestoc();
                p.setId(rs.getInt(1));
                p.setPropuesta_id(rs.getInt(2));
                p.setCapitulo_id(rs.getInt(3));
                try {
                    
                    if(p.getCapitulo_id()!=0){
                        capitulos c=new capitulos();
                        c.setId(rs.getInt(3));
                        c.setCod(rs.getString(4));
                        c.setNombre(rs.getString(5));
                        p.setCap(c);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                return p;
            }
            
        });
        
        
        return lta;
    }
    
    public List<presupuestoc> presupuestoCapitulosADD(int idP) {
        String sql="select * from ((SELECT p.id, p.propuesta_id, p.capitulo_id,c.cod,c.nombre FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) where propuesta_id=?) "+
                "union (select 0 as id,0 as propuesta_id, id as capitulo_id,cod,nombre from capitulos where id not in(SELECT p.capitulo_id "+
                "FROM presupuestoc p inner join capitulos c on(p.capitulo_id=c.id) where propuesta_id=?)))d order by cod asc ";
        List<presupuestoc> lta=this.getJdbcTemplate().query(sql,new Object[]{idP,idP},new RowMapper<presupuestoc>(){

            public presupuestoc mapRow(ResultSet rs, int i) throws SQLException {
                presupuestoc p=new presupuestoc();
                p.setId(rs.getInt(1));
                p.setPropuesta_id(rs.getInt(2));
                p.setCapitulo_id(rs.getInt(3));
                try {
                    
                    if(p.getCapitulo_id()!=0){
                        capitulos c=new capitulos();
                        c.setId(rs.getInt(3));
                        c.setCod(rs.getString(4));
                        c.setNombre(rs.getString(5));
                        p.setCap(c);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                return p;
            }
            
        });
        
        
        return lta;
    }
    @Override
    public String UpdateEstado(int idP) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuestoc SET estadoenviado=1, fecha=current_date WHERE propuesta_id=?";
        c=this.getJdbcTemplate().update(sql, new Object[]{idP});
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
     @Override
    public boolean presupPropuesta(int id) {
        String sql = "select count(*)as c from presupuestoc where propuesta_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                Boolean result=false;
                if(t>0) result=true;
                return result;
        }
        });
    }
}
