<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<script type="text/javascript">
	
	$(document).ready(function() {
 
		$('#form1').submit(function(e) {
			var frm = $('#form1');
			e.preventDefault();
 
		    var data = {}
		    var Form = this;
 
		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: '/Intranet/pos/Postular2.htm',
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(callback){
            	alert("Response: Name: "+callback.name+"  DOB: "+callback.dob+"  Email: "+callback.email+"  Phone: "+callback.phone);
                $(this).html("Success!");
            },
            error : function(){
                $(this).html("Error!");
            }
        });
		});
	});
</script>
<div id="signup-box" class="signup-box visible widget-box no-border">
        <div class="widget-body">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty mensaje}">
                <div >
                    <p class="alert alert-success">
                        ${mensaje}
                    </p>
            </div>
            </c:if>
                <div class="widget-main">
                        <h4 class="header green lighter bigger">
                                <i class="ace-icon fa fa-users blue"></i>
                                Trabaja con Nosotros
                        </h4>

                        <div class="space-6"></div>
                        <p> Si eres tan amable complementa los siguientes datos que nos ayudaran a conocerte. Te llevara poco tiempo. Gracias... </p>

                        <form:form id="form1" action="" method="POST" commandName="postulante">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="docuemnto_identidad" type="text" class="form-control" placeholder="NIF / NIE / PASAPORTE" path="docuemnto_identidad" required="true"/>
                                    
                                    <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>                                                                                                    

                                <label for="form-field-select-3">Perfil Profesional</label>												<br />
                                <form:select id="perfilprof" name="perfilprof" path="perfilprof.id" class="form-control" data-placeholder="Choose a State...">
                                    <form:options items="${listaPerfilProfesional}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                
                                <br/>
                                <div id="labelOficio">
                                <label id="" for="form-field-select-3" visible="false">Oficio</label>												<br />
                                <form:select id="" name="oficio" path="oficio.id" class="form-control" data-placeholder="Choose a State..." >
                                    <form:options items="${listaOficios}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                </div>
                                <br/>
                                <div id="otroP">
                                <label id="" for="form-field-select-3" visible="false">Otro Perfil Profesional</label>												<br />
                                <form:input type="text" name="otroperfilprofesional" id="otroperfilprofesional" path="otroperfilprofesional" class="form-control"/>
                                </div>
                                <br/>         

                                    <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="nombre" type="text" class="form-control" placeholder="Nombres" path="nombre" required="true"/>
                                     <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                    <form:input id="apellidos" type="text" class="form-control" placeholder="Apellidos" path="apellidos" required="true"/>
                                    
                                    <i class="ace-icon fa fa-pencil-square-o"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <form:input id="email" type="text" class="form-control" placeholder="Email" path="email" required="true"/>
                                    
                                            <i class="ace-icon fa fa-envelope"></i>
                                    </span>
                                </label>

                                <label class="block clearfix">
                                        <span class="block input-icon input-icon-right">
                                            <form:input id="usuario" type="text" class="form-control" placeholder="Username" path="usuario" required="true"/>
                                    
                                                <i class="ace-icon fa fa-user"></i>
                                        </span>
                                </label>

                                <label class="block clearfix">
                                        <span class="block input-icon input-icon-right">
                                            <form:input id="contrasenna2" type="password" class="form-control" placeholder="Password" path="contrasenna2" required="true"/>
                                      
                                                <i class="ace-icon fa fa-lock"></i>
                                        </span>
                                </label>

                                <label class="block clearfix">
                                        <span class="block input-icon input-icon-right">
                                           <form:input id="contrasenna" type="password" class="form-control" placeholder="Repeat password" path="contrasenna" required="true"/>
                                      
                                                <i class="ace-icon fa fa-retweet"></i>
                                        </span>
                                </label>
                                <label class="block clearfix">
                                                        
                                                        <div id="labelCoincide" class="col-sm-12">
                                                            <p class="text-success">Coinciden</p>
                                                        </div>
                                                        <div id="labelNOCoincide" class="col-sm-9">
                                                              <p class="text-danger">NO Coinciden</p>
                                                        </div>
                                </label>          
                                <label class="block">
                                    <form:checkbox path="condiciones" required="true"/>
                                     <span class="lbl">
                                            
                                            <a href="#">Acepto condiciones de uso y privacidad: </a>
                                        </span>
                                </label>

                                <div class="space-24"></div>

                                <div class="clearfix">
                                        <button type="reset" class="width-30 pull-left btn btn-sm">
                                                <i class="ace-icon fa fa-refresh"></i>
                                                <span class="bigger-110">Reset</span>
                                        </button>
                                    
                                        <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                                <span class="bigger-110">Register</span>

                                                <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                        </button>
                                </div>
                                
                        </fieldset>
                 </form:form>

                </div>

                <div class="toolbar center">
                        <a href="/Intranet/login.htm" data-target="#login-box" class="back-to-login-link">
                                <i class="ace-icon fa fa-arrow-left"></i>
                                Atr&aacute;s para iniciar sesi&oacute;n
                        </a>
                </div>
            
        </div><!-- /.widget-body -->
</div><!-- /.signup-box -->

	
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

<script type="text/javascript">
	$(document).ready(function(){
            $('#labelOficio').hide();
            $('#labelCoincide').hide();
            $('#labelNOCoincide').hide();
            $('#otroP').hide();
            
           
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

		<!-- page specific plugin scripts -->
		<script src="/Intranet/resources/assets/js/jquery-ui.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>

		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="/Intranet/resources/docs/assets/js/themes/sunburst.css" />

		<!-- page specific plugin scripts -->
		<script src="/Intranet/resources/assets/js/fuelux/fuelux.wizard.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.validate.js"></script>
		<script src="/Intranet/resources/assets/js/additional-methods.js"></script>
		<script src="/Intranet/resources/assets/js/bootbox.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.maskedinput.js"></script>
		<script src="/Intranet/resources/assets/js/select2.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="/Intranet/resources/assets/js/excanvas.js"></script>
		<![endif]-->
		<script src="/Intranet/resources/assets/js/jquery-ui.custom.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.easypiechart.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.sparkline.js"></script>
		<script src="/Intranet/resources/assets/js/flot/jquery.flot.js"></script>
		<script src="/Intranet/resources/assets/js/flot/jquery.flot.pie.js"></script>
		<script src="/Intranet/resources/assets/js/flot/jquery.flot.resize.js"></script>

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
		
		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="/Intranet/resources/docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '/Intranet/resources'; </script>
		<script src="/Intranet/resources/assets/js/ace/elements.onpage-help.js"></script>
		<script src="/Intranet/resources/assets/js/ace/ace.onpage-help.js"></script>
		<script src="/Intranet/resources/docs/assets/js/rainbow.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/generic.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/html.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/css.js"></script>
		<script src="/Intranet/resources/docs/assets/js/language/javascript.js"></script>
