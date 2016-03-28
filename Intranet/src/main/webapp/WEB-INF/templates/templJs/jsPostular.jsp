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
            $('#labelOficio').hide();
            $('#labelCoincide').hide();
            $('#labelNOCoincide').hide();
            $('#otroP').hide();
            if($("#perfilprof").val()=='2') { 
                 $('#labelOficio').show();
                 $('#otroP').hide();
                 $("#otroperfilprofesional").attr("value","");
            }else if($("#perfilprof").val()=='3') {
                  $('#labelOficio').hide();
                  $('#otroP').show(); 
             }else{
                 $('#labelOficio').hide();  
                 $('#otroP').hide();
                 $("#otroperfilprofesional").attr("value","");
             }
    
           
        });	
        
        $(function(){

         $("#btn_enviar").click(function(){ 
            $.ajax({
                   type: "POST",
                   url: "/Intranet/jsonPostular.htm",
                   data: $("#form1").serialize(), // Adjuntar los campos del formulario enviado.
                   success: function(data)
                   {
                      // Mostrar la respuestas del script PHP.
                      // alert("success: "+data);
                       if(data=='1'){
                           //terminos
                           //$("#terminos").show();
                              
                                $.gritter.add({
						title: 'Notificacion !',
						text: 'Acepte las condiciones de uso y privacidad',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
        
        

                       }else if(data=='21'){
                           //contra
                           //$("#contra").show();
                                    $.gritter.add({
						title: 'Notificacion. !',
						text: 'Contraseñas vacias',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                       }else if(data=='2'){
                           //contranocoinciden   
                            $.gritter.add({
						title: 'Notificacion. !',
						text: 'Las contraseñas no Coinciden',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                       }else if(data=='3'){
                           //usuarionif
                           $.gritter.add({
						title: 'Notificacion. !',
						text: 'Ya existe un Usuario con el mismo Documento NIF',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                       }else if(data=='4'){
                           //usuarioDes
                           $.gritter.add({
						title: 'Notificacion. !',
						text: 'Ya existe un Usuario con la misma descripcion(usuario)',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                       }else if(data=='5'){
                           //errorinesperado
                           $.gritter.add({
						title: 'Notificacion. !',
						text: 'Error Inesperado del sistema, vuelva intentarlo mas tarde.',
						image: '/Intranet/resources/figuras/icono_error.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                       }else if(data=='6'){
                           //redirecciona        
                           $.gritter.add({
						title: 'Notificacion. !',
						text: 'Su registro ha sido satisfactorio.',
						image: '/Intranet/resources/figuras/check-icon.png', //in Ace demo ../assets will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-success' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
                                        var obj={j_username:'fajardo',j_password:'angel'};
                                        $.ajax({
                                           cache: false,
                                            type: 'POST',
                                            url: "j_spring_security_check",
                                            crossDomain: true,
                                            async: false,
                                            data: { j_username: "fajardo", j_password: "angel" },
                                           //data: $("#form1").serialize(),
                                           success:function(data)
                                           {
                                               alert(data);
                                           }
                                       });
                                        
                       }
                   },error:function(data,status,er) { 
                        //alert("error: "+data+" status: "+status+" er:"+er);
                    }
                 });

            return false; // Evitar ejecutar el submit del formulario.
         });
 
        });
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#perfilprof').on('change',function(e) {
                            
                             if($("#perfilprof").val()=='2') { 
                                $('#labelOficio').show();
                                $('#otroP').hide();
                                 $("#otroperfilprofesional").attr("value","");
                            }else if($("#perfilprof").val()=='3') { 
                                $('#labelOficio').hide();
                                $('#otroP').show();
                            }else{
                                $('#labelOficio').hide();  
                                $('#otroP').hide();
                                $("#otroperfilprofesional").attr("value","");
                            }
        
					
					
			 });
			 $('#contrasenna').on('change',function(e) {
                             
                             if($('#contrasenna').val()==$('#contrasenna2').val()){
                                
                                 $('#labelCoincide').show();
                                 $('#labelNOCoincide').hide();
                             }else if($('#contrasenna').val()!=$('#contrasenna2').val()){
                                 
                                 $('#labelCoincide').hide();
                                $('#labelNOCoincide').show();
                             }
					
					
			 });
			 $('#contrasenna2').on('change',function(e) {
                              if($('#contrasenna').val()==$('#contrasenna2').val()){
                                
                                 $('#labelCoincide').show();
                                 $('#labelNOCoincide').hide();
                             }else if($('#contrasenna').val()!=$('#contrasenna2').val()){
                                 
                                 $('#labelCoincide').hide();
                                $('#labelNOCoincide').show();
                             }
        
					
					
			 });
                     });
		</script>


                <script src="/Intranet/resources/assets/js/bootstrap.js"></script>
                <script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		<script src="/Intranet/resources/assets/js/bootbox.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.easypiechart.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.gritter.js"></script>
		<script src="/Intranet/resources/assets/js/spin.js"></script>

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


