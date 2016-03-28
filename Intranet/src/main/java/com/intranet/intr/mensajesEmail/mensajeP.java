/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.mensajesEmail;

import com.intranet.beans.experiencia_laboral;
import com.intranet.beans.postulantes;
import com.intranet.beans.users;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


public class mensajeP {
    private String miCorreo="noreply@decorakia.com";
    private String miContraseña="angel2010";
    
    
    public void mensaje(postulantes p,List<experiencia_laboral> exp) {
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Un nuevo Postulante";
        String cuerpo="";
        String rpta="";  
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
            String oficio="";
	   if(p.getPerfilprof().getId()==2)oficio="<b>Perfil Profesional : </b>"+p.getPerfilprof().getNombre()+"<br/><b>Oficio : </b>"+p.getOficio().getNombre()+"<br/>";
	   else oficio="<b>Perfil Profesional : </b>"+p.getPerfilprof().getNombre()+"<br/>";
	   String experi="";
	   for(experiencia_laboral expl:exp){
		   experi=experi+" "+expl.getPuesto()+" / ";
	   }
	   if(p.getDireccion()==null)p.setDireccion("");
	   if(p.getPais()==null)p.setPais("");
	   if(p.getProvincia()==null)p.setProvincia("");
	   if(p.getPoblacion()==null)p.setPoblacion("");
	   if(p.getNacionalidad()==null)p.setNacionalidad("");
	   if(p.getTelefono()==null)p.setTelefono("");
	   if(p.getEmail()==null)p.setEmail("");
	   
            
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<H4>Una nueva persona ha rellenado el formulario de trabaja con nosotros, aqu&iacute; los detalles:</H4>"
		        + ""+oficio+""
		        + "<b>Nombres y Apellidos : </b>"+p.getNombre()+", "+p.getApellidos()+"<br/>"
		        + "<b>Direccion : </b>"+p.getDireccion()+"<br/>"
		        + "<b>Localidad : </b>"+p.getPais()+"<br/>"
		        + "<b>Provincia/Poblacion/Nacionalidad : </b>"+p.getProvincia()+" / "+p.getPoblacion()+" / "+p.getNacionalidad()+"<br/>"
		        + "<b>Telefono : </b>"+p.getTelefono()+"<br/>"
		        + "<b>Email : </b>"+p.getEmail()+"<br/>"
		        + "<b>Experiencias : </b>"+experi+"<br/>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("seleccion@decorakia.com"));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch        
               */
        
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
	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("seleccion@decorakia.com"));

