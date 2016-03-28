<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

                
		<link rel="stylesheet" href="/Intranet/resources/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/chosen.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" href="/Intranet/resources/assets/css/colorpicker.css" />
 
<div class="page-header">
   
        <h1>
            Nueva Paño para la Estancia:
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    ${pa.estancia_id.numero} ${pa.estancia_id.tipo_estancia_id.nombre} 
            </small>
        </h1>
        
</div><!-- /.page-header -->
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="pa">
                <form:hidden id="estancia_id" path="estancia_id.id" value="${pa.estancia_id.id}"/>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">N°</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="numero" path="numero" class="col-xs-10 col-sm-4" required="true"/>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tipo de Paño</label>

                        <div class="col-sm-9">
                        <form:select id="tipo_pano_id" name="tipo_pano_id" path="tipo_pano_id.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State...">
                            <form:options items="${ltaTipoPano}" itemValue="id" itemLabel="nombre" />
                        </form:select>
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">LARGO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="largo" path="largo" class="col-xs-10 col-sm-4" required="true"/>
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">ALTO</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="alto" path="alto" class="col-xs-10 col-sm-4"  required="true"/>
                        </div>
                </div>
                <div class="form-group" id="Otro">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">SUPERFICIE</label>

                        <div class="col-sm-9">
                            <form:input type="text" id="superficie" path="superficie" class="col-xs-10 col-sm-4"  readonly="true"/>
                        </div>
                </div>
                      
                
                <div class="form-group">
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-3">Siguiente</button>
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
function calcular_total() {
	importe_total = 0
	$(".importe_linea").each(
		function(index, value) {
			importe_total = importe_total + eval($(this).val());
		}
	);
	$("#total").val(importe_total);
}
 
function nueva_linea() {
    
        $("#lineas").append('<input type="text" class="importe_linea" value="0"/><br/>');
        
}
</script>

<script type="text/javascript">
	$(document).ready(function(){
            $("#Numventanas").hide();
            $("#Numpuertas").hide();
            $("#Numarmarios").hide();
            $("#venN").hide();
            
          //ventanas
          if($("#ventana1").is(":checked")){
                $("#Numventanas").show();
                $("#venN").show();
            }else if($("#ventana2").is(":checked")){
                $("#Numventanas").hide();
            }
            $("#ventana1").click(function() {             
                $("#Numventanas").show();
                $("#venN").show();
            });
             $("#ventana2").click(function() {             
                $("#Numventanas").hide();
            });
            //puertas
            $("#puertas1").click(function() {             
                $("#Numpuertas").show();
            });
             $("#puertas2").click(function() {             
                $("#Numpuertas").hide();
            });
            //armarios
            $("#armario1").click(function() {             
                $("#Numarmarios").show();
            });
             $("#armario2").click(function() {             
                $("#Numarmarios").hide();
            });
        });
                jQuery(function($){
                    $("#numventanas").on('change',function(e) { 
                        $("#venN").show();
                    });
        
                    //pano
                    
                    $("#largo").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val()));
                    });
                    $("#alto").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val())); 
                    });
                    
                    //ventanas
                    
                   
                    $("#largoventana").on('change',function(e) { 
                        $("#superficieventana").attr("value",($("#largoventana").val()*$("#altoventana").val()).val());
                    });
                    $("#altoventana").on('change',function(e) { 
                        $("#superficieventana").attr("value",($("#largoventana").val()*$("#altoventana").val()).val()); 
                    });
                    
                    
                    //puertas
                    $("#largopuerta").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val()));
                    });
                    $("#altopuerta").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val())); 
                    });
                    $("#numpuertas").on('change',function(e) { 
                        $("#superficiepuerta").attr("value",(($("#largopuerta").val()*$("#altopuerta").val())*$("#numpuertas").val()));
                    });
                    
                    //armarios
                    $("#largoarmario").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val()));
                    });
                    $("#altoarmario").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val())); 
                    });
                    $("#numarmarios").on('change',function(e) { 
                        $("#superficiearmario").attr("value",(($("#largoarmario").val()*$("#altoarmario").val())*$("#numarmarios").val()));
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

		<script src="/Intranet/resources/assets/js/dataTables/jquery.dataTables.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/jquery.dataTables.bootstrap.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/extensions/TableTools/js/dataTables.tableTools.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/extensions/ColVis/js/dataTables.colVis.js"></script>

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
