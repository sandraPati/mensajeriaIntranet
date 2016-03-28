/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.proveedores;

import com.intranet.beans.Roles;
import com.intranet.beans.capitulos;
import com.intranet.beans.clasificaciones;
import com.intranet.beans.clientes;
import com.intranet.beans.presupuesto;
import com.intranet.beans.propuesta;
import com.intranet.beans.prov_presup_adj;
import com.intranet.beans.proveedor_presupuesto;
import com.intranet.beans.proveedor_presupuesto_asignar;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipo_actividades;
import com.intranet.beans.users;
import com.intranet.intr.PublicoController;
import com.intranet.intr.conexion;
import com.intranet.service.RolesService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.propuesta.PresupuestosService;
import com.intranet.service.propuesta.PropuestasService;
import com.intranet.service.proveedores.ClasificacionService;
import com.intranet.service.proveedores.ProvPresupAdjService;
import com.intranet.service.proveedores.ProveedorPresupuestoAsignarService;
import com.intranet.service.proveedores.ProveedorPresupuestoService;
import com.intranet.service.proveedores.ProveedoresService;
import com.intranet.service.proveedores.TipoActividadService;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
public class SupControllerGestion {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
     @Autowired
    private ProveedoresService proveedoresService;
     @Autowired
    private ClasificacionService clasificacionService;
    @Autowired
    private TipoActividadService tipoActividadService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProveedorPresupuestoService proveedorPresupuestoService;
    @Autowired
    private ProvPresupAdjService provPresupAdjService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private PropuestasService propuestasService;
    @Autowired
    private PresupuestosService presupuestosService;
    @Autowired
    private ProveedorPresupuestoAsignarService proveedorPresupuestoAsignarService;
    
      proveedores proveedor=new proveedores();
      
