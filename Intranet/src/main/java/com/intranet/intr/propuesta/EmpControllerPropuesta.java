/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuesta;

import com.intranet.beans.armarios;
import com.intranet.beans.capitulos;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.plantillaPresupuesto;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoJson;
import com.intranet.beans.presupuesto_superficie;
import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.beans.presupuesto_superficies_panos_vpa;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.presupuestom2panos;
import com.intranet.beans.presupuestosGrupo;
import com.intranet.beans.propuesta;
import com.intranet.beans.puertas;
import com.intranet.beans.subcapitulos;
import com.intranet.beans.tipo_estancia;
import com.intranet.beans.tipo_pano;
import com.intranet.beans.users;
import com.intranet.beans.ventanas;
import com.intranet.intr.conexion;
import com.intranet.intr.mensajesEmail.mensajeContratoPropuesta;
import com.intranet.intr.mensajesEmail.mensajePresupuesto;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.CapitulosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PlantillaPresupuestoService;
import com.intranet.service.propuesta.PresupuestoCService;
import com.intranet.service.propuesta.PresupuestoM2PanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosVPAService;
import com.intranet.service.propuesta.PresupuestoSuperficiesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.SubCapitulosService;
import com.intranet.service.propuesta.TipoEstanciasService;
import com.intranet.service.propuesta.TipoPanosService;
import com.intranet.service.propuesta.VentanaService;
import java.security.Principal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
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
@RequestMapping("/emp/*")
public class EmpControllerPropuesta {
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
    private EstanciasService estanciasService;            
    @Autowired
    private TipoEstanciasService tipoEstanciasService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private TipoPanosService tipoPanosService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private PresupuestoCService presupuestoCService;
    @Autowired
    private CapitulosService capitulosService;
    @Autowired
    private SubCapitulosService subCapitulosService;
    @Autowired
    private PresupuestoSuperficiesService presupuestoSuperficiesService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    
    @Autowired
    private PlantillaPresupuestoService plantillaPresupuestoService;
    @Autowired
    private PresupuestoM2PanosService presupuestoM2PanosService;
    @Autowired
    private PresupuestoSuperficiesPanosService presupuestoSuperficiesPanosService;
    @Autowired
    private PresupuestoSuperficiesPanosVPAService presupuestoSuperficiesPanosVPAService;
    List<presupuestoJson> presupLta=new ArrayList<presupuestoJson>();
    presupuesto presup=new presupuesto();
    List<presupuesto_superficie> presupSupLista=new ArrayList<presupuesto_superficie>();
    float sum=0;
    clientes nifCli=new clientes();
    estancias estancia=new estancias();
    panos pa=new panos();
    
