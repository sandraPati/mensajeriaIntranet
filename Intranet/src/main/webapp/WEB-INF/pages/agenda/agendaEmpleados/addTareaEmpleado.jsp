<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

		
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery.gritter.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/select2.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-editable.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/chosen.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/colorpicker.css" />
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
            Agregar Tarea
            <br/>
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
            </small>
        </h1>
        </div>
    <div class="col-lg-4 align-right">
        <a class=" btn btn-white btn-warning" href="/Intranet/sup/TareasEmpleado.htm?nif=${nif}" data-rel="tooltip">
            <i class="ace-icon fa fa-reply icon-only"></i>

        </a>

    </div>
             
             
    </div>
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="tarea">
                <form:hidden id="nifsupervisor" path="nifsupervisor" value="${tarea.nifsupervisor}"/>
                <form:hidden id="nifempleado" path="nifempleado" value="${tarea.nifempleado}"/>
                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Cliente Asignado: </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="cliasignado1" path="cliasignado" value="SI" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                                
                                                        </label>
                                                        <label>
                                                            
                                                                <form:radiobutton id="cliasignado2" path="cliasignado" value="NO" class="ace" />
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>        
                                                </div>

                                              


                                        </div>
                                </div>
                <div class="form-group" id="clienteAsig">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Cliente </label>

                        <div class="col-sm-9">
                            <form:select id="nifcliente" name="nifcliente" path="nifcliente" class="col-xs-10 col-sm-3" data-placeholder="Choose a State...">
                               
                                <form:options items="${clientesLista}" itemValue="nif" itemLabel="nif" />
                            </form:select>

                        </div>

                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo Tarea:</label>

                        <div class="col-sm-9">
                            <form:select id="tipotarea_id" name="tipotarea_id" path="tipotarea_id"  data-placeholder="Choose a State..." >
                                <form:option value="Visita"></form:option>
                                <form:option value="Enviar Presupuesto"></form:option>
                                <form:option value="Llamada para concretar visita"></form:option>
                                <form:option value="Llamada de seguimiento"></form:option>
                                <form:option value="Libre"></form:option>
                                <form:option value="Incidencia"></form:option>
                            </form:select>
                          
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Descripcion:</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="descripcion" path="descripcion" required="true"/>
                          
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Desde:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="finicio" type="text" class="form-control" path="finicio"  required="true"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>   
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Hasta:</label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="ffin" type="text" class="form-control" path="ffin"  required="true"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="fa fa-clock-o bigger-110"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>   
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

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
 window.jQuery || document.write("<script src='/Intranet/resources/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='/Intranet/resources/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script src="/Intranet/resources/assets/js/bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
            $("#clienteAsig").hide();
            
          //ventanas
            $("#cliasignado1").click(function() {             
                $("#clienteAsig").show();
            });
             $("#cliasignado2").click(function() {             
                $("#clienteAsig").hide();
            });
            if($("#cliasignado1").is(":checked")){
                $("#clienteAsig").show();
            }else if($("#cliasignado2").is(":checked")){
                $("#clienteAsig").hide();
            }
           
        });
    
			jQuery(function($) {
                                $('#finicio').datetimepicker().next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
                                $('#ffin').datetimepicker().next().on(ace.click_event, function(){
					$(this).prev().focus();
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