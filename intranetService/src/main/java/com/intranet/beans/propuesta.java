/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class propuesta {
    Integer id;
Date dia;
String hora;

empleados empleado_nif;
clientes cliente_nif;
String nifCliente;
String direccion;
String pais;
String poblacion;
String nacionalidad;
String codigo_postal;
String provincia;
String descipcion;
int estado;
Date fechaproyecto;
String coincide;
List<estancias> ltaEstancias=new ArrayList<estancias>();

float totalSpanos=0;
float superficie=0;
	//Double totalS2;
	float totalSventanas=0;
	float totalSpuertas=0;
	float totalSarmarios=0;
	float totalSsuelos=0;
	float totalStechos=0;
        int numventanas=0;
        int numpuertas=0;
        int numarmarios=0;
        
        int tienePresupuesto=0;
        int plantilla=0;
        plantillaPresupuesto objplantilla;
        int tieneEstancias=0;
        
        float descuentoproveedor=0;
        
        int tipopropuesta=1;
    public propuesta() {
    }

    public propuesta(Integer id, Date dia, String hora, empleados empleado_nif, clientes cliente_nif, String direccion, String pais, String poblacion, String nacionalidad, String codigo_postal, String provincia, String descipcion, int estado, Date fechaproyecto) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.empleado_nif = empleado_nif;
        this.cliente_nif = cliente_nif;
        this.direccion = direccion;
        this.pais = pais;
        this.poblacion = poblacion;
        this.nacionalidad = nacionalidad;
        this.codigo_postal = codigo_postal;
        this.provincia = provincia;
        this.descipcion = descipcion;
        this.estado = estado;
        this.fechaproyecto = fechaproyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public empleados getEmpleado_nif() {
        return empleado_nif;
    }

    public void setEmpleado_nif(empleados empleado_nif) {
        this.empleado_nif = empleado_nif;
    }

    public clientes getCliente_nif() {
        return cliente_nif;
    }

    public void setCliente_nif(clientes cliente_nif) {
        this.cliente_nif = cliente_nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaproyecto() {
        return fechaproyecto;
    }

    public void setFechaproyecto(Date fechaproyecto) {
        this.fechaproyecto = fechaproyecto;
    }

    public String getCoincide() {
        return coincide;
    }

    public void setCoincide(String coincide) {
        this.coincide = coincide;
    }

    
    
    
    
    
    
    
    
    
    
    public float getTotalSpanos() {
        return totalSpanos;
    }

    public void setTotalSpanos(float totalSpanos) {
        this.totalSpanos = totalSpanos;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public float getTotalSventanas() {
        return totalSventanas;
    }

    public void setTotalSventanas(float totalSventanas) {
        this.totalSventanas = totalSventanas;
    }

    public float getTotalSpuertas() {
        return totalSpuertas;
    }

    public void setTotalSpuertas(float totalSpuertas) {
        this.totalSpuertas = totalSpuertas;
    }

    public float getTotalSarmarios() {
        return totalSarmarios;
    }

    public void setTotalSarmarios(float totalSarmarios) {
        this.totalSarmarios = totalSarmarios;
    }

    public float getTotalSsuelos() {
        return totalSsuelos;
    }

    public void setTotalSsuelos(float totalSsuelos) {
        this.totalSsuelos = totalSsuelos;
    }

    public float getTotalStechos() {
        return totalStechos;
    }

    public void setTotalStechos(float totalStechos) {
        this.totalStechos = totalStechos;
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

    public List<estancias> getLtaEstancias() {
        return ltaEstancias;
    }

    public void setLtaEstancias(List<estancias> ltaEstancias) {
        this.ltaEstancias = ltaEstancias;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public int getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(int plantilla) {
        this.plantilla = plantilla;
    }

    public int getTienePresupuesto() {
        return tienePresupuesto;
    }

    public void setTienePresupuesto(int tienePresupuesto) {
        this.tienePresupuesto = tienePresupuesto;
    }

    public plantillaPresupuesto getObjplantilla() {
        return objplantilla;
    }

    public void setObjplantilla(plantillaPresupuesto objplantilla) {
        this.objplantilla = objplantilla;
    }

    public int getTieneEstancias() {
        return tieneEstancias;
    }

    public void setTieneEstancias(int tieneEstancias) {
        this.tieneEstancias = tieneEstancias;
    }

    public float getDescuentoproveedor() {
        return descuentoproveedor;
    }

    public void setDescuentoproveedor(float descuentoproveedor) {
        this.descuentoproveedor = descuentoproveedor;
    }

    public int getTipopropuesta() {
        return tipopropuesta;
    }

    public void setTipopropuesta(int tipopropuesta) {
        this.tipopropuesta = tipopropuesta;
    }

    
    
}
