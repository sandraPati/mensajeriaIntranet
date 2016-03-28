/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.Roles;
import com.intranet.beans.conocimientos;
import com.intranet.beans.contrato;
import com.intranet.beans.cursos;
import com.intranet.beans.deducciones;
import com.intranet.beans.empleados;
import com.intranet.beans.estudios;
import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.futuro_empleo;
import com.intranet.beans.idiomas;
import com.intranet.beans.nomina;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.perfiles;
import com.intranet.beans.reporteNomina;
import com.intranet.beans.tipoidioma;
import com.intranet.beans.users;
import com.intranet.service.ContratoService;
import com.intranet.service.DeduccionesService;
import com.intranet.service.EmpleadoService;
import com.intranet.service.NominaService;
import com.intranet.service.OficioService;
import com.intranet.service.PerfilProfesionalService;
import com.intranet.service.PerfilesService;
import com.intranet.service.RolesService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.postulante.ConocimientosService;
import com.intranet.service.postulante.CursosService;
import com.intranet.service.postulante.EstudiosService;
import com.intranet.service.postulante.ExperienciaLaboralesService;
import com.intranet.service.postulante.FuturoEmpleoService;
import com.intranet.service.postulante.IdiomasService;
import com.intranet.service.postulante.TipoIdiomaService;
import java.io.File;
import java.security.Principal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
public class EmpController {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private PerfilesService perfilesService;
    
    @Autowired
    private PerfilProfesionalService perfilProfesionalService;
    @Autowired
    private OficioService oficioService;
    
     @Autowired
    private EstudiosService estudiosService;
     @Autowired
    private CursosService cursosService;
     @Autowired
    private TipoIdiomaService tipoIdiomaService;
     @Autowired
    private IdiomasService idiomasService;
    @Autowired
    private ConocimientosService conocimientosService;
    @Autowired
    private ExperienciaLaboralesService experienciaLaboralesService;
    @Autowired
    private FuturoEmpleoService futuroEmpleoService;
   @Autowired
    private RolesService rolesService;
   
   @Autowired
    private ContratoService contratoService;
    @Autowired
    private NominaService nominaService;
     @Autowired
    private DeduccionesService deduccionesService;
    
   
    @RequestMapping(value = "Datos.htm",method=RequestMethod.GET)
    public String Datos_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        empleados po=new empleados();
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        List<perfiles> listaPerfiles=null;
        List<estudios> ltaestudios=null;
        List<idiomas> ltaidiomas=null;
        List<conocimientos> ltaconocimientos=null;
        List<experiencia_laboral> ltaexperienciaLaboral=null;
        futuro_empleo ltafuturoEmpleo=null;
        try{
            
            users u=usuarioService.getByLogin(name);
            po=empleadoService.ByNif(u.getNif());
            ltaestudios=estudiosService.findAll(u.getNif());
            ltaidiomas=idiomasService.findAll(u.getNif());
            ltaconocimientos=conocimientosService.findAll(u.getNif());
            ltaexperienciaLaboral=experienciaLaboralesService.findAll(u.getNif());
            if(futuroEmpleoService.existeFEP(u.getNif())==true){
            ltafuturoEmpleo=futuroEmpleoService.porNif(u.getNif());
            }
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            listaPerfiles=perfilesService.findAll();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("empleado", po);
        map.addAttribute("ltaestudios", ltaestudios);
        map.addAttribute("ltaidiomas", ltaidiomas);
        map.addAttribute("ltaconocimientos", ltaconocimientos);
        map.addAttribute("ltaexperienciaLaboral", ltaexperienciaLaboral);
        map.addAttribute("ltafuturoEmpleo", ltafuturoEmpleo);
        map.addAttribute("listaPerfilProfesional", listaPerfilProfesional);
        map.addAttribute("listaOficios", listaOficios);
        map.addAttribute("listaPerfiles", listaPerfiles);
        //map.addAttribute("empleado",null);
        map.addAttribute("mensaje","mensaje");
        
        return "Datos";
    }
    
    
    
