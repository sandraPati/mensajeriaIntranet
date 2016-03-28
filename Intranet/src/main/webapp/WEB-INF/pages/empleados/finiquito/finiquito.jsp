<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">              
<div class="page-header">
    <h1>
       Fecha Finiquito
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="finiquito">
                                <form:hidden path="nif_empleado" value="${finiquito.nif_empleado}"/>
                                <form:hidden path="id_contrato" value="${finiquito.id_contrato}"/>
                                    <!-- #section:elements.form -->
                    
                    <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha </label>

                            <div class="col-sm-9">
                                    <div class="row">
                                            <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                    <div class="input-group input-group-sm">
                                                        <form:input id="fecha" type="text" class="form-control" path="fecha" data-date-format="yyyy-mm-dd" required="true"/>   
                                                             <span class="input-group-addon">
                                                                    <i class="ace-icon fa fa-calendar"></i>
                                                            </span>
                                                    </div>


                                            </div>
                                    </div>
                            </div>

                    </div>
                    
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Monto Recibido </label>
                        
                        <div class="col-sm-9">
                            <form:input id="monto" type="text" class="col-xs-12 col-sm-5 col-md-4 col-lg-3" path="monto"required="true"/>   
                                                     
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
                
                
                