      @RequestMapping("Gestion.htm")
    public ModelAndView Gestion(ModelAndView mav){
        List<proveedores> listaProveedores=null;
        
        try{
            listaProveedores=clasificacionService.lista(""); 
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("listaProveedores", listaProveedores);
        mav.setViewName("Gestion");        
        return mav;
    }
    
    @RequestMapping("verProveedor.htm")
    public ModelAndView Gestion(@RequestParam(value = "id") int id,ModelAndView mav){
        List<clasificaciones> listaCalificaciones=null;
        proveedores p=new proveedores();
        try{
            listaCalificaciones=clasificacionService.AllcalificacionProveedor(id);
             p=proveedoresService.porId(id);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("proveedor",p);
        mav.addObject("listaCalificaciones",listaCalificaciones);
        mav.setViewName("verProveedor");        
        return mav;
    }
    
   
    @RequestMapping(value = "addProveedor.htm",method=RequestMethod.GET)
    public String addProveedor_get(ModelMap map) {
        
        List<tipo_actividades> allTipoActividad=null;
        proveedores proveedor=new proveedores();
        try{
            allTipoActividad=tipoActividadService.all();
        }catch(Exception e){}
       
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proveedor",proveedor);
        map.addAttribute("allTipoActividad",allTipoActividad);
        map.addAttribute("mensaje","mensaje");
        
        return "addProveedor";
    }
    
    @RequestMapping(value = "addProveedor.htm",method=RequestMethod.POST)
    public String addProveedor_post(@ModelAttribute("proveedor")proveedores proveedor,BindingResult result) {
        String mensaje="";
        try{
            //proveedoresService.insertarSinImagen(proveedor);
            boolean r=proveedoresService.insertarSinImagen(proveedor);
            
            
        }catch(Exception e){
        }
	 
       
       
         return "redirect:Gestion.htm";
        
        
        
    }
    @RequestMapping(value = "updateProveedor.htm",method=RequestMethod.GET)
    public String updateProveedor_get(ModelMap map,@RequestParam(value = "id") int id) {
        
        List<tipo_actividades> allTipoActividad=null;
        try{
            allTipoActividad=tipoActividadService.all();
            proveedor=proveedoresService.porId(id);
           
        }catch(Exception e){
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proveedor",proveedor);
        map.addAttribute("allTipoActividad",allTipoActividad);
        map.addAttribute("mensaje","mensaje");
        
        return "updateProveedor";
    }
    
    @RequestMapping(value = "updateProveedor.htm",method=RequestMethod.POST)
    public String updateProveedor_post(@ModelAttribute("proveedor")proveedores prov,BindingResult result) {
        String mensaje="";
        try{
            System.out.println("actiTUALIZAR: "+prov.getNum_cuenta());
            proveedoresService.updateSinImagen(prov);
            
        }catch(Exception e){
        }
         return "redirect:Gestion.htm";
        
    }
    
   
    
     @RequestMapping(value = "deleteProveedor.htm",method=RequestMethod.GET)
    public String eliminarEstudio(@RequestParam(value = "id") int id) {
        String rpta="";
        try{
            proveedoresService.delete(id);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:Gestion.htm";  
    }
    private int idProv=0;
     @RequestMapping(value = "fotoProveedor.htm",method=RequestMethod.GET)
    public String fotoProveedor_get(ModelMap map,@RequestParam(value = "id") int id) {
        
        try{
            idProv=id;
             proveedor=proveedoresService.porId(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
                
        map.addAttribute("menu",r);
        map.addAttribute("proveedor",proveedor);
        map.addAttribute("mensaje","mensaje");
        
        return "fotoProveedor";
    }
    @RequestMapping(value = "fotoProveedor.htm",method=RequestMethod.POST)
    public String fotoProveedor_post(@ModelAttribute("proveedor")proveedores prov,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        //C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosPerfil\\proveedores
        String ubicacionArchivo="C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\fotosPerfil\\proveedores";
    DiskFileItemFactory factory=new DiskFileItemFactory();
    factory.setSizeThreshold(1024);
    
    ServletFileUpload upload=new ServletFileUpload(factory);
    
    System.out.println("uPDAT FOTO ID proveedor: "+prov.getId());
    try{
        System.out.println("1: "+prov.getId());
        List<FileItem> partes=upload.parseRequest(request);
        for(FileItem item : partes)
        {
            System.out.println("2"+item.getName());
            File file=new File(ubicacionArchivo,item.getName());
            System.out.println("3"+prov.getId());
            item.write(file);
            System.out.println("4"+idProv);
            prov.setNombreFoto(item.getName());
            proveedoresService.UpdateImagen(prov);
            System.out.println("5: "+prov.getId());
        }
        System.out.println("Archi subido correctamente");
    }
    catch(Exception ex)
    {
        System.out.println("Error al subir archivo"+ex.getMessage());
    }
	
            //return "redirect:uploadFile.htm";
        
    
	
            return "redirect:Gestion.htm";
        
    }
   
    
    
    
    
     @RequestMapping(value = "/ajaxProvDesaprobado", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxProvDesaprobado(@ModelAttribute(value="proveedor") proveedores proveedor) {
        try{
        //System.out.println("ajaxtext");
            proveedoresService.UpdateDesaprobado(proveedor.getId());
            users u=new users();
            u.setNif(""+proveedor.getId());
            if(usuarioService.validaExiste(u)==true){
                users usu=new users();
                usu.setNif(""+proveedor.getId());
                usu.setEstado(2);
                usuarioService.updateEstado(usu);
            }
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return "/Intranet/sup/verProveedor.htm";
    }
    @RequestMapping(value = "/ajaxProvPresupRechazar", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxProvPresupRechazar(@ModelAttribute(value="presup") proveedor_presupuesto presup) {
        try{
        System.out.println("ajaxtext22222");
        proveedorPresupuestoAsignarService.Delete(presup.getId());
            proveedorPresupuestoService.UpdateRechazado(presup.getId());
            
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return "/Intranet/sup/verProveedor.htm";
    }
    @RequestMapping(value = "/ajaxProvAprobado", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxProvAprobado(@ModelAttribute(value="proveedor") proveedores proveedor) {
        String r="0";
        try{
        //System.out.println("ajaxtext");
            users u=new users();
            u.setNif(""+proveedor.getId());
            
            if(usuarioService.validaExiste(u)==true){
                r="1";
            }
            
            
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return r;
    }
    @RequestMapping(value = "/ajaxLogeoProveedor", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxLogeoProveedor(@ModelAttribute(value="proveedor") proveedores proveedor) {
        String r="0";
        try{
        System.out.println("proveedor: -....."+proveedor.getUsuario()+"id..co"+proveedor.getContrasenna()+"-"+proveedor.getContrasenna2());
            
            if(usuarioService.validaNIF(""+proveedor.getId())==0){
                if( proveedor.getContrasenna()!="" && proveedor.getContrasenna2()!=""){
                    if(proveedor.getContrasenna().equals(proveedor.getContrasenna2())){
                        proveedoresService.UpdateAprobado(proveedor.getId());                                 
                        users u=new users();
                        u.setNif(""+proveedor.getId());
                        u.setUsuario(proveedor.getUsuario());
                        u.setContrasenna(proveedor.getContrasenna());
                        u.setEmail(proveedor.getEmail());
                        u.setRol(rolesService.getRolesporId(6));
                        usuarioService.insertar(u);
                        enviarProvUC(proveedor);
                        usuarioService.anadirRolaUser(""+proveedor.getId(), 6);
                        proveedoresService.UpdateContrato(proveedor.getFechaContrato(),proveedor.getId());
                        r="/Intranet/sup/verProveedor.htm?id="+proveedor.getId();
                    }
                }
            }
            
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return r;
    }
    @RequestMapping(value = "/ajaxProvAprobadoMUsu", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxProvAprobadoMUsu(@ModelAttribute(value="proveedor") proveedores proveedor) {
        String r="0";
        try{
        //System.out.println("ajaxtext");
            proveedoresService.UpdateAprobado(proveedor.getId());
            users u=new users();
            u.setNif(""+proveedor.getId());
            if(usuarioService.validaExiste(u)==true){
                users usu=new users();
                usu.setNif(""+proveedor.getId());
                usu.setEstado(1);
                usuarioService.updateEstado(usu);
                proveedoresService.UpdateContrato(proveedor.getFechaContrato(),proveedor.getId());
                r="/Intranet/sup/verProveedor.htm?id="+proveedor.getId();
            }
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return r;
    }
    private String miCorreo="noreply@decorakia.com";
    
    private String miContraseña="angel2010";
    @RequestMapping(value = "/ajaxProvAprobadoUpdUsu", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxProvAprobadoUpdUsu(@ModelAttribute(value="proveedor") proveedores proveedor) {
        
        String r="0";
        try{
        //System.out.println("ajaxtext");
            proveedoresService.UpdateAprobado(proveedor.getId());
            users u=new users();
            u.setNif(""+proveedor.getId());
            if(usuarioService.validaExiste(u)==true){
                if( proveedor.getContrasenna()!="" && proveedor.getContrasenna2()!=""){
                    if(proveedor.getContrasenna().equals(proveedor.getContrasenna2())){
                        users usu=new users();
                        usu.setNif(""+proveedor.getId());
                        usu.setEstado(1);
                        usu.setUsuario(proveedor.getUsuario());
                        usu.setContrasenna(proveedor.getContrasenna());
                        usuarioService.updateEstado(usu);
                        usuarioService.update(usu);
                        enviarProvUC(proveedor);
                        proveedoresService.UpdateContrato(proveedor.getFechaContrato(),proveedor.getId());
                        r="/Intranet/sup/verProveedor.htm?id="+proveedor.getId();
                    }
                }
            }
        }catch ( Exception ex ){
            System.out.println(ex);
        }
        return r;
    }
    
    @RequestMapping("verLtaPresupuestos.htm")
    public ModelAndView verLtaPresupuestos(ModelAndView mav,@RequestParam(value = "id") int id){
       
        List<proveedor_presupuesto> lta=null;
        try{
            
            lta=proveedorPresupuestoService.findAll(id);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.setViewName("verLtaPresupuestos");        
        return mav;
    }
    
    @RequestMapping("verPPresupuesto.htm")
    public String verPPresupuestos(ModelMap mav,@RequestParam(value = "idP") int id,@RequestParam(value = "msg",required=false) String msg){
        proveedor_presupuesto lta=null;
        List<prov_presup_adj> ltaArc=null;
        List<String> archivos=null;
        List<String> imagenes=null;
        try{
           if(msg!=null &&msg!=""){
              if(msg.equals("success")) {
               mav.addAttribute("msg", "Presupuesto Aceptado y Asignado Correctamente");
              }else{
                  mav.addAttribute("error", "Operacion Rechazada, Intente Nuevamente");
              }
           }
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
        mav.addAttribute("menu",r);
        mav.addAttribute("presup", lta);
        mav.addAttribute("idP", id);
        
        mav.addAttribute("ltaArc", ltaArc);
               
        return "verPPresupuesto";
    }
    
    @RequestMapping(value = "verContratoProveedorPdf.htm",method=RequestMethod.GET)
    public String verContratoProveedorPdf(@RequestParam(value = "id") int idP,ModelMap map) throws SQLException {
       
       String ruta="";
        try{
                Connection con=null;
                conexion conexion=null;
                conexion=new conexion();
                con=conexion.getConnection();
               
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idP", idP);
                    
                   //C:\reportesIntranetDecorakia\presupuesto
                   JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\proveedores\\contratoProveedor.jasper", params, con);
                   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\proveedores\\Contrato"+idP+".pdf");
                   String r=validaInterfacesRoles.valida();
                    map.addAttribute("menu",r);
                    map.addAttribute("idP",idP);
                    ruta="verContratoProveedorPdf";
                  
        
        }catch(Exception e){

        }
        return(ruta);
    }
    
    @RequestMapping("pdfContratoProveedor.htm")
    public ModelAndView pdf(ModelAndView mav,@RequestParam(value = "idP") int id){
       
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
         mav.addObject("id",id);
        mav.setViewName("pdfContratoProveedor");        
        return mav;
    }
    
    
    
    public void enviarProvUC(proveedores proveedor){
        String cuerpo="";
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        Properties props = new Properties();//propiedades a agragar
        props.put("mail.smtp.user", miCorreo);//correo origen
        props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
        props.put("mail.smtp.port", puertoEnvio);//puesto de salida
        props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
        props.put("mail.smtp.auth", "true");//autentificacion
        props.put("mail.smtp.password", "angel2010");//autentificacion
        props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar el puerto
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");                            
                                        
        SecurityManager security = System.getSecurityManager();
         
	 Authenticator auth = new autentificadorSMTP();//autentificar el correo
            Session session = Session.getInstance(props, auth);//se inica una session
            // session.setDebug(true);

	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensajeE = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensajeE.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensajeE.addRecipient(Message.RecipientType.TO, new InternetAddress(proveedor.getEmail()));

	   // Asignamos el asunto
	   mensajeE.setSubject("Su Perfil Personal");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   String text="Acceda con usuario: "+proveedor.getUsuario()+" y contraseña: "+proveedor.getContrasenna()+", al siguiente link http://decorakia.ddns.net/Intranet/login.htm";
	   // Asignamos el texto del correo
	   cuerpo="<!DOCTYPE html><html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<p>"+text+"</p>"
		        + "</body>"
		        + "</html>";
           mensajeE.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<p>"+text+"</p>"
		        + "</body>"
		        + "</html>","text/html" );
	   //mensaje.setText(text);


	   // Creamos un multipart al correo
	   
	   // Enviamos el correo
	   Transport.send(mensajeE);
	   System.out.println("Mensaje enviado");
           
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
    }
    private class autentificadorSMTP extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContraseña);//autentifica tanto el correo como la contraseña
        }
    }
    
    
    @RequestMapping(value = "/ajaxBuscarCliente.json", method = RequestMethod.GET)
    public @ResponseBody
    List<clientes> ajaxBuscarCliente() {
        System.out.println("ola");
        List<clientes> data=simulateSearchCliente();
        return data;

    }

    private List<clientes> simulateSearchCliente() {

            List<clientes> result = new ArrayList<clientes>();
            List<clientes> lta=clientesService.findAll("");
            // iterate a list and filter by tagName
            
            
            return lta;
    }
    @RequestMapping("BuscarCliente.htm")
    public ModelAndView BuscarCliente(ModelAndView mav,@RequestParam(value = "idP") int id){
       
        List<clientes> lta=null;
        try{
            
            lta=clientesService.findAll("");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("idPresup", id);
        mav.setViewName("BuscarCliente");        
        return mav;
    }
    @RequestMapping(value = "/ajaxBuscarProyecto.json", method = RequestMethod.GET)
    public @ResponseBody
    List<propuesta> getTags(@RequestParam(value = "nif") String nif) {
        System.out.println("olapROY");
        List<propuesta> data=simulateSearchResult(nif);
        return data;

    }

    private List<propuesta> simulateSearchResult(String id) {

            List<propuesta> result = new ArrayList<propuesta>();
            List<propuesta> lta=propuestasService.filtroCProy(id);
            // iterate a list and filter by tagName
            
            return lta;
    }
    @RequestMapping("Proyectos.htm")
    public ModelAndView Proyectos(ModelAndView mav,@RequestParam(value = "idPresup") int id,@RequestParam(value = "nifC") String nifC){
       
        List<propuesta> lta=null;
        try{
            
            lta=propuestasService.filtroCProy(nifC);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("idPresup", id);
        mav.addObject("nifC", nifC);
        mav.setViewName("Proyectos");        
        return mav;
    }
    @RequestMapping("PPCapitulos.htm")
    public ModelAndView PPCapitulos(ModelAndView mav,@RequestParam(value = "idPresup") int idPresup,@RequestParam(value = "idP") int id){
       
        List<capitulos> lta=null;
        try{
            
            lta=presupuestosService.capitulosEnPresupuestosdePropuesta(id);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("idProp", id);
        mav.addObject("idPresup", idPresup);
        mav.setViewName("PPCapitulos");        
        return mav;
    }
    @RequestMapping("PPSupCapitulos.htm")
    public ModelAndView PPSupCapitulos(ModelAndView mav,@RequestParam(value = "idPresup") int idPresup,@RequestParam(value = "idProp") int idProp,@RequestParam(value = "idC") int id){
       
        List<presupuesto> lta=null;
        try{
            
            lta=presupuestosService.subcapPresupuesto(idProp,id);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("entra a funcion documento");
        }
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("lta", lta);
        mav.addObject("idPresup", idPresup);
        mav.setViewName("PPSupCapitulos");        
        return mav;
    }
      @RequestMapping(value = "AsignarPresupuesto.htm",method=RequestMethod.GET)
    public String AsiganrPresupuesto(@RequestParam(value = "idPresup") int idPresup,@RequestParam(value = "idSC") int id,ModelMap map) {
        String rpta="";
        try{
            proveedorPresupuestoService.UpdateAprobado(idPresup);
            proveedor_presupuesto_asignar c=new proveedor_presupuesto_asignar();
            c.setPresupuesto(id);
            c.setProv_presu(idPresup);
            boolean r=proveedorPresupuestoAsignarService.Insert(c);
            if(r==true){
                map.addAttribute("msg","success");
            }else map.addAttribute("msg","error");
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        return "redirect:verPPresupuesto.htm?idP="+idPresup;  
    }
}
