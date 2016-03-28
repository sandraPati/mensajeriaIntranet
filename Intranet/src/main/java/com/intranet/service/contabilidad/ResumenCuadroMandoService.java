/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service.contabilidad;

import com.intranet.dao.ResumenCuadroMandoDAO;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resumenCuadroMandoService")
public class ResumenCuadroMandoService {
    @Autowired
    ResumenCuadroMandoDAO resumenCuadroMandoDAO;
    
    public Double TotalIngresos(){
        return resumenCuadroMandoDAO.TotalIngresos();
    }
    public Double TotalGastos(){
        return resumenCuadroMandoDAO.TotalGastos();
    }
    public Double TotalBeneficio(){
        return resumenCuadroMandoDAO.TotalBeneficio();
    }
    public Double TotalIngresosP(){
        return resumenCuadroMandoDAO.TotalIngresosP();
    }
    public Double TotalIngresosP(String anio){
        return resumenCuadroMandoDAO.TotalIngresosP(anio);
    }
    public Double TotalIngresosP(String mes, String anio){
        return resumenCuadroMandoDAO.TotalIngresosP(mes,anio);
    }
    public Double TotalIngresosPFecha(String fecha){
        return resumenCuadroMandoDAO.TotalIngresosPFecha(fecha);
    }
    
    
    public Double TotalGastosP(){
        return resumenCuadroMandoDAO.TotalGastosP();
    }
    public Double TotalGastosP(String anio){
        return resumenCuadroMandoDAO.TotalGastosP(anio);
    }
    public Double TotalGastosP(String mes, String anio){
        return resumenCuadroMandoDAO.TotalGastosP(mes,anio);
    }
    public Double TotalGastosPFecha(String fecha){
        return resumenCuadroMandoDAO.TotalGastosPFecha(fecha);
    }
    
    public Double TotalBeneficioP(){
        return resumenCuadroMandoDAO.TotalBeneficioP();
    }
    public Double TotalBeneficioP(String anio){
        return resumenCuadroMandoDAO.TotalBeneficioP(anio);
    }
    public Double TotalBeneficioP(String mes, String anio){
        return resumenCuadroMandoDAO.TotalBeneficioP(mes,anio);
    }
    public Double TotalBeneficioPFecha(String fecha){
        return resumenCuadroMandoDAO.TotalBeneficioPFecha(fecha);
    }
    
     public Double TotalIngresosI(){
        return resumenCuadroMandoDAO.TotalIngresosI();
    }
     public Double TotalIngresosI(String anio){
        return resumenCuadroMandoDAO.TotalIngresosI(anio);
    }
    public Double TotalIngresosI(String mes, String anio){
        return resumenCuadroMandoDAO.TotalIngresosI(mes,anio);
    }
    public Double TotalIngresosIFecha(String fecha){
        return resumenCuadroMandoDAO.TotalIngresosIFecha(fecha);
    }
    
    public Double TotalGastosI(){
        return resumenCuadroMandoDAO.TotalGastosI();
    }
    public Double TotalGastosI(String anio){
        return resumenCuadroMandoDAO.TotalGastosI(anio);
    }
    public Double TotalGastosI(String mes, String anio){
        return resumenCuadroMandoDAO.TotalGastosI(mes,anio);
    }
    public Double TotalGastosIFecha(String fecha){
        return resumenCuadroMandoDAO.TotalGastosIFecha(fecha);
    }
    
    public Double TotalBeneficioI(String anio){
        return resumenCuadroMandoDAO.TotalBeneficioI(anio);
    }
    public Double TotalBeneficioI(){
        return resumenCuadroMandoDAO.TotalBeneficioI();
    }
    public Double TotalBeneficioI(String mes, String anio){
        return resumenCuadroMandoDAO.TotalBeneficioI(mes,anio);
    }
    public Double TotalBeneficioIFecha(String fecha){
        return resumenCuadroMandoDAO.TotalBeneficioIFecha(fecha);
    }
    
    public Double clienteF(){
        return resumenCuadroMandoDAO.clienteF();
    }
    public Double clienteF(String anio){
        return resumenCuadroMandoDAO.clienteF(anio);
    }
    public Double clienteF(String mes, String anio){
        return resumenCuadroMandoDAO.clienteF(mes,anio);
    }
    public Double clienteFFecha(String fecha){
        return resumenCuadroMandoDAO.clienteF(fecha);
    }
    public Integer visitasFecha(String fecha){
        return resumenCuadroMandoDAO.visitasFecha(fecha);
    }
    public Integer visitas(String mes, String anio){
        return resumenCuadroMandoDAO.visitas(mes,anio);
    }
    public Integer visitas(String anio){
        return resumenCuadroMandoDAO.visitas(anio);
    }
    public Integer visitas(){
        return resumenCuadroMandoDAO.visitas();
    }
    public Integer presupuesto(){
        return resumenCuadroMandoDAO.presupuesto();
    }
    public Integer presupuesto(String anio){
        return resumenCuadroMandoDAO.presupuesto(anio);
    }
    public Integer presupuesto(String mes, String anio){
        return resumenCuadroMandoDAO.presupuesto(mes, anio);
    }
    public Integer presupuestoFecha(String fecha){
        return resumenCuadroMandoDAO.presupuestoFecha(fecha);
    }
    
    public Integer presupuestoAceptados(){
        return resumenCuadroMandoDAO.presupuestoAceptados();
    }
    public Integer presupuestoAceptados(String anio){
        return resumenCuadroMandoDAO.presupuestoAceptados(anio);
    }
    public Integer presupuestoAceptados(String mes, String anio){
        return resumenCuadroMandoDAO.presupuestoAceptados(mes, anio);
    }
    public Integer presupuestoAceptadosFecha(String fecha){
        return resumenCuadroMandoDAO.presupuestoAceptadosFecha(fecha);
    }
    public Integer presupuestoRechazados(){
        return resumenCuadroMandoDAO.presupuestoRechazados();
    }
    public Integer presupuestoRechazados(String anio){
        return resumenCuadroMandoDAO.presupuestoRechazados(anio);
    }
    public Integer presupuestoRechazados(String mes, String anio){
        return resumenCuadroMandoDAO.presupuestoRechazados(mes, anio);
    }
    public Integer presupuestoRechazadosFecha(String fecha){
        return resumenCuadroMandoDAO.presupuestoRechazadosFecha(fecha);
    }
    public Integer presupuestoPendientes(){
        return resumenCuadroMandoDAO.presupuestoPendientes();
    }
    public Integer presupuestoPendientes(String anio){
        return resumenCuadroMandoDAO.presupuestoPendientes(anio);
    }
    public Integer presupuestoPendientes(String mes, String anio){
        return resumenCuadroMandoDAO.presupuestoPendientes(mes, anio);
    }
    public Integer presupuestoPendientesFecha(String fecha){
        return resumenCuadroMandoDAO.presupuestoPendientesFecha(fecha);
    }
}
