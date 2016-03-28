/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.inbox;

import com.intranet.beans.empleados;
import com.intranet.beans.users;
import com.intranet.intr.mensajesEmail.mensajeCorreoDecorakia;
import com.intranet.service.EmpleadoService;
import com.intranet.service.RolesService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp/*")
public class EmpControllerInbox {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private EmpleadoService empleadoService;
    private List<String> arc=new ArrayList<String>();
    
    @RequestMapping("EInbox.htm")
    public ModelAndView SeguimientoGPS(ModelAndView mav,Principal principal){
        String name = principal.getName();
        List<correoNoLeidos> lta=null;
        int numTodoscorreosNum=0;
        try{
            lta=ltaRecibidos(name);
            numTodoscorreosNum=todosCorreosNum(name);
        
        }catch(Exception ex){}
        //ModelAndView mav=new ModelAndView();
        String r=validaInterfacesRoles.valida();
        mav.addObject("menu",r);
        mav.addObject("numCT",numTodoscorreosNum);
        mav.addObject("lta",lta);
        mav.setViewName("EInbox");        
        return mav;
    }
    
    @RequestMapping("EverRecibido.htm")
    public String verRecibido(@RequestParam(value = "num") int num,ModelMap map,Principal principal) {
        correoNoLeidos correo=null;
        String name = principal.getName();
        
        try{
            correo=ltaRecibidos2(name,num);
            
            
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("correo",correo);
        return("EverRecibido");
        
    }
    
    @RequestMapping(value = "/Eajaxtest2", method = RequestMethod.GET)
    public @ResponseBody
    String getTime(Principal principal) {
        String name = principal.getName();
        
        int numMensa=numCorreosNOL(name);
        
        String result=""+numMensa;
        //System.out.println("ajaxtext");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        //String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }
    
    public int numCorreosNOL(String name){
        int numMensa=0;
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            users u=usuarioService.getByLogin(name);
            
               Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");

                store.connect("imap.1and1.es", u.getCorreoUsuario(), u.getCorreoContreasenna());

                System.out.println("ola"+store);

                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            
            Message msg[] = inbox.search(ft);
            System.out.println("MAILS: "+msg.length);
            System.out.println(" "+msg.length); 
            numMensa=msg.length;
        }catch(Exception ex){
        }
        return numMensa;
    }
    
    public int todosCorreosNum(String name){
        int num=0;
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            users u=usuarioService.getByLogin(name);
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");
                store.connect("imap.1and1.es", u.getCorreoUsuario(), u.getCorreoContreasenna());
                System.out.println("ola"+store);
                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
                Message msg[] = inbox.getMessages();
                System.out.println("MAILS: "+msg.length);
                System.out.println(" "+msg.length);
                num=msg.length;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return num;
    }
    
    public List<correoNoLeidos> ltaRecibidos(String name){
        List<correoNoLeidos> lta=new ArrayList<correoNoLeidos>();
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
             users u=usuarioService.getByLogin(name);
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");

                store.connect("imap.1and1.es", u.getCorreoUsuario(), u.getCorreoContreasenna());

                System.out.println("ola"+store);

                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
                 Calendar fecha3 = Calendar.getInstance();
                 fecha3.roll(Calendar.MONTH, false);
            Message msg[] = inbox.search(new  ReceivedDateTerm ( ComparisonTerm . GT ,fecha3.getTime()));
            System.out.println("MAILS: "+msg.length);
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            for(Message message:msg) {
                
                java.util.Date fecha = message.getSentDate();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
                int anio1=Integer.parseInt(formateador.format(fecha));
                
                formateador = new SimpleDateFormat("MM");
                int mes1=Integer.parseInt(formateador.format(fecha));
                
                
                Calendar fecha2 = Calendar.getInstance();
                int año = fecha2.get(Calendar.YEAR);
                int mes = fecha2.get(Calendar.MONTH) + 1;
                System.out.println("mail"+anio1+"-"+mes1+" sistema:"+año+"."+mes);
                //if(año==anio1 && mes==mes1){
                System.out.println(año+"-"+mes);
                    correoNoLeidos correo=new correoNoLeidos();
                    Object [] fila = new Object[4];                
                    correo.setNum(message.getMessageNumber());
                    correo.setFecha(message.getSentDate().toString());
                    correo.setDe(message.getFrom()[0].toString());
                    correo.setAsunto(message.getSubject().toString());
                    lta.add(correo);
                //}else break;
                //}
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
          
        return lta;
    }
    
     public correoNoLeidos ltaRecibidos2(String name,int num){
        correoNoLeidos lta=new correoNoLeidos();
       Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
             users u=usuarioService.getByLogin(name);
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");

                store.connect("imap.1and1.es", u.getCorreoUsuario(), u.getCorreoContreasenna());

                System.out.println("ola"+store);

                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
            Calendar fecha3 = Calendar.getInstance();
                 fecha3.roll(Calendar.MONTH, false);
            Message msg[] = inbox.search(new  ReceivedDateTerm ( ComparisonTerm . GT ,fecha3.getTime()));
            //Message msg[] = inbox.getMessages();
            System.out.println("MAILS: "+msg.length);
            for(Message message:msg) {
                try {            
                    if(num==message.getMessageNumber())
                    {
                        //message.setFlag(Flags.Flag.SEEN, true);
                        lta.setNum(message.getMessageNumber());
                        lta.setFecha(message.getSentDate().toString());
                        lta.setDe(message.getFrom()[0].toString());
                        lta.setAsunto(message.getSubject().toString());
                        correoNoLeidos co=new correoNoLeidos();
                        List<String> arc=new ArrayList<String>();
                        List<String> rar=new ArrayList<String>();
                        correoNoLeidos cc=analizaParteDeMensaje2(co,arc,rar,message);
                        lta.setImagenes(cc.getImagenes());
                        lta.setRar(cc.getRar());
                        lta.setContenido(cc.getContenido());
                        String cont="";
                        
                        String contenido="";
                        
                        //lta.setContenido(analizaParteDeMensaje2(message));
                    }
                } catch (Exception e) {
                    System.out.println("No Information");
                }
                
            }
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    
        return lta;
    }
    
    
    @RequestMapping(value = "/EajaxtestFoto", method = RequestMethod.GET)
    public @ResponseBody
    String getTimeFoto(Principal principal) {
        String name = principal.getName();
        empleados po=new empleados();
        
        try {
            users u=usuarioService.getByLogin(name);
            po=empleadoService.ByNif(u.getNif());
               
        }catch(Exception ex){
        }
     String result="/Intranet/resources/fotosPerfil/"+po.getNombrefotografia();
        //System.out.println("ajaxtext");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        //String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }
    
    @RequestMapping(value = "/EajaxtestNoL", method = RequestMethod.GET)
    public @ResponseBody
    String ajaxtestNoL(Principal principal) {
        String name = principal.getName();
        String result="";
        try {
            users u=usuarioService.getByLogin(name);
            
            Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
       
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");

                store.connect("imap.1and1.es", u.getCorreoUsuario(), u.getCorreoContreasenna());

                System.out.println("ola"+store);

                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
                
                
                FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
                Calendar fecha3 = Calendar.getInstance();
                 fecha3.roll(Calendar.MONTH, false);
            Message msg[] = inbox.search(new  ReceivedDateTerm ( ComparisonTerm . GT ,fecha3.getTime()));
                //Message msg[] = inbox.search(ft);
                System.out.println("MAILS: "+msg.length);
                for(Message message:msg) {
                    try {
                        /*System.out.println("DATE: "+message.getSentDate().toString());
                        System.out.println("FROM: "+message.getFrom()[0].toString());            
                        System.out.println("SUBJECT: "+message.getSubject().toString());
                        System.out.println("CONTENT: "+message.getContent().toString());
                        System.out.println("******************************************");
                        */result=result+"<li>"+
                                "<a href='#' class='clearfix'>"+
                                        "<span class='msg-body'>"+
                                                "<span class='msg-title'>"+
                                                        "<span class='blue'>"+message.getFrom()[0].toString()+"</span>"+
                                                        
                                                       message.getSubject().toString()+
                                                "</span>"+
                                                
                                        "</span>"+
                                "</a>"+
                        "</li> ";
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        System.out.println("No Information");
                    }
                }
            
            
        }catch(Exception ex){
        }
        
        return result;
    } 
    
    
    
    
    
    
    
    private static correoNoLeidos analizaParteDeMensaje2(correoNoLeidos correo,List<String> arc,List<String> rar,Part unaParte) {
        String r=null;
        try
        {
            System.out.println("CORREO NUM: ");
          // Si es multipart, se analiza cada una de sus partes recursivamente.
            if (unaParte.isMimeType("multipart/*"))
            {
                Multipart multi;
                multi = (Multipart) unaParte.getContent();
                System.out.println("for MULTIPART");
                for (int j = 0; j < multi.getCount(); j++)
                {
                    System.out.println("Si es multi");
                    analizaParteDeMensaje2(correo,arc,rar,multi.getBodyPart(j));
                }
            }
            else
            {
              // Si es texto, se escribe el texto.
               if (unaParte.isMimeType("text/*"))
                {
                    System.out.println("Texto " + unaParte.getContentType());
                    System.out.println(unaParte.getContent());
                    System.out.println("---------------------------------");
                      correo.setContenido((String) unaParte.getContent());
                }
                
                  // Si es imagen, se guarda en fichero y se visualiza en JFrame
                    if (unaParte.isMimeType("image/*"))
                    {
                        System.out.println("IMAGEN SYSTEM");
                        System.out.println(
                            "Imagen " + unaParte.getContentType());
                        System.out.println("Fichero=" + unaParte.getFileName());
                        System.out.println("---------------------------------");

                        arc.add("/Intranet/resources/archivosMail/verCorreo/"+salvaImagenEnFichero(unaParte));
                        //visualizaImagenEnJFrame(unaParte);
                    }
                    else
                    {
                         System.out.println("ELSE img");
                      // Si no es ninguna de las anteriores, se escribe en pantalla
                      // el tipo.
                        System.out.println("Recibido " + unaParte.getContentType());
                        System.out.println("---------------------------------");
                        if(salvaImagenEnFichero(unaParte)!=null & salvaImagenEnFichero(unaParte)!=""){
                        rar.add(salvaImagenEnFichero(unaParte));
                        }
                        correo.setContenido((String) unaParte.getContent());
                    }
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        correo.setImagenes(arc);
        correo.setRar(rar);
        return correo;
    }
    
    private static void visualizaImagenEnJFrame(Part unaParte)throws IOException, MessagingException
     {
        
        System.out.println("ola");
        
     }
     
     private static String salvaImagenEnFichero(Part unaParte)
        throws FileNotFoundException, MessagingException, IOException
    {
        FileOutputStream fichero = new FileOutputStream(
                "C:\\glassfish-4.1.1-web\\glassfish4\\glassfish\\domains\\domain1\\applications\\Intranet\\resources\\archivosMail\\verCorreo\\" + unaParte.getFileName());
        InputStream imagen = unaParte.getInputStream();
        byte[] bytes = new byte[1000];
        int leidos = 0;

        while ((leidos = imagen.read(bytes)) > 0)
        {
            fichero.write(bytes, 0, leidos);
        }
        return unaParte.getFileName();
    }
    
     
     @RequestMapping(value = "EenviarMail.htm",method=RequestMethod.GET)
    public String addContrato_get(ModelMap map) {
        correoNoLeidos c=new correoNoLeidos();
        
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("correo",c);
        
        return "EenviarMail";
    }
    
    @RequestMapping(value = "EenviarMail.htm",method=RequestMethod.POST)
    public String addContrato_post(@ModelAttribute("correo")correoNoLeidos c,BindingResult result,Principal principal,HttpServletRequest request) {
        String mensaje="";
        String name=principal.getName();
        try{
            //MultipartFile multipart = c.getArchivo();
            for(String s:arc){
            System.out.println("metodo enviar foto: "+s);
            }
            c.setImagenes(arc);
             users u=usuarioService.getByLogin(name);
             mensajeCorreoDecorakia msj=new mensajeCorreoDecorakia();
             msj.mensaje(c, u);
        }catch(Exception ex){
        
        }
         return "redirect:EInbox.htm";
        
        
        
    }
     
     
    @RequestMapping(value = "EenviarMailA.htm",method=RequestMethod.GET)
    public String enviarMailA_get(ModelMap map) {
        correoNoLeidos c=new correoNoLeidos();
        arc=new ArrayList<String>();
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("correo",c);
        
        return "EenviarMailA";
    }
    
    @RequestMapping(value = "EenviarMailA.htm",method=RequestMethod.POST)
    public String enviarMailA_post(@ModelAttribute("correo")correoNoLeidos c,BindingResult result,HttpServletRequest request) {
        String mensaje="";
        
        try{
            //MultipartFile multipart = c.getArchivo();
            System.out.println("olaEnviarMAILS");
            String ubicacionArchivo="C:\\DecorakiaReportesIntranet\\archivosMail\\";
            //File file=new File(ubicacionArchivo,multipart.getOriginalFilename());
            //String ubicacionArchivo="C:\\";
            
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            ServletFileUpload upload=new ServletFileUpload(factory);
            
            List<FileItem> partes=upload.parseRequest(request);
            
            for(FileItem item : partes)
            {
                System.out.println("NOMBRE FOTO: "+item.getName());
                File file=new File(ubicacionArchivo,item.getName());
                item.write(file);
                arc.add(item.getName());
                System.out.println("img"+item.getName());
            }
            //c.setImagenes(arc);
             
        }catch(Exception ex){
        
        }
         return "redirect:EenviarMail.htm";
        
        
        
    }
    
}
