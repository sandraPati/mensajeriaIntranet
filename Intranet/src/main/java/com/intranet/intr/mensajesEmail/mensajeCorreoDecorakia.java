/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.mensajesEmail;

import com.intranet.beans.users;
import com.intranet.intr.conexion;
import com.intranet.intr.inbox.correoNoLeidos;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
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


public class mensajeCorreoDecorakia {
    private String miCorreo="";
    private String miContraseña="";
    
    public void mensaje(correoNoLeidos c,users u) {
        miCorreo=u.getCorreoUsuario();
        miContraseña=u.getCorreoContreasenna();
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
       
	  try{
		  
		  Connection con=null;
		  conexion conexion=null;
		  conexion=new conexion();
		  con=conexion.getConnection();
		  
		  
		 System.out.println("ola");
                 
	     //reporte
	
		 //abrir reporte
	     System.out.println("abrir reporte");
	     
	     
      
                           	  
	Properties props = new Properties();//propiedades a agragar
        props.put("mail.smtp.user", u.getCorreoUsuario());//correo origen
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
	 
	 
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(u.getCorreoUsuario()));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDe()));

	   // Asignamos el asunto
	   mensaje.setSubject(c.getAsunto());
	   
           BodyPart cuerpoMensaje = new MimeBodyPart();
	   cuerpoMensaje.setText(c.getContenido());
           Multipart multiparte = new MimeMultipart();
           multiparte.addBodyPart(cuerpoMensaje);
           
           for(String s:c.getImagenes()){
               cuerpoMensaje = new MimeBodyPart();
                String nombreArchivo = "C:\\DecorakiaReportesIntranet\\archivosMail\\"+s;
                System.out.println("MENSAJE ARCHIVO: "+s);
                DataSource fuente = new FileDataSource(nombreArchivo);
                cuerpoMensaje.setDataHandler(new DataHandler(fuente));
                cuerpoMensaje.setFileName(nombreArchivo);
                multiparte.addBodyPart(cuerpoMensaje);
           }
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");
        mensaje.setContent(multiparte);
	   // Enviamos el correo
	   Transport.send(mensaje);
	   System.out.println("Mensaje enviado");
	 } catch (MessagingException e) {
	   e.printStackTrace();
	 
         
         }catch(Exception e){
		 e.getMessage();
	 }
	}
     private class autentificadorSMTP extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContraseña);//autentifica tanto el correo como la contraseña
        }
    }
}
