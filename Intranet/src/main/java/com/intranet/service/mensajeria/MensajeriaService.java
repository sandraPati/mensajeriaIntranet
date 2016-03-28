/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.mensajeria;

import com.intranet.beans.empleados;
import com.intranet.beans.mensajeg;
import com.intranet.beans.mensajep;
import com.intranet.beans.relacion_mensajes;
import com.intranet.dao.MensajeriaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("mensajeriaService")
public class MensajeriaService {
    @Autowired
    private MensajeriaDAO mensajeriaDAO;
    public  int cantidadEmp (){
         return mensajeriaDAO.cantidadEmp();
     }
     public  empleados usuario (String nif){
         return mensajeriaDAO.usuario(nif);
     }
     public  List<empleados> ltaEmpleados (String nif){
         return mensajeriaDAO.ltaEmpleados(nif);
     }
    public List<mensajep> mensajePrivadoUsu(String nif_empleado,String nif_amigo){
         return mensajeriaDAO.mensajePrivadoUsu(nif_empleado,nif_amigo);
     }
    public boolean enviarMensaje(mensajep men){
         return mensajeriaDAO.enviarMensaje(men);
     }
    public boolean crearGrupo(mensajeg m,List<empleados> empleado){
         return mensajeriaDAO.crearGrupo(m,empleado);
     }
    public List<mensajeg> ListaMensajesGrupo(String nif){
         return mensajeriaDAO.ListaMensajesGrupo(nif);
     }
    public List<relacion_mensajes> MensajesaGrupo(int id_mgrupo){
         return mensajeriaDAO.MensajesaGrupo(id_mgrupo);
     }
    public boolean enviarMensajeaGrupo(relacion_mensajes mensaje){
         return mensajeriaDAO.enviarMensajeaGrupo(mensaje);
     }
    public List<empleados> amigosPorGrupo(int id_mgrupo){
         return mensajeriaDAO.amigosPorGrupo(id_mgrupo);
     }
}
