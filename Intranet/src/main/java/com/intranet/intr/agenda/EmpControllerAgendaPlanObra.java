/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;

import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.empleados;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.agenda.TareaSupEmpService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.proyecto.ProyectoTrabajadoresService;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp/*")
public class EmpControllerAgendaPlanObra {
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
    
    @RequestMapping("EAgendaPlanObra.htm")
    public ModelAndView verAgendaEmpleados(ModelAndView mav,Principal principal){
        List eventos = new ArrayList();
        String name=principal.getName();
        System.out.println("entra a funcion documento");
        users u=null;
        List<proyecto_trabajadores> tareasListbox=null;
        proyecto_trabajadores c=new proyecto_trabajadores();
        try{
            u=usuarioService.getByLogin(name);
            empleados emp=empleadoService.ByNif(u.getNif());
            tareasListbox=proyectoTrabajadoresService.findAllPropuestaE(emp);
            for(proyecto_trabajadores t:tareasListbox){
                    eventos.add(new EventosEntity(t.getId(),t.getDescripcion(),t.getFinicio(), t.getFfin(),"label-success"));
                }
            //empleadoListbox=clientesService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("tareas", eventos);
        mav.addObject("tarea",c);
        mav.setViewName("EAgendaPlanObra");        
        return mav;
    }
    
    @RequestMapping(value="/EajaxUpdateTPO.json", method=RequestMethod.GET)
    public @ResponseBody proyecto_trabajadores loginDisponible(
                                        @RequestParam("id") int id) {
      proyecto_trabajadores data=new proyecto_trabajadores();
        
        try{
            data=proyectoTrabajadoresService.porId(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    @RequestMapping(value = "/EajaxupdateTareaPO", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxupdateTarea(@ModelAttribute(value="tarea") proyecto_trabajadores tarea) {
        
        try{
                
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
            }catch(Exception e){

             }
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/emp/EAgendaPlanObra.htm";
    }
    
    
     @RequestMapping(value = "EupdateAgendaPlanObra.htm",method=RequestMethod.GET)
    public String updateContrato_get(ModelMap map,@RequestParam(value = "id") int id) {
        proyecto_trabajadores c=new proyecto_trabajadores();
        
        try{
            c=proyectoTrabajadoresService.porId(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tarea",c);
        return "EupdateAgendaPlanObra";
    }
    
    @RequestMapping(value = "EupdateAgendaPlanObra.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("tarea")proyecto_trabajadores tarea,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try{
                
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
            }catch(Exception e){

             }
	}else{return "error";} 
         
            return "redirect:EAgendaPlanObra.htm";
        
    }
   
}
