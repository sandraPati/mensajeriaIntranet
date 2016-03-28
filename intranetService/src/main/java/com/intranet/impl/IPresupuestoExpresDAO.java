/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto_expres;
import com.intranet.beans.tipo_pano;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.PresupuestoExpresDAO;
import com.intranet.dao.TipoPanoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoExpresDAO")
public class IPresupuestoExpresDAO extends UtilTemplateDAO implements PresupuestoExpresDAO{
    @Autowired
    EstanciasDAO estanciasDAO;
    @Autowired
    TipoPanoDAO tipoPanoDAO;
    public presupuesto_expres presupExpresIDE(int id) {
        String sql = "SELECT id, idpropuesta, idestancia, cambiarfalsotecho, falsotecho, nventana, "+
                "ventana, puerta, puertatipo, puntosluz, puntosenchufe, nradiador, "+
                "radiadortipo, fontaneriapuntos, ducha, duchatipo, inodoro, lavabo, "+
                "bide, eliminar, eliminarcual, llavecorte, demolermuro, falsotechonuevo,panotipo "+
	      "FROM presupuesto_expres  WHERE id=?";
        presupuesto_expres est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<presupuesto_expres>(){
        @Override
            public presupuesto_expres mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_expres pre = new presupuesto_expres();
                pre.setId(rs.getInt(1));
                pre.setIdpropuesta(rs.getInt(2));
                pre.setIdestancia(rs.getInt(3));
                pre.setCambiarfalsotecho(rs.getInt(4));
                pre.setFalsotechopano(rs.getInt(5));
                pre.setNventana(rs.getInt(6));
                pre.setPuerta(rs.getInt(8));
                pre.setPuertatipo(rs.getInt(9));
                pre.setPuntosluz(rs.getInt(10));
                pre.setPuntosenchufe(rs.getInt(11));
                pre.setNradiador(rs.getInt(12));
                pre.setRadiadortipo(rs.getInt(13));
                pre.setFontaneriapuntos(rs.getInt(14));
                pre.setDucha(rs.getInt(15));
                pre.setDuchatipo(rs.getInt(16));
                pre.setInodoro(rs.getInt(17));
                pre.setLavabo(rs.getInt(18));
                pre.setBide(rs.getInt(19));
                pre.setEliminar(rs.getInt(20));
                pre.setEliminarcual(rs.getString(21));
                pre.setLlavecorte(rs.getInt(22));
                pre.setDemolermuro(rs.getFloat(23));
                pre.setFalsotechonuevo(rs.getFloat(24));
                pre.setPanotipo(rs.getInt(25));
                return pre;
        }
        });
        
        return est;
    }

    
    public presupuesto_expres presupExpresIDE2(int id) {
        String sql = "SELECT id, idpropuesta, idestancia, cambiarfalsotecho, falsotecho, nventana, "+
                "ventana, puerta, puertatipo, puntosluz, puntosenchufe, nradiador, "+
                "radiadortipo, fontaneriapuntos, "+
                " eliminar, eliminarcual, llavecorte, demolermuro, falsotechonuevo,panotipo,puntospvh,puntosptv,puntosptt,igg,mobe,mobn "+
	      "FROM presupuesto_expres  WHERE id=?";
        presupuesto_expres est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<presupuesto_expres>(){
        @Override
            public presupuesto_expres mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto_expres pre = new presupuesto_expres();
                pre.setId(rs.getInt(1));
                pre.setIdpropuesta(rs.getInt(2));
                pre.setIdestancia(rs.getInt(3));
                pre.setCambiarfalsotecho(rs.getInt(4));
                pre.setFalsotechopano(rs.getInt(5));
                pre.setNventana(rs.getInt(6));
                pre.setPuerta(rs.getInt(8));
                pre.setPuertatipo(rs.getInt(9));
                pre.setPuntosluz(rs.getInt(10));
                pre.setPuntosenchufe(rs.getInt(11));
                pre.setNradiador(rs.getInt(12));
                pre.setRadiadortipo(rs.getInt(13));
                pre.setFontaneriapuntos(rs.getInt(14));
                
                pre.setEliminar(rs.getInt(15));
                pre.setEliminarcual(rs.getString(16));
                pre.setLlavecorte(rs.getInt(17));
                pre.setDemolermuro(rs.getFloat(18));
                pre.setFalsotechonuevo(rs.getFloat(19));
                pre.setPanotipo(rs.getInt(20));
                pre.setPuntospvh(rs.getInt(21));
                pre.setPuntosptv(rs.getInt(22));
                pre.setPuntosptt(rs.getInt(23));
                pre.setIgg(rs.getInt(24));
                pre.setMobe(rs.getInt(25));
                pre.setMobn(rs.getFloat(26));
                return pre;
        }
        });
        
        return est;
    }

    public boolean insert(presupuesto_expres obj) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuesto_expres(idpropuesta, idestancia, cambiarfalsotecho, falsotecho, nventana, "+
                " ventana, puerta, puertatipo, puntosluz, puntosenchufe, nradiador, "+
                "radiadortipo, fontaneriapuntos, ducha, duchatipo, inodoro, lavabo, "+
                "bide, eliminar, eliminarcual, llavecorte, demolermuro, falsotechonuevo,panotipo) "+
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getIdpropuesta(),obj.getIdestancia(),obj.getCambiarfalsotecho(),0,
        obj.getNventana(),0,obj.getPuerta(),obj.getPuertatipo(),obj.getPuntosluz(),obj.getPuntosenchufe(),obj.getNradiador(),obj.getRadiadortipo(),
        obj.getFontaneriapuntos(),obj.getDucha(),obj.getDuchatipo(),obj.getInodoro(),obj.getLavabo(),obj.getBide(),obj.getEliminar(),obj.getEliminarcual(),
        obj.getLlavecorte(),obj.getDemolermuro(),obj.getFalsotechonuevo(),obj.getPanotipo()});
       if(r>0) return true;
       else return false;
    }

    public boolean update(presupuesto_expres obj) {
       String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto_expres SET  cambiarfalsotecho=?, falsotecho=?, nventana=?, ventana=?, puerta=?, puertatipo=?, puntosluz=?, puntosenchufe=?, "+
                "nradiador=?, radiadortipo=?, fontaneriapuntos=?, ducha=?, duchatipo=?, inodoro=?, lavabo=?, bide=?, eliminar=?, eliminarcual=?, llavecorte=?, "+
                "demolermuro=?, falsotechonuevo=?,panotipo=? WHERE id=?";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getCambiarfalsotecho(),0,
        obj.getNventana(),0,obj.getPuerta(),obj.getPuertatipo(),obj.getPuntosluz(),obj.getPuntosenchufe(),obj.getNradiador(),obj.getRadiadortipo(),
        obj.getFontaneriapuntos(),obj.getDucha(),obj.getDuchatipo(),obj.getInodoro(),obj.getLavabo(),obj.getBide(),obj.getEliminar(),obj.getEliminarcual(),
        obj.getLlavecorte(),obj.getDemolermuro(),obj.getFalsotechonuevo(),obj.getPanotipo(),obj.getId()});
       if(r>0) return true;
       else return false;
    }
    
    public boolean insert2(presupuesto_expres obj) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuesto_expres(idpropuesta, idestancia, cambiarfalsotecho, falsotecho, nventana, "+
                " ventana, puerta, puertatipo, puntosluz, puntosenchufe, nradiador, "+
                "radiadortipo, fontaneriapuntos, "+
                " eliminar, eliminarcual, llavecorte, demolermuro, falsotechonuevo,panotipo,puntospvh,puntosptv,puntosptt,igg,mobe,mobn) "+
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getIdpropuesta(),obj.getIdestancia(),obj.getCambiarfalsotecho(),0,
        obj.getNventana(),0,obj.getPuerta(),obj.getPuertatipo(),obj.getPuntosluz(),obj.getPuntosenchufe(),obj.getNradiador(),obj.getRadiadortipo(),
        obj.getFontaneriapuntos(),obj.getEliminar(),obj.getEliminarcual(),
        obj.getLlavecorte(),obj.getDemolermuro(),obj.getFalsotechonuevo(),obj.getPanotipo(),obj.getPuntospvh(),obj.getPuntosptv(),obj.getPuntosptt(),
        obj.getIgg(),obj.getMobe(),obj.getMobn()});
       if(r>0) return true;
       else return false;
    }

    public boolean update2(presupuesto_expres obj) {
       String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto_expres SET  cambiarfalsotecho=?, falsotecho=?, nventana=?, ventana=?, puerta=?, puertatipo=?, puntosluz=?, puntosenchufe=?, "+
                "nradiador=?, radiadortipo=?, fontaneriapuntos=?, eliminar=?, eliminarcual=?, llavecorte=?, "+
                "demolermuro=?, falsotechonuevo=?,panotipo=?,puntospvh=?,puntosptv=?,puntosptt=?,igg=?,mobe=?,mobn=? WHERE id=?";
        int r= this.getJdbcTemplate().update(sql, new Object[]{obj.getCambiarfalsotecho(),0,
        obj.getNventana(),0,obj.getPuerta(),obj.getPuertatipo(),obj.getPuntosluz(),obj.getPuntosenchufe(),obj.getNradiador(),obj.getRadiadortipo(),
        obj.getFontaneriapuntos(),obj.getEliminar(),obj.getEliminarcual(),
        obj.getLlavecorte(),obj.getDemolermuro(),obj.getFalsotechonuevo(),obj.getPanotipo(),obj.getPuntospvh(),obj.getPuntosptv(),
        obj.getPuntosptt(),obj.getIgg(),obj.getMobe(),obj.getMobn(),obj.getId()});
       if(r>0) return true;
       else return false;
    }

    public int existe(int idP, int idE) {
       String sql = "SELECT id FROM presupuesto_expres "+
	   "WHERE idpropuesta=? and idestancia=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idP,idE},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("id");
                return t;
        }
        });
    }
     public int existecount(int idP, int idE) {
       String sql = "SELECT count(id)as c FROM presupuesto_expres "+
	   "WHERE idpropuesta=? and idestancia=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idP,idE},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }

    public boolean delete(int idP, int idE) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "DELETE from presupuesto_expres WHERE idpropuesta=? and idestancia=?";
        int r= this.getJdbcTemplate().update(sql, new Object[]{idP,idE});
       if(r>0) return true;
       else return false;
    }
     public boolean deleteP(int idP) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "DELETE from presupuesto_expres WHERE idpropuesta=? ";
        int r= this.getJdbcTemplate().update(sql, new Object[]{idP});
       if(r>0) return true;
       else return false;
    }
    
     
     @Override
    public List<panos> panosExpres(int idE) {
        String sql = "select * from ((SELECT p.id,p.estancia_id, p.tipo_pano_id, p.largo,p.alto, ex.medialtura, ( p.largo*ex.medialtura) as superficie,p.nombrepano,1 as agregado "+
	     "FROM presupuesto_expres_panos ex inner join panos p on(ex.idpano=p.id) WHERE p.estancia_id=? and p.id in( select idpano from presupuesto_expres_panos)) union "+
             "(SELECT p.id,p.estancia_id, p.tipo_pano_id, p.largo, p.alto,p.alto as medialtura ,p.superficie,p.nombrepano,0 as agregado "+
	     "FROM panos p  WHERE p.estancia_id=? and p.id not in( select idpano from presupuesto_expres_panos)))as d order by id asc ";
        List<panos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idE,idE},new RowMapper<panos>(){
        @Override
            public panos mapRow(ResultSet rs, int i) throws SQLException {
                panos e = new panos();
                e.setId(rs.getInt(1));
                int idE=rs.getInt("estancia_id");
                int idTP=rs.getInt("tipo_pano_id");
                try {
                    if(idE!=0){
                    estancias cu=estanciasDAO.porID(idE);
                    e.setEstancia_id(cu);
                    }
                    if(idTP!=0){
                    tipo_pano cu2=tipoPanoDAO.porId(idTP);
                    e.setTipo_pano_id(cu2);
                    }
                    
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	                e.setLargo(rs.getFloat(4));
                        e.setAlto(rs.getFloat(5));
                        e.setLargopresupuesto(rs.getFloat(6));
                        e.setSuperficie(rs.getFloat(7));
                        e.setNombrepano(rs.getString(8));
                        e.setAgeregado(rs.getInt("agregado"));
                        
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public List<panos> panosExpresElejidos(int idE) {
        String sql = "select * from (SELECT p.id,p.estancia_id, p.tipo_pano_id, p.largo,p.alto, ex.medialtura, ( p.largo*ex.medialtura) as superficie,p.nombrepano,1 as agregado "+
	     "FROM presupuesto_expres_panos ex inner join panos p on(ex.idpano=p.id) WHERE p.estancia_id=? and p.id in( select idpano from presupuesto_expres_panos))  "+
             "as d order by id asc ";
        List<panos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idE},new RowMapper<panos>(){
        @Override
            public panos mapRow(ResultSet rs, int i) throws SQLException {
                panos e = new panos();
                e.setId(rs.getInt(1));
                int idE=rs.getInt("estancia_id");
                int idTP=rs.getInt("tipo_pano_id");
                try {
                    if(idE!=0){
                    estancias cu=estanciasDAO.porID(idE);
                    e.setEstancia_id(cu);
                    }
                    if(idTP!=0){
                    tipo_pano cu2=tipoPanoDAO.porId(idTP);
                    e.setTipo_pano_id(cu2);
                    }
                    
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
	                e.setLargo(rs.getFloat(4));
                        e.setAlto(rs.getFloat(5));
                        e.setLargopresupuesto(rs.getFloat(6));
                        e.setSuperficie(rs.getFloat(7));
                        e.setNombrepano(rs.getString(8));
                        e.setAgeregado(rs.getInt("agregado"));
                        
                return e;
        }
        });
        
        return est;
    }
    
}
