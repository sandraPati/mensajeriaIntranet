/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.contabilidad;

import com.intranet.beans.compra;
import com.intranet.beans.compraR;
import com.intranet.beans.detalleCompra;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipogasto;
import com.intranet.beans.tipoiva;
import com.intranet.beans.users;
import com.intranet.intr.conexion;
import com.intranet.intr.mensajesEmail.mensajeContabilidad;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.CompraRService;
import com.intranet.service.contabilidad.CompraService;
import com.intranet.service.contabilidad.DetalleCompraService;
import com.intranet.service.contabilidad.ResumenCuadroMandoService;
import com.intranet.service.contabilidad.TipoGastoService;
import com.intranet.service.contabilidad.TipoIvaService;
import com.intranet.service.proveedores.ProveedoresService;
import java.io.File;
import java.security.Principal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
public class SupControllerFacturaCompra {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CompraService compraService;
    @Autowired
    private CompraRService compraRService;
    @Autowired
    private DetalleCompraService detalleCompraService;
    @Autowired
    private ProveedoresService proveedoresService;       
    @Autowired
    private TipoIvaService tipoIvaService;
    @Autowired
    private TipoGastoService tipoGastoService;
    @Autowired
    private ResumenCuadroMandoService resumenCuadroMandoService;
            
    private List<detalleCompra> tiendaV=new ArrayList<detalleCompra>();
    private int idP=0;
    int idPC=0;
    compraR gr=new compraR();
    