    @RequestMapping("ELtaClientesPropuesta.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav){
       
        List<clientes> clientesListbox=null;
        try{
            
            clientesListbox=clientesService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("clientesListbox", clientesListbox);
        mav.setViewName("ELtaClientesPropuesta");        
        return mav;
    }
    
    
    @RequestMapping(value = "EaddCliente.htm",method=RequestMethod.GET)
    public String addCliente_get(ModelMap map) {
        clientes cliente=new clientes();
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente",cliente);
        map.addAttribute("mensaje","mensaje");
        
        return "EaddCliente";
    }
    
    @RequestMapping(value = "EaddCliente.htm",method=RequestMethod.POST)
    public String addCliente_post(@ModelAttribute("cliente")clientes cliente,BindingResult result) {
        String mensaje="";
        
        try{
            if(clientesService.validaNIf(cliente.getNif())==false){
            clientesService.Insert(cliente);
            }
        }catch(Exception e){
        
        }
         return "redirect:ELtaClientesPropuesta.htm";
        
    }
    @RequestMapping("EverPropuestas.htm")
    public String verPropuestas(@RequestParam(value = "nifC") String nif,@RequestParam(value = "msg", required = false) String msg,ModelMap map,Principal principal) {
         String name=principal.getName();
        users u=null;
        List<propuesta> ltaPropuestas=null;
        List<propuesta> ltaPropuestas2=new ArrayList<propuesta>();
        int existePlantilla=0;
        try{
            if(msg!=null & msg!=""){
                if(msg.equals("contratado")) {
                    map.addAttribute("msg", "La Propuesta se ha contratado. Ahora es un PROYECTO");
                }else if(msg.equals("success")) {
                    map.addAttribute("msg", "Reporte de Presupuesto enviado Satisfactoriamente");
                }else if (msg.equals("error")) {
                    map.addAttribute("error", "Operacion rechazada, la Propuesta no tiene el Presupuesto Llenado");
                }
            }
            existePlantilla=plantillaPresupuestoService.existePlantilla();
            if(existePlantilla>0){
                List<plantillaPresupuesto> lta=plantillaPresupuestoService.todasPlantillas();
                map.addAttribute("ltaPlantillas",lta);
            }
            u=usuarioService.getByLogin(name);
            //empleado=empleadoService.ByNif(nif); 
            ltaPropuestas=propuestasService.filtroCE(u.getNif(),nif);
            for(propuesta p:ltaPropuestas){
                List<estancias> ltaest=estanciasService.listaPropuesta(p.getId());
                p.setTieneEstancias(ltaest.size());
                ltaPropuestas2.add(p);
            }
            nifCli=clientesService.ByNif(nif);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        presup=new presupuesto();
            presupSupLista=new ArrayList<presupuesto_superficie>();
            sum=0;
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaPropuestas",ltaPropuestas2);
        map.addAttribute("cliente",nifCli);
        map.addAttribute("existePlantilla",existePlantilla);
        return("EverPropuestas");
        
    }
    
    @RequestMapping(value = "EaddPropuesta.htm",method=RequestMethod.GET)
    public String addPropuesta_get(ModelMap map,@RequestParam(value = "nifC") String nif) {
        //List<tipo_contrato> allTipoContrato=null;
        propuesta prop=new propuesta();
        
        try{
            nifCli=clientesService.ByNif(nif);
            prop.setCliente_nif(nifCli);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("cliente",nifCli);
        map.addAttribute("prop",prop);
        
        return "EaddPropuesta";
    }
    
    @RequestMapping(value = "EaddPropuesta.htm",method=RequestMethod.POST)
    public String addPropuesta_post(@ModelAttribute("prop")propuesta prop,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        empleados empleado=new empleados();
        users u=null;
        try{
            
            u=usuarioService.getByLogin(name);
            empleado=empleadoService.ByNif(u.getNif());
            prop.setEmpleado_nif(empleado);
            propuestasService.Insert(prop);
        }catch(Exception ex){
            
        }
          
         return "redirect:EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif();
        
        
        
    }
    
    @RequestMapping(value = "EupdatePropuesta.htm",method=RequestMethod.GET)
    public String updatePropuesta_get(ModelMap map,@RequestParam(value = "idP") int idP) {
        //List<tipo_contrato> allTipoContrato=null;
        propuesta prop=new propuesta();
        
        try{
            prop=propuestasService.porId(idP);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",prop);
        
        return "EupdatePropuesta";
    }
    
    @RequestMapping(value = "EupdatePropuesta.htm",method=RequestMethod.POST)
    public String updatePropuesta_post(@ModelAttribute("prop")propuesta prop,BindingResult result) {
        
        try{
            propuestasService.Update(prop);
        }catch(Exception ex){
            
        }
          
         return "redirect:EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif();
        
        
        
    }
    
   @RequestMapping("EconsultarPropuesta.htm")
    public String consultarPropuesta(@RequestParam(value = "idP") int idP,ModelMap map) {
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
                List<panos> newltaPano=new ArrayList<panos>();
                for(panos pa:ltaPanos){
                    panos newpa=medidasPano(pa);
                    numventana=numventana+newpa.getNumventanas();
                    numpuerta=numpuerta+newpa.getNumpuertas();
                    numarmario=numarmario+newpa.getNumarmarios();
                    newltaPano.add(newpa);
                }
                e.setNumventanas(numventana);
                e.setNumpuertas(numpuerta);
                e.setNumarmarios(numarmario);
                e.setLtaPanos(newltaPano);
                e=sumaSuperficiesEstancia(e);
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
        return("EconsultarPropuesta");
        
    }
    public panos medidasPano(panos p){
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
                        
			e.setSuperficie(totalS);
			e.setTotalSpanos(totalSpanos);
			e.setTotalSventanas(totalSventanas);
			e.setTotalSpuertas(totalSpuertas);
			e.setTotalSarmarios(totalSarmarios);
			e.setTotalSsuelos(totalSsuelos);
			e.setTotalStechos(totalStechos);
                        
			return e;
	 }
    @RequestMapping(value = "EdeleteEstancia.htm",method=RequestMethod.GET)
    public String deleteEstancia(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
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
        
        return "redirect:EconsultarPropuesta.htm?idP="+idP;
    }
    
    @RequestMapping(value = "EaddEstancia.htm",method=RequestMethod.GET)
    public String addEstancia_get(ModelMap map,@RequestParam(value = "idP") int idP) {
        propuesta prop=new propuesta();
        estancias est=new estancias();
        List<tipo_estancia> ltaTipoEstancia=null;
        try{
            prop=propuestasService.porId(idP);
            ltaTipoEstancia=tipoEstanciasService.findAll("");
            estancia.setPropuesta_id(prop);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("estancia",est);
        map.addAttribute("prop",prop);
        map.addAttribute("ltaTipoEstancia",ltaTipoEstancia);
        
        return "EmpjaddEstancia";
    }
    
    @RequestMapping(value = "EaddEstancia.htm",method=RequestMethod.POST)
    public String addEstancia_post(@ModelAttribute("estancia")estancias est,BindingResult result,Principal principal) {
        propuesta prop=new propuesta();
        try{
            if(est.getTipo_estancia_id().getId()!=6){
                est.setOtro_tipo("");
            }
            est.setPropuesta_id(prop);
            
            estanciasService.Insert(est);
        }catch(Exception ex){            
        }
          
         return "redirect:EconsultarPropuesta.htm?idP="+prop.getId();
    }
    
    @RequestMapping("EverEstancias.htm")
    public String verEstancias(@RequestParam(value = "idE") int idE,ModelMap map) {
        List<panos> ltaPanos=null;
        //propuesta prop=new propuesta();
        try{
            estancia=estanciasService.porID(idE);
            ltaPanos=panosService.findAll(idE);
            List<panos> newltaPano=new ArrayList<panos>();
            int numventana=0;
            int numpuerta=0;
            int numarmario=0;
            for(panos p:ltaPanos){
                 panos newpa=medidasPano(pa);
                 numventana=numventana+newpa.getNumventanas();
                    numpuerta=numpuerta+newpa.getNumpuertas();
                    numarmario=numarmario+newpa.getNumarmarios();
                 newltaPano.add(newpa);
            }
            estancia.setNumventanas(numventana);
                estancia.setNumpuertas(numpuerta);
                estancia.setNumarmarios(numarmario);
                estancia.setLtaPanos(newltaPano);
                estancia=sumaSuperficiesEstancia(estancia);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        System.out.println("estancia: "+estancia.getPropuesta_id().getDescipcion());
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("estancia",estancia);
        map.addAttribute("ltaPanos",ltaPanos);
        return("EverEstancias");
        
    }
    @RequestMapping(value = "EvolcarPano.htm",method=RequestMethod.GET)
    public String volcarPano(@RequestParam(value = "idPano") int idPano,ModelMap map) {
        String rpta="";
        panos pano2=null;
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
        
        return "redirect:EverEstancias.htm?idE="+pano2.getEstancia_id().getId();
    }
    @RequestMapping(value = "EaddPano.htm",method=RequestMethod.GET)
    public String addPano_get(ModelMap map,@RequestParam(value = "idE") int idE) {
        panos pa=new panos();
        
        List<tipo_pano> ltaTipoPano=null;
        try{
            estancia=estanciasService.porID(idE);
            pa.setEstancia_id(estancia);
           
            ltaTipoPano=tipoPanosService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pa);
        map.addAttribute("ltaTipoPano",ltaTipoPano);
        
        return "EaddPano";
    }
    
    @RequestMapping(value = "EaddPano.htm",method=RequestMethod.POST)
    public String addPano_post(@ModelAttribute("pa")panos pa,BindingResult result) {
        
        try{
            if(pa.getTipo_pano_id().getId()==2)pa.setNombrepano("Suelo");
            if(pa.getTipo_pano_id().getId()==3)pa.setNombrepano("Techo");
            if(pa.getVentana().equals("NO")){
                pa.setNumventanas(0); 
                pa.setLargoventana(0);
                pa.setAltoventana(0);
                pa.setSuperficieventana(0);
            }
            if(pa.getPuertas().equals("NO")){
                pa.setNumpuertas(0);
                pa.setLargopuerta(0);
                pa.setAltopuerta(0);
                pa.setSuperficiepuerta(0);
            }
            if(pa.getArmario().equals("NO")){
                pa.setNumarmarios(0);
                pa.setLargoarmario(0);
                pa.setAltoarmario(0);
                pa.setFondoarmario(0);
                pa.setSuperficiearmario(0);
            }
            pa.setSuperficie(pa.getAlto()*pa.getLargo());
            pa.setSuperficieventana((pa.getLargoventana()*pa.getAltoventana())*pa.getNumventanas());
            pa.setSuperficiepuerta((pa.getLargopuerta()*pa.getAltopuerta())*pa.getNumpuertas());
            pa.setSuperficiearmario((pa.getLargoarmario()*pa.getAltoarmario())*pa.getNumarmarios());
            //Double total=Double.parseDouble(""+pano.getSuperficie())-(Double.parseDouble(""+pano.getSuperficieventana())-Double.parseDouble(""+pano.getSuperficiepuerta())-Double.parseDouble(""+pano.getSuperficiearmario()));
            float total=pa.getSuperficie()-(pa.getSuperficieventana()+pa.getSuperficiepuerta()+pa.getSuperficiearmario());
            System.out.println("suma "+total);

            pa.setTotal(total);
            
            if(pa.getTipo_pano_id().getId()==1){
		pa.setNombrepano("PaÃ±o "+pa.getNumero());
            }

            panosService.Insert(pa);
            
            estancias estancia=pa.getEstancia_id();
            estancia.setLtaPanos(panosService.findAll(pa.getEstancia_id().getId()));
            estancia=sumaSuperficiesEstancia(estancia);
            estanciasService.Update(estancia);
           /* List<presupuesto> listaP=presupuestosService.presupuestoEstancia(pa.getEstancia_id().getId());
            for(presupuesto p:listaP){
                //float monto=p.getEstancia_id().getTotalSpanos()*p.getSubcapitulo().getCantidad();
                p.setMonto(0);
                presupuestosService.UpdateMonto(p);
            }*/
        }catch(Exception ex){            
        }
          
         return "redirect:EverEstancias.htm?idE="+pa.getEstancia_id().getId();
    }
    
    
    
    @RequestMapping(value = "EupdatePano.htm",method=RequestMethod.GET)
    public String updatePano_get(ModelMap map,@RequestParam(value = "idPano") int idPano) {
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
        
        return "EupdatePano";
    }
    
    @RequestMapping(value = "EupdatePano.htm",method=RequestMethod.POST)
    public String updatePano_post(@ModelAttribute("pa")panos pa,BindingResult result) {
        
        try{
            if(pa.getTipo_pano_id().getId()==2)pa.setNombrepano("Suelo");
            if(pa.getTipo_pano_id().getId()==3)pa.setNombrepano("Techo");
            if(pa.getVentana().equals("NO")){
                pa.setNumventanas(0); 
                pa.setLargoventana(0);
                pa.setAltoventana(0);
                pa.setSuperficieventana(0);
            }
            if(pa.getPuertas().equals("NO")){
                pa.setNumpuertas(0);
                pa.setLargopuerta(0);
                pa.setAltopuerta(0);
                pa.setSuperficiepuerta(0);
            }
            if(pa.getArmario().equals("NO")){
                pa.setNumarmarios(0);
                pa.setLargoarmario(0);
                pa.setAltoarmario(0);
                pa.setFondoarmario(0);
                pa.setSuperficiearmario(0);
            }
            pa.setSuperficie(pa.getAlto()*pa.getLargo());
            pa.setSuperficieventana((pa.getLargoventana()*pa.getAltoventana())*pa.getNumventanas());
            pa.setSuperficiepuerta((pa.getLargopuerta()*pa.getAltopuerta())*pa.getNumpuertas());
            pa.setSuperficiearmario((pa.getLargoarmario()*pa.getAltoarmario())*pa.getNumarmarios());
            //Double total=Double.parseDouble(""+pano.getSuperficie())-(Double.parseDouble(""+pano.getSuperficieventana())-Double.parseDouble(""+pano.getSuperficiepuerta())-Double.parseDouble(""+pano.getSuperficiearmario()));
            float total=pa.getSuperficie()-(pa.getSuperficieventana()+pa.getSuperficiepuerta()+pa.getSuperficiearmario());
            System.out.println("suma "+total);

            pa.setTotal(total);
            
            if(pa.getTipo_pano_id().getId()==1){
		pa.setNombrepano("PaÃ±o "+pa.getNumero());
            }

            panosService.Update(pa);
            
            estancias estancia=pa.getEstancia_id();
            estancia.setLtaPanos(panosService.findAll(pa.getEstancia_id().getId()));
            estancia=sumaSuperficiesEstancia(estancia);
            estanciasService.Update(estancia);
           /* List<presupuesto> listaP=presupuestosService.presupuestoEstancia(pa.getEstancia_id().getId());
            for(presupuesto p:listaP){
                //float monto=p.getEstancia_id().getTotalSpanos()*p.getSubcapitulo().getCantidad();
                p.setMonto(0);
                presupuestosService.UpdateMonto(p);
            }*/
        }catch(Exception ex){            
        }
          
         return "redirect:EverEstancias.htm?idE="+pa.getEstancia_id().getId();
    }
    @RequestMapping(value = "EdeletePano.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            ventanaService.DeletePano(idP);
            puertasService.DeletePano(idP);
            armariosService.DeletePano(idP);
            rpta=panosService.Delete(idP);
             estancia=estanciasService.porID(idE);
            estancia.setLtaPanos(panosService.findAll(idE));
            for(panos p:estancia.getLtaPanos()){
                    
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
                    panosService.Update(p);
                    
                }
            estancia.setLtaPanos(panosService.findAll(idE));
            estancia=sumaSuperficiesEstancia(estancia);
            estanciasService.Update(estancia);
            /*List<presupuesto> listaP=presupuestosService.presupuestoEstancia(idE);
            for(presupuesto p:listaP){
                float monto=p.getEstancia_id().getTotalSpanos()*p.getSubcapitulo().getCantidad();
                p.setMonto(monto);
                presupuestosService.UpdateMonto(p);
            }*/
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverEstancias.htm?idE="+idE;
    }
    
    @RequestMapping("EverPanos.htm")
    public String verPanos(@RequestParam(value = "idPano") int idPano,ModelMap map) {
        
        //propuesta prop=new propuesta();
        try{
            pa=panosService.porID(idPano);
            
            if(pa.getTipo_pano_id().getId()==1){
                pa=medidasPano(pa);
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pa);
        return("EverPanos");
        
    }
    
    @RequestMapping("EPresupuesto.htm")
    public String Presupuesto(@RequestParam(value = "idP") int idP,ModelMap map) {
        propuesta prop=new propuesta();
        List<presupuestoc> ltaCapitulos=null;
        boolean presuProp=false;
        String result="";
        //propuesta prop=new propuesta();
        try{
            prop=propuestasService.porId(idP);
            ltaCapitulos=presupuestoCService.presupuestoCapitulos(idP);
            presuProp=presupuestoCService.presupPropuesta(idP);
            int r=presupuestoM2PanosService.buscar(idP);
            if(r==0){
                result="No existe ninguna Lista de Panos GUARDADO";
                map.addAttribute("result",result);
            }
            else{
                presupuestom2panos prem2=presupuestoM2PanosService.porIdProp(idP);
                presupuesto p=presupuestosService.porID(prem2.getIdpresupuesto());
                map.addAttribute("listaGuradada",p.getPresup_id());
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",prop);
        map.addAttribute("ltaCapitulos",ltaCapitulos);
        map.addAttribute("presuProp",presuProp);
        return("EPresupuesto");
        
    }
    @RequestMapping("/ECrearPlantilla.htm")
    public @ResponseBody String CrearPlantilla(@RequestBody plantillaPresupuesto pre ){
        propuesta prop=new propuesta();
        try{
            prop=propuestasService.porId(pre.getPropuesta_id());
            plantillaPresupuestoService.Insert(pre);
        }catch(Exception ex){}
        
        return "/Intranet/emp/EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif(); 
    }
    @RequestMapping("/EDeletePlantilla.htm")
    public @ResponseBody String DeletePlantilla(@RequestBody plantillaPresupuesto pre ){
        propuesta prop=new propuesta();
        try{
            prop=propuestasService.porId(pre.getPropuesta_id());
            plantillaPresupuestoService.delete(pre.getPropuesta_id());
        }catch(Exception ex){}
        
        return "/Intranet/emp/EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif(); 
    }
    
    
    @RequestMapping(value = "EAsignarPlantilla.htm",method=RequestMethod.GET)
    public String AsignarPlantilla(@RequestParam(value = "nifC") String nifC,@RequestParam(value = "idP") int idP,@RequestParam(value = "idPlan") int idPlan,ModelMap map) {
        String rpta="";
        
            plantillaPresupuesto plantilla=plantillaPresupuestoService.porID(idPlan);
            List<presupuestoc> ltaPresupC=presupuestoCService.presupuestoCapitulos(plantilla.getPropuesta_id());
            for(presupuestoc pc:ltaPresupC){
                int idCapExiste=presupuestoCService.ultimoPresupuestoC(idP, pc.getCapitulo_id());
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(pc.getCapitulo_id());
                    precnew.setPropuesta_id(idP);

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(idP, pc.getCapitulo_id());
               // }else idCapExiste=presupuestoCService.ultimoPresupuestoCid(idP, pc.getCapitulo_id());
                List<presupuesto> ltaPresup=presupuestosService.presupuestoSUBCapitulos(pc.getId());
                for(presupuesto pre:ltaPresup){
                    System.out.println("cap: "+idCapExiste+" sub cap: "+ pre.getIdSubCap());
                    int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste, pre.getIdSubCap());
                    System.out.println(" busca si existe:"+idSubCapExiste);
                    presupuesto ObjidSubCapExiste=new presupuesto();
                    if(idSubCapExiste==0){
                        pre.setPresup_id(idCapExiste);
                        System.out.println(" insertar");
                        presupuestosService.Insert(pre);
                    }
                        idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste, pre.getIdSubCap());
                         System.out.println(" insertar"+idSubCapExiste);
                        ObjidSubCapExiste=presupuestosService.porID(idSubCapExiste);
                    //}else ObjidSubCapExiste=presupuestosService.porID(idSubCapExiste);
                    float suma=0;
                    if(pre.getTipoCantidad().equals("m2") || pre.getTipoCantidad().equals("ml") ){
                        List<presupuesto_superficie> ltaPreSuperf=presupuestoSuperficiesService.findAll(pre.getId());
                        List<estancias> ltaEstancias=estanciasService.listaPropuesta(idP);
                        for(presupuesto_superficie presuperf:ltaPreSuperf){
                            presuperf.setPresupuesto_id(ObjidSubCapExiste.getId());
                            for(estancias est:ltaEstancias){
                                if(est.getNumero()==presuperf.getEstancia_id().getNumero()){
                                    
                                    presuperf.setEstancia(est.getId());
                                    int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                                    presupuesto_superficie presupobj=new presupuesto_superficie();
                                    if(idPresupSup==0){
                                    
                                    presupuestoSuperficiesService.Insert(presuperf);
                                    }
                                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                                   // }else presupobj=presupuestoSuperficiesService.buscar(presuperf);
                                    
                                    List<presupuesto_superficies_panos> ltaPreSuperfPanos=presupuestoSuperficiesPanosService.findAll(presuperf.getId());
                                    List<panos> ltaPanos=panosService.findAll(est.getId());
                                    for(presupuesto_superficies_panos presuperfpanos:ltaPreSuperfPanos){
                                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                                        for(panos pano:ltaPanos){
                                            panos idpp=panosService.porID(presuperfpanos.getIdpano());
                                            if(pano.getNumero()==idpp.getNumero()){
                                                presuperfpanos.setIdpano(pano.getId());
                                                
                                                int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(presuperfpanos.getIdpano(),presuperfpanos.getIdpresup_sup());
                                                if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                                                if(pre.getSubcapitulo().getId_capitulo().getId()==30 || pre.getSubcapitulo().getId_capitulo().getId()==31){
                                                    idPanosPre=presupuestoSuperficiesPanosService.buscar(presuperfpanos.getIdpano(),presuperfpanos.getIdpresup_sup());
                                                    List<presupuesto_superficies_panos_vpa> ltavpa=presupuestoSuperficiesPanosVPAService.findAll(presuperfpanos.getId());
                                                    
                                                    
                                                    
                                                    for(presupuesto_superficies_panos_vpa ltavpanew:ltavpa){
                                                        ltavpanew.setIdpresup_sup_pano(idPanosPre);
                                                        if(ltavpanew.getIdvpa()!=0){
                                                            List<ventanas> ltaVentanas=ventanaService.findAllPresupSuperficies(pano.getId(),presuperfpanos.getId());
                                                    for(ventanas ven:ltaVentanas){
                                                        
                                                        ventanas ventP=ventanaService.porID(ltavpanew.getIdvpa());
                                                        if(ven.getNum()==ventP.getNum()){
                                                            ltavpanew.setIdvpa(ven.getId());
                                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcount(ltavpanew.getIdvpa(), ltavpanew.getIdpresup_sup_pano());
                                                            if(vpaid==0)presupuestoSuperficiesPanosVPAService.Insert(ltavpanew);
                                                        
                                                            if(pre.getTipoCantidad().equals("m2"))suma=suma+ven.getSuperficie();
                                                            if(pre.getTipoCantidad().equals("ml"))suma=suma+ven.getLargo();
                                                            
                                                        }
                                                    }
                                                    }
                                                    if(ltavpanew.getIdpuerta()!=0){
                                                        List<puertas> ltaPuertas=ventanaService.findAllPresupSuperficiesP(pano.getId(),presuperfpanos.getId());
                                                    for(puertas ven:ltaPuertas){
                                                        
                                                        puertas ventP=puertasService.porID(ltavpanew.getIdpuerta());
                                                        if(ventP!=null || ventP.getId()!=0){
                                                        if(ven.getNum()==ventP.getNum()){
                                                            ltavpanew.setIdpuerta(ven.getId());
                                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountP(ltavpanew.getIdpuerta(), ltavpanew.getIdpresup_sup_pano());
                                                            if(vpaid==0)presupuestoSuperficiesPanosVPAService.InsertP(ltavpanew);
                                                        
                                                            if(pre.getTipoCantidad().equals("m2"))suma=suma+ven.getSuperficie();
                                                            if(pre.getTipoCantidad().equals("ml"))suma=suma+ven.getLargo();
                                                            
                                                        }
                                                        }
                                                    }
                                                    }
                                                    if(ltavpanew.getIdarmario()!=0){  
                                                        List<armarios> ltaArmarios=ventanaService.findAllPresupSuperficiesA(pano.getId(),presuperfpanos.getId());
                                                    for(armarios ven:ltaArmarios){
                                                        armarios ventP=armariosService.porID(ltavpanew.getIdarmario());
                                                        if(ventP!=null || ventP.getId()!=0){
                                                        if(ven.getNum()==ventP.getNum()){
                                                            ltavpanew.setIdarmario(ven.getId());
                                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountA(ltavpanew.getIdarmario(), ltavpanew.getIdpresup_sup_pano());
                                                            if(vpaid==0)presupuestoSuperficiesPanosVPAService.InsertA(ltavpanew);
                                                        
                                                            if(pre.getTipoCantidad().equals("m2"))suma=suma+ven.getSuperficie();
                                                            if(pre.getTipoCantidad().equals("ml"))suma=suma+ven.getLargo();
                                                            
                                                        }
                                                        }
                                                    }
                                                    }
                                                    }
                                                }else{
                                                    if(pre.getTipoCantidad().equals("m2"))suma=suma+pano.getSuperficie();
                                                    if(pre.getTipoCantidad().equals("ml"))suma=suma+pano.getLargo();
                                                }
                                            }
                                        }
                                    }
                                    
                                }
                            }
                            
                        }
                        ObjidSubCapExiste.setCantidad(suma);
                        ObjidSubCapExiste.setMonto(ObjidSubCapExiste.getPrecio()*ObjidSubCapExiste.getCantidad());
                        
                        
                       presupuestosService.Update(ObjidSubCapExiste);
                    }else{
                        pre.setId(ObjidSubCapExiste.getId());
                        presupuestosService.Update(pre);
                    }
                    
                    
                }
                
            }
        
        return "redirect:EverPropuestas.htm?nifC="+nifC;
    }
    /* @RequestMapping("EgrupoPresupuesto.htm")
    public String grupoPresupuesto(@RequestParam(value = "idPres",required=false) String idPres,@RequestParam(value = "idP") int idP,ModelMap map) {
        propuesta prop=new propuesta();
        List<presupuestoc> ltaPresupuesto=null;
        String ruta="EgrupoPresupuesto";
        //propuesta prop=new propuesta();
        try{
            prop=propuestasService.porId(idP);
            if(idPres!=null && idPres!=""){
            ltaPresupuesto=presupuestoCService.grupo(idP,Integer.parseInt(idPres));
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",prop);
        map.addAttribute("idPres",idPres);
        map.addAttribute("idP",idP);
        map.addAttribute("ltaPresupuesto",ltaPresupuesto);
        return("EgrupoPresupuesto");
        
    }*//*
    @RequestMapping(value = "EasignarPlantilla.htm",method=RequestMethod.GET)
    public String asignarPlantilla(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            int idPlantilla=plantillaPresupuestoService.SacarID(idE);
            if(idPlantilla!=0){
                plantillaPresupuesto pp=new plantillaPresupuesto();
                pp.setPropuesta_id(idP);
                pp.setEstancia_id(idE);
                plantillaPresupuestoService.Insert(pp);
            }else{
                plantillaPresupuesto pp=new plantillaPresupuesto();
                pp.setPropuesta_id(idP);
                pp.setEstancia_id(idE);
                plantillaPresupuestoService.Update(pp);
            }
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EPresupuesto.htm?idP="+idP;  
    }*//*
    @RequestMapping(value = "EPlantilla.htm",method=RequestMethod.GET)
    public String Plantilla(@RequestParam(value = "idE") int idE,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            List<presupuestosGrupo> ltaG=plantillaPresupuestoService.buscarPlantilla(idE);
            boolean r=false;
            int idPC=0;
            int rm2=0;
            for(presupuestosGrupo pg:ltaG){
            presupuestoc prec=new presupuestoc();
                    prec.setPropuesta_id(idP);
                    prec.setCapitulo_id(pg.getCapitulo_id());
                    
                    r=presupuestoCService.Insert(prec);
                    if(r==true){
                        idPC=presupuestoCService.ultimoPresupuestoC(prec.getPropuesta_id(), prec.getCapitulo_id());
                    }
                 
            
             for(presupuesto p : pg.getLtaSubcap()){
                 
                   // p.setPropuesta_id(idP);
                    p.setPresup_id(idPC);
                    presupuestosService.Insert(p);
                    if(p.getTipoCantidad().equals("m2")){
                            rm2++;
                    }
            }
             idPresC=idPC;
                if(rm2>0){
                        for(presupuesto_superficie supP:pg.getLtaSuperficies()){
                            
                            supP.setPresupuesto_id(idPC);
                            presupuestoSuperficiesService.Insert(supP);
                        }
                }
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EPresupuesto.htm?idP="+idP;  
    }*/
    //add presupuesto
    presupuestoc presupCap=null;
    @RequestMapping(value = "EaddPresupuesto.htm",method=RequestMethod.GET)
    public String addPresupuesto_get(ModelMap map,@RequestParam(value = "idP") int idP) {
        presupLta=new ArrayList<presupuestoJson>();
        presupCap=new presupuestoc();
        propuesta p=new propuesta();
        List<presupuestoc> ltaCapitulos=null;
        try{
            p=propuestasService.porId(idP);
            //presupCap.setPropuesta_id(idP);
            ltaCapitulos=presupuestoCService.presupuestoCapitulosADD(idP);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("presup",presupCap);
        map.addAttribute("ltaCapitulos",ltaCapitulos);
        return "EaddPresupuesto";
    }
    
    @RequestMapping(value = "EaddPresupuesto.htm",method=RequestMethod.POST)
    public String addPresupuesto_post(ModelMap map,@ModelAttribute("presup")presupuestoc presupr,BindingResult result) {
        
        try{
            presupCap=presupr;
            //System.out.println("prop"+presup.getPropuesta_id()+"capitulo: "+presup.getCapitulo_id().getId()+"- "+presup.getCapitulo_id().getNombre());
        }catch(Exception ex){            
        }
        
        //map.addAttribute("presup",presup);  
        return "redirect:EaddPresupuesto2.htm";
    }
    
    @RequestMapping("/EjsonAddPresupCap.htm")
    public @ResponseBody String jsonAddPresupCap(@RequestBody presupuestoc pre ){
        
        try{
            presupuestoCService.Insert(pre);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        
        return "success"; 
    }
    
    @RequestMapping("/EjsonDeletePresupCap.htm")
    public @ResponseBody String jsonDeletePresupCap(@RequestBody presupuestoc pre ){
        try{
            int idPre=presupuestoCService.ultimoPresupuestoCid(pre.getPropuesta_id(),pre.getCapitulo_id());
            List<presupuesto> p=presupuestosService.presupuestoSUBCapitulos(idPre);
            for(presupuesto pres:p){
               List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(pres.getId());
                for(presupuesto_superficie ps:lta){
                    List<presupuesto_superficies_panos> pppanos=presupuestoSuperficiesPanosService.findAll(ps.getId());
                    for(presupuesto_superficies_panos ppsa:pppanos){
                        presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(ppsa.getId());
                    }
                    presupuestoSuperficiesPanosService.DeletePorIdPSE(ps.getId());
                }
                presupuestoSuperficiesService.Delete(pres.getId());
            }
            presupuestoM2PanosService.DeletePresup(idPre);
            presupuestosService.DeleteU(idPre);
            presupuestoCService.DeletePC(pre.getPropuesta_id(),pre.getCapitulo_id());
        }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonAddPresupSubCap.htm")
    public @ResponseBody String jsonAddPresupSubCap(@RequestBody presupuesto pre ){
        
            subcapitulos sc=subCapitulosService.porId(pre.getIdSubCap());
            pre.setPrecio(sc.getCantidad());
            presupuestosService.Insert(pre);
      
        return "success"; 
    }
    
    
    @RequestMapping("/EjsonDeletePresupSubCap.htm")
    public @ResponseBody String jsonDeletePresupSubCap(@RequestBody presupuesto pre ){
        try{
            presupuesto p=presupuestosService.buscarPresupSC(pre.getPresup_id(),pre.getIdSubCap());
            
             presupuestoM2PanosService.DeleteidPresu(p.getId());
            List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(p.getId());
            for(presupuesto_superficie ps:lta){
                List<presupuesto_superficies_panos> pppanos=presupuestoSuperficiesPanosService.findAll(ps.getId());
                    for(presupuesto_superficies_panos ppsa:pppanos){
                        presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(ppsa.getId());
                    }
                presupuestoSuperficiesPanosService.DeletePorIdPSE(ps.getId());
            }
            presupuestoSuperficiesService.Delete(p.getId());
            presupuestosService.DeleteSC(pre.getPresup_id(),pre.getIdSubCap());
        }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonAddUpdMedida.htm")
    public @ResponseBody String jsonAddUpdPresupSubCap(@RequestBody presupuesto pre ){
        presupuesto p=new presupuesto();
            p=presupuestosService.buscarPresupSC(pre.getPresup_id(),pre.getIdSubCap());
            if(pre.getTipoCantidad().equals("und.")){
                System.out.println(""+pre.getPresup_id()+"-"+pre.getIdSubCap());
                
                List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(p.getId());
                for(presupuesto_superficie pres:lta){
                    List<presupuesto_superficies_panos> pppanos=presupuestoSuperficiesPanosService.findAll(pres.getId());
                    for(presupuesto_superficies_panos ppsa:pppanos){
                        presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(ppsa.getId());
                    }
                    presupuestoSuperficiesPanosService.DeletePorIdPSE(pres.getId());
                }
                presupuestoSuperficiesService.Delete(p.getId());
                presupuestoM2PanosService.DeleteidPresu(p.getId());
                p.setTipoCantidad("und.");
                p.setCantidad(0);
                p.setMonto(0);
                presupuestosService.Update(p);
            }else{
                System.out.println("m2 | ml");
                int id=presupuestoSuperficiesService.tieneRegistros(p.getId());
                if(id>0){
                    System.out.println("tiene registros");
                List<presupuesto_superficie> lta2=presupuestoSuperficiesService.findAll(p.getId());
                
                if(lta2.size()>0){
                    if(pre.getTipoCantidad().equals("m2")){
                        System.out.println("m2");
                        float suma=0;
                        for(presupuesto_superficie pres:lta2){
                            List<presupuesto_superficies_panos> Ltapanos=presupuestoSuperficiesPanosService.findAll(pres.getId());
                            for(presupuesto_superficies_panos lpp:Ltapanos){
                                panos pano=panosService.porID(lpp.getIdpano());
                               
                                if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                                    List<presupuesto_superficies_panos_vpa> LtapanosVPA=presupuestoSuperficiesPanosVPAService.findAll(lpp.getId());
                                    for(presupuesto_superficies_panos_vpa vpa:LtapanosVPA){
                                        if(vpa.getIdvpa()!=0){
                                            ventanas vent=ventanaService.porID(vpa.getIdvpa());
                                            suma=suma+vent.getSuperficie();
                                        }else if(vpa.getIdpuerta()!=0){
                                            puertas vent=puertasService.porID(vpa.getIdpuerta());
                                            suma=suma+vent.getSuperficie();
                                        }else if(vpa.getIdarmario()!=0){
                                            armarios vent=armariosService.porID(vpa.getIdarmario());
                                            suma=suma+vent.getSuperficie();
                                        }
                                    }
                                }else{
                                    suma=suma+pano.getSuperficie();
                                }
                            }
                        }
                        pre.setTipoCantidad("m2");
                        pre.setCantidad(suma);
                    }else if(pre.getTipoCantidad().equals("ml")){
                        System.out.println("ml");
                        float suma2=0;
                        for(presupuesto_superficie pres:lta2){
                            List<presupuesto_superficies_panos> Ltapanos=presupuestoSuperficiesPanosService.findAll(pres.getId());
                            for(presupuesto_superficies_panos lpp:Ltapanos){
                                System.out.println("pano");
                                panos pano=panosService.porID(lpp.getIdpano());
                                if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                                    List<presupuesto_superficies_panos_vpa> LtapanosVPA=presupuestoSuperficiesPanosVPAService.findAll(lpp.getId());
                                    for(presupuesto_superficies_panos_vpa vpa:LtapanosVPA){
                                        if(vpa.getIdvpa()!=0){
                                            ventanas vent=ventanaService.porID(vpa.getIdvpa());
                                            suma2=suma2+vent.getLargo();
                                        }else if(vpa.getIdpuerta()!=0){
                                            puertas vent=puertasService.porID(vpa.getIdpuerta());
                                            suma2=suma2+vent.getLargo();
                                        }else if(vpa.getIdarmario()!=0){
                                            armarios vent=armariosService.porID(vpa.getIdarmario());
                                            suma2=suma2+vent.getLargo();
                                        }
                                    }
                                }else{
                                    suma2=suma2+pano.getLargo();
                                }
                            }
                            System.out.println("estancia");
                        }
                        pre.setTipoCantidad("ml");
                        pre.setCantidad(suma2);
                    }
                    pre.setId(p.getId());
                    pre.setPrecio(p.getPrecio());
                    pre.setMonto(pre.getPrecio()*pre.getCantidad());
                    presupuestosService.UpdateM(pre);
                }else{
                    System.out.println("NO tiene registros");
                    p.setCantidad(0);
                    p.setMonto(0);
                    p.setTipoCantidad(pre.getTipoCantidad());
                    presupuestosService.Update(p);
                }
                }else{ 
                    p.setCantidad(0);
                    p.setMonto(0);
                    p.setTipoCantidad(pre.getTipoCantidad());
                    presupuestosService.Update(p);
                }
            }
            
            
        
        return "success"; 
    }
    
    @RequestMapping(value = "EaddPresupuesto2.htm",method=RequestMethod.GET)
    public String addPresupuesto2_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idC")int idC) {
        
        propuesta p=new propuesta();
        //List<capitulos> ltaCapitulos=null;
        capitulos cap=null;
        List<presupuesto> ltaSubCapitulos=null;
        List<presupuesto> ltaSubCapitulos2=new ArrayList<presupuesto>();
        int idPc=0;
        presupuestom2panos presm2=null;
        int res=0;
        try{
            p=propuestasService.porId(idP);
            idPc=presupuestoCService.ultimoPresupuestoCid(idP,idC);
            presup.setPresup_id(idPc);
            cap=capitulosService.porId(idC);
            ltaSubCapitulos=presupuestosService.presupuestoSUBCapitulosADD(idPc,idC);
            for(presupuesto pp:ltaSubCapitulos){
                int r=0;
                List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(pp.getId());
                if(lta.size()>0){
                    for(presupuesto_superficie ps:lta){
                        List<presupuesto_superficies_panos> ltapanos=presupuestoSuperficiesPanosService.findAll(ps.getId());
                        if(ltapanos.size()>0){
                            if(pp.getSubcapitulo().getId_capitulo().getId()==30 || pp.getSubcapitulo().getId_capitulo().getId()==31){
                                for(presupuesto_superficies_panos panosup:ltapanos){
                                List<presupuesto_superficies_panos_vpa> ltap=presupuestoSuperficiesPanosVPAService.findAll(panosup.getId());
                                    if(ltap.size()>0){
                                        r=1;
                                    }
                                }
                            }else  r=1;
                        }
                    }
                }
                pp.setTienePanosM2(r);
                
                ltaSubCapitulos2.add(pp);
            }
            res=presupuestoM2PanosService.buscar(idP);
            System.out.println("guradadoNO");
            if(res>0){
                presm2=presupuestoM2PanosService.porIdProp(idP);
                System.out.println("guradado"+presm2.getIdpresupuesto());
                presupuesto presupues=presupuestosService.porID(presm2.getIdpresupuesto());
                System.out.println("sub"+presupues.getSubcapitulo().getId());
                map.addAttribute("presm2",presupues.getSubcapitulo().getId());
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("idP",idP);
        map.addAttribute("presup",idPc);
        map.addAttribute("cap",cap);
       // map.addAttribute("ltaCapitulos",ltaCapitulos);
        map.addAttribute("ltaSubCapitulos",ltaSubCapitulos);
        map.addAttribute("res",res);
        return "EaddPresupuesto2";
    }
    @RequestMapping(value = "/EaddPresupuesto2.htm")    
    public @ResponseBody String addPresupuesto2_post(@RequestBody List<presupuestoJson> presupuestoJ){
       String ruta="";
        try{
           ruta="/Intranet/emp/EaddPresupuesto3.htm";
           int rU=0;
           int rM=0;
          for(presupuestoJson p : presupuestoJ){
              presupLta.add(p);
              if(p.getTipoCantidad().equals("und.")){
                 rU++;
              }else rM++;
          }
          if(rU!=0){
              ruta="/Intranet/emp/EaddPresupuesto3.htm";
          }else if(rM!=0){
              ruta="/Intranet/emp/EaddPresupuesto4.htm";
          }
       }catch(Exception ex){}
       return ruta;
    }
   /* @RequestMapping(value = "EaddPresupuesto2.htm",method=RequestMethod.POST)
    public String addPresupuesto2_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
        String redirec="";
        try{
            presup=presup2;
            presup.setSubcapitulo(subCapitulosService.porId(presup.getSubcapitulo().getId()));
            System.out.println("SUBCAPITULO: "+presup2.getSubcapitulo().getId()+" "+presup2.getSubcapitulo().getCantidad());
            if(presup.getTipoCantidad().equals("und.")){
                redirec="redirect:EaddPresupuesto3.htm";
            }else{
                redirec="redirect:EaddPresupuesto4.htm";
            }
        }catch(Exception ex){            
        }
        //map.addAttribute("presup",presup);  
        return redirec;
    }
    */
    @RequestMapping(value = "EaddPresupuesto3.htm",method=RequestMethod.GET)
    public String addPresupuesto3_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
        String ruta="";
        propuesta p=new propuesta();
        try{
            p=propuestasService.porId(idP);
            
            presup=presupuestosService.buscarPresupSC(idPre, idSC);
            if(presup.getTipoCantidad().equals("und.")){
                ruta="EaddPresupuesto3";            
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("p",p);
                map.addAttribute("presup",presup);
            }else  ruta="redirect:EaddPresupuesto4.htm?idP="+idP+"&idPre="+idPre+"&idSC="+idSC; 
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        return ruta;
    }
    int idPresC=0;
    @RequestMapping(value = "EaddPresupuesto3.htm",method=RequestMethod.POST)
    public String addPresupuesto3_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
       //String ruta="redirect:EPresupuesto.htm?idP="+presup2.getPropuesta_id();
        String ruta="redirect:EaddPresupuesto2.htm?idP="+presup2.getProp()+"&idC="+presup2.getCapitulo().getId();
        try{
            presupuestosService.Update(presup2); 
            
        }catch(Exception ex){            
        }
        //map.addAttribute("presup",presup);  
        return ruta;
    }
    
    @RequestMapping("EaddPresupuesto4.htm")
    public String addPresupuesto4(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
        propuesta p=new propuesta();
        List<estancias> ltaEstancias=null;
        presupuestoc pre=null;
        presupuesto pres1=null;
        //propuesta prop=new propuesta();
        try{
            pres1=presupuestosService.buscarPresupSC(idPre, idSC);
            pre=presupuestoCService.porid(idPre);
            ltaEstancias=estanciasService.listaEstanciasPresup(idP,pres1.getId());
            p=propuestasService.porId(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("ltaEstancias",ltaEstancias);
        map.addAttribute("idPre",idPre);
        map.addAttribute("idSC",idSC);
        map.addAttribute("idC",pre.getCapitulo_id());
        map.addAttribute("pres1",pres1.getId());
        return("EaddPresupuesto4");
        
    }
   
    @RequestMapping("/EjsonAddPresupEstanciaM2.htm")
    public @ResponseBody String jsonAddPresupEstanciaM2(@RequestBody presupuesto_superficie pre_sup ){
        
        try{
            presupuestoSuperficiesService.Insert(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        
        return "success"; 
    }
    @RequestMapping("/EjsonAddPresupEstanciaPanosM2.htm")
    public @ResponseBody String jsonAddPresupEstanciaPanosM2(@RequestBody presupuesto_superficies_panos pre_sup ){
        
        try{
            panos pano=panosService.porID(pre_sup.getIdpano());
            presupuestoSuperficiesPanosService.Insert(pre_sup);
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(pre_sup.getIdpresup_sup());
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()!=30 && p.getSubcapitulo().getId_capitulo().getId()!=31 ){
                float newsuperficie=pano.getLargo()*pre_sup.getLargo();
                if("m2".equals(p.getTipoCantidad()))
                p.setCantidad(p.getCantidad()+newsuperficie);
                else if("ml".equals(p.getTipoCantidad()))p.setCantidad(p.getCantidad()+pano.getLargo());
                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
          }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonAddPresupVentanasM2.htm")
    public @ResponseBody String jsonAddPresupVentanasM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
        
        try{
            ventanas v=ventanaService.porID(pre_sup.getIdvpa());
            presupuestoSuperficiesPanosVPAService.Insert(pre_sup);
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                p.setCantidad(p.getCantidad()+v.getSuperficie());
                else if("ml".equals(p.getTipoCantidad()))p.setCantidad(p.getCantidad()+v.getLargo());
                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
          }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonAddPresupPuertasM2.htm")
    public @ResponseBody String EjsonAddPresupPuertasM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
        
        try{
            puertas v=puertasService.porID(pre_sup.getIdvpa());
            presupuestoSuperficiesPanosVPAService.InsertP(pre_sup);
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                p.setCantidad(p.getCantidad()+v.getSuperficie());
                else if("ml".equals(p.getTipoCantidad()))p.setCantidad(p.getCantidad()+v.getLargo());
                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
          }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonAddPresupArmariosM2.htm")
    public @ResponseBody String EjsonAddPresupArmariosM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
        
        try{
            armarios v=armariosService.porID(pre_sup.getIdvpa());
            presupuestoSuperficiesPanosVPAService.InsertA(pre_sup);
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                p.setCantidad(p.getCantidad()+v.getSuperficie());
                else if("ml".equals(p.getTipoCantidad()))p.setCantidad(p.getCantidad()+v.getLargo());
                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
          }catch(Exception ex){}
        return "success"; 
    }
    
    @RequestMapping("/EjsonDeletePresupVentanasM2.htm")
    public @ResponseBody String jsonDeletePresupVentanasM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
       try{
            ventanas v=ventanaService.porID(pre_sup.getIdvpa());
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getSuperficie());
                if("ml".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getLargo());

                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
            //presupuesto_superficie psup=presupuestoSuperficiesService.buscar(pre_sup);
            presupuestoSuperficiesPanosVPAService.DeleteID(pre_sup.getIdvpa(),pre_sup.getIdpresup_sup_pano());
            //presupuestoSuperficiesService.DeleteEstancia(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonDeletePresupPuertasM2.htm")
    public @ResponseBody String EjsonDeletePresupPuertasM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
       try{
            puertas v=puertasService.porID(pre_sup.getIdpuerta());
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getSuperficie());
                if("ml".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getLargo());

                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
            //presupuesto_superficie psup=presupuestoSuperficiesService.buscar(pre_sup);
            System.out.println("puerta:"+pre_sup.getIdpuerta()+"presup_pano"+pre_sup.getIdpresup_sup_pano());
            presupuestoSuperficiesPanosVPAService.DeleteIDPuerta(pre_sup.getIdpuerta(),pre_sup.getIdpresup_sup_pano());
            //presupuestoSuperficiesService.DeleteEstancia(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonDeletePresupArmariosM2.htm")
    public @ResponseBody String EjsonDeletePresupArmariosM2(@RequestBody presupuesto_superficies_panos_vpa pre_sup ){
       try{
            armarios v=armariosService.porID(pre_sup.getIdarmario());
            int idpsp=presupuestoSuperficiesPanosService.buscaridPresupSup(pre_sup.getIdpresup_sup_pano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(idpsp);
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                if("m2".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getSuperficie());
                if("ml".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-v.getLargo());

                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
            //presupuesto_superficie psup=presupuestoSuperficiesService.buscar(pre_sup);
            presupuestoSuperficiesPanosVPAService.DeleteIDArmario(pre_sup.getIdarmario(),pre_sup.getIdpresup_sup_pano());
            //presupuestoSuperficiesService.DeleteEstancia(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        return "success"; 
    }
    
    @RequestMapping("/EjsonDeletePresupEstanciaM2.htm")
    public @ResponseBody String jsonDeletePresupEstanciaM2(@RequestBody presupuesto_superficie pre_sup ){
        try{
            presupuesto_superficie psup=presupuestoSuperficiesService.buscar(pre_sup);
            List<presupuesto_superficies_panos> lta=presupuestoSuperficiesPanosService.findAll(psup.getId());
            presupuesto p=presupuestosService.porID(psup.getPresupuesto_id());
            for(presupuesto_superficies_panos pssp:lta){
                
                if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                    List<presupuesto_superficies_panos_vpa> ltavpa=presupuestoSuperficiesPanosVPAService.findAll(pssp.getId());
                    for(presupuesto_superficies_panos_vpa vpa:ltavpa){
                        if(vpa.getIdvpa()!=0){
                            ventanas ve=ventanaService.porID(vpa.getIdvpa());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }else if(vpa.getIdpuerta()!=0){
                            puertas ve=puertasService.porID(vpa.getIdpuerta());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }else if(vpa.getIdarmario()!=0){
                            armarios ve=armariosService.porID(vpa.getIdarmario());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }
                    }
                     presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(pssp.getId());
                }else{
                    panos pano=panosService.porID(pssp.getIdpano());
                    presupuesto_superficies_panos objidpsp=presupuestoSuperficiesPanosService.buscarID(pssp.getId());
                    float newsuperficie=pano.getLargo()*objidpsp.getLargo();
                    if("m2".equals(p.getTipoCantidad()))
                        p.setCantidad(p.getCantidad()-newsuperficie);
                    if("ml".equals(p.getTipoCantidad()))
                        p.setCantidad(p.getCantidad()-pano.getLargo());
                }
            }
            p.setMonto(p.getPrecio()*p.getCantidad());
            presupuestosService.Update(p);
            
            presupuestoSuperficiesPanosService.DeletePorIdPSE(psup.getId());
            presupuestoSuperficiesService.DeleteEstancia(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        return "success"; 
    }
    @RequestMapping("/EjsonDeletePresupEstanciaPanosM2.htm")
    public @ResponseBody String jsonDeletePresupEstanciaPanosM2(@RequestBody presupuesto_superficies_panos pre_sup ){
        try{
           panos pano=panosService.porID(pre_sup.getIdpano());
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(pre_sup.getIdpresup_sup());
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            int idpsp=presupuestoSuperficiesPanosService.buscar(pre_sup.getIdpano(),pre_sup.getIdpresup_sup());
            if(p.getSubcapitulo().getId_capitulo().getId()==30 || p.getSubcapitulo().getId_capitulo().getId()==31){
                List<presupuesto_superficies_panos_vpa> lta=presupuestoSuperficiesPanosVPAService.findAll(idpsp);
                for(presupuesto_superficies_panos_vpa vpa:lta){
                        if(vpa.getIdvpa()!=0){
                            ventanas ve=ventanaService.porID(vpa.getIdvpa());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }else if(vpa.getIdpuerta()!=0){
                            puertas ve=puertasService.porID(vpa.getIdpuerta());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }else if(vpa.getIdarmario()!=0){
                            armarios ve=armariosService.porID(vpa.getIdarmario());
                            if("m2".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getSuperficie());
                            if("ml".equals(p.getTipoCantidad()))
                                p.setCantidad(p.getCantidad()-ve.getLargo());
                        }
                    
                    
                }
                presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(idpsp);
            }else{
                
                presupuesto_superficies_panos objidpsp=presupuestoSuperficiesPanosService.buscarID(idpsp);
                float newsuperficie=pano.getLargo()*objidpsp.getLargo();
                if("m2".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-newsuperficie);
                if("ml".equals(p.getTipoCantidad()))
                    p.setCantidad(p.getCantidad()-pano.getLargo());
            }
            p.setMonto(p.getPrecio()*p.getCantidad());
            presupuestosService.Update(p);
            //presupuesto_superficie psup=presupuestoSuperficiesService.buscar(pre_sup);
            presupuestoSuperficiesPanosService.DeleteID(pre_sup.getIdpano(),pre_sup.getIdpresup_sup());
            //presupuestoSuperficiesService.DeleteEstancia(pre_sup);
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        return "success"; 
    }
     @RequestMapping(value = "EaddPresupuesto5.htm",method=RequestMethod.GET)
    public String addPresupuesto5_get(ModelMap map,@RequestParam(value = "idE") int idE,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC,@RequestParam(value = "idPresup") int idPresup) {
        propuesta p=new propuesta();
        List<panos> ltaPanos=null;
        List<panos> ltaPanos2=new ArrayList<panos>();
        presupuesto_superficie psup=new presupuesto_superficie();
        presupuesto_superficie ps=null;
        //propuesta prop=new propuesta();
        try{
            p=propuestasService.porId(idP);
            ps=new presupuesto_superficie();
            ps.setEstancia(idE);
            ps.setPresupuesto_id(idPresup);
            presupuesto pres=presupuestosService.porID(idPresup);
            if(pres.getSubcapitulo().getId_capitulo().getId()==30 || pres.getSubcapitulo().getId_capitulo().getId()==31){
                map.addAttribute("vpa",1);
            }else map.addAttribute("vpa",0);
            psup=presupuestoSuperficiesService.buscar(ps);
            ltaPanos=panosService.findAllPresupSuperf(idE,psup.getId());
            //p=propuestasService.porId(presup.getPropuesta_id());
           for(panos lta:ltaPanos){
               if(lta.getAgeregado()==1){ 
                   System.out.println("dd"+psup.getId()+"pano:"+lta.getId());
               int r=presupuestoSuperficiesPanosService.buscar(lta.getId(), psup.getId());
               
                presupuesto_superficies_panos obj=presupuestoSuperficiesPanosService.buscarID(r);
                lta.setLargopresupuesto(obj.getLargo());
                }else lta.setLargopresupuesto(lta.getAlto());
                ltaPanos2.add(lta);
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("ltaPanos",ltaPanos2);
         map.addAttribute("idPre",idPre);
        map.addAttribute("idSC",idSC);
        map.addAttribute("idE",idE);
        map.addAttribute("idPresup",idPresup);
        map.addAttribute("idpresup_sup",psup.getId());
        return("EaddPresupuesto5");
    }
    @RequestMapping(value = "EaddPresupuesto6.htm",method=RequestMethod.GET)
    public String addPresupuesto6_get(ModelMap map,@RequestParam(value = "idE") int idE,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC,@RequestParam(value = "idPresup") int idPresup,@RequestParam(value = "idPsp") int idPsp,@RequestParam(value = "idPano") int idPano) {
        propuesta p=new propuesta();
        List<ventanas> ltaVentanas=null;
        List<puertas> ltaPuertas=null;
        List<armarios> ltaArmarios=null;
        int idPresp=0;
        //propuesta prop=new propuesta();
     try{
           p=propuestasService.porId(idP);
           idPresp= presupuestoSuperficiesPanosService.buscar(idPano, idPsp);
            System.out.println("idp"+idPresp+"pano"+idPano);
            ltaVentanas=ventanaService.findAllPresupSuperficies(idPano,idPresp);
            ltaPuertas=ventanaService.findAllPresupSuperficiesP(idPano,idPresp);
            ltaArmarios=ventanaService.findAllPresupSuperficiesA(idPano,idPresp);
            
     }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("ltaVentanas",ltaVentanas);
        map.addAttribute("ltaPuertas",ltaPuertas);
        map.addAttribute("ltaArmarios",ltaArmarios);
         map.addAttribute("idPre",idPre);
         map.addAttribute("idP",idP);
         map.addAttribute("idE",idE);
        map.addAttribute("idSC",idSC);
        map.addAttribute("idPresup",idPresup);
        map.addAttribute("idpresup_sup",idPsp);
        map.addAttribute("idPresp",idPresp);
        return("EaddPresupuesto6");
    }
    @RequestMapping(value = "EaddPresupuesto7.htm",method=RequestMethod.GET)
    public String addPresupuesto7_get(ModelMap map,@RequestParam(value = "idPano") int idPano,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
       //presup.setCantidad(0);
       /*sum=0;
        presupuesto_superficie psup=new presupuesto_superficie();
        try{
           psup.setPano_id(panosService.porID(idPano));
            psup.setEstancia_id(psup.getPano_id().getEstancia_id());
            
            int i=0;
            for(presupuesto_superficie plta:presupSupLista){
                if(plta.getPano_id().getId()==idPano){
                     plta.setAgeregado(0);
                         presupSupLista.set(i,plta);
                    //presupSupLista.remove(plta);
                }
                i++;
            }
            
            sum=0;
            System.out.println("SUMA 0: "+sum);
            for(presupuesto_superficie plta:presupSupLista){
                if(plta.getAgeregado()==1){
                sum=sum+plta.getPano_id().getSuperficie();
                }
            }
            psup.getPano_id().getSuperficie();
                presup.setCantidad(sum);
            //presupuestoSuperficiesService16 6 37
        }catch(Exception ex){            
        }*/
        //map.addAttribute("presup",presup);  
        return "";
    }
    
    
      @RequestMapping(value = "EaddPresupuestoG.htm",method=RequestMethod.GET)
    public String addPresupuestoG_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
        String ruta="EaddPresupuestoG";
        propuesta p=new propuesta();
        //List<capitulos> ltaCapitulos=null;
       // List<subcapitulos> ltaSubCapitulos=null;
        try{
            int s=0;
            presupuesto presup=presupuestosService.buscarPresupSC(idPre, idSC);
            List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(presup.getId());
            if(lta.size()>0){
                for(presupuesto_superficie ps:lta){
                    List<presupuesto_superficies_panos> ltapp=presupuestoSuperficiesPanosService.findAll(ps.getId());
                    
                    if(ltapp.size()>0){
                        s=1;
                        break;
                    }
                }
            }
            
            if(s==0){
                ruta="redirect:EaddPresupuesto4.htm?idP="+idP+"&idPre="+idPre+"&idSC="+idSC;
            }else{
            estancias e=new estancias();
            e.setId(0);
            p=propuestasService.porId(idP);
            
            String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
            map.addAttribute("p",p);
            map.addAttribute("presup",presup);
            map.addAttribute("idP",idP);
            map.addAttribute("idPre",idPre);
            map.addAttribute("idSC",idSC);
            /*presup.setEstancia_id(e);
            p=propuestasService.porId(presup.getPropuesta_id());
            presup.setCapitulo_id(capitulosService.porId(presup.getCapitulo_id().getId()));
            presup.setTipoCantidad("m2");
            */
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        return ruta;
    }
    
    @RequestMapping(value = "EaddPresupuestoG.htm",method=RequestMethod.POST)
    public String addPresupuestoG_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
       try{
            
             presupuestosService.Update(presup2);
            
                
        }catch(Exception ex){            
        }
        //map.addAttribute("presup",presup);  
        //return "redirect:EPresupuesto.htm?idP="+presup2.getPropuesta_id();
        return "redirect:EaddPresupuesto2.htm?idP="+presup2.getProp()+"&idC="+presup2.getCapitulo().getId(); 
    }
    
    
    
    
    //update Presupuesto
    @RequestMapping(value = "EupdatePresupuesto.htm",method=RequestMethod.GET)
    public String updatePresupuesto_get(ModelMap map,@RequestParam(value = "idPres") int idP) {
        presup=new presupuesto();
        
        propuesta p=new propuesta();
        List<capitulos> ltaCapitulos=null;
        try{
            
            presup=presupuestosService.porID(idP);
            
            //p=propuestasService.porId(presup.getPropuesta_id());
            ltaCapitulos=capitulosService.findAll("");
            presupSupLista=presupuestoSuperficiesService.findAll(idP);
            System.out.println("idPRe :"+idP);
            List<presupuesto_superficie> lta2=new ArrayList<presupuesto_superficie>();
            for(presupuesto_superficie pp:presupSupLista){
                System.out.println("lista de super ya existente:");
               pp.setAgeregado(1);
               lta2.add(pp);
           }
            presupSupLista=lta2;
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("presup",presup);
        map.addAttribute("ltaCapitulos",ltaCapitulos);
        return "EupdatePresupuesto";
    }
    
    @RequestMapping(value = "EupdatePresupuesto.htm",method=RequestMethod.POST)
    public String updatePresupuesto_post(ModelMap map,@ModelAttribute("presup")presupuesto presupr,BindingResult result) {
        
        try{
            presup=presupr;
           // System.out.println("prop"+presup.getPropuesta_id()+"capitulo: "+presup.getCapitulo_id().getId()+"- "+presup.getCapitulo_id().getNombre());
        }catch(Exception ex){            
        }
        return "redirect:EupdatePresupuesto2.htm";
    }
    int idPresUpd=0;
    int idPropUpd=0;
    @RequestMapping(value = "EupdatePresupuesto2.htm",method=RequestMethod.GET)
    public String updatePresupuesto2_get(ModelMap map,@RequestParam(value = "idPres") int idPres,@RequestParam(value = "idP") int idP) {
        propuesta p=new propuesta();
        presupuestoc presc=null;
        List<presupuesto> ltaPresupuestos=null;
        List<subcapitulos> ltaSubCap=null;
        try{
            presupLta=new ArrayList<presupuestoJson>();
            int rm2=0;
            idPresUpd=idPres;
            idPropUpd=idP;
            ltaPresupuestos=presupuestoCService.presupuestos(idPres);
            p=propuestasService.porId(idP);
            presc=presupuestoCService.porid(idPres);
            ltaSubCap=subCapitulosService.filtro(presc.getCapitulo_id());
            for(presupuesto prem2:ltaPresupuestos){
                if(prem2.getTipoCantidad().equals("m2")){
                    rm2++;
                }
            }
            if(rm2>0){
                presupSupLista=presupuestoSuperficiesService.findAll(idPres);
                List<presupuesto_superficie> lta2=new ArrayList<presupuesto_superficie>();
                for(presupuesto_superficie pp:presupSupLista){
                    System.out.println("lista de super ya existente:");
                   pp.setAgeregado(1);
                   lta2.add(pp);
               }
            presupSupLista=lta2;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("presc",presc);
        map.addAttribute("ltaPresupuestos",ltaPresupuestos);
        map.addAttribute("ltaSubCap",ltaSubCap);
        return "EupdatePresupuesto2";
    }
    
    @RequestMapping(value = "/EupdatePresupuesto2.htm")    
    public @ResponseBody String updatePresupuesto2_post(@RequestBody List<presupuestoJson> presupuestoJ){
       String ruta="";
        try{
           ruta="/Intranet/emp/EupdatePresupuesto3.htm";
           int rU=0;
           int rM=0;
          for(presupuestoJson p : presupuestoJ){
              presupLta.add(p);
              if(p.getTipoCantidad().equals("und.")){
                 rU++;
              }else rM++;
          }
          if(rU!=0){
              ruta="/Intranet/emp/EupdatePresupuesto3.htm";
          }else if(rM!=0){
              ruta="/Intranet/emp/EupdatePresupuesto4.htm";
          }
       }catch(Exception ex){}
       return ruta;
    }
    /*@RequestMapping(value = "EupdatePresupuesto2.htm",method=RequestMethod.POST)
    public String updatePresupuesto2_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
        String redirec="";
        try{
            //presup=presup2;
            presup.setTipoCantidad(presup2.getTipoCantidad());
            if(presup2.getTipoCantidad().equals("und.")){
                redirec="redirect:EupdatePresupuesto3.htm";
            }else{
                redirec="redirect:EupdatePresupuesto4.htm";
            }
             System.out.println("ID Presupueso: "+presup.getId());
        }catch(Exception ex){            
        }  
        return redirec;
    }
    */
    @RequestMapping(value = "EupdatePresupuesto3.htm",method=RequestMethod.GET)
    public String updatePresupuesto3_get(ModelMap map) {
        presupuestoc prec=new presupuestoc();
        propuesta p=new propuesta();
        try{
            prec=presupuestoCService.porid(idPresUpd);
            p=propuestasService.porId(idPropUpd);
            //presup.setTipoCantidad("und.");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("prec",prec);
        return "EupdatePresupuesto3";
    }
    
    @RequestMapping(value = "EupdatePresupuesto3.htm",method=RequestMethod.POST)
    public String updatePresupuesto3_post(ModelMap map,@ModelAttribute("prec")presupuestoc presup2,BindingResult result) {
       String ruta="redirect:EPresupuesto.htm?idP="+presup2.getPropuesta_id();
        try{
            int rM=0;
            
            estancias e=new estancias();
            e.setId(0);
            //presup.setEstancia_id(e);
            if(presupLta.size()!=0){
                
            if(presupuestoCService.Upd(presup2)==true){
                //presupuestoSuperficiesService.Delete(presup2.getId());
                 presupuestosService.DeleteU(presup2.getId());
            for(presupuestoJson p : presupLta){
                System.out.println(""+p.getTipoCantidad()+"."+p.getIdSubCap());
                if(p.getTipoCantidad().equals("und.")){
                   
                    System.out.println("unidad"+p.getIdSubCap());
                    subcapitulos s=subCapitulosService.porId(p.getIdSubCap());
                    capitulos cap=capitulosService.porId(p.getIdCap());
                    presupuesto pre=new presupuesto();
                   // pre.setPropuesta_id(presup2.getPropuesta_id());
                   // pre.setCapitulo_id(cap);
                    pre.setSubcapitulo(s);
                    pre.setTipoCantidad("und.");
                    pre.setPrecio(s.getCantidad());
                    //pre.setCantidad(presup2.getCantidad());
                    pre.setMonto(pre.getCantidad()*pre.getPrecio());
                    pre.setPresup_id(presup2.getId());
                    //if(presupuestosService.buscar(presup2)==0){
                        presupuestosService.Insert(pre);                
                    //}
                }else{ rM++;}
            }
            if(rM!=0){
                ruta="redirect:EupdatePresupuesto4.htm";
            }else{
                presupuestoSuperficiesService.Delete(presup2.getId());
                presupuestosService.Delete(presup2.getId());
            presup=new presupuesto();
            presupSupLista=new ArrayList<presupuesto_superficie>();
            sum=0;
            presupLta=new ArrayList<presupuestoJson>();
            idPresUpd=0;
            idPropUpd=0;
            }
            }
            }else{
            presup=new presupuesto();
            presupSupLista=new ArrayList<presupuesto_superficie>();
            sum=0;
            presupLta=new ArrayList<presupuestoJson>();
            idPresUpd=0;
            idPropUpd=0;
            }
        }catch(Exception ex){            
        }
        return ruta;
    }
    
    @RequestMapping("EupdatePresupuesto4.htm")
    public String updatePresupuesto4(ModelMap map) {
        propuesta p=new propuesta();
        List<estancias> ltaEstancias=null;
        try{
            ltaEstancias=estanciasService.listaPropuesta(idPropUpd);
            p=propuestasService.porId(idPropUpd);
           
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("idPropUpd",idPropUpd);
        map.addAttribute("idPresUpd",idPresUpd);
        map.addAttribute("ltaEstancias",ltaEstancias);
        return("EupdatePresupuesto4");
        
    }
   
    
     @RequestMapping(value = "EupdatePresupuesto5.htm",method=RequestMethod.GET)
    public String updatePresupuesto5_get(ModelMap map,@RequestParam(value = "idE") int idE) {
        propuesta p=new propuesta();
        estancias es=null;
        List<panos> ltaPanos=null;
        try{
            p=propuestasService.porId(idPropUpd);
            estancia=estanciasService.porID(idE);
            ltaPanos=panosService.findAll(idE);
           
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
         
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("presupSupLista",presupSupLista);
        map.addAttribute("estancia",estancia);
        map.addAttribute("ltaPanos",ltaPanos);
        map.addAttribute("idE",idE);
        return("EupdatePresupuesto5");
    }
    
    @RequestMapping(value = "EupdatePresupuesto6.htm",method=RequestMethod.GET)
    public String updatePresupuesto6_get(ModelMap map,@RequestParam(value = "idPano") int idPano,@RequestParam(value = "idE") int idE) {
       /*presup.setCantidad(0);
        presupuesto_superficie psup=new presupuesto_superficie();
        try{
            System.out.println("1: ");
            psup.setPano_id(panosService.porID(idPano));
            psup.setEstancia_id(psup.getPano_id().getEstancia_id());
            psup.setPresupuesto_id(0);
            int r=1;
            for(presupuesto_superficie plta:presupSupLista){
                if(Objects.equals(plta.getEstancia_id().getId(), psup.getEstancia_id().getId()) ){
                    if(Objects.equals(plta.getPano_id().getId(), psup.getPano_id().getId())){
                        if(plta.getAgeregado()==0){
                             r=3;
                         }else{
                            r=2;
                         }
                        //presup.setCantidad(sum);
                        //presup.setMonto(presup.getCantidad()*presup.getSubcapitulo().getCantidad());
                    }
                }
                
            }
           if(r==1){
                sum=0;
                psup.setAgeregado(1);
                presupSupLista.add(psup);
                 for(presupuesto_superficie plta:presupSupLista){
                     if(plta.getAgeregado()==1){
                     sum=sum+plta.getPano_id().getSuperficie();
                     }
                 }
                
                
                psup.getPano_id().getSuperficie();
                float d=presup.getCantidad();
                //sum=sum+psup.getPano_id().getSuperficie();
                presup.setCantidad(sum);
                
            }else if(r==2){
                sum=0;
                 for(presupuesto_superficie plta:presupSupLista){
                     if(plta.getAgeregado()==1){
                     sum=sum+plta.getPano_id().getSuperficie();
                     }
                 }
                // presupSupLista.add(psup);
                psup.getPano_id().getSuperficie();
                float d=presup.getCantidad();
                //sum=sum+psup.getPano_id().getSuperficie();
                presup.setCantidad(sum);
                
            }else if(r==3){
                sum=0;
                int i=0;
                for(presupuesto_superficie plta:presupSupLista){
                     if(plta.getPano_id().getId()==idPano){
                         plta.setAgeregado(1);
                         presupSupLista.set(i,plta);
                     }
                     i++;
                 }
                 for(presupuesto_superficie plta:presupSupLista){
                     if(plta.getAgeregado()==1){
                     sum=sum+plta.getPano_id().getSuperficie();
                     }
                 }
                // presupSupLista.add(psup);
                psup.getPano_id().getSuperficie();
                float d=presup.getCantidad();
                //sum=sum+psup.getPano_id().getSuperficie();
                presup.setCantidad(sum);
                
            }
             System.out.println("ID Presupueso: "+presup.getId());
        }catch(Exception ex){            
        } */
        return "";
    }
    
    @RequestMapping(value = "EupdatePresupuesto7.htm",method=RequestMethod.GET)
    public String updatePresupuesto7_get(ModelMap map,@RequestParam(value = "idPano") int idPano,@RequestParam(value = "idE") int idE) {
       //presup.setCantidad(0);
       /*sum=0;
        presupuesto_superficie psup=new presupuesto_superficie();
        try{
           psup.setPano_id(panosService.porID(idPano));
            psup.setEstancia_id(psup.getPano_id().getEstancia_id());
            int i=0;
            for(presupuesto_superficie plta:presupSupLista){
                if(plta.getPano_id().getId()==idPano){
                     plta.setAgeregado(0);
                         presupSupLista.set(i,plta);
                    
                }
                i++;
            }
            sum=0;
            System.out.println("SUMA 0: "+sum);
            for(presupuesto_superficie plta:presupSupLista){
                if(plta.getAgeregado()==1){
                sum=sum+plta.getPano_id().getSuperficie();
                }
                System.out.println("nueva : "+sum);
            }
            psup.getPano_id().getSuperficie();
            System.out.println("pano: "+psup.getPano_id().getSuperficie());
                presup.setCantidad(sum);
            //presupuestoSuperficiesService16 6 37
        }catch(Exception ex){            
        }*/
        //map.addAttribute("presup",presup);  
        return "";
    }
    
      @RequestMapping(value = "EupdatePresupuestoG.htm",method=RequestMethod.GET)
    public String updatePresupuestoG_get(ModelMap map,@RequestParam(value = "idE") int idE) {
        String ruta="EupdatePresupuestoG";
        propuesta p=new propuesta();
        
        try{
            int s=0;
            for(presupuesto_superficie pps:presupSupLista){
                if(pps.getAgeregado()==1){
                    s=s+1;
                }
            }
            if(s==0){
                ruta="redirect:EupdatePresupuesto5.htm?idE="+estancia.getId();
            }else{
            estancias e=new estancias();
            e.setId(0);
            presupuestoc prec=presupuestoCService.porid(idPresUpd);
                //idPropUpd=0;
                //prec.setCantidadmetros(presup.getCantidad());
                //presup.setEstancia_id(e);
                p=propuestasService.porId(idPropUpd);
                //presup.setCapitulo_id(capitulosService.porId(presup.getCapitulo_id().getId()));
                //presup.setTipoCantidad("m2");
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                    map.addAttribute("p",p);
                    map.addAttribute("estancia",estancia);
                    map.addAttribute("prec",prec);
                    map.addAttribute("idE",idE);
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        return ruta;
    }
    
    @RequestMapping(value = "EupdatePresupuestoG.htm",method=RequestMethod.POST)
    public String updatePresupuestoG_post(ModelMap map,@ModelAttribute("prec")presupuestoc presup2,BindingResult result) {
       
        try{
            int rm2=0;
            estancias e=new estancias();
            e.setId(0);
            //presup.setEstancia_id(e);
            if(presupLta.size()!=0){
                
            if(presupuestoCService.Upd(presup2)==true){
               int ru=0;
               presupuestoSuperficiesService.Delete(presup2.getId());
                    presupuestosService.Delete(presup2.getId());
                for(presupuestoJson p : presupLta){
                    if(p.getTipoCantidad().equals("und.")){
                        ru++;
                    }
               }
                if(ru==0){
                    presupuestosService.DeleteU(presup2.getId());
                }
                    
               
             for(presupuestoJson p : presupLta){
                 System.out.println("-----------------------------"+p.getIdSubCap()+"."+p.getTipoCantidad());
                if(p.getTipoCantidad().equals("m2")){
                    subcapitulos s=subCapitulosService.porId(p.getIdSubCap());
                    capitulos cap=capitulosService.porId(p.getIdCap());
                    presupuesto pres=new presupuesto();
                    //pres.setCapitulo_id(cap);
                    pres.setSubcapitulo(s);
                    pres.setTipoCantidad("m2");
                    //pres.setPropuesta_id(presup2.getPropuesta_id());
                    //pres.setCantidad(presup2.getCantidad());
                    pres.setPrecio(s.getCantidad());
                    pres.setMonto(pres.getCantidad()*pres.getPrecio());
                    pres.setPresup_id(presup2.getId());
                   //if(presupuestosService.buscar(presup2)==0){
                        presupuestosService.Insert(pres);
                        
                        //pr=presupuestosService.porID(presupuestosService.buscar(pr));
                        
                    //}
                        rm2++;
                }
            }
                if(rm2>0){
                        for(presupuesto_superficie supP:presupSupLista){
                            supP.setPresupuesto_id(presup2.getId());
                            presupuestoSuperficiesService.Insert(supP);
                        }
                }
            }
            }
            presup=new presupuesto();
            presupSupLista=new ArrayList<presupuesto_superficie>();
            sum=0;
            presupLta=new ArrayList<presupuestoJson>();
        }catch(Exception ex){            
        }
        return "redirect:EPresupuesto.htm?idP="+presup2.getPropuesta_id();
    }
 
    
    
    @RequestMapping(value = "EdeletePresupuesto.htm",method=RequestMethod.GET)
    public String eliminarPresupuesto(@RequestParam(value = "idPres") int id,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            presupuestoSuperficiesService.Delete(id);
            if(presupuestosService.DeleteU(id)!=0){
                presupuestoCService.Delete(id);
                    presup=new presupuesto();
                    presupSupLista=new ArrayList<presupuesto_superficie>();
                    sum=0;
                   
            }

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EPresupuesto.htm?idP="+idP;  
    }
    @RequestMapping(value = "EasignarLtaGuardada.htm",method=RequestMethod.GET)
    public String asignarLtaGuardada(@RequestParam(value = "idP") int idP,@RequestParam(value = "idPre") int idPre,@RequestParam(value = "idSC") int idSC,ModelMap map) {
        String rpta="";
        
           presupuesto pres=presupuestosService.buscarPresupSC(idPre, idSC);
                if(pres.getTipoCantidad().equals("m2")){
                    System.out.println("m2");
                    int r=presupuestoM2PanosService.buscar(idP);
                    if(r>0){
                    presupuestom2panos prem2=presupuestoM2PanosService.porIdProp(idP);
                    
                    System.out.println("presupuestoM2"+prem2.getIdpresupuesto());
                    List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(prem2.getIdpresupuesto());
                    float metros=0;
                        for(presupuesto_superficie supP:lta){
                            
                            supP.setPresupuesto_id(pres.getId());
                            int idPresupSup=presupuestoSuperficiesService.buscarcount(supP);
                            if(idPresupSup==0) presupuestoSuperficiesService.Insert(supP);
                            
                            presupuesto_superficie presup_supE=presupuestoSuperficiesService.buscar(supP);
                            List<presupuesto_superficies_panos> ltaPanos=presupuestoSuperficiesPanosService.findAll(supP.getId());
                            for(presupuesto_superficies_panos pp:ltaPanos){
                                pp.setIdpresup_sup(presup_supE.getId());
                                int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pp.getIdpano(),pp.getIdpresup_sup());
                                if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(pp);
                                
                                int idPa=presupuestoSuperficiesPanosService.ultimo(pp.getIdpano(), pp.getIdpresup_sup());
                                panos pano=panosService.porID(pp.getIdpano());
                                if(pres.getSubcapitulo().getId_capitulo().getId()==30 || pres.getSubcapitulo().getId_capitulo().getId()==31){
                                   
                                    List<presupuesto_superficies_panos_vpa> ltaPanosVPA=presupuestoSuperficiesPanosVPAService.findAll(pp.getId());
                                    for(presupuesto_superficies_panos_vpa ppva:ltaPanosVPA){
                                        ppva.setIdpresup_sup_pano(idPa);
                                        
                                         if(ppva.getIdvpa()!=0){
                                            ventanas v=ventanaService.porID(ppva.getIdvpa());
                                            metros=metros+v.getSuperficie();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcount(ppva.getIdvpa(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.Insert(ppva);
                                        }else if(ppva.getIdpuerta()!=0){
                                            puertas p=puertasService.porID(ppva.getIdpuerta());
                                            metros=metros+p.getSuperficie();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountP(ppva.getIdpuerta(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.InsertP(ppva);
                                        }else if(ppva.getIdarmario()!=0){
                                            armarios ar=armariosService.porID(ppva.getIdarmario());
                                            metros=metros+ar.getSuperficie();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountA(ppva.getIdarmario(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.InsertA(ppva);
                                        }
                                        
                                    }
                                }else  metros=metros+pano.getSuperficie();
                            }
                            System.out.println("presu_superf");
                            
                            //metros=metros+supP.getPano_id().getSuperficie();
                        }
                        pres.setCantidad(metros);
                        pres.setPrecio(pres.getSubcapitulo().getCantidad());
                        pres.setMonto(pres.getCantidad()*pres.getPrecio());
                        presupuestosService.Update(pres);
                    }
                }else if(pres.getTipoCantidad().equals("ml")){
                    System.out.println("m2");
                    int r=presupuestoM2PanosService.buscar(idP);
                    if(r>0){
                    presupuestom2panos prem2=presupuestoM2PanosService.porIdProp(idP);
                    
                    System.out.println("presupuestoM2"+prem2.getIdpresupuesto());
                    List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(prem2.getIdpresupuesto());
                    float metros=0;
                        for(presupuesto_superficie supP:lta){
                            supP.setPresupuesto_id(pres.getId());
                            int idPresupSup=presupuestoSuperficiesService.buscarcount(supP);
                            if(idPresupSup==0) presupuestoSuperficiesService.Insert(supP);
                            presupuesto_superficie presup_supE=presupuestoSuperficiesService.buscar(supP);
                            List<presupuesto_superficies_panos> ltaPanos=presupuestoSuperficiesPanosService.findAll(supP.getId());
                            for(presupuesto_superficies_panos pp:ltaPanos){
                                pp.setIdpresup_sup(presup_supE.getId());
                                int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pp.getIdpano(),pp.getIdpresup_sup());
                                if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(pp);
                                
                                int idPa=presupuestoSuperficiesPanosService.ultimo(pp.getIdpano(), pp.getIdpresup_sup());
                                panos pano=panosService.porID(pp.getIdpano());
                                 if(pres.getSubcapitulo().getId_capitulo().getId()==30 || pres.getSubcapitulo().getId_capitulo().getId()==31){
                                   
                                    List<presupuesto_superficies_panos_vpa> ltaPanosVPA=presupuestoSuperficiesPanosVPAService.findAll(pp.getId());
                                    for(presupuesto_superficies_panos_vpa ppva:ltaPanosVPA){
                                        ppva.setIdpresup_sup_pano(idPa);
                                        if(ppva.getIdvpa()!=0){
                                            ventanas v=ventanaService.porID(ppva.getIdvpa());
                                            metros=metros+v.getLargo();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcount(ppva.getIdvpa(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.Insert(ppva);
                                        }else if(ppva.getIdpuerta()!=0){
                                            puertas p=puertasService.porID(ppva.getIdpuerta());
                                            metros=metros+p.getLargo();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountP(ppva.getIdpuerta(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.InsertP(ppva);
                                        }else if(ppva.getIdarmario()!=0){
                                            armarios ar=armariosService.porID(ppva.getIdarmario());
                                            metros=metros+ar.getLargo();
                                            int vpaid=presupuestoSuperficiesPanosVPAService.buscarcountA(ppva.getIdarmario(), ppva.getIdpresup_sup_pano());
                                            if(vpaid==0) presupuestoSuperficiesPanosVPAService.InsertA(ppva);
                                        }
                                        
                                    }
                                }else  metros=metros+pano.getLargo();
                            }
                            System.out.println("presu_superf");
                            
                            //metros=metros+supP.getPano_id().getSuperficie();
                        }
                        pres.setCantidad(metros);
                        pres.setPrecio(pres.getSubcapitulo().getCantidad());
                        pres.setMonto(pres.getCantidad()*pres.getPrecio());
                        presupuestosService.Update(pres);
                    }
                }
            


        
        
        return "redirect:EaddPresupuesto2.htm?idP="+idP+"&idC="+pres.getCapitulo().getId();  
    }
    
    
    @RequestMapping(value = "EdeletePresupuestoG.htm",method=RequestMethod.GET)
    public String eliminarPresupuestoG(@RequestParam(value = "idPres") int id,@RequestParam(value = "idP") int idP,@RequestParam(value = "idPP") int idPP,ModelMap map) {
        String rpta="";
        try{
            List<presupuesto_superficie> lta=presupuestoSuperficiesService.findAll(id);
            for(presupuesto_superficie ps:lta){
                List<presupuesto_superficies_panos> pppanos=presupuestoSuperficiesPanosService.findAll(ps.getId());
                    for(presupuesto_superficies_panos ppsa:pppanos){
                        presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(ppsa.getId());
                    }
                presupuestoSuperficiesPanosService.DeletePorIdPSE(ps.getId());
            }
            presupuestoSuperficiesService.Delete(id);
            presupuestoM2PanosService.DeleteidPresu(id);
            if(presupuestosService.DeleteP(id)!=0){
                presup=new presupuesto();
                presupSupLista=new ArrayList<presupuesto_superficie>();
                sum=0;
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverPresupuesto.htm?idPres="+idPP+"&idP="+idP;  
    }
    @RequestMapping(value = "EdeletePresupuestoGCap.htm",method=RequestMethod.GET)
    public String deletePresupuestoGCap(@RequestParam(value = "idPres") int id,@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            List<presupuesto> p=presupuestosService.presupuestoSUBCapitulos(id);
            for(presupuesto pres:p){
                List<presupuesto_superficie> ps=presupuestoSuperficiesService.findAll(pres.getId());
                for(presupuesto_superficie pps:ps){
                    List<presupuesto_superficies_panos> pppanos=presupuestoSuperficiesPanosService.findAll(pps.getId());
                    for(presupuesto_superficies_panos ppsa:pppanos){
                        presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(ppsa.getId());
                    }
                    
                    presupuestoSuperficiesPanosService.DeletePorIdPSE(pps.getId());
                }
                presupuestoSuperficiesService.Delete(pres.getId());
            }
            presupuestoM2PanosService.DeletePresup(id);
            presupuestosService.DeleteU(id);
            presupuestoCService.Delete(id);
        }catch(Exception ex){}
        return "redirect:EPresupuesto.htm?idP="+idP;  
    }
    @RequestMapping("EverPresupuesto.htm")
    public String verPresupuesto(@RequestParam(value = "idPres") int idPres,@RequestParam(value = "idP") int idP,ModelMap map) {
        List<presupuesto> presupues=new ArrayList<presupuesto>();
        propuesta prop=new propuesta();
        presupuestom2panos presm2=null;
        String ruta="";
        try{
            presupues=presupuestosService.presupuestoSUBCapitulos(idPres);
            prop=propuestasService.porId(idP);
            int r=presupuestoM2PanosService.buscar(idP);
             if(r>0){
                presm2=presupuestoM2PanosService.porIdProp(idP);
                map.addAttribute("presm2",presm2);
            }
           ruta="EverPresupuestoU";
            //empleado=empleadoService.ByNif(nif); 
            //prop=propuestasService.porId(idP);
            //ltaEstancias=estanciasService.listaPropuesta(idP);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",prop);
        map.addAttribute("idP",idP);
        map.addAttribute("idPres",idPres);
        map.addAttribute("presup",presupues);
        map.addAttribute("r",r);
        return(ruta);
        
    }
    @RequestMapping("EverPresupuestoSC.htm")
    public String verPresupuestoSC(@RequestParam(value = "idPres") int idPres,@RequestParam(value = "idP") int idP,@RequestParam(value = "idPP") int idPP,ModelMap map) {
        estancias ltaEstancias=null;
        List<presupuesto_superficie> ltapS=null;
        List<presupuesto_superficie> ltapS2=new ArrayList<presupuesto_superficie>();
        presupuesto presupues=new presupuesto();
        propuesta prop=new propuesta();
        String ruta="";
        try{
            presupues=presupuestosService.porID(idPres);
            prop=propuestasService.porId(idP);           
            ruta="EverPresupuestoSC";
            if(presupues.getTipoCantidad().equals("m2")){
                ltapS=presupuestoSuperficiesService.findAll(idPres);
                for(presupuesto_superficie ps:ltapS){
                    presupuesto_superficie obj=ps;
                    obj.setLta(presupuestoSuperficiesPanosService.findAllMostrar(ps.getId()));
                    List<presupuesto_superficies_panos> lta2p=new ArrayList<presupuesto_superficies_panos>();
                    for(presupuesto_superficies_panos pp:obj.getLta()){
                        pp.setLta(presupuestoSuperficiesPanosVPAService.findAllMostrar(pp.getId()));
                        pp.setLtap(presupuestoSuperficiesPanosVPAService.findAllMostrarP(pp.getId()));
                        pp.setLtaa(presupuestoSuperficiesPanosVPAService.findAllMostrarA(pp.getId()));
                        lta2p.add(pp);
                    }
                    obj.setLta(lta2p);
                    ltapS2.add(obj);
                }
                ltaEstancias=new estancias();
                for(presupuesto_superficie p:ltapS){
                    ltaEstancias=p.getEstancia_id();
                }
               
            }
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",prop);
        map.addAttribute("presup",presupues);
        map.addAttribute("idPres",idPres);
        map.addAttribute("idP",idP);
        map.addAttribute("ltaEstancias",ltaEstancias);
        map.addAttribute("ltaPanos",ltapS2);
        return(ruta);
        
    }
    @RequestMapping(value = "EcontratarPresupuesto.htm",method=RequestMethod.GET)
    public String contratarPresupuesto(@RequestParam(value = "idP") int idPr,ModelMap map) {
        String rpta="";
        try{
            propuesta p=propuestasService.porId(idPr);
            boolean res=presupuestoCService.presupPropuesta(idPr);
            if(res==true){
                if(p.getEstado()!=2){
                    System.out.println("estado1");
                    if(propuestasService.contrataraProyecto(p)!=0){
                        clientes c=clientesService.ByNif(p.getCliente_nif().getNif());
                        clientes pc=p.getCliente_nif();
                        pc.setEmail(c.getEmail());
                        p.setCliente_nif(pc);
                        System.out.println("mensaje");
                        mensajeContratoPropuesta m=new mensajeContratoPropuesta();
                        m.mensaje(p);
                        smsenvio(c.getNif(),"Se le ha enviado el Contrato de la Propuesta a su correo electronico: "+c.getEmail());
                        map.addAttribute("msg","contratado");
                    }else System.out.println("no contrata");

                }System.out.println("mensajeest2");
            }else{
                map.addAttribute("msg","error");
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverPropuestas.htm?nifC="+nifCli.getNif();  
    }
    
    @RequestMapping(value = "EenviarPresupuesto.htm",method=RequestMethod.GET)
    public String enviarPresupuesto(@RequestParam(value = "idP") int idPr,ModelMap map) {
        String rpta="";
        try{
            propuesta p=propuestasService.porId(idPr);
            boolean res=presupuestoCService.presupPropuesta(idPr);
            if(res==true){
                clientes c=clientesService.ByNif(p.getCliente_nif().getNif());
                clientes pc=p.getCliente_nif();
                pc.setEmail(c.getEmail());
                p.setCliente_nif(pc);
                presupuestoCService.UpdateEstado(idPr);
                List<presupuestoc> presupuestoLista=presupuestoCService.presupuestoCapitulos(idPr);
                mensajePresupuesto m=new mensajePresupuesto();
		m.mensaje(p,presupuestoLista);
                smsenvio(p.getCliente_nif().getNif(),"Se le ha enviado el Presupuesto a su correo electronico: "+pc.getEmail());
                 map.addAttribute("msg","success");
             }else{
                map.addAttribute("msg","error");
            }     

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverPropuestas.htm?nifC="+nifCli.getNif();  
    }
    
    @RequestMapping(value = "EverPresupuestoPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=new propuesta();
        String ruta="";
        try{
            boolean res=presupuestoCService.presupPropuesta(idPr);
            if(res==true){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
                
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idpropuesta", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\presupuesto\\presupuesto.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\propuestas\\presupuesto\\Presupuesto"+prop.getCliente_nif().getNif()+".pdf");
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("idP",idPr);
                ruta="EverPresupuestoPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif();
            }        
               
        
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping(value = "EverPresupuestoDescuentoPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoDescuentoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=new propuesta();
       String ruta="";
        try{
            boolean res=presupuestoCService.presupPropuesta(idPr);
            if(res==true){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idpropuesta", prop.getId());
                    params.put("desc", prop.getDescuentoproveedor()/100);
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\presupuestoD\\presupuesto.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\propuestas\\presupuestoD\\Presupuesto"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("idP",idPr);
                    ruta="EverPresupuestoDescuentoPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:EverPropuestas.htm?nifC="+prop.getCliente_nif().getNif();
            }        
        
        }catch(Exception e){

        }
        return(ruta);
    }
    @RequestMapping("EpdfPresupuesto.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idP") int idPr){
        propuesta prop=new propuesta();
        prop=propuestasService.porId(idPr);
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EpdfPresupuesto");        
        return mav;
    }
    
    @RequestMapping("EDescuentopdfPresupuesto.htm")
    public ModelAndView EDescuentopdfPresupuesto(ModelAndView mav,@RequestParam(value = "idP") int idPr){
        propuesta prop=new propuesta();
        prop=propuestasService.porId(idPr);
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("EDescuentopdfPresupuesto");        
        return mav;
    }
    
    @RequestMapping(value = "ERechazarPresupuesto.htm",method=RequestMethod.GET)
    public String RechazarPresupuesto(@RequestParam(value = "idP") int idPr,ModelMap map) {
        //propuesta prop=new propuesta();
        String rpta="";
        try{
            propuestasService.rechazar(idPr);
              

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverPropuestas.htm?nifC="+nifCli.getNif();  
    }
    
     @RequestMapping(value = "EActivarPresupuesto.htm",method=RequestMethod.GET)
    public String ActivarPresupuesto(@RequestParam(value = "idP") int idPr,ModelMap map) {
        //propuesta prop=new propuesta();
        String rpta="";
        try{
            propuestasService.activar(idPr);
              

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EverPropuestas.htm?nifC="+nifCli.getNif();  
    }
    
    @RequestMapping("/EPresupSupCap.json")    
    public @ResponseBody List<presupuesto> PresupSupCap(@RequestBody presupuestoJson p){
        List<presupuesto> ltaSubcapitulos=null;
        System.out.println("ooooo");
         System.out.println("ooooo"+p.getPropuesta_id()+"-"+p.getIdCap());
        try{
        ltaSubcapitulos=presupuestosService.subcapPresupuesto(p.getPropuesta_id(),p.getIdCap());
           
        }catch(Exception ex){
        }
        return ltaSubcapitulos;
    }
    
    
    
    
    
    
    @RequestMapping("/EjsonguardarPanosSelecAddPresup.htm")
    public @ResponseBody String jsonguardarPanosSelecAddPresup(@RequestBody presupuesto pre ){
        presupuestoc pp=new presupuestoc();
        try{
            pp=presupuestoCService.porid(pre.getPresup_id());
            presupuesto p=presupuestosService.buscarPresupSC(pre.getPresup_id(),pre.getIdSubCap());
            int r=presupuestoM2PanosService.buscar(p.getProp());
            if(r>0){
                System.out.println("existe en la propuesta");
            presupuestom2panos prem2=presupuestoM2PanosService.porIdProp(p.getProp());
            
                prem2.setIdpresupuesto(p.getId());
                System.out.println("upd");
                presupuestoM2PanosService.Update(prem2);
                System.out.println("upd2");
            }else{
                presupuestom2panos pm2=new presupuestom2panos(p.getId(),p.getProp());
                presupuestoM2PanosService.Insert(pm2);
            }
            
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        
        return "/Intranet/emp/EaddPresupuesto2.htm?idP="+pp.getPropuesta_id()+"&idC="+pp.getCapitulo_id(); 
    }
    @RequestMapping("/EjsonguardarPanosSelec.htm")
    public @ResponseBody String jsonguardarPanosSelec(@RequestBody presupuestom2panos pre ){
        
        try{
            int r=presupuestoM2PanosService.buscar(pre.getIdpropuesta());
            if(r>0){
                System.out.println("existe en la propuesta");
            presupuestom2panos prem2=presupuestoM2PanosService.porIdProp(pre.getIdpropuesta());
            
                prem2.setIdpresupuesto(pre.getIdpresupuesto());
                System.out.println("upd");
                presupuestoM2PanosService.Update(prem2);
                System.out.println("upd2");
            }else presupuestoM2PanosService.Insert(pre);
            
            //LtaPresupuestoCap.add(pre);
        }catch(Exception ex){}
        
        return "success"; 
    }
    
    @RequestMapping("/EjsonAddPresupEstanciaPanosM2Largo.htm")
    public @ResponseBody String jsonAddPresupEstanciaPanosM2Largo(@RequestBody presupuesto_superficies_panos pre_sup ){
        
        try{
            panos pano=panosService.porID(pre_sup.getIdpano());
            int idpsp=presupuestoSuperficiesPanosService.buscar(pre_sup.getIdpano(),pre_sup.getIdpresup_sup());
            presupuesto_superficies_panos objidpsp=presupuestoSuperficiesPanosService.buscarID(idpsp);
            presupuesto_superficie pre=presupuestoSuperficiesService.porID(pre_sup.getIdpresup_sup());
            presupuesto p=presupuestosService.porID(pre.getPresupuesto_id());
            if(p.getSubcapitulo().getId_capitulo().getId()!=30 && p.getSubcapitulo().getId_capitulo().getId()!=31){
                float newsuperficieAntes=pano.getLargo()*objidpsp.getLargo();
                float newsuperficieAhora=pano.getLargo()*pre_sup.getLargo();
                if("m2".equals(p.getTipoCantidad())){
                    p.setCantidad(p.getCantidad()-newsuperficieAntes);
                    p.setCantidad(p.getCantidad()+newsuperficieAhora);
                }else if("ml".equals(p.getTipoCantidad())){
                    p.setCantidad(p.getCantidad()-objidpsp.getLargo());
                    p.setCantidad(p.getCantidad()+pre_sup.getLargo());
                }
                p.setMonto(p.getPrecio()*p.getCantidad());
                presupuestosService.Update(p);
            }
                presupuestoSuperficiesPanosService.UpdateLargoPresup(pre_sup);
               
            
          }catch(Exception ex){}
        return "success"; 
    }
    
    @RequestMapping(value="/EjsonDescuentoPropuesta.json", method=RequestMethod.GET)
    public @ResponseBody propuesta loginDisponible(
                                        @RequestParam("idP") int idP,Principal principal) {
      String name=principal.getName();
      users u=null;
      propuesta data=null;
            try{
                data=propuestasService.porIdDescuento(idP);
                
            }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    
    @RequestMapping("/EDescuento.htm")
    public @ResponseBody String Descuento(@RequestBody propuesta p ){
        
        try{
            propuestasService.UpdateDescuento(p);
        }catch(Exception ex){}
        
        return "success"; 
    }
    
    private void smsenvio(String nif,String mensaje) {
       try{
           clientes cli =clientesService.ByNif(nif);
            //map.addAttribute("msg","success");
            HttpClient client = new HttpClient();
        client.setStrictMode(true);
        //Se fija el tiempo m´aximo de espera de la respuesta del servidor
        client.setTimeout(60000);
        //Se fija el tiempo m´aximo de espera para conectar con el servidor
        client.setConnectionTimeout(5000);
        PostMethod post = null;
        //Se fija la URL sobre la que enviar la petici´on POST
            //Como ejemplo la petici´on se env´ıa a www.altiria.net/sustituirPOSTsms
            //Se debe reemplazar la cadena ’/sustituirPOSTsms’ por la parte correspondiente
            //de la URL suministrada por Altiria al dar de alta el servicio
            post = new PostMethod("http://www.altiria.net/api/http");
            //Se fija la codificaci´on de caracteres en la cabecera de la petici´on
            post.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded; charset=UTF-8");
            //Se crea la lista de par´ametros a enviar en la petici´on POST
            NameValuePair[] parametersList = new NameValuePair[6];
            //XX, YY y ZZ se corresponden con los valores de identificaci´on del
            //usuario en el sistema.
            parametersList[0] = new NameValuePair("cmd", "sendsms");
            parametersList[1] = new NameValuePair("domainId", "comercial");
            parametersList[2] = new NameValuePair("login", "jfruano");
            parametersList[3] = new NameValuePair("passwd", "wrnkmekt");
            parametersList[4] = new NameValuePair("dest", "34"+cli.getTelefono());
            parametersList[5] = new NameValuePair("msg", ""+mensaje);
            //Se rellena el cuerpo de la petici´on POST con los par´ametros
            post.setRequestBody(parametersList);
            int httpstatus = 0;
            String response = null;
            try {
            //Se env´ıa la petici´on
            httpstatus = client.executeMethod(post);
            //Se consigue la respuesta
            response = post.getResponseBodyAsString();
            }
            catch (Exception e) {
            //Habr´a que prever la captura de excepciones
            
            }
            finally {
            //En cualquier caso se cierra la conexi´on
            post.releaseConnection();
            }
            //Habr´a que prever posibles errores en la respuesta del servidor
            if (httpstatus!=200){
            
            }
            else {
            //Se procesa la respuesta capturada en la cadena ‘‘response’’
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
    }
    
   
}
