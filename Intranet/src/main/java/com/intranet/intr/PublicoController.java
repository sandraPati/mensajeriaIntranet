/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.Objetivos;
import com.intranet.beans.clientes;
import com.intranet.beans.empleados;
import com.intranet.beans.metasEmpleado;
import com.intranet.beans.oficios;
import com.intranet.beans.perfil_profesional;
import com.intranet.beans.postulantes;
import com.intranet.beans.proveedores;
import com.intranet.beans.tipo_actividades;
import com.intranet.beans.users;
import com.intranet.service.EmpleadoService;
import com.intranet.service.OficioService;
import com.intranet.service.PerfilProfesionalService;
import com.intranet.service.PostulanteService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.objetivos.MetasEmpleadoService;
import com.intranet.service.objetivos.ObjetivosService;
import com.intranet.service.propuesta.ClientesService;
import com.intranet.service.proveedores.ProveedoresService;
import com.intranet.service.proveedores.TipoActividadService;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/*")
public class PublicoController {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private PostulanteService postulanteService;
    @Autowired
    private PerfilProfesionalService perfilProfesionalService;
    @Autowired
    private OficioService oficioService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ObjetivosService objetivosService;
    @Autowired
    private MetasEmpleadoService metasEmpleadoService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private ProveedoresService proveedoresService;
    @Autowired
    private TipoActividadService tipoActividadService;
    
    private String mensaje="",error="";
    private String miCorreo="noreply@decorakia.com";
    private String miContraseña="angel2010";
        String nifs;
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("index");
        return mav;
    }
    
    
    @RequestMapping(value="login.htm", method = RequestMethod.GET)
    public String login(@RequestParam(value = "state", required = false) String state,ModelMap mav) {

		if(state!=null){
                if (state.equals("failure")) {
                    nifs="";
			mav.addAttribute("error", "Usuario y contraseña INCORRECTOS!");
		}

		if (state.equals("logout")) {
                    if(nifs!=null && nifs!=""){
                    usuarioService.CSEstadoUsu(nifs);
                    }
                    nifs="";
			mav.addAttribute("msg", "Has Cerrado Session Satisfactoriamente!.");
		}
            }

		return ("login");

	}
    @RequestMapping(value="logout.htm", method = RequestMethod.GET)
    public String logout(@RequestParam(value = "state", required = false) String state,ModelMap mav,Principal principal,HttpServletRequest request) {
        String name=principal.getName();
		users u=usuarioService.getByLogin(name);
                    usuarioService.CSEstadoUsu(u.getNif());
                    System.out.println("cerrar sesion:"+u.getNif());
                    HttpSession session = request.getSession();  
     session.invalidate();  
                mav.addAttribute("state", "logout");   
		return ("redirect:login.htm");

	}
    @RequestMapping(value = "/ajaxtestFoto", method = RequestMethod.GET)
    public @ResponseBody
    String getTimeFoto(Principal principal) {
        String name = principal.getName();
        
        String result="";
        try {
            users u=usuarioService.getByLogin(name);
            
           
            if(u.getRol().getId()==4){
                postulantes po=new postulantes();
                po=postulanteService.ByNif(u.getNif());
                result="/Intranet/resources/fotosPerfil/"+po.getNombrefotografia();
            }else if(u.getRol().getId()==5){
                clientes po=new clientes();
                po=clientesService.ByNif(u.getNif());
                result="";
            }else{
                empleados po=new empleados();
                po=empleadoService.ByNif(u.getNif());
                result="/Intranet/resources/fotosPerfil/"+po.getNombrefotografia();
            }
            
        }catch(Exception ex){
        }
     
        
        return result;
    }
    @RequestMapping(value = "error.htm", method = RequestMethod.GET)
    public ModelAndView pageError() {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("error");
        return mav;
    }
    @RequestMapping(value = "Home.htm", method = RequestMethod.GET)
    public String principal(Principal principal,ModelMap mav) {
        String name=principal.getName();
        
        String ruta="";
        try{
            if(name!=null && name!=""){
                users u=usuarioService.getByLogin(name);
                nifs=u.getNif();
                usuarioService.ISEstadoUsu(u.getNif());
                if(u.getRol().getId()==5){
                    
                    ruta="redirect:cli/CfichaCliente.htm";
                }else  if(u.getRol().getId()==3 || u.getRol().getId()==2 || u.getRol().getId()==1){
                
                empleados emp=empleadoService.ByNif(u.getNif());
                if(emp.getPerfilprof().getId()==1){
                    mav.addAttribute("activo",1);
                    Calendar fecha2 = Calendar.getInstance();
                    int anio = fecha2.get(Calendar.YEAR);
                    int mes = fecha2.get(Calendar.MONTH) + 1;
                    mav.addAttribute("fecha",""+mes+"/"+anio);
                    if(objetivosService.existe(u.getNif())==true){
                    Objetivos obj=objetivosService.ByNif(u.getNif());
                    mav.addAttribute("obj",obj);
                    
                    System.out.println("mestas");
                    
                    metasEmpleado meta=metasEmpleadoService.ByNifHome(u.getNif(), mes, anio);
                    System.out.println("mestas");
                    System.out.println("mestas"+meta.getNumvisitas()+"-"+meta.getNum_presupuesto()+"."+meta.getNum_contratos()+"."+meta.getImporte());
                    float porc=(meta.getNumvisitas()*100)/obj.getNum_visitas();
                    meta.setPorcentaje1(porc);
                    float porc2=(meta.getNum_presupuesto()*100)/obj.getNum_presupuesto();
                    meta.setPorcentaje2(porc2);
                    float porc3=(meta.getNum_contratos()*100)/obj.getNum_contratos();
                    meta.setPorcentaje3(porc3);
                    double porc4=(meta.getImporte()*100)/obj.getImporte();
                    meta.setPorcentaje4(porc4);
                    mav.addAttribute("meta",meta);
                    }
                }else{
                    mav.addAttribute("activo",0);                
                }
                    
                    ruta="Home";
                    
                    
                    
                }else{
                    mav.addAttribute("activo",0);
                    ruta="Home";
                }
            }
        }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
                mav.addAttribute("menu",r);
        return ruta;
    }
    
     
    
    @RequestMapping(value = "Postular.htm",method=RequestMethod.GET)
    public String PostulanteR_get(ModelMap map,@RequestParam(value = "msg", required = false) String state) {
        ModelAndView mav=new ModelAndView();
        List<perfil_profesional> listaPerfilProfesional=null;
        List<oficios> listaOficios=null;
        try{
        listaPerfilProfesional=perfilProfesionalService.findAll();
        listaOficios=oficioService.findAll();
        
            switch (state) {
                case "success":
                    map.addAttribute("mensaje", "Su Registro ha sido Satisfactorio, en breve recibira un mail");
                    break;
                case "error":
                    map.addAttribute("error", "Error Inesperado del sistema!.");
                    break;
                case "errorT":
                    map.addAttribute("error", "NO has aceptado los terminos!.");
                    break;
                case "errorCv":
                    map.addAttribute("error", "Contraseñas vacias.");
                    break;
                case "errorCc":
                    map.addAttribute("error", "Las contraseñas no Coinciden.");
                    break;
                case "errorN":
                    map.addAttribute("error", "Ya existe un Usuario con el nismo Docuemento NIF");
                    break;
                case "errorU":
                    map.addAttribute("error", "Ya existe un Usuario con la misma descripcion");
                    break;
                case "errorCorreo":
                    map.addAttribute("error", "El correo ingresado ya fue registrado,No se realizo la postulacion");
                    break;
            }
        }catch(Exception ex){
            ex.printStackTrace();        
        }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("listaPerfilProfesional",listaPerfilProfesional);
        map.addAttribute("listaOficios",listaOficios);
        map.addAttribute("postulante",new postulantes());
        
        return "Postular";
    }
    
    @RequestMapping(value = "Postular.htm",method=RequestMethod.POST)
    public String PostulanteR_post(@ModelAttribute("postulante")postulantes tra,BindingResult result,ModelMap map) {
        String mensaje2="";
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="LLena tu informacion";
        String cuerpo="";
        String rpta="";
        ModelAndView model = new ModelAndView();
        if(!result.hasErrors()){
            try {
                if(tra.getCondiciones()==true){
                    if( tra.getContrasenna()!="" && tra.getContrasenna2()!=""){
                        if(tra.getContrasenna().equals(tra.getContrasenna2())){
                            users u =new users();
                            u.setUsuario(tra.getUsuario());
                            u.setContrasenna(tra.getContrasenna());
                            u.setNif(tra.getDocuemnto_identidad());
                            if(postulanteService.validaNIf(u.getNif())==false){
                            if(usuarioService.validaExisteUC(u)==0){
                                //tra.setContrasenna(tra.getContrasenna());
                                //if(postulanteService.validaEmail(tra.getEmail())==0){
                                    if(this.postulanteService.Insert(tra)==true){
                                        mensaje2="success";
                                            // La dirección de envío (to)
                                        
          // La dirección de la cuenta de envío (from)
	
	 // Obtenemos las propiedades del sistema
	 
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
	   mensajeE.addRecipient(Message.RecipientType.TO, new InternetAddress(tra.getEmail()));

	   // Asignamos el asunto
	   mensajeE.setSubject("LLena tu informacion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   String text="Accede con usuario: "+tra.getUsuario()+" - contraseña: "+tra.getContrasenna()+", al siguiente link http://decorakia.ddns.net/Intranet/pos/Informacion.htm";
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
            mensaje="Su Registro ha sido Satisfactorio, en breve recibira un mail";
         error=""; 
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	 
	
         
         
         /*
         String text="Accede con usuario: "+tra.getUsuario()+" - contraseña: "+tra.getContrasenna()+", al siguiente link http://decorakia.ddns.net/Intranet/pos/Informacion.htm";
	 cuerpo="<!DOCTYPE html><html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<p>"+text+"</p>"
		        + "</body>"
		        + "</html>";  
          Properties props = new Properties();//propiedades a agragar
        props.put("mail.smtp.user", miCorreo);//correo origen
        props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
        props.put("mail.smtp.port", puertoEnvio);//puesto de salida
        props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
        props.put("mail.smtp.auth", "true");//autentificacion
        props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar el puerto
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");                            
                                        
        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new autentificadorSMTP();//autentificar el correo
            Session session = Session.getInstance(props, auth);//se inica una session
            // session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tra.getEmail()));//agrega el destinatario
            System.out.println("HOLA TRANSPORT");
            Transport.send(msg);//envia el mensaje
            System.out.println("DESPUES TRANSPORT");
            System.out.println("Se Inserto Satisfactoriamente en breve recibira un mail");
		//Executions.sendRedirect("../");
	 mensaje="Su Registro ha sido Satisfactorio, en breve recibira un mail";
         error="";            
//JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (MessagingException mex) {//en caso de que ocurra un error se crea una excepcion
            //JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
            System.out.println("Error de registro");
		//Executions.sendRedirect("../");
            error="Error Inesperado del sistema";
            mensaje="";
        }//fin try-catch
        */
        
          //limpiaPostulante();
	
         
                                    }else{
                                        mensaje2="error";
                                        error="Error Inesperado del sistema";
                                        mensaje="";
                                    }
                                /*}else{
                                    mensaje2="errorCorreo";
                                        error="El correo ingresado ya fue registrado,No se realizo la postulacion";
                                        mensaje="";
                                    }*/
                            }else  {mensaje2="errorU";error="Ya existe un Usuario con la misma descripcion";mensaje="";}
                            }else  {mensaje2="errorN";error="Ya existe un Usuario con el nismo Docuemento NIF";mensaje="";}
                        }else {mensaje2="errorCc";error="Las contraseñas no Coinciden.";mensaje="";}
                    }else  {mensaje2="errorCv";error="Contraseñas vacias.";mensaje="";}
                }else{
                    System.out.println("no ha aceptado los terminos");
                    mensaje2="errorT";error="NO has aceptado los terminos!.";mensaje="";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
        map.addAttribute("msg",mensaje2);
        //map.addAttribute("mensaje",messages.getMessage("status.ok", null, LocaleContextHolder.getLocale()));
        //mensaje="Su Registro ha sido Satisfactorio, en breve recibira un mail";
        //map.addAttribute("mensaje","Su Registro ha sido Satisfactorio, en breve recibira un mail");
        return "redirect:Postular.htm";
        
        
    }
    @RequestMapping(value = "/jsonPostular", method = RequestMethod.POST)
    public @ResponseBody String jsonPostular(@ModelAttribute(value="postulante") postulantes tra) {
       
        String res="";
        try{
                if(tra.getCondiciones()==true){
                    if( tra.getContrasenna()!="" && tra.getContrasenna2()!=""){
                        if(tra.getContrasenna().equals(tra.getContrasenna2())){
                            users u =new users();
                            u.setUsuario(tra.getUsuario());
                            u.setContrasenna(tra.getContrasenna());
                            u.setNif(tra.getDocuemnto_identidad());
                            if(postulanteService.validaNIf(u.getNif())==false){
                            if(usuarioService.validaExisteUC(u)==0){
                                //tra.setContrasenna(tra.getContrasenna());
                                //if(postulanteService.validaEmail(tra.getEmail())==0){
                                    if(this.postulanteService.Insert(tra)==true){
                                    envioMensaje(tra);
                                    res="6";
                                    }else res="5";
                            }else res="4";
                            }else res="3";
                        }else res="2";
                    }else res="21";
                }else res="6";
        }catch ( Exception ex ){
            System.out.println(ex);
        }
            return res;
    }
    
    public void envioMensaje(postulantes tra){
        String mensaje2="";
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="LLena tu informacion";
        String cuerpo="";
        String rpta="";
	 // Obtenemos las propiedades del sistema
	 
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
	   mensajeE.addRecipient(Message.RecipientType.TO, new InternetAddress(tra.getEmail()));

	   // Asignamos el asunto
	   mensajeE.setSubject("LLena tu informacion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   String text="Accede con usuario: "+tra.getUsuario()+" - contraseña: "+tra.getContrasenna()+", al siguiente link http://decorakia.ddns.net/Intranet/pos/Informacion.htm";
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
           System.out.println("transport");
	   Transport.send(mensajeE);
	   System.out.println("Mensaje enviado");
            mensaje="Su Registro ha sido Satisfactorio, en breve recibira un mail";
         error=""; 
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
    }
    
    @RequestMapping(value = "security.htm",method=RequestMethod.GET)
    public String security_get(ModelMap map) {
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("user",new users());
        map.addAttribute("mensaje",mensaje);
        map.addAttribute("error",error);
        return "security";
    }
    
    @RequestMapping(value = "security.htm",method=RequestMethod.POST)
    public String security_post(@ModelAttribute("user")users u,BindingResult result) {
        
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Recuperar contraseña";
        String cuerpo="";
        String rpta="";
        if(!result.hasErrors()){
            try {
                if(u.getEmail()!=null && u.getEmail()!=""){
                    users newuser=usuarioService.ResuperarUC(u.getEmail());
                    if(newuser!=null){
           /* String text="Accede con usuario: "+newuser.getUsuario()+" - contraseña: "+newuser.getContrasenna()+", al siguiente link http://decorakia.ddns.net/";
                        cuerpo="<!DOCTYPE html><html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<p>"+text+"</p>"
		        + "</body>"
		        + "</html>";              
                 */       
         
	 // Obtenemos las propiedades del sistema
	 Properties props = new Properties();//propiedades a agragar
        props.put("mail.smtp.user", miCorreo);//correo origen
        props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
        props.put("mail.smtp.port", puertoEnvio);//puesto de salida
        props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
        props.put("mail.smtp.auth", "true");//autentificacion
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
	   mensajeE.addRecipient(Message.RecipientType.TO, new InternetAddress(newuser.getEmail()));

	   // Asignamos el asunto
	   mensajeE.setSubject("Recuperar contraseña");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   String text="Accede con usuario: "+newuser.getUsuario()+" - contraseña: "+newuser.getContrasenna()+", al siguiente link http://decorakia.ddns.net/";
	   // Asignamos el texto del correo
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
            mensaje="Su solicitud ha sido procesada, en breve recibira un mail";
         error="";
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	 /*
                        Properties props = new Properties();//propiedades a agragar
        props.put("mail.smtp.user", miCorreo);//correo origen
        props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
        props.put("mail.smtp.port", puertoEnvio);//puesto de salida
        props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
        props.put("mail.smtp.auth", "true");//autentificacion
        props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar el puerto
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");                            
                                        
        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new autentificadorSMTP();//autentificar el correo
            Session session = Session.getInstance(props, auth);//se inica una session
            // session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(newuser.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            System.out.println("Se Inserto Satisfactoriamente en breve recibira un mail");
            //JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            //JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
            System.out.println("Error");
        }//fin try-catch
	 //limpiaPostulante();
	 
		//Executions.sendRedirect("../");
	 */
                                    }else System.out.println("no existe registro con con el email: "+u.getEmail());
                                
                            }else System.out.println("correo vacio");
        
            } catch (Exception ex) {
                ex.printStackTrace();
                rpta="";
            }
            
        }else{return "error";}
        return "redirect:security.htm";
        
        
    }

   
    private class autentificadorSMTP extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContraseña);//autentifica tanto el correo como la contraseña
        }
    }
    
    @RequestMapping(value = "Proveedor.htm",method=RequestMethod.GET)
    public String Proveedor_get(ModelMap map,@RequestParam(value = "msg", required = false) String state) {
        
        List<tipo_actividades> allTipoActividad=null;
        proveedores proveedor=new proveedores();
        try{
            if(state!=null && state!=""){
            switch (state) {
                case "success":
                    map.addAttribute("mensaje", "Su Registro ha sido Satisfactorio,en breve nos pondremos en contacto con Usted.");
                    break;
                case "error":
                    map.addAttribute("error", "Error Inesperado del sistema!.");
                    break;
               
            }
            }
            allTipoActividad=tipoActividadService.all();
        }catch(Exception e){}
       
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("proveedor",proveedor);
        map.addAttribute("allTipoActividad",allTipoActividad);
        
        return "Proveedor";
    }
    
    @RequestMapping(value = "Proveedor.htm",method=RequestMethod.POST)
    public String Proveedor_post(@ModelAttribute("proveedor")proveedores proveedor,BindingResult result,ModelMap map) {
        String mensaje="";
        try{
            System.out.println("PROVEEDOR REGISTRO.......................................................");
            proveedor.setAprobado(false);
            
            boolean r=proveedoresService.insertarSinImagen(proveedor);
            if(r==true){
                map.addAttribute("msg","success");
            }else{
                map.addAttribute("msg","error");
            }
            
        }catch(Exception e){
        }
	 
       
       
         return "redirect:Proveedor.htm";
        
        
        
    }
    
}
