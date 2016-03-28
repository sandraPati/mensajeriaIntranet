/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuestaPanos;

import com.intranet.beans.armarios;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuesto_superficie;
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
import com.intranet.service.propuesta.CapitulosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.SubCapitulosService;
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
@RequestMapping("/sup/*")
public class SupControllerPropuestaPanos {
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
    
    private propuesta prop=new propuesta();
    private estancias est=new estancias();
    private panos pano=new panos();
   
    private clientes cli=new clientes();
    private List<panos> ltapanos=new  ArrayList<panos>();
    private List<ventanas> ltaventana=new  ArrayList<ventanas>();
    private List<ventanas> ltaventana2=new  ArrayList<ventanas>();
    private List<puertas> ltapuerta=new  ArrayList<puertas>();
    private List<armarios> ltaarmario=new  ArrayList<armarios>();
    
    @RequestMapping(value = "EjaddEstancia.htm",method=RequestMethod.GET)
    public String addEstancia_get(ModelMap map,@RequestParam(value = "idP") int idP) {
        ltapanos=new ArrayList<panos>();
        prop.setId(idP);
        estancias e=new estancias();
        List<tipo_estancia> ltaTipoEstancia=null;
        try{
            //prop=propuestasService.porId(idP);
            ltaTipoEstancia=tipoEstanciasService.findAll("");
            e.setPropuesta_id(prop);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("estancia",e);
        map.addAttribute("prop",prop);
        map.addAttribute("ltaTipoEstancia",ltaTipoEstancia);
        
        return "EjaddEstancia";
    }
    
    @RequestMapping(value = "EjaddEstancia.htm",method=RequestMethod.POST)
    public String addEstancia_post(@ModelAttribute("estancia")estancias estan,BindingResult result,Principal principal) {
        int idE=0;
        try{
            
            est=estan;
            est.setPropuesta_id(prop);
            if(est.getTipo_estancia_id().getId()!=6){
                est.setOtro_tipo("");
            }
            estanciasService.Insert(est);
            idE=estanciasService.idultimo(est.getPropuesta_id().getId());
            
            ltapanos=null;
            //estancia.add(est);
            //estanciasService.Insert(est);
        }catch(Exception ex){}
         return "redirect:EjaddPano.htm?idE="+idE;
    }
    
    @RequestMapping(value = "EjaddPano.htm",method=RequestMethod.GET)
    public String addPano_get(ModelMap map,@RequestParam(value = "idE") int idE) {
        //ltapanos=new ArrayList<panos>();
        pano=new panos();
        List<tipo_pano> ltaTipoPano=null;
        try{
            est=estanciasService.porID(idE);
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
        return "EjaddPano";
    }
    
    @RequestMapping(value = "EjaddPano.htm",method=RequestMethod.POST)
    public String addPano_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="redirect:EjaddVentanas.htm";
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
                    pan.setEstancia_id(est);
                    panosService.Insert(pan);
                    if(pan.getTipo_pano_id().getId()!=1)ruta="redirect:MasPanos.htm?idE="+est.getId();
                    int idPan=panosService.idultimo(est.getId());
                    pano=panosService.porID(idPan);
                    
        }catch(Exception ex){}
         return ruta;
    }
    
   
    
