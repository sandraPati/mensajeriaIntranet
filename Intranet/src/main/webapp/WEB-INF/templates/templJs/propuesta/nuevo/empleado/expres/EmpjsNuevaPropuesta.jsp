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
            
           
            $('#btnsubmit').click(function () {
                if($("#tipo1").is(":checked")){
                    if($('#form-field-select-3').val()!=''){
                     window.location.replace("/Intranet/emp/ENuevaPropuestaExpresAdd.htm?cli="+$('#form-field-select-3').val());
                    }
                }
            });
        
         
            $("#tipo1").click(function() { 
                $("#formC").hide();
                if($('#form-field-select-3').val()!=''){
                    $('#btnsubmit').attr('disabled', false);
                }else{
                    $('#btnsubmit').attr('disabled', true);
                }
            });
            $("#tipo2").click(function() { 
                $("#formC").show(); 
                $('#btnsubmit').attr('disabled', false);
            });
        
        
    });
    
    jQuery(function($) {
                            $('#form-field-select-3').on('change',function(e) {                            
                                if($('#form-field-select-3').val()!=''){
                                    
                                    $('#btnsubmit').attr('disabled', false);
                                }else{
                                    if($("#tipo2").is(":checked")){
                                        $('#btnsubmit').attr('disabled', false);
                                    }else $('#btnsubmit').attr('disabled', true);
                                }
                            });
                            if($("#tipo1").is(":checked")){
                                $("#formC").hide();
                                if($('#form-field-select-3').val()!=''){
                                    $('#btnsubmit').attr('disabled', false);
                                }else{
                                    $('#btnsubmit').attr('disabled', true);
                                }
                            }
                            if($("#tipo2").is(":checked")){
                                $("#formC").show(); 
                                $('#btnsubmit').attr('disabled', false);
                            }
                           
			});
                        
      $("#form1").submit(function(event){
          
            var obj={nif:$("#nif").val(),nombre:$("#nombre").val(),apellidos:$("#apellidos").val(),direccion:$("#direccion").val(),
                    pais:$("#pais").val(),provincia:$("#provincia").val(),poblacion:$("#poblacion").val(),nacionalidad:$("#nacionalidad").val(),
                    codigo_postal:$("#codigo_postal").val(),telefono:$("#telefono").val(),otro_telefono:$("#otro_telefono").val(),email:$("#email").val()};
                  
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/emp/EjsonAddClientePasoPropuesta.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#tipoc").attr('disabled', 'false');
                          window.location.replace("/Intranet/emp/ENuevaPropuestaExpresAdd.htm?cli="+$("#nif").val());
                         
                                                
                        }
                    });
                    return false;
        });                  
    </script>

    <script src="<c:url value="/resources/assets/js/jquery-ui.custom.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.ui.touch-punch.js" />"></script>
		<script src="<c:url value="/resources/assets/js/chosen.jquery.js" />"></script>
		<script src="<c:url value="/resources/assets/js/fuelux/fuelux.spinner.js" />"></script>
		<script src="<c:url value="/resources/assets/js/date-time/bootstrap-datepicker.js" />"></script>
		<script src="<c:url value="/resources/assets/js/date-time/bootstrap-timepicker.js" />"></script>
		<script src="<c:url value="/resources/assets/js/date-time/moment.js" />"></script>
		<script src="<c:url value="/resources/assets/js/date-time/daterangepicker.js" />"></script>
		<script src="<c:url value="/resources/assets/js/date-time/bootstrap-datetimepicker.js" />"></script>
		<script src="<c:url value="/resources/assets/js/bootstrap-colorpicker.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.knob.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.autosize.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.inputlimiter.1.3.1.js" />"></script>
		<script src="<c:url value="/resources/assets/js/jquery.maskedinput.js" />"></script>
		<script src="<c:url value="/resources/assets/js/bootstrap-tag.js" />"></script>

    
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
                                    
			
				if(!ace.vars['touch']) {
					$('.chosen-select').chosen({allow_single_deselect:true}); 
					//resize the chosen on window resize
			
					$(window)
					.off('resize.chosen')
					.on('resize.chosen', function() {
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					}).trigger('resize.chosen');
					//resize chosen on sidebar collapse/expand
					$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
						if(event_name != 'sidebar_collapsed') return;
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					});
			
			
					$('#chosen-multiple-style .btn').on('click', function(e){
						var target = $(this).find('input[type=radio]');
						var which = parseInt(target.val());
						if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
						 else $('#form-field-select-4').removeClass('tag-input-style');
					});
				}
			
			
			});
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


