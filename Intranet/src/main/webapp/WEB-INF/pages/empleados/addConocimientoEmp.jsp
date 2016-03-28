<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

                
<div class="page-header">
    <h1>
        Agregar Conocimiento
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->   
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="conocimiento" class="form-horizontal" role="form">
                                <form:hidden path="postulante_doc_identidad"/>
                                    <!-- #section:elements.form -->
                                    
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Descripci&oacute;n</label>

                                            <div class="col-sm-9">
                                                <form:input id="descripcion" type="text" class="col-xs-10 col-sm-5" placeholder="Descripcion" path="descripcion" required="true"/>
                                                 
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="nivel" path="nivel" value="Basico" class="ace"/>
                                                                
                                                                    <span class="lbl"> Basico</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Medio" class="ace"/>
                                                                    <span class="lbl"> Medio</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Alto" class="ace"/>
                                                                    <span class="lbl"> Alto</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                 <form:radiobutton id="nivel" path="nivel" value="Excelente" class="ace"/>
                                                                    <span class="lbl"> Excelente</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                                
                                      <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Agregar</button>
                                            </div>
                                    </div>       
                                    


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
		
			//you don't need this, just used for changing background
			jQuery(function($) {
                         $('#cursando').click(function(){
                                $('#fecha_fin').show();                              
                                if($('#cursando').is(':checked')){
                                    $('#fecha_fin').hide();
                                }
			 
                         });
			});
		</script>
                
                
                
		<!-- CALENDARIO -->
		<script src="/Intranet/resources/assets/js/jquery-ui.js"></script>
		<script src="/Intranet/resources/assets/js/jquery.ui.touch-punch.js"></script>



		<!-- TABLA -->
		<script src="/Intranet/resources/assets/js/dataTables/jquery.dataTables.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/jquery.dataTables.bootstrap.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/extensions/TableTools/js/dataTables.tableTools.js"></script>
		<script src="/Intranet/resources/assets/js/dataTables/extensions/ColVis/js/dataTables.colVis.js"></script>



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