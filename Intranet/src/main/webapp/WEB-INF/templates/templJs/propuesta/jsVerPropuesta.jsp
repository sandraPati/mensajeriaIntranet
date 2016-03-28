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
        checkbox_change();
        descuento_click();
        var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
      
    });
    var chk;
    function checkbox_change() {
            $('.chk').change(function () {
 
                //Control checkbox
                chk = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = chk.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
               
                //Si esta activo el checkbox
                if (chk.is(':checked')) {
                   var propuesta_id=chk.val();
                   
                    $('#myModal #propuesta_id').val(chk.val());    
                    $('#myModal').modal('show');
                    chk.attr("checked",false);
                }else{
                    var obj={propuesta_id:chk.val()};
                    $.ajax({
                       type:'POST',
                       contentType:'application/json',
                       url: "/Intranet/sup/DeletePlantilla.htm",
                       data:JSON.stringify(obj), // Adjuntar los campos del formulario enviado.
                       success: function(data)
                       {
                           
                            window.location.href = data;
                       }
                     });
                    
                } 
            });
        }
        function descuento_click() {
            $('.descuento').on("click",function () {
 
                //Control checkbox
                chk = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = chk.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
               
                //Si esta activo el checkbox
                //if (chk.is(':checked')) {
               
                   var propuesta_id=chk.val();
                   $.getJSON('/Intranet/sup/jsonDescuentoPropuesta.json?idP='+propuesta_id,{},function(data){
                   
                        $('#myModalDescuento #propuesta_idD').val(data.id);
                        $('#myModalDescuento #descuentop').val(data.descuentoproveedor);
                        $('#myModalDescuento').modal('show');
                   });
                       
                    
                    
                //}
            });
        }
        
        $(function(){

        $("#btn_enviar").click(function(){
            if($('#form1').valid()==true){
                var obj={propuesta_id:$("#propuesta_id").val(),descripcion:$("#descripcion").val()};
               $.ajax({
                  type:'POST',
                  contentType:'application/json',
                  url: "/Intranet/sup/CrearPlantilla.htm",
                  data:JSON.stringify(obj), // Adjuntar los campos del formulario enviado.
                  success: function(data)
                  {
                      //$("#respuesta").html(data); // Mostrar la respuestas del script PHP.
                      $("#myModal").modal('hide');
                       window.location.href = data;
                  }
                });
            }else{ 
                $("#descripcion").focus();
            }
           return false; // Evitar ejecutar el submit del formulario.
        });
        
         $("#btn_enviarD").click(function(){
            if($('#formD').valid()==true){
                var obj={id:$("#propuesta_idD").val(),descuentoproveedor:$("#descuentop").val()};
               
               $.ajax({
                  type:'POST',
                  contentType:'application/json',
                  url: "/Intranet/sup/Descuento.htm",
                  data:JSON.stringify(obj), // Adjuntar los campos del formulario enviado.
                  success: function(data)
                  {
                      //$("#respuesta").html(data); // Mostrar la respuestas del script PHP.
                   
                    $("#myModalDescuento").modal('hide');
                    window.location.href = "/Intranet/sup/verPropuestas.htm?nifC=${cliente.nif}";
                       //window.location.href = data;
                  }
                });
            }else{ 
                $("#descuento").focus();
            }
           return false; // Evitar ejecutar el submit del formulario.
        });
        
        $("#btn_cancel").click(function(){
            $("#myModal").modal('hide');
                      chk.attr("checked",false);
                     
        });
         
        
    });
		</script>


                <script src="/Intranet/resources/assets/js/fuelux/fuelux.wizard.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.validate.js"></script>
		<script src="/Intranet/resources/assets/js/additional-methods.js"></script>
		<script src="/Intranet/resources/assets/js/bootbox.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.maskedinput.js"></script>
		<script src="/Intranet/resources/assets/js/select2.js"></script>

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
			
				var $validation = true;
				
			
				//jump to a step
				/**
				var wizard = $('#fuelux-wizard-container').data('fu.wizard')
				wizard.currentStep = 3;
				wizard.setState();
				*/
			
				//determine selected step
				//wizard.selectedItem().step
			
				$('#form1').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					ignore: "",
					rules: {
						
						descripcion: {
							required: true
						}
					},
			
					messages: {
						descripcion: {
							required: "Se requiere una Descripcion de Plantilla"
						}
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
							var controls = element.closest('div[class*="col-"]');
							if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
							else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
						}
						else if(element.is('.select2')) {
							error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
						}
						else if(element.is('.chosen-select')) {
							error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
						}
						else error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
			
				
				
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


