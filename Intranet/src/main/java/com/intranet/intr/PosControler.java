/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.conocimientos;
import com.intranet.beans.cursos;
import com.intranet.beans.empleados;
import com.intranet.beans.estudios;
import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.futuro_empleo;
import com.intranet.beans.idiomas;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.postulantes;
import com.intranet.beans.tipoidioma;
import com.intranet.beans.users;
import com.intranet.intr.mensajesEmail.mensajeP;
import com.intranet.service.OficioService;
import com.intranet.service.PerfilProfesionalService;
import com.intranet.service.PostulanteService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.postulante.ConocimientosService;
import com.intranet.service.postulante.CursosService;
import com.intranet.service.postulante.EstudiosService;
import com.intranet.service.postulante.ExperienciaLaboralesService;
import com.intranet.service.postulante.FuturoEmpleoService;
import com.intranet.service.postulante.IdiomasService;
import com.intranet.service.postulante.TipoIdiomaService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pos/*")
public class PosControler {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private PostulanteService postulanteService;
    @Autowired
    private UsuarioService usuarioService;
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
    String mensaje="";
    
    @RequestMapping(value = "Informacion.htm",method=RequestMethod.GET)
    public String updateContrato_get(ModelMap map,Principal principal,@RequestParam(value = "msg", required = false) String state) {
        String name = principal.getName();
        System.out.println("usu: "+name);
        postulantes po=new postulantes();
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        try{
            
            users u=usuarioService.getByLogin(name);
            po=postulanteService.ByNif(u.getNif());
            System.out.println("nif: "+po.getDocuemnto_identidad());
            listaPerfilProfesional=perfilProfesionalService.findAll();
            listaOficios=oficioService.findAll();
            if (state.equals("success")) {
			map.addAttribute("mensaje", "Gracias por Completar su información, en breve recibirá un mail");
                        
		}

		if (state.equals("error")) {
			map.addAttribute("error", "Error Inesperado del sistema!.");
		}
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("postulante", po);
        map.addAttribute("listaPerfilProfesional", listaPerfilProfesional);
        map.addAttribute("listaOficios", listaOficios);
        //map.addAttribute("empleado",null);
        
        return "Informacion";
    }
    
    @RequestMapping(value = "Informacion.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("postulante")postulantes p,BindingResult result) {
        
        String ruta="redirect:Informacion.htm";
            try {
                if(p.getDocuemnto_identidad()!=null){
                        postulantes pos=postulanteService.ByNif(p.getDocuemnto_identidad());
                        if(pos.getEmail().equals(p.getEmail())){
                            users u=new users();
                            u.setNif(p.getDocuemnto_identidad());
                            u.setEmail(p.getEmail());
                            usuarioService.updateEmail(u);
                        }
                         mensaje=postulanteService.UpdateSinImagenSinCV(p);
                         
                }else {mensaje="Se requiere de NIF/NIE/PASAPORTE";}
                if(p.getEstadoinf()==false){
                    ruta="redirect:fotoPostulante.htm";
                }
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	
            return ruta;    
        
    }
    
    @RequestMapping(value = "securityPostulante.htm",method=RequestMethod.GET)
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
        
        return "securityPostulante";
    }
    @RequestMapping(value = "securityPostulante.htm",method=RequestMethod.POST)
    public String updateSecurityL_post(@ModelAttribute("user")users p,BindingResult result) {
        String mensaje="";
        
            try {
                if(p.getNif()!=null && p.getContrasenna()!="" && p.getContrasenna2()!=""){
                    if(p.getContrasenna().equals(p.getContrasenna2())){
                        mensaje=usuarioService.update(p);
                    }else{
			System.out.println("Las contraseñas no Coinciden");
                    }
                }else if(p.getNif()!=null){
                     mensaje=usuarioService.update(p);
                }
                
                
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	
            return "redirect:Informacion.htm";
        
    }
    
    
    
    @RequestMapping("EstudiosP.htm")
    public ModelAndView EstudiosList(ModelAndView mav,Principal principal){
        System.out.println("entra a funcion documento");
        String name = principal.getName();
        
        List<estudios> listaEstudios=null;
        postulantes p=null;
        try{
            users u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
            listaEstudios=estudiosService.findAll(u.getNif());
            System.out.println("entra a funcion documento");
             
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", p);
        mav.addObject("listaEstudios", listaEstudios);
        mav.addObject("mensaje", mav.getModelMap().get("mensaje"));
        mav.setViewName("EstudiosP");        
        return mav;
    }
    
    @RequestMapping("EstudiosView.htm")
    public ModelAndView EstudiosVList(ModelAndView mav,Principal principal){
        System.out.println("entra a funcion documento");
        String name = principal.getName();
        
        List<estudios> listaEstudios=null;
        
        try{
            users u=usuarioService.getByLogin(name);
            listaEstudios=estudiosService.findAll(u.getNif());
            System.out.println("entra a funcion documento");
             
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaEstudios", listaEstudios);
        mav.setViewName("EstudiosView");        
        return mav;
    }
   
    
    @RequestMapping(value = "addEstudio.htm",method=RequestMethod.GET)
    public String addEstudio_get(ModelMap map,Principal principal) {
        List<cursos> listaCursos=null;
        postulantes p=null;
        users u=null;
        try{
        listaCursos=cursosService.findAll();
        
        u=usuarioService.getByLogin(principal.getName());
        p=postulanteService.ByNif(u.getNif());
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("postulante",p);
         map.addAttribute("listaCursos",listaCursos);
        map.addAttribute("estudio",new estudios());
        map.addAttribute("nif",u.getNif());
        return "addEstudio";
    }
     @RequestMapping(value = "addEstudio.htm",method=RequestMethod.POST)
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
        return "redirect:EstudiosP.htm";
        
        
    }
    
    @RequestMapping("updateEstudio.htm")
    public String updateEstudio_get(@RequestParam(value = "id") int id, ModelMap map,Principal principal){
        String name=principal.getName();
        users u=null;
        List<cursos> listaCursos=null;
        estudios estudio=null;
        postulantes p=null;
        try{
            u=usuarioService.getByLogin(name);
        p=postulanteService.ByNif(u.getNif());    
        listaCursos=cursosService.findAll();
        estudio=estudiosService.porNif(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("postulante",p);
         map.addAttribute("listaCursos",listaCursos);
        map.addAttribute("estudio",estudio);
       
        return "updateEstudio";
    }
    
    @RequestMapping(value = "updateEstudio.htm",method=RequestMethod.POST)
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
        return "redirect:EstudiosP.htm";       
    }
    
    @RequestMapping(value = "deleteEstudio.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=estudiosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EstudiosP.htm";
    }
    
    
    @RequestMapping("IdiomasP.htm")
    public ModelAndView IdiomasList(ModelAndView mav,Principal principal){
        System.out.println("entra a funcion documento");
        String name = principal.getName();
        postulantes p=null;
        List<idiomas> listaIdiomas=null;
        
        try{
            users u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());  
            listaIdiomas=idiomasService.findAll(u.getNif());
            System.out.println("entra a funcion documento");
             
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", p);
        mav.addObject("listaIdiomas", listaIdiomas);
        mav.addObject("mensaje", mav.getModelMap().get("mensaje"));
        mav.setViewName("IdiomasP");        
        return mav;
    }
   
    
    @RequestMapping(value = "addIdioma.htm",method=RequestMethod.GET)
    public String addIdioma_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        List<tipoidioma> listaTipoIdioma=null;
        postulantes p=null;
        users u=null;
        try{
            u=usuarioService.getByLogin(name);
        listaTipoIdioma=tipoIdiomaService.findAll();
        p=postulanteService.ByNif(u.getNif());
        //u=usuarioService.getByLogin(principal.getName());
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaTipoIdioma",listaTipoIdioma);
        map.addAttribute("idioma",new idiomas());
        map.addAttribute("nif",u.getNif());
        map.addAttribute("postulante",p);
        return "addIdioma";
    }
     @RequestMapping(value = "addIdioma.htm",method=RequestMethod.POST)
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
        return "redirect:IdiomasP.htm";
        
        
    }
    
    @RequestMapping("updateIdioma.htm")
    public String updateIdioma_get(@RequestParam(value = "id") int id, ModelMap map,Principal principal){
        List<tipoidioma> listaTipoIdioma=null;
        idiomas idioma=null;
        String name=principal.getName();
        users u=null;
        postulantes p=null;
        try{
        u=usuarioService.getByLogin(name);
        p=postulanteService.ByNif(u.getNif());
        listaTipoIdioma=tipoIdiomaService.findAll();
        idioma=idiomasService.porId(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("listaTipoIdioma",listaTipoIdioma);
        map.addAttribute("idioma",idioma);
        map.addAttribute("postulante",p);
       
        return "updateIdioma";
    }
    
    @RequestMapping(value = "updateIdioma.htm",method=RequestMethod.POST)
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
        return "redirect:IdiomasP.htm";       
    }
    
    @RequestMapping(value = "deleteIdioma.htm",method=RequestMethod.GET)
    public String eliminarIdioma(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            rpta=idiomasService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:IdiomasP.htm";
    }
    
    
    
    
    @RequestMapping("ConocimientosP.htm")
    public ModelAndView ConocimientosList(ModelAndView mav,Principal principal){
        System.out.println("entra a funcion documento");
        String name = principal.getName();
        
        List<conocimientos> listaConocimientos=null;
        postulantes p=null;
        try{
            users u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
            listaConocimientos=conocimientosService.findAll(u.getNif());
            System.out.println("entra a funcion documento");
             
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", p);
        mav.addObject("listaConocimientos", listaConocimientos);
        mav.addObject("mensaje", mav.getModelMap().get("mensaje"));
        mav.setViewName("ConocimientosP");        
        return mav;
    }
   
    
    @RequestMapping(value = "addConocimiento.htm",method=RequestMethod.GET)
    public String addConocimiento_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        postulantes p=null;
        users u=null;
                try{
                    
                    u=usuarioService.getByLogin(principal.getName());
                    p=postulanteService.ByNif(u.getNif());
                }catch(Exception e){
                
                }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("conocimiento",new conocimientos());
        map.addAttribute("postulante",p);
        map.addAttribute("nif",u.getNif());
        return "addConocimiento";
    }
     @RequestMapping(value = "addConocimiento.htm",method=RequestMethod.POST)
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
        return "redirect:ConocimientosP.htm";
        
        
    }
    
    @RequestMapping("updateConocimiento.htm")
    public String updateConocimiento_get(@RequestParam(value = "id") int id, ModelMap map,Principal principal){
        String name=principal.getName();
        postulantes p=null;
        users u=null;
        conocimientos conocimiento=null;
        try{
            u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
                conocimiento=conocimientosService.porId(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("conocimiento",conocimiento);
        map.addAttribute("postulante",p);
        return "updateConocimiento";
    }
    
    @RequestMapping(value = "updateConocimiento.htm",method=RequestMethod.POST)
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
        return "redirect:ConocimientosP.htm";       
    }
    
    @RequestMapping(value = "deleteConocimiento.htm",method=RequestMethod.GET)
    public String eliminarConocimiento(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=conocimientosService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ConocimientosP.htm";
    }
    
    
    
    
    @RequestMapping("ExperienciaLaboralesP.htm")
    public ModelAndView ExperienciaLaboralesPList(ModelAndView mav,Principal principal){
        System.out.println("entra a funcion documento");
        String name = principal.getName();
        //users u=null;
        postulantes p=null;
        List<experiencia_laboral> listaExperienciaLaborales=null;
        
        try{
            users u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
            listaExperienciaLaborales=experienciaLaboralesService.findAll(u.getNif());
            System.out.println("entra a funcion documento");
             
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", p);
        mav.addObject("listaExperienciaLaborales", listaExperienciaLaborales);
        mav.setViewName("ExperienciaLaboralesP");        
        return mav;
    }
   
    
    @RequestMapping(value = "addExperienciaLaboral.htm",method=RequestMethod.GET)
    public String addExperienciaLaboral_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        users u=null;
        postulantes p=null;
                try{
                    u=usuarioService.getByLogin(principal.getName());
                    p=postulanteService.ByNif(u.getNif());
                }catch(Exception e){
                
                }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",new experiencia_laboral());
        map.addAttribute("nif",u.getNif());
         map.addAttribute("postulante",p);
        return "addExperienciaLaboral";
    }
     @RequestMapping(value = "addExperienciaLaboral.htm",method=RequestMethod.POST)
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
        return "redirect:ExperienciaLaboralesP.htm";
        
        
    }
    
    @RequestMapping("updateExperienciaLaboral.htm")
    public String updateExperienciaLaboral_get(@RequestParam(value = "id") int id, ModelMap map,Principal principal){
        String name=principal.getName();
        users u=null;
        postulantes p=null;
        experiencia_laboral experienciaLaboral=null;
        try{
            u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
                experienciaLaboral=experienciaLaboralesService.porNif(id);
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("experienciaLaboral",experienciaLaboral);
       map.addAttribute("postulante",p);
        return "updateExperienciaLaboral";
    }
    
    @RequestMapping(value = "updateExperienciaLaboral.htm",method=RequestMethod.POST)
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
        return "redirect:ExperienciaLaboralesP.htm";       
    }
    
    @RequestMapping(value = "deleteExperienciaLaboral.htm",method=RequestMethod.GET)
    public String eliminarExperienciaLaboral(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
             if(id!=0){
                rpta=experienciaLaboralesService.Delete(id);
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ExperienciaLaboralesP.htm";
    }
    
    @RequestMapping(value = "FuturoEmpleoP.htm",method=RequestMethod.GET)
    public String FuturoEmpleo_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        futuro_empleo futuroEmpleo=null;
        users u=null;
        int id=0;
        postulantes p=null;
        try{
            
            u=usuarioService.getByLogin(name);
            p=postulanteService.ByNif(u.getNif());
            //futuroEmpleo.setPostulante_doc_identidad(u.getNif());
            if(futuroEmpleoService.existeFEP(u.getNif())==true){
                futuroEmpleo=futuroEmpleoService.porNif(u.getNif());
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
        map.addAttribute("postulante",p);
        map.addAttribute("nif",u.getNif());
        map.addAttribute("id",id);
        return "FuturoEmpleoP";
    }
     @RequestMapping(value = "FuturoEmpleoP.htm",method=RequestMethod.POST)
    public String FuturoEmpleo_post(@ModelAttribute("futuroEmpleo")futuro_empleo futuroEmpleo,BindingResult result,Principal principal,ModelMap map) {
        String mensaje2="";
        String name = principal.getName();
        users u=null;
        postulantes p=null;
        String mensaje="";
        String ruta="redirect:FuturoEmpleoP.htm";
       // if(!result.hasErrors()){
            try {
                if(futuroEmpleo.getBuscas_trabajo()!=null){
                    if(futuroEmpleoService.existeFEP(futuroEmpleo.getPostulante_doc_identidad())==true){
                       
                        mensaje=futuroEmpleoService.Update(futuroEmpleo);
                    }else{
                        
                        mensaje=futuroEmpleoService.Insert(futuroEmpleo);
                    }
                }  
                u=usuarioService.getByLogin(name);
                p=postulanteService.ByNif(u.getNif());
                if(p.getEstadoinf()==false){
                    FinishInformacion_get(p);
                    mensaje2="success";
                    ruta="redirect:Informacion.htm";
                }
               
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        //}else{return "error";}
            map.addAttribute("msg",mensaje2);
        return ruta;
        
        
    }
    
  
    
   @RequestMapping(value = "fotoPostulante.htm",method=RequestMethod.GET)
    public String fotoEmpleado_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        postulantes po=new postulantes();
        
        try{
            
            users u=usuarioService.getByLogin(name);
            
            po=postulanteService.ByNif(u.getNif());
            //po.setContrasenna("");
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("postulante",po);
        map.addAttribute("mensaje","mensaje");
        
        return "fotoPostulante";
    }
    @RequestMapping(value = "fotoPostulante.htm",method=RequestMethod.POST)
    public String fotoEmpleado_post(@ModelAttribute("postulante")postulantes postulante,BindingResult result,HttpServletRequest request,Principal principal) {
        String mensaje="";
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosPerfil";
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(1024);

        ServletFileUpload upload=new ServletFileUpload(factory);
        String name = principal.getName();
            postulantes po=new postulantes();

        try{
            List<FileItem> partes=upload.parseRequest(request);
            for(FileItem item : partes)
            {
                System.out.println("NOMBRE FOTO: "+item.getName());
                File file=new File(ubicacionArchivo,item.getName());
                item.write(file);
                users u=usuarioService.getByLogin(name);
                po=postulanteService.ByNif(u.getNif());
                po.setNombrefotografia(item.getName());
                postulanteService.UpdateImagen(po);
            }
            System.out.println("Archi subido correctamente");
        }
        catch(Exception ex)
        {
            System.out.println("Error al subir archivo"+ex.getMessage());
        }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return "redirect:ActualizarfotoPostulante.htm";
        
    }
    
    @RequestMapping(value = "ActualizarfotoPostulante.htm",method=RequestMethod.GET)
    public String updateTamanoFoto_get(ModelMap map,Principal principal) {
        String name = principal.getName();
        postulantes po=new postulantes();
        
        try{
            
            users u=usuarioService.getByLogin(name);
            
            po=postulanteService.ByNif(u.getNif());
            //po.setContrasenna("");
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("postulante",po);
        map.addAttribute("mensaje","mensaje");
        
        return "ActualizarfotoPostulante";
    }
    @RequestMapping(value = "ActualizarfotoPostulante.htm",method=RequestMethod.POST)
    public String updateTamanoFoto_post(@ModelAttribute("postulante")postulantes postulante,BindingResult result,Principal principal) {
        String mensaje="";
        String ruta="redirect:ActualizarfotoPostulante.htm";

            try{
                postulanteService.UpdateTamanoImagen(postulante);
                if(postulante.getEstadoinf()==false){
                    ruta="redirect:EstudiosP.htm";
                }
            }
            catch(Exception ex)
            {
                System.out.println("Error al subir archivo"+ex.getMessage());
            }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return ruta;
        
    }
    
    public void FinishInformacion_get(postulantes pos) {
        //String name=principal.getName();
        users u=null;
        postulantes newpos=null;
        List<experiencia_laboral> exp=null;
         mensajeP m=new mensajeP();
        try{
            
            //pos=postulanteService.ByNif(pos);
            exp=experienciaLaboralesService.findAll(pos.getDocuemnto_identidad());
            postulanteService.updateEstadoInf(pos);
            newpos=postulanteService.ByNif(pos.getDocuemnto_identidad());
            u=usuarioService.getById(newpos.getDocuemnto_identidad());
            if(newpos.getEstadoinf()==true){                
                m.mensaje(newpos,exp);
                m.mensajePostulanteInformacion(u);
            }
        }catch(Exception ex){
            
        }
        mensaje="Gracias por Completar su información, en breve recibirá un mail";
       
    }
}
