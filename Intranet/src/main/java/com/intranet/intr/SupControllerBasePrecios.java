/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.capitulos;
import com.intranet.beans.subcapitulos;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.CapitulosService;
import com.intranet.service.propuesta.SubCapitulosService;
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
@RequestMapping("/sup/*")
public class SupControllerBasePrecios {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private CapitulosService capitulosService;
    @Autowired
    private SubCapitulosService subCapitulosService;        
            
    capitulos cap=new capitulos();
    
    @RequestMapping("Capitulos.htm")
    public ModelAndView Capitulos(ModelAndView mav){
        System.out.println("entra a funcion documento");
        List<capitulos> capitulosListbox=null;
        
        try{
            System.out.println("entra a funcion documento");
            capitulosListbox=capitulosService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("capitulosListbox", capitulosListbox);
        mav.addObject("mensaje", mav.getModelMap().get("mensaje"));
        mav.setViewName("Capitulos");        
        return mav;
    }
   
    @RequestMapping("SubCapitulos.htm")
    public String SubCapitulos(@RequestParam(value = "codC") int codC,ModelMap map) {
        List<subcapitulos> subcapitulosListbox=null;
        
        try{
            cap=capitulosService.porId(codC);
            subcapitulosListbox=subCapitulosService.filtro(cap.getId()); 
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("subcapitulosListbox", subcapitulosListbox);
        map.addAttribute("cap", cap);
        return("SubCapitulos");
        
    }
    
    @RequestMapping(value = "addCapitulo.htm",method=RequestMethod.GET)
    public String addCapitulo_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("capitulo",new capitulos());
        map.addAttribute("mensaje","mensaje");
        
        return "addCapitulo";
    }
    
    @RequestMapping(value = "addCapitulo.htm",method=RequestMethod.POST)
    public String addCapitulo_post(@ModelAttribute("capitulo")capitulos capitulo,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=capitulosService.existe(capitulo.getCod());
            if(result1==false){
                capitulosService.Insert(capitulo);
            }
            
        }catch(Exception e){
        }
	 
       
       
         return "redirect:Capitulos.htm";
        
        
        
    }
    @RequestMapping(value = "updateCapitulo.htm",method=RequestMethod.GET)
    public String updateCapitulo_get(ModelMap map,@RequestParam(value = "cod") int cod) {
        //capitulos cap=new capitulos();
        try{
            cap=capitulosService.porId(cod);
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("capitulo",cap);
        map.addAttribute("mensaje","mensaje");
        
        return "updateCapitulo";
    }
    
    @RequestMapping(value = "updateCapitulo.htm",method=RequestMethod.POST)
    public String updateCapitulo_post(@ModelAttribute("capitulo")capitulos capitulo,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=capitulosService.existeU(capitulo);
            if(result1==false){
                capitulosService.Update(capitulo);
            }
            
        }catch(Exception e){
        }
         return "redirect:Capitulos.htm";
    }
    
    
    @RequestMapping(value="deleteCapitulos.htm",method=RequestMethod.GET)
    public String deleteCapitulos_post(@RequestParam(value = "cod") int cod,ModelMap map) {
        
            try {
                capitulosService.Delete(cod);
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:Capitulos.htm";
        
        
    }
    
    @RequestMapping(value = "addSubCapitulo.htm",method=RequestMethod.GET)
    public String addSubCapitulo_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("subcapitulo",new subcapitulos());
        map.addAttribute("mensaje","mensaje");
        map.addAttribute("cap", cap);
        return "addSubCapitulo";
    }
    
    @RequestMapping(value = "addSubCapitulo.htm",method=RequestMethod.POST)
    public String addSubCapitulo_post(@ModelAttribute("subcapitulo")subcapitulos subcapitulo,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=subCapitulosService.existe(subcapitulo.getCod());
            if(result1==false){
                subCapitulosService.Insert(subcapitulo);
            }
            
        }catch(Exception e){
        }
	 
         return "redirect:SubCapitulos.htm?codC="+cap.getId();
        
        
        
    }
    @RequestMapping(value = "updateSubCapitulo.htm",method=RequestMethod.GET)
    public String updateSubCapitulo_get(ModelMap map,@RequestParam(value = "cod") int cod) {
        subcapitulos subcap=new subcapitulos();
        try{
            subcap=subCapitulosService.porId(cod);
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("subcapitulo",subcap);
        map.addAttribute("mensaje","mensaje");
        map.addAttribute("cap", cap);
        return "updateSubCapitulo";
    }
    
    @RequestMapping(value = "updateSubCapitulo.htm",method=RequestMethod.POST)
    public String updateSubCapitulo_post(@ModelAttribute("subcapitulo")subcapitulos subcapitulo,BindingResult result) {
        String mensaje="";
        try{
            boolean result1=subCapitulosService.existeU(subcapitulo);
            if(result1==false){
                subCapitulosService.Update(subcapitulo);
            }
            
        }catch(Exception e){
        }
         return "redirect:SubCapitulos.htm?codC="+cap.getId();
    }
    
    
    @RequestMapping(value="deleteSubCapitulos.htm",method=RequestMethod.GET)
    public String deleteSubCapitulos_post(@RequestParam(value = "cod") int cod,ModelMap map) {
          try {
                subCapitulosService.Delete(cod);
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:SubCapitulos.htm?codC="+cap.getId();
        
        
    }
}
