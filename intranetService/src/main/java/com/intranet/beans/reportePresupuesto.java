/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

public class reportePresupuesto {
    String nombredelcapitulo;
	int idpresupuesto;
	String nombresubcapitulo;
	String descripcion;
	int udds;
	Double longitud;
	Double altura;
	Double parciales;
	Double cantidad;
	Double precio;
	Double importe;
	Double total;

    public reportePresupuesto() {
    }

    public reportePresupuesto(String nombredelcapitulo, int idpresupuesto, String nombresubcapitulo, String descripcion, int udds, Double longitud, Double altura, Double parciales, Double cantidad, Double precio, Double importe, Double total) {
        this.nombredelcapitulo = nombredelcapitulo;
        this.idpresupuesto = idpresupuesto;
        this.nombresubcapitulo = nombresubcapitulo;
        this.descripcion = descripcion;
        this.udds = udds;
        this.longitud = longitud;
        this.altura = altura;
        this.parciales = parciales;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
        this.total = total;
    }

    public String getNombredelcapitulo() {
        return nombredelcapitulo;
    }

    public void setNombredelcapitulo(String nombredelcapitulo) {
        this.nombredelcapitulo = nombredelcapitulo;
    }

    public int getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(int idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public String getNombresubcapitulo() {
        return nombresubcapitulo;
    }

    public void setNombresubcapitulo(String nombresubcapitulo) {
        this.nombresubcapitulo = nombresubcapitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUdds() {
        return udds;
    }

    public void setUdds(int udds) {
        this.udds = udds;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getParciales() {
        return parciales;
    }

    public void setParciales(Double parciales) {
        this.parciales = parciales;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
        
        
}
