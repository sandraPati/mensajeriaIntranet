/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.Roles;
import com.intranet.beans.conocimientos;
import com.intranet.beans.cursos;
import com.intranet.beans.empleados;
import com.intranet.beans.estudios;
import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.futuro_empleo;
import com.intranet.beans.idiomas;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.perfiles;
import com.intranet.beans.tipoidioma;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

@Controller
@RequestMapping("/sup/*")
public class SupControllerInformacion {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
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
    private PerfilesService perfilesService;
    
    @Autowired
    private PerfilProfesionalService perfilProfesionalService;
    @Autowired
    private OficioService oficioService;
     @Autowired
    private RolesService rolesService;
    
    @RequestMapping(value = "DatosSupervisor.htm",method=RequestMethod.GET)
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
        
        return "DatosSupervisor";
    }
    
    
    
    @RequestMapping("UpdateDatosSupervisor.htm")
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
        
        return "UpdateDatosSupervisor";
    }
    
    @RequestMapping(value = "UpdateDatosSupervisor.htm",method=RequestMethod.POST)
    public String UpdateDatos_post(@ModelAttribute("empleado")empleados emp,BindingResult result) {
        String mensaje="";
        
        //if(!result.hasErrors()){
            try {
                System.out.println("NIF NIF2:"+emp.getNif());
               
                if(emp.getNif()!=null){
                    System.out.println("update"+emp.getPais());
                    
                            users u=new users();
                            u.setNif(emp.getNif());
                            u.setEmail(emp.getEmail());
                            usuarioService.updateEmail(u);
                        
                    empleadoService.UpdateA(emp);
                    List<Roles> ltaRoles=rolesService.getList();
                    for (Roles r : ltaRoles) {
                        int n=emp.getId_perfil().getIdp();
                        switch (n) {
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
                    
                }else mensaje="Se requiere el nif del empleado";
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	//}else{return "error";} 
         
            return "redirect:DatosSupervisor.htm";
        
    }
    
    @RequestMapping(value = "addEstudioSupervisor.htm",method=RequestMethod.GET)
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
        return "addEstudioSupervisor";
    }
     @RequestMapping(value = "addEstudioSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm";
        
        
    }
    
    @RequestMapping("updateEstudioSupervisor.htm")
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
       
        return "updateEstudioSupervisor";
    }
    
    @RequestMapping(value = "updateEstudioSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm";      
    }
    @RequestMapping(value = "deleteEstudioSupervisor.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=estudiosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:DatosSupervisor.htm";  
    }
    
    @RequestMapping(value = "addIdiomaSupervisor.htm",method=RequestMethod.GET)
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
        return "addIdiomaSupervisor";
    }
     @RequestMapping(value = "addIdiomaSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm";  
        
        
    }
    @RequestMapping("updateIdiomaSupervisor.htm")
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
       
        return "updateIdiomaSupervisor";
    }
    
    @RequestMapping(value = "updateIdiomaSupervisor.htm",method=RequestMethod.POST)
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
       return "redirect:DatosSupervisor.htm";        
    }
    @RequestMapping(value = "deleteIdiomaSupervisor.htm",method=RequestMethod.GET)
    public String eliminarIdioma(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=idiomasService.Delete(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Datos.htm"; 
    }
  
    @RequestMapping(value = "addConocimientoSupervisor.htm",method=RequestMethod.GET)
    public String addConocimiento_get(ModelMap map,Principal principal) {
       //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("conocimiento",new conocimientos());
        
        
        return "addConocimientoSupervisor";
    }
     @RequestMapping(value = "addConocimientoSupervisor.htm",method=RequestMethod.POST)
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
         return "redirect:DatosSupervisor.htm"; 
        
        
    }
    @RequestMapping(value = "updateConocimientoSupervisor.htm",method=RequestMethod.GET)
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
        
        
        return "updateConocimientoSupervisor";
    }
    
    
    @RequestMapping(value = "updateConocimientoSupervisor.htm",method=RequestMethod.POST)
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
       return "redirect:DatosSupervisor.htm";      
    }
    @RequestMapping(value = "deleteConocimientoSupervisor.htm",method=RequestMethod.GET)
    public String eliminarConocimiento(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=conocimientosService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:DatosSupervisor.htm"; 
    }
    @RequestMapping(value = "addExperienciaLaboralSupervisor.htm",method=RequestMethod.GET)
    public String addExperienia_get(ModelMap map) {
            
//ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
       map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",new experiencia_laboral());
        
        
        return "addExperienciaLaboralSupervisor";
    }
   
     @RequestMapping(value = "addExperienciaLaboralSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm"; 
        
        
    }
    @RequestMapping(value = "updateExperienciaLaboralSupervisor.htm",method=RequestMethod.GET)
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
        
        
        return "updateExperienciaLaboralSupervisor";
    }
    
    
    @RequestMapping(value = "updateExperienciaLaboralSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm";    
    }
    
    @RequestMapping(value = "deleteExperienciaLaboralSupervisor.htm",method=RequestMethod.GET)
    public String eliminarExperienciaLaboral(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=experienciaLaboralesService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:DatosSupervisor.htm"; 
    }
    @RequestMapping( "FuturoEmpleoSupervisor.htm")
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
        return "FuturoEmpleoSupervisor";
    }
    
   
     @RequestMapping(value = "FuturoEmpleoSupervisor.htm",method=RequestMethod.POST)
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
        return "redirect:DatosSupervisor.htm"; 
        
        
    }
    
    @RequestMapping(value = "fotoSupervisor.htm",method=RequestMethod.GET)
    public String updateSecurityL_get(ModelMap map,Principal principal) {
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
    @RequestMapping(value = "fotoSupervisor.htm",method=RequestMethod.POST)
    public String updateSecurityL_post(@ModelAttribute("empleado")empleados empleado,BindingResult result,HttpServletRequest request,Principal principal) {
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
        
    
	
            return "redirect:ActualizarfotoSupervisor.htm";
        
    }
    
    @RequestMapping(value = "ActualizarfotoSupervisor.htm",method=RequestMethod.GET)
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
        
        return "ActualizarfotoSupervisor";
    }
    @RequestMapping(value = "ActualizarfotoSupervisor.htm",method=RequestMethod.POST)
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
        
    
	
            return "redirect:ActualizarfotoSupervisor.htm";
        
    }
    
}
