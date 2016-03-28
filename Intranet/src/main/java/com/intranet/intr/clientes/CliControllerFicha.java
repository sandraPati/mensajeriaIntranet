/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.clientes;

import com.intranet.beans.clientes;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.presupuesto;
import com.intranet.beans.propuesta;
import com.intranet.beans.proyecto_certificaciones_galeria;
import com.intranet.beans.proyecto_trabajadores;
import com.intranet.beans.users;
import com.intranet.intr.conexion;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ArmariosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.EstanciasService;
import com.intranet.service.propuesta.PanosService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.propuesta.PuertasService;
import com.intranet.service.propuesta.VentanaService;
import com.intranet.service.proyecto.ProyectoCertificacionesGaleriaService;
import com.intranet.service.proyecto.ProyectoCertificacionesService;
import com.intranet.service.proyecto.ProyectoTrabajadoresService;
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
@RequestMapping("/cli/*")
public class CliControllerFicha {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private EstanciasService estanciasService;
    @Autowired
    private PanosService panosService;
    @Autowired
    private VentanaService ventanaService;
    @Autowired
    private PuertasService puertasService;
    @Autowired
    private ArmariosService armariosService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private ProyectoCertificacionesService proyectoCertificacionesService;
    @Autowired
    private ProyectoTrabajadoresService proyectoTrabajadoresService;
    @Autowired
    private ProyectoCertificacionesGaleriaService proyectoCertificacionesGaleriaService;
    int idP=0;
    String nifC="";
    