    @RequestMapping(value = "EjaddPano2.htm",method=RequestMethod.GET)
    public String EjaddPano2_get(ModelMap map,@RequestParam(value = "idE") int id) {
        ltapanos=new ArrayList<panos>();
        ltaventana=new ArrayList<ventanas>();
        ltapuerta=new ArrayList<puertas>();
        ltaarmario=new ArrayList<armarios>();
        pano=new panos();
        List<tipo_pano> ltaTipoPano=null;
        try{
            
            est=estanciasService.porID(id);
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
        return "EjaddPano2";
    }
    
    @RequestMapping(value = "EjaddPano2.htm",method=RequestMethod.POST)
    public String EjaddPano2_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="redirect:EjaddVentanas.htm";
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
                    pan.setEstancia_id(est);
                    panosService.Insert(pan);
                    if(pan.getTipo_pano_id().getId()!=1)ruta="redirect:MasPanos.htm?idE="+est.getId();
                    int idPan=panosService.idultimo(est.getId());
                    pano=panosService.porID(idPan);
                    
        }catch(Exception ex){}
         return ruta;
    }
    
    @RequestMapping(value = "EjaddVentanas.htm",method=RequestMethod.GET)
    public String addVentanas_get(ModelMap map) {
        ltaventana=new ArrayList<ventanas>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        
        return "EjaddVentanas";
    }
    
    @RequestMapping(value = "EjaddVentanas.htm",method=RequestMethod.POST)
    public String addVentanas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="redirect:EjaddPuertas.htm";
        
            //vent=v;
            pano.setVentana(p.getVentana());
            pano.setNumventanas(p.getNumventanas());
            if(p.getVentana().equals("NO")){
               // pano.setVentana(p.getVentana());
                pano.setNumventanas(0);
            }
            
            panosService.UpdateVentana(pano);
            if(p.getVentana().equals("SI")){
                ruta="redirect:EjaddVentanasF.htm";
            }
            
         return ruta;
    }
    
    @RequestMapping(value = "EjaddVentanasF.htm",method=RequestMethod.GET)
    public String addVentanasF_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",new ventanas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaventana",ltaventana);
        return "EjaddVentanasF";
    }
    
    @RequestMapping(value = "EjaddVentanasF.htm",method=RequestMethod.POST)
    public String addVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="redirect:EjaddVentanasF.htm";
        try{
            //vent=v;
            v.setIdpano(pano);
            ventanaService.Insert(v);
            ltaventana=ventanaService.findAll(pano.getId());
            if(pano.getNumventanas()==ltaventana.size()){
                ruta="redirect:EjaddPuertas.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    @RequestMapping(value = "EjaddPuertas.htm",method=RequestMethod.GET)
    public String addPuertas_get(ModelMap map) {
        ltapuerta=new ArrayList<puertas>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        
        return "EjaddPuertas";
    }
    
    @RequestMapping(value = "EjaddPuertas.htm",method=RequestMethod.POST)
    public String addPuertas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="redirect:EjaddArmarios.htm";
        try{
            pano.setPuertas(p.getPuertas());
            pano.setNumpuertas(p.getNumpuertas());
            if(p.getPuertas().equals("NO")){
                //pano.setPuertas(p.getVentana());
                pano.setNumpuertas(0);
            }
            panosService.UpdatePuerta(pano);
            if(p.getPuertas().equals("SI")){
                ruta="redirect:EjaddPuertasF.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "EjaddPuertasF.htm",method=RequestMethod.GET)
    public String addPuertasF_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pue",new puertas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltapuerta",ltapuerta);
        return "EjaddPuertasF";
    }
    
    @RequestMapping(value = "EjaddPuertasF.htm",method=RequestMethod.POST)
    public String addPuertas_post(@ModelAttribute("pue")puertas p,BindingResult result) {
        String ruta="redirect:EjaddPuertasF.htm";
        try{
            p.setIdpano(pano);
            puertasService.Insert(p);
            ltapuerta=puertasService.findAll(pano.getId());
            if(pano.getNumpuertas()==ltapuerta.size()){
                ruta="redirect:EjaddArmarios.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    @RequestMapping("/jsonEjaddPuertasF.htm")
    public @ResponseBody String jsonAddPresupSubCap(@RequestBody puertas p ){
        String ruta="/Intranet/sup/EjaddPuertasF.htm";
            
            p.setIdpano(pano);
            puertasService.Insert(p);
            ltapuerta=puertasService.findAll(pano.getId());
            if(pano.getNumpuertas()==ltapuerta.size()){
                ruta="/Intranet/sup/EjaddArmarios.htm";
            }
        return ruta; 
    }
    
    @RequestMapping(value = "EjaddArmarios.htm",method=RequestMethod.GET)
    public String addArmarios_get(ModelMap map) {
        ltaarmario=new ArrayList<armarios>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        
        return "EjaddArmarios";
    }
    
    @RequestMapping(value = "EjaddArmarios.htm",method=RequestMethod.POST)
    public String addArmarios_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="redirect:MasPanos.htm?idE="+pano.getEstancia_id().getId();
        try{
            pano.setArmario(p.getArmario());
            pano.setNumarmarios(p.getNumarmarios());
            if(p.getArmario().equals("NO")){
                //pano.setPuertas(p.getVentana());
                pano.setNumarmarios(0);
            }
            panosService.UpdateArmario(pano);
            if(p.getArmario().equals("SI")){
                ruta="redirect:EjaddArmariosF.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    @RequestMapping(value = "EjaddArmariosF.htm",method=RequestMethod.GET)
    public String addArmarioF_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",new armarios());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaarmario",ltaarmario);
        return "EjaddArmariosF";
    }
    
    @RequestMapping(value = "EjaddArmariosF.htm",method=RequestMethod.POST)
    public String addArmario_post(@ModelAttribute("arm")armarios p,BindingResult result) {
        String ruta="redirect:EjaddArmariosF.htm";
        try{
            p.setIdpano(pano);
            armariosService.Insert(p);
            ltaarmario=armariosService.findAll(pano.getId());
            if(pano.getNumarmarios()==ltaarmario.size()){
                ruta="redirect:MasPanos.htm?idE="+pano.getEstancia_id().getId();
            }
            
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "MasPanos.htm",method=RequestMethod.GET)
    public String masPanos_get(ModelMap map,@RequestParam(value="idE")int idE) {
        propuesta p=prop;
        estancias e=est;
        panos pan=pano;
        try{
        pan.setVentanaspano(ltaventana);
        pan.setPuertaspano(ltapuerta);
        pan.setArmariospano(ltaarmario);
        ltapanos=panosService.findAll(est.getId());
        //ltapanos.add(pan);
        //pano=new panos();
        ltaventana=null;
        ltapuerta=null;
        ltaarmario=null;
        }catch(Exception ex){
        }
        String r=validaInterfacesRoles.valida();
        
        map.addAttribute("menu",r);
        map.addAttribute("est",idE);
        return "MasPanos";
    }
    
   
    @RequestMapping(value = "FinPropuesta.htm",method=RequestMethod.GET)
    public String FinPropuesta(ModelMap map) {
        try{
            //estancia.add(est);
            
                ltapanos=panosService.findAll(est.getId());
                for(panos p:ltapanos){
                    
                    p=updateMedidas(p);
                    panosService.Update(p);
                    
                }
                ltapanos=panosService.findAll(est.getId());
                est.setLtaPanos(ltapanos);
                est=sumaSuperficiesEstancia(est);
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
        
        return "redirect:consultarPropuesta.htm?idP="+est.getPropuesta_id().getId();
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
    
     
     
     
     
     
     
     
     //VOLCAR
     
     @RequestMapping(value = "Volcar.htm",method=RequestMethod.GET)
    public String Volcar_get(ModelMap map) {
        
        try{
                    if(pano.getTipo_pano_id().getId()==2)pano.setNombrepano("Suelo");
                    if(pano.getTipo_pano_id().getId()==3)pano.setNombrepano("Techo");
                    if(pano.getVentana().equals("NO")){
                        pano.setNumventanas(0); 
                       
                        pano.setSuperficieventana(0);
                    }
                    if(pano.getPuertas().equals("NO")){
                        pano.setNumpuertas(0);
                        
                        pano.setSuperficiepuerta(0);
                    }
                    if(pano.getArmario().equals("NO")){
                        pano.setNumarmarios(0);
                       
                        pano.setSuperficiearmario(0);
                    }
                    
            float supVentana=0;
                    float supPuerta=0;
                    float supArm=0;
                    for(ventanas v:pano.getVentanaspano()){
                        supVentana=supVentana+v.getSuperficie();
                    }
                    for(puertas v:pano.getPuertaspano()){
                        supPuerta=supPuerta+v.getSuperficie();
                    }
                    for(armarios v:pano.getArmariospano()){
                        supArm=supArm+v.getSuperficie();
                    }
                    float total=pano.getSuperficie()-(supVentana+supPuerta+supArm);
                    pano.setSuperficieventana(supVentana);
                    pano.setSuperficiepuerta(supPuerta);
                    pano.setSuperficiearmario(supArm);
                    pano.setTotal(total);
                    if(pano.getTipo_pano_id().getId()==1){
                        pano.setNombrepano("Paño "+pano.getNumero());
                    }        
            ltaventana=pano.getVentanaspano();
            ltapuerta=pano.getPuertaspano();
            ltaarmario=pano.getArmariospano();
            //System.out.println("size"+ltapanos.size());
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "Volcar";
    }
     
     
     @RequestMapping(value = "EjaddPanoVolcar.htm",method=RequestMethod.GET)
    public String addPanoVolcar_get(ModelMap map) {
        //ltapanos=new ArrayList<panos>();
        List<tipo_pano> ltaTipoPano=null;
        try{
            //estancia=estanciasService.porID(idE);
            pano.setEstancia_id(est);
            ltaTipoPano=tipoPanosService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        map.addAttribute("ltaTipoPano",ltaTipoPano);
        return "EjaddPanoVolcar";
    }
    
    @RequestMapping(value = "EjaddPanoVolcar.htm",method=RequestMethod.POST)
    public String addPanoVolcar_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="";
        try{
            System.out.println("ventana:"+pan.getVentana());
            pano=pan;
            pano.setVentanaspano(ltaventana);
            pano.setPuertaspano(ltapuerta);
            pano.setArmariospano(ltaarmario);
        }catch(Exception ex){            
        }
          
         return "redirect:Volcar.htm";
    }
    
    @RequestMapping(value = "EjaddVentanasVolcar.htm",method=RequestMethod.GET)
    public String addVentanasVolcar_get(ModelMap map) {
        //ltaventana=new ArrayList<ventanas>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",new panos());
        
        return "EjaddVentanasVolcar";
    }
    
    @RequestMapping(value = "EjaddVentanasVolcar.htm",method=RequestMethod.POST)
    public String addVentanasVolcar_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        try{
            //vent=v;
            pano.setVentana(p.getVentana());
            pano.setNumventanas(p.getNumventanas());
            
                ruta="redirect:EjaddVentanasFVolcarAdd.htm";
            
        }catch(Exception ex){            
        }
         return ruta;
    }
    
    @RequestMapping(value = "EjaddVentanasFVolcar.htm",method=RequestMethod.GET)
    public String addVentanasFVolcar_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",new ventanas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaventana",ltaventana);
        map.addAttribute("ltaventana2",ltaventana2);
        return "EjaddVentanasFVolcar";
    }
    
    @RequestMapping(value = "EjaddVentanasFVolcar.htm",method=RequestMethod.POST)
    public String addVentanasFVolcar_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="redirect:EjaddVentanasFVolcar.htm";
        try{
            System.out.println("Pano: "+pano.getNumventanas()+"ventana: "+v.getNum()+"largo:"+v.getLargo()+"alto:"+v.getAlto()+"sup:"+v.getSuperficie());
            //vent=v;
            ltaventana2.add(v);
            for(ventanas ve:ltaventana2){
                System.out.println("ventana: "+ve.getNum()+"largo:"+ve.getLargo()+"alto:"+ve.getAlto()+"sup:"+ve.getSuperficie());
            }
            
            if(pano.getNumventanas()==ltaventana2.size()){
                ltaventana=new ArrayList<ventanas>();
                ltaventana=ltaventana2;
                ltaventana2=new ArrayList<ventanas>();
                pano.setVentanaspano(ltaventana);
                ruta="redirect:Volcar.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
   @RequestMapping(value = "EjaddVentanasFVolcarAdd.htm",method=RequestMethod.GET)
    public String addVentanasFVolcarAdd_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",new ventanas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaventana",ltaventana);
        return "EjaddVentanasFVolcarAdd";
    }
    
    @RequestMapping(value = "EjaddVentanasFVolcarAdd.htm",method=RequestMethod.POST)
    public String addVentanasFVolcarAdd_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="redirect:EjaddVentanasFVolcarAdd.htm";
        try{
            System.out.println("Pano: "+pano.getNumventanas()+"ventana: "+v.getNum()+"largo:"+v.getLargo()+"alto:"+v.getAlto()+"sup:"+v.getSuperficie());
            //vent=v;
            ltaventana.add(v);
            for(ventanas ve:ltaventana){
                System.out.println("ventana: "+ve.getNum()+"largo:"+ve.getLargo()+"alto:"+ve.getAlto()+"sup:"+ve.getSuperficie());
            }
            
            if(pano.getNumventanas()==ltaventana.size()){
                pano.setVentanaspano(ltaventana);
                ruta="redirect:Volcar.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    
    
    @RequestMapping(value = "EjaddPuertasVolcar.htm",method=RequestMethod.GET)
    public String addPuertasVolcar_get(ModelMap map) {
        ltapuerta=new ArrayList<puertas>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",new panos());
        
        return "EjaddPuertasVolcar";
    }
    
    @RequestMapping(value = "EjaddPuertasVolcar.htm",method=RequestMethod.POST)
    public String addPuertasVolcar_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="redirect:EjaddArmariosVolcar.htm";
        try{
            pano.setPuertas(p.getPuertas());
            pano.setNumpuertas(p.getNumpuertas());
            if(p.getPuertas().equals("SI")){
                ruta="redirect:EjaddPuertasFVolcar.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "EjaddPuertasFVolcar.htm",method=RequestMethod.GET)
    public String addPuertasFVolcar_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pue",new puertas());
        map.addAttribute("pa",pano);
        map.addAttribute("ltapuerta",ltapuerta);
        return "EjaddPuertasFVolcar";
    }
    
    @RequestMapping(value = "EjaddPuertasFVolcar.htm",method=RequestMethod.POST)
    public String addPuertasVolcar_post(@ModelAttribute("pue")puertas p,BindingResult result) {
        String ruta="redirect:EjaddPuertasFVolcar.htm";
        try{
            System.out.println("Pano: "+pano.getNumpuertas()+"puerta: "+p.getNum()+"largo:"+p.getLargo()+"alto:"+p.getAlto()+"sup:"+p.getSuperficie());
            //vent=v;
            ltapuerta.add(p);
            for(puertas ve:ltapuerta){
                System.out.println("puerta: "+ve.getNum()+"largo:"+ve.getLargo()+"alto:"+ve.getAlto()+"sup:"+ve.getSuperficie());
            }
            
            if(pano.getNumpuertas()==ltapuerta.size()){
                ruta="redirect:EjaddArmariosVolcar.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    
    @RequestMapping(value = "EjaddArmariosVolcar.htm",method=RequestMethod.GET)
    public String addArmariosVolcar_get(ModelMap map) {
        ltaarmario=new ArrayList<armarios>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",new panos());
        
        return "EjaddArmariosVolcar";
    }
    
    @RequestMapping(value = "EjaddArmariosVolcar.htm",method=RequestMethod.POST)
    public String addArmariosVolcar_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="redirect:MasPanos.htm";
        try{
            pano.setArmario(p.getArmario());
            pano.setNumarmarios(p.getNumarmarios());
            System.out.println("numArmarios:"+pano.getNumarmarios());
            if(p.getArmario().equals("SI")){
                ruta="redirect:EjaddArmariosFVolcar.htm";
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    @RequestMapping(value = "EjaddArmariosFVolcar.htm",method=RequestMethod.GET)
    public String addArmarioFVolcar_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",new armarios());
        map.addAttribute("pa",pano);
        map.addAttribute("ltaarmario",ltaarmario);
        return "EjaddArmariosFVolcar";
    }
    
    @RequestMapping(value = "EjaddArmariosFVolcar.htm",method=RequestMethod.POST)
    public String addArmarioVolcar_post(@ModelAttribute("arm")armarios p,BindingResult result) {
        String ruta="redirect:EjaddArmariosFVolcar.htm";
        try{
            System.out.println("Pano: "+pano.getNumarmarios()+"Armrio: "+p.getNum()+"largo:"+p.getLargo()+"alto:"+p.getAlto()+"sup:"+p.getSuperficie());
            //vent=v;
            ltaarmario.add(p);
            for(armarios ve:ltaarmario){
                System.out.println("Armrio: "+ve.getNum()+"largo:"+ve.getLargo()+"alto:"+ve.getAlto()+"sup:"+ve.getSuperficie()+"fondo:"+ve.getFondo());
            }
            
            if(pano.getNumarmarios()==ltaarmario.size()){
                ruta="redirect:MasPanos.htm";
            }
            
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
}