    @RequestMapping("UpdateDatos.htm")
    public String UpdateDatos_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        List<perfiles> listaPerfiles=null;
        empleados empleado=null;
        try{
            users u=usuarioService.getByLogin(name);
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            listaPerfiles=perfilesService.findAll();
            empleado=empleadoService.ByNif(u.getNif());
            System.out.println("NIF NIF1:"+empleado.getNif());
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("empleado", empleado);
        map.addAttribute("listaPerfilProfesional", listaPerfilProfesional);
        map.addAttribute("listaOficios", listaOficios);
        map.addAttribute("listaPerfiles", listaPerfiles);
        map.addAttribute("mensaje","mensaje");
        
        return "UpdateDatos";
    }
    
    @RequestMapping(value = "UpdateDatos.htm",method=RequestMethod.POST)
    public String UpdateDatos_post(@ModelAttribute("empleado")empleados emp,BindingResult result) {
        String mensaje="";
        
        //if(!result.hasErrors()){
            try {
                System.out.println("NIF NIF2:"+emp.getNif());
               
                if(emp.getNif()!=null){
                    System.out.println("update");
                    
                            users u=new users();
                            u.setNif(emp.getNif());
                            u.setEmail(emp.getEmail());
                            usuarioService.updateEmail(u);
                        
                    empleadoService.UpdateA(emp);
                   
                    
                }else mensaje="Se requiere el nif del empleado";
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	//}else{return "error";} 
         
            return "redirect:Datos.htm";
        
    }
    
    @RequestMapping(value = "addEstudioEmp.htm",method=RequestMethod.GET)
    public String addEstudio_get(ModelMap map) {
        List<cursos> listaCursos=null;
        
        try{
            listaCursos=cursosService.findAll();
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaCursos",listaCursos);
        map.addAttribute("estudio",new estudios());
        return "addEstudioEmp";
    }
     @RequestMapping(value = "addEstudioEmp.htm",method=RequestMethod.POST)
    public String addEstudio_post(@ModelAttribute("estudio")estudios est,BindingResult result,Principal principal) {
        String name = principal.getName();
        users u=null;
        String mensaje="";
        if(!result.hasErrors()){
            try {
                u=usuarioService.getByLogin(name);
                est.setPostulante_doc_identidad(u.getNif());
                if(est.getCurso_id()!=null && est.getCentro()!=null && est.getFecha_inicio_mes()!=null && est.getFecha_inicio_anio()!=null){
                    
                        mensaje=estudiosService.Insert(est);
                    
                }else mensaje="Se requieren campos obligatorios";
               
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:Datos.htm";
        
        
    }
    
    @RequestMapping("updateEstudioEmp.htm")
    public String updateEstudio_get(@RequestParam(value = "id") int id, ModelMap map){
        List<cursos> listaCursos=null;
        estudios estudio=null;
        try{
        listaCursos=cursosService.findAll();
        estudio=estudiosService.porNif(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaCursos",listaCursos);
        map.addAttribute("estudio",estudio);
       
        return "updateEstudioEmp";
    }
    
    @RequestMapping(value = "updateEstudioEmp.htm",method=RequestMethod.POST)
    public String updateEstudio_post(@ModelAttribute("estudio")estudios estudio,BindingResult result) {
        String rpta="";
       
        if(!result.hasErrors()){
            try {
                
                if(estudio.getId()!=0){
                    rpta=estudiosService.Update(estudio);
                }
               
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
        return "redirect:Datos.htm";      
    }
    @RequestMapping(value = "deleteEstudioEmp.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=estudiosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Datos.htm";  
    }
    
    @RequestMapping(value = "addIdiomaEmp.htm",method=RequestMethod.GET)
    public String addIdioma_get(ModelMap map) {
        List<tipoidioma> listaTipoIdioma=null;
        
        try{
        listaTipoIdioma=tipoIdiomaService.findAll();
        
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaTipoIdioma",listaTipoIdioma);
        map.addAttribute("idioma",new idiomas());
        return "addIdiomaEmp";
    }
     @RequestMapping(value = "addIdiomaEmp.htm",method=RequestMethod.POST)
    public String addIdioma_post(@ModelAttribute("idioma")idiomas idioma,BindingResult result,Principal principal) {
        String name=principal.getName();
        users u=null;
        String mensaje="";
        if(!result.hasErrors()){
            try {         
                u=usuarioService.getByLogin(name);
                idioma.setPostulante_doc_identidad(u.getNif());
                        mensaje=idiomasService.Insert(idioma);
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:Datos.htm";  
        
        
    }
    @RequestMapping("updateIdiomaEmp.htm")
    public String updateIdioma_get(@RequestParam(value = "id") int id, ModelMap map){
        List<tipoidioma> listaTipoIdioma=null;
        idiomas idioma=null;
        try{
        listaTipoIdioma=tipoIdiomaService.findAll();
        idioma=idiomasService.porId(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaTipoIdioma",listaTipoIdioma);
        map.addAttribute("idioma",idioma);
       
        return "updateIdiomaEmp";
    }
    
    @RequestMapping(value = "updateIdiomaEmp.htm",method=RequestMethod.POST)
    public String updateIdioma_post(@ModelAttribute("idioma")idiomas idioma,BindingResult result) {
        String rpta="";
        if(!result.hasErrors()){
            try {
                if(idioma.getId()!=0){
                    rpta=idiomasService.Update(idioma);
                }
               
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
       return "redirect:Datos.htm";        
    }
    @RequestMapping(value = "deleteIdiomaEmp.htm",method=RequestMethod.GET)
    public String eliminarIdioma(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=idiomasService.Delete(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Datos.htm"; 
    }
  
    @RequestMapping(value = "addConocimientoEmp.htm",method=RequestMethod.GET)
    public String addConocimiento_get(ModelMap map,Principal principal) {
       //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("conocimiento",new conocimientos());
        
        
        return "addConocimientoEmp";
    }
     @RequestMapping(value = "addConocimientoEmp.htm",method=RequestMethod.POST)
    public String addConocimiento_post(@ModelAttribute("conocimiento")conocimientos conocimiento,BindingResult result,Principal principal) {
        String name=principal.getName();
        users u=null;
        String mensaje="";
        if(!result.hasErrors()){
            try {       
                u=usuarioService.getByLogin(name);
                conocimiento.setPostulante_doc_identidad(u.getNif());
                if(conocimiento.getDescripcion()!=null){
                        mensaje=conocimientosService.Insert(conocimiento);
                }else mensaje="Debe llenar la Descripcion";
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
         return "redirect:Datos.htm"; 
        
        
    }
    @RequestMapping(value = "updateConocimientoEmp.htm",method=RequestMethod.GET)
    public String updateConocimiento_get(ModelMap map,@RequestParam(value = "id") int id) {
        conocimientos conocimiento=null;
        try{
           
                conocimiento=conocimientosService.porId(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }       
//ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("conocimiento", conocimiento);
        
        
        return "updateConocimientoEmp";
    }
    
    
    @RequestMapping(value = "updateConocimientoEmp.htm",method=RequestMethod.POST)
    public String updateConocimiento_post(@ModelAttribute("conocimiento")conocimientos conocimiento,BindingResult result) {
        String rpta="";
        if(!result.hasErrors()){
            try {
                if(conocimiento.getId()!=0){
                    rpta=conocimientosService.Update(conocimiento);
                }
               
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
       return "redirect:Datos.htm";      
    }
    @RequestMapping(value = "deleteConocimientoEmp.htm",method=RequestMethod.GET)
    public String eliminarConocimiento(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=conocimientosService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Datos.htm"; 
    }
    @RequestMapping(value = "addExperienciaLaboralEmp.htm",method=RequestMethod.GET)
    public String addExperienia_get(ModelMap map) {
            
//ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",new experiencia_laboral());
        
        
        return "addExperienciaLaboralEmp";
    }
   
     @RequestMapping(value = "addExperienciaLaboralEmp.htm",method=RequestMethod.POST)
    public String addExperienciaLaboral_post(@ModelAttribute("experienciaLaboral")experiencia_laboral experienciaLaboral,BindingResult result,Principal principal) {
        String name=principal.getName();
        users u=null;
        String mensaje="";
        if(!result.hasErrors()){
            try {       
                u=usuarioService.getByLogin(name);
                experienciaLaboral.setPostulante_doc_identidad(u.getNif());
               if(experienciaLaboral.getPuesto()!=null && experienciaLaboral.getEmpresa()!=null && experienciaLaboral.getFecha_inicio_anio()!=null && experienciaLaboral.getFecha_inicio_mes()!=null){
                        mensaje=experienciaLaboralesService.Insert(experienciaLaboral);
                }else mensaje="Debe llenar la Descripcion";
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:Datos.htm"; 
        
        
    }
    @RequestMapping(value = "updateExperienciaLaboralEmp.htm",method=RequestMethod.GET)
    public String updateExperienia_get(ModelMap map,@RequestParam(value = "id") int id) {
            experiencia_laboral experienciaLaboral=null;
        try{
           
                experienciaLaboral=experienciaLaboralesService.porNif(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
    //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",experienciaLaboral);
        
        
        return "updateExperienciaLaboralEmp";
    }
    
    
    @RequestMapping(value = "updateExperienciaLaboralEmp.htm",method=RequestMethod.POST)
    public String updateExperienciaLaboral_post(@ModelAttribute("experienciaLaboral")experiencia_laboral experienciaLaboral,BindingResult result) {
        String rpta="";
        if(!result.hasErrors()){
            try {
                if(experienciaLaboral.getId()!=0){
                    rpta=experienciaLaboralesService.Update(experienciaLaboral);
                }
               
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
        return "redirect:Datos.htm";    
    }
    
    @RequestMapping(value = "deleteExperienciaLaboralEmp.htm",method=RequestMethod.GET)
    public String eliminarExperienciaLaboral(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=experienciaLaboralesService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Datos.htm"; 
    }
    @RequestMapping( "FuturoEmpleoEmp.htm")
    public String futuroEmpleado_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        futuro_empleo futuroEmpleo=null;
        users u=null;
        int id=0;
        try{
            u=usuarioService.getByLogin(name);
            //futuroEmpleo.setPostulante_doc_identidad(u.getNif());
            if(futuroEmpleoService.existeFEP(u.getNif())==true){
                futuroEmpleo=futuroEmpleoService.porNif(u.getNif());
                id=futuroEmpleo.getId();
            }else{
                futuroEmpleo=new futuro_empleo();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("futuroEmpleo",futuroEmpleo);
        return "FuturoEmpleoEmp";
    }
    
   
     @RequestMapping(value = "FuturoEmpleoEmp.htm",method=RequestMethod.POST)
    public String FuturoEmpleo_post(@ModelAttribute("futuroEmpleo")futuro_empleo futuroEmpleo,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        users u=null;
       // if(!result.hasErrors()){
            try {
                u=usuarioService.getByLogin(name);
                futuroEmpleo.setPostulante_doc_identidad(u.getNif());
                if(futuroEmpleo.getBuscas_trabajo()!=null){
                    if(futuroEmpleoService.existeFEP(futuroEmpleo.getPostulante_doc_identidad())==true){
                       
                        mensaje=futuroEmpleoService.Update(futuroEmpleo);
                    }else{
                        
                        mensaje=futuroEmpleoService.Insert(futuroEmpleo);
                    }
                }  
                
               
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        //}else{return "error";}
        return "redirect:Datos.htm"; 
        
        
    }
    
    @RequestMapping("verContratosEmp.htm")
    public ModelAndView vercontrato_get(ModelAndView mav,Principal principal){
        String name=principal.getName();
        users u=null;
        List<contrato> ltacont=null;
        try{
            u=usuarioService.getByLogin(name);
            ltacont=contratoService.findAll(u.getNif());
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
           mav.addObject("menu",r);
        mav.addObject("ltacont",ltacont);
        mav.setViewName("verContratosEmp");   
        return mav;
    }
   
   
     @RequestMapping("viewNominaEmp.htm")
    public ModelAndView viewNominaEmp_get(@RequestParam(value = "idN") int idN,ModelAndView mav,Principal principal){
        nomina nomi=null;
        deducciones deducc=new deducciones();
        try{
            nomi=nominaService.ById(idN);
            deducc=deduccionesService.UltimoPorNomina(nomi.getId());
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("deducc",deducc);
        mav.addObject("nomina",nomi);
        mav.setViewName("viewNominaEmp");   
        return mav;
    }
    
    
    @RequestMapping("verNominasEmp.htm")
    public String nominasEmp_get(@RequestParam(value = "idC") int idC,
            @RequestParam(value = "msg", required = false) String msg,ModelMap mav,Principal principal){
        contrato cont=null;
        List<nomina> ltanomi=null;
        try{
            if(msg!=null & msg!=""){
                if (msg.equals("error")) {
                   mav.addAttribute("error", "Proceso Cancelado: la Nomina no tiene Deduccion registrada");
                }
            }
            cont=contratoService.porId(idC); 
            ltanomi=nominaService.findAll("","",idC);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("cont",cont);
        mav.addAttribute("ltanomi",ltanomi);
        //mav.setViewName("verNominasEmp");   
        return ("verNominasEmp");
    }
    
    
    
    @RequestMapping("verContratoCEmp.htm")
    public ModelAndView generateHtmlReport(@RequestParam(value = "idC") int idC,ModelAndView mav,Principal principal){
        String name=principal.getName();
        users u=null;
        empleados em=null;
       //List<contrato> ltacont=null;
        try{
            u=usuarioService.getByLogin(name);
            Connection con=null;
      conexion c=null;
      c=new conexion();
      con=c.getConnection();
         contrato cont=contratoService.porId(idC);
        //em=empleadoService.reporteContrato(u.getNif(),idC);
          Map<String,Object> params = new HashMap();
            params.put("nif",""+cont.getNif_empleado().getNif());
 		        
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
       //String url=request.getSession().getServletContext().getRealPath("/reportes/ContratoConfidencial"+em.getNif()+".pdf");
JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\contrato.jasper", params, con);
	JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\Contrato"+cont.getNif_empleado().getNif()+".pdf");
	
    
        }catch(Exception e){
      
      }
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("idC",idC);
        mav.setViewName("verContratoCEmp");   
        return mav;
    }
    
    @RequestMapping("verContratoCEmpConfidencial.htm")
    public ModelAndView generateHtmlReportConfidencial(@RequestParam(value = "idC") int idC,ModelAndView mav,Principal principal){
        String name=principal.getName();
        users u=null;
        empleados em=null;
       //List<contrato> ltacont=null;
        try{
            u=usuarioService.getByLogin(name);
            Connection con=null;
      conexion c=null;
      c=new conexion();
      con=c.getConnection();
        
        em=empleadoService.reporteContrato(u.getNif(),idC);
          Map<String,Object> params = new HashMap();
            params.put("idC",idC);
            //params.put("idC",""+idC);
            params.put("nif",""+u.getNif());
        
       //String url=request.getSession().getServletContext().getRealPath("/reportes/ContratoConfidencial"+em.getNif()+".pdf");
JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\RHContrato.jasper", params, con);
	JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\ContratoConfidencial"+em.getNif()+".pdf");
	
    
        }catch(Exception e){
      
      }
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("idC",idC);
        mav.setViewName("verContratoCEmpConfidencial");   
        return mav;
    }
   
    @RequestMapping("pdfContratoEmp.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idC") int idC,Principal principal){
        String name=principal.getName();
        users u=null;
        empleados em=null;
        try{
            u=usuarioService.getByLogin(name);
            em=empleadoService.reporteContrato(u.getNif(),idC);
            System.out.println("NIF ODF: "+em.getNif());
        }catch(Exception ex){
            ex.printStackTrace();
        }System.out.println("NIF ODF: "+em.getNif());
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",em.getNif());
        mav.setViewName("pdfContratoEmp");        
        return mav;
    }
    @RequestMapping("pdfContratoEmpConfidencial.htm")
    public ModelAndView pdfConfidencial(ModelAndView mav,@RequestParam(value = "idC") int idC,Principal principal){
        String name=principal.getName();
        users u=null;
        empleados em=null;
        try{
            u=usuarioService.getByLogin(name);
            em=empleadoService.reporteContrato(u.getNif(),idC);
            System.out.println("NIF ODF: "+em.getNif());
        }catch(Exception ex){
            ex.printStackTrace();
        }System.out.println("NIF ODF: "+em.getNif());
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",em.getNif());
        mav.setViewName("pdfContratoEmpConfidencial");        
        return mav;
    }
    @RequestMapping("verNominaCEmp.htm")
    public String verNominaCEmp(@RequestParam(value = "idC") int idC,ModelMap mav,Principal principal,@RequestParam(value = "idN") int idN){
       String name=principal.getName();
        users u=null;
        reporteNomina em=null;
        String ruta="redirect:verNominasEmp.htm?idC="+idC;
       //List<contrato> ltacont=null;
        try{
            if(deduccionesService.siexiste(idN)==true){
                Connection con=null;
                conexion c=null;
                c=new conexion();
                con=c.getConnection();
                u=usuarioService.getByLogin(name);
                em=empleadoService.reporteNomina(u.getNif(),idC,idN);
                Map<String,Object> params = new HashMap();
                params.put("nif",""+u.getNif());
	 		        params.put("cont",idC);
	 		        params.put("nomi",idN);
        
            JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\reportsRRHH\\RHNomina.jasper", params, con);
            JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\Nomina"+em.getNif()+".pdf");
            String r=validaInterfacesRoles.valida();
            mav.addAttribute("menu",r);
            mav.addAttribute("idC",idC);
            mav.addAttribute("idN",idN);
            ruta="verNominaCEmp";
            //mav.setViewName("verNominaCEmp"); 
            }else{

                System.out.println("NO existe");

                mav.addAttribute("msg","error");
                //ruta="redirect:verNominas.htm?nif="+em.getNif()+"&idC="+idC;
            }
        }catch(Exception e){
      
      }
          
        return ruta;
    }
    @RequestMapping("pdfNominaEmp.htm")
    public ModelAndView pdfNominaEmp(ModelAndView mav,@RequestParam(value = "idC") int idC,@RequestParam(value = "idN") int idN,Principal principal){
        String name=principal.getName();
        users u=null;
        reporteNomina em=null;
        try{
            u=usuarioService.getByLogin(name);
            em=empleadoService.reporteNomina(u.getNif(),idC,idN);
            System.out.println("NIF ODF: "+em.getNif());
        }catch(Exception ex){
            ex.printStackTrace();
        }System.out.println("NIF ODF: "+em.getNif());
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",em.getNif());
        mav.setViewName("pdfNominaEmp");        
        return mav;
    }
    
    
    @RequestMapping(value = "securityEmpleado.htm",method=RequestMethod.GET)
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
        
        return "securityEmpleado";
    }
    @RequestMapping(value = "securityEmpleado.htm",method=RequestMethod.POST)
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
	
            return "redirect:securityEmpleado.htm";
        
    }
    @RequestMapping(value = "fotoEmpleado.htm",method=RequestMethod.GET)
    public String fotoEmpleado_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        empleados po=new empleados();
        
        try{
            
            users u=usuarioService.getByLogin(name);
            
            po=empleadoService.ByNif(u.getNif());
            //po.setContrasenna("");
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("empleado",po);
        map.addAttribute("mensaje","mensaje");
        
        return "fotoSupervisor";
    }
    @RequestMapping(value = "fotoEmpleado.htm",method=RequestMethod.POST)
    public String fotoEmpleado_post(@ModelAttribute("empleado")empleados empleado,BindingResult result,HttpServletRequest request,Principal principal) {
        String mensaje="";
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosPerfil";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    String name = principal.getName();
        empleados po=new empleados();
    
    try{
        List<FileItem> partes=upload.parseRequest(request);
        for(FileItem item : partes)
        {
            System.out.println("NOMBRE FOTO: "+item.getName());
            File file=new File(ubicacionArchivo,item.getName());
            item.write(file);
            users u=usuarioService.getByLogin(name);
            po=empleadoService.ByNif(u.getNif());
            po.setNombrefotografia(item.getName());
            empleadoService.UpdateImagen(po);
        }
        System.out.println("Archi subido correctamente");
    }
    catch(Exception ex)
    {
        System.out.println("Error al subir archivo"+ex.getMessage());
    }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return "redirect:ActualizarfotoEmpleado.htm";
        
    }
    
    @RequestMapping(value = "ActualizarfotoEmpleado.htm",method=RequestMethod.GET)
    public String updateTamanoFoto_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        empleados po=new empleados();
        
        try{
            
            users u=usuarioService.getByLogin(name);
            
            po=empleadoService.ByNif(u.getNif());
            //po.setContrasenna("");
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("empleado",po);
        map.addAttribute("mensaje","mensaje");
        
        return "ActualizarfotoEmpleado";
    }
    @RequestMapping(value = "ActualizarfotoEmpleado.htm",method=RequestMethod.POST)
    public String updateTamanoFoto_post(@ModelAttribute("empleado")empleados empleado,BindingResult result,Principal principal) {
        String mensaje="";
        
    
    try{
        empleadoService.UpdateTamanoImagen(empleado);
    }
    catch(Exception ex)
    {
        System.out.println("Error al subir archivo"+ex.getMessage());
    }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return "redirect:ActualizarfotoEmpleado.htm";
        
    }
    
    
}
