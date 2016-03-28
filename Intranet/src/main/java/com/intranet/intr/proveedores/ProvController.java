/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proveedores;

import com.intranet.beans.compra;
import com.intranet.beans.detalleCompra;
import com.intranet.beans.prov_presup_adj;
import com.intranet.beans.proveedor_presupuesto;
import com.intranet.beans.users;
import com.intranet.intr.conexion;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.CompraService;
import com.intranet.service.contabilidad.DetalleCompraService;
import com.intranet.service.proveedores.ProvPresupAdjService;
import com.intranet.service.proveedores.ProveedorPresupuestoService;
import java.io.File;
import java.security.Principal;
import java.sql.Connection;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/prov/*")
public class ProvController {
    
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ProveedorPresupuestoService proveedorPresupuestoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProvPresupAdjService provPresupAdjService;
    @Autowired
    private CompraService compraService;
    @Autowired
    private DetalleCompraService detalleCompraService;
    private List<prov_presup_adj> arc=new ArrayList<prov_presup_adj>();
    
    
    @RequestMapping(value = "enviarPresupuesto.htm",method=RequestMethod.GET)
    public String enviarPresupuesto_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proveedorPresupuesto",new proveedor_presupuesto());
        map.addAttribute("mensaje","mensaje");
        
        return "enviarPresupuesto";
    }
    
    @RequestMapping(value = "enviarPresupuesto.htm",method=RequestMethod.POST)
    public String enviarPresupuesto_post(@ModelAttribute("proveedorPresupuesto")proveedor_presupuesto proveedorPresupuesto,BindingResult result,Principal principal) {
        String mensaje="";
        String name=principal.getName();
        try{
            System.out.println("registart PRESUPUESTO");
            users u=usuarioService.getByLogin(name);
            proveedorPresupuesto.setId_proveedor(Integer.parseInt(u.getNif()));
            System.out.println(""+proveedorPresupuesto.getDescripcion()+"-"+proveedorPresupuesto.getId_proveedor());
            proveedorPresupuestoService.Insert(proveedorPresupuesto);
            int id=proveedorPresupuestoService.idultimo();
            System.out.println("registart PRESUPUESTO"+id);
                for(prov_presup_adj n:arc){
                    System.out.println("registart PRESUPUESTO"+n);
                    
                    n.setId_prov_presup(id);
                    provPresupAdjService.Insert(n);
                }
            
        }catch(Exception e){
        }
	 
       
       
         return "redirect:LtaPresupuesto.htm";
        
        
        
    }
    
    
    @RequestMapping(value = "enviarPresupuestoA.htm",method=RequestMethod.GET)
    public String enviarPresupuestoA_get(ModelMap map) {
        prov_presup_adj p=new prov_presup_adj();
        arc=new ArrayList<prov_presup_adj>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("provPresupAdj",p);
        return "enviarPresupuestoA";
    }
    
    @RequestMapping(value = "enviarPresupuestoA.htm",method=RequestMethod.POST)
    public String enviarPresupuestoA_post(@ModelAttribute("provPresupAdj")prov_presup_adj provPresupAdj,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        
        try{
            //MultipartFile multipart = c.getArchivo();
            System.out.println("olaEnviarMAILS");
            String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\archivosProveedores";
            //File file=new File(ubicacionArchivo,multipart.getOriginalFilename());
            //String ubicacionArchivo="C:\\";
            
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            ServletFileUpload upload=new ServletFileUpload(factory);
            
            List<FileItem> partes=upload.parseRequest(request);
            
            for(FileItem item : partes)
            {
                System.out.println("NOMBRE FOTO: "+item.getContentType());
                File file=new File(ubicacionArchivo,item.getName());
                
                item.write(file);
                prov_presup_adj pp=new prov_presup_adj();
                pp.setNombre(item.getName());
                pp.setTipo(item.getContentType());
                arc.add(pp);
                System.out.println("img"+item.getName());
            }
            //c.setImagenes(arc);
             
        }catch(Exception ex){
        
        }
         return "redirect:enviarPresupuesto.htm";
        
        
        
    }
    
    @RequestMapping("LtaPresupuesto.htm")
    public String LtaPresupuesto(ModelMap mav,Principal principal,@RequestParam(value = "msg",required=false) String msg){
       String name=principal.getName();
        List<proveedor_presupuesto> lta=null;
        try{
            if(msg!=null & msg!=""){
                if(msg.equals("success")) {
                    mav.addAttribute("msg", "Presupuesto Eliminado Satisfactoriamente");
                   }else{
                       mav.addAttribute("error", "Operacion Rechazada.");
                   }
            }
            users u=usuarioService.getByLogin(name);
            lta=proveedorPresupuestoService.findAll(Integer.parseInt(u.getNif()));
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("lta", lta);
                
        return "LtaPresupuesto";
    }
    
    @RequestMapping("PverPPresupuesto.htm")
    public ModelAndView verPPresupuestos(ModelAndView mav,@RequestParam(value = "idP") int id){
        proveedor_presupuesto lta=null;
        List<prov_presup_adj> ltaArc=null;
        List<String> archivos=null;
        List<String> imagenes=null;
        try{
            lta=proveedorPresupuestoService.porID(id);
            ltaArc=provPresupAdjService.findAll(id);
            /*for(prov_presup_adj pp:ltaArc){
                if(pp.getTipo().startsWith("i")){
                    imagenes.add(pp.getNombre());
                }else archivos.add(pp.getNombre());
            }*/
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("ltaArc", ltaArc);
        
        mav.setViewName("PverPPresupuesto");        
        return mav;
    }
    
    @RequestMapping("ProvFacturas.htm")
    public ModelAndView ProvFacturas(ModelAndView mav,Principal principal){
       String name=principal.getName();
        List<compra> compraListbox=null;
        try{
            users u=usuarioService.getByLogin(name);
            compraListbox=compraService.findAllProveedor(Integer.parseInt(u.getNif()));
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("compraListbox", compraListbox);
        mav.setViewName("ProvFacturas");        
        return mav;
    }
    
    @RequestMapping(value = "PverFacturaCompraPdf.htm",method=RequestMethod.GET)
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
                    ruta="PverFacturaCompraPdf";
            }else{
                map.addAttribute("msg","error");
                ruta="redirect:ProvFacturas.htm";
            }        
        
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("PpdfCompra.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idP") int idPr){
        compra prop=new compra();
        prop=compraService.porId(idPr);
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("id",prop.getProveeedor_id().getId());
        mav.setViewName("PpdfCompra");        
        return mav;
    }
    
    @RequestMapping(value = "deletePresupProv.htm",method=RequestMethod.GET)
    public String AsiganrPresupuesto(@RequestParam(value = "idP") int idP,ModelMap map) {
        String rpta="";
        try{
            int ra=proveedorPresupuestoService.existeAsignado(idP);
            if(ra!=0){
            boolean r=provPresupAdjService.Delete(idP);
            if(r==true){
                boolean r2=proveedorPresupuestoService.Delete(idP);
                if(r2==true){
                    map.addAttribute("msg","success");
                }else map.addAttribute("msg","error");
            }else map.addAttribute("msg","error");
            }else map.addAttribute("msg","error");
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:LtaPresupuesto.htm";  
    }
    
    @RequestMapping(value = "updatePresupProv.htm",method=RequestMethod.GET)
    public String updatePresupProv_get(ModelMap map,@RequestParam(value = "idP") int id) {
        proveedor_presupuesto lta=null;
        List<prov_presup_adj> ltaArc=null;
        try{
            lta=proveedorPresupuestoService.porID(id);
            ltaArc=provPresupAdjService.findAll(id);
           
        }catch(Exception e){
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("presup",lta);
        map.addAttribute("archivos",ltaArc);
        map.addAttribute("idP",id);
        
        return "updatePresupProv";
    }
    
    @RequestMapping(value = "updatePresupProv.htm",method=RequestMethod.POST)
    public String updateProveedor_post(@ModelAttribute("presup")proveedor_presupuesto presup,BindingResult result) {
        String mensaje="";
        try{
            proveedorPresupuestoService.Update(presup);
            
        }catch(Exception e){
        }
         return "redirect:LtaPresupuesto.htm";
        
    }
    @RequestMapping(value = "deletePresupProvID.htm",method=RequestMethod.GET)
    public String deletePresupProv(@RequestParam(value = "idP") int idP,@RequestParam(value = "idA") int idA,ModelMap map) {
        String rpta="";
        try{
            provPresupAdjService.DeleteID(idA);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:updatePresupProv.htm?idP="+idP;  
    }
    
    int idPr=0;
    @RequestMapping(value = "updateArchivos.htm",method=RequestMethod.GET)
    public String updateArchivos_get(ModelMap map,@RequestParam(value = "idP") int id) {
        prov_presup_adj p=new prov_presup_adj();
       
        idPr=id;
        arc=new ArrayList<prov_presup_adj>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("provPresupAdj",p);
        map.addAttribute("idP",id);
        return "updateArchivos";
    }
    
    @RequestMapping(value = "updateArchivos.htm",method=RequestMethod.POST)
    public String updateArchivos_post(@ModelAttribute("provPresupAdj")prov_presup_adj provPresupAdj,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        
        try{
            
            String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\archivosProveedores";
            //File file=new File(ubicacionArchivo,multipart.getOriginalFilename());
            //String ubicacionArchivo="C:\\";
            
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            ServletFileUpload upload=new ServletFileUpload(factory);
            
            List<FileItem> partes=upload.parseRequest(request);
            
            for(FileItem item : partes)
            {
                System.out.println("NOMBRE FOTO: "+item.getContentType());
                File file=new File(ubicacionArchivo,item.getName());
                
                item.write(file);
                prov_presup_adj pp=new prov_presup_adj();
                pp.setId_prov_presup(idPr);
                pp.setNombre(item.getName());
                pp.setTipo(item.getContentType());
                provPresupAdjService.Insert(pp);
            }
            //c.setImagenes(arc);
             
        }catch(Exception ex){
        
        }
         return "redirect:updatePresupProv.htm?idP="+idPr;
        
        
        
    }
}
