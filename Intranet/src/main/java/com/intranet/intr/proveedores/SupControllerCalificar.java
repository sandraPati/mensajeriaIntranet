/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proveedores;

import com.intranet.beans.clasificaciones;
import com.intranet.beans.empleados;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipo_actividades;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.proveedores.ClasificacionService;
import com.intranet.service.proveedores.ProveedoresService;
import com.intranet.service.proveedores.TipoActividadService;
import java.security.Principal;
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
public class SupControllerCalificar {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ClasificacionService clasificacionService;
    @Autowired
    private TipoActividadService tipoActividadService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ProveedoresService proveedoresService;
    
    
    @RequestMapping("Calificar.htm")
    public ModelAndView Calificar(ModelAndView mav){
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
        mav.setViewName("Calificar");        
        return mav;
    }
    
    @RequestMapping(value = "updateCalificar.htm",method=RequestMethod.GET)
    public String updateCapitulo_get(ModelMap map,@RequestParam(value = "id") int id,Principal principal) {
        String name=principal.getName();
        users u=null;
        empleados empl=new empleados();
        proveedores pro=new proveedores();
        clasificaciones clasificacion=new clasificaciones() ;
        
        try{
            u=usuarioService.getByLogin(name);
            empl=empleadoService.ByNif(u.getNif());
            pro=proveedoresService.porId(id);
            
            clasificacion=clasificacionService.calificacionProveedorEmpleado(id, u.getNif());
            
            //pro=clasificacion.getProveedor_numcuenta();
            if(clasificacion==null){
                //empl=empleadoService.ByNif(u.getNif());
                //pro=proveedoresService.porNumCuenta(num_cuenta);
                clasificacion.setEmpleado_nif(empl);
                clasificacion.setProveedor_numcuenta(pro);
            }
            
        }catch(Exception e){
        
        }
        System.out.println("empleado: "+empl.getNif());
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("calificar",clasificacion);
        map.addAttribute("empl",empl);
        map.addAttribute("pro",pro);
        map.addAttribute("mensaje","mensaje");
        
        return "updateCalificar";
    }
    
    @RequestMapping(value = "updateCalificar.htm",method=RequestMethod.POST)
    public String updateCapitulo_post(@ModelAttribute("calificar")clasificaciones clasificacion,BindingResult result) {
        String mensaje="";
        System.out.println("nif emp:"+clasificacion.getEmpleado_nif().getNif()+"id cal:"+clasificacion.getProveedor_numcuenta().getId());
        try{
           if(clasificacionService.existencia(clasificacion.getProveedor_numcuenta().getId(), clasificacion.getEmpleado_nif().getNif())){
               System.out.println("1");
               clasificacionService.update(clasificacion);
           }else{
               System.out.println("2");
               clasificacionService.insertar(clasificacion);
           }
            System.out.println("1"+clasificacion.getEmpleado_nif().getNif());
       
        }catch(Exception ex){}
       
         return "redirect:Gestion.htm";
        
        
        
    }
}
