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


                <script src="/Intranet/resources/assets/js/jquery.colorbox.js"></script>
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
        
    });
			jQuery(function($) {
				
				$('#fotografia').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'ace-icon fa fa-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
				
				
			});
		</script>

                <!-- CALENDARIO -->
		<script src="/Intranet/resources/assets/js/jquery-ui.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>



		<script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.gritter.js"></script>
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



<!-- ace scripts -->
<script src="<c:url value="/resources/assets/js/ace/elements.scroller.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.colorpicker.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.fileinput.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.typeahead.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.wysiwyg.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.spinner.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.treeview.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.wizard.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/elements.aside.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.ajax-content.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.touch-drag.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.sidebar.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.sidebar-scroll-1.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.submenu-hover.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.widget-box.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings-rtl.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.settings-skin.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.widget-on-reload.js" />"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.searchbox-autocomplete.js" />"></script>
<script type="text/javascript">
			jQuery(function($) {
	var $overflow = '';
	var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'50%',
		maxHeight:'50%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};

	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
	
	
	$(document).one('ajaxloadstart.page', function(e) {
		$('#colorbox, #cboxOverlay').remove();
   });
})
		</script>
<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="<c:url value="/resources/assets/css/ace.onpage-help.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/docs/assets/js/themes/sunburst.css"/>" />

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="<c:url value="/resources/assets/js/ace/elements.onpage-help.js"/>"></script>
<script src="<c:url value="/resources/assets/js/ace/ace.onpage-help.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/rainbow.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/generic.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/html.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/css.js"/>"></script>
<script src="<c:url value="/resources/docs/assets/js/language/javascript.js"/>"></script>


