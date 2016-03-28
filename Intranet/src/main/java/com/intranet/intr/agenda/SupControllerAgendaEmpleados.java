/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;

import com.intranet.beans.Roles;
import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.users;
import com.intranet.intr.inbox.Tag;
import com.intranet.intr.inbox.correoNoLeidos;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.agenda.TareaSupEmpService;
import com.intranet.service.propuesta.ClientesService;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerAgendaEmpleados {
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
            
    empleados emp=new empleados();
    
    @RequestMapping("verAgendaEmpleados.htm")
    public ModelAndView verAgendaEmpleados(ModelAndView mav){
        System.out.println("entra a funcion documento");
        List<empleados> empleadoListbox=null;
        
        try{
            System.out.println("entra a funcion documento");
            empleadoListbox=empleadoService.findAll(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleadoListbox", empleadoListbox);
        mav.setViewName("verAgendaEmpleados");        
        return mav;
    }
    
    @RequestMapping("TareasEmpleado.htm")
    public String verContratos(@RequestParam(value = "nif") String nif,ModelMap map,Principal principal) {
        String name=principal.getName();
        List eventos = new ArrayList();
        empleados empleado=null;
        users u=null;
        List<TareaSupEmp> tareas=null;
        List<clientes> clientesLista=null;
        TareaSupEmp ta=new TareaSupEmp();
        try{
            clientesLista=clientesService.findAll("");
            u=usuarioService.getByLogin(name);
            
            
            tareas=tareaSupEmpService.getTareas(u.getNif(), nif);
            for(TareaSupEmp t:tareas){
                    eventos.add(new EventosEntity(t.getId(),t.getDescripcion(),t.getFinicio(), t.getFfin(),"label-success"));
                }
            emp=empleadoService.ByNif(nif);
            u=usuarioService.getByLogin(name);
            ta.setNifsupervisor(u.getNif());
            ta.setNifempleado(emp.getNif());
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("tareas",eventos);
        map.addAttribute("empleado",emp);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("tarea",ta);
        return("TareasEmpleado");
        
    }
    @RequestMapping(value = "addTareaEmpleado.htm",method=RequestMethod.GET)
    public String addContrato_get(ModelMap map,Principal principal) {
        String name=principal.getName();
        List<clientes> clientesLista=null;
        TareaSupEmp c=new TareaSupEmp();
        users u=null;
        try{
            u=usuarioService.getByLogin(name);
            c.setNifsupervisor(u.getNif());
            c.setNifempleado(emp.getNif());
            clientesLista=clientesService.findAll("");
            
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("tarea",c);
        map.addAttribute("nif",emp.getNif());
        return "addTareaEmpleado";
    }
    
    @RequestMapping(value = "addTareaEmpleado.htm",method=RequestMethod.POST)
    @ResponseBody
    public String addContrato_post(@ModelAttribute("tarea")TareaSupEmp tarea,BindingResult result) {
        String mensaje="";
        System.out.println("ADD TAREA");
        try{
           tarea.setNifempleado(emp.getNif());
           if(tarea.getCliasignado().equals("NO")){
               tarea.setNifcliente("");
           }
            tareaSupEmpService.insertTarea(tarea);
              
	 
        }catch(Exception e){
    
         }
       
         return "redirect:TareasEmpleado.htm?nif="+emp.getNif();
        
        
        
    }
    @RequestMapping(value = "/ajaxaddTarea", method = RequestMethod.POST)
    public @ResponseBody
    String getTimeS(@ModelAttribute(value="tarea") TareaSupEmp tarea) {
        try{
        //System.out.println("ajaxtext");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("ajax ADD tarea:" +tarea.getDescripcion()+"-"+tarea.getNifcliente());
        tarea.setNifempleado(emp.getNif());
           if(tarea.getCliasignado().equals("NO")){
               tarea.setNifcliente("");
           }
           
            tareaSupEmpService.insertTarea(tarea);
            }
    catch ( Exception ex ){
        System.out.println(ex);
    }
        return "/Intranet/sup/TareasEmpleado.htm?nif="+emp.getNif();
    }
    @RequestMapping(value = "/ajaxupdateTarea", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxupdateTarea(@ModelAttribute(value="tarea") TareaSupEmp tarea) {
        
        //System.out.println("ajaxtext");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("ajax UPDATE tarea:" +tarea.getId());
        if(tarea.getCliasignado().equals("NO")){
                    tarea.setNifcliente("");
                }
                if(tarea.getEstado().equals("SI")){
                    tarea.setNota("");
                }
                if(tarea.getCond()==true){
                    if(tarea.getNifcliente()!=null ){
                        tarea.setCondicion(3);
                        tareaSupEmpService.updateCondicion(tarea);
                    }else{
                        tarea.setCondicion(2);
                        tareaSupEmpService.updateCondicion(tarea);
                    }
                }else{
                    tareaSupEmpService.updateTarea(tarea);
                }
            //tareaSupEmpService.insertTarea(tarea);
        return "/Intranet/sup/TareasEmpleado.htm?nif="+emp.getNif();
    }
    
     @RequestMapping(value="/ajaxUpdateT.json", method=RequestMethod.GET)
    public @ResponseBody TareaSupEmp loginDisponible(
                                        @RequestParam("id") int id) {
        System.out.println("id:"+id);
        
      TareaSupEmp data=tareaSupEmpService.porId(id);
         System.out.println("data:"+data);
      String r="";
      
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
 
    
    @RequestMapping(value = "/ajaxdeleteTarea", method = RequestMethod.POST)
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
        return "/Intranet/sup/TareasEmpleado.htm?nif="+emp.getNif();
    }
    
    @RequestMapping(value = "updateTareaEmpleado.htm",method=RequestMethod.GET)
    public String updateContrato_get(ModelMap map,@RequestParam(value = "id") int id) {
        List<clientes> clientesLista=null;
        TareaSupEmp c=new TareaSupEmp();
        
        try{
            clientesLista=clientesService.findAll("");
            c=tareaSupEmpService.porId(id);
            
       
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("clientesLista",clientesLista);
        map.addAttribute("tarea",c);
        map.addAttribute("nif",emp.getNif());
        return "updateTareaEmpleado";
    }
    
    @RequestMapping(value = "updateTareaEmpleado.htm",method=RequestMethod.POST)
    public String updateContrato_post(@ModelAttribute("tarea")TareaSupEmp tarea,BindingResult result) {
        String mensaje="";
        if(!result.hasErrors()){
            try{
                System.out.println("cliente"+tarea.getNifcliente());
                if(tarea.getCliasignado().equals("NO")){
                    tarea.setNifcliente("");
                }
                if(tarea.getEstado().equals("SI")){
                    tarea.setNota("");
                }
                if(tarea.getCond()==true){
                    if(tarea.getNifcliente()!=null ){
                        tarea.setCondicion(3);
                        tareaSupEmpService.updateCondicion(tarea);
                    }else{
                        tarea.setCondicion(2);
                        tareaSupEmpService.updateCondicion(tarea);
                    }
                }else{
                    tareaSupEmpService.updateTarea(tarea);
                }
                //tareaSupEmpService.insertTarea(tarea);
            }catch(Exception e){

             }
	}else{return "error";} 
         
            return "redirect:TareasEmpleado.htm?nif="+emp.getNif();
        
    }
    @RequestMapping(value="deleteTareaEmpleado.htm",method=RequestMethod.GET)
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
	 
         return "redirect:TareasEmpleado.htm?nif="+emp.getNif();
        
        
    }
    
  
}
