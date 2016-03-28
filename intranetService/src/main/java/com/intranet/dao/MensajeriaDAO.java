/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.empleados;
import com.intranet.beans.mensajeg;
import com.intranet.beans.mensajep;
import com.intranet.beans.relacion_mensajes;
import java.util.List;

public interface MensajeriaDAO {
    public  int cantidadEmp ();
    public  empleados usuario (String nif);
    public  List<empleados> ltaEmpleados (String nif);
    public List<mensajep> mensajePrivadoUsu(String nif_empleado,String nif_amigo);
    public boolean enviarMensaje(mensajep men);
    public boolean crearGrupo(mensajeg m,List<empleados> empleado);
    public List<mensajeg> ListaMensajesGrupo(String nif);
    public List<relacion_mensajes> MensajesaGrupo(int id_mgrupo);
    public boolean enviarMensajeaGrupo(relacion_mensajes mensaje);
    public List<empleados> amigosPorGrupo(int id_mgrupo);
    
}
