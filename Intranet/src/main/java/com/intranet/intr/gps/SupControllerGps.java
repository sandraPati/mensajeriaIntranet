/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.gps;

import com.intranet.beans.empleados;
import com.intranet.beans.gps;
import com.intranet.intr.conexion;
import com.intranet.service.EmpleadoService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.gps.GpsService;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class SupControllerGps {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private GpsService gpsService;
    @Autowired
    private EmpleadoService empleadoService;
    
    @RequestMapping("SeguimientoGPS.htm")
    public ModelAndView SeguimientoGPS(ModelAndView mav){
       
        List<empleados> empleadosListbox=null;
        try{
            
            empleadosListbox=empleadoService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("empleadosListbox", empleadosListbox);
        mav.setViewName("SeguimientoGPS");        
        return mav;
    }
    private String nif1="";
    @RequestMapping(value="SeguimientoGPSEmpleado.htm", method = RequestMethod.GET)
    public ModelAndView SeguimientoGPSEmpleado(@RequestParam(value = "nif") String nif,@RequestParam(value = "f", required = false)  String fecha,ModelAndView mav){
       
        nif1=nif;
        gps g1=new gps();
        gps gpsListbox=null;
        List<gps> gpsListaHoy=null;
        try{
           if(gpsService.validaExiste(nif)==true){
            gpsListbox=gpsService.findAll(nif);
           }
            if(fecha!=null && fecha!=""){
                gpsListaHoy=gpsService.findFecha(nif,fecha);
            }else{
                gpsListaHoy=gpsService.findAllHoy(nif);
            }
             
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("gpsListbox", gpsListbox);
        mav.addObject("gpsListaHoy", gpsListaHoy);
        mav.addObject("gps1", g1);
        mav.addObject("nif", nif);
        mav.addObject("f", fecha);
        mav.setViewName("SeguimientoGPSEmpleado");        
        return mav;
    }
    @RequestMapping(value = "SeguimientoGPSEmpleado.htm",method=RequestMethod.POST)
    public String addCliente_post(@ModelAttribute("gps1")gps gps1,BindingResult result,ModelMap mav) {
        mav.addAttribute("nif", gps1.getNif_user());
        mav.addAttribute("f", gps1.getFecha());
         return "redirect:SeguimientoGPSEmpleado.htm";
        
    }
    
    @RequestMapping("SeguimientoGPSEmpleadoFecha.htm")
    public String SeguimientoGPSEmpleadoFecha(ModelMap mav,@RequestParam(value = "nif", required = false) String nif,@RequestParam(value = "fecha", required = false)  String fecha){
       List<gps> gpsListbox=null;
       try{
            gpsListbox=gpsService.findFecha(nif,fecha);
        }catch(Exception e){
        
        }
       System.out.println("nif:"+nif);
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("nif",nif); 
        mav.addAttribute("gpsListbox",gpsListbox); 
        mav.addAttribute("menu",r);       
        return "SeguimientoGPSEmpleadoFecha";
    }
    
    @RequestMapping("SeguimientoGPSfecha.htm")
    @ResponseBody
    public String fecha_post(@RequestParam String fecha,@RequestParam String nif,HttpServletRequest request,
        HttpServletResponse response, Model model ) {
        String mensaje="";
        List<gps> gpsListbox=null;
        try{
            gpsListbox=gpsService.findFecha(nif, fecha);
        }catch(Exception e){
        
        }
         return "error exist";
        
    }
    
    
    @RequestMapping(value = "GpsPdf.htm",method=RequestMethod.GET)
    public String GpsPdf(@RequestParam(value = "nif") String nif,@RequestParam(value = "f",required = false) String f,ModelMap map) {
      
        try{
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("nif", nif);
                    if(f!=null & f!=""){
                        params.put("fecha", f);
                    }else{
                       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date();
                        params.put("fecha", ""+dateFormat.format(date));
                    }
                    
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\gps\\gps.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\gps\\Gps"+nif+".pdf");

        
                 }catch(Exception e){

               }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nif",nif);
        map.addAttribute("f",f);
        return("GpsPdf");
    }
    
    @RequestMapping("pdfGpsPdf.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "nif") String nif,@RequestParam(value = "f") String f){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.addObject("f",f);
        mav.setViewName("pdfGpsPdf");        
        return mav;
    }
}
