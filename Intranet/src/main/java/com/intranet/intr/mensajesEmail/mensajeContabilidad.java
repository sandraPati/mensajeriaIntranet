/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.mensajesEmail;

import com.intranet.beans.compra;
import com.intranet.beans.venta;
import com.intranet.intr.conexion;
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
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class mensajeContabilidad {
    private String miCorreo="noreply@decorakia.com";
    private String miContraseña="angel2010";
    
    public void mensaje(venta p) {
        String servidorSMTP = "smtp.1and1.es";
        String puertoEnvio = "465";
        //String mailReceptor="";
        String asunto="Factura de Venta";
        String cuerpo="Se le ha enviado La Factura de Venta";
        String rpta=""; 
	  try{
		  
		  Connection con=null;
		  conexion conexion=null;
		  conexion=new conexion();
		  con=conexion.getConnection();
		  
		  
		 System.out.println("ola");
                 
	  
		 //abrir reporte
	     System.out.println("abrir reporte");
	     
	     Map<String, Object> params = new HashMap<String, Object>();
	     params.put("numC", p.getNum());
             String rect="NO";
             String causarect="";
             if(p.getRectificactiva()==true){
                 rect="Si";
                 causarect="Causa: "+p.getCausa();
             }
             params.put("rectificativo", rect);
             
             params.put("causaRec", causarect);
		      //C:\reportesIntranetDecorakia\presupuesto
		        JasperPrint jasperPrinteee = JasperFillManager.fillReport("C:\\DecorakiaReportesIntranet\\contabilidad\\compra\\venta.jasper", params, con);
		 	   JasperExportManager.exportReportToPdfFile(jasperPrinteee, "C:\\DecorakiaReportesIntranet\\pdfs\\contabilidad\\venta\\Venta"+p.getCliente_nif().getNif()+".pdf");
	
      
                           	  
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
	 
	 
	   // Creamos un objeto mensaje tipo MimeMessage por defecto.
	   MimeMessage mensaje = new MimeMessage(session);

	   // Asignamos el “de o from” al header del correo.
	   mensaje.setFrom(new InternetAddress(miCorreo));

	   // Asignamos el “para o to” al header del correo.
	   mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getCliente_nif().getEmail()));

	   // Asignamos el asunto
	   mensaje.setSubject("Emision de Factura de Venta");
	   
	   // Creamos un cuerpo del correo con ayuda de la clase BodyPart
	   BodyPart cuerpoMensaje = new MimeBodyPart();
	   
	   // Asignamos el texto del correo
	   cuerpoMensaje.setText("Se le ha enviado La Factura de Venta");
	   
	   // Creamos un multipart al correo
	   Multipart multiparte = new MimeMultipart();
	   
	   // Agregamos el texto al cuerpo del correo multiparte
	   multiparte.addBodyPart(cuerpoMensaje);
	   
	   // Ahora el proceso para adjuntar el archivo
	   cuerpoMensaje = new MimeBodyPart();
	   //String nombreArchivo = "C:\\Users\\MoisesJacob\\Desktop\\ojos.jpg";
	   String nombreArchivo = "C:\\DecorakiaReportesIntranet\\pdfs\\contabilidad\\venta\\Venta"+p.getCliente_nif().getNif()+".pdf";
	   DataSource fuente = new FileDataSource(nombreArchivo);
	   cuerpoMensaje.setDataHandler(new DataHandler(fuente));
	   cuerpoMensaje.setFileName(nombreArchivo);
	   multiparte.addBodyPart(cuerpoMensaje);
	   
	   // Asignamos al mensaje todas las partes que creamos anteriormente
	   mensaje.setContent(multiparte);
	   
	   // Asignamos el mensaje como tal
	   //mensaje.setText("El mensaje de nuestro primer correo ");

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
