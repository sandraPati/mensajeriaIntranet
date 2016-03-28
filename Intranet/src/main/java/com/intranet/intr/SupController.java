/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.NominaDeduccion;
import com.intranet.beans.contrato;
import com.intranet.beans.deducciones;
import com.intranet.beans.empleados;
import com.intranet.beans.nomina;
import com.intranet.beans.reporteNomina;
import com.intranet.beans.tipo_contrato;
import com.intranet.beans.users;
import com.intranet.service.ContratoService;
import com.intranet.service.DeduccionesService;
import com.intranet.service.EmpleadoService;
import com.intranet.service.NominaService;
import com.intranet.service.TipoContratoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import java.io.File;
import java.security.Principal;
import java.sql.Connection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/sup/*")
public class SupController {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TipoContratoService tipoContratoService;
    @Autowired
    private ContratoService contratoService;
    @Autowired
    private NominaService nominaService;
    @Autowired
    private DeduccionesService deduccionesService;
    
    @RequestMapping("DocumentosContratos.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav){
        System.out.println("entra a funcion documento");
        List<empleados> empleadoListbox=null;
        
        try{
            System.out.println("entra a funcion documento");
            empleadoListbox=empleadoService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleadoListbox", empleadoListbox);
        mav.addObject("mensaje", mav.getModelMap().get("mensaje"));
        mav.setViewName("DocumentosContratos");        
        return mav;
    }
    
    @RequestMapping("verContratos.htm")
    public String verContratos(@RequestParam(value = "nif") String nif,ModelMap map) {
        empleados empleado=null;
        
        List<contrato> ltacont=null;
        try{
            empleado=empleadoService.ByNif(nif); 
            ltacont=contratoService.findAll(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("empleado",empleado);
        map.addAttribute("ltacont",ltacont);
        return("verContratos");
        
    }
    
    @RequestMapping(value = "addContrato.htm",method=RequestMethod.GET)
    public String addContrato_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        List<tipo_contrato> allTipoContrato=null;
        contrato c=new contrato();
        empleados emp=empleadoService.ByNif(nif);
        c.setNif_empleado(emp);
        try{
        allTipoContrato=tipoContratoService.findAll();
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("allTipoContrato",allTipoContrato);
        map.addAttribute("contrato",c);
        map.addAttribute("empleado",emp);
        map.addAttribute("mensaje","mensaje");
        
        return "addContrato";
    }
    
    @RequestMapping(value = "addContrato.htm",method=RequestMethod.POST)
    public String addContrato_post(@ModelAttribute("contrato")contrato tra,BindingResult result) {
        String mensaje="";
        
                if(tra.getNif_empleado().getNif()!=null){
                    if(tra.getId_tipo_contrato()!=null){
                        switch (tra.getJornada()) {
                            case "Completo":
                                System.out.println("tiempo "+tra.getTiempo_rango1());
                                tra.setTiempo_rango(tra.getTiempo_rango1());
                                break;
                            case "Parcial":
                                System.out.println("parcial");    
                                System.out.println("tiempo "+tra.getTiempo_rango2());
                                tra.setTiempo_rango(tra.getTiempo_rango2());
                                break;
                        }
                        mensaje=contratoService.Insert(tra);
                    }else mensaje="Debe seleccionar un tipo de contrato";
                }else mensaje="Se requiere de un empleado regrese a elegir un empleado";
	 
	 
       
       
         return "redirect:verContratos.htm?nif="+tra.getNif_empleado().getNif();
        
        
        
    }
    
    @RequestMapping(value = "updateContrato.htm",method=RequestMethod.GET)
    public String updateContrato_get(ModelMap map,@RequestParam(value = "idC") int idC) {
        List<tipo_contrato> allTipoContrato=null;
        contrato c=contratoService.porId(idC);
        //empleados emp=empleadoService.ByNif(c.getNif_empleado().getNif());
        //c.setNif_empleado(emp);
        try{
        allTipoContrato=tipoContratoService.findAll();
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("allTipoContrato",allTipoContrato);
        map.addAttribute("contrato",c);
        //map.addAttribute("empleado",null);
        map.addAttribute("mensaje","mensaje");
        
        return "updateContrato";
    }
    
    @RequestMapping(value = "updateContrato.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("contrato")contrato tra,BindingResult result) {
        String mensaje="";
        System.out.println("id contrato");
        System.out.println("id: "+tra.getId());
           try{ 
                if(tra.getId()!=0){
                    if(tra.getId_tipo_contrato()!=null){
                        switch (tra.getJornada()) {
                            case "Completo":
                                tra.setTiempo_rango(tra.getTiempo_rango1());
                                break;
                            case "Parcial":
                                tra.setTiempo_rango(tra.getTiempo_rango2());
                                break;
                        }   
                        System.out.println("id c: "+tra.getId());
                        mensaje=contratoService.Update(tra);
                        tra=contratoService.porId(tra.getId());
                        //System.out.println("nif contrato. "+tra.getNif_empleado().getNif());
                        //tra.setNif_empleado(empleadoService.);
                    }else mensaje="Debe seleccionar un tipo de contrato";
                }else mensaje="Se requiere de un contrato regrese a elegir en la Lista de Contratos";
           }catch(Exception ex){}
         
            return "redirect:verContratos.htm?nif="+tra.getNif_empleado().getNif()+"";
        
    }
    
    @RequestMapping(value="deleteContrato.htm",method=RequestMethod.GET)
    public String deleteContrato_post(@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,ModelMap map) {
        System.out.println("nif: "+nif);
        String mensaje="";
        
            try {
                if(idC!=0 && nif!=null){
                      
                        mensaje=contratoService.Delete(idC);
                    
                }else mensaje="Se requiere del NIF y el ID del contrato";
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:verContratos.htm?nif="+nif;
        
        
    }
    
    @RequestMapping("verContratoC.htm")
    public String generateHtmlReport(@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,ModelMap map) {
        empleados em=null;
        try{
        Connection con=null;
      conexion c=null;
      c=new conexion();
      con=c.getConnection();
        contrato cont=contratoService.porId(idC);
	//empleados e=empleadoService.ByNif(cont.getNif_empleado().getNif());
         Map<String,Object> params = new HashMap();
 		        params.put("nif",""+nif);
 		        
 		        params.put("categoria_profesional",""+cont.getCategoria_profesional());
 		        params.put("grupo",""+cont.getNivel_profesional());
 		        params.put("num_horas1",""+cont.getNum_horas1());
 		        params.put("num_horas2",""+cont.getNum_horas2());
 		        params.put("rango",""+cont.getTiempo_rango1());
 		        params.put("tiempo",""+cont.getTiempo_rango2());
 		        params.put("distribucion_tiempo",""+cont.getDistribucion_tiempo());
 		        params.put("corresponde_contrato",""+cont.getCorresponde_contrato());
 		        params.put("pacto_horas",""+cont.getPacto_horas_complementarias());
 		        params.put("fecha_desde",""+cont.getDuracion_contrato_desde());
 		        params.put("periodo_prueba",""+cont.getPeriodo_prueba());
 		        params.put("contrato_relevo",""+cont.getContrato_relevo());
 		        params.put("retribucion_total",""+cont.getRetribucion_total());
 		        params.put("vacaciones",""+cont.getVacaciones());
 		        params.put("fecha_contrato",""+cont.getFecha_contrato());
 		        params.put("clausulas",""+cont.getClausulas());
 		        params.put("conceptos_salariales",""+cont.getConceptos_salariales());
 		        params.put("tipo_contrato",""+cont.getId_tipo_contrato().getNombre());
                        if(cont.getId_tipo_contrato().getNombre().equals("Contrato Indefinido")){
                            params.put("Dtipo_contrato","Indefinido");
                            params.put("fecha_fin","");
                        }else if(cont.getId_tipo_contrato().getNombre().equals("Contrato Practicas")){
                            params.put("Dtipo_contrato","Practicas");
                            params.put("fecha_fin","hasta "+cont.getDuracion_contrato_hasta());
                        }else if(cont.getId_tipo_contrato().getNombre().equals("Contrato de Formacion y Aprendizaje")){
                            params.put("Dtipo_contrato","Formacion y Aprendizaje");
                            params.put("fecha_fin","hasta "+cont.getDuracion_contrato_hasta());
                        }else if(cont.getId_tipo_contrato().getNombre().equals("Contrato Temporal")){
                            params.put("Dtipo_contrato","Temporal");
                            params.put("fecha_fin","hasta "+cont.getDuracion_contrato_hasta());
                        }
                        //params.put("Dtipo_contrato","");
   String realPath="";    
 //String url=request.getSession().getServletContext().getRealPath("/resources/ContratoConfidencial"+em.getNif()+".pdf");
// ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
 realPath=(String) "/";     
JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\contrato.jasper", params, con);

JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\Contrato"+nif+".pdf");
	
    
        }catch(Exception e){
      
      }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nif",nif);
        map.addAttribute("idC",idC);
        return("verContratoC");
        
    }
    
    @RequestMapping("verContratoConfidencial.htm")
    public String verContratoConfidencial(@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,ModelMap map) {
        empleados em=null;
        try{
        Connection con=null;
      conexion c=null;
      c=new conexion();
      con=c.getConnection();
        
        em=empleadoService.reporteContrato(nif,idC);
         Map<String,Object> params = new HashMap();
            params.put("idC",idC);
            //params.put("idC",""+idC);
            params.put("nif",""+nif);
   String realPath="";    
 //String url=request.getSession().getServletContext().getRealPath("/resources/ContratoConfidencial"+em.getNif()+".pdf");
// ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
 realPath=(String) "/";     
JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\RHContrato.jasper", params, con);

JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\ContratoConfidencial"+em.getNif()+".pdf");
	
    
        }catch(Exception e){
      
      }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nif",em.getNif());
        map.addAttribute("idC",idC);
        return("verContratoConfidencial");
        
    }
    
    
    @RequestMapping("pdf.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("pdf");        
        return mav;
    }
    
    @RequestMapping("pdfCC.htm")
    public ModelAndView pdfCC(ModelAndView mav,@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC){
        empleados em=null;
        try{
            em=empleadoService.reporteContrato(nif,idC);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",em.getNif());
        mav.setViewName("pdfCC");        
        return mav;
    }
    
    
    @RequestMapping("verNominaC.htm")
    public String generateHtmlReportNomina( @RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,@RequestParam(value = "idN") int idN,ModelMap map) {
        reporteNomina em=null;
        String ruta="redirect:verNominas.htm?nif="+nif+"&idC="+idC;
        deducciones d=null;
        try{
            //d=deduccionesService.UltimoPorNomina(idN);
        if(deduccionesService.siexiste(idN)==true){
            System.out.println("existe");
            Connection con=null;
            conexion c=null;
            c=new conexion();
            con=c.getConnection();

              em=empleadoService.reporteNomina(nif,idC,idN);
               Map<String,Object> params = new HashMap();
                 params.put("nif",""+nif);
                                      params.put("cont",idC);
                                      params.put("nomi",idN);

             //String url=request.getSession().getServletContext().getRealPath("/reportes/Nomina"+em.getNif()+".pdf");
            JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\RHNomina.jasper", params, con);
              JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\Nomina"+em.getNif()+".pdf");
            String r=validaInterfacesRoles.valida();
            map.addAttribute("menu",r);
            map.addAttribute("nif",em.getNif());
            map.addAttribute("idC",idC);
            map.addAttribute("idN",idN);
            ruta="verNominaC";
        }else{
            
            System.out.println("NO existe");
            
            map.addAttribute("msg","error");
            //ruta="redirect:verNominas.htm?nif="+em.getNif()+"&idC="+idC;
        }
        
        
    //C:\glassfish-4.1.1-web\glassfish4\glassfish\domains\domain1\applications
        }catch(Exception e){
      
      }
        
        
        return(ruta);
        
    }
    @RequestMapping("pdfNomina.htm")
    public ModelAndView pdfNomina(ModelAndView mav,@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,@RequestParam(value = "idN") int idN){
        reporteNomina em=null;
        try{
            em=empleadoService.reporteNomina(nif,idC,idN);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",em.getNif());
        mav.setViewName("pdfNomina");        
        return mav;
    }
    
     private NominaDeduccion n=new NominaDeduccion();
    @RequestMapping("verNominas.htm")
    public String verNominas(@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,
        @RequestParam(value = "msg", required = false) String msg,ModelMap map) {
        contrato cont=null;
        n=new NominaDeduccion();
        List<nomina> ltanomi=null;
        try{
            if(msg!=null & msg!=""){
                if (msg.equals("error")) {
                   map.addAttribute("error", "Proceso Cancelado: la Nomina no tiene Deduccion registrada");
                }
            }
            cont=contratoService.porId(idC); 
            ltanomi=nominaService.findAll("","",idC);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nif",nif);
        map.addAttribute("cont",cont);
        map.addAttribute("ltanomi",ltanomi);
        return("verNominas");
        
    }
    
    @RequestMapping(value = "volcarNomina.htm",method=RequestMethod.GET)
    public String volcarNomina_get(ModelMap map,@RequestParam(value = "idN") int idN) {
        empleados emp=new empleados();
        contrato c=new contrato();
        nomina nomi=new nomina();
        deducciones deducc=new deducciones();
        NominaDeduccion nomideduc=new NominaDeduccion();
        try{
            deducc=deduccionesService.UltimoPorNomina(idN);
            nomi=nominaService.ById(idN);
            nomideduc.setNominaId(nomi);
            nomideduc.setDeduccionId(deducc);
            n=nomideduc;
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        //map.addAttribute("menu",r);
        map.addAttribute("nif",nomideduc.getNominaId().getNif_empleado().getNif());
        map.addAttribute("idC",nomideduc.getNominaId().getC().getId());
        map.addAttribute("opcion","1");
        
        System.out.println("nominaVolcar:?nif="+nomideduc.getNominaId().getNif_empleado().getNif()+"&idC="+nomideduc.getNominaId().getC().getId());
        return "redirect:addNomina.htm";
    }
    
    @RequestMapping(value = "addNomina.htm",method=RequestMethod.GET)
    public String addNomina_get(ModelMap map,@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,@RequestParam(value = "opcion", required = false) String opcion) {
        empleados emp=new empleados();
        contrato c=new contrato();
        NominaDeduccion no=new NominaDeduccion();
        nomina nomi=new nomina();
        deducciones deducc=new deducciones();
        try{
            if(opcion!=null && opcion!=""){
                if(n.getNominaId()!=null){
                if(n.getNominaId().getNif_empleado().getNif()!=null && n.getNominaId().getNif_empleado().getNif()!=""){
                    no=n;
                    System.out.println("volcar");
                }
            
                }
            }else{
                 System.out.println("insertar");
                emp=empleadoService.ByNif(nif);
                c=contratoService.porId(idC);
                nomi.setNif_empleado(emp);
                nomi.setC(c);
                deducc.setNif_empleado(emp);

                no.setNominaId(nomi);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nomina",no);
        return "addNomina";
    }
    
    @RequestMapping(value = "addNomina.htm",method=RequestMethod.POST)
    public String addNomina_post(@ModelAttribute("nomina")NominaDeduccion tra,BindingResult result) {
        String mensaje="";
        try{
                if(tra.getNominaId().getNif_empleado().getNif()!=null && tra.getNominaId().getNif_empleado().getNif()!="" && tra.getNominaId().getC().getId()!=0){
                    System.out.println("contrato");
                    if(tra.getNominaId().getMes()!=null && tra.getNominaId().getAnio()!=null){
                        System.out.println("mes y ano "+tra.getNominaId().getMes()+"-"+tra.getNominaId().getAnio());
                       /*boolean r=nominaService.existeNominaM(tra.getNif_empleado().getNif(),tra.getMes(),tra.getAnio());
                       if(r==false){*/
                           System.out.println("insert");
                        boolean rn=nominaService.Insert(tra.getNominaId());
                        System.out.println("insert2");
                         if(rn==true){
                             System.out.println("insert3");
                        nomina nomir=nominaService.UltimoPorEmpleado(tra.getNominaId().getNif_empleado().getNif());
                        System.out.println("deducc"+nomir.getId());
                        if(nomir.getId()!=0){
                        tra.getDeduccionId().setNif_empleado(tra.getNominaId().getNif_empleado());
                        tra.getDeduccionId().setNom(nomir);
                       /* if(deduccionesService.siexiste(nomir.getId())==true){
                            System.out.println("update");
                                    deduccionesService.Update(tra.getDeduccionId());


                        }else{*/
                            System.out.println("insert");
                                 deduccionesService.Insert(tra.getDeduccionId());

                       // }
                        }
                         }
                      // }
                    }else mensaje="Debe Llenar Mes y Año";
                }else mensaje="Se requiere de un empleado regrese a elegir un empleado";
	 
	 
        }catch(Exception ex){
        }
       
       
         return "redirect:verNominas.htm?nif="+tra.getNominaId().getNif_empleado().getNif()+"&idC="+tra.getNominaId().getC().getId();
        
        
        
    }/*
    @RequestMapping(value = "updateDeducciones.htm",method=RequestMethod.GET)
    public String updateDeducc_get(ModelMap map,@RequestParam(value = "idN") int idN) {
        empleados emp=new empleados();
        
        nomina nomi=new nomina();
        deducciones deducc=new deducciones();
        try{
            nomi=nominaService.ById(idN);
            //nomi.setNif_empleado(emp);
            if(deduccionesService.siexiste(idN)==true){
            deducc=deduccionesService.UltimoPorNomina(nomi.getId());
            }else{
                deducc.setNif_empleado(nomi.getNif_empleado());
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nomina",nomi);
         map.addAttribute("deducc",deducc);
        return "updateDeducciones";
    }
   
    @RequestMapping(value = "updateDeducciones.htm",method=RequestMethod.POST)
    public String updateDeducciones_post(@ModelAttribute("deducc")deducciones deducc,BindingResult result) {
        String mensaje=""; 
        nomina n=new nomina();
        if(!result.hasErrors()){
           try{
                if(deduccionesService.siexiste(deducc.getNom().getId())==true){
                    System.out.println("update");
                            deduccionesService.Update(deducc);
                    
                    
                }else{
                    System.out.println("insert");
                         deduccionesService.Insert(deducc);
                    
                }
                n=nominaService.ById(deducc.getNom().getId());
        }catch(Exception ex){
        }
	}else{return "error";} 
         
            return "redirect:verNominas.htm?nif="+n.getNif_empleado().getNif()+"&idC="+n.getC().getId();
        
    }*/
    
    @RequestMapping(value = "updateNomina.htm",method=RequestMethod.GET)
    public String updateNomina_get(ModelMap map,@RequestParam(value = "idN") int idN) {
        nomina nomi=new nomina();
        deducciones deduc=new deducciones();
        NominaDeduccion nomideduc=new NominaDeduccion();
        try{
            deduc=deduccionesService.UltimoPorNomina(idN);
            nomi=nominaService.ById(idN);
            nomideduc.setNominaId(nomi);
            nomideduc.setDeduccionId(deduc);
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nomina",nomideduc);
        //map.addAttribute("empleado",null);
        map.addAttribute("mensaje","mensaje");
        
        return "updateNomina";
    }
    
    @RequestMapping(value = "updateNomina.htm",method=RequestMethod.POST)
    public String updateNomina_post(@ModelAttribute("nomina")NominaDeduccion tra,BindingResult result) {
        String mensaje=""; 
        if(!result.hasErrors()){
           try{
                System.out.println("nomina id:"+tra.getNominaId().getId()+"contr."+tra.getNominaId().getC().getId()+"emp:"+tra.getNominaId().getNif_empleado().getNif());
                if(tra.getNominaId().getId()!=0 && tra.getNominaId().getC().getId()!=0){
                    if(tra.getNominaId().getMes()!=null && tra.getNominaId().getAnio()!=null){
                       //boolean r=nominaService.existeNominaMporID(tra.getNif_empleado().getNif(),tra.getMes(),tra.getAnio(),tra.getId());
                      // System.out.println("result "+r);
                       mensaje=nominaService.Update(tra.getNominaId());
                       deduccionesService.Update(tra.getDeduccionId());
                        System.out.println("nomina id:"+tra.getNominaId().getId());
                    }else mensaje="Debe Llenar Mes y Año";
                }else mensaje="Se requiere de una Nomina de un Contrato";
	 
	 
        }catch(Exception ex){
        }
	}else{return "error";} 
         
            return "redirect:verNominas.htm?nif="+tra.getNominaId().getNif_empleado().getNif()+"&idC="+tra.getNominaId().getC().getId();
        
    }
    
    @RequestMapping(value="deleteNomina.htm",method=RequestMethod.GET)
    public String deleteNomina_post(@RequestParam(value = "nif") String nif,@RequestParam(value = "idC") int idC,@RequestParam(value = "idN") int idN,ModelMap map) {
        String mensaje="";
            try {
                if(idN!=0){
                      deduccionesService.Delete(idN);
                      mensaje=nominaService.Delete(idN);
                }else mensaje="Se requiere del NIF y el ID del contrato";
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:verNominas.htm?nif="+nif+"&idC="+idC;
        
        
    }
    
    @RequestMapping(value = "securitySupervisor.htm",method=RequestMethod.GET)
    public String updateSecurityL_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        users po=new users();
        
        try{
            
            users u=usuarioService.getByLogin(name);
            
            po=usuarioService.getById(u.getNif());
            po.setContrasenna("");
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("user", po);
        //map.addAttribute("empleado",null);
        map.addAttribute("mensaje","mensaje");
        
        return "securitySupervisor";
    }
    @RequestMapping(value = "securitySupervisor.htm",method=RequestMethod.POST)
    public String updateSecurityL_post(@ModelAttribute("user")users p,BindingResult result) {
        String mensaje="";
        
            try {
                if(p.getNif()!=null && p.getContrasenna()!="" && p.getContrasenna2()!=""){
                    if(p.getContrasenna().equals(p.getContrasenna2())){
                        if(usuarioService.validaExisteUCNif(p)==0){
                        mensaje=usuarioService.update(p);
                        }
                    }else{
			System.out.println("Las contraseñas no Coinciden");
                    }
                }else if(p.getNif()!=null){
                    if(usuarioService.validaExisteUCNif(p)==0){
                     mensaje=usuarioService.update(p);
                    }
                }
                
                
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	
            return "redirect:securitySupervisor.htm";
        
    }
}
