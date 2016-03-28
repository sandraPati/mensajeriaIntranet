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
import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuesto_expres;
import com.intranet.beans.presupuesto_expres_panos;
import com.intranet.beans.presupuesto_superficie;
import com.intranet.beans.presupuesto_superficies_panos;
import com.intranet.beans.presupuesto_superficies_panos_vpa;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.propuesta;
import com.intranet.beans.puertas;
import com.intranet.beans.subcapitulos;
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
import com.intranet.service.propuesta.PresupuestoCService;
import com.intranet.service.propuesta.PresupuestoExpresPanosService;
import com.intranet.service.propuesta.PresupuestoExpresService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosService;
import com.intranet.service.propuesta.PresupuestoSuperficiesPanosVPAService;
import com.intranet.service.propuesta.PresupuestoSuperficiesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.SubCapitulosService;
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
public class SupControllerPresupuestoExpresCocina {
     @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private EstanciasService estanciasService;  
    @Autowired
    private PanosService panosService;
    @Autowired
    private PresupuestoExpresService presupuestoExpresService;
    @Autowired
    private PresupuestoExpresPanosService presupuestoExpresPanosService;
    @Autowired
    private PresupuestoCService presupuestoCService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private PresupuestoSuperficiesService presupuestoSuperficiesService;
    @Autowired
    private SubCapitulosService subCapitulosService;
    @Autowired
    private PresupuestoSuperficiesPanosService presupuestoSuperficiesPanosService;
    @Autowired
    private PresupuestoSuperficiesPanosVPAService presupuestoSuperficiesPanosVPAService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private TipoPanosService tipoPanosService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    
    
    
    @RequestMapping("/PExpresaddCocina.htm")
    public @ResponseBody String jsonAddPresupSubCap(@RequestBody presupuesto_expres pex ){
        int r=presupuestoExpresService.existecount(pex.getIdpropuesta(),pex.getIdestancia());
        System.out.println("EXPRES");
        if(r>0){
            System.out.println("update");
            pex.setId(presupuestoExpresService.existe(pex.getIdpropuesta(),pex.getIdestancia()));
                presupuestoExpresService.update2(pex);
            
        }else{
            System.out.println("insert");
            presupuestoExpresService.insert2(pex);
        }
            
        
        //AUTOMARICO
            presupuesto1und(pex,21,51,1);
            presupuesto1und(pex,21,54,1);
            
            presupuesto1und(pex,22,61,1);
            presupuesto1und(pex,22,64,1);
            //presupuesto1und(pex,22,65,1);
            
            presupuesto1und(pex,23,108,1);
            //presupuesto1undfloat(pex,23,79, (float) 3.25);
            
            presupuesto1und(pex,26,213,1);
            //alicatados y recubrimiento  8.04 remete de esquinas calculo automaticode esquinas ???????????????????
            
            //panos
            if(pex.getPanotipo()==1){
                 presupuesto1m2pano(pex,23,85,2);
                 
                 presupuesto1m2panodelete(pex,28,282);
                 presupuesto1m2panodelete(pex,28,283);
                 presupuesto1m2panodelete(pex,21,25);
            }else if(pex.getPanotipo()==2){
                presupuesto1m2pano2(pex,28,282,2);
                presupuesto1m2pano(pex,28,283,2);
                
                presupuesto1m2panodelete(pex,21,25);
                presupuesto1m2panodelete(pex,23,85);
            }else if(pex.getPanotipo()==0){
                presupuesto1m2pano(pex,21,25,1);                
                presupuesto1m2pano2(pex,28,282,1);
                presupuesto1m2pano(pex,28,283,1);
                
                presupuesto1m2panodelete(pex,23,85);
            }
            
            //suelo
            if(pex.getPanosuelo()!=0){
                presupuesto1m2suelo(pex,21,34,pex.getPanosuelo());
                presupuesto1m2suelo(pex,29,287,pex.getPanosuelo());
                
                presupuesto1m2suelomas(pex,29,288,pex.getPanosuelo());
                presupuesto1m2suelo(pex,29,289,pex.getPanosuelo());
            }
            //techo
            if(pex.getCambiarfalsotecho()==1){
               if(pex.getFalsotechopano()!=0)presupuesto1m2(pex,21,45);
                //presupuestoc
               
            }else{
                if(pex.getFalsotechopano()!=0)presupuesto2m2(pex,21,45);
                
            }
            //ventana
            //presupuesto1und(pex,21,68,pex.getNventana());
            presupuesto1und(pex,21,60,1);
            List<ventanas> ltavv=ventanaService.findAllEstanciaVentanas(pex.getIdestancia());
            if(ltavv.size()>0)presupuesto1m2ventanas(pex,31,346);
            
            //puerta
            presupuesto1und(pex,21,35,pex.getPuerta());
            if(pex.getPuertatipo()==0){
                presupuesto1und(pex,23,96,pex.getPuerta());
                presupuesto1und(pex,30,317,pex.getPuerta());
                presupuesto1und(pex,30,328,pex.getPuerta());
                
                presupuesto1m2panodelete(pex,30,315);
                presupuesto1m2panodelete(pex,30,318);
            }else if(pex.getPuertatipo()==1){
                presupuesto1und(pex,30,315,pex.getPuerta());
                presupuesto1und(pex,30,318,pex.getPuerta());
                
                presupuesto1m2panodelete(pex,23,96);
                presupuesto1m2panodelete(pex,30,317);
                presupuesto1m2panodelete(pex,30,328);
            }
            //electricidad
            //luz
            presupuesto1und(pex,27,218,pex.getPuntosluz());
            
            //enchufe
            presupuesto1und(pex,27,222,pex.getPuntosenchufe());
            //hornococina
            presupuesto1und(pex,27,223,pex.getPuntospvh());
            presupuesto1und(pex,27,224,pex.getPuntospvh());
            //telefonico
            presupuesto1und(pex,27,230,pex.getPuntosptt());
            //television
            presupuesto1und(pex,27,226,pex.getPuntosptv());
            
            
            sumaElectricidad(pex,27,247);
            
            
            //calefaccion
            //if(pex.getRadiadortipo()==1){
                presupuesto1und(pex,21,44,pex.getNradiador());
            /*}else{
                presupuesto1m2panodelete(pex,21,44);
            }*/
            //...........RT radiador toallero
            //fontaneria

            presupuesto1und(pex,22,66,pex.getFontaneriapuntos());            
            presupuesto1und(pex,26,130,pex.getFontaneriapuntos());
            //presupuesto1und(pex,26,137,pex.getFontaneriapuntos());
                //ducha 23 84
                 
                
                //elimibar..........................
                //laves de corate
                if(pex.getLlavecorte()==1){
                    presupuesto1und(pex,26,134,1);
                }else{
                   
                    presupuesto1m2panodelete(pex,26,134);
                
                }
                //demoler muro
                presupuesto1undfloat(pex,21,13,pex.getDemolermuro());
                presupuesto1undfloat(pex,23,99,pex.getDemolermuro());
                //falso techo nuevo
                presupuesto1undfloat(pex,23,102,pex.getFalsotechonuevo());
                presupuesto1undfloat(pex,23,103,(pex.getFalsotechonuevo()+(pex.getDemolermuro()*2)));
                
                //instalacion gas
                if(pex.getIgg()==1){
                    presupuesto1und(pex,35,407,pex.getIgg());
                }else{
                     presupuesto1m2panodelete(pex,35,407);
                 }
                presupuesto1und(pex,35,410,1);
                //pintura y acabado
                presupuesto1m2suelo(pex,36,414,pex.getPanosuelo());
                //equipamiento y mobiliario
                presupuesto1und(pex,21,37,pex.getMobe());
                presupuesto1ml(pex,37,423,pex.getMobn());
            
        return "success"; 
    }
    
@RequestMapping(value = "NuevaPropuestaPExpresC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPExpres_get(ModelMap map,@RequestParam(value = "idE") int idE) {
        List<panos> ltaPanos=null;
        estancias est=new estancias();
        presupuesto_expres pe=new presupuesto_expres();
        try{
            est=estanciasService.porID(idE);
            //ltaPanos=panosService.findAll(idE);
            ltaPanos=presupuestoExpresService.panosExpres(idE);
            
            int idPe=presupuestoExpresService.existecount(est.getPropuesta_id().getId(), idE);
          
            if(idPe>0){
                
                idPe=presupuestoExpresService.existe(est.getPropuesta_id().getId(), idE);
                pe=presupuestoExpresService.presupExpresIDE2(idPe);
            }else{            
                
                pe.setIdpropuesta(est.getPropuesta_id().getId());
                pe.setIdestancia(idE);
            }
        }catch(Exception ex){
        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaPanos",ltaPanos);
        map.addAttribute("pex",pe);
        map.addAttribute("idP",est.getPropuesta_id().getId());
        return "NuevaPropuestaPExpresC";
    }
    
  
    
    private void presupuesto1m2(presupuesto_expres pex,int cap,int subcap) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
        panos pt=panosService.porID(pex.getFalsotechopano());
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(pt.getSuperficie());
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                     pres.setCantidad(pt.getSuperficie());
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(pex.getFalsotechopano());
                        presuperfpanos.setLargo(pt.getAlto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pex.getFalsotechopano(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
    }
private void presupuesto1m2ventanas(presupuesto_expres pex,int cap,int subcap) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);

//panos pt=panosService.porID(pex.getFalsotechopano());
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(ventanaService.findAllEstancia(pex.getIdestancia()));
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                     pres.setCantidad(ventanaService.findAllEstancia(pex.getIdestancia()));
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                List<panos> panoslta=panosService.findAll(pex.getIdestancia());
                    for(panos ven:panoslta){
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(ven.getId());
                        presuperfpanos.setLargo(ven.getAlto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(ven.getId(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                        idPanosPre=presupuestoSuperficiesPanosService.buscar(ven.getId(),presupobj.getId());
                        List<ventanas> ltavv=ventanaService.findAll(ven.getId());
                        for(ventanas ven2:ltavv){
                            presupuesto_superficies_panos_vpa vpa=new presupuesto_superficies_panos_vpa();
                            vpa.setIdpresup_sup_pano(idPanosPre);
                            vpa.setIdvpa(ven2.getId());
                        int vpaid=presupuestoSuperficiesPanosVPAService.buscarcount(vpa.getIdvpa(), vpa.getIdpresup_sup_pano());
                        if(vpaid==0) presupuestoSuperficiesPanosVPAService.Insert(vpa);
                        }
                    }
    }

private void presupuesto1m2suelo(presupuesto_expres pex,int cap,int subcap,int idsuelo) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);

        panos pt=panosService.porID(idsuelo);
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(pt.getSuperficie());
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                     pres.setCantidad(pt.getSuperficie());
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(pt.getId());
                        presuperfpanos.setLargo(pt.getAlto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pt.getId(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                    
    }

private void presupuesto1ml(presupuesto_expres pex,int cap,int subcap,float monbn) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);

        
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("ml");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(monbn);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                     pres.setCantidad(monbn);
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    //presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                
                    
    }
private void presupuesto1m2suelomas(presupuesto_expres pex,int cap,int subcap,int idsuelo) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);

