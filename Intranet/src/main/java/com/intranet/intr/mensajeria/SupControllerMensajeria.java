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
import com.intranet.service.RolesService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.mensajeria.MensajeriaService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sup/*")
public class SupControllerMensajeria {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private MensajeriaService mensajeriaService;
    private List<String> arc=new ArrayList<String>();
    
    @RequestMapping("Mensajeria.htm")
    public String SeguimientoGPS(ModelMap mav,Principal principal,@RequestParam(value = "nifU", required = false)String nifU){
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
        return "Mensajeria";
    }
    
    @RequestMapping(value = "Mensajeria.htm",method=RequestMethod.POST)
    public String addCliente_post(@ModelAttribute("chatadd")mensajep chatadd,BindingResult result,ModelMap mav) {
        String mensaje="";
        
        try{
            mensajeriaService.enviarMensaje(chatadd);
        }catch(Exception e){
        
        }
        mav.addAttribute("nifU",chatadd.getNifReceptor());
         return "redirect:Mensajeria.htm";
        
    }
    
    @RequestMapping(value="/ajaxNum.json", method=RequestMethod.GET)
    public @ResponseBody int ajaxNum() {
        
       int data=0;
        try{
            data=mensajeriaService.cantidadEmp();
        }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value="/ajaxContactos.json", method=RequestMethod.GET)
    public @ResponseBody List<empleados> ajaxContactos(Principal principal) {
        String name=principal.getName();
        List<empleados> data=null;
        try{
            users u=usuarioService.getByLogin(name);
            data=mensajeriaService.ltaEmpleados(u.getNif());
        }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value="/ajaxMensajeP.json", method=RequestMethod.GET)
    public @ResponseBody List<mensajep> ajaxMensajeP(Principal principal,@RequestParam(value = "nifreceptor") String nifReceptor) {
        String name=principal.getName();
        List<mensajep> data=null;
        try{
            users u=usuarioService.getByLogin(name);
            data=mensajeriaService.mensajePrivadoUsu(u.getNif(),nifReceptor);
        }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value="/ajaxUsu.json", method=RequestMethod.GET)
    public @ResponseBody empleados ajaxUsu(Principal principal) {
        String name=principal.getName();
        empleados data=null;
        try{
            System.out.println("pp");
            users u=usuarioService.getByLogin(name);
            data=mensajeriaService.usuario(u.getNif());
            
            System.out.println("pp"+data.getNif());
        }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value="/ajaxaddMensaje.json", method=RequestMethod.POST)
    public @ResponseBody String ajaxaddMensaje(@RequestBody mensajep search,HttpServletRequest request,Principal principal) {
        String name=principal.getName();
        empleados data=null;
        String result="";
        boolean b=false;
        try{
            System.out.println("rec"+search.getNifReceptor());
            users u=usuarioService.getByLogin(name);
            System.out.println("rec"+search.getNifReceptor());
            mensajep m=new mensajep();
            m.setNifEmisor(u.getNif());
            m.setNifReceptor(search.getNifReceptor());
            System.out.println("rec3"+search.getNifReceptor());
            System.out.println("rec4"+m.getNifReceptor());
            m.setAsunto(search.getAsunto());
            if(mensajeriaService.enviarMensaje(m)==true)b=true;
            if(b==true) result="mensaje enviado";
        }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return result;
    }
    
    @RequestMapping(value="/ajaxMensajeria.json", method=RequestMethod.GET)
    public @ResponseBody List<mensajep> loginDisponible(Principal principal,
                                        @RequestParam("nifU") String nifU) {
       
        String name=principal.getName();
        users u=usuarioService.getByLogin(name);    
      List<mensajep> dataMen=mensajeriaService.mensajePrivadoUsu(u.getNif(),nifU);
      
      String r="";
      
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return dataMen;
    }
    
    
    @RequestMapping(value = "/ajaxBuscar.json", method = RequestMethod.GET)
    public @ResponseBody
    List<empleados> getTags(@RequestParam String nombre,Principal principal) {
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
