/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.impl;

import com.intranet.beans.empleados;
import com.intranet.beans.propuesta;
import com.intranet.beans.proyecto_presupuestos;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.dao.ClienteDAO;
import com.intranet.dao.EmpleadoDAO;
import com.intranet.dao.PropuestaDAO;
import com.intranet.dao.ProyectoPresupuestoDAO;
import com.intranet.dao.ProyectoTrabajadoresDAO;
import com.intranet.util.UtilTemplateDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("proyectoTrabajadoresDAO")
public class IProyectoTrabajadoresDAO extends UtilTemplateDAO implements ProyectoTrabajadoresDAO{
    
    @Autowired(required = true)
    ProyectoPresupuestoDAO proyectoPresupuestoDAO;
    @Autowired(required = true)
    EmpleadoDAO empleadoDAO;
    @Autowired(required = true)
    ClienteDAO clienteDAO;
    @Autowired(required = true)
    PropuestaDAO propuestaDAO;
    
    @Override
    public List<proyecto_trabajadores> findAll(int idProyectoPresupuesto) {
        String sql = "SELECT id, id_proyecto_presupuesto, nif_empleado, descripcion, ccabecera, "+
	"contenido, estado, nota, condicion, finicio, ffin, numhoras "+
	"FROM proyecto_trabajadores where id_proyecto_presupuesto=? and condicion=1";
        
        List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_trabajadores> findAllPlanObra(int idProyectoPresupuesto) {
        String sql ="SELECT id, id_proyecto_presupuesto, nif_empleado, descripcion, ccabecera, "+
	"contenido, estado, nota, condicion, finicio, ffin,numhoras "+
	"FROM proyecto_trabajadores where id_proyecto_presupuesto=? "; 
                List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_trabajadores> findAllPropuesta(int idPropuesta) {
        String sql ="SELECT pt.id, pt.id_proyecto_presupuesto, pt.nif_empleado, pt.descripcion, pt.ccabecera, "+
        "pt.contenido, pt.estado, pt.nota, pt.condicion, pt.finicio, pt.ffin,pt.numhoras "+ 
        "FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) "+
        "inner join presupuesto p on(pp.id_presupuesto=p.id) inner join presupuestoc pc on(p.presup_id=pc.id) where pc.propuesta_id=? and pt.condicion=1";
        List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPropuesta},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    
    @Override
    public int tienePlanobra(int idPropuesta) {
        String sql ="SELECT count(*)as c "+ 
        "FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) "+
        "inner join presupuesto p on(pp.id_presupuesto=p.id) inner join presupuestoc pc on(p.presup_id=pc.id)  where pc.propuesta_id=? and pt.condicion=1";
        int est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idPropuesta},new RowMapper<Integer>(){
        @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                int e = rs.getInt("c");
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_trabajadores> findAllPropuestaE(empleados e) {
        String sql ="SELECT pt.id, pt.id_proyecto_presupuesto, pt.nif_empleado, pt.descripcion, pt.ccabecera, "+
        "pt.contenido, pt.estado, pt.nota, pt.condicion, pt.finicio, pt.ffin,pt.numhoras "+ 
        "FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) "+
        "inner join presupuesto p on(pp.id_presupuesto=p.id) where pt.nif_empleado=? and pt.condicion=1";
        List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{e.getNif()},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
               // propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
               // e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public List<proyecto_trabajadores> findAllPropuestaPlanObraDes(int idPropuesta, String desPlanObra) {
        String sql = "SELECT pt.id, pt.id_proyecto_presupuesto, pt.nif_empleado, pt.descripcion, pt.ccabecera, "+
	"pt.contenido, pt.estado, pt.nota, pt.condicion, pt.finicio, pt.ffin,pt.numhoras "+ 
	"FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) "+
	"inner join presupuesto p on(pp.id_presupuesto=p.id) where p.propuesta_id=? and pt.condicion=1 and p.descripcion like '%?%' ";
        List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{idPropuesta,desPlanObra},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public proyecto_trabajadores porId(int id) {
        String sql = "SELECT id, id_proyecto_presupuesto, nif_empleado, descripcion, ccabecera, "+
        "contenido, estado, nota, condicion, finicio, ffin, numhoras "+
        "FROM proyecto_trabajadores where id=? ";
        proyecto_trabajadores est =this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{id},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public boolean agregarnuevoSuperaCantidad(int idProyectoPresupuesto) {
        String sql = "SELECT pp.num_trabajadores,count(pt.id)as c"+
        "FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) where pt.id_proyecto_presupuesto=? "+
        "group by pp.num_trabajadores ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = false;
                if(rs.getInt("num_trabajadores")==rs.getInt("c"))t=true;
                return t;
        }
        });
    }

    @Override
    public String cantidademeplados(int idProyectoPresupuesto) {
        String sql = "SELECT pp.num_trabajadores,count(pt.id)as c"+
        "FROM proyecto_trabajadores pt inner join proyecto_presupuesto pp on(pt.id_proyecto_presupuesto=pp.id) where pt.id_proyecto_presupuesto=? "+
        "group by pp.num_trabajadores ";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{idProyectoPresupuesto},new RowMapper<String>(){
        @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                String t ="";
                if(rs.getInt("num_trabajadores")==rs.getInt("c")){
                    t="Empleados asignados "+rs.getInt("num_trabajadores")+" Completo";
                }else{
                    int rest=rs.getInt("num_trabajadores")-rs.getInt("c");
                    t="Faltan: "+rest+" empleados por Asignar";
                }
                return t;
        }
        });
    }

