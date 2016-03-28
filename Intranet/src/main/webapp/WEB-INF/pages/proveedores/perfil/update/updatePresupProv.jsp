<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- /section:settings.box -->

<div class="page-content">
<div class="page-header">
    <h1>
         Modificar Presupuesto

    </h1>
</div>
<div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
<form:form id="form1" action="" method="POST" commandName="presup"class="form-horizontal  col-xs-12" role="form">
<br/>
<form:hidden path="id"/>
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
                            <button type="submit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-2">Modificar</button>
                    </div>
            </div>        
	</form:form>


								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
           <div class="col-xs-9">
                        <br/><br/><br/>
                        <div class="message-attachment clearfix">
                            <div class="attachment-title">
                                    <span class="blue bolder bigger-110">Attachments</span>
                                    &nbsp;

                                    <a class=" btn btn-white btn-warning" href="/Intranet/prov/updateArchivos.htm?idP=${idP}"addDatosCliente data-rel="tooltip">
                                    Agregar Mas Archivos
                                </a>
                            </div>

                            &nbsp;
                            <ul class="attachment-list pull-left list-unstyled">
                                 <c:forEach items="${archivos}" var="imagrar">
                                     
                                    <li>

                                                    <i class="ace-icon fa fa-file-o bigger-110"></i>
                                                    <span class="attached-name">${imagrar.nombre}</span>


                                            <span class="action-buttons">

                                                    <a href="/Intranet/resources/archivosProveedores/${imagrar.nombre}" id="btn_enviar">
                                                            <i class="ace-icon fa fa-download bigger-125 blue"></i>
                                                    </a> 
                                                    <a class="red" href="/Intranet/prov/deletePresupProvID.htm?idP=${idP}&idA=${imagrar.id}" title="Eliminar">
                                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                    </a>
                                            </span>
                                    </li>
                                 </c:forEach>    

                            </ul>
                            
                          
                    </div>
                    </div>     
						</div><!-- /.row -->
                                                
</div>

