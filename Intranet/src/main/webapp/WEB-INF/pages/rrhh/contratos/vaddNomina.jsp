<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 


<div class="page-header">
    <h1>
        NOMINA
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
                                
                           <form:hidden id="nif_empleado"  path="nif_empleado.nif" />
                            <form:hidden id="c"  path="c.id" />
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Periodo(N° dias) </label>

                                <div class="col-sm-9">
                                    <form:input id="numdias" type="text" class="col-xs-10 col-sm-5" placeholder="" path="numdias" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Antiguedad </label>

                                <div class="col-sm-9">
                                    <form:input id="antiguedad" type="text" class="col-xs-10 col-sm-5" placeholder="Antiguedad" path="antiguedad" required="true"/>
                                    
                                </div>
                        </div>            
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Salario Base </label>

                                <div class="col-sm-9">
                                    <form:input id="salario_base" type="text" class="col-xs-10 col-sm-5" placeholder="Salario Base" path="salario_base" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Pagas extas prorrateadas </label>

                                <div class="col-sm-9">
                                     <form:input id="pagas_extras_prorrateadas" type="text" class="col-xs-10 col-sm-5" placeholder="Pagas extas prorrateadas" path="pagas_extras_prorrateadas" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Gratificaciones extraordinarias </label>

                                <div class="col-sm-9">
                                   <form:input id="gratificaciones_extraordinarias" type="text" class="col-xs-10 col-sm-5" placeholder="Gratificaciones extraordinarias" path="gratificaciones_extraordinarias" />
                                   
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Indemnizaciones suplidos </label>

                                <div class="col-sm-9">
                                    <form:input id="indemnizaciones_suplidos" type="text" class="col-xs-10 col-sm-5" placeholder="Indemnizaciones suplidos" path="indemnizaciones_suplidos" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otras Percepciones no salariales </label>

                                <div class="col-sm-9">
                                    <form:input id="otras_percepciones_no_salariales" type="text" class="col-xs-10 col-sm-5" placeholder="Otras Percepciones no salariales" path="otras_percepciones_no_salariales" />
                                    
                                </div>
                        </div>

                        <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Mes y A&ntilde;o</label>
                        <div class="col-sm-9">
                                <!-- #section:elements.form.input-icon -->
                                <span class="input-icon">
                                    <form:input id="mes" type="text" placeholder="mm" path="mes" required="true"/>
                                    <i class="ace-icon fa fa-leaf blue"></i>
                                </span>

                                <span class="input-icon input-icon-right">
                                    <form:input id="anio" type="text" placeholder="yyyy" path="anio" required="true"/>
                                    <i class="ace-icon fa fa-leaf green"></i>
                                </span>

                                <!-- /section:elements.form.input-icon -->
                        </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Prorrateo Vacaciones </label>

                                <div class="col-sm-9">
                                    <form:input id="prorrateo_vacaciones" type="text" class="col-xs-10 col-sm-5" placeholder="Prorrateo Vacaciones" path="prorrateo_vacaciones" />
                                     
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Salario Especie </label>

                                <div class="col-sm-9">
                                   <form:input id="salario_especie" type="text" class="col-xs-10 col-sm-5" placeholder="Salario Especie" path="salario_especie" />
                                  
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Prestaciones indemnizaciones SS </label>

                                <div class="col-sm-9">
                                    <form:input id="prestaciones_indemnizaciones_ss" type="text" class="col-xs-10 col-sm-5" placeholder="Prestaciones indemnizaciones SS" path="prestaciones_indemnizaciones_ss" />
                                   
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Horas extraordinarias </label>

                                <div class="col-sm-9">
                                    <form:input id="horas_extraordinarias" type="text" class="col-xs-10 col-sm-5" placeholder="Horas extraordinarias" path="horas_extraordinarias" />
                                   
                                </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                <div class="col-sm-9">
                                       <button type="subtmit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-2">Insertar</button>
                                </div>
                        </div>
                </form:form>                   
                
        </div>
</div>


