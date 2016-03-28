<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 



<div class="page-header">
    <h1>
        DEDUCCIONES
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                 ${nomina.nif_empleado.nif}  ${nomina.nif_empleado.apellidos},  ${nomina.nif_empleado.nombre} 
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="nomina">
                        <!-- #section:elements.form -->
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nif Empleado </label>

                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 48293058 </label>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Contingencias Comunes </label>

                                <div class="col-sm-9">
                                    <form:input id="contingencias_comunes" type="text" class="col-xs-10 col-sm-5" placeholder="Contingencias Comunes" path="contingencias_comunes" />
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Desempleo </label>

                                <div class="col-sm-9">
                                    <form:input id="desempleo" type="text" class="col-xs-10 col-sm-5" placeholder="Desempleo" path="desempleo" />
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Formacion </label>

                                <div class="col-sm-9">
                                    <form:input id="formacion" type="text" class="col-xs-10 col-sm-5" placeholder="Formacion" path="formacion" />
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Irpf </label>

                                <div class="col-sm-9">
                                    <form:input id="irpf" type="text" class="col-xs-10 col-sm-5" placeholder="Irpf" path="irpf" />
                                   
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Anticipos </label>

                                <div class="col-sm-9">
                                    <form:input id="anticipos" type="text" class="col-xs-10 col-sm-5" placeholder="Anticipos" path="anticipos" />
                                    
                                </div>
                        </div>

                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Valor Productos Recibidos </label>

                                <div class="col-sm-9">
                                    <form:input id="valor_productos_recibidos" type="text" class="col-xs-10 col-sm-5" placeholder="Valor Productos Recibidos" path="valor_productos_recibidos" /> 
                                    
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otras Deducciones </label>

                                <div class="col-sm-9">
                                    <form:input id="otras_deducciones" type="text" class="col-xs-10 col-sm-5" placeholder="Otras Deducciones" path="otras_deducciones" /> 
                                  
                                </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                <div class="col-sm-9">
                                       <button type="submit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-2">Actualizar</button>
                                </div>
                        </div>

                </form:form>
        </div>
</div>

<!--<div class="hr hr-dotted hr-16"></div>-->
