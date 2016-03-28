/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class subcapitulos {
    Integer id;
    String nombre;
    float cantidad=0;
    String tipo;
    capitulos id_capitulo;
    String cod;
    String nota;
    
    public subcapitulos() {
    }

    public subcapitulos(Integer id, String nombre, String tipo, capitulos id_capitulo, String cod, String nota) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.id_capitulo = id_capitulo;
        this.cod = cod;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public capitulos getId_capitulo() {
        return id_capitulo;
    }

    public void setId_capitulo(capitulos id_capitulo) {
        this.id_capitulo = id_capitulo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

   
    
}