        panos pt=panosService.porID(idsuelo);
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        
                        pre.setPrecio(sc.getCantidad());
                        float s=(float) (pt.getSuperficie()+(pt.getSuperficie()*0.2));
                        pre.setCantidad(s);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                     float s=(float) (pt.getSuperficie()+(pt.getSuperficie()*0.2));
                     pres.setCantidad(s);
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(pt.getId());
                        presuperfpanos.setLargo(pt.getAlto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pt.getId(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                    
    }
    private void presupuesto2m2(presupuesto_expres pex,int cap,int subcap) {
       int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
       int idSubCapExiste=0;
       int idSubCapExiste2=0;
       int idPresupSup=0;
       int idPanosPre=0;
       List<presupuesto_superficies_panos> ltappano=new ArrayList<presupuesto_superficies_panos>();
       List<presupuesto_superficie> ltapsup=new ArrayList<presupuesto_superficie>();
                if(idCapExiste>0){
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                
                idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                if(idSubCapExiste>0){ 
                    idSubCapExiste2=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                
                presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste2);
                 presuperf.setEstancia(pex.getIdestancia());
                 
                idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                presupuesto_superficie presupobj=new presupuesto_superficie();
                if(idPresupSup>0){
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    presupobj.setEstancia(presupobj.getEstancia_id().getId());
                idPanosPre=presupuestoSuperficiesPanosService.buscarcount(pex.getFalsotechopano(),presupobj.getId());
                if(idPanosPre>0) presupuestoSuperficiesPanosService.DeleteID(pex.getFalsotechopano(),presupobj.getId());
                ltappano=presupuestoSuperficiesPanosService.findAll(presupobj.getId());
                if(ltappano.size()==0)presupuestoSuperficiesService.DeleteEstancia(presupobj);
                }
                ltapsup=presupuestoSuperficiesService.findAll(idSubCapExiste2);
                if(ltapsup.size()==0 ) presupuestosService.DeleteP(idSubCapExiste2);
                }
                System.out.println("idSubCapExiste"+idSubCapExiste+"idPresupSup"+idPresupSup+"idPanosPre"+idPanosPre);
                List<presupuesto> ltapp=presupuestosService.subcapPresupuesto(pex.getIdpropuesta(), cap);
                if(ltapp.size()==0  )presupuestoCService.Delete(idCapExiste);
                }
    }
    
