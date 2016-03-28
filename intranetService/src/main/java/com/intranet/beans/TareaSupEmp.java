/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.beans;

import java.sql.Date;

public class TareaSupEmp {
    private int id;
	private String nifsupervisor;
	private String nifempleado;
	private String nifcliente;
	private String descripcion;
	private String finicio;
	private String ffin;
	private String ccabecera;
	private String ccontenido;
	private String estado;
	private String nota;
	private String cerrado;
	private int condicion;
        private boolean allDay;
	Boolean cond=false;
	Date fecharecoratorio;
	clientes cli;
	empleados sup;
	empleados empl;
	String tipotarea_id;
        String cliasignado;

    public String getCliasignado() {
        return cliasignado;
    }

    public void setCliasignado(String cliasignado) {
        this.cliasignado = cliasignado;
    }
        
    public TareaSupEmp() {
    }

    public TareaSupEmp(int id, String nifsupervisor, String nifempleado, String nifcliente, String descripcion, String finicio, String ffin, String ccabecera, String ccontenido, String estado, String nota, String cerrado, int condicion, Date fecharecoratorio, clientes cli, empleados sup, empleados empl, String tipotarea_id) {
        this.id = id;
        this.nifsupervisor = nifsupervisor;
        this.nifempleado = nifempleado;
        this.nifcliente = nifcliente;
        this.descripcion = descripcion;
        this.finicio = finicio;
        this.ffin = ffin;
        this.ccabecera = ccabecera;
        this.ccontenido = ccontenido;
        this.estado = estado;
        this.nota = nota;
        this.cerrado = cerrado;
        this.condicion = condicion;
        this.fecharecoratorio = fecharecoratorio;
        this.cli = cli;
        this.sup = sup;
        this.empl = empl;
        this.tipotarea_id = tipotarea_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNifsupervisor() {
        return nifsupervisor;
    }

    public void setNifsupervisor(String nifsupervisor) {
        this.nifsupervisor = nifsupervisor;
    }

    public String getNifempleado() {
        return nifempleado;
    }

    public void setNifempleado(String nifempleado) {
        this.nifempleado = nifempleado;
    }

    public String getNifcliente() {
        return nifcliente;
    }

    public void setNifcliente(String nifcliente) {
        this.nifcliente = nifcliente;
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

    public String getCcontenido() {
        return ccontenido;
    }

    public void setCcontenido(String ccontenido) {
        this.ccontenido = ccontenido;
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

    public String getCerrado() {
        return cerrado;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
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

    public clientes getCli() {
        return cli;
    }

    public void setCli(clientes cli) {
        this.cli = cli;
    }

    public empleados getSup() {
        return sup;
    }

    public void setSup(empleados sup) {
        this.sup = sup;
    }

    public empleados getEmpl() {
        return empl;
    }

    public void setEmpl(empleados empl) {
        this.empl = empl;
    }

    public String getTipotarea_id() {
        return tipotarea_id;
    }

    public void setTipotarea_id(String tipotarea_id) {
        this.tipotarea_id = tipotarea_id;
    }

    public boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
        
        
}
