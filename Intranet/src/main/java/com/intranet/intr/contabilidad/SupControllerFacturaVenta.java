/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.contabilidad;

import com.intranet.beans.clientes;
import com.intranet.beans.detalleVenta;
import com.intranet.beans.tipoiva;
import com.intranet.beans.venta;
import com.intranet.intr.conexion;
import com.intranet.intr.mensajesEmail.mensajeContabilidad;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.DetalleVentaService;
import com.intranet.service.contabilidad.TipoIvaService;
import com.intranet.service.contabilidad.VentaService;
import com.intranet.service.propuesta.ClientesService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerFacturaVenta {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private DetalleVentaService detalleVentaService;
    @Autowired
    private ClientesService clientesService;       
    @Autowired
    private TipoIvaService tipoIvaService;
            
    private List<detalleVenta> tiendaV=new ArrayList<detalleVenta>();
    private int idP=0;
    @RequestMapping("Venta.htm")
    public String Venta(ModelMap mav,@RequestParam(value = "msg", required = false) String msg){
        tiendaV=new ArrayList<detalleVenta>();
        List<venta> ventaListbox=null;
        try{
            if(msg!=null & msg!=""){
                if(msg.equals("success")) {
                    mav.addAttribute("msg", "Factura Enviada");
                }else if (msg.equals("error")) {
                    mav.addAttribute("error", "Operacion rechazada, La Factura no contiene Productos/Servicios");
                }
            }
            ventaListbox=ventaService.findAll();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("tiendaV", tiendaV);
        mav.addAttribute("ventaListbox", ventaListbox);
        //mav.setViewName("Venta");        
        return "Venta";
    }
    
    @RequestMapping(value = "FacturaVenta.htm",method=RequestMethod.GET)
    public String FacturaCompra_get(ModelMap map) {
        String ruta="FacturaVenta";
        try{
            if(tiendaV.size()==0){
                ruta="redirect:addProductoVenta.htm";
                
                
            }else{
                for(detalleVenta p:tiendaV){
                    System.out.println("2+"+p.getProductoservicio()+""+p.getTipoiva_id().getId());
                }
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("detalleC",new detalleVenta());
            }
        }catch(Exception ex){}
        
        map.addAttribute("tiendaV",tiendaV);
        
        return (ruta);
    }
    
    @RequestMapping(value = "addProductoVenta.htm",method=RequestMethod.GET)
    public String addProducto_get(ModelMap map) {
        detalleVenta dc=new detalleVenta();
        List<tipoiva> ltaTipoIva=null;
        try{
            int i=0;
            for(detalleVenta d:tiendaV){
                i++;
                System.out.println("for tienda:"+i);
            }
            dc.setId(i+1);
            ltaTipoIva=tipoIvaService.findAll();
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",dc);
        map.addAttribute("ltaTipoIva",ltaTipoIva);
        map.addAttribute("tiendaV",tiendaV);
        
        return "addProductoVenta";
    }
    
    @RequestMapping(value = "addFacturaVenta.htm",method=RequestMethod.GET)
    public String addFacturadetalleVenta_get(ModelMap map) {
        
        venta c=new venta();
        List<clientes> ltaCliente=null;
        try{
            ltaCliente=clientesService.findAll("");
            Double suma=0.0;
            Double sumaiva=0.0;
            for(detalleVenta dc:tiendaV){
                suma=suma+dc.getDescuento();
                sumaiva=sumaiva+dc.getImpuesto();
            }
            c.setBaseimponible(suma);
            c.setIvatotal(sumaiva);
            c.setTotal(c.getBaseimponible()+c.getIvatotal());
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaCliente",ltaCliente);
        map.addAttribute("ven",c);
        map.addAttribute("tiendaV",tiendaV);
        
        return "addFacturaVenta";
    }
    
    @RequestMapping(value = "addFacturaVenta.htm",method=RequestMethod.POST)
    public String addFacturaCompra_post(@ModelAttribute("ven")venta ven,BindingResult result) {
        String mensaje="";
        //ventaService.Insert(ven);
        try{
            if(ven.getRectificactiva()==false)ven.setCausa("");
            if(ventaService.Insert(ven)==true){
                int cod=ventaService.ultimocompra();
                for(detalleVenta d:tiendaV){
                    venta com=new venta();
                    com.setNum(cod);
                    d.setVenta_id(com);
                    
                    detalleVentaService.Insert(d);
                }
            }
            
        }catch(Exception e){
        
        }
         return "redirect:Venta.htm";
        
    }
  
    @RequestMapping(value = "AgregarPVenta.htm",method = RequestMethod.POST)
    public String AgregarP(@ModelAttribute("detalleC")detalleVenta detalleC,ModelMap map) {
       
        try{
           detalleVenta dc=new detalleVenta();
            dc=agregar(detalleC);
            
            boolean regis=false;
            int i=0;
            
            for(detalleVenta array:tiendaV){               
                     if(array.getId()==dc.getId()){
                     regis=true;
                     break;
                     }
                     i++;
            }
            if(regis==true){
                 tiendaV.set(i, dc);
            }else{
                 tiendaV.add(dc);
            }
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        return "redirect:FacturaVenta.htm";
        
    }
    
    @RequestMapping(value = "QuitarPVenta.htm",method = RequestMethod.GET)
    public String QuitarP(@RequestParam("id")int id,ModelMap map){
    
        for(detalleVenta array:tiendaV){               
                if(array.getId()==id){
                tiendaV.remove(array);
                break;
                }
            }
        return "redirect:FacturaVenta.htm";
    }
    
    public detalleVenta agregar(detalleVenta detalleC){
        detalleVenta dc=new detalleVenta();
            dc.setProductoservicio(detalleC.getProductoservicio());
            dc.setCantidad(detalleC.getCantidad());
            dc.setPrecio(detalleC.getPrecio());
            dc.setTotalcp(detalleC.getCantidad()*detalleC.getPrecio());
            dc.setPorcentajedescuento(detalleC.getPorcentajedescuento());
            dc.setDescuento(dc.getTotalcp()-(dc.getTotalcp()*detalleC.getPorcentajedescuento()));
            System.out.println(""+detalleC.getTipoiva_id().getId()+"de."+detalleC.getTipoiva_id().getDescripcion());
            
            dc.setTipoiva_id(tipoIvaService.porId(detalleC.getTipoiva_id().getId()));
            if(detalleC.getTipoiva_id().getId()==1){
                dc.setImpuesto(dc.getDescuento()*0.21);
            }else if(detalleC.getTipoiva_id().getId()==2){
                dc.setImpuesto(dc.getDescuento()*0.10);
            }else if(detalleC.getTipoiva_id().getId()==3){
                dc.setImpuesto(dc.getDescuento()*0.04);
            }else if(detalleC.getTipoiva_id().getId()==4){
                dc.setImpuesto(0.0);
            }else if(detalleC.getTipoiva_id().getId()==5){
                dc.setImpuesto(0.0);
            }
            //dc.setImpuesto(detalleC.getImpuesto());
            dc.setTotalimp(dc.getDescuento()+dc.getImpuesto());
           
            dc.setId(detalleC.getId());
            return dc;
    }
    
    
    @RequestMapping(value = "enviarFacturaVenta.htm",method=RequestMethod.GET)
    public String enviarFacturaVenta(@RequestParam(value = "id") int idPr,ModelMap map) {
        //propuesta prop=new propuesta();
        String rpta="";
        try{
            venta p=ventaService.porId(idPr);
            List<detalleVenta> ltaP=detalleVentaService.findAllPorVenta(idPr);
            if(ltaP.size()!=0){
                
               // List<presupuesto> presupuestoLista=presupuestosService.presupuestoPropuesta(idPr);
                mensajeContabilidad m=new mensajeContabilidad();
		//System.out.println("email cliente "+prop.getCliente_nif().getEmail());
		m.mensaje(p);
                map.addAttribute("msg","success");
            }else{
                map.addAttribute("msg","error");
            }    

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Venta.htm";  
    }
    
    @RequestMapping(value = "verFacturaVentaPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoPdf(@RequestParam(value = "id") int idPr,ModelMap map) {
       venta prop=new venta();
       String ruta="";
        try{
            List<detalleVenta> ltaP=detalleVentaService.findAllPorVenta(idPr);
            if(ltaP.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=ventaService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("numC", prop.getNum());
                    String rect="NO";
                    String causarect="";
                    if(prop.getRectificactiva()==true){
                        rect="Si";
                        causarect="Causa: "+prop.getCausa();
                    }
                    params.put("rectificativo", rect);
             
                    params.put("causaRec", causarect);
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\contabilidad\\compra\\venta.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\contabilidad\\venta\\Venta"+prop.getCliente_nif().getNif()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("idP",idPr);
                    ruta="verFacturaVentaPdf";
            }else{
                map.addAttribute("msg","error");
                ruta="redirect:Venta.htm";
            }        
        
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("pdfVenta.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idP") int idPr){
        venta prop=new venta();
        prop=ventaService.porId(idPr);
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("id",prop.getCliente_nif().getNif());
        mav.setViewName("pdfVenta");        
        return mav;
    }
    
    @RequestMapping(value = "updateFV.htm",method=RequestMethod.GET)
    public String updateFC_get(ModelMap map,@RequestParam(value = "id") int idPv) {
        String ruta="redirect:updateFacturaVenta.htm";
        try{
            
            idP=idPv;
            tiendaV=new ArrayList<detalleVenta>();
            
                List<detalleVenta> ltaDC=detalleVentaService.findAllPorVenta(idPv);            
                tiendaV=ltaDC;
               
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",new detalleVenta());
        map.addAttribute("tiendaV",tiendaV);
        return (ruta);
    }
    
     @RequestMapping(value = "updateFacturaVenta.htm",method=RequestMethod.GET)
    public String updateFacturaVenta_get(ModelMap map) {
        String ruta="updateFacturaVenta";
        try{
            if(tiendaV.size()==0){
                ruta="redirect:updateProductoVenta.htm";
                
                
            }else{
                for(detalleVenta p:tiendaV){
                    System.out.println("2+"+p.getProductoservicio()+""+p.getTipoiva_id().getId());
                }
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("detalleC",new detalleVenta());
            }
        }catch(Exception ex){}
        
        map.addAttribute("tiendaV",tiendaV);
        
        return (ruta);
    }
    
    @RequestMapping(value = "updateProductoVenta.htm",method=RequestMethod.GET)
    public String updateProducto_get(ModelMap map) {
        detalleVenta dc=new detalleVenta();
        List<tipoiva> ltaTipoIva=null;
        try{
            int i=0;
            for(detalleVenta d:tiendaV){
                i++;
                System.out.println("for tienda:"+i);
            }
            dc.setId(i+1);
            ltaTipoIva=tipoIvaService.findAll();
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",dc);
        map.addAttribute("ltaTipoIva",ltaTipoIva);
        map.addAttribute("tiendaV",tiendaV);
        
        return "updateProductoVenta";
    }
    
    @RequestMapping(value = "updateFFacturaVenta.htm",method=RequestMethod.GET)
    public String updateFFacturadetalleVenta_get(ModelMap map) {
        
        venta c=new venta();
        List<clientes> ltaCliente=null;
        try{
            c=ventaService.porId(idP);
            ltaCliente=clientesService.findAll("");
            Double suma=0.0;
            Double sumaiva=0.0;
            for(detalleVenta dc:tiendaV){
                suma=suma+dc.getDescuento();
                sumaiva=sumaiva+dc.getImpuesto();
            }
            c.setBaseimponible(suma);
            c.setIvatotal(sumaiva);
            c.setTotal(c.getBaseimponible()+c.getIvatotal());
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaCliente",ltaCliente);
        map.addAttribute("ven",c);
        map.addAttribute("tiendaV",tiendaV);
        
        return "updateFFacturaVenta";
    }
    
    @RequestMapping(value = "updateFFacturaVenta.htm",method=RequestMethod.POST)
    public String updateFFacturaVenta_post(@ModelAttribute("ven")venta ven,BindingResult result) {
        String mensaje="";
        //ventaService.Insert(ven);
        try{
            if(ven.getRectificactiva()==false)ven.setCausa("");
            if(ventaService.Update(ven)==true){
                detalleVentaService.DeleteV(ven.getNum());
                for(detalleVenta d:tiendaV){
                    venta com=new venta();
                    com.setNum(ven.getNum());
                    d.setVenta_id(com);
                    
                    detalleVentaService.Insert(d);
                }
            }
            
        }catch(Exception e){
        
        }
         return "redirect:Venta.htm";
        
    }
  
    @RequestMapping(value = "updateAgregarPVenta.htm",method = RequestMethod.POST)
    public String updateAgregarP(@ModelAttribute("detalleC")detalleVenta detalleC,ModelMap map) {
       
        try{
           detalleVenta dc=new detalleVenta();
            dc=agregar(detalleC);
            
            boolean regis=false;
            int i=0;
            
            for(detalleVenta array:tiendaV){               
                     if(array.getId()==dc.getId()){
                     regis=true;
                     break;
                     }
                     i++;
            }
            if(regis==true){
                 tiendaV.set(i, dc);
            }else{
                 tiendaV.add(dc);
            }
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        return "redirect:updateFacturaVenta.htm";
        
    }
    
    @RequestMapping(value = "updateQuitarPVenta.htm",method = RequestMethod.GET)
    public String updateQuitarP(@RequestParam("id")int id,ModelMap map){
    
        for(detalleVenta array:tiendaV){               
                if(array.getId()==id){
                tiendaV.remove(array);
                break;
                }
            }
        return "redirect:updateFacturaVenta.htm";
    }
    
     @RequestMapping(value = "deleteFacturaVenta.htm",method=RequestMethod.GET)
    public String deleteFacturaCompra(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            detalleVentaService.DeleteV(id);
            ventaService.Delete(id);

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Venta.htm";  
    }
    @RequestMapping(value = "VFacturaPagada.htm",method=RequestMethod.GET)
    public String FacturaPagada(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=ventaService.EstadoDePagoT(id);
            if(r==true){
                rpta="success";
            }
            System.out.println("FACTURAPAGADA"+rpta);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Venta.htm";  
    }
    @RequestMapping(value = "VFacturaPendiente.htm",method=RequestMethod.GET)
    public String FacturaPendiente(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=ventaService.EstadoDePagoF(id);
            if(r==true){
                rpta="success";
            }

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Venta.htm";   
    }
    
    @RequestMapping(value="/jsondireccionCliente.json", method=RequestMethod.GET)
    public @ResponseBody clientes loginDisponible(
                                        @RequestParam("nif") String nif) {
      
      clientes data=null;
            try{
                data=clientesService.ByNif(nif);
                
            }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
}
