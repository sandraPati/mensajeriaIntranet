/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proveedores;

import com.intranet.beans.tipo_actividades;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.proveedores.TipoActividadService;
import java.util.List;
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
public class EmpControllerTipoActividad {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private TipoActividadService tipoActividadService;
    tipo_actividades tipoAct=new tipo_actividades();
    
    
    @RequestMapping("EPTipoActividad.htm")
    public ModelAndView TipoActividades(ModelAndView mav){
        System.out.println("entra a funcion documento");
        List<tipo_actividades> listatipoactividad=null;
        
        try{
            System.out.println("entra a funcion documento");
            listatipoactividad=tipoActividadService.all(); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listatipoactividad", listatipoactividad);
        mav.setViewName("EPTipoActividad");        
        return mav;
    }
    
    
     @RequestMapping(value = "EPaddTipoActividad.htm",method=RequestMethod.GET)
    public String addTipoActividad_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tipoActividad",new tipo_actividades());
        map.addAttribute("mensaje","mensaje");
        
        return "EPaddTipoActividad";
    }
    
    @RequestMapping(value = "EPaddTipoActividad.htm",method=RequestMethod.POST)
    public String addTipoActividad_post(@ModelAttribute("tipoActividad")tipo_actividades tipoActividad,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=tipoActividadService.existe(tipoActividad.getNombre());
            if(result1==false){
                tipoActividadService.Insert(tipoActividad);
            }
            
        }catch(Exception e){
        }
	 
       
       
         return "redirect:EPTipoActividad.htm";
        
        
        
    }
    @RequestMapping(value = "EPupdateTipoActividad.htm",method=RequestMethod.GET)
    public String updateTipoActividad_get(ModelMap map,@RequestParam(value = "id") int id) {
        //capitulos cap=new capitulos();
        try{
            tipoAct=tipoActividadService.porId(id);
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tipoActividad",tipoAct);
        map.addAttribute("mensaje","mensaje");
        
        return "EPupdateTipoActividad";
    }
    
    @RequestMapping(value = "EPupdateTipoActividad.htm",method=RequestMethod.POST)
    public String updateTipoActividad_post(@ModelAttribute("tipoActividad")tipo_actividades tipoActividad,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=tipoActividadService.existeU(tipoActividad);
            if(result1==false){
                tipoActividadService.Update(tipoActividad);
            }
            
        }catch(Exception e){
        }
         return "redirect:EPTipoActividad.htm";
    }
    
    
    @RequestMapping(value="EPdeleteTipoActividad.htm",method=RequestMethod.GET)
    public String deleteTipoActividad_post(@RequestParam(value = "id") int id,ModelMap map) {
        
            try {
                tipoActividadService.Delete(id);
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:EPTipoActividad.htm";
        
        
    }
    
}
