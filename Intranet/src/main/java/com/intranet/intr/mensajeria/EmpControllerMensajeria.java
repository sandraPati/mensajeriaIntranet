/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.mensajeria;

import com.intranet.beans.empleados;
import com.intranet.beans.mensajep;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.mensajeria.MensajeriaService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp/*")
public class EmpControllerMensajeria {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private MensajeriaService mensajeriaService;
    
    @RequestMapping("EMensajeria.htm")
    public String EMensajeria_GET(ModelMap mav,Principal principal,@RequestParam(value = "nifU", required = false)String nifU){
        String name=principal.getName();
        List<empleados> lta=null;
        List<mensajep> data=null;
        mensajep chatadd=new mensajep();
        try{
            users u=usuarioService.getByLogin(name);    
                lta=mensajeriaService.ltaEmpleados(u.getNif());
            if(nifU!=null){
                
                data=mensajeriaService.mensajePrivadoUsu(u.getNif(),nifU);
                chatadd.setNifEmisor(u.getNif());
                chatadd.setNifReceptor(nifU);
            }
            
        }catch(Exception ex){}
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("empleados",lta);
        mav.addAttribute("data",data);
        mav.addAttribute("chatadd",chatadd);
        //mav.setViewName("Mensajeria");        
        return "EMensajeria";
    }
    
    @RequestMapping(value = "EMensajeria.htm",method=RequestMethod.POST)
    public String EMensajeria_post(@ModelAttribute("chatadd")mensajep chatadd,BindingResult result,ModelMap mav) {
        String mensaje="";
        
        try{
            mensajeriaService.enviarMensaje(chatadd);
        }catch(Exception e){
        
        }
        mav.addAttribute("nifU",chatadd.getNifReceptor());
         return "redirect:EMensajeria.htm";
        
    }
    
    @RequestMapping(value="/EajaxMensajeria.json", method=RequestMethod.GET)
    public @ResponseBody List<mensajep> loginDisponible(Principal principal,
                                        @RequestParam("nifU") String nifU) {
         System.out.println("M:"+nifU);
        String name=principal.getName();
        users u=usuarioService.getByLogin(name);    
      List<mensajep> dataMen=mensajeriaService.mensajePrivadoUsu(u.getNif(),nifU);
      
      String r="";
      
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return dataMen;
    }
    
    @RequestMapping(value = "/EajaxBuscar.json", method = RequestMethod.GET)
    public @ResponseBody
    List<empleados> getTags(@RequestParam String nombre,Principal principal) {
        System.out.println("buscar");
        String name=principal.getName();
        users u=usuarioService.getByLogin(name);
            return simulateSearchResult(nombre,u.getNif());

    }

    private List<empleados> simulateSearchResult(String nombre,String nif) {

            List<empleados> result = new ArrayList<empleados>();
            List<empleados> lta=mensajeriaService.ltaEmpleados(nif);
            // iterate a list and filter by tagName
            
            for (empleados tag : lta) {
                    if (tag.getNombre().contains(nombre)) {
                            result.add(tag);
                            System.out.println("ncontratdo");
                    }
            }
            
            return result;
    }
}
