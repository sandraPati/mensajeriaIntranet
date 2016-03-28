/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.inbox;

import java.util.ArrayList;
import java.util.List;
import javax.mail.Folder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;
@XmlRootElement
public class correoNoLeidos {
    String nif;
    String fecha;
    String de;
    String asunto;
    String contenido;
    int num;
    List<String> imagenes;
    List<String> rar;
    Byte archivo;
    
    public correoNoLeidos() {
    }

    public correoNoLeidos(String nif, String fecha, String de, String asunto, String contenido,int num) {
        this.nif = nif;
        this.fecha = fecha;
        this.de = de;
        this.asunto = asunto;
        this.contenido = contenido;
        this.num=num;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public Byte getArchivo() {
        return archivo;
    }

    public void setArchivo(Byte archivo) {
        this.archivo = archivo;
    }

    public List<String> getRar() {
        return rar;
    }

    public void setRar(List<String> rar) {
        this.rar = rar;
    }

    @XmlElementWrapper(name="sugerencias")
    @XmlElement(name="sugerencia")
    public List<String> getSugerencias() {
        List<String> lta=new ArrayList<String>();
        lta.add("ola");
        lta.add("w");
        return lta;
    }
    
}
