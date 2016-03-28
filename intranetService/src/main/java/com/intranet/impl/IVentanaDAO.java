/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.armarios;
import com.intranet.beans.panos;
import com.intranet.beans.puertas;
import com.intranet.beans.ventanas;
import com.intranet.dao.PanoDAO;
import com.intranet.dao.VentanaDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ventanaDAO")
public class IVentanaDAO extends UtilTemplateDAO implements VentanaDAO{
    @Autowired(required = true)
    PanoDAO panoDAO;
    
    public  List<ventanas> findAll (int idPano){
    String sql = "SELECT id, idpano, num, largo, alto, superficie" +
                "  FROM ventanas WHERE idpano=? ";
        List<ventanas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano},new RowMapper<ventanas>(){
        @Override
            public ventanas mapRow(ResultSet rs, int i) throws SQLException {
                ventanas e = new ventanas();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                return e;
        }
        });
        
        return est;
    }
    public  List<ventanas> findAllEstanciaVentanas (int idE){
    String sql = "SELECT v.id, v.idpano, v.num, v.largo,v.alto, v.superficie " +
                " FROM ventanas v inner join panos p on(v.idpano=p.id) WHERE p.estancia_id=? ";
        List<ventanas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idE},new RowMapper<ventanas>(){
        @Override
            public ventanas mapRow(ResultSet rs, int i) throws SQLException {
                ventanas e = new ventanas();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                return e;
        }
        });
        
        return est;
    }
    public  float findAllEstancia (int idE){
    String sql = "SELECT round(sum(v.superficie),2) as suma " +
                "FROM ventanas v inner join panos p on(v.idpano=p.id) WHERE p.estancia_id=? ";
        float est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idE},new RowMapper<Float>(){
        @Override
            public Float mapRow(ResultSet rs, int i) throws SQLException {
                float e = rs.getFloat("suma");
                return e;
        }
        });
        
        return est;
    }
    public  List<ventanas> findAllPresupSuperficies (int idPano,int idPresupSupPano){
    String sql = "select * from ((select id,idpano,num,largo,alto,superficie,1 as agregado from ventanas where idpano=? and id in(select idpva from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)) union "+ 
                " (select id,idpano,num,largo,alto,superficie,0 as agregado from ventanas where idpano=? and id not in(select idpva from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)))as d order by id asc ";
        List<ventanas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano,idPresupSupPano,idPano,idPresupSupPano},new RowMapper<ventanas>(){
        @Override
            public ventanas mapRow(ResultSet rs, int i) throws SQLException {
                ventanas e = new ventanas();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                e.setAgregado(rs.getInt("agregado"));
                return e;
        }
        });
        
        return est;
    }
    public  List<puertas> findAllPresupSuperficiesP (int idPano,int idPresupSupPano){
    String sql = "select * from ((select id,idpano,num,largo,alto,superficie,1 as agregado from puertas where idpano=? and id in(select idpuerta from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)) union "+ 
                " (select id,idpano,num,largo,alto,superficie,0 as agregado from puertas where idpano=? and id not in(select idpuerta from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)))as d order by id asc ";
        List<puertas> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano,idPresupSupPano,idPano,idPresupSupPano},new RowMapper<puertas>(){
        @Override
            public puertas mapRow(ResultSet rs, int i) throws SQLException {
                puertas e = new puertas();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                e.setAgregado(rs.getInt("agregado"));
                return e;
        }
        });
        
        return est;
    }
    public  List<armarios> findAllPresupSuperficiesA (int idPano,int idPresupSupPano){
    String sql = "select * from ((select id,idpano,num,largo,alto,superficie,1 as agregado from armarios where idpano=? and id in(select idparmario from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)) union "+ 
                " (select id,idpano,num,largo,alto,superficie,0 as agregado from armarios where idpano=? and id not in(select idarmario from presupuesto_superficies_panos_vpa where idpresup_sup_pano=?)))as d order by id asc ";
        List<armarios> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPano,idPresupSupPano,idPano,idPresupSupPano},new RowMapper<armarios>(){
        @Override
            public armarios mapRow(ResultSet rs, int i) throws SQLException {
                armarios e = new armarios();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                e.setAgregado(rs.getInt("agregado"));
                return e;
        }
        });
        
        return est;
    }
    public  ventanas porID (int id){
        String sql = "SELECT id, idpano, num, largo, alto, superficie" +
                "  FROM ventanas WHERE id=? ";
       ventanas est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<ventanas>(){
        @Override
            public ventanas mapRow(ResultSet rs, int i) throws SQLException {
                ventanas e = new ventanas();
                e.setId(rs.getInt(1));
                int idP=rs.getInt("idpano");
                try {
                    if(idP!=0){
                    panos p=new panos();
                    p.setId(idP);
                     e.setIdpano(p);
                    }
                   
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                e.setNum(rs.getInt("num"));
                e.setLargo(rs.getFloat("largo"));
                e.setAlto(rs.getFloat("alto"));
                e.setSuperficie(rs.getFloat("superficie"));
                return e;
        }
        });
        
        return est;
    }
    
    public  String Insert (ventanas v){
        System.out.println("ventana pano: "+v.getIdpano().getId()+"- num: "+v.getNum()+". largo: "+v.getLargo()+". alto: "+v.getAlto()+" superficie: "+v.getSuperficie());
    String sql = "INSERT INTO ventanas("+
                "idpano, num, largo, alto, superficie) "+
                "VALUES (?, ?, ?, ?, ?) ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getIdpano().getId(),v.getNum(),v.getLargo(),v.getAlto(),v.getSuperficie()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }
	public  String Update (ventanas v){
            String sql = "UPDATE ventanas SET "+
                " largo=?, alto=?, superficie=? "+
                "WHERE id=? ";
        int c=this.getJdbcTemplate().update(sql, new Object[]{v.getLargo(),v.getAlto(),v.getSuperficie(),v.getId()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
        }
	public  String Delete (Integer id){
            String sql = "DELETE FROM ventanas WHERE id=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
            }
	public  String DeletePano (Integer id){
            String sql = "DELETE FROM ventanas WHERE idpano=? ";
            int c=this.getJdbcTemplate().update(sql, new Object[]{id});
            String rpta="ERROR!... No se pudo INSERTAR el Registro";
            if(c>0){
                rpta="Se INSERTO Satisfactoriamente...!";
            }
            return rpta;
        }
        
}
