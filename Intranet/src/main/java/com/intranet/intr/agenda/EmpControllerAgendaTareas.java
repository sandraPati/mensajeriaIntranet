/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;

import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.agenda.TareaSupEmpService;
import com.intranet.service.propuesta.ClientesService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
public class EmpControllerAgendaTareas {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private TareaSupEmpService tareaSupEmpService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClientesService clientesService;
    
    
    @RequestMapping("EverAgenda.htm")
    public String EverAgenda(ModelMap map,Principal principal) {
        List eventos = new ArrayList();
        String name=principal.getName();
        empleados empleado=null;
        users u=null;
        List<TareaSupEmp> tareas=null;
        List<empleados> sup=null;
        List<clientes> clientesLista=null;
        TareaSupEmp c=new TareaSupEmp();
        try{
            u=usuarioService.getByLogin(name);
            tareas=tareaSupEmpService.getTareasE(u.getNif());
            for(TareaSupEmp t:tareas){
                    eventos.add(new EventosEntity(t.getId(),t.getDescripcion(),t.getFinicio(), t.getFfin(),"label-success"));
                }
            
            c.setNifempleado(u.getNif());
            clientesLista=clientesService.findAll("");
            sup=empleadoService.findAll("");
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tareas",eventos);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("supervisorLista",sup);
        map.addAttribute("tarea",c);
        return("EverAgenda");
        
    }
    
    @RequestMapping(value = "/EajaxaddTarea", method = RequestMethod.POST)
    public @ResponseBody
    String getTimeS(@ModelAttribute(value="tarea") TareaSupEmp tarea) {
        try{
        if(tarea.getCliasignado().equals("NO")){
               tarea.setNifcliente("");
           }
            tareaSupEmpService.insertTarea(tarea);
        }catch(Exception ex){}    
        return "/Intranet/emp/EverAgenda.htm";
    }
    @RequestMapping(value = "/EajaxupdateTarea", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxupdateTarea(@ModelAttribute(value="tarea") TareaSupEmp tarea) {
        
        try{
                System.out.println("OLA SANDRA");
                System.out.println("cliente"+tarea.getNifcliente());
                if(tarea.getCliasignado().equals("NO")){
                    tarea.setNifcliente("");
                }
                System.out.println("OLA SANDRA");
                if(tarea.getEstado().equals("SI")){
                    tarea.setNota("");
                }
                System.out.println("OLA SANDRA");
                 System.out.println("valida");
                if(tarea.getCond()==true){
                    if(tarea.getNifcliente()!=null ){
                        tarea.setCondicion(3);
                         System.out.println("cond3");
                        tareaSupEmpService.updateCondicion(tarea);
                    }else{
                         System.out.println("cond 2");
                        tarea.setCondicion(2);
                        tareaSupEmpService.updateCondicion(tarea);
                    }
                }else{
                    System.out.println("update");
                    tareaSupEmpService.updateTarea(tarea);
                }
                //tareaSupEmpService.insertTarea(tarea);
            }catch(Exception e){

             }
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/emp/EverAgenda.htm";
    }
    
     @RequestMapping(value="/EajaxUpdateT.json", method=RequestMethod.GET)
    public @ResponseBody TareaSupEmp loginDisponible(
                                        @RequestParam("id") int id,Principal principal) {
      String name=principal.getName();
      users u=null;
      TareaSupEmp data=null;
            try{
                data=tareaSupEmpService.porId(id);
                u=usuarioService.getByLogin(name);
                data.setNifempleado(u.getNif());
                System.out.println(""+data.getNifsupervisor());
            }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
 
    
    @RequestMapping(value = "/EajaxdeleteTarea", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxdeleteTarea(@ModelAttribute(value="tarea") TareaSupEmp tarea) {
        TareaSupEmp c=new TareaSupEmp();
        //System.out.println("ajaxtext");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("ajax UPDATE tarea:" +tarea.getId());
        try{
        c=tareaSupEmpService.porId(tarea.getId());
                if(tarea.getId()!=0 ){
                      tareaSupEmpService.deleteTarea(c);
                }
        }catch(Exception ex){}
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/emp/EverAgenda.htm";
    }
    
    @RequestMapping(value = "EaddTarea.htm",method=RequestMethod.GET)
    public String addContrato_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        List<empleados> sup=null;
        List<clientes> clientesLista=null;
        TareaSupEmp c=new TareaSupEmp();
        users u=null;
        try{
            u=usuarioService.getByLogin(name);
            c.setNifempleado(u.getNif());
            clientesLista=clientesService.findAll("");
            sup=empleadoService.findAll("");
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("supervisorLista",sup);
        map.addAttribute("tarea",c);
        return "EaddTarea";
    }
    
    @RequestMapping(value = "EaddTarea.htm",method=RequestMethod.POST)
    public String addContrato_post(@ModelAttribute("tarea")TareaSupEmp tarea,BindingResult result) {
        String mensaje="";
        try{
           //tarea.setNifempleado(emp.getNif());
           if(tarea.getCliasignado().equals("NO")){
               tarea.setNifcliente("");
           }
            tareaSupEmpService.insertTarea(tarea);
              
	 
        }catch(Exception e){
    
         }
       
         return "redirect:EverAgenda.htm";
        
        
        
    }
    
    @RequestMapping(value = "EupdateTarea.htm",method=RequestMethod.GET)
    public String updateContrato_get(ModelMap map,@RequestParam(value = "id") int id,Principal principal) {
        String name=principal.getName();
        List<clientes> clientesLista=null;
        TareaSupEmp c=new TareaSupEmp();
        List<empleados> sup=null;
        users u=null;
        try{
            sup=empleadoService.findAll("");
            clientesLista=clientesService.findAll("");
            c=tareaSupEmpService.porId(id);
            u=usuarioService.getByLogin(name);
            c.setNifempleado(u.getNif());
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("supervisorLista",sup);
        map.addAttribute("tarea",c);
        return "EupdateTarea";
    }
    
    @RequestMapping(value = "EupdateTarea.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("tarea")TareaSupEmp tarea,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try{
                System.out.println("OLA SANDRA");
                System.out.println("cliente"+tarea.getNifcliente());
                if(tarea.getCliasignado().equals("NO")){
                    tarea.setNifcliente("");
                }
                System.out.println("OLA SANDRA");
                if(tarea.getEstado().equals("SI")){
                    tarea.setNota("");
                }
                System.out.println("OLA SANDRA");
                 System.out.println("valida");
                if(tarea.getCond()==true){
                    if(tarea.getNifcliente()!=null ){
                        tarea.setCondicion(3);
                         System.out.println("cond3");
                        tareaSupEmpService.updateCondicion(tarea);
                    }else{
                         System.out.println("cond 2");
                        tarea.setCondicion(2);
                        tareaSupEmpService.updateCondicion(tarea);
                    }
                }else{
                    System.out.println("update");
                    tareaSupEmpService.updateTarea(tarea);
                }
                //tareaSupEmpService.insertTarea(tarea);
            }catch(Exception e){

             }
	}else{return "error";} 
         
            return "redirect:EverAgenda.htm";
        
    }
    @RequestMapping(value="EdeleteTarea.htm",method=RequestMethod.GET)
    public String deleteTareaEmpleado_post(@RequestParam(value = "id") int id,ModelMap map) {
        
        TareaSupEmp c=new TareaSupEmp();
            try {
                c=tareaSupEmpService.porId(id);
                if(id!=0 ){
                      tareaSupEmpService.deleteTarea(c);
                }
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	 
         return "redirect:EverAgenda.htm";
        
        
    }
    
}
