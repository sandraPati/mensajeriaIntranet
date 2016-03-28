/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.util.ArrayList;
import java.util.List;

public class estancias {
    Integer id;
	propuesta propuesta_id;
	tipo_estancia tipo_estancia_id;
	String otro_tipo="";
	float largo;
	float alto;
	float superficie=0;
	List<panos> ltaPanos;
	int numero;
	float totalSpanos=0;
	//Double totalS2;
	float TotalSventanas=0;
	float TotalSpuertas=0;
	float TotalSarmarios=0;
	float TotalSsuelos=0;
	float TotalStechos=0;
        int numventanas=0;
        int numpuertas=0;
        int numarmarios=0;
        List<panos> ltaPa=new ArrayList<panos>();
        int asignado;
    public estancias() {
    }

    public estancias(Integer id, propuesta propuesta_id, tipo_estancia tipo_estancia_id, List<panos> ltaPanos, int numero) {
        this.id = id;
        this.propuesta_id = propuesta_id;
        this.tipo_estancia_id = tipo_estancia_id;
        this.ltaPanos = ltaPanos;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public propuesta getPropuesta_id() {
        return propuesta_id;
    }

    public void setPropuesta_id(propuesta propuesta_id) {
        this.propuesta_id = propuesta_id;
    }

    public tipo_estancia getTipo_estancia_id() {
        return tipo_estancia_id;
    }

    public void setTipo_estancia_id(tipo_estancia tipo_estancia_id) {
        this.tipo_estancia_id = tipo_estancia_id;
    }

    public String getOtro_tipo() {
        return otro_tipo;
    }

    public void setOtro_tipo(String otro_tipo) {
        this.otro_tipo = otro_tipo;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public List<panos> getLtaPanos() {
        return ltaPanos;
    }

    public void setLtaPanos(List<panos> ltaPanos) {
        this.ltaPanos = ltaPanos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTotalSpanos() {
        return totalSpanos;
    }

    public void setTotalSpanos(float totalSpanos) {
        this.totalSpanos = totalSpanos;
    }

    public float getTotalSventanas() {
        return TotalSventanas;
    }

    public void setTotalSventanas(float TotalSventanas) {
        this.TotalSventanas = TotalSventanas;
    }

    public float getTotalSpuertas() {
        return TotalSpuertas;
    }

    public void setTotalSpuertas(float TotalSpuertas) {
        this.TotalSpuertas = TotalSpuertas;
    }

    public float getTotalSarmarios() {
        return TotalSarmarios;
    }

    public void setTotalSarmarios(float TotalSarmarios) {
        this.TotalSarmarios = TotalSarmarios;
    }

    public float getTotalSsuelos() {
        return TotalSsuelos;
    }

    public void setTotalSsuelos(float TotalSsuelos) {
        this.TotalSsuelos = TotalSsuelos;
    }

    public float getTotalStechos() {
        return TotalStechos;
    }

    public void setTotalStechos(float TotalStechos) {
        this.TotalStechos = TotalStechos;
    }

    public int getNumventanas() {
        return numventanas;
    }

    public void setNumventanas(int numventanas) {
        this.numventanas = numventanas;
    }

    public int getNumpuertas() {
        return numpuertas;
    }

    public void setNumpuertas(int numpuertas) {
        this.numpuertas = numpuertas;
    }

    public int getNumarmarios() {
        return numarmarios;
    }

    public void setNumarmarios(int numarmarios) {
        this.numarmarios = numarmarios;
    }

    public List<panos> getLtaPa() {
        return ltaPa;
    }

    public void setLtaPa(List<panos> ltaPa) {
        this.ltaPa = ltaPa;
    }
        
      public void superficieL(List<panos>lta){
          superficie=0;
          for(panos p:lta){
              superficie=superficie+p.getSuperficie();
          }
         
   }  

    public int getAsignado() {
        return asignado;
    }

    public void setAsignado(int asignado) {
        this.asignado = asignado;
    }
    
}
