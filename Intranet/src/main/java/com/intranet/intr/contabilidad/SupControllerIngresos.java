/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.contabilidad;

import com.intranet.beans.clientes;
import com.intranet.beans.formapago;
import com.intranet.beans.ingresos;
import com.intranet.beans.tipoingreso;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.FormaPagoService;
import com.intranet.service.contabilidad.IngresosService;
import com.intranet.service.contabilidad.TipoIngresoService;
import com.intranet.service.propuesta.ClientesService;
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
public class SupControllerIngresos {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private IngresosService ingresosService;
    @Autowired
    private FormaPagoService formaPagoService;
    @Autowired
    private TipoIngresoService tipoIngresoService;
    @Autowired
    private ClientesService clientesService;
    
    
    @RequestMapping("Ingresos.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav){
       
        List<ingresos> ingresosListbox=null;
        try{
            
            ingresosListbox=ingresosService.findAll();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("ingresosListbox", ingresosListbox);
        mav.setViewName("Ingresos");        
        return mav;
    }
    
    @RequestMapping(value = "addIngreso.htm",method=RequestMethod.GET)
    public String addIngreso_get(ModelMap map) {
        ingresos ingreso=new ingresos();
        List<formapago> ltaFormapago=null;
        List<tipoingreso> ltaTipoingreso=null;
        List<clientes> ltaCliente=null;
        try{
            ltaFormapago=formaPagoService.findAll();
            ltaTipoingreso=tipoIngresoService.findAll();
            ltaCliente=clientesService.findAll("");
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapago",ltaFormapago);
        map.addAttribute("ltaTipoingreso",ltaTipoingreso);
        map.addAttribute("ltaCliente",ltaCliente);
        map.addAttribute("ingreso",ingreso);
        map.addAttribute("mensaje","mensaje");
        
        return "addIngreso";
    }
    
    @RequestMapping(value = "addIngreso.htm",method=RequestMethod.POST)
    public String addIngreso_post(@ModelAttribute("ingreso")ingresos ingreso,BindingResult result) {
        String mensaje="";
        
        try{
            ingresosService.Insert(ingreso);
           
        }catch(Exception e){
        
        }
         return "redirect:Ingresos.htm";
        
    }
    
    @RequestMapping(value = "updateIngreso.htm",method=RequestMethod.GET)
    public String updateIngreso_get(ModelMap map,@RequestParam(value = "id") int id) {
        ingresos ingreso=new ingresos();
        List<formapago> ltaFormapago=null;
        List<tipoingreso> ltaTipoingreso=null;
        List<clientes> ltaCliente=null;
        try{
            ingreso=ingresosService.porID(id);
            ltaFormapago=formaPagoService.findAll();
            ltaTipoingreso=tipoIngresoService.findAll();
            ltaCliente=clientesService.findAll("");
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapago",ltaFormapago);
        map.addAttribute("ltaTipoingreso",ltaTipoingreso);
        map.addAttribute("ltaCliente",ltaCliente);
        map.addAttribute("ingreso",ingreso);
        map.addAttribute("mensaje","mensaje");
        
        return "updateIngreso";
    }
    
    @RequestMapping(value = "updateIngreso.htm",method=RequestMethod.POST)
    public String updateDatosCliente_post(@ModelAttribute("ingreso")ingresos ingreso,BindingResult result) {
        String mensaje="";
        
        try{
            ingresosService.Update(ingreso);
        }catch(Exception e){
        
        }
         return "redirect:Ingresos.htm";
        
    }
    
    @RequestMapping(value = "deleteIngreso.htm",method=RequestMethod.GET)
    public String deleteIngreso(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            ingresosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Ingresos.htm";
    }
     @RequestMapping(value = "IngresoPagada.htm",method=RequestMethod.GET)
    public String FacturaPagada(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=ingresosService.EstadoDePagoT(id);
            if(r==true){
                rpta="success";
            }
            System.out.println("FACTURAPAGADA"+rpta);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Ingresos.htm";  
    }
    @RequestMapping(value = "IngresoPendiente.htm",method=RequestMethod.GET)
    public String FacturaPendiente(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=ingresosService.EstadoDePagoF(id);
            if(r==true){
                rpta="success";
            }

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Ingresos.htm";   
    }
}
