/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuestaPanos;

import com.intranet.beans.armarios;
import com.intranet.beans.clientes;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.propuesta;
import com.intranet.beans.puertas;
import com.intranet.beans.tipo_pano;
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

@Controller
@RequestMapping("/sup/*")
public class SupControllerPropuestaPanosUpdate {
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
    private ventanas ventana=new ventanas();
    private List<puertas> ltapuerta=new  ArrayList<puertas>();
    private List<armarios> ltaarmario=new  ArrayList<armarios>();
    
    
    @RequestMapping(value = "EjupdatePano.htm",method=RequestMethod.GET)
    public String addPano_get(ModelMap map,@RequestParam(value = "idPano") int id) {
        
        List<tipo_pano> ltaTipoPano=null;
        try{
            pano=panosService.porID(id);
            ltaTipoPano=tipoPanosService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        map.addAttribute("ltaTipoPano",ltaTipoPano);
        return "EjupdatePano";
    }
    
    @RequestMapping(value = "EjupdatePano.htm",method=RequestMethod.POST)
    public String addPano_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="redirect:EjupdateVentanas.htm?idPano="+pano.getId();
        
           
                    if(pan.getTipo_pano_id().getId()==2)pan.setNombrepano("Suelo");
                    if(pan.getTipo_pano_id().getId()==3)pan.setNombrepano("Techo");
                    System.out.println("tipo:"+pan.getTipo_pano_id().getId());
                    System.out.println("id Paño:"+pan.getId());
                    
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
                        ruta="redirect:verEstancias.htm?idE="+pan.getEstancia_id().getId();
                    }else{ 
                        pan.setTotal(pan.getSuperficie());
                        panosService.Update(pan);
                    }
                    ltapanos=panosService.findAll(pan.getEstancia_id().getId());
                    estancias est=updEstancia(ltapanos,pan.getEstancia_id().getId());
                    estanciasService.Update(est);
                    System.out.println("id Paño:"+pan.getId());
                    pano=panosService.porID(pan.getId());
                    
        
         return ruta;
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
    @RequestMapping(value = "EjupdateVentanas.htm",method=RequestMethod.GET)
    public String EjupdateVentanas_get(ModelMap map,@RequestParam(value = "idPano") int id) {
        
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
        return "EjupdateVentanas";
    }
    @RequestMapping(value = "EjupdateVentanasFadd.htm",method=RequestMethod.GET)
    public String EjupdateaddVentanas_get(ModelMap map,@RequestParam(value = "idP") int id) {
        ventanas v=new ventanas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",v);
        return "EjupdateVentanasFadd";
    }
    @RequestMapping(value = "EjupdateVentanasFadd.htm",method=RequestMethod.POST)
    public String EjupdateassVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
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
        