    @RequestMapping("CfichaCliente.htm")
    public String verPropuestas(Principal principal,@RequestParam(value = "msg", required = false) String msg,ModelMap map) {
        String name=principal.getName();
        users u=null;
        List<propuesta> ltaPropuestas=null;
        List<propuesta> ltaProyectos=null;
        clientes c=null;
        try{
            if(msg!=null & msg!=""){
                if (msg.equals("error")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro el Presupuesto del Proyecto");
                }else if (msg.equals("errorC")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro la Certificacion del Proyecto");
                }else if (msg.equals("errorPlanObra")) {
                    map.addAttribute("error", "Operacion rechazada. No se encontro el Plan de Obra del Proyecto");
                }
            }
            u=usuarioService.getByLogin(name);
            //empleado=empleadoService.ByNif(nif); 
            ltaPropuestas=propuestasService.filtroC(u.getNif());
            ltaProyectos=propuestasService.filtroCProy(u.getNif());
            c=clientesService.ByNif(u.getNif());
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaPropuestas",ltaPropuestas);
        map.addAttribute("ltaProyectos",ltaProyectos);
        map.addAttribute("cliente",c);
        return("CfichaCliente");
        
    }
    
    @RequestMapping("CfichaverPropuesta.htm")
    public String fichaverPropuesta(@RequestParam(value = "idP") int id,ModelMap map) {
        List<estancias> ltaEstancias=null;
        List<estancias> ltaEstancias2=new ArrayList<estancias>();
        
        propuesta pro=new propuesta();
        try{
            float totalSpanos=0;
            float superficie=0;
	float TotalSventanas=0;
	float TotalSpuertas=0;
	float TotalSarmarios=0;
	float TotalSsuelos=0;
	float TotalStechos=0;
                int numventanaP=0;
                int numpuertaP=0;
                int numarmarioP=0;
            pro=propuestasService.porId(id);
            ltaEstancias=estanciasService.listaPropuesta(id);
            for(estancias e: ltaEstancias){
                List<panos> ltaPanos=null;
                int numventana=0;
                int numpuerta=0;
                int numarmario=0;
                ltaPanos=panosService.findAll(e.getId());
                for(panos pa:ltaPanos){
                    numventana=numventana+pa.getNumventanas();
                    numpuerta=numpuerta+pa.getNumpuertas();
                    numarmario=numarmario+pa.getNumarmarios();
                    pa.setVentanaspano(ventanaService.findAll(pa.getId()));
                    pa.setPuertaspano(puertasService.findAll(pa.getId()));
                    pa.setArmariospano(armariosService.findAll(pa.getId()));
                }
                e.setNumventanas(numventana);
                e.setNumpuertas(numpuerta);
                e.setNumarmarios(numarmario);
                e.setLtaPanos(ltaPanos);
                ltaEstancias2.add(e);
                totalSpanos=totalSpanos+e.getTotalSpanos();
                superficie=superficie+e.getSuperficie();
                TotalSventanas=TotalSventanas+e.getTotalSventanas();
                TotalSpuertas=TotalSpuertas+e.getTotalSpuertas();
                TotalSarmarios=TotalSarmarios+e.getTotalSarmarios();
                TotalSsuelos=TotalSsuelos+e.getTotalSsuelos();
                TotalStechos=TotalStechos+e.getTotalStechos();
                    numventanaP=numventanaP+e.getNumventanas();
                    numpuertaP=numpuertaP+e.getNumpuertas();
                    numarmarioP=numarmarioP+e.getNumarmarios();
            }
            pro.setTotalSpanos(totalSpanos);
            pro.setSuperficie(superficie);
            pro.setTotalSventanas(TotalSventanas);
            pro.setTotalSpuertas(TotalSpuertas);
            pro.setTotalSarmarios(TotalSarmarios);
            pro.setTotalSsuelos(TotalSsuelos);
            pro.setTotalStechos(TotalStechos);
            pro.setNumventanas(numventanaP);
            pro.setNumpuertas(numpuertaP);
            pro.setNumarmarios(numarmarioP);
            
            
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("ltaEstancias",ltaEstancias2);
        map.addAttribute("prop",pro);
        return("CfichaverPropuesta");
        
    }
    
     @RequestMapping(value = "CFichaverPresupuestoPdf.htm",method=RequestMethod.GET)
    public String verPresupuestoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=null;
       String ruta="";
        try{
            List<presupuesto> ltaP=presupuestosService.presupuestoPropuesta(idPr);
            if(ltaP.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idpropuesta", idPr);
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\presupuesto\\presupuesto.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\propuestas\\presupuesto\\Presupuesto"+prop.getCliente_nif().getNif()+".pdf");
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("nif",prop.getCliente_nif().getNif());
                ruta="CFichaverPresupuestoPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","error");
                ruta="redirect:CfichaCliente.htm";
            }       
        }catch(Exception e){

        }
        
        return(ruta);
    }
    
    @RequestMapping("CFichapdfPresupuestoPdf.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("CFichapdfPresupuestoPdf");        
        return mav;
    }
     @RequestMapping(value = "CFichaverCertificacionesPdf.htm",method=RequestMethod.GET)
    public String FichaverCertificacionesPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       propuesta prop=null;
      String ruta="";
        try{
            int res=proyectoCertificacionesService.existeCertificaciones(idPr);
            if(res!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("propuesta_id", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\certificaciones\\certificaciones.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proyecto\\certificaciones\\Certificaciones"+prop.getCliente_nif().getNif()+".pdf");
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                map.addAttribute("nif",prop.getCliente_nif().getNif());
                ruta="CFichaverCertificacionesPdf";
            }else{
                System.out.println("NO hay certificaciones");
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","errorC");
                ruta="redirect:CfichaCliente.htm";
            }       
        }catch(Exception e){

        }
        
        return(ruta);
    }
    
    @RequestMapping("CFichapdfCertificacionesPdf.htm")
    public ModelAndView pdfCertificacionesPdf(ModelAndView mav,@RequestParam(value = "nif") String nif){
        
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",nif);
        mav.setViewName("CFichapdfCertificacionesPdf");        
        return mav;
    }
    
    
    
