/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import java.sql.Date;


public interface ResumenCuadroMandoDAO {
    public Double TotalIngresos();
    public Double TotalGastos();
    public Double TotalBeneficio();
    
    public Double TotalIngresosP();
    public Double TotalIngresosP(String anio);
    public Double TotalIngresosP(String mes, String anio);
    public Double TotalIngresosPFecha(String fecha);
    
    
    public Double TotalGastosP();
    public Double TotalGastosP(String anio);
    public Double TotalGastosP(String mes, String anio);
    public Double TotalGastosPFecha(String fecha);
    
    public Double TotalBeneficioP(String anio);
    public Double TotalBeneficioP();
    public Double TotalBeneficioP(String mes, String anio);
    public Double TotalBeneficioPFecha(String fecha);
    
     public Double TotalIngresosI();
     public Double TotalIngresosI(String anio);
    public Double TotalIngresosI(String mes, String anio);
    public Double TotalIngresosIFecha(String fecha);
    
    public Double TotalGastosI();
    public Double TotalGastosI(String anio);
    public Double TotalGastosI(String mes, String anio);
    public Double TotalGastosIFecha(String fecha);
    
    public Double TotalBeneficioI();
    public Double TotalBeneficioI(String anio);
    public Double TotalBeneficioI(String mes, String anio);
    public Double TotalBeneficioIFecha(String fecha);
    
    public Double clienteF();
    public Double clienteF(String anio);
    public Double clienteF(String mes, String anio);
    public Double clienteFFecha(String fecha);
    
    public Integer visitasFecha(String fecha);
    public Integer visitas(String anio);
    public Integer visitas(String mes, String anio);
    public Integer visitas();
    
    public Integer presupuesto();
    public Integer presupuesto(String anio);
    public Integer presupuesto(String mes, String anio);
    public Integer presupuestoFecha(String fecha);
    
    public Integer presupuestoAceptados();
    public Integer presupuestoAceptados(String anio);
    public Integer presupuestoAceptados(String mes, String anio);
    public Integer presupuestoAceptadosFecha(String fecha);
    
    public Integer presupuestoRechazados();
    public Integer presupuestoRechazados(String anio);
    public Integer presupuestoRechazados(String mes, String anio);
    public Integer presupuestoRechazadosFecha(String fecha);
    
    
    public Integer presupuestoPendientes();
    public Integer presupuestoPendientes(String anio);
    public Integer presupuestoPendientes(String mes, String anio);
    public Integer presupuestoPendientesFecha(String fecha);
}
