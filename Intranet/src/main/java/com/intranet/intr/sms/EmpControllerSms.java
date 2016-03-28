/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.sms;

import com.intranet.beans.sms;
import com.intranet.service.EmpleadoService;
import com.intranet.service.UsuarioService;
import com.intranet.service.ValidaInterfacesRoles;
import java.security.Principal;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
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
public class EmpControllerSms {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UsuarioService usuarioService;
    
     @RequestMapping(value = "ESMS.htm",method=RequestMethod.GET)
    public String ESMS_get(ModelMap map,Principal principal,@RequestParam(value = "msg",required=false) String msg) {
        if(msg!=null &&msg!=""){
              if(msg.equals("success")) {
               map.addAttribute("msg", "Presupuesto Aceptado y Asignado Correctamente");
              }else{
                  map.addAttribute("error", "Operacion Rechazada, Intente Nuevamente");
              }
           }
        String r=validaInterfacesRoles.valida();
        map.addAttribute("menu",r);
        map.addAttribute("mensaje",new sms());
        return "SMS";
    }
     @RequestMapping(value = "ESMS.htm",method=RequestMethod.POST)
    public String addEstudio_post(@ModelAttribute("mensaje")sms mensaje,BindingResult result,ModelMap map) {
        try{
            map.addAttribute("msg","success");
            HttpClient client = new HttpClient();
        client.setStrictMode(true);
        //Se fija el tiempo m´aximo de espera de la respuesta del servidor
        client.setTimeout(60000);
        //Se fija el tiempo m´aximo de espera para conectar con el servidor
        client.setConnectionTimeout(5000);
        PostMethod post = null;
        //Se fija la URL sobre la que enviar la petici´on POST
            //Como ejemplo la petici´on se env´ıa a www.altiria.net/sustituirPOSTsms
            //Se debe reemplazar la cadena ’/sustituirPOSTsms’ por la parte correspondiente
            //de la URL suministrada por Altiria al dar de alta el servicio
            post = new PostMethod("http://www.altiria.net/api/http");
            //Se fija la codificaci´on de caracteres en la cabecera de la petici´on
            post.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded; charset=UTF-8");
            //Se crea la lista de par´ametros a enviar en la petici´on POST
            NameValuePair[] parametersList = new NameValuePair[6];
            //XX, YY y ZZ se corresponden con los valores de identificaci´on del
            //usuario en el sistema.
            parametersList[0] = new NameValuePair("cmd", "sendsms");
            parametersList[1] = new NameValuePair("domainId", "comercial");
            parametersList[2] = new NameValuePair("login", "jfruano");
            parametersList[3] = new NameValuePair("passwd", "wrnkmekt");
            parametersList[4] = new NameValuePair("dest", "34"+mensaje.getNum());
            parametersList[5] = new NameValuePair("msg", ""+mensaje.getTexto());
            //Se rellena el cuerpo de la petici´on POST con los par´ametros
            post.setRequestBody(parametersList);
            int httpstatus = 0;
            String response = null;
            try {
            //Se env´ıa la petici´on
            httpstatus = client.executeMethod(post);
            //Se consigue la respuesta
            response = post.getResponseBodyAsString();
            }
            catch (Exception e) {
            //Habr´a que prever la captura de excepciones
            
            }
            finally {
            //En cualquier caso se cierra la conexi´on
            post.releaseConnection();
            }
            //Habr´a que prever posibles errores en la respuesta del servidor
            if (httpstatus!=200){
            
            }
            else {
            //Se procesa la respuesta capturada en la cadena ‘‘response’’
            }
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
        return "redirect:ESMS.htm";
        
        
    }
}