         return "redirect:EjupdateVentanas.htm?idPano="+v.getIdpano().getId();
    }
    @RequestMapping(value = "EjupdateVentanasF.htm",method=RequestMethod.GET)
    public String EjupdateVentanasF_get(ModelMap map,@RequestParam(value = "id") int id) {
        
        try{
            //pano=panosService.porID(id);
            ventana=ventanaService.porID(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",ventana);
        return "EjupdateVentanasF";
    }
    
    @RequestMapping(value = "EjupdateVentanasF.htm",method=RequestMethod.POST)
    public String EjupdateVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           ventanaService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:EjupdateVentanas.htm?idPano="+v.getIdpano().getId()+"";
    }
    
   
    @RequestMapping(value = "EjdeleteVentanas.htm",method=RequestMethod.GET)
    public String EjdeleteVentanas(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
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
        
        return "redirect:EjupdateVentanas.htm?idPano="+ventana.getIdpano().getId()+"";
    }
    
    //puertas
    
    @RequestMapping(value = "EjupdatePuertas.htm",method=RequestMethod.GET)
    public String EjupdatePuertas_get(ModelMap map,@RequestParam(value = "idPano") int id) {
        
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
        return "EjupdatePuertas";
    }
    @RequestMapping(value = "EjupdatePuertasFadd.htm",method=RequestMethod.GET)
    public String EjupdateaddPuertas_get(ModelMap map,@RequestParam(value = "idP") int id) {
        puertas v=new puertas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pu",v);
        return "EjupdatePuertasFadd";
    }
    @RequestMapping(value = "EjupdatePuertasFadd.htm",method=RequestMethod.POST)
    public String EjupdateassPuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           puertasService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumpuertas(p.getNumpuertas()+1);
           panosService.UpdatePuerta(p);
        }catch(Exception ex){}          
        
         return "redirect:EjupdatePuertas.htm?idPano="+v.getIdpano().getId();
    }
    @RequestMapping(value = "EjupdatePuertasF.htm",method=RequestMethod.GET)
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
        return "EjupdatePuertasF";
    }
    
    @RequestMapping(value = "EjupdatePuertasF.htm",method=RequestMethod.POST)
    public String EjupdatePuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           puertasService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:EjupdatePuertas.htm?idPano="+v.getIdpano().getId()+"";
    }
    
   
    @RequestMapping(value = "EjdeletePuertas.htm",method=RequestMethod.GET)
    public String EjdeletePuertas(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        puertas p=null;
        try{
            p=puertasService.porID(id);
            puertasService.Delete(id);
            panos pp=panosService.porID(ventana.getIdpano().getId());
            int n=pp.getNumpuertas()-1;
           pp.setNumpuertas(n);
           panosService.UpdatePuerta(pp);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EjupdatePuertas.htm?idPano="+p.getIdpano().getId()+"";
    }
    
    
    
    
    //armarios
    
    @RequestMapping(value = "EjupdateArmario.htm",method=RequestMethod.GET)
    public String EjupdateArmario_get(ModelMap map,@RequestParam(value = "idPano") int id) {
        
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
        return "EjupdateArmario";
    }
    @RequestMapping(value = "EjupdateArmarioFadd.htm",method=RequestMethod.GET)
    public String EjupdateaddArmario_get(ModelMap map,@RequestParam(value = "idP") int id) {
        armarios v=new armarios();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",v);
        return "EjupdateArmarioFadd";
    }
    @RequestMapping(value = "EjupdateArmarioFadd.htm",method=RequestMethod.POST)
    public String EjupdateassArmarioF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           armariosService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumarmarios(p.getNumarmarios()+1);
           panosService.UpdateArmario(p);
        }catch(Exception ex){}          
        
         return "redirect:EjupdateArmario.htm?idPano="+v.getIdpano().getId();
    }
    @RequestMapping(value = "EjupdateArmarioF.htm",method=RequestMethod.GET)
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
        return "EjupdateArmarioF";
    }
    
    @RequestMapping(value = "EjupdateArmarioF.htm",method=RequestMethod.POST)
    public String EjupdateArmarioF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           armariosService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:EjupdateArmario.htm?idPano="+v.getIdpano().getId()+"";
    }
    
   
    @RequestMapping(value = "EjdeleteArmario.htm",method=RequestMethod.GET)
    public String EjdeleteArmario(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        armarios p=null;
        try{
            p=armariosService.porID(id);
            armariosService.Delete(id);
            panos pa=panosService.porID(ventana.getIdpano().getId());
            int n=pa.getNumarmarios()-1;
           pa.setNumarmarios(n);
           panosService.UpdateArmario(pa);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EjupdateArmario.htm?idPano="+p.getIdpano().getId()+"";
    }
    
    
    
    
    @RequestMapping(value = "EjupdateFinish.htm",method=RequestMethod.GET)
    public String EjupdateFinish(ModelMap map,@RequestParam(value = "idPano") int id) {
        //panos p=null;
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
        
        return "redirect:verEstancias.htm?idE="+est.getId();
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
    
     
}