    @RequestMapping("Compra.htm")
    public String DocumentosContratosList(ModelMap mav,@RequestParam(value = "msg", required = false) String msg){
        tiendaV=new ArrayList<detalleCompra>();
        idP=0;
        List<compra> compraListbox=null;
        try{
            if(msg!=null & msg!=""){
                if(msg.equals("success")) {
                    mav.addAttribute("msg", "Factura Enviada");
                }else if (msg.equals("error")) {
                    mav.addAttribute("error", "Operacion rechazada, La Factura no contiene Productos/Servicios");
                }
            }
            compraListbox=compraService.findAll();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("tiendaV", tiendaV);
        mav.addAttribute("compraListbox", compraListbox);
        //mav.setViewName("Compra");        
        return ("Compra");
    }
    
    
    
    @RequestMapping(value = "FacturaCompra.htm",method=RequestMethod.GET)
    public String FacturaCompra_get(ModelMap map) {
        String ruta="FacturaCompra";
        try{
            if(tiendaV.size()==0){
                ruta="redirect:addProducto.htm";
                
                
            }else{
                for(detalleCompra p:tiendaV){
                    System.out.println("2+"+p.getProductoservicio()+""+p.getTipoiva_id().getId());
                }
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("detalleC",new detalleCompra());
            }
        }catch(Exception ex){}
        
        map.addAttribute("tiendaV",tiendaV);
        
        return (ruta);
    }
    
    @RequestMapping(value = "addProducto.htm",method=RequestMethod.GET)
    public String addProducto_get(ModelMap map) {
        detalleCompra dc=new detalleCompra();
        List<tipoiva> ltaTipoIva=null;
        List<tipogasto> ltaTipoGasto=null;
        try{
            int i=0;
            for(detalleCompra d:tiendaV){
                i++;
                System.out.println("for tienda:"+i);
            }
            dc.setId(i+1);
            ltaTipoIva=tipoIvaService.findAll();
            ltaTipoGasto=tipoGastoService.findAll();
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",dc);
        map.addAttribute("ltaTipoIva",ltaTipoIva);
        map.addAttribute("ltaTipoGasto",ltaTipoGasto);
        map.addAttribute("tiendaV",tiendaV);
        
        return "addProducto";
    }
    
    @RequestMapping(value = "addFacturaCompra.htm",method=RequestMethod.GET)
    public String addFacturaCompra_get(ModelMap map) {
        
        compra c=new compra();
        List<proveedores> ltaProveedor=null;
        try{
            ltaProveedor=proveedoresService.lista("");
            Double suma=0.0;
            Double sumaiva=0.0;
            for(detalleCompra dc:tiendaV){
                suma=suma+dc.getDescuento();
                sumaiva=sumaiva+dc.getImpuesto();
            }
            c.setBaseimponible(suma);
            c.setIvatotal(sumaiva);
            c.setTotal(c.getBaseimponible()+c.getIvatotal());
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("comp",c);
        map.addAttribute("tiendaV",tiendaV);
        
        return "addFacturaCompra";
    }
    
    @RequestMapping(value = "addFacturaCompra.htm",method=RequestMethod.POST)
    public String addFacturaCompra_post(@ModelAttribute("comp")compra comp,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        users u=null;
        try{
            u=usuarioService.getByLogin(name);
            if(comp.getRetificativo()==false)comp.setCausaretificativo("");
            comp.setNif(u.getNif());
            if(compraService.Insert(comp)==true){
                int cod=compraService.ultimocompra();
                for(detalleCompra d:tiendaV){
                    compra com=new compra();
                    com.setNum(cod);
                    d.setCompra_id(com);
                    
                    detalleCompraService.Insert(d);
                }
            }
            
        }catch(Exception e){
        
        }
         return "redirect:Compra.htm";
        
    }
  
    @RequestMapping(value = "AgregarP.htm",method = RequestMethod.POST)
    public String AgregarP(@ModelAttribute("detalleC")detalleCompra detalleC,ModelMap map) {
        
        try{
            boolean regis=false;
            int i=0;
            detalleCompra dc=new detalleCompra();
            dc=agregar(detalleC);
            for(detalleCompra array:tiendaV){               
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
        return "redirect:FacturaCompra.htm";
        
    }
    
    @RequestMapping(value = "QuitarP.htm",method = RequestMethod.GET)
    public String QuitarP(@RequestParam("id")int id,ModelMap map){
    
        for(detalleCompra array:tiendaV){               
                if(array.getId()==id){
                tiendaV.remove(array);
                break;
                }
            }
        return "redirect:FacturaCompra.htm";
    }
    
    public detalleCompra agregar(detalleCompra detalleC){
    detalleCompra dc=new detalleCompra();
            dc.setProductoservicio(detalleC.getProductoservicio());
            dc.setCantidad(detalleC.getCantidad());
            dc.setPrecio(detalleC.getPrecio());
            dc.setTotalcp(detalleC.getCantidad()*detalleC.getPrecio());
            dc.setPorcentajedescuento(detalleC.getPorcentajedescuento());
            
            dc.setDescuento(dc.getTotalcp()-(dc.getTotalcp()*detalleC.getPorcentajedescuento()));
            
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
            
            
            dc.setTotalimp(dc.getDescuento()+dc.getImpuesto());
            
            dc.setId(detalleC.getId());
            
            dc.setTipogasto_id(tipoGastoService.porId(detalleC.getTipogasto_id().getId()));
            return dc;
    }
    
    @RequestMapping(value = "verFacturaCompraPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoPdf(@RequestParam(value = "id") int idPr,ModelMap map) {
       compra prop=new compra();
       String ruta="";
        try{
            List<detalleCompra> ltaP=detalleCompraService.findAllPorCompra(idPr);
            if(ltaP.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=compraService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("numC", prop.getNum());
                    String rect="NO";
                    String causarect="";
                    if(prop.getRetificativo()==true){
                        rect="Si";
                        causarect="Causa: "+prop.getCausaretificativo();
                    }
                    params.put("rectificativo", rect);
             
                    params.put("causaRec", causarect);
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\contabilidad\\compra\\compra.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\contabilidad\\compra\\Compra"+prop.getProveeedor_id().getId()+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("idP",idPr);
                    ruta="verFacturaCompraPdf";
            }else{
                map.addAttribute("msg","error");
                ruta="redirect:Compra.htm";
            }        
        
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("pdfCompra.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idP") int idPr){
        compra prop=new compra();
        prop=compraService.porId(idPr);
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("id",prop.getProveeedor_id().getId());
        mav.setViewName("pdfCompra");        
        return mav;
    }
    @RequestMapping(value = "updateFC.htm",method=RequestMethod.GET)
    public String updateFC_get(ModelMap map,@RequestParam(value = "id") int idPv) {
        String ruta="redirect:updateFacturaCompra.htm";
        try{
            
            idP=idPv;
            tiendaV=new ArrayList<detalleCompra>();
            
                List<detalleCompra> ltaDC=detalleCompraService.findAllPorCompra(idPv);            
                tiendaV=ltaDC;
               
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",new detalleCompra());
        map.addAttribute("tiendaV",tiendaV);
        return (ruta);
    }
    @RequestMapping(value = "updateFacturaCompra.htm",method=RequestMethod.GET)
    public String updateFacturaCompra_get(ModelMap map) {
        String ruta="updateFacturaCompra";
        try{
            if(tiendaV.size()==0){
                ruta="redirect:updateProducto.htm";
                
                
            }else{
                for(detalleCompra p:tiendaV){
                    System.out.println("2+"+p.getProductoservicio()+""+p.getTipoiva_id().getId());
                }
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("detalleC",new detalleCompra());
            }
        }catch(Exception ex){}
        
        map.addAttribute("tiendaV",tiendaV);
        return (ruta);
    }
   
    @RequestMapping(value = "updateProducto.htm",method=RequestMethod.GET)
    public String updateProducto_get(ModelMap map) {
        detalleCompra dc=new detalleCompra();
        List<tipoiva> ltaTipoIva=null;
        List<tipogasto> ltaTipoGasto=null;
        try{
            int i=0;
            for(detalleCompra d:tiendaV){
                i++;
                System.out.println("for tienda:"+i);
            }
            dc.setId(i+1);
            ltaTipoIva=tipoIvaService.findAll();
            ltaTipoGasto=tipoGastoService.findAll();
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("detalleC",dc);
        map.addAttribute("ltaTipoIva",ltaTipoIva);
        map.addAttribute("ltaTipoGasto",ltaTipoGasto);
        map.addAttribute("tiendaV",tiendaV);
        return "updateProducto";
    }
    
    @RequestMapping(value = "updateFFacturaCompra.htm",method=RequestMethod.GET)
    public String updateFFacturaCompra_get(ModelMap map) {
        
        compra c=new compra();
        List<proveedores> ltaProveedor=null;
        try{
            c=compraService.porId(idP);
            ltaProveedor=proveedoresService.lista("");
            Double suma=0.0;
            Double sumaiva=0.0;
            for(detalleCompra dc:tiendaV){
                suma=suma+dc.getDescuento();
                sumaiva=sumaiva+dc.getImpuesto();
            }
            c.setBaseimponible(suma);
            c.setIvatotal(sumaiva);
            c.setTotal(c.getBaseimponible()+c.getIvatotal());
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("comp",c);
        map.addAttribute("tiendaV",tiendaV);
        map.addAttribute("idP",idP);
        return "updateFFacturaCompra";
    }
    
    @RequestMapping(value = "updateFFacturaCompra.htm",method=RequestMethod.POST)
    public String updateFFacturaCompra_post(@ModelAttribute("comp")compra comp,BindingResult result) {
        String mensaje="";
        
        try{
            if(comp.getRetificativo()==false)comp.setCausaretificativo("");
            if(compraService.Update(comp)==true){
                //int cod=compraService.ultimocompra();
                detalleCompraService.DeleteC(comp.getNum());
                for(detalleCompra d:tiendaV){
                    compra com=new compra();
                    com.setNum(comp.getNum());
                    d.setCompra_id(com);
                    
                    detalleCompraService.Insert(d);
                }
            }
            
        }catch(Exception e){
        
        }
         return "redirect:Compra.htm";
        
    }
    
    @RequestMapping(value = "updateAgregarP.htm",method = RequestMethod.POST)
    public String updateAgregarP(@ModelAttribute("detalleC")detalleCompra detalleC,ModelMap map) {
        
        try{
            boolean regis=false;
            int i=0;
            detalleCompra dc=new detalleCompra();
            dc=agregar(detalleC);
            for(detalleCompra array:tiendaV){               
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
        return "redirect:updateFacturaCompra.htm";
        
    }
    
    @RequestMapping(value = "updateQuitarP.htm",method = RequestMethod.GET)
    public String updateQuitarP(@RequestParam("id")int id,ModelMap map){
    
        for(detalleCompra array:tiendaV){               
                if(array.getId()==id){
                tiendaV.remove(array);
                break;
                }
            }
        return "redirect:updateFacturaCompra.htm";
    }
    
    @RequestMapping(value = "deleteFacturaCompra.htm",method=RequestMethod.GET)
    public String deleteFacturaCompra(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            detalleCompraService.DeleteC(id);
            compraService.Delete(id);

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Compra.htm";  
    }
    @RequestMapping(value = "FacturaPagada.htm",method=RequestMethod.GET)
    public String FacturaPagada(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=compraService.EstadoDePagoT(id);
            if(r==true){
                rpta="success";
            }
            System.out.println("FACTURAPAGADA"+rpta);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Compra.htm";  
    }
    @RequestMapping(value = "FacturaPendiente.htm",method=RequestMethod.GET)
    public String FacturaPendiente(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=compraService.EstadoDePagoF(id);
            if(r==true){
                rpta="success";
            }

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Compra.htm";   
    }
    
    @RequestMapping(value="/jsondireccionProveedor.json", method=RequestMethod.GET)
    public @ResponseBody proveedores loginDisponible(
                                        @RequestParam("id") int id) {
      
      proveedores data=null;
            try{
                data=proveedoresService.porId(id);
                
            }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    
    @RequestMapping(value="/jsonCompraImgS.json", method=RequestMethod.GET)
    public @ResponseBody compraR jsonCompraImg(
                                        @RequestParam("id") int id) {
      System.out.println("COPMRA: "+id);
      compraR data=null;
            try{
                data=compraRService.porIdCompra(id);
                
            }catch(Exception ex){}
            //si no lo está, generamos las sugerencias con la ayuda del IUsuarioBO
            return data;
    }
    
     @RequestMapping(value = "updateFacturaCompraRF.htm",method=RequestMethod.GET)
    public String EupdateGastoRF_get(ModelMap map,@RequestParam(value = "id") int id) {
        gr.setIdcompra(id);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ga",gr);
        
        return "updateFacturaCompraRF";
    }
    
    @RequestMapping(value = "updateFacturaCompraRF.htm",method=RequestMethod.POST)
    public String EupdateGastoRF_post(@ModelAttribute("ga")compraR ga,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        String ruta="redirect:Compra.htm";
        
            //MultipartFile multipart = c.getArchivo();
            System.out.println("olaEnviarMAILS");
            String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosfacturas";
            //File file=new File(ubicacionArchivo,multipart.getOriginalFilename());
            //String ubicacionArchivo="C:\\";
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024);

            ServletFileUpload upload=new ServletFileUpload(factory);

            try{
                List<FileItem> partes=upload.parseRequest(request);
                for(FileItem item : partes)
                {
                    if(gr.getIdcompra()!=0){
                    
                    if(compraRService.existe(item.getName())==false){
                        System.out.println("updateeeNOMBRE FOTO: "+item.getName());
                        File file=new File(ubicacionArchivo,item.getName());
                        item.write(file);
                        gr.setNombreimg(item.getName());
                        compraRService.updateCompra(gr);
                    }
                    }else ruta="redirect:Compra.htm";
                }
                System.out.println("Archi subido correctamente");
            }
            catch(Exception ex)
            {
                System.out.println("Error al subir archivo"+ex.getMessage());
            }

         return ruta;
        
        
        
    }
    
}
