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
               Paño:
                <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                   
                </small>
        </h1>       
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.tipo_pano_id.nombre}" /> :</span>
                    </div>
                </div>    
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.largo}" /> m</span>
                    </div>
                </div>    
               
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.alto}" /> m</span>
                    </div>
                </div>  
                  
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div> 
                  
                         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/EjaddPanoVolcar.htm" data-rel="tooltip">
                Cambiar Datos
            </a> 
        </div>  
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/MasPanos.htm" data-rel="tooltip">
                Usar los mismos Datos
            </a> 
        </div>             
    </div>
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div>                
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numventanas}" /> Ventanas</span>
                    </div>
                </div> 
               
                 
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                 
        </div>  
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/EjaddVentanasFVolcar.htm" data-rel="tooltip">
                Cambiar datos Ventanas
            </a> 
        </div> 
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/EjaddVentanasVolcar.htm" data-rel="tooltip">
                Agregar Ventanas
            </a> 
        </div>             
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
            <a class=" btn btn-white btn-success" href="/Intranet/sup/MasPanos.htm" data-rel="tooltip">
                No tiene Ventanas
            </a> 
        </div>             
                    
     </div>     
                    
                    
    <c:forEach items="${pa.ventanaspano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>  
    
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div>
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numpuertas}" /> Puertas</span>
                    </div>
                </div> 
               
                 
        </div>
                    
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                 
        </div>                  
                   
     </div>               
                        
                    
    <c:forEach items="${pa.puertaspano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>                
    
    <div class="col-xs-8">
       <div class="hr hr-dotted hr-8"><br/><br/><br/></div> 
                         
                    
     </div>                
     <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${pa.numarmarios}" /> Armarios</span>
                    </div>
                </div> 
               
                 
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                 
        </div>                  
              
     </div>             
                    
     <c:forEach items="${pa.armariospano}" var="itemv">              
    <div class="col-xs-12">
       <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                
        </div>
         
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-1">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">N°</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.num}" /></span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                 
                <div class="profile-info-row">
                    <div class="profile-info-name">L </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.largo}" /> m</span>
                    </div>
                </div>     
                
                
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    <div class="profile-info-name">A</div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.alto}" /> m</span>
                    </div>
                </div> 
                 
           
        </div>
         <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-2">
                
                <div class="profile-info-row">
                    
                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${itemv.superficie}" /></span>
                    </div>
                    <div class="profile-info-name">m cuadrados </div>

                </div> 
                
        </div>                  
                    
     </div>                  
    </c:forEach>                     
                    
    <div class="col-xs-9">
       <div class="hr hr-dotted hr-6"><br/><br/><br/></div> 
                         
                    
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
	
                jQuery(function($){
                   
                    //pano
                    
                    $("#largo").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val()));
                    });
                    $("#alto").on('change',function(e) { 
                        $("#superficie").attr("value",($("#largo").val()*$("#alto").val())); 
                    });
                    
                    //ventanas
                    
                   
                    
                    //puertas
                    $("#largopuerta1").on('change',function(e) { 
                        $("#superficiepuerta1").attr("value",($("#largopuerta1").val()*$("#altopuerta1").val()));
                    });
                    $("#altopuerta1").on('change',function(e) { 
                        $("#superficiepuerta1").attr("value",($("#largopuerta1").val()*$("#altopuerta1").val())); 
                    });
                    $("#largopuerta2").on('change',function(e) { 
                        $("#superficiepuerta2").attr("value",($("#largopuerta2").val()*$("#altopuerta2").val()));
                    });
                    $("#altopuerta2").on('change',function(e) { 
                        $("#superficiepuerta2").attr("value",($("#largopuerta2").val()*$("#altopuerta2").val())); 
                    });
                    $("#largopuerta3").on('change',function(e) { 
                        $("#superficiepuerta3").attr("value",($("#largopuerta3").val()*$("#altopuerta3").val()));
                    });
                    $("#altopuerta3").on('change',function(e) { 
                        $("#superficiepuerta3").attr("value",($("#largopuerta3").val()*$("#altopuerta3").val())); 
                    });
                    $("#largopuerta4").on('change',function(e) { 
                        $("#superficiepuerta4").attr("value",($("#largopuerta4").val()*$("#altopuerta4").val()));
                    });
                    $("#altopuerta4").on('change',function(e) { 
                        $("#superficiepuerta4").attr("value",($("#largopuerta4").val()*$("#altopuerta4").val())); 
                    });
                    $("#largopuerta5").on('change',function(e) { 
                        $("#superficiepuerta5").attr("value",($("#largopuerta5").val()*$("#altopuerta5").val()));
                    });
                    $("#altopuerta5").on('change',function(e) { 
                        $("#superficiepuerta5").attr("value",($("#largopuerta5").val()*$("#altopuerta5").val())); 
                    });
                    $("#largopuerta6").on('change',function(e) { 
                        $("#superficiepuerta6").attr("value",($("#largopuerta6").val()*$("#altopuerta6").val()));
                    });
                    $("#altopuerta6").on('change',function(e) { 
                        $("#superficiepuerta6").attr("value",($("#largopuerta6").val()*$("#altopuerta6").val())); 
                    });

                    $("#largopuerta7").on('change',function(e) { 
                        $("#superficiepuerta7").attr("value",($("#largopuerta7").val()*$("#altopuerta7").val()));
                    });
                    $("#altopuerta7").on('change',function(e) { 
                        $("#superficiepuerta7").attr("value",($("#largopuerta7").val()*$("#altopuerta7").val())); 
                    });
                    
                    $("#largopuerta8").on('change',function(e) { 
                        $("#superficiepuerta8").attr("value",($("#largopuerta8").val()*$("#altopuerta8").val()));
                    });
                    $("#altopuerta8").on('change',function(e) { 
                        $("#superficiepuerta8").attr("value",($("#largopuerta8").val()*$("#altopuerta8").val())); 
                    });
                    $("#largopuerta9").on('change',function(e) { 
                        $("#superficiepuerta9").attr("value",($("#largopuerta9").val()*$("#altopuerta9").val()));
                    });
                    $("#altopuerta9").on('change',function(e) { 
                        $("#superficiepuerta9").attr("value",($("#largopuerta9").val()*$("#altopuerta9").val())); 
                    });
                    $("#largopuerta10").on('change',function(e) { 
                        $("#superficiepuerta10").attr("value",($("#largopuerta10").val()*$("#altopuerta10").val()));
                    });
                    $("#altopuerta10").on('change',function(e) { 
                        $("#superficiepuerta10").attr("value",($("#largopuerta10").val()*$("#altopuerta10").val())); 
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
