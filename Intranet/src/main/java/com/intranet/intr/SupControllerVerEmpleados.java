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
import com.intranet.beans.empleados;
import com.intranet.beans.estudios;
import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.finiquito;
import com.intranet.beans.futuro_empleo;
import com.intranet.beans.idiomas;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.perfiles;
import com.intranet.beans.tipoidioma;
import com.intranet.beans.users;
import com.intranet.service.ContratoService;
import com.intranet.service.EmpleadoService;
import com.intranet.service.FiniquitoService;
import com.intranet.service.OficioService;
import com.intranet.service.PerfilProfesionalService;
import com.intranet.service.PerfilesService;
import com.intranet.service.PostulanteService;
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
import java.sql.Connection;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerVerEmpleados {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private PostulanteService postulanteService;
    
    @Autowired
    private EstudiosService estudiosService;
    @Autowired    
    private IdiomasService idiomasService;
    @Autowired    
    private ConocimientosService conocimientosService;
    @Autowired    
    private ExperienciaLaboralesService experienciaLaboralesService;
    @Autowired    
    private FuturoEmpleoService futuroEmpleoService;
    
    @Autowired
    private PerfilesService perfilesService;
    @Autowired
    private PerfilProfesionalService perfilProfesionalService;
    @Autowired
    private OficioService oficioService;
    @Autowired
    private UsuarioService usuarioService;
    
     @Autowired
    private CursosService cursosService;
     @Autowired
    private TipoIdiomaService tipoIdiomaService;
    @Autowired
    private RolesService rolesService;
     @Autowired
    private ContratoService contratoService;
     @Autowired
    private FiniquitoService finiquitoService;
     
    @RequestMapping("verEmpleados.htm")
    public String verEmpleados(ModelMap mav,@RequestParam(value = "msg", required = false) String msg){
        System.out.println("entra a funcion documento");
        List<empleados> empleadoListbox=null;
        
        try{
            if(msg!=null & msg!=""){
               if(msg.equals("successAlta")) {
                    mav.addAttribute("msg", "Empleado dado de ALTA");
                }else if(msg.equals("successBaja")) {
                    mav.addAttribute("msg", "Empleado dado de BAJA");
                }else if (msg.equals("eInsertado")) {
                    mav.addAttribute("msg", "Se registro un Nuevo Empleado");
                }else if(msg.equals("errorAlta")) {
                    mav.addAttribute("error", "Error al dar empleado de Alta");
                }else if(msg.equals("errorBaja")) {
                    mav.addAttribute("error", "Error al dar empleado de Baja");
                }else if (msg.equals("errorFiniquito")) {
                    mav.addAttribute("error", "Operacion rechazada. Este empleado no esta dado de BAJA");
                }else if (msg.equals("errorC")) {
                    mav.addAttribute("error", "Operacion rechazada. El empleado seleccionado no tiene Contrato");
                }else if (msg.equals("eContrasena")) {
                    mav.addAttribute("error", "Operacion rechazada. Las contraseñas no Coinciden.");
                }else if (msg.equals("eCvacias")) {
                    mav.addAttribute("error", "Operacion rechazada. Contraseñas vacias.");
                }else if (msg.equals("eEusuemail")) {
                    mav.addAttribute("error", "Operacion rechazada. ya existe un usuario con el mismo email");
                }else if (msg.equals("eEusu")) {
                    mav.addAttribute("error", "Operacion rechazada. ya existe un usuario con el mismo NIF/NIE/PASAPORTE");
                }else if (msg.equals("eUsu")) {
                    mav.addAttribute("error", "Operacion rechazada. ya existe un usuario con la misma descripcion de usuario");
                }else if (msg.equals("eEnif")) {
                    mav.addAttribute("error", "Operacion rechazada. Se requiere el nif del empleado");
                }
               
            }
            System.out.println("entra a funcion documento");
            empleadoListbox=empleadoService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("empleadoListbox", empleadoListbox);
        return ("verEmpleados");
    }
    
    @RequestMapping("verDatosEmpleado.htm")
    public String verDatosEmpleado(@RequestParam(value = "nif") String nif,ModelMap map) {
        empleados empleado=null;
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        List<perfiles> listaPerfiles=null;
        List<estudios> ltaestudios=null;
        List<idiomas> ltaidiomas=null;
        List<conocimientos> ltaconocimientos=null;
        List<experiencia_laboral> ltaexperienciaLaboral=null;
        futuro_empleo ltafuturoEmpleo=null;
        try{
            empleado=empleadoService.ByNif(nif); 
            
            ltaestudios=estudiosService.findAll(nif);
            ltaidiomas=idiomasService.findAll(nif);
            ltaconocimientos=conocimientosService.findAll(nif);
            ltaexperienciaLaboral=experienciaLaboralesService.findAll(nif);
            if(futuroEmpleoService.existeFEP(nif)==true){
            ltafuturoEmpleo=futuroEmpleoService.porNif(nif);
            }
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            listaPerfiles=perfilesService.findAll();
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("empleado",empleado);
        map.addAttribute("ltaestudios", ltaestudios);
        map.addAttribute("ltaidiomas", ltaidiomas);
        map.addAttribute("ltaconocimientos", ltaconocimientos);
        map.addAttribute("ltaexperienciaLaboral", ltaexperienciaLaboral);
        map.addAttribute("ltafuturoEmpleo", ltafuturoEmpleo);
        map.addAttribute("listaPerfilProfesional", listaPerfilProfesional);
        map.addAttribute("listaOficios", listaOficios);
        map.addAttribute("listaPerfiles", listaPerfiles);
        return("verDatosEmpleado");
        
    }
    @RequestMapping(value = "securityDatosEmpleados.htm",method=RequestMethod.GET)
    public String securityDatosEmpleados_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        users po=null;
        
        try{
            
            po=usuarioService.getById(nif);
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
        
        return "securityDatosEmpleados";
    }
    
    @RequestMapping(value = "securityDatosEmpleados.htm",method=RequestMethod.POST)
    public String securityDatosEmpleados_post(@ModelAttribute("user")users u,BindingResult result) {
        String mensaje="";
        
            try {
                if(u.getNif()!=null && u.getContrasenna()!="" && u.getContrasenna2()!=""){
                   
                    if(u.getContrasenna().equals(u.getContrasenna2())){
                        if(usuarioService.validaExisteUCNif(u)==0){
                        mensaje=usuarioService.update(u);
                        }
                    }else{
			System.out.println("Las contraseñas no Coinciden");
                    }
                }else if(u.getNif()!=null){
                    System.out.println("USER ");
                    if(usuarioService.validaExisteUCNif(u)==0){
                     mensaje=usuarioService.update(u);
                    }
                }
                
                
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
         return "redirect:verEmpleados.htm";
        
    }
    @RequestMapping(value = "NuevoEmpleado.htm",method=RequestMethod.GET)
    public String NuevoEmpleado_get(ModelMap map) {
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        List<perfiles> listaPerfiles=null;
        empleados empleado=new empleados();
        try{
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            listaPerfiles=perfilesService.findAll();
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaPerfilProfesional", listaPerfilProfesional);
        map.addAttribute("listaOficios", listaOficios);
        map.addAttribute("listaPerfiles", listaPerfiles);
         map.addAttribute("empleado",empleado);
        return "NuevoEmpleado";
    }
     @RequestMapping(value = "NuevoEmpleado.htm",method=RequestMethod.POST)
    public String NuevoEmpleado_post(@ModelAttribute("empleado")empleados emp,BindingResult result,ModelMap map) {
        String mensaje="";
        //if(!result.hasErrors()){
            try {
                if(emp.getNif()!=null){
                    
                    if(usuarioService.validaNIF(emp.getNif())==0){
                         if(postulanteService.validaEmail(emp.getEmail())==0){
                             if( emp.getContrasenna()!="" && emp.getContrasenna2()!=""){
                                 if(emp.getContrasenna().equals(emp.getContrasenna2())){
                             users u =new users();
                            u.setUsuario(emp.getUsuario());
                            u.setContrasenna(emp.getContrasenna());
                            u.setNif(emp.getNif());
                            
                            if(usuarioService.validaExisteUC(u)==0){
                        empleadoService.Insert(emp);
                         map.addAttribute("msg","eInsertado");System.out.println("Empleado insertado");
                        List<Roles> ltaRoles=rolesService.getList();
                        for(Roles r:ltaRoles){
                            switch (emp.getId_perfil().getIdp()) {
                                case 2:
                                    {
                                        
                                        u.setEmail(emp.getEmail());
                                        u.setRol(rolesService.getRolesporId(3));
                                        usuarioService.insertar(u);
                                        usuarioService.anadirRolaUser(emp.getNif(), 3);
                                        break;
                                    }
                                case 4:
                                    {
                                        
                                        u.setEmail(emp.getEmail());
                                        u.setRol(rolesService.getRolesporId(2));
                                        usuarioService.insertar(u);
                                        usuarioService.anadirRolaUser(emp.getNif(), 2);
                                        break;
                                    }
                                case 1:
                                    {
                                        
                                        u.setEmail(emp.getEmail());
                                        u.setRol(rolesService.getRolesporId(2));
                                        usuarioService.insertar(u);
                                        usuarioService.anadirRolaUser(emp.getNif(), 2);
                                        break;
                                    }
                               default:
                                    {
                                       
                                u.setEmail(emp.getEmail());
                                u.setRol(rolesService.getRolesporId(3));
                                usuarioService.insertar(u);
                                usuarioService.anadirRolaUser(emp.getNif(), 3);
                                    }
                            }

                        }
                            }else  {map.addAttribute("msg","eUsu");}
                       
                                 }else{  map.addAttribute("msg","eContrasena");System.out.println("Las contraseñas no Coinciden.");}
                             }else{ map.addAttribute("msg","eCvacias");System.out.println("Contraseñas vacias.");}
                         }else{ map.addAttribute("msg","eEusuemail");System.out.println("ya existe un usuario con el mismo email");}
                    }else{  map.addAttribute("msg","eEusu");System.out.println("ya existe un usuario con el mismo NIF/NIE/PASAPORTE");}
                    
                }else {map.addAttribute("msg","eEnif");mensaje="Se requiere el nif del empleado";}
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        //}else{return "error";}
        return "redirect:verEmpleados.htm";
        
        
    }
    
    
   @RequestMapping("UpdateDatosEmpleado.htm")
    public String UpdateDatosEmpleado_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        List<perfiles> listaPerfiles=null;
        empleados empleado=null;
        try{
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            listaPerfiles=perfilesService.findAll();
            empleado=empleadoService.ByNif(nif);
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
        
        return "UpdateDatosEmpleado";
    }
    
    @RequestMapping(value = "UpdateDatosEmpleado.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("empleado")empleados emp,BindingResult result) {
        String mensaje="";
        
        //if(!result.hasErrors()){
            try {
                System.out.println("NIF NIF2:"+emp.getNif());
               
                if(emp.getNif()!=null){
                    System.out.println("update");
                    //if(usuarioService.validaNIF(emp.getNif())!=0){
                    empleadoService.UpdateA(emp);
                   
                        users ue=new users();
                            ue.setNif(emp.getNif());
                            ue.setEmail(emp.getEmail());
                            usuarioService.updateEmail(ue);
                    
                    List<Roles> ltaRoles=rolesService.getList();
                    for(Roles r:ltaRoles){
                        switch (emp.getId_perfil().getIdp()) {
                            case 2:
                                usuarioService.updateRol(emp.getNif(), 3);
                                break;
                            case 4:
                                usuarioService.updateRol(emp.getNif(), 2);
                                break;
                            case 1:
                                usuarioService.updateRol(emp.getNif(), 1);
                                break;
                        }
                    }
                    /*}else{
                        u.setNif(emp.getDocuemnto_identidad());
                        u.setUsuario(emp.getUsuario());
                        u.setContrasenna(emp.getContrasenna());
                        u.setEmail(emp.getEmail());
                        usuarioService.insertar(u);
                        usuarioService.anadirRolaUser(emp.getNif(), 3);
                    }*/
                    
                }else mensaje="Se requiere el nif del empleado";
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	//}else{return "error";} 
         
            return "redirect:verDatosEmpleado.htm?nif="+emp.getNif()+"";
        
    }
    
    
    @RequestMapping(value = "addEstudioE.htm",method=RequestMethod.GET)
    public String addEstudio_get(ModelMap map,@RequestParam(value = "nif") String nif) {
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
        map.addAttribute("nif",nif);
        return "addEstudioE";
    }
     @RequestMapping(value = "addEstudioE.htm",method=RequestMethod.POST)
    public String addEstudio_post(@ModelAttribute("estudio")estudios est,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try {
                if(est.getCurso_id()!=null && est.getCentro()!=null && est.getFecha_inicio_mes()!=null && est.getFecha_inicio_anio()!=null){
                    
                        mensaje=estudiosService.Insert(est);
                    
                }else mensaje="Se requieren campos obligatorios";
               
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:verDatosEmpleado.htm?nif="+est.getPostulante_doc_identidad()+"";
        
        
    }
    
    @RequestMapping("updateEstudioE.htm")
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
       
        return "updateEstudioE";
    }
    
    @RequestMapping(value = "updateEstudioE.htm",method=RequestMethod.POST)
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
        return "redirect:verDatosEmpleado.htm?nif="+estudio.getPostulante_doc_identidad()+"";      
    }
    
    @RequestMapping(value = "deleteEstudioE.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "id") int id,@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
            rpta=estudiosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:verDatosEmpleado.htm?nif="+nif+"";  
    }
    
    
     @RequestMapping(value = "addIdiomaE.htm",method=RequestMethod.GET)
    public String addIdioma_get(ModelMap map,@RequestParam(value = "nif") String nif) {
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
        map.addAttribute("nif",nif);
        return "addIdiomaE";
    }
     @RequestMapping(value = "addIdiomaE.htm",method=RequestMethod.POST)
    public String addIdioma_post(@ModelAttribute("idioma")idiomas idioma,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try {                    
                        mensaje=idiomasService.Insert(idioma);
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:verDatosEmpleado.htm?nif="+idioma.getPostulante_doc_identidad()+"";  
        
        
    }
    
    @RequestMapping("updateIdiomaE.htm")
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
       
        return "updateIdiomaE";
    }
    
    @RequestMapping(value = "updateIdiomaE.htm",method=RequestMethod.POST)
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
       return "redirect:verDatosEmpleado.htm?nif="+idioma.getPostulante_doc_identidad()+"";        
    }
    
    @RequestMapping(value = "deleteIdiomaE.htm",method=RequestMethod.GET)
    public String eliminarIdioma(@RequestParam(value = "id") int id,@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
            rpta=idiomasService.Delete(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:verDatosEmpleado.htm?nif="+nif+""; 
    }
    
    
    @RequestMapping(value = "addConocimientoE.htm",method=RequestMethod.GET)
    public String addConocimiento_get(ModelMap map,@RequestParam(value = "nif") String nif) {
       
                try{
                }catch(Exception e){
                
                }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("conocimiento",new conocimientos());
        map.addAttribute("nif",nif);
        return "addConocimientoE";
    }
     @RequestMapping(value = "addConocimientoE.htm",method=RequestMethod.POST)
    public String addConocimiento_post(@ModelAttribute("conocimiento")conocimientos conocimiento,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try {       
                if(conocimiento.getDescripcion()!=null){
                        mensaje=conocimientosService.Insert(conocimiento);
                }else mensaje="Debe llenar la Descripcion";
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
         return "redirect:verDatosEmpleado.htm?nif="+conocimiento.getPostulante_doc_identidad()+""; 
        
        
    }
    
    @RequestMapping("updateConocimientoE.htm")
    public String updateConocimiento_get(@RequestParam(value = "id") int id, ModelMap map){
        conocimientos conocimiento=null;
        try{
           
                conocimiento=conocimientosService.porId(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("conocimiento",conocimiento);
       
        return "updateConocimientoE";
    }
    
    @RequestMapping(value = "updateConocimientoE.htm",method=RequestMethod.POST)
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
       return "redirect:verDatosEmpleado.htm?nif="+conocimiento.getPostulante_doc_identidad()+"";      
    }
    
    @RequestMapping(value = "deleteConocimientoE.htm",method=RequestMethod.GET)
    public String eliminarConocimiento(@RequestParam(value = "id") int id,@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=conocimientosService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:verDatosEmpleado.htm?nif="+nif+""; 
    }
    
    @RequestMapping(value = "addExperienciaLaboralE.htm",method=RequestMethod.GET)
    public String addExperienciaLaboral_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        
                try{
                   
                }catch(Exception e){
                
                }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",new experiencia_laboral());
        map.addAttribute("nif",nif);
        return "addExperienciaLaboralE";
    }
     @RequestMapping(value = "addExperienciaLaboralE.htm",method=RequestMethod.POST)
    public String addExperienciaLaboral_post(@ModelAttribute("experienciaLaboral")experiencia_laboral experienciaLaboral,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try {       
               if(experienciaLaboral.getPuesto()!=null && experienciaLaboral.getEmpresa()!=null && experienciaLaboral.getFecha_inicio_anio()!=null && experienciaLaboral.getFecha_inicio_mes()!=null){
                        mensaje=experienciaLaboralesService.Insert(experienciaLaboral);
                }else mensaje="Debe llenar la Descripcion";
                 
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        }else{return "error";}
        return "redirect:verDatosEmpleado.htm?nif="+experienciaLaboral.getPostulante_doc_identidad()+""; 
        
        
    }
    
    @RequestMapping("updateExperienciaLaboralE.htm")
    public String updateExperienciaLaboral_get(@RequestParam(value = "id") int id, ModelMap map){
        experiencia_laboral experienciaLaboral=null;
        try{
           
                experienciaLaboral=experienciaLaboralesService.porNif(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",experienciaLaboral);
       
        return "updateExperienciaLaboralE";
    }
    
    @RequestMapping(value = "updateExperienciaLaboralE.htm",method=RequestMethod.POST)
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
        return "redirect:verDatosEmpleado.htm?nif="+experienciaLaboral.getPostulante_doc_identidad()+"";    
    }
    
    @RequestMapping(value = "deleteExperienciaLaboralE.htm",method=RequestMethod.GET)
    public String eliminarExperienciaLaboral(@RequestParam(value = "id") int id,@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=experienciaLaboralesService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:verDatosEmpleado.htm?nif="+nif+""; 
    }
    
    @RequestMapping(value = "FuturoEmpleoE.htm",method=RequestMethod.GET)
    public String FuturoEmpleo_get(ModelMap map,@RequestParam(value = "nif") String nif) {
       
        futuro_empleo futuroEmpleo=null;
        
        int id=0;
        try{
            
            //futuroEmpleo.setPostulante_doc_identidad(u.getNif());
            if(futuroEmpleoService.existeFEP(nif)==true){
                futuroEmpleo=futuroEmpleoService.porNif(nif);
                System.out.println("ID: "+futuroEmpleo.getId());
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
        map.addAttribute("nif",nif);
        map.addAttribute("id",id);
        return "FuturoEmpleoE";
    }
     @RequestMapping(value = "FuturoEmpleoE.htm",method=RequestMethod.POST)
    public String FuturoEmpleo_post(@ModelAttribute("futuroEmpleo")futuro_empleo futuroEmpleo,BindingResult result) {
        String mensaje="";
       // if(!result.hasErrors()){
            try {
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
        return "redirect:verDatosEmpleado.htm?nif="+futuroEmpleo.getPostulante_doc_identidad()+""; 
        
        
    }
    
    
    @RequestMapping(value = "securityDecorakiaEmp.htm",method=RequestMethod.GET)
    public String securityDecorakiaEmp_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        users u=new users();
        empleados c=null;
        try{
            c=empleadoService.ByNif(nif);
            u.setNif(c.getNif());
            u.setEmail(c.getEmail());
            if(usuarioService.validaExiste(u)==true){
                u=usuarioService.getById(nif);
                u.setCorreoContreasenna("");
            }
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("usu",u);
        map.addAttribute("mensaje","mensaje");
        
        return "securityDecorakiaEmp";
    }
    
    @RequestMapping(value = "securityDecorakiaEmp.htm",method=RequestMethod.POST)
    public String securityDecorakiaEmp_post(@ModelAttribute("usu")users u,BindingResult result) {
        String mensaje="";
        
        try{
            System.out.println("nif cliente:"+u.getNif());
            if(u.getNif()!=null && u.getContrasenna()!="" && u.getContrasenna2()!=""){
                System.out.println("Solo nif usurario y contra");
                    if(u.getCorreoContreasenna().equals(u.getContrasenna2())){
                        System.out.println("contrasenas iguales");
                        if(usuarioService.validaExiste(u)==true){
                            System.out.println("ya existe usuario con nif");
                            if(usuarioService.validaExisteUCNifcorreo(u)==0){
                                System.out.println("No existe usuario ");
                                usuarioService.updateCorreo(u);
                            }else System.out.println("Ya existe un usuario con el mismo usuario y contraseña");
                        }else{
                            System.out.println("NOexiste usuario con nif");
                            if(usuarioService.validaExisteUCcorreo(u)==0){
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
                     mensaje=usuarioService.updateCorreo(u);
                    }else{
                        if(usuarioService.validaExisteUCcorreo(u)==0){
                        empleados c=empleadoService.ByNif(u.getNif());
                        u.setEmail(c.getEmail());
                        usuarioService.insertar(u);
                        usuarioService.anadirRolaUser(u.getNif(), 5);
                        }
                    }
                        
                }
                
        }catch(Exception e){
        
        }
         return "redirect:verEmpleados.htm";
        
    }
    
    @RequestMapping(value="/ajaxEAlta.json", method=RequestMethod.GET)
    public String ajaxEAlta(@RequestParam(value="nif") String nif,ModelMap map) {
        
      System.out.println("baja"+nif);
        boolean r=false;
      int i=0;
        try{
          r=empleadoService.updateEstadoAlta(nif);
          if(r==true){
              i=1;
              map.addAttribute("msg","successAlta");
          }else map.addAttribute("msg","errorAlta");
              
      }catch(Exception ex){
      }
        
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return "redirect:verEmpleados.htm";
    }
 
    @RequestMapping(value="ajaxEBaja.json", method=RequestMethod.GET)
    public String ajaxEBaja(@RequestParam(value="nif") String nif,ModelMap map) {
        
      System.out.println("baja"+nif);
        boolean r=false;
      int i=1;
        try{
          r=empleadoService.updateEstadoBaja(nif);
          if(r==true){
              i=0;
              map.addAttribute("msg","successBaja");
          }else map.addAttribute("msg","errorBaja");
              
      }catch(Exception ex){
      }
        
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return "redirect:verEmpleados.htm";
    }
    
    
    @RequestMapping(value = "VerFiniquito.htm",method=RequestMethod.GET)
    public String VerFiniquito(@RequestParam(value = "nif") String nif,ModelMap map) {
       empleados e=new empleados();
       String ruta="";
        try{
            e=empleadoService.ByNif(nif);
            System.out.println("nif:"+nif);
            if(e.getEstadoaltabaja()==2){
                System.out.println("est:"+e.getEstadoaltabaja());
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("nif2", nif);
                   //C:\reportesIntranetDecorakia\presupuesto
                    System.out.println("antesdde jasper"+nif);
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\empleados\\finiquito\\finiquito.jasper", params, con);
                   System.out.println("despues1");
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\finiquito\\Finiquito"+nif+".pdf");
                   System.out.println("despues2:");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("nif",nif);
                    ruta="VerFiniquito";
            }else{
                map.addAttribute("msg","errorFiniquito");
                ruta="redirect:verEmpleados.htm";
            }        
        
        }catch(Exception ex){

        }
        return(ruta);
    }
    
    @RequestMapping("pdfFiniquito.htm")
    public ModelAndView pdfFiniquito(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("pdfFiniquito");        
        return mav;
    }
    
    @RequestMapping(value = "finiquito.htm", method = RequestMethod.GET)
    public String ajaxfiquito(ModelMap map,@RequestParam(value = "nif") String nif) {
        finiquito co=new finiquito();
        //System.out.println("ajaxtext");
        String ruta="";
        try{
             
             int idc=contratoService.UContratoF(nif);
             if(idc!=0){
                co.setId_contrato(idc);
                co.setNif_empleado(nif);
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("finiquito",co);
             ruta="finiquito";
             return ruta;
             }else{
             System.out.println("olacontrato id");
                map.addAttribute("msg","errorC");
                ruta="redirect:verEmpleados.htm";
            return ruta;
             }
             
         }catch(Exception ex){
             map.addAttribute("msg","errorC");
                ruta="redirect:verEmpleados.htm";
         }
         
            //tareaSupEmpService.insertTarea(tarea);
        return ruta;
    }
    
    @RequestMapping(value = "finiquito.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("finiquito")finiquito co,BindingResult result,ModelMap map) {
        String mensaje="";
        boolean r=false;
        int i=1;
        System.out.println("ola");
            try{
                if(finiquitoService.Insert(co)==true){
                //tareaSupEmpService.insertTarea(tarea);
                r=empleadoService.updateEstadoBaja(co.getNif_empleado());
                if(r==true){
                    i=0;
                    map.addAttribute("msg","successBaja");
                }else map.addAttribute("msg","errorBaja");
                }else map.addAttribute("msg","errorBaja");
            }catch(Exception e){

             }
	
            return "redirect:verEmpleados.htm";
        
    }
}