    @Override
    public boolean existe(proyecto_trabajadores presu) {
        String sql = "SELECT count(*)as c "+
	"FROM proyecto_trabajadores where id_proyecto_presupuesto=? and nif_empleado=?";
        return this.getJdbcTemplate().queryForObject(sql, 
                new Object[]{presu.getId_proyecto_presupuesto().getId(),presu.getNif_empleado().getNif()},new RowMapper<Boolean>(){
        @Override
            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
                Boolean t = false;
                if(rs.getInt("c")!=0) t=true;
                return t;
        }
        });
    }

    @Override
    public String Insert(proyecto_trabajadores presu) {
        String sql = "INSERT INTO proyecto_trabajadores( "+
        "id_proyecto_presupuesto, nif_empleado, descripcion, ccabecera, "+
        "contenido, finicio, ffin,numhoras, condicion) "+
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getId_proyecto_presupuesto().getId(), presu.getNif_empleado().getNif(),
            presu.getDescripcion(), presu.getCcabecera(), presu.getContenido(), presu.getFinicio(), presu.getFfin(), presu.getNumhoras()});
        String rpta="ERROR!... No se pudo INSERTAR el Registro";
        if(c>0){
            rpta="Se INSERTO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String Update(proyecto_trabajadores presu) {
        String sql = "UPDATE proyecto_trabajadores "+
        "SET nif_empleado=?, descripcion=?, " +
        "ccabecera=?, contenido=?, estado=?, nota=?, finicio=?, " +
        "ffin=?,numhoras=? WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getNif_empleado().getNif(),
            presu.getDescripcion(), presu.getCcabecera(), presu.getContenido(),presu.getEstado(),presu.getNota(), 
            presu.getFinicio(), presu.getFfin(), presu.getNumhoras(),presu.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String UpdateEstadoNota(proyecto_trabajadores presu) {
        String sql = "UPDATE proyecto_trabajadores "+
        "SET  estado=?, nota=? " +
        "WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{presu.getEstado(),presu.getNota(),presu.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String updateCondicion(proyecto_trabajadores t) {
        String sql = "UPDATE proyecto_trabajadores "+
        "SET condicion=?, fecharecordatorio=(current_date::DATE +3) " +
        " WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getCondicion(),t.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public String cerrarRecordatorio(proyecto_trabajadores t) {
        String sql = "UPDATE proyecto_trabajadores "+
        "SET condicion=4 " +
        " WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{t.getId()});
        String rpta="ERROR!... No se pudo ACTUALIZAR el Registro";
        if(c>0){
            rpta="Se ACTUALIZO Satisfactoriamente...!";
        }
        return rpta;
    }

    @Override
    public List<proyecto_trabajadores> getTareasE(String nif) {
        String sql ="SELECT id, id_proyecto_presupuesto, nif_empleado, descripcion, ccabecera, "+
        "contenido, estado, nota, condicion, finicio, ffin,numhoras "+
        "FROM proyecto_trabajadores where nif_empleado=? and condicion=1 ";
                List<proyecto_trabajadores> est =this.getJdbcTemplate().query(sql, 
                new Object[]{nif},new RowMapper<proyecto_trabajadores>(){
        @Override
            public proyecto_trabajadores mapRow(ResultSet rs, int i) throws SQLException {
                proyecto_trabajadores e = new proyecto_trabajadores();
                e.setId(rs.getInt("id"));
                int idC=rs.getInt("id_proyecto_presupuesto");
                String nifE=rs.getString("nif_empleado");
                try {
                    proyecto_presupuestos cu=proyectoPresupuestoDAO.porId(idC);
                    e.setId_proyecto_presupuesto(cu);
                    empleados emm=empleadoDAO.ByNif(nifE);
                    e.setNif_empleado(emm);
                   // clientes cli=clienteDAO.ByNif(nifE)
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.setDescripcion(rs.getString(4));
                e.setCcabecera(rs.getString(5));
                e.setContenido(rs.getString(6));
                e.setEstado(rs.getString(7));
                e.setNota(rs.getString(8));
                e.setCondicion(rs.getInt(9));
                e.setFinicio(rs.getString(10));
                e.setFfin(rs.getString(11));
                e.setNumhoras(rs.getInt(12));
                //propuesta p=propuestaDAO.porId(e.getId_proyecto_presupuesto().getId_presupuesto().getPropuesta_id());
                //e.setCli(clienteDAO.ByNif(p.getCliente_nif().getNif()));
                e.setEmpl(empleadoDAO.ByNif(e.getNif_empleado().getNif()));
                return e;
        }
        });
        
        return est;
    }

    @Override
    public String Delete(Integer id) {
        String sql = "DELETE FROM proyecto_trabajadores WHERE id=?";
        int c=this.getJdbcTemplate().update(sql, new Object[]{id});
        String rpta="ERROR!... No se pudo ELIMINAR el Registro";
        if(c>0){
            rpta="Se ELIMINADO Satisfactoriamente...!";
        }
        return rpta;
    }
    
}
