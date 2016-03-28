/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuesta;

import com.intranet.beans.armarios;
import com.intranet.beans.capitulos;
import com.intranet.beans.clientes;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuesto_superficie;
import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.beans.presupuesto_superficies_panos_vpa;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.presupuestom2panos;
import com.intranet.beans.propuesta;
import com.intranet.beans.puertas;
import com.intranet.beans.ventanas;
import com.intranet.intr.conexion;
import com.intranet.intr.mensajesEmail.mensajePresupuesto;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.CapitulosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PresupuestoCService;
import com.intranet.service.propuesta.PresupuestoM2PanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosVPAService;
import com.intranet.service.propuesta.PresupuestoSuperficiesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.SubCapitulosService;
import com.intranet.service.propuesta.VentanaService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
public class SupControllerPresupuestoExpresCocinaP {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private PresupuestoCService presupuestoCService;
    @Autowired
    private CapitulosService capitulosService;
    @Autowired
    private SubCapitulosService subCapitulosService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private PresupuestoSuperficiesService presupuestoSuperficiesService;
    @Autowired
    private PresupuestoSuperficiesPanosService presupuestoSuperficiesPanosService;
    @Autowired
    private PresupuestoM2PanosService presupuestoM2PanosService;
    @Autowired
    private EstanciasService estanciasService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private PresupuestoSuperficiesPanosVPAService presupuestoSuperficiesPanosVPAService;
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuestoC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPresupuesto_get(ModelMap map,@RequestParam(value = "idP") int idP,@RequestParam(value = "msg", required = false) String msg) {        
        propuesta p=new propuesta();
        int idE=0;
        presupuestoc presupCap=new presupuestoc();
        List<presupuestoc> ltaCapitulos=null;
        try{
            if(msg!=null & msg!=""){
                if(msg.equals("success")) {
                    map.addAttribute("msg", "Reporte de Presupuesto enviado Satisfactoriamente");
                }else if (msg.equals("error")) {
                    map.addAttribute("error", "Operacion rechazada, la Propuesta no tiene el Presupuesto Llenado");
                }
            }
            p=propuestasService.porId(idP);
            idE=estanciasService.idultimo(idP);
            //presupCap.setPropuesta_id(idP);
            ltaCapitulos=presupuestoCService.presupuestoCapitulosADD(idP);
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("p",p);
        map.addAttribute("idE",idE);
        map.addAttribute("presup",presupCap);
        map.addAttribute("ltaCapitulos",ltaCapitulos);
        return "NuevaPropuestaExpresPresupuestoC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuesto2C.htm",method=RequestMethod.GET)
    public String addPresupuestoExpres2_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idC")int idC) {
        
        propuesta p=new propuesta();
        //List<capitulos> ltaCapitulos=null;
        capitulos cap=null;
        List<presupuesto> ltaSubCapitulos=null;
        List<presupuesto> ltaSubCapitulos2=new ArrayList<presupuesto>();
        int idPc=0;
        presupuestom2panos presm2=null;
        int res=0;
        presupuesto presup=new presupuesto();
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
                            r=1;
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
        return "NuevaPropuestaExpresPresupuesto2C";
    }
   
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuesto3C.htm",method=RequestMethod.GET)
    public String addPresupuesto3_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
        String ruta="";
        propuesta p=new propuesta();
        presupuesto presup=null;
        try{
            p=propuestasService.porId(idP);
            
            presup=presupuestosService.buscarPresupSC(idPre, idSC);
            if(presup.getTipoCantidad().equals("und.")){
                ruta="NuevaPropuestaExpresPresupuesto3C";            
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("p",p);
                map.addAttribute("presup",presup);
            }else  ruta="redirect:NuevaPropuestaExpresPresupuesto4C.htm?idP="+idP+"&idPre="+idPre+"&idSC="+idSC; 
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuesto3C.htm",method=RequestMethod.POST)
    public String addPresupuesto3_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
      // String ruta="redirect:Presupuesto.htm?idP="+presup2.getPropuesta_id();
        String ruta="redirect:NuevaPropuestaExpresPresupuesto2C.htm?idP="+presup2.getProp()+"&idC="+presup2.getCapitulo().getId();
        try{
            presupuestosService.Update(presup2); 
           
        }catch(Exception ex){            
        }
        //map.addAttribute("presup",presup);  
        return ruta;
    }
    @RequestMapping("NuevaPropuestaExpresPresupuesto4C.htm")
    public String addPresupuesto4(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC) {
        propuesta p=new propuesta();
        List<estancias> ltaEstancias=null;
        presupuestoc pre=new presupuestoc();
         presupuesto pres1=new presupuesto();
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
        return("NuevaPropuestaExpresPresupuesto4C");
        
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuesto5C.htm",method=RequestMethod.GET)
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
            //p=propuestasService.porId(presup.getPropuesta_id());
           
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
        return("NuevaPropuestaExpresPresupuesto5C");
    }
    @RequestMapping(value = "NuevaPropuestaExpresPresupuesto6C.htm",method=RequestMethod.GET)
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
        return("NuevaPropuestaExpresPresupuesto6C");
    }
    @RequestMapping(value = "NuevaPropuestaExpresPresupuestoGC.htm",method=RequestMethod.GET)
    public String addPresupuestoG_get(ModelMap map,@RequestParam(value="idP")int idP,@RequestParam(value="idPre")int idPre,@RequestParam(value="idSC")int idSC,@RequestParam(value="idPresup")int idPresup) {
        String ruta="NuevaPropuestaExpresPresupuestoGC";
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
                ruta="redirect:NuevaPropuestaExpresPresupuesto4C.htm?idP="+idP+"&idPre="+idPre+"&idSC="+idSC;
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
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
       // map.addAttribute("ltaCapitulos",ltaCapitulos);
      //  map.addAttribute("ltaSubCapitulos",ltaSubCapitulos);
        return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuestoGC.htm",method=RequestMethod.POST)
    public String addPresupuestoG_post(ModelMap map,@ModelAttribute("presup")presupuesto presup2,BindingResult result) {
       
        try{
            
             presupuestosService.Update(presup2);
            
            
        }catch(Exception ex){            
        }
        //map.addAttribute("presup",presup);  
        //return "redirect:Presupuesto.htm?idP="+presup2.getPropuesta_id();
        return "redirect:NuevaPropuestaExpresPresupuesto2C.htm?idP="+presup2.getProp()+"&idC="+presup2.getCapitulo().getId(); 
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPresupuestoasignarLtaGuardadaC.htm",method=RequestMethod.GET)
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
            

        
        
        return "redirect:NuevaPropuestaExpresPresupuesto2C.htm?idP="+idP+"&idC="+pres.getCapitulo().getId();  
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresVerPresupuestoCPdf.htm",method=RequestMethod.GET)
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
                    ruta="NuevaPropuestaExpresVerPresupuestoCPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:NuevaPropuestaExpresPresupuestoC.htm?idP="+idPr;
            }        
        
        }catch(Exception e){

        }
        return(ruta);
    }
    @RequestMapping(value = "NuevaPropuestaExpresenviarPresupuestoC.htm",method=RequestMethod.GET)
    public String enviarPresupuesto(@RequestParam(value = "idP") int idPr,ModelMap map) {
        //propuesta prop=new propuesta();
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
		//System.out.println("email cliente "+prop.getCliente_nif().getEmail());
		m.mensaje(p,presupuestoLista);
                map.addAttribute("msg","success");
            }else{
                map.addAttribute("msg","error");
            }    

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:NuevaPropuestaExpresPresupuestoC.htm?idP="+idPr;
    }
}
