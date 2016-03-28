/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.estancias;
import com.intranet.beans.propuesta;
import com.intranet.beans.tipo_estancia;
import com.intranet.dao.PropuestaDAO;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.TipoEstanciaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("estanciasDAO")
public class IEstanciasDAO extends UtilTemplateDAO implements EstanciasDAO{

    @Autowired(required = true)
    PropuestaDAO propuestaDAO;
    @Autowired(required = true)
    TipoEstanciaDAO tipoEstanciaDAO;
    
    @Override
    public List<estancias> findAll(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<estancias> listaPropuesta(int idP) {
        String sql = "select id,propuesta_id,tipo_estancia_id,otro_tipo,numero,superficie,totalspanos,"+
					"totalsventanas, totalspuertas, totalsarmarios,totalssuelos, totalstechos "+
					"from estancias where propuesta_id=? ";
        List<estancias> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idP},new RowMapper<estancias>(){
        @Override
            public estancias mapRow(ResultSet rs, int i) throws SQLException {
                estancias est = new estancias();
                est.setId(rs.getInt(1));
                int idC=rs.getInt("propuesta_id");
                int idTE=rs.getInt("tipo_estancia_id");
                try {
                    propuesta cu=propuestaDAO.porId(idC);
                    est.setPropuesta_id(cu);
                    tipo_estancia cu2=tipoEstanciaDAO.porId(idTE);
                    est.setTipo_estancia_id(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
				est.setOtro_tipo(rs.getString(4));
				est.setNumero(rs.getInt(5));
				est.setSuperficie(rs.getFloat(6));
				est.setTotalSpanos(rs.getFloat(7));
				est.setTotalSventanas(rs.getFloat(8));
				est.setTotalSpuertas(rs.getFloat(9));
				est.setTotalSarmarios(rs.getFloat(10));
				est.setTotalSsuelos(rs.getFloat(11));
				est.setTotalStechos(rs.getFloat(12));
                
                return est;
        }
        });
        
        return e;
    }

    @Override
    public List<estancias> listaEstanciasPresup(int idP,int idPresup) {
        String sql = "select * from ((select id,propuesta_id,tipo_estancia_id,otro_tipo,numero,superficie,totalspanos,"+
                    "totalsventanas, totalspuertas, totalsarmarios,totalssuelos, totalstechos,1 as asignado "+
                    "from estancias where propuesta_id=? and id in(select distinct estancia_id from presupuesto_superficies where presupuesto_id=?)) union "+
                    "(select id,propuesta_id,tipo_estancia_id,otro_tipo,numero,superficie,totalspanos,totalsventanas, totalspuertas, totalsarmarios,totalssuelos, totalstechos,0 as asignado "+
                    "from estancias where propuesta_id=? and id not in( select distinct estancia_id from presupuesto_superficies where presupuesto_id=?)))as d order by id asc";
        List<estancias> e =this.getJdbcTemplate().query(sql, 
                new Object[]{idP,idPresup,idP,idPresup},new RowMapper<estancias>(){
        @Override
            public estancias mapRow(ResultSet rs, int i) throws SQLException {
                estancias est = new estancias();
                est.setId(rs.getInt(1));
                int idC=rs.getInt("propuesta_id");
                int idTE=rs.getInt("tipo_estancia_id");
                try {
                    propuesta cu=propuestaDAO.porId(idC);
                    est.setPropuesta_id(cu);
                    tipo_estancia cu2=tipoEstanciaDAO.porId(idTE);
                    est.setTipo_estancia_id(cu2);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
				est.setOtro_tipo(rs.getString(4));
				est.setNumero(rs.getInt(5));
				est.setSuperficie(rs.getFloat(6));
				est.setTotalSpanos(rs.getFloat(7));
				est.setTotalSventanas(rs.getFloat(8));
				est.setTotalSpuertas(rs.getFloat(9));
				est.setTotalSarmarios(rs.getFloat(10));
				est.setTotalSsuelos(rs.getFloat(11));
				est.setTotalStechos(rs.getFloat(12));
                                est.setAsignado(rs.getInt("asignado"));
                
                return est;
        }
        });
        
        return e;
    }
    
    @Override
    public estancias porID(int id) {
        String sql = "select id,propuesta_id,tipo_estancia_id,otro_tipo,numero,superficie,totalspanos,"+
					"totalsventanas, totalspuertas, totalsarmarios,totalssuelos, totalstechos,alto "+
					"from estancias where id=? ";
        estancias e =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<estancias>(){
        @Override
            public estancias mapRow(ResultSet rs, int i) throws SQLException {
                estancias est = new estancias();
                est.setId(rs.getInt(1));
                int idC=rs.getInt("propuesta_id");
                int idTE=rs.getInt("tipo_estancia_id");
                try {
                    propuesta ppr=new propuesta();
                    ppr.setId(idC);
                    
                    est.setPropuesta_id(ppr);
                    if(idTE!=0){
                    tipo_estancia cu2=tipoEstanciaDAO.porId(idTE);
                    est.setTipo_estancia_id(cu2);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
				est.setOtro_tipo(rs.getString(4));
				est.setNumero(rs.getInt(5));
				est.setSuperficie(rs.getFloat(6));
				est.setTotalSpanos(rs.getFloat(7));
				est.setTotalSventanas(rs.getFloat(8));
				est.setTotalSpuertas(rs.getFloat(9));
				est.setTotalSarmarios(rs.getFloat(10));
				est.setTotalSsuelos(rs.getFloat(11));
				est.setTotalStechos(rs.getFloat(12));
                                est.setAlto(rs.getFloat("alto"));
                
                return est;
        }
        });
        
        return e;
    }

     @Override
    public int idultimo(int idP) {
        String sql = "SELECT max(id) as c FROM estancias WHERE propuesta_id = ?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idP},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public Integer porPropuestaEstancia(int idPropuesta, int numero) {
        String sql = "select id from estancias where propuesta_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPropuesta},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("id");
                return t;
        }
        });
    }

    @Override
    public int Insert(estancias est) {
        String sql = "INSERT INTO estancias("+
		"propuesta_id, tipo_estancia_id, otro_tipo,numero,superficie,"+
		"totalspanos, totalsventanas, totalspuertas, totalsarmarios,totalssuelos, totalstechos,alto) "+
		"VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getPropuesta_id().getId(), est.getTipo_estancia_id().getId(), est.getOtro_tipo(),
            est.getNumero(), est.getSuperficie(), est.getTotalSpanos(), est.getTotalSventanas(), est.getTotalSpuertas(), est.getTotalSarmarios(),
            est.getTotalSsuelos(), est.getTotalStechos(),est.getAlto()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return c;
    }

    @Override
    public String Update(estancias est) {
        String sql = "UPDATE estancias SET "+
		"superficie=?,totalspanos=?, totalsventanas=?, totalspuertas=?, totalsarmarios=?,totalssuelos=?, totalstechos=?,alto=? "+
		"WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{est.getSuperficie(), est.getTotalSpanos(), est.getTotalSventanas(), est.getTotalSpuertas(),
            est.getTotalSarmarios(), est.getTotalSsuelos(), est.getTotalStechos(),est.getAlto(),est.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM estancias WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
