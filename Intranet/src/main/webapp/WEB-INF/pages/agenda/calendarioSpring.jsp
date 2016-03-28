<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:settings.box -->
<link rel="stylesheet" href="/Intranet/resources/assets/css/fullcalendar.css" />

<div class="page-header">
        <h1>
                Full Calendar
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        with draggable and editable events
                </small>
        </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                    <div class="col-sm-9">
                            <div class="space"></div>

                            <!-- #section:plugins/data-time.calendar -->
                            <div id="calendar"></div>

                            <!-- /section:plugins/data-time.calendar -->
                    </div>

                    <div class="col-sm-3">
                            <div class="widget-box transparent">
                                    <div class="widget-header">
                                            <h4>Draggable events</h4>
                                    </div>

                                    <div class="widget-body">
                                            <div class="widget-main no-padding">
                                                    <div id="external-events">
                                                            <div class="external-event label-grey" data-class="label-grey">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 1
                                                            </div>

                                                            <div class="external-event label-success" data-class="label-success">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 2
                                                            </div>

                                                            <div class="external-event label-danger" data-class="label-danger">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 3
                                                            </div>

                                                            <div class="external-event label-purple" data-class="label-purple">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 4
                                                            </div>

                                                            <div class="external-event label-yellow" data-class="label-yellow">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 5
                                                            </div>

                                                            <div class="external-event label-pink" data-class="label-pink">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 6
                                                            </div>

                                                            <div class="external-event label-info" data-class="label-info">
                                                                    <i class="ace-icon fa fa-arrows"></i>
                                                                    My Event 7
                                                            </div>

                                                            <label>
                                                                    <input type="checkbox" class="ace ace-checkbox" id="drop-remove" />
                                                                    <span class="lbl"> Remove after drop</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                    </div>
            </div>

            <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->



                            
					</div><!-- /.row -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">decora</span>
							Kia &copy; 2015-2016
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/Intranet/resources/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='/Intranet/resources/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script src="/Intranet/resources/assets/js/bootstrap.js"></script>




		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="../assets/js/excanvas.js"></script>
		<![endif]-->
                <script src="/Intranet/resources/assets/js/jquery-ui.js"></script>
		<script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		
                <script src="/Intranet/resources/assets/js/date-time/moment.js"></script>
		<script src="/Intranet/resources/assets/js/fullcalendar.js"></script>
		<script src="/Intranet/resources/assets/js/bootbox.js"></script>
                
                
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
                    <c:forEach var='event' items='${lta}'>
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
			
			bootbox.prompt("New Event Title:", function(title) {
				if (title !== null) {
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay,
							className: 'label-info'
						},
						true // make the event "stick"
					);
				}
			});
			

			calendar.fullCalendar('unselect');
		}
		,
		eventClick: function(calEvent, jsEvent, view) {

			//display a modal
			var modal = 
			'<div class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				 <div class="modal-body">\
				   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
				   <form class="no-margin">\
					  <label>Change event name &nbsp;</label>\\n\
                                          <input class="middle" autocomplete="off" type="text" value="' + calEvent.id + '" readonly="true"/>\
					  <input class="middle" autocomplete="off" type="text" value="' + calEvent.title + '" />\
					 <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Save</button>\
				   </form>\
				 </div>\
				 <div class="modal-footer">\
					<button type="button" class="btn btn-sm btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> Delete Event</button>\
					<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
				 </div>\
			  </div>\
			 </div>\
			</div>';
		
		
			var modal = $(modal).appendTo('body');
			modal.find('form').on('submit', function(ev){
				ev.preventDefault();

				calEvent.title = $(this).find("input[type=text]").val();
                                $.ajax({
                                    url: "/Intranet/sup/updateEvent.htm",
                                    type: "POST",
                                    
                                    data: calEvent,
                                    dataType: "json",
                                    contentType: "application/json",
                                        success: function(){
                                              //$("#thanks").html(msg)
                                           // modal.modal("hide");
                                            alert("plo");
                                        },
                                    error: function(){alert("Erreur lors de l'update");}
                                });
				calendar.fullCalendar('updateEvent');
				modal.modal("hide");
			});
			modal.find('button[data-action=delete]').on('click', function() {
				calendar.fullCalendar('removeEvents' , function(ev){
					return (ev._id == calEvent._id);
				})
				modal.modal("hide");
			});
			
			modal.modal('show').on('hidden', function(){
				modal.remove();
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