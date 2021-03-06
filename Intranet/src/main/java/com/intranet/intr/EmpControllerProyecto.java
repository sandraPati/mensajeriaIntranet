/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.capitulos;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.propuesta;
import com.intranet.beans.prov_presup_adj;
import com.intranet.beans.proveedor_presupuesto;
import com.intranet.beans.proyecto_certificaciones;
import com.intranet.beans.proyecto_presupuestos;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.beans.users;
import com.intranet.intr.mensajesEmail.mensajeCertificaciones;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.CapitulosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PresupuestoCService;
import com.intranet.service.propuesta.PresupuestoSuperficiesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.SubCapitulosService;
import com.intranet.service.propuesta.TipoEstanciasService;
import com.intranet.service.propuesta.TipoPanosService;
import com.intranet.service.proveedores.ProvPresupAdjService;
import com.intranet.service.proveedores.ProveedorPresupuestoAsignarService;
import com.intranet.service.proveedores.ProveedorPresupuestoService;
import com.intranet.service.proyecto.ProyectoCertificacionesService;
import com.intranet.service.proyecto.ProyectoPresupuestoService;
import com.intranet.service.proyecto.ProyectoTrabajadoresService;
import java.security.Principal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/emp/*")
public class EmpControllerProyecto {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private PresupuestoCService presupuestoCService;
    @Autowired
    private ProyectoPresupuestoService proyectoPresupuestoService;
    @Autowired
    private CapitulosService capitulosService;
    @Autowired
    private ProyectoTrabajadoresService proyectoTrabajadoresService;
    @Autowired
    private ProyectoCertificacionesService proyectoCertificacionesService;
    @Autowired
    private ProvPresupAdjService provPresupAdjService;
    @Autowired
    private ProveedorPresupuestoService proveedorPresupuestoService;
    //propuesta prop=null;
   // int idPPp=0;
    private clientes nifCli=new clientes();
    private propuesta prop=new propuesta();
    private capitulos cap=new capitulos();
    private presupuesto presup=new presupuesto();
    private proyecto_presupuestos propres=new proyecto_presupuestos();
    
    
    
    @RequestMapping("ELtaClientesProyecto.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav){
       
        List<clientes> clientesListbox=null;
        try{
            
            clientesListbox=clientesService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("clientesListbox", clientesListbox);
        mav.setViewName("ELtaClientesProyecto");        
        return mav;
    }
    @RequestMapping("EverPropuestasP.htm")
    public String verPropuestas(@RequestParam(value = "nifC") String nif,@RequestParam(value = "msg", required = false) String msg,ModelMap map,Principal principal) {
        List<propuesta> ltaPropuestas=null;
        String name=principal.getName();
        users u=null;
        try{
            if(msg!=null & msg!=""){
                if (msg.equals("error")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro registros de Certificaciones");
                }else if (msg.equals("errorPlanObra")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro registros de Plan de Obra");
                }
            }
            u=usuarioService.getByLogin(name);
            nifCli=clientesService.ByNif(nif);
            //empleado=empleadoService.ByNif(nif); 
            ltaPropuestas=propuestasService.filtroCEProy(u.getNif(),nif);
            //cliente=clientesService.ByNif(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaPropuestas",ltaPropuestas);
        map.addAttribute("cliente",nifCli);
        return("EverPropuestasP");
        
    }
    @RequestMapping("EProyecto.htm")
    public String Proyecto(@RequestParam(value = "idP") int idP,ModelMap map) {
        List<presupuestoc> ltaCapitulos=null;
        try{
            prop=propuestasService.porId(idP);
            ltaCapitulos=presupuestoCService.presupuestoCapitulos(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("capitulosLista",ltaCapitulos);
        map.addAttribute("prop",prop);
        return("EProyecto");
        
    }
    
    @RequestMapping("EProyectoPresupuesto.htm")
    public String ProyectoSubCap(@RequestParam(value = "idPres") int idPres,@RequestParam(value = "idP") int idP,ModelMap map) {
       List<presupuesto> presupues=new ArrayList<presupuesto>();
        presupuestoc p=null;
        try{
            p=presupuestoCService.porid(idPres);
            presupues=presupuestosService.presupuestoSUBCapitulos(idPres);
            prop=propuestasService.porId(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("presupuestoLista",presupues);
        map.addAttribute("p",p);
        map.addAttribute("prop",prop);
        map.addAttribute("idPres",idPres);
        map.addAttribute("idP",idP);
        return("EProyectoPresupuesto");
        
    }
   
    @RequestMapping("EPlanObra.htm")
    public String PlanObra(@RequestParam(value = "idPres") int idPres,ModelMap map) {
        List<proyecto_presupuestos> proypresupuestoLista=null;
        presupuestoc pp=null;
        try{
           presup=presupuestosService.porID(idPres);
            pp=presupuestoCService.porid(presup.getPresup_id());
            prop=propuestasService.porId(pp.getPropuesta_id());
            proypresupuestoLista=proyectoPresupuestoService.findAllPPres(idPres);
            //empleado=empleadoService.ByNif(nif); 
            //prop=propuestasService.porId(idP);
            //ltaEstancias=estanciasService.listaPropuesta(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proypresupuestoLista",proypresupuestoLista);
        map.addAttribute("prop",prop);
        map.addAttribute("cap",cap);
        map.addAttribute("idPres",pp.getId());
        map.addAttribute("idPresupuesto",idPres);
        return("EPlanObra");
        
    }
   
    @RequestMapping("EPlanObraEmpleados.htm")
    public String PlanObraEmpleados(@RequestParam(value = "idPP") int idPP,ModelMap map) {
        List<proyecto_trabajadores> proyempledosLista=null;
        
        try{
            propres=proyectoPresupuestoService.porId(idPP);
            proyempledosLista=proyectoTrabajadoresService.findAllPlanObra(idPP);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyempledosLista",proyempledosLista);
        map.addAttribute("prop",prop);
        map.addAttribute("cap",cap);
        map.addAttribute("idPP",propres.getId());
        map.addAttribute("idPres",presup.getId());
        return("EPlanObraEmpleados");
        
    }
    
    @RequestMapping(value = "EaddPlanObra.htm",method=RequestMethod.GET)
    public String addPlanObra_get(ModelMap map,@RequestParam(value = "idPres") int idPres) {
        proyecto_presupuestos proyPresu=new proyecto_presupuestos();
        
        try{
            presup=presupuestosService.porID(idPres);
            proyPresu.setId_presupuesto(presup);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyPresu",proyPresu);
        map.addAttribute("p",prop);
        return "EaddPlanObra";
    }
    
    
    @RequestMapping(value = "EaddPlanObra.htm",method=RequestMethod.POST)
    public String addPresupuesto_post(ModelMap map,@ModelAttribute("proyPresu")proyecto_presupuestos proyPresu,BindingResult result) {
        
        try{
            
            proyectoPresupuestoService.Insert(proyPresu);
        }catch(Exception ex){            
        }
        
        //map.addAttribute("presup",presup);  
        return "redirect:EPlanObra.htm?idPres="+proyPresu.getId_presupuesto().getId();
    }
    
    @RequestMapping(value = "EupdatePlanObra.htm",method=RequestMethod.GET)
    public String updatePlanObra_get(ModelMap map,@RequestParam(value = "idPP") int idPP) {
        try{
            propres=proyectoPresupuestoService.porId(idPP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyPresu",propres);
        map.addAttribute("p",prop);
        return "EupdatePlanObra";
    }
    
  
    @RequestMapping(value = "EupdatePlanObra.htm",method=RequestMethod.POST)
    public String updatePresupuesto_post(ModelMap map,@ModelAttribute("proyPresu")proyecto_presupuestos proyPresu,BindingResult result) {
        try{
            proyectoPresupuestoService.Update(proyPresu);
        }catch(Exception ex){            
        }
        
        return "redirect:EPlanObra.htm?idPres="+proyPresu.getId_presupuesto().getId();
    }
    
    @RequestMapping(value = "EdeletePlanObra.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "idPP") int idPP,ModelMap map) {
        String rpta="";
        
        try{
            propres=proyectoPresupuestoService.porId(idPP);
            rpta=proyectoPresupuestoService.Delete(idPP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EPlanObra.htm?idPres="+propres.getId_presupuesto().getId();  
    }
    
    @RequestMapping(value = "EaddPlanObraEmpleados.htm",method=RequestMethod.GET)
    public String addPlanObraEmpleados_get(ModelMap map,@RequestParam(value = "idPP") int idPP) {
        proyecto_trabajadores proyTrabajadores=new proyecto_trabajadores();
        List<empleados> ltaEmpleados=new ArrayList<empleados>();
        try{
            propres=proyectoPresupuestoService.porId(idPP);
            proyTrabajadores.setId_proyecto_presupuesto(propres);
            ltaEmpleados=empleadoService.findAll("");
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyTrabajadores",proyTrabajadores);
        map.addAttribute("ltaEmpleados",ltaEmpleados);
        map.addAttribute("idPP",propres.getId());
        return "EaddPlanObraEmpleados";
    }
    
  
    @RequestMapping(value = "EaddPlanObraEmpleados.htm",method=RequestMethod.POST)
    public String addPlanObraEmpleados_post(ModelMap map,@ModelAttribute("proyTrabajadores")proyecto_trabajadores proyTrabajadores,BindingResult result) {
        
        try{
            
            proyectoTrabajadoresService.Insert(proyTrabajadores);
        }catch(Exception ex){            
        }
        
        //map.addAttribute("presup",presup);  
        return "redirect:EPlanObraEmpleados.htm?idPP="+proyTrabajadores.getId_proyecto_presupuesto().getId();
    }
    
    @RequestMapping(value = "EupdatePlanObraEmpleado.htm",method=RequestMethod.GET)
    public String updatePlanObraEmpleados_get(ModelMap map,@RequestParam(value = "idPT") int idPT) {
        proyecto_trabajadores proyTrabajadores=new proyecto_trabajadores();
        List<empleados> ltaEmpleados=new ArrayList<empleados>();
        try{
            
            proyTrabajadores=proyectoTrabajadoresService.porId(idPT);
            ltaEmpleados=empleadoService.findAll("");
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyTrabajadores",proyTrabajadores);
        map.addAttribute("ltaEmpleados",ltaEmpleados);
        map.addAttribute("idPT",idPT);
        map.addAttribute("idPP",proyTrabajadores.getId_proyecto_presupuesto().getId());
        return "EupdatePlanObraEmpleado";
    }
    
  
    @RequestMapping(value = "EupdatePlanObraEmpleado.htm",method=RequestMethod.POST)
    public String updatePlanObraEmpleados_post(ModelMap map,@ModelAttribute("proyTrabajadores")proyecto_trabajadores proyTrabajadores,BindingResult result) {
        
        try{
             proyectoTrabajadoresService.Update(proyTrabajadores);
        }catch(Exception ex){            
        }
        
        return "redirect:EPlanObraEmpleados.htm?idPP="+proyTrabajadores.getId_proyecto_presupuesto().getId();
    }
    
    @RequestMapping(value = "EdeletePlanObraEmpleado.htm",method=RequestMethod.GET)
    public String deletePlanObraEmpleado(@RequestParam(value = "idPT") int idPT,ModelMap map) {
        String rpta="";
        proyecto_trabajadores proyt=new proyecto_trabajadores();
        try{
            proyt=proyectoTrabajadoresService.porId(idPT);
            rpta=proyectoTrabajadoresService.Delete(idPT);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EPlanObraEmpleados.htm?idPP="+propres.getId();  
    }
    
    
    @RequestMapping("ECertificaciones.htm")
    public String Certificaciones(@RequestParam(value = "idP") int idP,@RequestParam(value = "msg", required = false) String msg,ModelMap map) {
        List<presupuestoc> ltaCapitulos=null;
        try{
            prop=propuestasService.porId(idP);
            ltaCapitulos=presupuestoCService.presupuestoCapitulos(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("capitulosLista",ltaCapitulos);
        map.addAttribute("prop",prop);
        map.addAttribute("certificacion",new proyecto_certificaciones());
        return("ECertificaciones");
        
    }
    
    @RequestMapping("EProyectoPresupuestoC.htm")
    public String ProyectoPresupuestoC(@RequestParam(value = "idPres") int idPres,@RequestParam(value = "idP") int idP,ModelMap map) {
       List<presupuesto> presupues=new ArrayList<presupuesto>();
        presupuestoc p=null;
        try{
            p=presupuestoCService.porid(idPres);
            presupues=presupuestosService.presupuestoSUBCapitulos(idPres);
            prop=propuestasService.porId(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("presupuestoLista",presupues);
        map.addAttribute("p",p);
        map.addAttribute("prop",prop);
        map.addAttribute("idPres",idPres);
        map.addAttribute("idP",idP);
       
        return("EProyectoPresupuestoC");
        
    }
  
    @RequestMapping("EPlanObraC.htm")
    public String PlanObraC(@RequestParam(value = "idPres") int idPres,ModelMap map) {
        List<proyecto_presupuestos> proypresupuestoLista=null;
        presupuestoc pp=null;
        try{
           presup=presupuestosService.porID(idPres);
            pp=presupuestoCService.porid(presup.getPresup_id());
            prop=propuestasService.porId(pp.getPropuesta_id());
            proypresupuestoLista=proyectoPresupuestoService.findAllPPres(idPres);
            //empleado=empleadoService.ByNif(nif); 
            //prop=propuestasService.porId(idP);
            //ltaEstancias=estanciasService.listaPropuesta(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proypresupuestoLista",proypresupuestoLista);
        map.addAttribute("prop",prop);
        map.addAttribute("cap",cap);
        map.addAttribute("idPres",pp.getId());
        map.addAttribute("idPresupuesto",idPres);
        return("EPlanObraC");
        
    }
    private String valorllenado="";
   @RequestMapping("EverCertificaciones.htm")
    public String verCertificaciones(@RequestParam(value = "idPP") int idPP,ModelMap map) {
        List<proyecto_certificaciones> listapryCert=null;
        valorllenado="";
        try{
            propres=proyectoPresupuestoService.porId(idPP);
            listapryCert=proyectoCertificacionesService.findAll(idPP);
          for(proyecto_certificaciones c:listapryCert){
                   valorllenado=valorllenado+" | "+c.getMonto_semana();
           }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("listapryCert",listapryCert);
        map.addAttribute("prop",prop);
        map.addAttribute("idPres",presup.getId());
        map.addAttribute("idPP",propres.getId());
        map.addAttribute("valorllenado",valorllenado);
        return("EverCertificaciones");
        
    }
    
    @RequestMapping(value = "EaddCertificacion.htm",method=RequestMethod.GET)
    public String addCertificacion_get(ModelMap map,@RequestParam(value = "idPP") int idPP) {
        proyecto_certificaciones proyCert=new proyecto_certificaciones();
        //List<empleados> ltaEmpleados=new ArrayList<empleados>();
        try{
            propres=proyectoPresupuestoService.porId(idPP);
            //proyecto_presupuestos proypres=proyectoPresupuestoService.porId(propres.getId());           
            proyCert.setId_proyecto_presupuesto(propres);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proyCert",proyCert);
        //map.addAttribute("ltaEmpleados",ltaEmpleados);
        map.addAttribute("idPP",propres.getId());
        return "EaddCertificacion";
    }
    
  
    @RequestMapping(value = "EaddCertificacion.htm",method=RequestMethod.POST)
    public String addCertificacion_post(ModelMap map,@ModelAttribute("proyCert")proyecto_certificaciones proyCert,BindingResult result) {
        //proyecto_presupuestos proypre=new proyecto_presupuestos();
        //presupuesto p=new presupuesto();
        try{
            System.out.println("ol1"+proyCert.getId_proyecto_presupuesto().getId()+"-"+proyCert.getMonto_semana()+"-"+proyCert.getPorcentaje_terminado()+"-"+proyCert.getFecha()+"-"+proyCert.getNumsemana());
            int id=proyectoCertificacionesService.maximo(propres.getId());
            System.out.println("ol2"+proyCert.getId_proyecto_presupuesto().getId()+"-"+proyCert.getMonto_semana()+"-"+proyCert.getPorcentaje_terminado()+"-"+proyCert.getFecha()+"-"+proyCert.getNumsemana());
            
            int p=proyCert.getPorcentaje_terminado();
            System.out.println("ol3"+proyCert.getId_proyecto_presupuesto().getId()+"-"+proyCert.getMonto_semana()+"-"+proyCert.getPorcentaje_terminado()+"-"+proyCert.getFecha()+"-"+proyCert.getNumsemana());
            
            if(id!=0){
                System.out.println("ol4"+proyCert.getId_proyecto_presupuesto().getId()+"-"+proyCert.getMonto_semana()+"-"+proyCert.getPorcentaje_terminado()+"-"+proyCert.getFecha()+"-"+proyCert.getNumsemana());
            
            proyecto_certificaciones pc=proyectoCertificacionesService.porId(id);
            p=proyCert.getPorcentaje_terminado()-pc.getPorcentaje_terminado();
            //pryCert.setPorcentaje_terminado(p);
            }
            proyCert.setMonto_semana((p*propres.getId_presupuesto().getMonto())/100);
            /*proyCert.setMonto_semana((proyCert.getPorcentaje_terminado()*proyCert.getId_proyecto_presupuesto().getId_presupuesto().getMonto())/100);
            proyecto_certificaciones pc=new proyecto_certificaciones();
            String id=proyectoCertificacionesService.maximo(propres.getId());
            System.out.println("1");
            if(id!="" && id!=null ){
                System.out.println("id"+id);
                pc=proyectoCertificacionesService.porId(Integer.parseInt(id));
            System.out.println("id"+pc.getPorcentaje_terminado());
            System.out.println("2");
            int p=proyCert.getPorcentaje_terminado()-pc.getPorcentaje_terminado();
            System.out.println("3");
            proyCert.setMonto_semana((p*proyCert.getId_proyecto_presupuesto().getId_presupuesto().getMonto())/100);
            System.out.println("4");
            proyectoCertificacionesService.Insert(proyCert);
            System.out.println("5");
            
            }*/
            proyectoCertificacionesService.Insert(proyCert);
            System.out.println("ol5"+proyCert.getId_proyecto_presupuesto().getId()+"-"+proyCert.getMonto_semana()+"-"+proyCert.getPorcentaje_terminado()+"-"+proyCert.getFecha()+"-"+proyCert.getNumsemana());
            
            //proyectoTrabajadoresService.Insert(proyCert);
        }catch(Exception ex){            
        }
        
        //map.addAttribute("presup",presup);  
        return "redirect:EverCertificaciones.htm?idPP="+propres.getId();
    }
    
    
     @RequestMapping(value = "EdeleteCertificacion.htm",method=RequestMethod.GET)
    public String deleteCertificacion(@RequestParam(value = "idCert") int idCert,ModelMap map) {
        String rpta="";
        proyecto_certificaciones proC=new proyecto_certificaciones();
         List<proyecto_certificaciones> listapryCert=null;
        try{
            proC=proyectoCertificacionesService.porId(idCert);
            proyectoCertificacionesService.Delete(idCert);
            listapryCert=proyectoCertificacionesService.findAll(proC.getId_proyecto_presupuesto().getId());
            
            valorllenado="";
            for(proyecto_certificaciones c:listapryCert){
                    valorllenado=valorllenado+" | "+c.getMonto_semana();
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverCertificaciones.htm?idPP="+proC.getId_proyecto_presupuesto().getId();  
    }
    
    
    @RequestMapping(value = "EverContratoPdf.htm",method=RequestMethod.GET)
    public String verContratoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       
        try{
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idPropuesta", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\propuestaContratoCliente.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\propuestas\\contrato\\ContratoPropuesta"+prop.getCliente_nif().getNif()+".pdf");

        
                 }catch(Exception e){

               }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        //map.addAttribute("idP",idPr);
        return("EverContratoPdf");
    }
    
    @RequestMapping("EpdfContratoProyecto.htm")
    public ModelAndView pdf(ModelAndView mav){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EpdfContratoProyecto");        
        return mav;
    }
    
    @RequestMapping(value = "EverPlanObraPdf.htm",method=RequestMethod.GET)
    public String verPlanObraPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       String ruta="";
        try{
            List<proyecto_trabajadores> ltaPT=proyectoTrabajadoresService.findAllPropuesta(idPr);
            if(ltaPT.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
                
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idPropuesta", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\planObra\\planObra.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proyecto\\planobra\\PlanObra"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    ruta="EverPlanObraPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","errorPlanObra");
                ruta="redirect:EverPropuestasP.htm?nifC="+prop.getCliente_nif().getNif();
            }       
        }catch(Exception e){
        }
        
        return(ruta);
    }
    
    @RequestMapping("EpdfPlanObraPdf.htm")
    public ModelAndView pdfPlanObra(ModelAndView mav){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EpdfPlanObraPdf");        
        return mav;
    }
    
    @RequestMapping(value = "EverCertificacionesPdf.htm",method=RequestMethod.GET)
    public String verCertificacionesPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       String ruta="";
        try{
            int res=proyectoCertificacionesService.existeCertificaciones(idPr);
            if(res!=0){
            prop=propuestasService.porId(idPr);
            
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("propuesta_id", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\certificaciones\\certificaciones.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proyecto\\certificaciones\\Certificaciones"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    ruta="EverCertificacionesPdf";
            
            }else{
                System.out.println("NO hay certificaciones");
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:EverPropuestasP.htm?nifC="+prop.getCliente_nif().getNif();
            }
                 }catch(Exception e){

               }
        
        //map.addAttribute("idP",idPr);
        return(ruta);
    }
    
    @RequestMapping("EpdfCertificacionesPdf.htm")
    public ModelAndView pdfCertificacionesPdf(ModelAndView mav){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EpdfCertificacionesPdf");        
        return mav;
    }
    
    @RequestMapping(value = "EverCertificacionesSemanaPdf.htm",method=RequestMethod.POST)
    public String verCertificacionesSemanaPdf_post(ModelMap map,@ModelAttribute("certificacion")proyecto_certificaciones certificacion,BindingResult result) {
        String ruta="";
        try{
            if(proyectoCertificacionesService.existeCertificacionesSemana(prop.getId(),certificacion.getNumsemana())!=0){
              
                prop=propuestasService.porId(prop.getId());
                
                    System.out.println("3");
                    Connection con=null;
                    conexion conexion=null;
                    conexion=new conexion();
                    con=conexion.getConnection();
                    System.out.println("2");
                    System.out.println("prop:"+prop.getId()+" numsemana:"+certificacion.getNumsemana());
                        Map<String, Object> params = new HashMap<String, Object>();
                        params.put("propuesta_id", prop.getId());
			params.put("numsemana", certificacion.getNumsemana());
                       //C:\reportesIntranetDecorakia\presupuesto
                       JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\certificacionesSemana\\certificacionesSemana.jasper", params, con);
                       JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proyecto\\certificaciones\\semana\\CertificacionesSemana"+prop.getCliente_nif().getNif()+".pdf");
                       ruta="redirect:EverCertificacionesSemanaPdf.htm";
                
              
            }else{
                System.out.println("NO existe");
                //pr=propuestasService.porId(prop.getId());
                map.addAttribute("msg","errorSemana");
                ruta="redirect:ECertificaciones.htm?idP="+prop.getId();
                
            }  
        }catch(Exception ex){            
        }
        
        return (ruta);
    }
    @RequestMapping(value = "EverCertificacionesSemanaPdf.htm",method=RequestMethod.GET)
    public String verCertificacionesSemanaPdf_get(ModelMap map) {
       System.out.println("certificacion ver");
      
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        //map.addAttribute("idP",idPr);
        return("EverCertificacionesSemanaPdf");
    }
    
    @RequestMapping("EpdfCertificacionesSemanaPdf.htm")
    public ModelAndView pdfCertificacionesSemanaPdf(ModelAndView mav){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EpdfCertificacionesSemanaPdf");        
        return mav;
    }
    
    @RequestMapping(value = "EenviarCertificacionSemana.htm",method=RequestMethod.POST)
    public String enviarCertificacionSemana(@ModelAttribute("certificacion")proyecto_certificaciones certificacion,BindingResult result,ModelMap map) {
        String rpta="";
        try{
            if(proyectoCertificacionesService.existeCertificacionesSemana(prop.getId(),certificacion.getNumsemana())!=0){
            //prop=propuestasService.porId(prop.getId());
            if(certificacion.getNumsemana()!=0){
                //propuesta p=propuestasService.porId(idPr);
            
                clientes c=clientesService.ByNif(prop.getCliente_nif().getNif());
                clientes pc=prop.getCliente_nif();
                pc.setEmail(c.getEmail());
                prop.setCliente_nif(pc);
                
                mensajeCertificaciones m=new mensajeCertificaciones();
		m.mensaje(prop,certificacion.getNumsemana());
                smsenvio(c.getNif(),"Se le ha enviado la Certificación Periodica a su correo electronico: "+c.getEmail());
                map.addAttribute("msg","successSemana");
            }
            }else{
                map.addAttribute("msg","errorSemana");
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ECertificaciones.htm?idP="+prop.getId();  
    }
    
    @RequestMapping("EProyectoverLtaPresupuestos.htm")
    public ModelAndView verLtaPresupuestos(ModelAndView mav,@RequestParam(value = "id") int id,@RequestParam(value = "nifC") String nifC){
       
        List<proveedor_presupuesto> lta=null;
        try{
            
            lta=proveedorPresupuestoService.findAllPorProyecto(id);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("idProy", id);
        mav.addObject("nifC", nifC);
        mav.setViewName("EProyectoverLtaPresupuestos");        
        return mav;
    }
    
    @RequestMapping("EProyectoverPPresupuesto.htm")
    public String verPPresupuestos(ModelMap mav,@RequestParam(value = "nifC") String nifC,@RequestParam(value = "idProy") int idProy,@RequestParam(value = "idP") int id,@RequestParam(value = "msg",required=false) String msg){
        proveedor_presupuesto lta=null;
        List<prov_presup_adj> ltaArc=null;
        List<String> archivos=null;
        List<String> imagenes=null;
        try{
           if(msg!=null &&msg!=""){
              if(msg.equals("success")) {
               mav.addAttribute("msg", "Presupuesto Aceptado y Asignado Correctamente");
              }else{
                  mav.addAttribute("error", "Operacion Rechazada, Intente Nuevamente");
              }
           }
            lta=proveedorPresupuestoService.porID(id);
            ltaArc=provPresupAdjService.findAll(id);
            /*for(prov_presup_adj pp:ltaArc){
                if(pp.getTipo().startsWith("i")){
                    imagenes.add(pp.getNombre());
                }else archivos.add(pp.getNombre());
            }*/
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("presup", lta);
        mav.addAttribute("idP", id);
        mav.addAttribute("nifC", nifC);
        mav.addAttribute("idProy", idProy);
        mav.addAttribute("ltaArc", ltaArc);
               
        return "EProyectoverPPresupuesto";
    }
    
    private void smsenvio(String nif,String mensaje) {
       try{
           clientes cli =clientesService.ByNif(nif);
            //map.addAttribute("msg","success");
            HttpClient client = new HttpClient();
        client.setStrictMode(true);
        //Se fija el tiempo m´aximo de espera de la respuesta del servidor
        client.setTimeout(60000);
        //Se fija el tiempo m´aximo de espera para conectar con el servidor
        client.setConnectionTimeout(5000);
        PostMethod post = null;
        //Se fija la URL sobre la que enviar la petici´on POST
            //Como ejemplo la petici´on se env´ıa a www.altiria.net/sustituirPOSTsms
            //Se debe reemplazar la cadena ’/sustituirPOSTsms’ por la parte correspondiente
            //de la URL suministrada por Altiria al dar de alta el servicio
            post = new PostMethod("http://www.altiria.net/api/http");
            //Se fija la codificaci´on de caracteres en la cabecera de la petici´on
            post.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded; charset=UTF-8");
            //Se crea la lista de par´ametros a enviar en la petici´on POST
            NameValuePair[] parametersList = new NameValuePair[6];
            //XX, YY y ZZ se corresponden con los valores de identificaci´on del
            //usuario en el sistema.
            parametersList[0] = new NameValuePair("cmd", "sendsms");
            parametersList[1] = new NameValuePair("domainId", "comercial");
            parametersList[2] = new NameValuePair("login", "jfruano");
            parametersList[3] = new NameValuePair("passwd", "wrnkmekt");
            parametersList[4] = new NameValuePair("dest", "34"+cli.getTelefono());
            parametersList[5] = new NameValuePair("msg", ""+mensaje);
            //Se rellena el cuerpo de la petici´on POST con los par´ametros
            post.setRequestBody(parametersList);
            int httpstatus = 0;
            String response = null;
            try {
            //Se env´ıa la petici´on
            httpstatus = client.executeMethod(post);
            //Se consigue la respuesta
            response = post.getResponseBodyAsString();
            }
            catch (Exception e) {
            //Habr´a que prever la captura de excepciones
            
            }
            finally {
            //En cualquier caso se cierra la conexi´on
            post.releaseConnection();
            }
            //Habr´a que prever posibles errores en la respuesta del servidor
            if (httpstatus!=200){
            
            }
            else {
            //Se procesa la respuesta capturada en la cadena ‘‘response’’
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
    }
}
