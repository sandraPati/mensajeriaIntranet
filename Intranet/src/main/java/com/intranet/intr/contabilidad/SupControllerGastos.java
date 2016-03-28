/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.contabilidad;

import com.intranet.beans.formapagogasto;
import com.intranet.beans.gastos;
import com.intranet.beans.gastosR;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipogasto;
import com.intranet.beans.users;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.FormaPagoGastoService;
import com.intranet.service.contabilidad.GastosRService;
import com.intranet.service.contabilidad.GastosService;
import com.intranet.service.contabilidad.TipoGastoService;
import com.intranet.service.proveedores.ProveedoresService;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/sup/*")
public class SupControllerGastos {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private GastosService gastosService;
    @Autowired
    private FormaPagoGastoService formaPagoGastoService;
    @Autowired
    private TipoGastoService tipoGastoService;
    @Autowired
    private ProveedoresService proveedoresService;
    @Autowired
    private GastosRService gastosRService;
    @Autowired
    private UsuarioService usuarioService;
    int idPC=0;
    gastosR gr=new gastosR();
    @RequestMapping("Gastos.htm")
    public ModelAndView DocumentosContratosList(ModelAndView mav){
       
        List<gastos> gastosListbox=null;
        try{
            
            gastosListbox=gastosService.findAll();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("gastosListbox", gastosListbox);
        mav.setViewName("Gastos");        
        return mav;
    }
    
    @RequestMapping(value = "addGasto.htm",method=RequestMethod.GET)
    public String addGasto_get(ModelMap map) {
        gastos gasto=new gastos();
        List<formapagogasto> ltaFormapagoGasto=null;
        List<tipogasto> ltaTipogasto=null;
        List<proveedores> ltaProveedor=null;
        try{
            ltaFormapagoGasto=formaPagoGastoService.findAll();
            ltaTipogasto=tipoGastoService.findAll();
            ltaProveedor=proveedoresService.lista("");
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapagoGasto",ltaFormapagoGasto);
        map.addAttribute("ltaTipogasto",ltaTipogasto);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("gasto",gasto);
        map.addAttribute("mensaje","mensaje");
        
        return "addGasto";
    }
    
    @RequestMapping(value = "addGasto.htm",method=RequestMethod.POST)
    public String addGasto_post(@ModelAttribute("gasto")gastos gasto,BindingResult result,Principal principal) {
        String mensaje="";
        String user=principal.getName();
         users u=null;
        try{
            u=usuarioService.getByLogin(user);
            gasto.setNif(u.getNif());
            gastosService.Insert(gasto);
           
        }catch(Exception e){
        
        }
         return "redirect:Gastos.htm";
        
    }
    
    @RequestMapping(value = "updateGasto.htm",method=RequestMethod.GET)
    public String updateGasto_get(ModelMap map,@RequestParam(value = "id") int id) {
        gastos gasto=new gastos();
        List<formapagogasto> ltaFormapagoGasto=null;
        List<tipogasto> ltaTipogasto=null;
        List<proveedores> ltaProveedor=new ArrayList<proveedores>();
        try{
            gasto=gastosService.porID(id);
            ltaFormapagoGasto=formaPagoGastoService.findAll();
            ltaTipogasto=tipoGastoService.findAll();
            ltaProveedor=proveedoresService.lista("");
            
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapagoGasto",ltaFormapagoGasto);
        map.addAttribute("ltaTipogasto",ltaTipogasto);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("gasto",gasto);
        map.addAttribute("mensaje","mensaje");
        
        return "updateGasto";
    }
    
    @RequestMapping(value = "updateGasto.htm",method=RequestMethod.POST)
    public String updateGasto_post(@ModelAttribute("gasto")gastos gasto,BindingResult result) {
        String mensaje="";
        
        try{
            gastosService.Update(gasto);
        }catch(Exception e){
        
        }
         return "redirect:Gastos.htm";
        
    }
    
    @RequestMapping(value = "deleteGasto.htm",method=RequestMethod.GET)
    public String deleteIngreso(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            gastosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Gastos.htm";
    }
    
    @RequestMapping(value = "GastoPagada.htm",method=RequestMethod.GET)
    public String FacturaPagada(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=gastosService.EstadoDePagoT(id);
            if(r==true){
                rpta="success";
            }
            System.out.println("FACTURAPAGADA"+rpta);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Gastos.htm";  
    }
    @RequestMapping(value = "GastoPendiente.htm",method=RequestMethod.GET)
    public String FacturaPendiente(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="error";
        try{
            boolean r=gastosService.EstadoDePagoF(id);
            if(r==true){
                rpta="success";
            }

        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Gastos.htm";   
    }
    
    @RequestMapping(value = "addGastoR.htm",method=RequestMethod.GET)
    public String addGastoR_get(ModelMap map) {
        gastos gasto=new gastos();
        List<formapagogasto> ltaFormapagoGasto=null;
        List<tipogasto> ltaTipogasto=null;
        List<proveedores> ltaProveedor=null;
        try{
            ltaFormapagoGasto=formaPagoGastoService.findAll();
            ltaTipogasto=tipoGastoService.findAll();
            ltaProveedor=proveedoresService.lista("");
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapagoGasto",ltaFormapagoGasto);
        map.addAttribute("ltaTipogasto",ltaTipogasto);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("gasto",gasto);
        map.addAttribute("mensaje","mensaje");
        
        return "addGastoR";
    }
    
    @RequestMapping(value = "addGastoR.htm",method=RequestMethod.POST)
    public String addGastoR_post(@ModelAttribute("gasto")gastos gasto,BindingResult result,Principal principal) {
        String mensaje="";
        String user=principal.getName();
         users u=null;
        try{
            u=usuarioService.getByLogin(user);
            gasto.setNif(u.getNif());
            gastosService.Insert(gasto);
           idPC=gastosService.ultimo(gasto);
        }catch(Exception e){
        
        }
         return "redirect:addGastoRF.htm";
        
    }
    
     
    @RequestMapping(value = "addGastoRF.htm",method=RequestMethod.GET)
    public String addGastoRF_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ga",new gastosR());
        
        return "addGastoRF";
    }
    
    @RequestMapping(value = "addGastoRF.htm",method=RequestMethod.POST)
    public String addGastoRF_post(@ModelAttribute("ga")gastosR ga,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        String ruta="redirect:Gastos.htm";
        gastosR gr=new gastosR();
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
                    if(idPC!=0){
                    gr.setIdgasto(idPC);
                    if(gastosRService.existe(item.getName())==false){
                    System.out.println("NOMBRE FOTO: "+item.getName());
                    File file=new File(ubicacionArchivo,item.getName());
                    item.write(file);
                    gr.setNombreimg(item.getName());
                        gastosRService.insertar(gr);
                    }
                    }else ruta="redirect:Gastos.htm";
                }
                System.out.println("Archi subido correctamente");
            }
            catch(Exception ex)
            {
                System.out.println("Error al subir archivo"+ex.getMessage());
            }

         return ruta;
        
        
        
    }
    
    @RequestMapping(value = "updateGastoR.htm",method=RequestMethod.GET)
    public String updateGastoR_get(ModelMap map,@RequestParam(value = "id") int id) {
        gastos gasto=new gastos();
        List<formapagogasto> ltaFormapagoGasto=null;
        List<tipogasto> ltaTipogasto=null;
        List<proveedores> ltaProveedor=new ArrayList<proveedores>();
        String nombreimg="";
        try{
            gasto=gastosService.porID(id);
            gastosR gg=gastosRService.porIdGasto(id);
            nombreimg=gg.getNombreimg();
            ltaFormapagoGasto=formaPagoGastoService.findAll();
            ltaTipogasto=tipoGastoService.findAll();
            ltaProveedor=proveedoresService.lista("");
            
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaFormapagoGasto",ltaFormapagoGasto);
        map.addAttribute("ltaTipogasto",ltaTipogasto);
        map.addAttribute("ltaProveedor",ltaProveedor);
        map.addAttribute("gasto",gasto);
        map.addAttribute("nombreimg",nombreimg);
        map.addAttribute("mensaje","mensaje");
        
        return "updateGastoR";
    }
    
    @RequestMapping(value = "updateGastoR.htm",method=RequestMethod.POST)
    public String updateGastoR_post(@ModelAttribute("gasto")gastos gasto,BindingResult result) {
        String mensaje="";
        
        try{
            gastosService.Update(gasto);
        }catch(Exception e){
        
        }
         return "redirect:Gastos.htm";
        
    }
    
    @RequestMapping(value = "deleteGastoR.htm",method=RequestMethod.GET)
    public String deleteGastoR(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        try{
            gastosRService.eliminarGasto(id);
            gastosService.Delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Gastos.htm";
    }
    
    @RequestMapping(value = "updateGastoRF.htm",method=RequestMethod.GET)
    public String EupdateGastoRF_get(ModelMap map,@RequestParam(value = "id") int id) {
        gr.setIdgasto(id);
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ga",gr);
        
        return "updateGastoRF";
    }
    
    @RequestMapping(value = "updateGastoRF.htm",method=RequestMethod.POST)
    public String EupdateGastoRF_post(@ModelAttribute("ga")gastosR ga,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        String ruta="redirect:Gastos.htm";
        
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
                    if(gr.getIdgasto()!=0){
                    
                    if(gastosRService.existe(item.getName())==false){
                        System.out.println("updateeeNOMBRE FOTO: "+item.getName());
                        File file=new File(ubicacionArchivo,item.getName());
                        item.write(file);
                        gr.setNombreimg(item.getName());
                        gastosRService.updateGasto(gr);
                    }
                    }else ruta="redirect:Gastos.htm";
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