    private propuesta prop=new propuesta();
    @RequestMapping(value = "CFichaverContratoPdf.htm",method=RequestMethod.GET)
    public String verContratoPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       
        try{
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idPropuesta", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\propuestas\\propuestaContratoCliente.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\clientesFicha\\ContratoPropuesta"+prop.getCliente_nif().getNif()+".pdf");

        
                 }catch(Exception e){

               }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        //map.addAttribute("idP",idPr);
        return("CFichaverContratoPdf");
    }
    
    @RequestMapping("pdfCFichaContratoProyecto.htm")
    public ModelAndView pdf(ModelAndView mav){
        //propuesta prop=new propuesta();
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("pdfCFichaContratoProyecto");        
        return mav;
    }
    
    @RequestMapping(value = "verCFichaPlanObraPdf.htm",method=RequestMethod.GET)
    public String verPlanObraPdf(@RequestParam(value = "idP") int idPr,ModelMap map) {
       String ruta="";
        try{
            List<proyecto_trabajadores> ltaPT=proyectoTrabajadoresService.findAllPropuesta(idPr);
            if(ltaPT.size()!=0){
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
                prop=propuestasService.porId(idPr);
                
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idPropuesta", prop.getId());
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proyecto\\planObra\\planObra.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\clientesFicha\\PlanObra"+prop.getCliente_nif().getNif()+".pdf");
                String r=validaInterfacesRoles.valida();
                map.addAttribute("menu",r);
                ruta="verCFichaPlanObraPdf";
            }else{
                prop=propuestasService.porId(idPr);
                map.addAttribute("msg","errorPlanObra");
                ruta="redirect:CfichaCliente.htm";
            }       
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("pdfCFichaPlanObraPdf.htm")
    public ModelAndView pdfPlanObra(ModelAndView mav){
        //propuesta prop=new propuesta();
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("nif",prop.getCliente_nif().getNif());
        mav.setViewName("pdfCFichaPlanObraPdf");        
        return mav;
    }
   
    
    @RequestMapping(value = "CProyectoGaleria.htm",method=RequestMethod.GET)
    public String ProyectoGaleria_get(ModelMap map,@RequestParam(value = "id") int id) {
        List<proyecto_certificaciones_galeria> ltaFotos=new ArrayList<proyecto_certificaciones_galeria>();
        try{
            
            ltaFotos=proyectoCertificacionesGaleriaService.listaProyecto(id);
            idP=id;
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);        
        map.addAttribute("fotogaleria",new proyecto_certificaciones_galeria());
         map.addAttribute("ltaFotos",ltaFotos);
        return "CProyectoGaleria";
    }
    
    
    
    @RequestMapping(value = "CProyectoGaleriaDelete.htm",method=RequestMethod.GET)
    public String ProyectoGaleriaDelete(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        proyecto_certificaciones_galeria p=null;
        try{
            
            proyectoCertificacionesGaleriaService.eliminar(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:CProyectoGaleria.htm?nifC="+nifC+"&id="+idP;
    }
    
    
     @RequestMapping(value = "CProyectoGaleria.htm",method=RequestMethod.POST)
    public String ProyectoGaleria_post(@ModelAttribute("fotogaleria")proyecto_certificaciones_galeria galer,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        //C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosCertificaciones";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    String ruta="redirect:CProyectoGaleria.htm?nifC="+nifC+"&id="+idP;
    try{
        List<FileItem> partes=upload.parseRequest(request);
        for(FileItem item : partes)
        {
            if(idP!=0){
            galer.setIdPropuesta(idP);
            if(proyectoCertificacionesGaleriaService.existe(item.getName())==false){
            
            File file=new File(ubicacionArchivo,item.getName());
            item.write(file);
            galer.setNombreimg(item.getName());
                proyectoCertificacionesGaleriaService.insertar2(galer);
            }
            }else ruta="redirect:CfichaCliente.htm";
        }
        System.out.println("Archi subido correctamente");
    }
    catch(Exception ex)
    {
        System.out.println("Error al subir archivo"+ex.getMessage());
    }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return ruta;
        
    }
}
