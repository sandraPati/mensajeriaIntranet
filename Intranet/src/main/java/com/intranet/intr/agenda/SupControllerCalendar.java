/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;

import com.intranet.beans.TareaSupEmp;
import com.intranet.beans.tipo_actividades;
import com.intranet.service.ValidaInterfacesRoles;
import com.intranet.service.agenda.TareaSupEmpService;
import com.intranet.service.proveedores.TipoActividadService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sup/*")
public class SupControllerCalendar {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private TipoActividadService tipoActividadService;
    @Autowired
    private TareaSupEmpService tareaSupEmpService;
    @RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody TareaSupEmp getShopInJSON(@PathVariable String name) {

		
		return null;

	}
        
        
        List<tipo_actividades> data = new ArrayList<tipo_actividades>();

        
        @RequestMapping(value = "calendar.htm", method = RequestMethod.GET)
	public ModelAndView getPages() {
            data=tipoActividadService.all();
		ModelAndView model = new ModelAndView("calendar");
		return model;

	}

	@RequestMapping(value = "viewCalendar.htm", method = RequestMethod.GET)
	public @ResponseBody
	List<tipo_actividades> getTags(@RequestParam String tagName) {

		return simulateSearchResult(tagName);

	}
        
        private List<tipo_actividades> simulateSearchResult(String tagName) {

		List<tipo_actividades> result = new ArrayList<tipo_actividades>();

		// iterate a list and filter by tagName
		for (tipo_actividades tag : data) {
			if (tag.getNombre().contains(tagName)) {
				result.add(tag);
                                System.out.println(""+tag.getNombre());
			}
		}

		return result;
	}
        
        
        @RequestMapping(value = "calendarioSpring.htm", method = RequestMethod.GET)
	public ModelAndView MontaAgenda() {
		 List<TareaSupEmp> tareas=null;
                 List eventos = new ArrayList();
                 tareas=tareaSupEmpService.getTareas("53005868E", "70563581");
		ModelAndView mv = new ModelAndView("calendarioSpring");
		String r=validaInterfacesRoles.valida();
                for(TareaSupEmp t:tareas){
                    eventos.add(new EventosEntity(t.getId(),t.getDescripcion(),t.getFinicio(), t.getFfin(),"label-success"));
                }
                //eventos.add(new EventosEntity("Long Event","2015-11-06", "label-success"));
		//eventos.add(new EventosEntity("Long Event2","2015-11-24", "label-info"));
                mv.addObject("menu",r);
                mv.addObject("lta",eventos);
		return mv;
	}
        
        
        
        
        
        
        
        
        @RequestMapping(value = "updateEvent.htm", method = RequestMethod.POST)	
	public @ResponseBody String updateEvent(@RequestBody Object title ){
                EventosEntity e=(EventosEntity) title;
                System.out.println("HOLA update"+e.getId()+"tittle-"+e.getTitle());
		return null;
	}
        
        
        
        
        
        
        
        @RequestMapping(value = "getEventos.htm", method = RequestMethod.GET)	
	public @ResponseBody List GetEventos(){
            
            List<TareaSupEmp> tareas=null;
            System.out.println("entro a getEVENTOS ");
		List eventos = new ArrayList();
				
		String mesAtual = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+ 1);
		System.out.println("mesAtual: "+mesAtual);
		if(mesAtual.length() <2)
			mesAtual = "0" + mesAtual;
		
		String anoAtual = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println("anoActual: "+anoAtual);		
		/*ADICIONANDO OS EVENTOS*/
                /*title: 'Long Event',
			start: moment().subtract(5, 'days').format('YYYY-MM-DD'),
			end: moment().subtract(1, 'days').format('YYYY-MM-DD'),
			className: 'label-success'*/
                
                 tareas=tareaSupEmpService.getTareas("53005868E", "70563581");
                 for(TareaSupEmp t:tareas){
                     System.out.println("fecha: "+t.getFinicio());
                 }
		/*eventos.add(new EventosEntity("Estudar Linux",     anoAtual+"-"+mesAtual+"-02T12:00:00",anoAtual+"-"+mesAtual+"-02T13:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Estudar Java", 	   anoAtual+"-"+mesAtual+"-02T14:00:00",anoAtual+"-"+mesAtual+"-02T14:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Estudar C#", 	   anoAtual+"-"+mesAtual+"-02T15:00:00",anoAtual+"-"+mesAtual+"-02T15:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Estudar SOA Suite", anoAtual+"-"+mesAtual+"-02T16:00:00",anoAtual+"-"+mesAtual+"-02T17:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Estudar Jquery",    anoAtual+"-"+mesAtual+"-02T19:00:00",anoAtual+"-"+mesAtual+"-02T20:30:00", null,"label-success"));		
		eventos.add(new EventosEntity("Correr",     	   anoAtual+"-"+mesAtual+"-03T13:00:00",anoAtual+"-"+mesAtual+"-03T13:30:00",null, "label-success"));
		eventos.add(new EventosEntity("Reunião",	       anoAtual+"-"+mesAtual+"-05T12:00:00",anoAtual+"-"+mesAtual+"-05T13:30:00", null,"label-success"));		
		eventos.add(new EventosEntity("Dois dias de evento", anoAtual+"-"+mesAtual+"-07T12:00:00",anoAtual+"-"+mesAtual+"-08T12:00:00", null,"label-success"));
		
		eventos.add(new EventosEntity("Publicar Artigo",   anoAtual+"-"+mesAtual+"-10T12:00:00",anoAtual+"-"+mesAtual+"-10T13:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Reunião",	       anoAtual+"-"+mesAtual+"-10T15:00:00",anoAtual+"-"+mesAtual+"-10T18:30:00", null,"label-success"));		
		
		eventos.add(new EventosEntity("Festa",  		   anoAtual+"-"+mesAtual+"-13T12:00:00",anoAtual+"-"+mesAtual+"-13T13:30:00", null,"label-success"));
		eventos.add(new EventosEntity("Festa 2",	       anoAtual+"-"+mesAtual+"-13T15:00:00",anoAtual+"-"+mesAtual+"-13T18:30:00", null,"label-success"));		
		*/
                
                // eventos.add(new EventosEntity("Long Event","2015-11-06", "label-success"));
		//eventos.add(new EventosEntity("Long Event2","2015-11-24", "label-info"));		
                 
                 Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 111);
        map.put("title", "event1");
        map.put("start", "2011-07-28");
        map.put("url", "http://yahoo.com/");
		return eventos;
		
	}
}
