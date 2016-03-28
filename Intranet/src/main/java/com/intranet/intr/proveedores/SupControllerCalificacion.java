/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proveedores;

import com.intranet.beans.clasificaciones;
import com.intranet.beans.proveedores;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.proveedores.ClasificacionService;
import com.intranet.service.proveedores.ProveedoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerCalificacion {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ClasificacionService clasificacionService;
    @Autowired
    private ProveedoresService proveedoresService;
    
    
    
    @RequestMapping("Calificacion.htm")
    public ModelAndView Calificacion(ModelAndView mav){
        List<proveedores> listaProveedores=null;
        
        try{
            listaProveedores=clasificacionService.lista(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaProveedores", listaProveedores);
        mav.setViewName("Calificacion");        
        return mav;
    }
    
    @RequestMapping("verCalificacion.htm")
    public String verCalificacion(@RequestParam(value = "id") int id,ModelMap map) {
        List<clasificaciones> listaCalificaciones=null;
        proveedores prov=new proveedores();
        try{
            prov=proveedoresService.porId(id);
            listaCalificaciones=clasificacionService.AllcalificacionProveedor(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("listaCalificaciones",listaCalificaciones);
        map.addAttribute("prov",prov);
        return("verCalificacion");
        
    }
}
