/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proyecto;

import com.intranet.beans.armarios;
import com.intranet.beans.clientes;
import com.intranet.beans.estancias;
import com.intranet.beans.panos;
import com.intranet.beans.propuesta;
import com.intranet.beans.proyecto_certificaciones;
import com.intranet.beans.proyecto_certificaciones_galeria;
import com.intranet.beans.puertas;
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
import com.intranet.service.proyecto.ProyectoCertificacionesGaleriaService;
import com.intranet.service.proyecto.ProyectoCertificacionesService;
import java.io.File;
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

@Controller
@RequestMapping("/emp/*")
public class EmpControllerProyectoGaleriaCertificaciones {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ProyectoCertificacionesService proyectoCertificacionesService;
    @Autowired
    private ProyectoCertificacionesGaleriaService proyectoCertificacionesGaleriaService;
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
    int idP=0;
    String nifC="";
    proyecto_certificaciones idPC=new proyecto_certificaciones();
    
    @RequestMapping(value = "ECertificaciones_galeria.htm",method=RequestMethod.GET)
    public String Certificaciones_galeria_get(ModelMap map,@RequestParam(value = "idC") int id) {
        proyecto_certificaciones_galeria proc=new proyecto_certificaciones_galeria();
        List<proyecto_certificaciones_galeria> ltaFotos=new ArrayList<proyecto_certificaciones_galeria>();
        try{
            proyecto_certificaciones p=new proyecto_certificaciones();
            p.setId(id);
            idPC=p;
            proc.setId_proyecto_certificaciones(p);
            ltaFotos=proyectoCertificacionesGaleriaService.lista(id);
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("fotogaleria",proc);
         map.addAttribute("ltaFotos",ltaFotos);
        return "ECertificaciones_galeria";
    }
    
   @RequestMapping(value = "ECertificaciones_galeria.htm",method=RequestMethod.POST)
    public String fotoEmpleado_post(@ModelAttribute("fotogaleria")proyecto_certificaciones_galeria galer,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        //C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosCertificaciones";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    
    try{
        List<FileItem> partes=upload.parseRequest(request);
        for(FileItem item : partes)
        {
            galer.setId_proyecto_certificaciones(idPC);
            if(proyectoCertificacionesGaleriaService.existe(item.getName())==false){
            System.out.println("NOMBRE FOTO: "+item.getName());
            File file=new File(ubicacionArchivo,item.getName());
            item.write(file);
            galer.setNombreimg(item.getName());
                proyectoCertificacionesGaleriaService.insertar(galer);
            }
            
        }
        System.out.println("Archi subido correctamente");
    }
    catch(Exception ex)
    {
        System.out.println("Error al subir archivo"+ex.getMessage());
    }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return "redirect:ECertificaciones_galeria.htm?idC="+idPC.getId();
        
    }
    
    @RequestMapping(value = "EgaleriaDelete.htm",method=RequestMethod.GET)
    public String EjdeleteVentanas(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        proyecto_certificaciones_galeria p=null;
        try{
            
            p=proyectoCertificacionesGaleriaService.porId(id);
            proyectoCertificacionesGaleriaService.eliminar(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:ECertificaciones_galeria.htm?idC="+p.getId_proyecto_certificaciones().getId();
    }
     @RequestMapping(value = "EProyectoGaleria.htm",method=RequestMethod.GET)
    public String ProyectoGaleria_get(ModelMap map,@RequestParam(value = "nifC") String nifC2,@RequestParam(value = "id") int id) {
        List<proyecto_certificaciones_galeria> ltaFotos=new ArrayList<proyecto_certificaciones_galeria>();
        try{
            
            ltaFotos=proyectoCertificacionesGaleriaService.listaProyecto(id);
            idP=id;
            nifC=nifC2;
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("nifC",nifC);        
        map.addAttribute("fotogaleria",new proyecto_certificaciones_galeria());
         map.addAttribute("ltaFotos",ltaFotos);
        return "EProyectoGaleria";
    }
    
    
    
    @RequestMapping(value = "EProyectoGaleriaDelete.htm",method=RequestMethod.GET)
    public String ProyectoGaleriaDelete(@RequestParam(value = "id") int id,ModelMap map) {
        String rpta="";
        proyecto_certificaciones_galeria p=null;
        try{
            
            proyectoCertificacionesGaleriaService.eliminar(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:EProyectoGaleria.htm?nifC="+nifC+"&id="+idP;
    }
    
    
     @RequestMapping(value = "EProyectoGaleria.htm",method=RequestMethod.POST)
    public String ProyectoGaleria_post(@ModelAttribute("fotogaleria")proyecto_certificaciones_galeria galer,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        //C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosCertificaciones";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    String ruta="redirect:EProyectoGaleria.htm?nifC="+nifC+"&id="+idP;
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
            }else ruta="redirect:ELtaClientesProyecto.htm";
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
