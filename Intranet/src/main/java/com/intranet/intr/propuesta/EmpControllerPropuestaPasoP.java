/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuesta;

import com.intranet.beans.armarios;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.propuesta;
import com.intranet.beans.puertas;
import com.intranet.beans.tipo_estancia;
import com.intranet.beans.tipo_pano;
import com.intranet.beans.users;
import com.intranet.beans.ventanas;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.TipoEstanciasService;
import com.intranet.service.propuesta.TipoPanosService;
import com.intranet.service.propuesta.VentanaService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/emp/*")
public class EmpControllerPropuestaPasoP {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private TipoEstanciasService tipoEstanciasService;
    @Autowired
    private EstanciasService estanciasService;
    @Autowired
    private TipoPanosService tipoPanosService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    
    @RequestMapping(value = "ENuevaPropuesta.htm",method=RequestMethod.GET)
    public String addCliente_get(ModelMap map) {        
        List<clientes> clientesListbox=null;
        try{
            
            clientesListbox=clientesService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("clientesListbox", clientesListbox);
        return "ENuevaPropuesta";
    }
    
    @RequestMapping("/EjsonAddClientePasoPropuesta.htm")
    public @ResponseBody String jsonAddClientePasoPropuesta(@RequestBody clientes c ){
        
        try{
            if(clientesService.validaNIf(c.getNif())==false){
               clientesService.Insert(c);
               
            }
            
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        
        return "/Intranet/emp/ENuevaPropuestaAdd.htm?cli="+c.getNif(); 
    }
    
    @RequestMapping(value = "ENuevaPropuestaAdd.htm",method=RequestMethod.GET)
    public String NuevaPropuestaAdd_get(ModelMap map,@RequestParam(value="cli")String nif) {        
        clientes cliente=null;
        propuesta prop=new propuesta();
        try{            
            cliente=clientesService.ByNif(nif);
            prop.setCliente_nif(cliente);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente", cliente);
        map.addAttribute("prop",prop);
        return "ENuevaPropuestaAdd";
    }
    
    @RequestMapping(value = "ENuevaPropuestaAdd.htm",method=RequestMethod.POST)
    public String NuevaPropuestaAdd_post(@ModelAttribute("prop")propuesta prop,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        empleados empleado=new empleados();
        users u=null;
        int id=0;
        try{
            
            u=usuarioService.getByLogin(name);
            empleado=empleadoService.ByNif(u.getNif());
            prop.setEmpleado_nif(empleado);
            prop.setTipopropuesta(1);
            propuestasService.InsertPaso(prop);
            id=propuestasService.porIdNifCEmpleado(prop.getNifCliente(),u.getNif());
        }catch(Exception ex){
            
        }
          
         return "redirect:ENuevaPropuestaEstancias.htm?idP="+id;
        
        
        
    }
    @RequestMapping(value = "ENuevaPropuestaEstancias.htm",method=RequestMethod.GET)
    public String NuevaPropuestaEstancias_get(ModelMap map,@RequestParam(value="idP")int id) {        
        estancias e=new estancias();
        List<tipo_estancia> ltaTipoEstancia=null;
        
        try{            
            ltaTipoEstancia=tipoEstanciasService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",id);
        map.addAttribute("estancia",e);
        map.addAttribute("ltaTipoEstancia",ltaTipoEstancia);
        return "ENuevaPropuestaEstancias";
    }
    
    @RequestMapping(value = "ENuevaPropuestaEstancias.htm",method=RequestMethod.POST)
    public String NuevaPropuestaEstancias_post(@ModelAttribute("estancia")estancias estan,BindingResult result) {
        int idE=0;
        try{
            
            
            if(estan.getTipo_estancia_id().getId()!=6){
                estan.setOtro_tipo("");
            }
            estanciasService.Insert(estan);
            idE=estanciasService.idultimo(estan.getPropuesta_id().getId());
            
            //estancia.add(est);
            //estanciasService.Insert(est);
        }catch(Exception ex){}
         return "redirect:ENuevaPropuestaPanos.htm?idE="+idE;
    }
    
    @RequestMapping(value = "ENuevaPropuestaPanos.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPanos_get(ModelMap map,@RequestParam(value="idE")int idE) {        
        panos pano=new panos();
        List<tipo_pano> ltaTipoPano=null;
        estancias est=null;
        try{
            est=estanciasService.porID(idE);
            pano.setEstancia_id(est);
            //estancia=estanciasService.porID(idE);
            //pano.setEstancia_id(est);
            ltaTipoPano=tipoPanosService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        map.addAttribute("est",est);
        map.addAttribute("ltaTipoPano",ltaTipoPano);
        return "ENuevaPropuestaPanos";
    }
    
    @RequestMapping(value = "ENuevaPropuestaPanos.htm",method=RequestMethod.POST)
    public String NuevaPropuestaPanos_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="";
        try{
            System.out.println("ventana:"+pan.getVentana());
            
            //e.setId(idE);
                    if(pan.getTipo_pano_id().getId()==2)pan.setNombrepano("Suelo");
                    if(pan.getTipo_pano_id().getId()==3)pan.setNombrepano("Techo");
                    
                    
                    if(pan.getTipo_pano_id().getId()==1){
                        pan.setNombrepano("Paño "+pan.getNumero());
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else{
                    if(pan.getFormapano()==1){
                        pan.setLargo(0);
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==2){
                    
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==4){
                    
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==5){
                    
                        pan.setLado4(0);
                    }
                    }   
                    panosService.Insert(pan);
                    if(pan.getTipo_pano_id().getId()!=1)ruta="redirect:ENuevaPropuestaFinEstancia.htm?idE="+pan.getEstancia_id().getId();
                    else{
                        int idPan=panosService.idultimo(pan.getEstancia_id().getId());
                        ruta="redirect:ENuevaPropuestaVentanas.htm?idP="+idPan;
                    }
                    
        }catch(Exception ex){}
         return ruta;
    }
    
    @RequestMapping(value = "ENuevaPropuestaVentanas.htm",method=RequestMethod.GET)
    public String NuevaPropuestaVentanas_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
            
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "ENuevaPropuestaVentanas";
    }
    
    @RequestMapping(value = "ENuevaPropuestaVentanas.htm",method=RequestMethod.POST)
    public String NuevaPropuestaVentanas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        try{
            if(p.getVentana().equals("NO")){
               // pano.setVentana(p.getVentana());
                p.setNumventanas(0);
            }
            
            panosService.UpdateVentana(p);
            if(p.getVentana().equals("SI")){
                ruta="redirect:ENuevaPropuestaVentanasF.htm?idP="+p.getId();
            }else ruta="redirect:ENuevaPropuestaPuertas.htm?idP="+p.getId();
        }catch(Exception ex){}  
         return ruta;
    }
    @RequestMapping(value = "ENuevaPropuestaVentanasF.htm",method=RequestMethod.GET)
    public String NuevaPropuestaVentanasF_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        List<ventanas> ltaventana=null;
        try{
            pano=panosService.porID(idP);
          ltaventana=ventanaService.findAll(idP);
          
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("vent",new ventanas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaventana",ltaventana);
        return "ENuevaPropuestaVentanasF";
    }
    @RequestMapping(value = "ENuevaPropuestaVentanasF.htm",method=RequestMethod.POST)
    public String addVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="redirect:ENuevaPropuestaVentanasF.htm?idP="+v.getIdpano().getId();
        List<ventanas> ltaventana=null;
        try{
            //vent=v;
            panos pano=panosService.porID(v.getIdpano().getId());
            ventanaService.Insert(v);
            ltaventana=ventanaService.findAll(v.getIdpano().getId());
           
            if(pano.getNumventanas()==ltaventana.size()){
                ruta="redirect:ENuevaPropuestaPuertas.htm?idP="+pano.getId();
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
   
    @RequestMapping(value = "ENuevaPropuestaPuertas.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPuertas_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "ENuevaPropuestaPuertas";
    }
    
    @RequestMapping(value = "ENuevaPropuestaPuertas.htm",method=RequestMethod.POST)
    public String NuevaPropuestaPuertas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        try{
            if(p.getPuertas().equals("NO")){
               // pano.setVentana(p.getVentana());
                p.setNumpuertas(0);
            }
            
            panosService.UpdatePuerta(p);
            if(p.getPuertas().equals("SI")){
                ruta="redirect:ENuevaPropuestaPuertasF.htm?idP="+p.getId();
            }else ruta="redirect:ENuevaPropuestaArmarios.htm?idP="+p.getId();
        }catch(Exception ex){}  
         return ruta;
    }
    @RequestMapping(value = "ENuevaPropuestaPuertasF.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPuertasF_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        List<puertas> ltapuerta=null;
        try{
            pano=panosService.porID(idP);
            ltapuerta=puertasService.findAll(idP);
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pue",new puertas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltapuerta",ltapuerta);
        return "ENuevaPropuestaPuertasF";
    }
    
    @RequestMapping("/EjsonNuevaPropuestaEjaddPuertasF.htm")
    public @ResponseBody String jsonNuevaPropuestaEjaddPuertasF(@RequestBody puertas p ){
        System.out.println("add json puertas");
        String ruta="/Intranet/emp/ENuevaPropuestaPuertasF.htm?idP="+p.getId_pano();
        try{
            panos pano=panosService.porID(p.getId_pano());
            puertasService.InsertPaso(p);
            List<puertas> ltapuerta=puertasService.findAll(p.getId_pano());
           
            if(pano.getNumpuertas()==ltapuerta.size()){
                ruta="/Intranet/emp/ENuevaPropuestaArmarios.htm?idP="+p.getId_pano();
            }
        }catch(Exception ex){}
        return ruta; 
    }
    
    @RequestMapping(value = "ENuevaPropuestaArmarios.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPuertasArmarios_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "ENuevaPropuestaArmarios";
    }
    
    @RequestMapping(value = "ENuevaPropuestaArmarios.htm",method=RequestMethod.POST)
    public String NuevaPropuestaPuertasArmarios_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        panos pa=null;
        try{
            if(p.getArmario().equals("NO")){
               // pano.setVentana(p.getVentana());
                p.setNumarmarios(0);
            }
            pa=panosService.porID(p.getId());
            panosService.UpdateArmario(p);
            if(p.getArmario().equals("SI")){
                ruta="redirect:ENuevaPropuestaArmariosF.htm?idP="+p.getId();
            }else ruta="redirect:ENuevaPropuestaFinEstancia.htm?idE="+pa.getEstancia_id().getId();
        }catch(Exception ex){}  
         return ruta;
    }
    
     @RequestMapping(value = "ENuevaPropuestaArmariosF.htm",method=RequestMethod.GET)
    public String NuevaPropuestaArmariosF_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        List<armarios> ltaarmario=null;
        try{
            pano=panosService.porID(idP);
          ltaarmario=armariosService.findAll(idP);
          
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
         map.addAttribute("arm",new armarios());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaarmario",ltaarmario);
        return "ENuevaPropuestaArmariosF";
    }
    @RequestMapping(value = "ENuevaPropuestaArmariosF.htm",method=RequestMethod.POST)
    public String NuevaPropuestaArmariosF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="redirect:ENuevaPropuestaArmariosF.htm?idP="+v.getIdpano().getId();
        List<armarios> ltaarmario=null;
        try{
            //vent=v;
            panos pano=panosService.porID(v.getIdpano().getId());
            armariosService.Insert(v);
            ltaarmario=armariosService.findAll(v.getIdpano().getId());
            
            if(pano.getNumarmarios()==ltaarmario.size()){
                ruta="redirect:ENuevaPropuestaFinEstancia.htm?idE="+pano.getEstancia_id().getId();
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "ENuevaPropuestaFinEstancia.htm",method=RequestMethod.GET)
    public String NuevaPropuestaFinEstancia_get(ModelMap map,@RequestParam(value="idE")int idE) {
        
        String r=validaInterfacesRoles.valida();
        estancias est=estanciasService.porID(idE);
        map.addAttribute("menu",r);
        map.addAttribute("est",idE);
        map.addAttribute("idP",est.getPropuesta_id().getId());
        return "ENuevaPropuestaFinEstancia";
    }
    
    @RequestMapping(value = "ENuevaPropuestaFinPropuesta.htm",method=RequestMethod.GET)
    public String NuevaPropuestaFinPropuesta(ModelMap map,@RequestParam(value="idE")int idE) {
        List<panos> ltapanos=null;
        estancias est=null;
        
        
            //estancia.add(est);
                est=estanciasService.porID(idE);
                ltapanos=panosService.findAll(est.getId());
                for(panos p:ltapanos){
                    
                    p=updateMedidas(p);
                    panosService.Update(p);
                    
                }
                ltapanos=panosService.findAll(idE);
                est.setLtaPanos(ltapanos);
                est=sumaSuperficiesEstancia(est);
                //est.setPropuesta_id(prop);
                
                estanciasService.Update(est);
       
        
        return "redirect:ENuevaPropuestaEstancias.htm?idP="+est.getPropuesta_id().getId();
    }
    
    @RequestMapping(value = "ENuevaPropuestaFinPropuesta2.htm",method=RequestMethod.GET)
    public String NuevaPropuestaFinPropuesta2(ModelMap map,@RequestParam(value="idE")int idE) {
        List<panos> ltapanos=null;
        estancias est=null;
        String ruta= "";
        
            //estancia.add(est);
                est=estanciasService.porID(idE);
                ltapanos=panosService.findAll(est.getId());
                for(panos p:ltapanos){
                    
                    p=updateMedidas(p);
                    panosService.Update(p);
                    
                }
                ltapanos=panosService.findAll(idE);
                est.setLtaPanos(ltapanos);
                est=sumaSuperficiesEstancia(est);
                //est.setPropuesta_id(prop);
                
                estanciasService.Update(est);
        return "redirect:ENuevaPropuestaVerEstancia.htm?idP="+est.getPropuesta_id().getId();
    }
    
    @RequestMapping("ENuevaPropuestaVerEstancia.htm")
    public String NuevaPropuestaVerEstancia(@RequestParam(value = "idP") int idP,ModelMap map) {
        propuesta prop=new propuesta();
        List<estancias> ltaEstancias=null;
        List<estancias> ltaEstancias2=new ArrayList<estancias>();
        try{
            //empleado=empleadoService.ByNif(nif); 
            prop=propuestasService.porId(idP);
            ltaEstancias=estanciasService.listaPropuesta(idP);
            
            float totalSpanos=0;
            float superficie=0;
            float TotalSventanas=0;
            float TotalSpuertas=0;
            float TotalSarmarios=0;
            float TotalSsuelos=0;
            float TotalStechos=0;
                int numventanaP=0;
                int numpuertaP=0;
                int numarmarioP=0;
            //prop=propuestasService.porId(id);
            //ltaEstancias=estanciasService.listaPropuesta(id);
            for(estancias e: ltaEstancias){
                List<panos> ltaPanos=null;
                int numventana=0;
                int numpuerta=0;
                int numarmario=0;
                ltaPanos=panosService.findAll(e.getId());
                for(panos pa:ltaPanos){
                    numventana=numventana+pa.getNumventanas();
                    numpuerta=numpuerta+pa.getNumpuertas();
                    numarmario=numarmario+pa.getNumarmarios();
                }
                e.setNumventanas(numventana);
                e.setNumpuertas(numpuerta);
                e.setNumarmarios(numarmario);
                e.setLtaPanos(ltaPanos);
                ltaEstancias2.add(e);
                totalSpanos=totalSpanos+e.getTotalSpanos();
                superficie=superficie+e.getSuperficie();
                TotalSventanas=TotalSventanas+e.getTotalSventanas();
                TotalSpuertas=TotalSpuertas+e.getTotalSpuertas();
                TotalSarmarios=TotalSarmarios+e.getTotalSarmarios();
                TotalSsuelos=TotalSsuelos+e.getTotalSsuelos();
                TotalStechos=TotalStechos+e.getTotalStechos();
                    numventanaP=numventanaP+e.getNumventanas();
                    numpuertaP=numpuertaP+e.getNumpuertas();
                    numarmarioP=numarmarioP+e.getNumarmarios();
            }
            prop.setTotalSpanos(totalSpanos);
            prop.setSuperficie(superficie);
            prop.setTotalSventanas(TotalSventanas);
            prop.setTotalSpuertas(TotalSpuertas);
            prop.setTotalSarmarios(TotalSarmarios);
            prop.setTotalSsuelos(TotalSsuelos);
            prop.setTotalStechos(TotalStechos);
            prop.setNumventanas(numventanaP);
            prop.setNumpuertas(numpuertaP);
            prop.setNumarmarios(numarmarioP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",prop);
        map.addAttribute("ltaEstancias",ltaEstancias);
        return("ENuevaPropuestaVerEstancia");
        
    }
    
     @RequestMapping("ENuevaPropuestaVerPanos.htm")
    public String NuevaPropuestaVerPanos(@RequestParam(value = "idE") int idE,ModelMap map) {
        List<panos> ltaPanos=null;
        //propuesta prop=new propuesta();
        estancias estancia=null;
        try{
            estancia=estanciasService.porID(idE);
            ltaPanos=panosService.findAll(idE);
            int numventana=0;
                int numpuerta=0;
                int numarmario=0;
                for(panos pa:ltaPanos){
                    numventana=numventana+pa.getNumventanas();
                    numpuerta=numpuerta+pa.getNumpuertas();
                    numarmario=numarmario+pa.getNumarmarios();
                }
                estancia.setNumventanas(numventana);
                estancia.setNumpuertas(numpuerta);
                estancia.setNumarmarios(numarmario);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("estancia",estancia);
        map.addAttribute("ltaPanos",ltaPanos);
        return("ENuevaPropuestaVerPanos");
        
    }
    
    @RequestMapping(value = "ENuevaPropuestaDeleteEstancia.htm",method=RequestMethod.GET)
    public String NuevaPropuestaDeleteEstancia(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        estancias estancia=null;
        try{
            
            estancia=estanciasService.porID(idE);
            estancia.setLtaPanos(panosService.findAll(idE));
            for(panos p:estancia.getLtaPanos()){
                if(p.getTipo_pano_id().getId()==1){
                    ventanaService.DeletePano(p.getId());
                    puertasService.DeletePano(p.getId());
                    armariosService.DeletePano(p.getId());
                }
                    rpta=panosService.Delete(p.getId());
                    
                }
            estancia.setLtaPanos(panosService.findAll(idE));
            estancia=sumaSuperficiesEstancia(estancia);
            estanciasService.Delete(idE);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaVerEstancia.htm?idP="+idP;
    }
    
    @RequestMapping(value = "ENuevaPropuestaDeletePano.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        estancias estancia=null;
        try{
            ventanaService.DeletePano(idP);
            puertasService.DeletePano(idP);
            armariosService.DeletePano(idP);
            rpta=panosService.Delete(idP);
            estancia=estanciasService.porID(idE);
           
            estancia.setLtaPanos(panosService.findAll(idE));
            estancia=sumaSuperficiesEstancia(estancia);
            estanciasService.Update(estancia);
           
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaVerPanos.htm?idE="+idE;
    }
    
    @RequestMapping("ENuevaPropuestaVerP.htm")
    public String verPanos(@RequestParam(value = "idPano") int idPano,ModelMap map) {
        panos pa=null;
        //propuesta prop=new propuesta();
        try{
            pa=panosService.porID(idPano);
            if(pa.getTipo_pano_id().getId()==1){
            pa.setVentanaspano(ventanaService.findAll(idPano));
            pa.setPuertaspano(puertasService.findAll(idPano));
            pa.setArmariospano(armariosService.findAll(idPano));
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pa);
        return("ENuevaPropuestaVerP");
        
    }
    
    
    @RequestMapping(value = "ENuevaPropuestavolcarPano.htm",method=RequestMethod.GET)
    public String NuevaPropuestavolcarPano(@RequestParam(value = "idPano") int idPano,ModelMap map) {
        String rpta="";
        panos pano2=new panos();
        estancias estancia=null;
        try{
            
            panos pano=panosService.porID(idPano);
            if(pano!=null && pano.getId()!=0){                
                panosService.InsertVolcar(pano);
                pano2=panosService.porID(panosService.idultimo(pano.getEstancia_id().getId()));
                if(pano.getNumventanas()>0){ 
                    List<ventanas> ltaventanas=ventanaService.findAll(idPano);
                    for(ventanas v:ltaventanas){
                        v.setIdpano(pano2);
                        ventanaService.Insert(v);
                    }
                }
                if(pano.getNumpuertas()>0){ 
                    List<puertas> ltapuertas=puertasService.findAll(idPano); 
                    for(puertas v:ltapuertas){
                        v.setIdpano(pano2);
                        puertasService.Insert(v);
                    }
                }
                if(pano.getNumarmarios()>0){ 
                    List<armarios> ltaarmarios=armariosService.findAll(idPano); 
                    for(armarios v:ltaarmarios){
                        v.setIdpano(pano2);
                        armariosService.Insert(v);
                    }
                }
                estancia=estanciasService.porID(pano2.getEstancia_id().getId());
                estancia.setLtaPanos(panosService.findAll(estancia.getId()));
                estancia=sumaSuperficiesEstancia(estancia);
                estanciasService.Update(estancia);
            }
             
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaVerPanos.htm?idE="+pano2.getEstancia_id().getId();
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdatePano.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdatePano_get(ModelMap map,@RequestParam(value = "idP") int idPano) {
        panos pa=new panos();
        //estancias estancia=new estancias();
        List<tipo_pano> ltaTipoPano=null;
        try{
            //estancia=estanciasService.porID(idPano);
            pa=panosService.porID(idPano);
            ltaTipoPano=tipoPanosService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pa);
        map.addAttribute("ltaTipoPano",ltaTipoPano);
        
        return "ENuevaPropuestaUpdatePano";
    }
    
     @RequestMapping(value = "ENuevaPropuestaUpdatePano.htm",method=RequestMethod.POST)
    public String updatePano_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="redirect:ENuevaPropuestaUpdateVentanas.htm?idP="+pan.getId();
        List<panos> ltapanos=null;
        
           
                    if(pan.getTipo_pano_id().getId()==2)pan.setNombrepano("Suelo");
                    if(pan.getTipo_pano_id().getId()==3)pan.setNombrepano("Techo");
                    
                    if(pan.getTipo_pano_id().getId()==1){
                        pan.setNombrepano("Paño "+pan.getNumero());
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else{
                    if(pan.getFormapano()==1){
                        pan.setLargo(0);
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==2){
                    
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==4){
                    
                        pan.setLado3(0);
                        pan.setLado4(0);
                    }else if(pan.getFormapano()==5){
                    
                        pan.setLado4(0);
                    }
                    }
                    if(pan.getTipo_pano_id().getId()!=1){
                        if(ventanaService.findAll(pan.getId()).size()>0)ventanaService.DeletePano(pan.getId());
                        if(puertasService.findAll(pan.getId()).size()>0)puertasService.DeletePano(pan.getId());
                        if(armariosService.findAll(pan.getId()).size()>0)armariosService.DeletePano(pan.getId());
                        pan.setNumventanas(0);
                        pan.setNumarmarios(0);
                        pan.setNumpuertas(0);
                        pan.setSuperficiearmario(0);
                        pan.setSuperficiepuerta(0);
                        pan.setSuperficieventana(0);
                        pan.setVentana("NO");
                        pan.setPuertas("NO");
                        pan.setArmario("NO");
                        pan.setTotal(pan.getSuperficie());
                            panosService.Update(pan);
                        ruta="redirect:ENuevaPropuestaVerPanos.htm?idE="+pan.getEstancia_id().getId();
                    }else{ 
                        pan.setTotal(pan.getSuperficie());
                        panosService.Update(pan);
                    }
                    ltapanos=panosService.findAll(pan.getEstancia_id().getId());
                    estancias est=updEstancia(ltapanos,pan.getEstancia_id().getId());
                    estanciasService.Update(est);
                    
        
         return ruta;
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdateVentanas.htm",method=RequestMethod.GET)
    public String EjupdateVentanas_get(ModelMap map,@RequestParam(value = "idP") int id) {
        List<ventanas> ltaventana=null;
        try{
            //pano=panosService.porID(id);
            ltaventana=ventanaService.findAll(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("idPano",id);
        map.addAttribute("ltaventana",ltaventana);
        return "ENuevaPropuestaUpdateVentanas";
    }
    
    
    @RequestMapping(value = "ENuevaPropuestaUpdateVentanasF.htm",method=RequestMethod.GET)
    public String EjupdateVentanasF_get(ModelMap map,@RequestParam(value = "id") int id) {
        ventanas ventana=null;
        try{
            //pano=panosService.porID(id);
            ventana=ventanaService.porID(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",ventana);
        return "ENuevaPropuestaUpdateVentanasF";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdateVentanasF.htm",method=RequestMethod.POST)
    public String EjupdateVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           ventanaService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdateVentanas.htm?idP="+v.getIdpano().getId()+"";
    }
     @RequestMapping(value = "ENuevaPropuestaUpdateVentanasFadd.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdateVentanasFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        ventanas v=new ventanas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",v);
        return "ENuevaPropuestaUpdateVentanasFadd";
    }
    @RequestMapping(value = "ENuevaPropuestaUpdateVentanasFadd.htm",method=RequestMethod.POST)
    public String NuevaPropuestaUpdateVentanasFadd_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           ventanaService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setVentana("SI");
           p.setNumventanas(p.getNumventanas()+1);
           p.setSuperficieventana(p.getSuperficieventana()+v.getSuperficie());
           p.setTotal(p.getTotal()-v.getSuperficie());
           panosService.UpdateVentana(p);
           p.getEstancia_id().setTotalSventanas(p.getEstancia_id().getTotalSventanas()+v.getSuperficie());
           p.getEstancia_id().setSuperficie(p.getEstancia_id().getTotalSpanos()-v.getSuperficie());
           estanciasService.Update(p.getEstancia_id());
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdateVentanas.htm?idP="+v.getIdpano().getId();
    }
    
    @RequestMapping(value = "ENuevaPropuestaDeleteVentanas.htm",method=RequestMethod.GET)
    public String EjdeleteVentanas(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        ventanas ventana=null;
        try{
            ventana=ventanaService.porID(id);
            ventanaService.Delete(id);
            panos p=panosService.porID(ventana.getIdpano().getId());
            int n=p.getNumventanas()-1;
           p.setNumventanas(n);
           panosService.UpdateVentana(p);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaUpdateVentanas.htm?idP="+ventana.getIdpano().getId()+"";
    }
    //puertas
    
    @RequestMapping(value = "ENuevaPropuestaUpdatePuertas.htm",method=RequestMethod.GET)
    public String EjupdatePuertas_get(ModelMap map,@RequestParam(value = "idP") int id) {
        List<puertas> ltapuerta=null;
        try{
            //pano=panosService.porID(id);
            ltapuerta=puertasService.findAll(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("idPano",id);
        map.addAttribute("ltapuerta",ltapuerta);
        return "ENuevaPropuestaUpdatePuertas";
    }
    
    
    @RequestMapping(value = "ENuevaPropuestaUpdatePuertasF.htm",method=RequestMethod.GET)
    public String EjupdatePuertasF_get(ModelMap map,@RequestParam(value = "id") int id) {
        puertas p=null;
        try{
            //pano=panosService.porID(id);
            p=puertasService.porID(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pu",p);
        return "ENuevaPropuestaUpdatePuertasF";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdatePuertasF.htm",method=RequestMethod.POST)
    public String EjupdatePuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           puertasService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdatePuertas.htm?idP="+v.getIdpano().getId()+"";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdatePuertasFadd.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdatePuertasFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        puertas v=new puertas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pu",v);
        return "ENuevaPropuestaUpdatePuertasFadd";
    }
    @RequestMapping(value = "ENuevaPropuestaUpdatePuertasFadd.htm",method=RequestMethod.POST)
    public String EjupdateassPuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           puertasService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumpuertas(p.getNumpuertas()+1);
           panosService.UpdatePuerta(p);
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdatePuertas.htm?idP="+v.getIdpano().getId();
    }
    @RequestMapping(value = "ENuevaPropuestaDeletePuertas.htm",method=RequestMethod.GET)
    public String EjdeletePuertas(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        puertas p=null;
        try{
            p=puertasService.porID(id);
            puertasService.Delete(id);
            panos pp=panosService.porID(p.getIdpano().getId());
            int n=pp.getNumpuertas()-1;
           pp.setNumpuertas(n);
           panosService.UpdatePuerta(pp);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaUpdatePuertas.htm?idP="+p.getIdpano().getId()+"";
    }
    
    //armarios
    
    @RequestMapping(value = "ENuevaPropuestaUpdateArmario.htm",method=RequestMethod.GET)
    public String EjupdateArmario_get(ModelMap map,@RequestParam(value = "idP") int id) {
        List<armarios> ltaarmario=null;
        try{
            //pano=panosService.porID(id);
            ltaarmario=armariosService.findAll(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("idPano",id);
        map.addAttribute("ltaarmario",ltaarmario);
        return "ENuevaPropuestaUpdateArmario";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdateArmarioF.htm",method=RequestMethod.GET)
    public String EjupdateArmarioF_get(ModelMap map,@RequestParam(value = "id") int id) {
        armarios p=null;
        try{
            //pano=panosService.porID(id);
            p=armariosService.porID(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",p);
        return "ENuevaPropuestaUpdateArmarioF";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdateArmarioF.htm",method=RequestMethod.POST)
    public String EjupdateArmarioF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           armariosService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdateArmario.htm?idP="+v.getIdpano().getId()+"";
    }
    
    @RequestMapping(value = "ENuevaPropuestaUpdateArmarioFadd.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdateArmarioFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        armarios v=new armarios();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",v);
        return "ENuevaPropuestaUpdateArmarioFadd";
    }
    @RequestMapping(value = "ENuevaPropuestaUpdateArmarioFadd.htm",method=RequestMethod.POST)
    public String NuevaPropuestaUpdateArmarioFadd_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           armariosService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumarmarios(p.getNumarmarios()+1);
           panosService.UpdateArmario(p);
        }catch(Exception ex){}          
        
         return "redirect:ENuevaPropuestaUpdateArmario.htm?idP="+v.getIdpano().getId();
    }
    @RequestMapping(value = "ENuevaPropuestaDeleteArmario.htm",method=RequestMethod.GET)
    public String EjdeleteArmario(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        armarios p=null;
        try{
            p=armariosService.porID(id);
            armariosService.Delete(id);
            panos pa=panosService.porID(p.getIdpano().getId());
            int n=pa.getNumarmarios()-1;
           pa.setNumarmarios(n);
           panosService.UpdateArmario(pa);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ENuevaPropuestaUpdateArmario.htm?idP="+p.getIdpano().getId()+"";
    }
    @RequestMapping(value = "ENuevaPropuestaUpdateFinish.htm",method=RequestMethod.GET)
    public String EjupdateFinish(ModelMap map,@RequestParam(value = "idP") int id) {
        //panos p=null;
        estancias est=null;
        List<panos> ltapanos=null;
        try{
            //estancia.add(est);
            panos pp=panosService.porID(id);
            est=pp.getEstancia_id();
            ltapanos=panosService.findAll(est.getId());
                for(panos p:ltapanos){
                    int sumventana=0;
                    int sumpuerta=0;
                    int sumarm=0;
                    float supVentana=0;
                    float supPuerta=0;
                    float supArm=0;
                    p.setVentanaspano(ventanaService.findAll(p.getId()));
                    p.setPuertaspano(puertasService.findAll(p.getId()));
                    p.setArmariospano(armariosService.findAll(p.getId()));
                    for(ventanas v:p.getVentanaspano()){
                        supVentana=supVentana+v.getSuperficie();
                         sumventana=sumventana+1;
                    }
                    for(puertas v:p.getPuertaspano()){
                        supPuerta=supPuerta+v.getSuperficie();
                        sumpuerta=sumpuerta+1;
                    }
                    for(armarios v:p.getArmariospano()){
                        supArm=supArm+v.getSuperficie();
                        sumarm=sumarm+1;
                    }
                    float total=p.getSuperficie()-(supVentana+supPuerta+supArm);
                    p.setNumventanas(sumventana);
                    p.setNumpuertas(sumpuerta);
                    p.setNumarmarios(sumarm);
                    p.setSuperficieventana(supVentana);
                    p.setSuperficiepuerta(supPuerta);
                    p.setSuperficiearmario(supArm);
                    p.setTotal(total);
                    System.out.println("suma de superficies: "+total+"."+sumventana+"."+supPuerta+"-"+supArm+"-"+p.getSuperficieventana()+"."+p.getSuperficiepuerta()+"."+p.getSuperficiearmario());
                    if(p.getTipo_pano_id().getId()==1){
                        p.setNombrepano("Paño "+p.getNumero());
                    }
                    panosService.Update(p);
                    
                }
                ltapanos=panosService.findAll(est.getId());
                est.setLtaPanos(ltapanos);
                est=sumaSuperficiesEstancia(est);
                //est.setPropuesta_id(prop);
                //est.setPropuesta_id(prop);
                
                estanciasService.Update(est);
                /*List<presupuesto> listaP=presupuestosService.presupuestoEstancia(est.getId());
                for(presupuesto p:listaP){
                    float monto=p.getEstancia_id().getTotalSpanos()*p.getSubcapitulo().getCantidad();
                    p.setMonto(monto);
                    presupuestosService.UpdateMonto(p);
                }*/
            
        }catch(Exception ex){
        }
        
        return "redirect:ENuevaPropuestaVerPanos.htm?idE="+est.getId();
    }
    
    
    public panos updateMedidas(panos p){
        int sumventana=0;
                    int sumpuerta=0;
                    int sumarm=0;
                    float supVentana1=0;
                    float supPuerta1=0;
                    float supArm1=0;
                    p.setVentanaspano(ventanaService.findAll(p.getId()));
                    p.setPuertaspano(puertasService.findAll(p.getId()));
                    p.setArmariospano(armariosService.findAll(p.getId()));
                    for(ventanas v:p.getVentanaspano()){
                        supVentana1=supVentana1+v.getSuperficie();
                         sumventana=sumventana+1;
                    }
                    System.out.println("ventanas"+sumventana+"-"+supVentana1);
                    for(puertas v:p.getPuertaspano()){
                        supPuerta1=supPuerta1+v.getSuperficie();
                        sumpuerta=sumpuerta+1;
                    }
                    System.out.println("sumpuerta"+sumpuerta+"-"+supPuerta1);
                    for(armarios v:p.getArmariospano()){
                        supArm1=supArm1+v.getSuperficie();
                        sumarm=sumarm+1;
                    }
                    System.out.println("sumarm"+sumarm+"-"+supArm1);
                    float total=p.getSuperficie()-(supVentana1+supPuerta1+supArm1);
                    p.setNumventanas(sumventana);
                    p.setNumpuertas(sumpuerta);
                    p.setNumarmarios(sumarm);
                    p.setSuperficieventana(supVentana1);
                    p.setSuperficiepuerta(supPuerta1);
                    p.setSuperficiearmario(supArm1);
                    p.setTotal(total);
                    System.out.println("suma de superficies: "+total+"."+sumventana+"."+supPuerta1+"-"+supArm1+"-"+p.getSuperficieventana()+"."+p.getSuperficiepuerta()+"."+p.getSuperficiearmario());
                    if(p.getTipo_pano_id().getId()==1){
                        p.setNombrepano("Paño "+p.getNumero());
                    }
        return p;
    }
    public estancias sumaSuperficiesEstancia(estancias e){
		 float totalS=0;
		 float totalSpanos=0;
		 float totalSventanas=0;
		 float totalSpuertas=0;
		 float totalSarmarios=0;
		 float totalSsuelos=0;
		 float totalStechos=0;
			
			for(panos pp:e.getLtaPanos()){
				totalS=totalS+pp.getTotal();
				totalSpanos=totalSpanos+pp.getSuperficie();	
				if(pp.getTipo_pano_id().getId()==1){
					if(pp.getNumventanas()>0){
						totalSventanas=totalSventanas+pp.getSuperficieventana();
					}
					if(pp.getNumpuertas()>0){
						totalSpuertas=totalSpuertas+pp.getSuperficiepuerta();
					}
					if(pp.getNumarmarios()>0){
						totalSarmarios=totalSarmarios+pp.getSuperficiearmario();
					}
				}else{
					if(pp.getTipo_pano_id().getId()==2){
						totalSsuelos=totalSsuelos+pp.getSuperficie();
					}else{
						totalStechos=totalStechos+pp.getSuperficie();
					}
				}
				
			}
			System.out.println("total estancia "+totalS);
                        //estancia.setId(estancia.getId());
			//estancia.setPropuesta_id(estancia.getPropuesta_id());
			e.setSuperficie(totalS);System.out.println("totalS "+e.getSuperficie());
			e.setTotalSpanos(totalSpanos);System.out.println("totalSpanos "+e.getTotalSpanos());
			e.setTotalSventanas(totalSventanas);System.out.println("totalSventanas "+e.getTotalSventanas());
			e.setTotalSpuertas(totalSpuertas);System.out.println("totalSpuertas "+e.getTotalSpuertas());
			e.setTotalSarmarios(totalSarmarios);System.out.println("totalSarmarios "+e.getTotalSarmarios());
			e.setTotalSsuelos(totalSsuelos);System.out.println("totalSsuelos "+e.getTotalSsuelos());
			e.setTotalStechos(totalStechos);System.out.println("totalStechos "+e.getTotalStechos());
                        
			return e;
	 }
    
    public estancias updEstancia(List<panos> lta,int id){
        float totalS=0;
		 float totalSpanos=0;
		 float totalSventanas=0;
		 float totalSpuertas=0;
		 float totalSarmarios=0;
		 float totalSsuelos=0;
		 float totalStechos=0;
			
			for(panos pp:lta){
				totalS=totalS+pp.getTotal();
				totalSpanos=totalSpanos+pp.getSuperficie();	
				if(pp.getTipo_pano_id().getId()==1){
					if(pp.getNumventanas()>0){
						totalSventanas=totalSventanas+pp.getSuperficieventana();
					}
					if(pp.getNumpuertas()>0){
						totalSpuertas=totalSpuertas+pp.getSuperficiepuerta();
					}
					if(pp.getNumarmarios()>0){
						totalSarmarios=totalSarmarios+pp.getSuperficiearmario();
					}
				}else{
					if(pp.getTipo_pano_id().getId()==2){
						totalSsuelos=totalSsuelos+pp.getSuperficie();
					}else{
						totalStechos=totalStechos+pp.getSuperficie();
					}
				}
				
			}
			System.out.println("total estancia "+totalS);
                        estancias est=estanciasService.porID(id);
                        //estancia.setId(estancia.getId());
			//estancia.setPropuesta_id(estancia.getPropuesta_id());
			est.setSuperficie(totalS);
			est.setTotalSpanos(totalSpanos);
			est.setTotalSventanas(totalSventanas);
			est.setTotalSpuertas(totalSpuertas);
			est.setTotalSarmarios(totalSarmarios);
			est.setTotalSsuelos(totalSsuelos);
			est.setTotalStechos(totalStechos);
                        return est;
			
    }
}
