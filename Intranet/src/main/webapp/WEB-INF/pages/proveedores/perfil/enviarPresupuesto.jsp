<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- /section:settings.box -->

<div class="page-content">
<div class="page-header">
    <h1>
         Enviar Presupuesto

    </h1>
</div>
<div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
<form:form id="form1" action="" method="POST" commandName="proveedorPresupuesto"class="form-horizontal  col-xs-12" role="form">
<br/>
            <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" >Descripcion:</label>

                    <div class="col-sm-9">
                            
                                <form:input type="text" id="descripcion" path="descripcion" class="col-xs-10 col-sm-6 col-lg-6" placeholder="" required="true"/> 
                                 
                    </div>
            </div>


            <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" >Monto:</label>

                    <div class="col-sm-6 col-xs-12">
                            
                            <form:input type="text" id="monto" path="monto" class="col-xs-10 col-sm-3 col-lg-2"required="true"/> 	
                                   
                    </div>
            </div>
            <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Iva:</label>

                    <div class="col-sm-6 col-xs-12">
                            
                            <form:input type="text" id="iva" path="iva" class="col-xs-10 col-sm-3 col-lg-2"required="true"/> 	
                               
                    </div>
            </div>
                        

            <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">
                            <span class="inline space-24 hidden-480"></span>

                    </label>

                    <!-- #section:plugins/editor.wysiwyg -->
                    <div class="col-sm-9">
                    <form:textarea type="text" id="nota" path="nota" class="col-xs-10 col-sm-6 " rows="5" />	

                    </div>

                    <!-- /section:plugins/editor.wysiwyg -->
            </div>  
             <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                    <div class="col-sm-9">
                            <button type="submit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-2">Enviar</button>
                    </div>
            </div>        
	</form:form>


								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
                                                
</div>

