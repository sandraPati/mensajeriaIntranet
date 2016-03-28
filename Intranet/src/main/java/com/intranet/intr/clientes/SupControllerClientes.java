/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.clientes;

import com.intranet.beans.clientes;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.propuesta;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.beans.users;
import com.intranet.intr.conexion;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.VentanaService;
import com.intranet.service.proyecto.ProyectoCertificacionesService;
import com.intranet.service.proyecto.ProyectoTrabajadoresService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
@RequestMapping("/sup/*")
public class SupControllerClientes {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private EstanciasService estanciasService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private ProyectoCertificacionesService proyectoCertificacionesService;
    @Autowired
    private ProyectoTrabajadoresService proyectoTrabajadoresService;
    
    @RequestMapping("Clientes.htm")
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
        mav.setViewName("Clientes");        
        return mav;
    }
    
    @RequestMapping(value = "addDatosCliente.htm",method=RequestMethod.GET)
    public String addCliente_get(ModelMap map) {
        clientes cliente=new clientes();
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente",cliente);
        map.addAttribute("mensaje","mensaje");
        
        return "addDatosCliente";
    }
    
    @RequestMapping(value = "addDatosCliente.htm",method=RequestMethod.POST)
    public String addCliente_post(@ModelAttribute("cliente")clientes cliente,BindingResult result) {
        String mensaje="";
        
        try{
            if(clientesService.validaNIf(cliente.getNif())==false){
                clientesService.Insert(cliente);
            }
        }catch(Exception e){
        
        }
         return "redirect:Clientes.htm";
        
    }
    
    
    @RequestMapping(value = "updateDatosCliente.htm",method=RequestMethod.GET)
    public String updateDatosCliente_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        clientes cliente=new clientes();
        try{
            cliente=clientesService.ByNif(nif);
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente",cliente);
        map.addAttribute("mensaje","mensaje");
        
        return "updateDatosCliente";
    }
    
    @RequestMapping(value = "updateDatosCliente.htm",method=RequestMethod.POST)
    public String updateDatosCliente_post(@ModelAttribute("cliente")clientes cliente,BindingResult result) {
        String mensaje="";
        
        try{
            System.out.println("nif:"+cliente.getNif());
            clientesService.Update(cliente);
            users u=new users();
            u.setNif(cliente.getNif());
            u.setEmail(cliente.getEmail());
            usuarioService.updateEmail(u);
        }catch(Exception e){
        
        }
         return "redirect:Clientes.htm";
        
    }
    
    @RequestMapping(value = "deleteDatosCliente.htm",method=RequestMethod.GET)
    public String deleteDatosCliente(@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
            clientesService.Delete(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Clientes.htm";
    }
    
    @RequestMapping(value = "securityDatosCliente.htm",method=RequestMethod.GET)
    public String securityDatosCliente_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        users u=new users();
        clientes c=null;
        try{
            c=clientesService.ByNif(nif);
            u.setNif(c.getNif());
            u.setEmail(c.getEmail());
            if(usuarioService.validaExiste(u)==true){
                u=usuarioService.getById(nif);
                u.setContrasenna("");
            }
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("usu",u);
        map.addAttribute("mensaje","mensaje");
        
        return "securityDatosCliente";
    }
    
    @RequestMapping(value = "securityDatosCliente.htm",method=RequestMethod.POST)
    public String securityDatosCliente_post(@ModelAttribute("usu")users u,BindingResult result) {
        String mensaje="";
        
        try{
            System.out.println("nif cliente:"+u.getNif());
            if(u.getNif()!=null && u.getContrasenna()!="" && u.getContrasenna2()!=""){
                System.out.println("Solo nif usurario y contra");
                    if(u.getContrasenna().equals(u.getContrasenna2())){
                        System.out.println("contrasenas iguales");
                        if(usuarioService.validaExiste(u)==true){
                            System.out.println("ya existe usuario con nif");
                            if(usuarioService.validaExisteUCNif(u)==0){
                                System.out.println("No existe usuario ");
                                usuarioService.update(u);
                            }else System.out.println("Ya existe un usuario con el mismo usuario y contraseña");
                        }else{
                            System.out.println("NOexiste usuario con nif");
                            if(usuarioService.validaExisteUC(u)==0){
                                System.out.println("NOexiste usario (Y)");
                                
                                 System.out.println("antes");
                                usuarioService.insertar(u);
                                System.out.println("inserta users");
                                usuarioService.anadirRolaUser(u.getNif(), 5);
                                System.out.println("inserta roluser");
                            }else System.out.println("Usted no esta regitrado,Ya existe un usuario con el mismo usuario y contraseña");
                            
                        }
                    }else{
			System.out.println("Las contraseñas no Coinciden");
                    }
                }else if(u.getNif()!=null){
                    System.out.println("Solo nif");
                    if(usuarioService.validaExiste(u)==true){
                        if(usuarioService.validaExisteUCNif(u)==0){
                            mensaje=usuarioService.update(u);
                        }
                     
                    }else{
                        if(usuarioService.validaExisteUC(u)==0){
                        clientes c=clientesService.ByNif(u.getNif());
                        u.setEmail(c.getEmail());
                        usuarioService.insertar(u);
                        usuarioService.anadirRolaUser(u.getNif(), 5);
                        }
                    }
                        
                }
                
        }catch(Exception e){
        
        }
         return "redirect:Clientes.htm";
        
    }
    
    @RequestMapping("fichaCliente.htm")
    public String verPropuestas(@RequestParam(value = "nifC") String nif,@RequestParam(value = "msg", required = false) String msg,ModelMap map) {
        List<propuesta> ltaPropuestas=null;
        List<propuesta> ltaProyectos=null;
        clientes c=null;
        try{
            if(msg!=null & msg!=""){
                if (msg.equals("error")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro el Presupuesto del Proyecto");
                }else if (msg.equals("errorC")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro la Certificacion del Proyecto");
                }else if (msg.equals("errorPlanObra")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro el Plan de Obra del Proyecto");
                }
            }
            //empleado=empleadoService.ByNif(nif); 
            ltaPropuestas=propuestasService.filtroC(nif);
            ltaProyectos=propuestasService.filtroCProy(nif);
            c=clientesService.ByNif(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaPropuestas",ltaPropuestas);
        map.addAttribute("ltaProyectos",ltaProyectos);
        map.addAttribute("cliente",c);
        return("fichaCliente");
        
    }
    
    @RequestMapping("fichaverPropuesta.htm")
    public String fichaverPropuesta(@RequestParam(value = "idP") int id,ModelMap map) {
        List<estancias> ltaEstancias=null;
        List<estancias> ltaEstancias2=new ArrayList<estancias>();
        
        propuesta pro=new propuesta();
        try{
            float totalSpanos=0;
            float superficie=0;
	float TotalSventanas=0;
	float TotalSpuertas=0;
	float TotalSarmarios=0;
	float TotalSsuelos=0;
	float TotalStechos=0;
                int numventanaP=0;
                int numpuertaP=0;
                int numarmarioP=0;
            pro=propuestasService.porId(id);
            ltaEstancias=estanciasService.listaPropuesta(id);
            for(estancias e: ltaEstancias){
                List<panos> ltaPanos=null;
                int numventana=0;
                int numpuerta=0;
                int numarmario=0;
                ltaPanos=panosService.findAll(e.getId());
                for(panos pa:ltaPanos){
                    numventana=numventana+pa.getNumventanas();
                    numpuerta=numpuerta+pa.getNumpuertas();
                    numarmario=numarmario+pa.getNumarmarios();
                    pa.setVentanaspano(ventanaService.findAll(pa.getId()));
                    pa.setPuertaspano(puertasService.findAll(pa.getId()));
                    pa.setArmariospano(armariosService.findAll(pa.getId()));
                }
                e.setNumventanas(numventana);
                e.setNumpuertas(numpuerta);
                e.setNumarmarios(numarmario);
                e.setLtaPanos(ltaPanos);
                ltaEstancias2.add(e);
                totalSpanos=totalSpanos+e.getTotalSpanos();
                superficie=superficie+e.getSuperficie();
                TotalSventanas=TotalSventanas+e.getTotalSventanas();
                TotalSpuertas=TotalSpuertas+e.getTotalSpuertas();
                TotalSarmarios=TotalSarmarios+e.getTotalSarmarios();
                TotalSsuelos=TotalSsuelos+e.getTotalSsuelos();
                TotalStechos=TotalStechos+e.getTotalStechos();
                    numventanaP=numventanaP+e.getNumventanas();
                    numpuertaP=numpuertaP+e.getNumpuertas();
                    numarmarioP=numarmarioP+e.getNumarmarios();
            }
            pro.setTotalSpanos(totalSpanos);
            pro.setSuperficie(superficie);
            pro.setTotalSventanas(TotalSventanas);
            pro.setTotalSpuertas(TotalSpuertas);
            pro.setTotalSarmarios(TotalSarmarios);
            pro.setTotalSsuelos(TotalSsuelos);
            pro.setTotalStechos(TotalStechos);
            pro.setNumventanas(numventanaP);
            pro.setNumpuertas(numpuertaP);
            pro.setNumarmarios(numarmarioP);
            
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaEstancias",ltaEstancias2);
        map.addAttribute("prop",pro);
        return("fichaverPropuesta");
        
    }
    
     @RequestMapping(value = "FichaverPresupuestoPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=null;
       String ruta="";
        try{
            List<presupuesto> ltaP=presupuestosService.presupuestoPropuesta(idPr);
            if(ltaP.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idpropuesta", idPr);
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\presupuesto\\presupuesto.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\propuestas\\presupuesto\\Presupuesto"+prop.getCliente_nif().getNif()+".pdf");
                String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("nif",prop.getCliente_nif().getNif());
                    ruta="FichaverPresupuestoPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:fichaCliente.htm?nifC="+prop.getCliente_nif().getNif();
            }       
        }catch(Exception e){

        }
        
        return(ruta);
    }
    
    @RequestMapping("FichapdfPresupuestoPdf.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("FichapdfPresupuestoPdf");        
        return mav;
    }
     @RequestMapping(value = "FichaverCertificacionesPdf.htm",method=RequestMethod.GET)
    public String FichaverCertificacionesPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=null;
       String ruta="";
        try{
            int res=proyectoCertificacionesService.existeCertificaciones(idPr);
            if(res!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("propuesta_id", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\certificaciones\\certificaciones.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proyecto\\certificaciones\\Certificaciones"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("nif",prop.getCliente_nif().getNif());
                    ruta="FichaverCertificacionesPdf";
            }else{
                System.out.println("NO hay certificaciones");
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","errorC");
                ruta="redirect:fichaCliente.htm?nifC="+prop.getCliente_nif().getNif();
            }       
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("FichapdfCertificacionesPdf.htm")
    public ModelAndView pdfCertificacionesPdf(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("FichapdfCertificacionesPdf");        
        return mav;
    }
    
    
    
    private propuesta prop=new propuesta();
    @RequestMapping(value = "FichaverContratoPdf.htm",method=RequestMethod.GET)
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
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\clientesFicha\\ContratoPropuesta"+prop.getCliente_nif().getNif()+".pdf");

        
                 }catch(Exception e){

               }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        //map.addAttribute("idP",idPr);
        return("FichaverContratoPdf");
    }
    
    @RequestMapping("pdfFichaContratoProyecto.htm")
    public ModelAndView pdf(ModelAndView mav){
        //propuesta prop=new propuesta();
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("pdfFichaContratoProyecto");        
        return mav;
    }
    
    @RequestMapping(value = "verFichaPlanObraPdf.htm",method=RequestMethod.GET)
    public String verPlanObraPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       //propuesta prop=new propuesta();
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
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\clientesFicha\\PlanObra"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    ruta="verFichaPlanObraPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","errorPlanObra");
                ruta="redirect:fichaCliente.htm?nifC="+prop.getCliente_nif().getNif();
            }       
        }catch(Exception e){

        }
        
        return(ruta);
    }
    
    @RequestMapping("pdfFichaPlanObraPdf.htm")
    public ModelAndView pdfPlanObra(ModelAndView mav){
        //propuesta prop=new propuesta();
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("pdfFichaPlanObraPdf");        
        return mav;
    }
    
}
