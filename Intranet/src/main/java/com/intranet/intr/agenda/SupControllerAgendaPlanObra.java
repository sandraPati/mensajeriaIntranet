/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;

import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.propuesta;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.agenda.TareaSupEmpService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.proyecto.ProyectoTrabajadoresService;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerAgendaPlanObra {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private TareaSupEmpService tareaSupEmpService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private ProyectoTrabajadoresService proyectoTrabajadoresService;
    
    clientes cli=new clientes();
    propuesta pro=new propuesta();
    
    @RequestMapping("verPlanObraAgendaEmpleados.htm")
    public ModelAndView verAgendaEmpleados(ModelAndView mav){
        System.out.println("entra a funcion documento");
        List<clientes> empleadoListbox=null;
        
        try{
            System.out.println("entra a funcion documento");
            empleadoListbox=clientesService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleadoListbox", empleadoListbox);
        mav.setViewName("verPlanObraAgendaEmpleados");        
        return mav;
    }
    
    @RequestMapping("PropuestasAgendaEmpleados.htm")
    public ModelAndView PropuestasAgendaEmpleados(ModelAndView mav,@RequestParam(value = "nif") String nif){
        System.out.println("entra a funcion documento");
        List<propuesta> empleadoListbox=null;
        
        try{
            cli=clientesService.ByNif(nif);
            System.out.println("entra a funcion documento");
            empleadoListbox=propuestasService.filtroCProy(nif); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleadoListbox", empleadoListbox);
        mav.addObject("cli", cli);
        mav.setViewName("PropuestasAgendaEmpleados");        
        return mav;
    }
    
    
    @RequestMapping("PlanObraTareasEmpleado.htm")
    public String PlanObraTareasEmpleado(@RequestParam(value = "id") int id,ModelMap map,Principal principal) {
        List eventos = new ArrayList();
        List<proyecto_trabajadores> tareas=null;
        try{
            pro=propuestasService.porId(id);
            tareas=proyectoTrabajadoresService.findAllPropuesta(pro.getId());
            for(proyecto_trabajadores t:tareas){
                    eventos.add(new EventosEntity(t.getId(),t.getDescripcion(),t.getFinicio(), t.getFfin(),"label-success"));
                }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tareas",eventos);
        map.addAttribute("prop",pro);
        map.addAttribute("cli",cli);
        map.addAttribute("tarea",new proyecto_trabajadores());
        return("PlanObraTareasEmpleado");
        
    }
    
    
    @RequestMapping(value="/ajaxUpdateTPO.json", method=RequestMethod.GET)
    public @ResponseBody proyecto_trabajadores loginDisponible(
                                        @RequestParam("id") int id) {
      proyecto_trabajadores data=new proyecto_trabajadores();
        
        try{
            data=proyectoTrabajadoresService.porId(id);
            System.out.println("p:"+data.getDescripcion());
        }catch(Exception ex){
            ex.printStackTrace();        
        }
      
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value = "/ajaxupdateTareaPO", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxupdateTarea(@ModelAttribute(value="tarea") proyecto_trabajadores tarea) {
        
        if(tarea.getEstado().equals("SI")){
                    tarea.setNota("");
                }
                if(tarea.getCond()==true){
                    
                        tarea.setCondicion(3);
                        proyectoTrabajadoresService.updateCondicion(tarea);
                    
                }else{
                    proyectoTrabajadoresService.UpdateEstadoNota(tarea);
                }
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/sup/PlanObraTareasEmpleado.htm?id="+pro.getId();
    }
    
    @RequestMapping(value = "/ajaxdeleteTareaPO", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxdeleteTarea(@ModelAttribute(value="tarea") proyecto_trabajadores tarea) {
        try {
                //c=tareaSupEmpService.porId(id);
                if(tarea.getId()!=0 ){
                      proyectoTrabajadoresService.Delete(tarea.getId());
                }
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/sup/PlanObraTareasEmpleado.htm?id="+pro.getId();
    }
    
   
    
    
}
