/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.conocimientos;
import com.intranet.beans.cvpostulante;
import com.intranet.beans.estudios;
import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.futuro_empleo;
import com.intranet.beans.idiomas;
import com.intranet.beans.postulantes;
import com.intranet.intr.mensajesEmail.mensajeP;
import com.intranet.service.PostulanteService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.postulante.ConocimientosService;
import com.intranet.service.postulante.EstudiosService;
import com.intranet.service.postulante.ExperienciaLaboralesService;
import com.intranet.service.postulante.FuturoEmpleoService;
import com.intranet.service.postulante.IdiomasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sup/*")
public class SupControllerGestionEmpleados {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private PostulanteService postulanteService;
     @Autowired
    private UsuarioService usuarioService;
            
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
          
    @RequestMapping("cvrecibidos.htm")
    public ModelAndView cvrecibidosList(ModelAndView mav){
        List<postulantes> listaPostulantes=null;
        cvpostulante cvp=null;
        try{
            listaPostulantes=postulanteService.findAll(); 
            cvp=postulanteService.cantidadesEstado();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaPostulantes", listaPostulantes);
        mav.addObject("cvp", cvp);
        mav.setViewName("cvrecibidos");        
        return mav;
    }
    @RequestMapping("cvEnProceso.htm")
    public ModelAndView cvEnProceso(ModelAndView mav){
        List<postulantes> listaPostulantes=null;
        cvpostulante cvp=null;
        try{
            listaPostulantes=postulanteService.enproceso(); 
            cvp=postulanteService.cantidadesEstado();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaPostulantes", listaPostulantes);
        mav.addObject("cvp", cvp);
        mav.setViewName("cvEnProceso");        
        return mav;
    }
    @RequestMapping("cvDescartado.htm")
    public ModelAndView cvDescartado(ModelAndView mav){
        List<postulantes> listaPostulantes=null;
        cvpostulante cvp=null;
        try{
            listaPostulantes=postulanteService.descartados(); 
            cvp=postulanteService.cantidadesEstado();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaPostulantes", listaPostulantes);
        mav.addObject("cvp", cvp);
        mav.setViewName("cvDescartado");        
        return mav;
    }
    
    @RequestMapping("verCv.htm")
    public ModelAndView verCvList(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        postulantes postulante=new postulantes();
        List<estudios> ltaestudios=null;
        List<idiomas> ltaidiomas=null;
        List<conocimientos> ltaconocimientos=null;
        List<experiencia_laboral> ltaexperienciaLaboral=null;
        futuro_empleo ltafuturoEmpleo=null;
        try{
            postulante=postulanteService.ByNif(nif);
            ltaestudios=estudiosService.findAll(nif);
            ltaidiomas=idiomasService.findAll(nif);
            ltaconocimientos=conocimientosService.findAll(nif);
            ltaexperienciaLaboral=experienciaLaboralesService.findAll(nif);
            ltafuturoEmpleo=futuroEmpleoService.porNif(nif);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", postulante);
        mav.addObject("ltaestudios", ltaestudios);
        mav.addObject("ltaidiomas", ltaidiomas);
        mav.addObject("ltaconocimientos", ltaconocimientos);
        mav.addObject("ltaexperienciaLaboral", ltaexperienciaLaboral);
        mav.addObject("ltafuturoEmpleo", ltafuturoEmpleo);
        mav.setViewName("verCv");        
        return mav;
    }
    
    @RequestMapping("verCvEnProceso.htm")
    public ModelAndView verCvEnProcesoList(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        postulantes postulante=new postulantes();
        List<estudios> ltaestudios=null;
        List<idiomas> ltaidiomas=null;
        List<conocimientos> ltaconocimientos=null;
        List<experiencia_laboral> ltaexperienciaLaboral=null;
        futuro_empleo ltafuturoEmpleo=null;
        try{
            postulante=postulanteService.ByNif(nif);
            ltaestudios=estudiosService.findAll(nif);
            ltaidiomas=idiomasService.findAll(nif);
            ltaconocimientos=conocimientosService.findAll(nif);
            ltaexperienciaLaboral=experienciaLaboralesService.findAll(nif);
            ltafuturoEmpleo=futuroEmpleoService.porNif(nif);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", postulante);
        mav.addObject("ltaestudios", ltaestudios);
        mav.addObject("ltaidiomas", ltaidiomas);
        mav.addObject("ltaconocimientos", ltaconocimientos);
        mav.addObject("ltaexperienciaLaboral", ltaexperienciaLaboral);
        mav.addObject("ltafuturoEmpleo", ltafuturoEmpleo);
        mav.setViewName("verCvEnProceso");        
        return mav;
    }
    
    @RequestMapping("verCvDescartado.htm")
    public ModelAndView verCvDescartadoList(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        postulantes postulante=new postulantes();
        List<estudios> ltaestudios=null;
        List<idiomas> ltaidiomas=null;
        List<conocimientos> ltaconocimientos=null;
        List<experiencia_laboral> ltaexperienciaLaboral=null;
        futuro_empleo ltafuturoEmpleo=null;
        try{
            postulante=postulanteService.ByNif(nif);
            ltaestudios=estudiosService.findAll(nif);
            ltaidiomas=idiomasService.findAll(nif);
            ltaconocimientos=conocimientosService.findAll(nif);
            ltaexperienciaLaboral=experienciaLaboralesService.findAll(nif);
            ltafuturoEmpleo=futuroEmpleoService.porNif(nif);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("postulante", postulante);
        mav.addObject("ltaestudios", ltaestudios);
        mav.addObject("ltaidiomas", ltaidiomas);
        mav.addObject("ltaconocimientos", ltaconocimientos);
        mav.addObject("ltaexperienciaLaboral", ltaexperienciaLaboral);
        mav.addObject("ltafuturoEmpleo", ltafuturoEmpleo);
        mav.setViewName("verCvDescartado");        
        return mav;
    }
    
    @RequestMapping("cvEnProcesoadd.htm")
    public String cvEnProcesoadd(ModelAndView mav,@RequestParam(value = "nif") String nif) {
        String rpta="";
        try{
             if(nif!=null && nif!="" ){
                 if(postulanteService.enProceso(nif)!=0){
                    mensajeP m=new mensajeP();
                    postulantes p=postulanteService.ByNif(nif);
                     m.mensajePostulanteEnProceso( p);
                 }
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:cvrecibidos.htm";
    }
    @RequestMapping("enprocesoFin.htm")
    public String enprocesoFin(ModelAndView mav,@RequestParam(value = "nif") String nif) {
        String rpta="";
        try{
             if(nif!=null && nif!="" ){
                 postulantes p=postulanteService.ByNif(nif);
                 if(postulanteService.volcaraEmpleado(p)!=0){
                     usuarioService.updateRol(nif, 3);
                     postulanteService.enProcesoFin(p);
                    mensajeP m=new mensajeP();
                    
                     m.mensajePostulanteEmpleado( p);
                 }
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:cvEnProceso.htm";
    }
    @RequestMapping(value = "cvDescartadoadd.htm",method=RequestMethod.GET)
    public String cvDescartadoadd(@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
             if(nif!=null && nif!="" ){
                 if(postulanteService.descartado(nif)!=0){
                    mensajeP m=new mensajeP();
                    postulantes p=postulanteService.ByNif(nif);
                     m.mensajePostulantedescartado( p);
                 }
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:cvrecibidos.htm";
    }
    @RequestMapping(value = "restaurar.htm",method=RequestMethod.GET)
    public String restaurar(@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
             if(nif!=null && nif!="" ){
                 postulantes p=postulanteService.ByNif(nif);
                 if(postulanteService.restaurar(p)!=0){
                    mensajeP m=new mensajeP();
                    
                     m.mensajePostulanteRestaurar( p);
                 }
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:cvDescartado.htm";
    }
    @RequestMapping(value = "cvDescartadoaddp.htm",method=RequestMethod.GET)
    public String cvDescartadoaddp(@RequestParam(value = "nif") String nif,ModelMap map) {
        String rpta="";
        try{
             if(nif!=null && nif!="" ){
                 if(postulanteService.descartado(nif)!=0){
                    mensajeP m=new mensajeP();
                    postulantes p=postulanteService.ByNif(nif);
                     m.mensajePostulantedescartado( p);
                 }
             }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:cvEnProceso.htm";
    }
}
