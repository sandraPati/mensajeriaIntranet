/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.objetivos;

import com.intranet.beans.Objetivos;
import com.intranet.beans.empleados;
import com.intranet.service.EmpleadoService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.objetivos.ObjetivosService;
import java.util.List;
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
public class SupControllerObjetivos {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ObjetivosService objetivosService;
    
     @RequestMapping(value = "Objetivos.htm",method=RequestMethod.GET)
    public String Objetivos_get(ModelMap map,@RequestParam(value = "nif") String nif) {
        List<empleados> ltaEmpleados=null;
        Objetivos obj=new Objetivos();
        empleados emp=new empleados();
        try{
            ltaEmpleados=empleadoService.findAll("");
            boolean o=objetivosService.existe(nif);
                if(o==true){
                    Objetivos ob=objetivosService.ByNif(nif);
                obj=ob;
            }else{
            obj.setNif_empleado(nif);}
            emp=empleadoService.ByNif(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("ltaEmpleados", ltaEmpleados);
         map.addAttribute("obj",obj);
         map.addAttribute("emp",emp);
        return "Objetivos";
    }
     @RequestMapping(value = "Objetivos.htm",method=RequestMethod.POST)
    public String Objetivos_post(@ModelAttribute("obj")Objetivos obj,BindingResult result,ModelMap map) {
        String mensaje="";
        //if(!result.hasErrors()){
            try {
                boolean o=objetivosService.existe(obj.getNif_empleado());
                if(o==true){
                    objetivosService.Update(obj);
                }else objetivosService.Insert(obj);
            } catch (Exception ex) {
                ex.printStackTrace();
                mensaje="";
            }
            
        //}else{return "error";}
        return "redirect:verEmpleados.htm";
        
        
    }
   
}
