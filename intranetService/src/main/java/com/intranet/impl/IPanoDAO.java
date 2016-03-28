/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.cursos;
import com.intranet.beans.estancias;
import com.intranet.beans.estudios;
import com.intranet.beans.panos;
import com.intranet.beans.tipo_pano;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.PanoDAO;
import com.intranet.dao.PresupuestoSuperficiesPanosDAO;
import com.intranet.dao.TipoPanoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("panoDAO")
public class IPanoDAO extends UtilTemplateDAO implements PanoDAO{
    
    @Autowired(required = true)
    EstanciasDAO estanciasDAO;
    @Autowired(required = true)
    TipoPanoDAO tipoPanoDAO;
    @Autowired(required = true)
    PresupuestoSuperficiesPanosDAO presupuestoSuperficiesPanosDAO;
    
    @Override
    public List<panos> findAll(int idEstancia) {
        String sql = "SELECT id,estancia_id, tipo_pano_id, largo, alto, superficie, numventana,"+
	     "largoventana, altoventana, superficieventana, numpuertas, largopuerta,"+
	     "altopuerta, superficiepuerta, numarmarios, largoarmario, altoarmario,"+
	     "fondoarmario, superficiearmario,nombrepano,numero,totalsuperficie,ventana,puertas,armario,lado3,forma "+
	     "FROM panos WHERE estancia_id=? ";
        List<panos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idEstancia},new RowMapper<panos>(){
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
                        e.setSuperficie(rs.getFloat(6));
                        e.setNumventanas(rs.getInt(7));
                        e.setLargoventana(rs.getFloat(8));
                        e.setAltoventana(rs.getFloat(9));
                        e.setSuperficieventana(rs.getFloat(10));
                        e.setNumpuertas(rs.getInt(11));
                        e.setLargopuerta(rs.getFloat(12));
                        e.setAltopuerta(rs.getFloat(13));
                        e.setSuperficiepuerta(rs.getFloat(14));
                        e.setNumarmarios(rs.getInt(15));
                        e.setLargoarmario(rs.getFloat(16));
                        e.setAltoarmario(rs.getFloat(17));
                        e.setFondoarmario(rs.getFloat(18));
                        e.setSuperficiearmario(rs.getFloat(19));
                        e.setNombrepano(rs.getString(20));
                        e.setNumero(rs.getInt(21));
                        e.setTotal(rs.getFloat(22));
                        e.setVentana(rs.getString(23));
                        e.setPuertas(rs.getString(24));
                        e.setArmario(rs.getString(25));
                        e.setLado3(rs.getFloat(26));
                        e.setFormapano(rs.getInt(27));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<panos> findAllPresupSuperf(int idE,int idPresu) {
        String sql = "select * from ((SELECT id,estancia_id, tipo_pano_id, largo, alto, superficie, numventana, "+
             "largoventana, altoventana, superficieventana, numpuertas, largopuerta,"+
	     "altopuerta, superficiepuerta, numarmarios, largoarmario, altoarmario,"+
	     "fondoarmario, superficiearmario,nombrepano,numero,totalsuperficie,ventana,puertas,armario,lado3,forma,1 as agregado "+
	     "FROM panos WHERE estancia_id=? and id in( select idpano from presupuesto_superficies_panos where idpresup_sup=?)) union "+
             "(SELECT id,estancia_id, tipo_pano_id, largo, alto, superficie, numventana, "+
             "largoventana, altoventana, superficieventana, numpuertas, largopuerta,"+
	     "altopuerta, superficiepuerta, numarmarios, largoarmario, altoarmario,"+
	     "fondoarmario, superficiearmario,nombrepano,numero,totalsuperficie,ventana,puertas,armario,lado3,forma,0 as agregado "+
	     "FROM panos WHERE estancia_id=? and id not in( select idpano from presupuesto_superficies_panos where idpresup_sup=?)))as d order by id asc ";
        List<panos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idE,idPresu,idE,idPresu},new RowMapper<panos>(){
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
                        e.setSuperficie(rs.getFloat(6));
                        e.setNumventanas(rs.getInt(7));
                        e.setLargoventana(rs.getFloat(8));
                        e.setAltoventana(rs.getFloat(9));
                        e.setSuperficieventana(rs.getFloat(10));
                        e.setNumpuertas(rs.getInt(11));
                        e.setLargopuerta(rs.getFloat(12));
                        e.setAltopuerta(rs.getFloat(13));
                        e.setSuperficiepuerta(rs.getFloat(14));
                        e.setNumarmarios(rs.getInt(15));
                        e.setLargoarmario(rs.getFloat(16));
                        e.setAltoarmario(rs.getFloat(17));
                        e.setFondoarmario(rs.getFloat(18));
                        e.setSuperficiearmario(rs.getFloat(19));
                        e.setNombrepano(rs.getString(20));
                        e.setNumero(rs.getInt(21));
                        e.setTotal(rs.getFloat(22));
                        e.setVentana(rs.getString(23));
                        e.setPuertas(rs.getString(24));
                        e.setArmario(rs.getString(25));
                        e.setLado3(rs.getFloat(26));
                        e.setFormapano(rs.getInt(27));
                        e.setAgeregado(rs.getInt("agregado"));
                return e;
        }
        });
        
        return est;
    }
    
    @Override
    public panos porID(int id) {
        String sql = "SELECT id,estancia_id, tipo_pano_id, largo, alto, superficie, numventana,"+
	     "largoventana, altoventana, superficieventana, numpuertas, largopuerta,"+
	     "altopuerta, superficiepuerta, numarmarios, largoarmario, altoarmario,"+
	     "fondoarmario, superficiearmario,nombrepano,numero,totalsuperficie,ventana,puertas,armario,lado3,forma,lado4 "+
	     "FROM panos WHERE id=? ";
        panos est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<panos>(){
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
                        e.setSuperficie(rs.getFloat(6));
                        e.setNumventanas(rs.getInt(7));
                        e.setLargoventana(rs.getFloat(8));
                        e.setAltoventana(rs.getFloat(9));
                        e.setSuperficieventana(rs.getFloat(10));
                        e.setNumpuertas(rs.getInt(11));
                        e.setLargopuerta(rs.getFloat(12));
                        e.setAltopuerta(rs.getFloat(13));
                        e.setSuperficiepuerta(rs.getFloat(14));
                        e.setNumarmarios(rs.getInt(15));
                        e.setLargoarmario(rs.getFloat(16));
                        e.setAltoarmario(rs.getFloat(17));
                        e.setFondoarmario(rs.getFloat(18));
                        e.setSuperficiearmario(rs.getFloat(19));
                        e.setNombrepano(rs.getString(20));
                        e.setNumero(rs.getInt(21));
                        e.setTotal(rs.getFloat(22));
                        e.setVentana(rs.getString(23));
                        e.setPuertas(rs.getString(24));
                        e.setArmario(rs.getString(25));
                        e.setLado3(rs.getFloat(26));
                        e.setFormapano(rs.getInt(27));
                        e.setLado4(rs.getFloat(28));
                return e;
        }
        });
        
        return est;
    }

   @Override
    public int idultimo(int idE) {
        String sql = "SELECT max(id) as c FROM panos WHERE estancia_id = ?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idE},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("c");
                return t;
        }
        });
    }
    
    @Override
    public int Insert(panos pa) {
        String sql = "INSERT INTO panos("+
                "estancia_id, tipo_pano_id, largo, alto, superficie,nombrepano,numero,lado3,forma,lado4) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pa.getEstancia_id().getId(), pa.getTipo_pano_id().getId(), pa.getLargo(),
            pa.getAlto(), pa.getSuperficie(),  pa.getNombrepano(), pa.getNumero(),pa.getLado3(),pa.getFormapano(),pa.getLado4()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return c;
    }
    @Override
    public int InsertVolcar(panos pa) {
        String sql = "INSERT INTO panos("+
                "estancia_id, tipo_pano_id, largo, alto, superficie, numventana,largoventana, altoventana, superficieventana, numpuertas, largopuerta, "+
                "altopuerta, superficiepuerta, numarmarios, largoarmario, altoarmario, fondoarmario, superficiearmario, nombrepano, numero, totalsuperficie, "+
                "ventana, puertas, armario, lado3, forma,lado4) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,"+
                        "?,?,?,?,?,?,?,?,?,?,"+
                        "?,?,?,?,?,?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pa.getEstancia_id().getId(), pa.getTipo_pano_id().getId(), pa.getLargo(),
            pa.getAlto(), pa.getSuperficie(), pa.getNumventanas(),pa.getLargoventana(), pa.getAltoventana(), pa.getSuperficieventana(),
            pa.getNumpuertas(), pa.getLargopuerta(), pa.getAltopuerta(), pa.getSuperficiepuerta(), pa.getNumarmarios(),
            pa.getLargoarmario(), pa.getAltoarmario(), pa.getFondoarmario(), pa.getSuperficiearmario(), pa.getNombrepano(), pa.getNumero(),
            pa.getTotal(),pa.getVentana(),pa.getPuertas(),pa.getArmario(),pa.getLado3(),pa.getFormapano(),pa.getLado4()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return c;
    }

    @Override
    public String Updateu(panos pa) {
    String sql = "UPDATE panos "+
            "SET tipo_pano_id=?,largo=?, alto=?,superficie=?, nombrepano=?,numero=?,lado3=?,forma=?,lado4=? "+
            "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pa.getTipo_pano_id().getId(), pa.getLargo(),
            pa.getAlto(), pa.getSuperficie(), pa.getNombrepano(), pa.getNumero(),pa.getLado3(),pa.getFormapano(),pa.getLado4(),pa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
@Override
    public String Update(panos pa) {
    String sql = "UPDATE panos "+
            "SET estancia_id=?, tipo_pano_id=?,largo=?, alto=?,superficie=?, numventana=?, "+
            "largoventana=?, altoventana=?, superficieventana=?, numpuertas=?, largopuerta=?,  "+
            "altopuerta=?, superficiepuerta=?, numarmarios=?, largoarmario=?, altoarmario=?, "+
            "fondoarmario=?, superficiearmario=?,nombrepano=?,numero=?,totalsuperficie=?,ventana=?,puertas=?,armario=?,lado3=?,forma=?,lado4=? "+
            "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pa.getEstancia_id().getId(), pa.getTipo_pano_id().getId(), pa.getLargo(),
            pa.getAlto(), pa.getSuperficie(), pa.getNumventanas(),pa.getLargoventana(), pa.getAltoventana(), pa.getSuperficieventana(),
            pa.getNumpuertas(), pa.getLargopuerta(), pa.getAltopuerta(), pa.getSuperficiepuerta(), pa.getNumarmarios(),
            pa.getLargoarmario(), pa.getAltoarmario(), pa.getFondoarmario(), pa.getSuperficiearmario(), pa.getNombrepano(), pa.getNumero(),
            pa.getTotal(),pa.getVentana(),pa.getPuertas(),pa.getArmario(),pa.getLado3(),pa.getFormapano(),pa.getLado4(),pa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateVentana(panos pa) {
    String sql = "UPDATE panos "+
            "SET numventana=?,ventana=?,superficieventana=?,totalsuperficie=? "+
            "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{ pa.getNumventanas(),pa.getVentana(),pa.getSuperficieventana(),pa.getTotal(),pa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdatePuerta(panos pa) {
    String sql = "UPDATE panos "+
            "SET numpuertas=?, puertas=? "+
            "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{pa.getNumpuertas(),pa.getPuertas(),pa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateArmario(panos pa) {
    String sql = "UPDATE panos "+
            "SET numarmarios=?, armario=? "+
            "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{ pa.getNumarmarios(),pa.getArmario(),pa.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM panos WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String DeleteEstancia(Integer id) {
        String sql = "DELETE FROM panos WHERE estancia_id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
