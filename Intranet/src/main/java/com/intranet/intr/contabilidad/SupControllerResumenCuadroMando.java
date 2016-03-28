/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.contabilidad;

import com.intranet.beans.contrato;
import com.intranet.beans.cuadromando;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.contabilidad.ResumenCuadroMandoService;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sup/*")
public class SupControllerResumenCuadroMando {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private ResumenCuadroMandoService resumenCuadroMandoService;
    
    @RequestMapping(value = "Resumen.htm",method=RequestMethod.GET)
    public String Resumen(ModelMap mav) {
        Double ingresos=0.0;
        Double gastos=0.0;
        Double beneficio=0.0;
        try{
            ingresos=resumenCuadroMandoService.TotalIngresos();
            gastos=resumenCuadroMandoService.TotalGastos();
            beneficio=resumenCuadroMandoService.TotalBeneficio();
        }catch(Exception ex){}
        
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("ingresos",ingresos);
        mav.addAttribute("gastos",gastos);
        mav.addAttribute("beneficio",beneficio);
        
        return "Resumen";
    }
    
    @RequestMapping(value = "CuadroMando.htm",method=RequestMethod.GET)
    public String CuadroMando(ModelMap mav) {
        Double ingresosP=0.0;
        Double ingresosI=0.0;
        Double gastosP=0.0;
        Double gastosI=0.0;
        Double beneficioP=0.0;
        Double beneficioI=0.0;
        Double clienteF=0.0;
        Integer numvisitas=0;
        Integer presupuestoEnviado=0;
        Integer presupuestoAceptados=0;
        Integer presupuestoRechazados=0;
        Integer presupuestoPendientes=0;
        cuadromando cm=new cuadromando();
   try{
            ingresosP=resumenCuadroMandoService.TotalIngresosP();
            ingresosI=resumenCuadroMandoService.TotalIngresosI();
            gastosP=resumenCuadroMandoService.TotalGastosP();
            gastosI=resumenCuadroMandoService.TotalGastosI();
            beneficioP=resumenCuadroMandoService.TotalBeneficioP();
            beneficioI=resumenCuadroMandoService.TotalBeneficioI();
            clienteF=resumenCuadroMandoService.clienteF();
            numvisitas=resumenCuadroMandoService.visitas();
            presupuestoEnviado=resumenCuadroMandoService.presupuesto();
            presupuestoAceptados=resumenCuadroMandoService.presupuestoAceptados();
            presupuestoRechazados=resumenCuadroMandoService.presupuestoRechazados();
            presupuestoPendientes=resumenCuadroMandoService.presupuestoPendientes();
            System.out.println("ingresosP:"+ingresosP+"ingresosI"+ingresosI+"gastosP"+gastosP+
                    "gastosI"+gastosI+"beneficioP"+beneficioP+"beneficioI"+beneficioI+"clienteF"+clienteF+
                    "numvisitas"+numvisitas+"presupuestoEnviado"+presupuestoEnviado+"presupuestoAceptados"+
                    presupuestoAceptados+"presupuestoRechazados"+presupuestoRechazados);
            cm.setIngresosP(ingresosP);
            cm.setIngresosI(ingresosI);
            cm.setGastosP(gastosP);
            cm.setGastosI(gastosI);
            cm.setBeneficioP(beneficioP);
            cm.setBeneficioI(beneficioI);
            cm.setClienteF(clienteF);
            cm.setNumvisitas(numvisitas);
            cm.setPresupuestoEnviado(presupuestoEnviado);
            cm.setPresupuestoAceptados(presupuestoAceptados);
            cm.setPresupuestoRechazados(presupuestoRechazados);
            cm.setPresupuestoPendientes(presupuestoPendientes);
            /*formato="MM";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));*/
   }catch(Exception ex){}
        String r=validaInterfacesRoles.valida();
        mav.addAttribute("menu",r);
        mav.addAttribute("cm",cm);
        
        return "CuadroMando";
    }
    
    @RequestMapping(value ="/CuadroMandoDia.json",method=RequestMethod.POST)
    public @ResponseBody cuadromando CuadroMandoDia(@RequestBody contrato pre ) throws ParseException{
        Double ingresosP=0.0;
        Double ingresosI=0.0;
        Double gastosP=0.0;
        Double gastosI=0.0;
        Double beneficioP=0.0;
        Double beneficioI=0.0;
        Double clienteF=0.0;
        Integer numvisitas=0;
        Integer presupuestoEnviado=0;
        Integer presupuestoAceptados=0;
        Integer presupuestoRechazados=0;
        Integer presupuestoPendientes=0;
        cuadromando data=new cuadromando();
        
           System.out.println("fecha:0"+pre.getFequito());
         String dateReceivedFromUser = "2016-02-23";
         System.out.println("fecha:0"+dateReceivedFromUser);
         String r=pre.getFequito();
         System.out.println("fecha:0"+r);
DateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");
DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-mm-dd");
Date date2 = (Date) dateFormatNeeded.parse(r);
//String convertedDate = dateFormatNeeded.format(dateReceivedFromUser);
System.out.println(date2);    
System.out.println(dateFormatNeeded.format(date2));
    try{


       
               
            ingresosP=resumenCuadroMandoService.TotalIngresosPFecha(pre.getFequito());
            ingresosI=resumenCuadroMandoService.TotalIngresosIFecha(pre.getFequito());
            gastosP=resumenCuadroMandoService.TotalGastosPFecha(pre.getFequito());
            gastosI=resumenCuadroMandoService.TotalGastosIFecha(pre.getFequito());
            beneficioP=resumenCuadroMandoService.TotalBeneficioPFecha(pre.getFequito());
            beneficioI=resumenCuadroMandoService.TotalBeneficioIFecha(pre.getFequito());
            clienteF=resumenCuadroMandoService.clienteFFecha(pre.getFequito());
            numvisitas=resumenCuadroMandoService.visitasFecha(pre.getFequito());
            presupuestoEnviado=resumenCuadroMandoService.presupuestoFecha(pre.getFequito());
            presupuestoAceptados=resumenCuadroMandoService.presupuestoAceptadosFecha(pre.getFequito());
            presupuestoRechazados=resumenCuadroMandoService.presupuestoRechazadosFecha(pre.getFequito());
            presupuestoPendientes=resumenCuadroMandoService.presupuestoPendientesFecha(pre.getFequito());
            System.out.println("ingresosP:"+ingresosP+"ingresosI"+ingresosI+"gastosP"+gastosP+
                    "gastosI"+gastosI+"beneficioP"+beneficioP+"beneficioI"+beneficioI+"clienteF"+clienteF+
                    "numvisitas"+numvisitas+"presupuestoEnviado"+presupuestoEnviado+"presupuestoAceptados"+
                    presupuestoAceptados+"presupuestoRechazados"+presupuestoRechazados);
            
            data.setIngresosP(ingresosP);
            data.setIngresosI(ingresosI);
            data.setGastosP(gastosP);
            data.setGastosI(gastosI);
            data.setBeneficioP(beneficioP);
            data.setBeneficioI(beneficioI);
            data.setClienteF(clienteF);
            data.setNumvisitas(numvisitas);
            data.setPresupuestoEnviado(presupuestoEnviado);
            data.setPresupuestoAceptados(presupuestoAceptados);
            data.setPresupuestoRechazados(presupuestoRechazados);
            data.setPresupuestoPendientes(presupuestoPendientes);
            }catch(Exception ex){}
        return data;
    }
    /*
    @RequestMapping(value = "/CuadroMandoDia.json",method=RequestMethod.POST)
    public @ResponseBody cuadromando CuadroMandoDia(ModelMap mav,@RequestBody String fecha) throws ParseException {
        String fec="";
        Double ingresosP=0.0;
        Double ingresosI=0.0;
        Double gastosP=0.0;
        Double gastosI=0.0;
        Double beneficioP=0.0;
        Double beneficioI=0.0;
        Double clienteF=0.0;
        Integer numvisitas=0;
        Integer presupuestoEnviado=0;
        Integer presupuestoAceptados=0;
        Integer presupuestoRechazados=0;
        cuadromando data=new cuadromando();
        
            System.out.println("fecha:0"+fecha);
         String dateReceivedFromUser = ""+fecha;
         System.out.println("fecha:0"+dateReceivedFromUser);
         String r=fecha.toString();
         System.out.println("fecha:0"+r);
DateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");
DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-mm-dd");
Date date2 = (Date) dateFormatNeeded.parse(dateReceivedFromUser);
//String convertedDate = dateFormatNeeded.format(dateReceivedFromUser);
    System.out.println(dateFormatNeeded.format(date2));
    
   
            try{
               
            ingresosP=resumenCuadroMandoService.TotalIngresosP(fecha);
            ingresosI=resumenCuadroMandoService.TotalIngresosI(fecha);
            gastosP=resumenCuadroMandoService.TotalGastosP(fecha);
            gastosI=resumenCuadroMandoService.TotalGastosI(fecha);
            beneficioP=resumenCuadroMandoService.TotalBeneficioP(fecha);
            beneficioI=resumenCuadroMandoService.TotalBeneficioI(fecha);
            clienteF=resumenCuadroMandoService.clienteF(fecha);
            numvisitas=resumenCuadroMandoService.visitas(fecha);
            presupuestoEnviado=resumenCuadroMandoService.presupuesto(fecha);
            presupuestoAceptados=resumenCuadroMandoService.presupuestoAceptados(fecha);
            presupuestoRechazados=resumenCuadroMandoService.presupuestoRechazados(fecha);
            System.out.println(numvisitas);
            }catch(Exception ex){}
            data.setIngresosP(ingresosP);
            data.setIngresosI(ingresosI);
            data.setGastosP(gastosP);
            data.setGastosI(gastosI);
            data.setBeneficioP(beneficioP);
            data.setBeneficioI(beneficioI);
            data.setClienteF(clienteF);
            data.setNumvisitas(numvisitas);
            data.setPresupuestoEnviado(presupuestoEnviado);
            data.setPresupuestoAceptados(presupuestoAceptados);
            data.setPresupuestoRechazados(presupuestoRechazados);
        return data;
    }*/
    @RequestMapping(value = "/CuadroMandoMes.json",method=RequestMethod.POST)
    public @ResponseBody cuadromando CuadroMandoMes(ModelMap mav,@RequestBody Date fecha) {
        String fec="";
        Double ingresosP=0.0;
        Double ingresosI=0.0;
        Double gastosP=0.0;
        Double gastosI=0.0;
        Double beneficioP=0.0;
        Double beneficioI=0.0;
        Double clienteF=0.0;
        Integer numvisitas=0;
        Integer presupuestoEnviado=0;
        Integer presupuestoAceptados=0;
        Integer presupuestoRechazados=0;
        Integer presupuestoPendientes=0;
        cuadromando data=new cuadromando();
        try{
            
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
            String anio=formateador.format(fecha);
            formateador = new SimpleDateFormat("MM");
            String mes=formateador.format(fecha);
            fec=""+anio+"--"+mes+"--";
            System.out.println(fec);
           
            ingresosP=resumenCuadroMandoService.TotalIngresosP(mes,anio);
            System.out.println(ingresosP);
            ingresosI=resumenCuadroMandoService.TotalIngresosI(mes,anio);
            System.out.println(ingresosI);
            gastosP=resumenCuadroMandoService.TotalGastosP(mes,anio);
            System.out.println(gastosP);
            gastosI=resumenCuadroMandoService.TotalGastosI(mes,anio);
            System.out.println(gastosI);
            beneficioP=resumenCuadroMandoService.TotalBeneficioP(mes,anio);
            System.out.println(beneficioP);
            beneficioI=resumenCuadroMandoService.TotalBeneficioI(mes,anio);
            System.out.println(beneficioI);
            clienteF=resumenCuadroMandoService.clienteF(mes,anio);
            System.out.println("client:"+clienteF);
            numvisitas=resumenCuadroMandoService.visitas(mes,anio);
            System.out.println("en año:"+numvisitas);
            presupuestoEnviado=resumenCuadroMandoService.presupuesto(mes,anio);
            presupuestoAceptados=resumenCuadroMandoService.presupuestoAceptados(mes,anio);
            presupuestoRechazados=resumenCuadroMandoService.presupuestoRechazados(mes,anio);
            presupuestoPendientes=resumenCuadroMandoService.presupuestoPendientes(mes,anio);
            System.out.println("ingresosP:"+ingresosP+"ingresosI"+ingresosI+"gastosP"+gastosP+
                    "gastosI"+gastosI+"beneficioP"+beneficioP+"beneficioI"+beneficioI+"clienteF"+clienteF+
                    "numvisitas"+numvisitas+"presupuestoEnviado"+presupuestoEnviado+"presupuestoAceptados"+
                    presupuestoAceptados+"presupuestoRechazados"+presupuestoRechazados);
            
            data.setIngresosP(ingresosP);
            data.setIngresosI(ingresosI);
            data.setGastosP(gastosP);
            data.setGastosI(gastosI);
            data.setBeneficioP(beneficioP);
            data.setBeneficioI(beneficioI);
            data.setClienteF(clienteF);
            data.setNumvisitas(numvisitas);
            data.setPresupuestoEnviado(presupuestoEnviado);
            data.setPresupuestoAceptados(presupuestoAceptados);
            data.setPresupuestoRechazados(presupuestoRechazados);
            data.setPresupuestoPendientes(presupuestoPendientes);
       }catch(Exception ex){}
        return data;
    }
    @RequestMapping(value = "/CuadroMandoAnio.json",method=RequestMethod.POST)
    public @ResponseBody cuadromando CuadroMandoAnio(ModelMap mav,@RequestBody Date fecha) {
        String fec="";
        Double ingresosP=0.0;
        Double ingresosI=0.0;
        Double gastosP=0.0;
        Double gastosI=0.0;
        Double beneficioP=0.0;
        Double beneficioI=0.0;
        Double clienteF=0.0;
        Integer numvisitas=0;
        Integer presupuestoEnviado=0;
        Integer presupuestoAceptados=0;
        Integer presupuestoRechazados=0;
        Integer presupuestoPendientes=0;
        cuadromando data=new cuadromando();
        
            
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
            String anio=formateador.format(fecha);
            fec=""+anio+"--";
        try{ 
            ingresosP=resumenCuadroMandoService.TotalIngresosP(anio);
            System.out.println(ingresosP);
            ingresosI=resumenCuadroMandoService.TotalIngresosI(anio);
            System.out.println(ingresosI);
            gastosP=resumenCuadroMandoService.TotalGastosP(anio);
            System.out.println(gastosP);
            gastosI=resumenCuadroMandoService.TotalGastosI(anio);
            System.out.println(gastosI);
            beneficioP=resumenCuadroMandoService.TotalBeneficioP(anio);
            System.out.println(beneficioP);
            beneficioI=resumenCuadroMandoService.TotalBeneficioI(anio);
            System.out.println(beneficioI);
            clienteF=resumenCuadroMandoService.clienteF(anio);
            System.out.println("client:"+clienteF);
            numvisitas=resumenCuadroMandoService.visitas(anio);
            System.out.println("en año:"+numvisitas);
            presupuestoEnviado=resumenCuadroMandoService.presupuesto(anio);
            presupuestoAceptados=resumenCuadroMandoService.presupuestoAceptados(anio);
            presupuestoRechazados=resumenCuadroMandoService.presupuestoRechazados(anio);
            presupuestoPendientes=resumenCuadroMandoService.presupuestoPendientes(anio);
            data.setIngresosP(ingresosP);
            data.setIngresosI(ingresosI);
            data.setGastosP(gastosP);
            data.setGastosI(gastosI);
            data.setBeneficioP(beneficioP);
            data.setBeneficioI(beneficioI);
            data.setClienteF(clienteF);
            data.setNumvisitas(numvisitas);
            data.setPresupuestoEnviado(presupuestoEnviado);
            data.setPresupuestoAceptados(presupuestoAceptados);
            data.setPresupuestoRechazados(presupuestoRechazados);
            data.setPresupuestoPendientes(presupuestoPendientes);
        }catch(Exception ex){}
        return data;
    }
}
