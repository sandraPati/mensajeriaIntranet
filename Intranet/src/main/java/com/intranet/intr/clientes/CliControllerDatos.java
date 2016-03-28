/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.clientes;

import com.intranet.beans.clientes;
import com.intranet.beans.users;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.VentanaService;
import java.security.Principal;
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
@RequestMapping("/cli/*")
public class CliControllerDatos {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private EstanciasService estanciasService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    
    @RequestMapping("DatosCliente.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav,Principal principal){
       String name=principal.getName();
       users u=null;
       clientes empleado =new clientes();
        try{
            u=usuarioService.getByLogin(name);
            empleado=clientesService.ByNif(u.getNif());
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleado", empleado);
        mav.setViewName("DatosCliente");        
        return mav;
    }
    
    
    @RequestMapping(value = "CupdateDatosCliente.htm",method=RequestMethod.GET)
    public String updateDatosCliente_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        users u=null;
        clientes cliente=new clientes();
        try{
            u=usuarioService.getByLogin(name);
            cliente=clientesService.ByNif(u.getNif());
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente",cliente);
        map.addAttribute("mensaje","mensaje");
        
        return "CupdateDatosCliente";
    }
    
    @RequestMapping(value = "CupdateDatosCliente.htm",method=RequestMethod.POST)
    public String updateDatosCliente_post(@ModelAttribute("cliente")clientes cliente,BindingResult result) {
        String mensaje="";
        
        try{
            System.out.println("nif:"+cliente.getNif());
            
                            users u=new users();
                            u.setNif(cliente.getNif());
                            u.setEmail(cliente.getEmail());
                            usuarioService.updateEmail(u);
                        
            clientesService.Update(cliente);
        }catch(Exception e){
        
        }
         return "redirect:DatosCliente.htm";
        
    }
    
    
    @RequestMapping(value = "CsecurityDatosCliente.htm",method=RequestMethod.GET)
    public String securityDatosCliente_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        users u=new users();
        clientes c=null;
        try{
            u=usuarioService.getByLogin(name);
            c=clientesService.ByNif(u.getNif());
            
            if(usuarioService.validaExiste(u)==true){
                u=usuarioService.getById(u.getNif());
                u.setContrasenna("");
                u.setContrasenna2("");
            }
            u.setContrasenna("");
            u.setContrasenna2("");
        }catch(Exception e){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("usu",u);
        map.addAttribute("mensaje","mensaje");
        
        return "CsecurityDatosCliente";
    }
    
    @RequestMapping(value = "CsecurityDatosCliente.htm",method=RequestMethod.POST)
    public String securityDatosCliente_post(@ModelAttribute("usu")users u,BindingResult result) {
        String mensaje="";
        
        try{
            System.out.println("nif cliente:"+u.getNif());
            if(u.getNif()!=null && u.getContrasenna()!="" && u.getContrasenna2()!=""){
                System.out.println("Solo nif usurario y contra");
                    if(u.getContrasenna().equals(u.getContrasenna2())){
                        System.out.println("contrasenas iguales");
                        
                                usuarioService.update(u);
                            
                    }else{
			System.out.println("Las contraseñas no Coinciden");
                    }
                }else if(u.getNif()!=null){
                    if(usuarioService.validaExisteUCNif(u)==0){
                            mensaje=usuarioService.update(u);
                        }
                   
                   
                        
                }
                
        }catch(Exception e){
        
        }
         return "redirect:CsecurityDatosCliente.htm";
        
    }
   
}
