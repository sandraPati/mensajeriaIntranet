/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.capitulos;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.subcapitulos;
import com.intranet.beans.tipo_pano;
import com.intranet.dao.CapituloDAO;
import com.intranet.dao.EstanciasDAO;
import com.intranet.dao.PresupuestoDAO;
import com.intranet.dao.SubCapitulosDAO;
import com.intranet.dao.TipoPanoDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("presupuestoDAO")
public class IPresupuestoDAO extends UtilTemplateDAO implements PresupuestoDAO{

    @Autowired(required = true)
    EstanciasDAO estanciasDAO;
    @Autowired(required = true)
    CapituloDAO capituloDAO;
    @Autowired(required = true)
    SubCapitulosDAO subCapituloDAO;
    @Autowired(required = true)
    TipoPanoDAO tipoPanoDAO;
    
    @Override
    public presupuesto porID(int id) {
        String sql = "SELECT id, subcapitulo_id, monto, "+
	      "descripcion, tipocantidad, cantidad, precio,presup_id "+
	      "FROM presupuesto WHERE id=? ";
        presupuesto est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<presupuesto>(){
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

    @Override
    public int buscar(presupuesto p) {
        /*String sql = "SELECT max(id)as m FROM presupuesto "+
	   "WHERE propuesta_id=? and capitulo_id=? and subcapitulo_id=? ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{p.getPropuesta_id(),p.getCapitulo_id().getId(),p.getSubcapitulo().getId()},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer t = rs.getInt("m");
                return t;
        }
        });*/
        return 0;
    }

    @Override
    public List<presupuesto> findAll(int idPc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<presupuesto> presupuestoPropuesta(int idPresupC) {
        String sql = "SELECT id, subcapitulo_id, monto, "+
	      "descripcion, tipocantidad, cantidad, precio,presup_id "+
	      "FROM presupuesto WHERE presup_id=? ";
        List<presupuesto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPresupC},new RowMapper<presupuesto>(){
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

    @Override
    public List<presupuesto> presupuestoEstancia(int idestancia) {
        /*String sql = "SELECT id,capitulo_id, subcapitulo_id FROM presupuesto "+
	      "WHERE estancia_id=? ";
        List<presupuesto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idestancia},new RowMapper<presupuesto>(){
        @Override
            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto pre = new presupuesto();
                pre.setId(rs.getInt(1));
                int idC=rs.getInt("capitulo_id");
                int idSC=rs.getInt("subcapitulo_id");
                try {
                    if(idC!=0){
                        capitulos cu2=capituloDAO.porId(idC);
                        pre.setCapitulo_id(cu2);
                    }
                    if(idSC!=0){
                        subcapitulos cu3=subCapituloDAO.porId(idSC);
                        pre.setSubcapitulo(cu3);
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
    public estancias estanciasPropuesta(int idpropuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<panos> panosPropuesta(int idestancia) {
        String sql = "SELECT id, estancia_id, tipo_pano_id, largo, alto, superficie FROM panos "+
	        "WHERE estancia_id=?";
        List<panos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idestancia},new RowMapper<panos>(){
        @Override
            public panos mapRow(ResultSet rs, int i) throws SQLException {
                panos pre = new panos();
                pre.setId(rs.getInt(1));
                int idE=rs.getInt("estancia_id");
                int idTP=rs.getInt("tipo_pano_id");
                
                try {
                    if(idE!=0){
                        estancias cu=estanciasDAO.porID(idE);
                        pre.setEstancia_id(cu);
                    }
                    if(idTP!=0){
                        tipo_pano cu2=tipoPanoDAO.porId(idTP);
                        pre.setTipo_pano_id(cu2);
                    }
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                pre.setLargo(rs.getFloat(4));
	        pre.setAlto(rs.getFloat(5));
	        pre.setSuperficie(rs.getFloat(6));
                try{
                    estancias estn=estanciasDAO.porID(pre.getId());
                    pre.setEstancia_id(estn);
                }catch(Exception exce){
                    exce.getMessage();
                }
                return pre;
        }
        });
        
        return est;
    }

    @Override
    public String Insert(presupuesto presu) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuesto("+
            "subcapitulo_id, tipocantidad,presup_id,precio)"+
            "VALUES (?,?,?,?) ";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getIdSubCap(),
            presu.getTipoCantidad(),presu.getPresup_id(),presu.getPrecio()});
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String InsertT(presupuesto presu) {
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        int c=0;
        
        String sql = "INSERT INTO presupuesto("+
            "subcapitulo_id, tipocantidad,presup_id,precio,monto,cantidad)"+
            "VALUES (?,?,?,?,?,?) ";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getIdSubCap(),
            presu.getTipoCantidad(),presu.getPresup_id(),presu.getPrecio(),presu.getMonto(),presu.getCantidad()});
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(presupuesto presu) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto SET "+
        "monto=?, descripcion=?,tipocantidad=?,cantidad=?,precio=?  WHERE id=?  ";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getMonto(),
            presu.getDescripcion(), presu.getTipoCantidad(), presu.getCantidad(), presu.getPrecio(), presu.getId()});
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateM(presupuesto presu) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto SET "+
        "monto=?, tipocantidad=?,cantidad=? WHERE id=?  ";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getMonto(),
             presu.getTipoCantidad(), presu.getCantidad(), presu.getId()});
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    @Override
    public String UpdateMedida (presupuesto presu) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto SET "+
        "tipocantidad=? WHERE presup_id=? and  subcapitulo_id=? ";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getTipoCantidad(),presu.getPresup_id(),presu.getIdSubCap()});
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public String UpdateMonto(presupuesto presu) {
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        int c=0;
        
        String sql = "UPDATE presupuesto SET monto=? WHERE id=?";
        c=this.getJdbcTemplate().update(sql, new Object[]{presu.getMonto(),presu.getId()});
        if(c>0){
            rpta="Se ACTUALIZADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
    @Override
    public int DeleteU(Integer id) {
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuesto WHERE presup_id=? ";
        c=this.getJdbcTemplate().update(sql, new Object[]{id});
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
    
     @Override
    public int DeleteP(Integer id) {
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuesto WHERE id=? ";
        c=this.getJdbcTemplate().update(sql, new Object[]{id});
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
    
     @Override
    public  int DeleteSC (int idPresup,int idSc) {
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuesto WHERE presup_id=?  and subcapitulo_id=?";
        c=this.getJdbcTemplate().update(sql, new Object[]{idPresup,idSc});
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }

    @Override
    public int Delete(Integer id) {
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        int c=0;
        
        String sql = "DELETE FROM presupuesto WHERE presup_id=?  and tipocantidad='m2'";
        c=this.getJdbcTemplate().update(sql, new Object[]{id});
        if(c>0){
            rpta="Se ELIMINO Satisfactoriamente...!";
        }
        return c;
    }
    
    @Override
    public List<capitulos> capitulosEnPresupuestosdePropuesta(int idpropuesta) {
        String sql = "SELECT distinct p.capitulo_id,c.nombre,c.cod "+
        "FROM presupuesto p INNER JOIN capitulos c on(p.capitulo_id=c.id) "+ 
        "where propuesta_id=? "+
        "group by p.capitulo_id,c.nombre,c.cod ";
        List<capitulos> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idpropuesta},new RowMapper<capitulos>(){
        @Override
            public capitulos mapRow(ResultSet rs, int i) throws SQLException {
                capitulos pre = new capitulos();
                pre.setId(rs.getInt(1));
                pre.setNombre(rs.getString(2));
                pre.setCod(rs.getString(3));
                return pre;
        }
        });
        
        return est;
    }

    @Override
    public List<presupuesto> subcapPresupuesto(int idpropuesta, int idcapitulo) {
        String sql = "SELECT p.id, p.subcapitulo_id,p.descripcion,p.cantidad,p.precio,p.monto,p.tipocantidad,p.presup_id "+
        "FROM presupuesto p inner join presupuestoc pc on(p.presup_id=pc.id)"+ 
        "where pc.propuesta_id=? and pc.capitulo_id=? ";
        List<presupuesto> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idpropuesta,idcapitulo},new RowMapper<presupuesto>(){
        @Override
            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto pre = new presupuesto();
                pre.setId(rs.getInt(1));
                
                int idSC=rs.getInt("subcapitulo_id");
                try {
                    
                    if(idSC!=0){
                    subcapitulos cu2=subCapituloDAO.porId(idSC);
                    pre.setSubcapitulo(cu2);
                    }
                    
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                pre.setDescripcion(rs.getString(3));
                pre.setCantidad(rs.getFloat(4));
	        pre.setPrecio(rs.getFloat(5));
	        pre.setMonto(rs.getFloat(6));
	        pre.setTipoCantidad(rs.getString(7));
                pre.setPresup_id(rs.getInt(8));
                return pre;
        }
        });
        
        return est;
    }
   
    
    
    
    public List<presupuesto> presupuestoSUBCapitulos(int idP) {
        String sql="select pre.id,pre.subcapitulo_id,pre.presup_id,pre.monto, pre.descripcion, pre.tipocantidad, pre.cantidad, pre.precio "+
                "from presupuesto pre where pre.presup_id=?";
        List<presupuesto> lta=this.getJdbcTemplate().query(sql,new Object[]{idP},new RowMapper<presupuesto>(){

            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto p=new presupuesto();
                p.setId(rs.getInt(1));
                p.setPresup_id(rs.getInt(3));
                p.setIdSubCap(rs.getInt(2));
                p.setMonto(rs.getFloat(4));
                p.setDescripcion(rs.getString(5));
                p.setTipoCantidad(rs.getString(6));
                p.setCantidad(rs.getFloat(7));
                p.setPrecio(rs.getFloat(8));
                try {
                    
                    if(p.getIdSubCap()!=0){
                        subcapitulos c=subCapituloDAO.porId(p.getIdSubCap());
                        
                        p.setSubcapitulo(c);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                return p;
            }
            
        });
        
        
        return lta;
    }
    
    public List<presupuesto> presupuestoSUBCapitulosADD(int idP,int idC) {
        String sql="select * from((select pre.id,pre.subcapitulo_id,s.cod,s.nombre,s.nota,s.cantidad,pre.presup_id,pre.tipoCantidad from presupuesto pre inner join subcapitulos s on(pre.subcapitulo_id=s.id) where pre.presup_id=?) "+
                "union (select 0 as id,id as subcapitulo_id,cod,nombre,nota,cantidad,0 as presup_id,''as tipoCantidad from subcapitulos where id_capitulo=? and id not in (select pre.subcapitulo_id from presupuesto pre inner join subcapitulos s on(pre.subcapitulo_id=s.id) where pre.presup_id=?) ))d order by cod asc";
        List<presupuesto> lta=this.getJdbcTemplate().query(sql,new Object[]{idP,idC,idP},new RowMapper<presupuesto>(){

            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto p=new presupuesto();
                p.setId(rs.getInt(1));
                p.setPresup_id(rs.getInt(7));
                p.setIdSubCap(rs.getInt(2));
                p.setTipoCantidad(rs.getString(8));
                try {
                    
                    if(p.getIdSubCap()!=0){
                        subcapitulos c=subCapituloDAO.porId(p.getIdSubCap());
                        
                        p.setSubcapitulo(c);
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
    public presupuesto buscarPresupSC(int idPre,int idSc) {
        String sql = "SELECT p.id,p.subcapitulo_id,p.monto,p.descripcion,p.tipocantidad,p.cantidad,p.precio,p.presup_id,pre.capitulo_id,pre.propuesta_id as m FROM presupuesto p "+
                "inner join presupuestoc pre on(p.presup_id=pre.id) "+
	   "WHERE p.presup_id=? and p.subcapitulo_id=?  ";
        presupuesto pre= this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPre,idSc},new RowMapper<presupuesto>(){
        @Override
            public presupuesto mapRow(ResultSet rs, int i) throws SQLException {
                presupuesto t = new presupuesto();
                t.setId(rs.getInt(1));
                t.setIdSubCap(rs.getInt(2));
                t.setMonto(rs.getFloat(3));
                t.setDescripcion(rs.getString(4));
                t.setTipoCantidad(rs.getString(5));
                t.setCantidad(rs.getFloat(6));
                t.setPrecio(rs.getFloat(7));
                t.setPresup_id(rs.getInt(8));
                t.setProp(rs.getInt(10));
                try{
                    subcapitulos s=subCapituloDAO.porId(t.getIdSubCap());
                    t.setSubcapitulo(s);
                    capitulos c=capituloDAO.porId(rs.getInt(9));
                    
                    t.setCapitulo(c);
                }catch(Exception e){}
                
                return t;
        }
        });
        return pre;
    }
    
    @Override
    public int buscarPresupSCid(int idPre,int idSc) {
        String sql = "SELECT id FROM presupuesto p "+
	   "WHERE p.presup_id=? and p.subcapitulo_id=?  ";
        int pre= this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPre,idSc},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                int t = rs.getInt(1);
                return t;
        }
        });
        return pre;
    }
    
    @Override
    public int buscarPresupSCcount(int idPre,int idSc) {
        String sql = "SELECT count(id)as id FROM presupuesto p "+
	   "WHERE p.presup_id=? and p.subcapitulo_id=?  ";
        int pre= this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPre,idSc},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                int t = rs.getInt(1);
                return t;
        }
        });
        return pre;
    }
}