	   // Asignamos el asunto
	   mensaje.setSubject("Un nuevo Postulante");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://decorakia.ddns.net/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	   String oficio="";
	   if(p.getPerfilprof().getId()==2)oficio="<b>Perfil Profesional : </b>"+p.getPerfilprof().getNombre()+"<br/><b>Oficio : </b>"+p.getOficio().getNombre()+"<br/>";
	   else oficio="<b>Perfil Profesional : </b>"+p.getPerfilprof().getNombre()+"<br/>";
	   String experi="";
	   for(experiencia_laboral expl:exp){
		   experi=experi+" "+expl.getPuesto()+" / ";
	   }
	   if(p.getDireccion()==null)p.setDireccion("");
	   if(p.getPais()==null)p.setPais("");
	   if(p.getProvincia()==null)p.setProvincia("");
	   if(p.getPoblacion()==null)p.setPoblacion("");
	   if(p.getNacionalidad()==null)p.setNacionalidad("");
	   if(p.getTelefono()==null)p.setTelefono("");
	   if(p.getEmail()==null)p.setEmail("");
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<H4>Una nueva persona ha rellenado el formulario de trabaja con nosotros, aqu&iacute; los detalles:</H4>"
		        + ""+oficio+""
		        + "<b>Nombres y Apellidos : </b>"+p.getNombre()+", "+p.getApellidos()+"<br/>"
		        + "<b>Direccion : </b>"+p.getDireccion()+"<br/>"
		        + "<b>Localidad : </b>"+p.getPais()+"<br/>"
		        + "<b>Provincia/Poblacion/Nacionalidad : </b>"+p.getProvincia()+" / "+p.getPoblacion()+" / "+p.getNacionalidad()+"<br/>"
		        + "<b>Telefono : </b>"+p.getTelefono()+"<br/>"
		        + "<b>Email : </b>"+p.getEmail()+"<br/>"
		        + "<b>Experiencias : </b>"+experi+"<br/>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	 
 }
    
    public void mensajePostulanteInformacion(users p) {
	 String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Aviso de Seleccion";
        String cuerpo="";
        String rpta="";  
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
           
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Gracias por actualizar su informacion, ha concluido con el Proceso de Registro. </b>"
		        +"<br/>"
		        + "<b>En cualquier momento podrá modificar sus datos con usuario: "+p.getUsuario()+" y contraseña: "+p.getContrasenna()+" al siguiente enlace (http://decorakia.ddns.net/)</b>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch        
               
        */
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
	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Aviso de Seleccion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://82.223.16.90:8084/Seleccion/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	  
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Gracias por actualizar su informacion, ha concluido con el Proceso de Registro. </b>"
		        +"<br/>"
		        + "<b>En cualquier momento podrá modificar sus datos con usuario: "+p.getUsuario()+" y contraseña: "+p.getContrasenna()+" al siguiente enlace (http://decorakia.ddns.net/)</b>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
                
	 
 }
    
    public void mensajePostulantedescartado(postulantes p) {
	
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Aviso de Seleccion";
        String cuerpo="";
        String rpta="";  
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
           
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Ha sido descartado de la Seleccion, muchas gracias por su tiempo.</b>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch        
             
        
       */
        System.out.println("entro mensaje");
     // La dirección de envío (to)
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
	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Aviso de Seleccion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://82.223.16.90:8084/Seleccion/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	  
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Ha sido descartado de la Seleccion, muchas gracias por su tiempo.</b>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	 
 }
    
    public void mensajePostulanteEnProceso(postulantes p) {
	 
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Aviso de Seleccion";
        String cuerpo="";
        String rpta="";  
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
           
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Ud. ha pasado a la siguiente fase de Seleccion.</b>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch        
             */
        
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
	 
	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Aviso de Seleccion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://82.223.16.90:8084/Seleccion/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	  
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Ud. ha pasado a la siguiente fase de Seleccion.</b>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	
 }
    
    public void mensajePostulanteEmpleado(postulantes p) {
	 
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Aviso de Seleccion";
        String cuerpo="";
        String rpta="";  
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
           
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Felicidades Ud. forma parte de nuestro equipo Decorakia. Gracias.</b>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch 
        
        */
        
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
	  

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Aviso de Seleccion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://82.223.16.90:8084/Seleccion/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	  
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Felicidades Ud. forma parte de nuestro equipo Decorakia. Gracias.</b>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 }
	 
 }
    
    public void mensajePostulanteRestaurar(postulantes p) {
	  String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Aviso de Seleccion";
        String cuerpo="";
        String rpta="";  
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
           
            cuerpo="<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Su información ha sido recuperada de nuestra Base de Datos y pasará al proceso de Selección</b>"
		        + "</body>"
		        + "</html>";
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            msg.setText(cuerpo,"text/html");//seteo el cuertpo del mensaje
            
            
            msg.setSubject(asunto);//setea asusto (opcional)
            msg.setFrom(new InternetAddress(miCorreo));//agrega la la propiedad del correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));//agrega el destinatario
            Transport.send(msg);//envia el mensaje
            JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
        } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
            JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
        }//fin try-catch 
        */
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
	 

	 try{
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Aviso de Seleccion");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   //BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   //String text="Gracias por tu tiempo en breve nos pondremos en contacto contigo. Recuerda que puedes modificar tus datos en tu area privada (http://82.223.16.90:8084/Seleccion/).";
	   // Asignamos el texto del correo
	   //mensaje.setText(text);
	  
	   
	   mensaje.setContent("<!DOCTYPE html>"
		        + "<html>"
		        + "<head> "
		        + "<title></title>"
		        + "</head>"
		        + "<body>"
		        + "<img src='http://decorakia.ddns.net/unnamed.png'>"
		        + "<br/><br/>"		       
		        + "<b>Su información ha sido recuperada de nuestra Base de Datos y pasará al proceso de Selección</b>"
		        + "</body>"
		        + "</html>","text/html" );
	   // Creamos un multipart al correo
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

	   // Enviamos el correo
	   Transport.send(mensaje);
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
}
