/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class proyecto_trabajadores {
    int id;
	proyecto_presupuestos id_proyecto_presupuesto;
	empleados nif_empleado;
	String descripcion;
	String finicio;
	String ffin;
	String ccabecera="#3366ff";
	String contenido="#6699ff";
	String estado;
	String nota;
	Boolean cond=false;
	Date fecharecoratorio;
	int condicion;
	clientes cli;
	empleados empl;
	int numhoras=0;

    public proyecto_trabajadores() {
    }

    public proyecto_trabajadores(int id, proyecto_presupuestos id_proyecto_presupuesto, empleados nif_empleado, String descripcion, String finicio, String ffin, String estado, String nota, Date fecharecoratorio, int condicion, clientes cli, empleados empl) {
        this.id = id;
        this.id_proyecto_presupuesto = id_proyecto_presupuesto;
        this.nif_empleado = nif_empleado;
        this.descripcion = descripcion;
        this.finicio = finicio;
        this.ffin = ffin;
        this.estado = estado;
        this.nota = nota;
        this.fecharecoratorio = fecharecoratorio;
        this.condicion = condicion;
        this.cli = cli;
        this.empl = empl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public proyecto_presupuestos getId_proyecto_presupuesto() {
        return id_proyecto_presupuesto;
    }

    public void setId_proyecto_presupuesto(proyecto_presupuestos id_proyecto_presupuesto) {
        this.id_proyecto_presupuesto = id_proyecto_presupuesto;
    }

    public empleados getNif_empleado() {
        return nif_empleado;
    }

    public void setNif_empleado(empleados nif_empleado) {
        this.nif_empleado = nif_empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getCcabecera() {
        return ccabecera;
    }

    public void setCcabecera(String ccabecera) {
        this.ccabecera = ccabecera;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Boolean getCond() {
        return cond;
    }

    public void setCond(Boolean cond) {
        this.cond = cond;
    }

    public Date getFecharecoratorio() {
        return fecharecoratorio;
    }

    public void setFecharecoratorio(Date fecharecoratorio) {
        this.fecharecoratorio = fecharecoratorio;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public clientes getCli() {
        return cli;
    }

    public void setCli(clientes cli) {
        this.cli = cli;
    }

    public empleados getEmpl() {
        return empl;
    }

    public void setEmpl(empleados empl) {
        this.empl = empl;
    }

    public int getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(int numhoras) {
        this.numhoras = numhoras;
    }
        
        
}