    private void presupuesto1und(presupuesto_expres pex,int cap,int subcap,int und) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("und.");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(und);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                }else{
                 presupuesto pp=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                 pp.setCantidad(und);
                 pp.setMonto(pp.getPrecio()*pp.getCantidad());
                 presupuestosService.UpdateM(pp);
                 }
                 //presupuesto_superficies
                
    }
    
     private void presupuesto1undfloat(presupuesto_expres pex,int cap,int subcap,float und) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(und);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                }else{
                 presupuesto pp=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                 pp.setCantidad(und);
                 pp.setMonto(pp.getPrecio()*pp.getCantidad());
                 presupuestosService.UpdateM(pp);
                 }
                 //presupuesto_superficies
                
    }
     
     
    private void presupuesto1m2pano(presupuesto_expres pex, int c, int scap, int r) {
        List<panos> ltaPanos=presupuestoExpresService.panosExpresElejidos(pex.getIdestancia());
        if(ltaPanos.size()>0){
        float suma=0;
        if(r==1){
            suma=0;
            for(panos p:ltaPanos){
                suma=suma+(p.getLargo()*p.getAlto());
            }
            
        }else if(r==2){
            suma=0;
            for(panos p:ltaPanos){
                suma=suma+(p.getLargo()*p.getLargopresupuesto());
            }
            
        }
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),c);
        if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(c);
                    precnew.setPropuesta_id(pex.getIdpropuesta());
                    presupuestoCService.Insert(precnew);
        }          
        idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), c);  
        int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,scap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(scap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(scap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad(suma);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,scap);
                     pres.setCantidad(suma);
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,scap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                     for(panos p:ltaPanos){
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(p.getId());
                        presuperfpanos.setLargo(p.getLargopresupuesto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(p.getId(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                     }
        }
    }
    private void presupuesto1m2pano2(presupuesto_expres pex, int c, int scap, int r) {
        List<panos> ltaPanos=presupuestoExpresService.panosExpresElejidos(pex.getIdestancia());
        if(ltaPanos.size()>0){
        float suma=0;
        if(r==1){
            suma=0;
            for(panos p:ltaPanos){
                suma=suma+(p.getLargo()*p.getAlto());
            }
            
        }else if(r==2){
            suma=0;
            for(panos p:ltaPanos){
                suma=suma+(p.getLargo()*p.getLargopresupuesto());
            }
            
        }
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),c);
        if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(c);
                    precnew.setPropuesta_id(pex.getIdpropuesta());
                    presupuestoCService.Insert(precnew);
        }          
        idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), c);  
        int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,scap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(scap);
                        pre.setTipoCantidad("m2");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(scap);
                        
                        pre.setPrecio(sc.getCantidad());
                        pre.setCantidad((float) (suma+(suma*0.2)));
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                    }else{
                     
                     presupuesto pres=presupuestosService.buscarPresupSC(idCapExiste,scap);
                      pres.setCantidad((float) (suma+(suma*0.2)));
                        pres.setMonto(pres.getPrecio()*pres.getCantidad());
                     presupuestosService.UpdateM(pres);
                 }
                 idSubCapExiste=presupuestosService.buscarPresupSCid(idCapExiste,scap);
                 //presupuesto_superficies
                 presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste);
                 presuperf.setEstancia(pex.getIdestancia());
                 int idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                    presupuesto_superficie presupobj=new presupuesto_superficie();
                    if(idPresupSup==0){

                    presupuestoSuperficiesService.Insert(presuperf);
                    }
                    //idPresupSup=presupuestoSuperficiesService.buscarid(presuperf);
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    
                //presupuesto_superficies_panos
                     for(panos p:ltaPanos){
                        presupuesto_superficies_panos presuperfpanos=new presupuesto_superficies_panos();
                        presuperfpanos.setIdpresup_sup(presupobj.getId());
                        presuperfpanos.setIdpano(p.getId());
                        presuperfpanos.setLargo(p.getLargopresupuesto());
                        int idPanosPre=presupuestoSuperficiesPanosService.buscarcount(p.getId(),presupobj.getId());
                        if(idPanosPre==0) presupuestoSuperficiesPanosService.Insert(presuperfpanos);
                     }
        }
    }
    
     private void presupuesto1m2panodelete(presupuesto_expres pex,int cap,int subcap) {
         List<panos> ltaPanos=presupuestoExpresService.panosExpresElejidos(pex.getIdestancia());
       int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
       int idSubCapExiste=0;
       int idSubCapExiste2=0;
       int idPresupSup=0;
       int idPanosPre=0;
       List<presupuesto_superficies_panos> ltappano=new ArrayList<presupuesto_superficies_panos>();
       List<presupuesto_superficie> ltapsup=new ArrayList<presupuesto_superficie>();
                if(idCapExiste>0){
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                
                idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                if(idSubCapExiste>0){ 
                    idSubCapExiste2=presupuestosService.buscarPresupSCid(idCapExiste,subcap);
                
                presupuesto_superficie presuperf=new presupuesto_superficie();
                 presuperf.setPresupuesto_id(idSubCapExiste2);
                 presuperf.setEstancia(pex.getIdestancia());
                 
                idPresupSup=presupuestoSuperficiesService.buscarcount(presuperf);
                presupuesto_superficie presupobj=new presupuesto_superficie();
                if(idPresupSup>0){
                    presupobj=presupuestoSuperficiesService.buscar(presuperf);
                    presupobj.setEstancia(presupobj.getEstancia_id().getId());
                    
                for(panos p:ltaPanos){    
                    idPanosPre=presupuestoSuperficiesPanosService.buscarcount(p.getId(),presupobj.getId());
                    if(idPanosPre>0){
                    presupuestoSuperficiesPanosVPAService.DeletePorIdPSE(presupuestoSuperficiesPanosService.ultimo(p.getId(),presupobj.getId()));
                    presupuestoSuperficiesPanosService.DeleteID(p.getId(),presupobj.getId());
                    }
                    
                }
                ltappano=presupuestoSuperficiesPanosService.findAll(presupobj.getId());
                if(ltappano.size()==0)presupuestoSuperficiesService.DeleteEstancia(presupobj);
                }
                ltapsup=presupuestoSuperficiesService.findAll(idSubCapExiste2);
                if(ltapsup.size()==0 ) presupuestosService.DeleteP(idSubCapExiste2);
                }
                System.out.println("idSubCapExiste"+idSubCapExiste+"idPresupSup"+idPresupSup+"idPanosPre"+idPanosPre);
                List<presupuesto> ltapp=presupuestosService.subcapPresupuesto(pex.getIdpropuesta(), cap);
                if(ltapp.size()==0  )presupuestoCService.Delete(idCapExiste);
                }
    }
    
     
     
     @RequestMapping(value = "NuevaPropuestaExpresC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaExpres_get(ModelMap map) {        
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
        return "NuevaPropuestaExpresC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresAddC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaExpresAdd_get(ModelMap map,@RequestParam(value="cli")String nif) {        
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
        return "NuevaPropuestaExpresAddC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresAddC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaExpresAdd_post(@ModelAttribute("prop")propuesta prop,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        empleados empleado=new empleados();
        users u=null;
        int id=0;
        try{
            
            u=usuarioService.getByLogin(name);
            empleado=empleadoService.ByNif(u.getNif());
            prop.setEmpleado_nif(empleado);
            prop.setTipopropuesta(3);
            propuestasService.InsertPaso(prop);
            id=propuestasService.porIdNifCEmpleado(prop.getNifCliente(),u.getNif());
        }catch(Exception ex){
            
        }
          
         return "redirect:NuevaPropuestaExpresEstanciasC.htm?idP="+id;
        
        
        
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresEstanciasC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaExpresEstancias_get(ModelMap map,@RequestParam(value="idP")int id) {        
        estancias e=new estancias();
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("prop",id);
        map.addAttribute("estancia",e);
        return "NuevaPropuestaExpresEstanciasC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresEstanciasC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaExpresEstancias_post(@ModelAttribute("estancia")estancias estan,BindingResult result) {
        int idE=0;
        try{
            
            estanciasService.Insert(estan);
            idE=estanciasService.idultimo(estan.getPropuesta_id().getId());
            
            //estancia.add(est);
            //estanciasService.Insert(est);
        }catch(Exception ex){}
         return "redirect:NuevaPropuestaExpresPanosC.htm?idE="+idE;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPanosC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaExpresPanos_get(ModelMap map,@RequestParam(value="idE")int idE) {        
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
        return "NuevaPropuestaExpresPanosC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPanosC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaExpresPanos_post(@ModelAttribute("pa")panos pan,BindingResult result) {
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
                    if(pan.getTipo_pano_id().getId()!=1)ruta="redirect:NuevaPropuestaExpresFinEstanciaC.htm?idE="+pan.getEstancia_id().getId();
                    else{
                        int idPan=panosService.idultimo(pan.getEstancia_id().getId());
                        ruta="redirect:NuevaPropuestaExpresVentanasC.htm?idP="+idPan;
                    }
                    
        }catch(Exception ex){}
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresVentanasC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaExpresVentanas_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
            
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "NuevaPropuestaExpresVentanasC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresVentanasC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaExpresVentanas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        try{
            if(p.getVentana().equals("NO")){
               // pano.setVentana(p.getVentana());
                p.setNumventanas(0);
            }
            
            panosService.UpdateVentana(p);
            if(p.getVentana().equals("SI")){
                ruta="redirect:NuevaPropuestaExpresVentanasFC.htm?idP="+p.getId();
            }else ruta="redirect:NuevaPropuestaExpresPuertasC.htm?idP="+p.getId();
        }catch(Exception ex){}  
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresVentanasFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresVentanasFC";
    }
    @RequestMapping(value = "NuevaPropuestaExpresVentanasFC.htm",method=RequestMethod.POST)
    public String addVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="redirect:NuevaPropuestaExpresVentanasFC.htm?idP="+v.getIdpano().getId();
        List<ventanas> ltaventana=null;
        try{
            //vent=v;
            panos pano=panosService.porID(v.getIdpano().getId());
            ventanaService.Insert(v);
            ltaventana=ventanaService.findAll(v.getIdpano().getId());
           
            if(pano.getNumventanas()==ltaventana.size()){
                ruta="redirect:NuevaPropuestaExpresPuertasC.htm?idP="+pano.getId();
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPuertasC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPuertas_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "NuevaPropuestaExpresPuertasC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresPuertasC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaPuertas_post(@ModelAttribute("pa")panos p,BindingResult result) {
        String ruta="";
        try{
            if(p.getPuertas().equals("NO")){
               // pano.setVentana(p.getVentana());
                p.setNumpuertas(0);
            }
            
            panosService.UpdatePuerta(p);
            if(p.getPuertas().equals("SI")){
                ruta="redirect:NuevaPropuestaExpresPuertasFC.htm?idP="+p.getId();
            }else ruta="redirect:NuevaPropuestaExpresArmariosC.htm?idP="+p.getId();
        }catch(Exception ex){}  
         return ruta;
    }
    @RequestMapping(value = "NuevaPropuestaExpresPuertasFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresPuertasFC";
    }
    @RequestMapping("/ExpresjsonNuevaPropuestaEjaddPuertasFC.htm")
    public @ResponseBody String ExpresjsonNuevaPropuestaEjaddPuertasF(@RequestBody puertas p ){
        System.out.println("add json puertas");
        String ruta="/Intranet/sup/NuevaPropuestaExpresPuertasFC.htm?idP="+p.getId_pano();
        try{
            panos pano=panosService.porID(p.getId_pano());
            puertasService.InsertPaso(p);
            List<puertas> ltapuerta=puertasService.findAll(p.getId_pano());
           
            if(pano.getNumpuertas()==ltapuerta.size()){
                ruta="/Intranet/sup/NuevaPropuestaExpresArmariosC.htm?idP="+p.getId_pano();
            }
        }catch(Exception ex){}
        return ruta; 
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresArmariosC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaPuertasExpresArmarios_get(ModelMap map,@RequestParam(value="idP")int idP) {        
        panos pano=null;
        try{
            pano=panosService.porID(idP);
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pa",pano);
        return "NuevaPropuestaExpresArmariosC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresArmariosC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaPuertasExpresArmarios_post(@ModelAttribute("pa")panos p,BindingResult result) {
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
                ruta="redirect:NuevaPropuestaExpresArmariosFC.htm?idP="+p.getId();
            }else ruta="redirect:NuevaPropuestaExpresFinEstanciaC.htm?idE="+pa.getEstancia_id().getId();
        }catch(Exception ex){}  
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresArmariosFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresArmariosFC";
    }
    @RequestMapping(value = "NuevaPropuestaExpresArmariosFC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaArmariosF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="redirect:NuevaPropuestaExpresArmariosFC.htm?idP="+v.getIdpano().getId();
        List<armarios> ltaarmario=null;
        try{
            //vent=v;
            panos pano=panosService.porID(v.getIdpano().getId());
            armariosService.Insert(v);
            ltaarmario=armariosService.findAll(v.getIdpano().getId());
            
            if(pano.getNumarmarios()==ltaarmario.size()){
                ruta="redirect:NuevaPropuestaExpresFinEstanciaC.htm?idE="+pano.getEstancia_id().getId();
            }
        }catch(Exception ex){            
        }
          
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresFinEstanciaC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaFinEstancia_get(ModelMap map,@RequestParam(value="idE")int idE) {
        
        String r=validaInterfacesRoles.valida();
        estancias est=estanciasService.porID(idE);
        map.addAttribute("menu",r);
        map.addAttribute("est",idE);
        map.addAttribute("idP",est.getPropuesta_id().getId());
        return "NuevaPropuestaExpresFinEstanciaC";
    }
    
    
    @RequestMapping(value = "NuevaPropuestaExpresFinPropuesta2C.htm",method=RequestMethod.GET)
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
                
        return "redirect:NuevaPropuestaExpresVerPanosC.htm?idE="+idE;
    }
    
    
    
     @RequestMapping("NuevaPropuestaExpresVerPanosC.htm")
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
        return("NuevaPropuestaExpresVerPanosC");
        
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresDeleteEstanciaC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresVerEstanciaC.htm?idP="+idP;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresDeletePanoC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresVerPanosC.htm?idE="+idE;
    }
    
    
    @RequestMapping("NuevaPropuestaExpresVerPC.htm")
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
        return("NuevaPropuestaExpresVerPC");
        
    }
    
    
    @RequestMapping(value = "NuevaPropuestaExpresvolcarPanoC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresVerPanosC.htm?idE="+pano2.getEstancia_id().getId();
    }
 
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePanoC.htm",method=RequestMethod.GET)
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
        
        return "NuevaPropuestaExpresUpdatePanoC";
    }
    
     @RequestMapping(value = "NuevaPropuestaExpresUpdatePanoC.htm",method=RequestMethod.POST)
    public String updatePano_post(@ModelAttribute("pa")panos pan,BindingResult result) {
        String ruta="redirect:NuevaPropuestaExpresUpdateVentanasC.htm?idP="+pan.getId();
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
                        ruta="redirect:NuevaPropuestaExpresVerPanosC.htm?idE="+pan.getEstancia_id().getId();
                    }else{ 
                        pan.setTotal(pan.getSuperficie());
                        panosService.Update(pan);
                    }
                    ltapanos=panosService.findAll(pan.getEstancia_id().getId());
                    estancias est=updEstancia(ltapanos,pan.getEstancia_id().getId());
                    estanciasService.Update(est);
                    
        
         return ruta;
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateVentanasC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdateVentanasC";
    }
    
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateVentanasFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdateVentanasFC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateVentanasFC.htm",method=RequestMethod.POST)
    public String EjupdateVentanasF_post(@ModelAttribute("vent")ventanas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           ventanaService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:NuevaPropuestaExpresUpdateVentanasC.htm?idP="+v.getIdpano().getId()+"";
    }
     @RequestMapping(value = "NuevaPropuestaExpresUpdateVentanasFaddC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdateVentanasFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        ventanas v=new ventanas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("vent",v);
        return "NuevaPropuestaExpresUpdateVentanasFaddC";
    }
    @RequestMapping(value = "NuevaPropuestaExpresUpdateVentanasFaddC.htm",method=RequestMethod.POST)
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
        
         return "redirect:NuevaPropuestaExpresUpdateVentanasC.htm?idP="+v.getIdpano().getId();
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresDeleteVentanasC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresUpdateVentanasC.htm?idP="+ventana.getIdpano().getId()+"";
    }
    //puertas
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePuertasC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdatePuertasC";
    }
    
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePuertasFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdatePuertasFC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePuertasFC.htm",method=RequestMethod.POST)
    public String EjupdatePuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           puertasService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:NuevaPropuestaExpresUpdatePuertasC.htm?idP="+v.getIdpano().getId()+"";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePuertasFaddC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdatePuertasFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        puertas v=new puertas();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("pu",v);
        return "NuevaPropuestaExpresUpdatePuertasFaddC";
    }
    @RequestMapping(value = "NuevaPropuestaExpresUpdatePuertasFaddC.htm",method=RequestMethod.POST)
    public String EjupdateassPuertasF_post(@ModelAttribute("pu")puertas v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           puertasService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumpuertas(p.getNumpuertas()+1);
           panosService.UpdatePuerta(p);
        }catch(Exception ex){}          
        
         return "redirect:NuevaPropuestaExpresUpdatePuertasC.htm?idP="+v.getIdpano().getId();
    }
    @RequestMapping(value = "NuevaPropuestaExpresDeletePuertasC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresUpdatePuertasC.htm?idP="+p.getIdpano().getId()+"";
    }
    
    //armarios
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateArmarioC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdateArmarioC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateArmarioFC.htm",method=RequestMethod.GET)
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
        return "NuevaPropuestaExpresUpdateArmarioFC";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateArmarioFC.htm",method=RequestMethod.POST)
    public String EjupdateArmarioF_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
           // v.setIdpano(pano);
           armariosService.Update(v);
        }catch(Exception ex){}          
        
         return "redirect:NuevaPropuestaExpresUpdateArmarioC.htm?idP="+v.getIdpano().getId()+"";
    }
    
    @RequestMapping(value = "NuevaPropuestaExpresUpdateArmarioFaddC.htm",method=RequestMethod.GET)
    public String NuevaPropuestaUpdateArmarioFadd_get(ModelMap map,@RequestParam(value = "idP") int id) {
        armarios v=new armarios();
        panos p=new panos();
        p.setId(id);
        v.setIdpano(p);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("arm",v);
        return "NuevaPropuestaExpresUpdateArmarioFaddC";
    }
    @RequestMapping(value = "NuevaPropuestaExpresUpdateArmarioFaddC.htm",method=RequestMethod.POST)
    public String NuevaPropuestaUpdateArmarioFadd_post(@ModelAttribute("arm")armarios v,BindingResult result) {
        String ruta="";
        try{
            //v.setIdpano(pano);
           armariosService.Insert(v);
           panos p=panosService.porID(v.getIdpano().getId());
           p.setNumarmarios(p.getNumarmarios()+1);
           panosService.UpdateArmario(p);
        }catch(Exception ex){}          
        
         return "redirect:NuevaPropuestaExpresUpdateArmarioC.htm?idP="+v.getIdpano().getId();
    }
    @RequestMapping(value = "NuevaPropuestaExpresDeleteArmarioC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresUpdateArmarioC.htm?idP="+p.getIdpano().getId()+"";
    }
    @RequestMapping(value = "NuevaPropuestaExpresUpdateFinishC.htm",method=RequestMethod.GET)
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
        
        return "redirect:NuevaPropuestaExpresVerPanosC.htm?idE="+est.getId();
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

    public void sumaElectricidad(presupuesto_expres pex,int cap,int subcap) {
        List<presupuesto> lta=presupuestosService.subcapPresupuesto(pex.getIdpropuesta(), cap);
        float suma=0;
        for(presupuesto p:lta){
            suma=suma+p.getMonto();
        }
        presupuesto1undelec(pex,cap,subcap,suma);
        //return 0;
    }
    
    public void presupuesto1undelec(presupuesto_expres pex,int cap,int subcap,float suma) {
        int idCapExiste=presupuestoCService.ultimoPresupuestoC(pex.getIdpropuesta(),cap);
                if(idCapExiste==0){

                    presupuestoc precnew=new presupuestoc();
                    precnew.setCapitulo_id(cap);
                    precnew.setPropuesta_id(pex.getIdpropuesta());

                    presupuestoCService.Insert(precnew);
                }
                    idCapExiste=presupuestoCService.ultimoPresupuestoCid(pex.getIdpropuesta(), cap);
                 //presupuesto
                 int idSubCapExiste=presupuestosService.buscarPresupSCcount(idCapExiste,subcap);
                 if(idSubCapExiste==0){
                     presupuesto pre=new presupuesto();
                        pre.setIdSubCap(subcap);
                        pre.setTipoCantidad("und.");
                        pre.setPresup_id(idCapExiste);
                        subcapitulos sc=subCapitulosService.porId(subcap);
                        pre.setPrecio(suma);
                        pre.setCantidad(1);
                        pre.setMonto(pre.getPrecio()*pre.getCantidad());
                        presupuestosService.InsertT(pre);
                }else{
                 presupuesto pp=presupuestosService.buscarPresupSC(idCapExiste,subcap);
                 pp.setCantidad(1);
                 pp.setPrecio(suma);
                 pp.setMonto(pp.getPrecio()*pp.getCantidad());
                 presupuestosService.UpdateM(pp);
                 }
                 //presupuesto_superficies
                
    }
}
