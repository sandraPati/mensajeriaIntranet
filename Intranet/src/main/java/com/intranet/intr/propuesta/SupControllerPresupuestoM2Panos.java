/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.propuesta;

import com.intranet.beans.presupuesto;
import com.intranet.beans.presupuestoc;
import com.intranet.beans.presupuestom2panos;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.PresupuestoCService;
import com.intranet.service.propuesta.PresupuestoM2PanosService;
import com.intranet.service.propuesta.PresupuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sup/*")
public class SupControllerPresupuestoM2Panos {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PresupuestoM2PanosService presupuestoM2PanosService;
    @Autowired
    PresupuestosService presupuestosService;
    @Autowired
    PresupuestoCService presupuestoCService;
     
    @RequestMapping("/jsonguardarPanosSelec.htm")
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
    @RequestMapping("/jsonguardarPanosSelecAddPresup.htm")
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
        
        return "/Intranet/sup/addPresupuesto2.htm?idP="+pp.getPropuesta_id()+"&idC="+pp.getCapitulo_id(); 
    }
    
   @RequestMapping("/jsonguardarPanosSelecAddPresupPaso.htm")
    public @ResponseBody String jsonguardarPanosSelecAddPresupPaso(@RequestBody presupuesto pre ){
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
        
        return "/Intranet/sup/NuevaPropuestaPresupuesto2.htm?idP="+pp.getPropuesta_id()+"&idC="+pp.getCapitulo_id(); 
    }
}
