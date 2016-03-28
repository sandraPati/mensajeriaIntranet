/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import static java.lang.Math.sqrt;
import java.util.List;

public class panos {
    Integer id;
	estancias estancia_id;
	tipo_pano tipo_pano_id;
        int formapano;
	float largo;
	float alto;
        float lado3;
        float lado4;
	float superficie;
	int numventanas;
        int numventanas2;
	float largoventana;
	float altoventana;
	float superficieventana;
	int numpuertas;
	float largopuerta;
	float altopuerta;
	float superficiepuerta;
	int numarmarios;
	float largoarmario;
	float altoarmario;
	float fondoarmario;
	float superficiearmario;
	String nombrepano;
	int numero;
	float total;
        String ventana;
        String puertas;
        String armario;
        
        int ageregado=0;
        
        float largopresupuesto=0;
        
        
        List<ventanas> ventanaspano;
        List<puertas> puertaspano;
        List<armarios> armariospano;
    public panos() {
    }

    public panos(Integer id, estancias estancia_id, tipo_pano tipo_pano_id, float superficie, int numventanas, float superficieventana, int numpuertas, float superficiepuerta, int numarmarios, float superficiearmario, String nombrepano, int numero) {
        this.id = id;
        this.estancia_id = estancia_id;
        this.tipo_pano_id = tipo_pano_id;
        this.superficie = superficie;
        this.numventanas = numventanas;
        this.superficieventana = superficieventana;
        this.numpuertas = numpuertas;
        this.superficiepuerta = superficiepuerta;
        this.numarmarios = numarmarios;
        this.superficiearmario = superficiearmario;
        this.nombrepano = nombrepano;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public estancias getEstancia_id() {
        return estancia_id;
    }

    public void setEstancia_id(estancias estancia_id) {
        this.estancia_id = estancia_id;
    }

    public tipo_pano getTipo_pano_id() {
        return tipo_pano_id;
    }

    public void setTipo_pano_id(tipo_pano tipo_pano_id) {
        this.tipo_pano_id = tipo_pano_id;
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

    public int getNumventanas() {
        return numventanas;
    }

    public void setNumventanas(int numventanas) {
        this.numventanas = numventanas;
    }

    public float getLargoventana() {
        return largoventana;
    }

    public void setLargoventana(float largoventana) {
        this.largoventana = largoventana;
    }

    public float getAltoventana() {
        return altoventana;
    }

    public void setAltoventana(float altoventana) {
        this.altoventana = altoventana;
    }

    public float getSuperficieventana() {
        return superficieventana;
    }

    public void setSuperficieventana(float superficieventana) {
        this.superficieventana = superficieventana;
    }

    public int getNumpuertas() {
        return numpuertas;
    }

    public void setNumpuertas(int numpuertas) {
        this.numpuertas = numpuertas;
    }

    public float getLargopuerta() {
        return largopuerta;
    }

    public void setLargopuerta(float largopuerta) {
        this.largopuerta = largopuerta;
    }

    public float getAltopuerta() {
        return altopuerta;
    }

    public void setAltopuerta(float altopuerta) {
        this.altopuerta = altopuerta;
    }

    public float getSuperficiepuerta() {
        return superficiepuerta;
    }

    public void setSuperficiepuerta(float superficiepuerta) {
        this.superficiepuerta = superficiepuerta;
    }

    public int getNumarmarios() {
        return numarmarios;
    }

    public void setNumarmarios(int numarmarios) {
        this.numarmarios = numarmarios;
    }

    public float getLargoarmario() {
        return largoarmario;
    }

    public void setLargoarmario(float largoarmario) {
        this.largoarmario = largoarmario;
    }

    public float getAltoarmario() {
        return altoarmario;
    }

    public void setAltoarmario(float altoarmario) {
        this.altoarmario = altoarmario;
    }

    public float getFondoarmario() {
        return fondoarmario;
    }

    public void setFondoarmario(float fondoarmario) {
        this.fondoarmario = fondoarmario;
    }

    public float getSuperficiearmario() {
        return superficiearmario;
    }

    public void setSuperficiearmario(float superficiearmario) {
        this.superficiearmario = superficiearmario;
    }

    public String getNombrepano() {
        return nombrepano;
    }

    public void setNombrepano(String nombrepano) {
        this.nombrepano = nombrepano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    public String getArmario() {
        return armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public int getAgeregado() {
        return ageregado;
    }

    public void setAgeregado(int ageregado) {
        this.ageregado = ageregado;
    }

    public List<ventanas> getVentanaspano() {
        return ventanaspano;
    }

    public void setVentanaspano(List<ventanas> ventanaspano) {
        this.ventanaspano = ventanaspano;
    }

    public List<puertas> getPuertaspano() {
        return puertaspano;
    }

    public void setPuertaspano(List<puertas> puertaspano) {
        this.puertaspano = puertaspano;
    }

    public List<armarios> getArmariospano() {
        return armariospano;
    }

    public void setArmariospano(List<armarios> armariospano) {
        this.armariospano = armariospano;
    }

    public int getNumventanas2() {
        return numventanas2;
    }

    public void setNumventanas2(int numventanas2) {
        this.numventanas2 = numventanas2;
    }

    public float getLado3() {
        return lado3;
    }

    public void setLado3(float lado3) {
        this.lado3 = lado3;
    }

   public void superficieL(){
       float p=(largo+alto+lado3);
       float area=(float)sqrt(p*(p-largo)*(p-alto)*(p-lado3));
       superficie=area;
   }

    public int getFormapano() {
        return formapano;
    }

    public void setFormapano(int formapano) {
        this.formapano = formapano;
    }

    public float getLado4() {
        return lado4;
    }

    public void setLado4(float lado4) {
        this.lado4 = lado4;
    }

    public float getLargopresupuesto() {
        return largopresupuesto;
    }

    public void setLargopresupuesto(float largopresupuesto) {
        this.largopresupuesto = largopresupuesto;
    }

    
    
}
