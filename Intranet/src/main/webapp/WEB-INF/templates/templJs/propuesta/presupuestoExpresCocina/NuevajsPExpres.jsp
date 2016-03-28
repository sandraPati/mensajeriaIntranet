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
        alto_change();
        checkbox_change();
        var json1 =  null ; 
            $.ajax({
                url : '/Intranet/ajaxtestFoto.htm',
                success : function(data) {
                    json1 = "<img id='imagenUser'class='nav-user-photo' src='"+data+"' alt='' />"; 
                    $('#resultFoto').html(json1);
                }
            });
          
            
            $("#ducha").click(function() {      
                if ($("#ducha").is(':checked')) {
                    $("#radioducha").show();
                }else $("#radioducha").hide();
            });
            if ($("#ducha").is(':checked')) {
                    $("#radioducha").show();
                }
    });
    
    $(function(){

        $("#btn_enviar").click(function(){
            if($('#form1').valid()==true){
                var ambiarft=0;
                 if($("#cambiarfalsotecho1").is(":checked")){
                    ambiarft=1;
                }else if($("#cambiarfalsotecho2").is(":checked")){
                    ambiarft=0;
                }
                var tipopano=0;
                 if($("#panotipo1").is(":checked")){
                    tipopano=1;
                }else if($("#panotipo2").is(":checked")){
                    tipopano=2;
                }
                
                var puertatipo=0;
                 if($("#puertatipo1").is(":checked")){
                    puertatipo=0;
                }else if($("#puertatipo2").is(":checked")){
                    puertatipo=1;
                }
                
                var ducha=0;
                 if($("#ducha").is(":checked")){
                    ducha=1;
                }
                var inodoro=0;
                 if($("#inodoro").is(":checked")){
                    inodoro=1;
                }
                var lavabo=0;
                 if($("#lavabo").is(":checked")){
                    lavabo=1;
                }
                var bide=0;
                 if($("#bide").is(":checked")){
                    bide=1;
                }
                
                 var duchatipo=0;
                 if($("#duchatipo1").is(":checked")){
                    duchatipo=1;
                }else if($("#duchatipo2").is(":checked")){
                    duchatipo=2;
                }else if($("#duchatipo3").is(":checked")){
                    duchatipo=3;
                }
                 var llavecorte=0;
                 if($("#llavecorte1").is(":checked")){
                    llavecorte=1;
                }else if($("#llavecorte2").is(":checked")){
                    llavecorte=0;
                }
                 var eliminar=0;
                 if($("#eliminar1").is(":checked")){
                    eliminar=1;
                }else if($("#eliminar2").is(":checked")){
                    eliminar=0;
                }
                var radiadortipo=0;
                 if($("#radiadortipo1").is(":checked")){
                    radiadortipo=1;
                }else if($("#radiadortipo2").is(":checked")){
                    radiadortipo=2;
                }
                
                 var igg=0;
                 if($("#igg1").is(":checked")){
                    igg=1;
                }else if($("#igg2").is(":checked")){
                    igg=0;
                }
                
                var obj={id:$("#id").val(),idpropuesta:$("#idpropuesta").val(),idestancia:$("#idestancia").val(),panosuelo:$("#panosuelo").val(),
                cambiarfalsotecho:ambiarft,falsotechopano:$("#falsotechopano").val(),nventana:$("#nventana").val(),
                puerta:$("#puerta").val(),puertatipo:puertatipo,puntosluz:$("#puntosluz").val(),puntosenchufe:$("#puntosenchufe").val(),
                nradiador:$("#nradiador").val(),radiadortipo:radiadortipo,fontaneriapuntos:$("#fontaneriapuntos").val(),
                ducha:ducha,duchatipo:duchatipo,inodoro:inodoro,lavabo:lavabo,bide:bide,
                eliminar:eliminar,eliminarcual:$("#eliminarcual").val(),llavecorte:llavecorte,demolermuro:$("#demolermuro").val(),
                falsotechonuevo:$("#falsotechonuevo").val(),panotipo:tipopano,mobe:$("#mobe").val(),mobn:$("#mobn").val(),puntospvh:$("#puntospvh").val(),
            puntosptv:$("#puntosptv").val(),puntosptt:$("#puntosptt").val(),igg:igg};
          
               $.ajax({
                  type:'POST',
                  contentType:'application/json',
                  url: "/Intranet/sup/PExpresaddCocina.htm",
                  data:JSON.stringify(obj), // Adjuntar los campos del formulario enviado.
                  success: function(data)
                  {
                      window.location.replace("/Intranet/sup/NuevaPropuestaExpresPresupuestoC.htm?idP="+$("#idpropuesta").val());
                  }
                });
            }else{ 
                
            }
           return false; // Evitar ejecutar el submit del formulario.
        });
    });
    
    function checkbox_change() {
            $('.chk').change(function () {
 
                //Control checkbox
                var chk = $(this);
 
                //Obtenemos   la fila contenedora para el checkbox
                var tr = chk.closest("tr");
 
                //Buscamos en la actual fila el select, filtrando por la clase
               
                //Si esta activo el checkbox
                if (chk.is(':checked')) {
                    //Habilitamos
                    var obj={idpano:chk.val(),idpresupexpres:$("#id").val(),medialtura:tr.find('.ddl').val(),idestancia:${pex.idestancia},idpropuesta:${pex.idpropuesta}};
                  
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/sup/jsonPresupuestoExpres.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#tipoc").attr('disabled', 'false');
                          var ddl1 = tr.find('.SubCapCheckIcon');
                            ddl1.show();
                            var ddl2 = tr.find('.SubCapCheckIcon1');
                            ddl2.hide();
                            var ddl3 = tr.find('.UsarPanosGuardado3');
                            var ddl4 = tr.find('.UsarPanosGuardado4');
                            
                                        if(tr.find('.ddl').val()!="und."){                                        
                                            ddl3.show();
                                            ddl4.hide();
                                            
                                        }else{
                                            ddl3.hide();
                                            ddl4.hide();
                                        }
                                                
                        }
                    });
                    
                } else {
                   var obj={idpano:chk.val(),idpresupexpres:$("#id").val(),idestancia:${pex.idestancia},idpropuesta:${pex.idpropuesta}};
                  
                    $.ajax({
                        type:'POST',
                        contentType:'application/json',
                        url:"/Intranet/sup/jsonPresupuestoExpresDelete.htm",
                        data:JSON.stringify(obj),
                        success:function(data){
                           //$("#tipoc").attr('disabled', 'false');
                           var ddl1 = tr.find('.SubCapCheckIcon');
                            ddl1.hide();
                            var ddl2 = tr.find('.SubCapCheckIcon1');
                            ddl2.hide();
                            var ddl3 = tr.find('.UsarPanosGuardado3');
                            ddl3.hide();
                            var ddl4 = tr.find('.UsarPanosGuardado4');
                            ddl4.hide();
                            var lista1 = tr.find('.presupuestom1');
                            var lista2 = tr.find('.presupuestom2');
                            lista1.hide();
                            lista2.hide();
                            
                        }
                    });
                }
            });
        }
        
        function alto_change() {
            $('.ddl').change(function () {
                
                //Obtenemos el select 
                var ddl = $(this);
                var tr = ddl.closest("tr");
                var chk = tr.find('.chk');
                 if (chk.is(':checked')) {
                     
                                //Asignamos al select el valor seleccionado en la primera fila.
                               var obj={idpano:chk.val(),idpresupexpres:$("#id").val(),medialtura:tr.find('.ddl').val(),idestancia:${pex.idestancia},idpropuesta:${pex.idpropuesta}};
                               
                                
                                 $.ajax({
                                     type:'POST',
                                     contentType:'application/json',
                                     url:"/Intranet/sup/jsonPresupuestoExpressMedida.htm",
                                     data:JSON.stringify(obj),
                                     success:function(data){
                                        //$("#tipoc").attr('disabled', 'false');
                                       
                                     }
                                 });
                                
                            }
                  
                
            });
        }       
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
						
						nventana: {
							required: true
						}
					},
			
					messages: {
						nventana: {
							required: "Se requiere numerp de ventanas"
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


