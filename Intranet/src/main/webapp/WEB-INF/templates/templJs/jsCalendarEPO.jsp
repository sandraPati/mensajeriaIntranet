<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!--[if !IE]> -->
<script type="text/javascript">
        window.jQuery || document.write("<script src='<c:url value="/resources/assets/js/jquery.js" />'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='../assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/resources/assets/js/jquery.mobile.custom.js"/>'>"+"<"+"/script>");
</script>
<script src="<c:url value="/resources/assets/js/bootstrap.js" />"></script>

<script type="text/javascript">
    $(document).ready(function(){
            var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
            
            $("#nota").hide();
            
          //ventanas
            $("#estado2").click(function() {             
                $("#nota").show();
            });
             $("#estado1").click(function() {             
                $("#nota").hide();
            });
            if($("#estado2").is(":checked")){
                $("#nota").show();
            }else if($("#estado1").is(":checked")){
                $("#nota").hide();
            }
           
        });
   $(function(){

 
 
 $("#btn_enviarU").click(function(){ 
    $.ajax({
           type: "POST",
           url: "/Intranet/emp/EajaxupdateTareaPO.htm",
           data: $("#formidU").serialize(), // Adjuntar los campos del formulario enviado.
           success: function(data)
           {
               //$("#respuesta").html(data); // Mostrar la respuestas del script PHP.
               $("#myModalU").modal('hide');
                window.location.href = data;
           }
         });

    return false; // Evitar ejecutar el submit del formulario.
 });

});

			
		</script>
<script src="/Intranet/resources/assets/js/jquery-ui.js"></script>
		<script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		
                <script src="/Intranet/resources/assets/js/date-time/moment.js"></script>
		<script src="/Intranet/resources/assets/js/fullcalendar.js"></script>
		<script src="/Intranet/resources/assets/js/bootbox.js"></script>
                <script src="/Intranet/resources/assets/js/jquery.easypiechart.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/bootstrap-datepicker.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.hotkeys.js"></script>
		<script src="/Intranet/resources/assets/js/bootstrap-wysiwyg.js"></script>
		<script src="/Intranet/resources/assets/js/select2.js"></script>
		<script src="/Intranet/resources/assets/js/fuelux/fuelux.spinner.js"></script>
		<script src="/Intranet/resources/assets/js/x-editable/bootstrap-editable.js"></script>
		<script src="/Intranet/resources/assets/js/x-editable/ace-editable.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.maskedinput.js"></script>


		<script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		<script src="/Intranet/resources/assets/js/chosen.jquery.js"></script>
		<script src="/Intranet/resources/assets/js/fuelux/fuelux.spinner.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/bootstrap-datepicker.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/bootstrap-timepicker.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/moment.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/daterangepicker.js"></script>
		<script src="/Intranet/resources/assets/js/date-time/bootstrap-datetimepicker.js"></script>
		<script src="/Intranet/resources/assets/js/bootstrap-colorpicker.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.knob.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.autosize.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.inputlimiter.1.3.1.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.maskedinput.js"></script>
		<script src="/Intranet/resources/assets/js/bootstrap-tag.js"></script>
                
                
		<script src="/Intranet/resources/assets/js/ace/elements.scroller.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.colorpicker.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.fileinput.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.typeahead.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.wysiwyg.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.spinner.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.treeview.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.wizard.js"></script>
		<script src="/Intranet/resources/assets/js/ace/elements.aside.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.ajax-content.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.touch-drag.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.sidebar.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.submenu-hover.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.widget-box.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.settings.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.settings-rtl.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.settings-skin.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.searchbox-autocomplete.js"></script>
                <!-- inline scripts related to this page -->
		<script type="text/javascript">
                    
                    $(document).ready(function() {
                        
                    });
			jQuery(function($) {

/* initialize the external events
	-----------------------------------------------------------------*/

	$('#external-events div.external-event').each(function() {

		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
		// it doesn't need to have a start or end
		var eventObject = {
			title: $.trim($(this).text()) // use the element's text as the event title
		};

		// store the Event Object in the DOM element so we can get to it later
		$(this).data('eventObject', eventObject);

		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});
		
	});




	/* initialize the calendar
	-----------------------------------------------------------------*/

	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();


	var calendar = $('#calendar').fullCalendar({
		//isRTL: true,
		 buttonHtml: {
			prev: '<i class="ace-icon fa fa-chevron-left"></i>',
			next: '<i class="ace-icon fa fa-chevron-right"></i>'
		},
	
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		events: [
                    <c:forEach var='event' items='${tareas}'>
                         { id: ${event.id},title: '${event.title}', start: '${event.start}',end: '${event.end}',className: '${event.className}'},
                     </c:forEach>
                     
                ],
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar !!!
		drop: function(date, allDay) { // this function is called when something is dropped
		
			// retrieve the dropped element's stored Event Object
			var originalEventObject = $(this).data('eventObject');
			var $extraEventClass = $(this).attr('data-class');
			
			
			// we need to copy it, so that multiple events don't have a reference to the same object
			var copiedEventObject = $.extend({}, originalEventObject);
			
			// assign it the date that was reported
			copiedEventObject.start = date;
			copiedEventObject.allDay = allDay;
			if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
			
			// render the event on the calendar
			// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
			
			// is the "remove after drop" checkbox checked?
			if ($('#drop-remove').is(':checked')) {
				// if so, remove the element from the "Draggable Events" list
				$(this).remove();
			}
			
		}
		,
		selectable: true,
		selectHelper: true,
		select: function(start, end, allDay) {
			
		}
		,
		eventClick: function(calEvent, jsEvent, view) {

			//display a modal
                        $.getJSON('/Intranet/emp/EajaxUpdateTPO.json?id='+calEvent.id,{},function(data){
                        $('#myModalU #id').val(data.id);
                         $('#myModalU #cli').val(data.cli.nif);
                          $('#myModalU #nif_empleado').val(data.nif_empleado.nif);
                          $('#myModalU #id_proyecto_presupuesto').val(data.id_proyecto_presupuesto.id);
                          $('#myModalU #cli2').text(data.cli.nif+' '+data.cli.apellidos+', '+data.cli.nombre);
                          $('#myModalU #id_proyecto_presupuesto2').text(data.id_proyecto_presupuesto.id_presupuesto.descripcion);
                          $('#myModalU #descripcion').text(data.descripcion);
                          
                        $('#myModalU #finicio').val(data.finicio);
                        $('#myModalU #ffin').val(data.ffin);
                        if(data.estado=='SI'){
                                $('#myModalU #estado1').attr("checked",true);
                                $('#myModalU #estado2').attr("checked",false);
                                $("#nota").hide();
                            }else {
                                $('#myModalU #estado1').attr("checked",false);
                                $('#myModalU #estado2').attr("checked",true);
                                $("#nota").show();
                            }
                        $('#myModalU #nota').val(data.nota);    
                            $('#myModalU').modal('show');
                        });


			//console.log(calEvent.id);
			//console.log(jsEvent);
			//console.log(view);

			// change the border color just for fun
			//$(this).css('border-color', 'red');

		}
		
	});

				
})
		</script>

		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="/Intranet/resources/docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="/Intranet/resources/assets/js/ace/elements.onpage-help.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.onpage-help.js"></script>
		<script src="/Intranet/resources/docs/assets/js/rainbow.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/generic.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/html.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/css.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/javascript.js"></script>


