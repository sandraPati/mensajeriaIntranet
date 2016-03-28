<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<div class="page-content">
<form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="nomina">
<div class="page-header">
    <h1>
        NOMINA
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
               ${nomina.nominaId.nif_empleado.nif}  ${nomina.nominaId.nif_empleado.apellidos},  ${nomina.nominaId.nif_empleado.nombre} 
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
               
                
                        <!-- #section:elements.form -->
                        <div class="form-group">
                           <form:hidden id="id"  path="nominaId.id" />      
                           <form:hidden id="nif_empleado"  path="nominaId.nif_empleado.nif" value="${nomina.nominaId.nif_empleado.nif}"/>
                            <form:hidden id="c"  path="nominaId.c.id" value="${nomina.nominaId.c.id}"/>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Periodo(N° dias) </label>

                                <div class="col-sm-9">
                                    <form:input id="numdias" type="text" class="col-xs-10 col-sm-5" placeholder="" path="nominaId.numdias" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Antiguedad </label>

                                <div class="col-sm-9">
                                    <form:input id="antiguedad" type="text" class="col-xs-10 col-sm-5" placeholder="Antiguedad" path="nominaId.antiguedad" required="true"/>
                                    
                                </div>
                        </div>            
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Salario Base </label>

                                <div class="col-sm-9">
                                    <form:input id="salario_base" type="text" class="col-xs-10 col-sm-5" placeholder="Salario Base" path="nominaId.salario_base" required="true"/>
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Pagas extas prorrateadas </label>

                                <div class="col-sm-9">
                                     <form:input id="pagas_extras_prorrateadas" type="text" class="col-xs-10 col-sm-5" placeholder="Pagas extas prorrateadas" path="nominaId.pagas_extras_prorrateadas" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Gratificaciones extraordinarias </label>

                                <div class="col-sm-9">
                                   <form:input id="gratificaciones_extraordinarias" type="text" class="col-xs-10 col-sm-5" placeholder="Gratificaciones extraordinarias" path="nominaId.gratificaciones_extraordinarias" />
                                   
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Indemnizaciones suplidos </label>

                                <div class="col-sm-9">
                                    <form:input id="indemnizaciones_suplidos" type="text" class="col-xs-10 col-sm-5" placeholder="Indemnizaciones suplidos" path="nominaId.indemnizaciones_suplidos" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otras Percepciones no salariales </label>

                                <div class="col-sm-9">
                                    <form:input id="otras_percepciones_no_salariales" type="text" class="col-xs-10 col-sm-5" placeholder="Otras Percepciones no salariales" path="nominaId.otras_percepciones_no_salariales" />
                                    
                                </div>
                        </div>

                        <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Mes y A&ntilde;o</label>
                        <div class="col-sm-9">
                                <!-- #section:elements.form.input-icon -->
                                <span class="input-icon ">
                                    <form:input id="mes" type="text" placeholder="mm" path="nominaId.mes" required="true"/>
                                    <i class="ace-icon fa fa-leaf blue"></i>
                                </span>

                                <span class="input-icon input-icon-right">
                                    <form:input id="anio" type="text" placeholder="yyyy" path="nominaId.anio" required="true"/>
                                    <i class="ace-icon fa fa-leaf green"></i>
                                </span>

                                <!-- /section:elements.form.input-icon -->
                        </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Prorrateo Vacaciones </label>

                                <div class="col-sm-9">
                                    <form:input id="prorrateo_vacaciones" type="text" class="col-xs-10 col-sm-5" placeholder="Prorrateo Vacaciones" path="nominaId.prorrateo_vacaciones" />
                                     
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Salario Especie </label>

                                <div class="col-sm-9">
                                   <form:input id="salario_especie" type="text" class="col-xs-10 col-sm-5" placeholder="Salario Especie" path="nominaId.salario_especie" />
                                  
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Prestaciones indemnizaciones SS </label>

                                <div class="col-sm-9">
                                    <form:input id="prestaciones_indemnizaciones_ss" type="text" class="col-xs-10 col-sm-5" placeholder="Prestaciones indemnizaciones SS" path="nominaId.prestaciones_indemnizaciones_ss" />
                                   
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Horas extraordinarias </label>

                                <div class="col-sm-9">
                                    <form:input id="horas_extraordinarias" type="text" class="col-xs-10 col-sm-5" placeholder="Horas extraordinarias" path="nominaId.horas_extraordinarias" />
                                   
                                </div>

                        </div>
                       
                               
                
        </div>
</div>
<div class="page-header">
    <h1>
        DEDUCCION
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
             
        </small>
        
    </h1>
</div><!-- /.page-header -->
<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
               
                <form:hidden id="id"  path="deduccionId.id" />      
                           <form:hidden id="nif_empleado"  path="deduccionId.nif_empleado.nif" value="${nomina.deduccionId.nif_empleado.nif}"/>
                            <form:hidden id="nom"  path="deduccionId.nom.id" value="${nomina.deduccionId.nom.id}"/>
                        <!-- #section:elements.form -->
                       
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Contingencias Comunes</label>

                                <div class="col-sm-9">
                                    <form:input id="contingencias_comunes" type="text" class="col-xs-10 col-sm-5" placeholder="Contingencias Comunes" path="deduccionId.contingencias_comunes" />
                                    
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Desempleo</label>

                                <div class="col-sm-9">
                                     <form:input id="desempleo" type="text" class="col-xs-10 col-sm-5" placeholder="Desempleo" path="deduccionId.desempleo" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Formacion </label>

                                <div class="col-sm-9">
                                   <form:input id="formacion" type="text" class="col-xs-10 col-sm-5" placeholder="Formacion" path="deduccionId.formacion" />
                                   
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Irpf</label>

                                <div class="col-sm-9">
                                    <form:input id="irpf" type="text" class="col-xs-10 col-sm-5" placeholder="Irpf suplidos" path="deduccionId.irpf" />
                                     
                                </div>
                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Anticipos </label>

                                <div class="col-sm-9">
                                    <form:input id="anticipos" type="text" class="col-xs-10 col-sm-5" placeholder="Anticipos" path="deduccionId.anticipos" />
                                    
                                </div>
                        </div>

                        
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Valor Productos Recibidos</label>

                                <div class="col-sm-9">
                                    <form:input id="valor_productos_recibidos" type="text" class="col-xs-10 col-sm-5" placeholder="Valor Productos Recibidos" path="deduccionId.valor_productos_recibidos" />
                                     
                                </div>

                        </div>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otras Deducciones</label>

                                <div class="col-sm-9">
                                   <form:input id="otras_deducciones" type="text" class="col-xs-10 col-sm-5" placeholder="Otras Deducciones" path="deduccionId.otras_deducciones" />
                                  
                                </div>

                        </div>
                       <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Base de Cotizacion de contingencias comunes(mes + porrata pagas) </label>

                                <div class="col-sm-9">
                                   <form:input id="basecotizacion" type="text" class="col-xs-10 col-sm-5" placeholder="" path="deduccionId.basecotizacion" />
                                  
                                </div>

                        </div>  
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Base sujeta a IRPF </label>

                                <div class="col-sm-9">
                                   <form:input id="baseirpf" type="text" class="col-xs-10 col-sm-5" placeholder="" path="deduccionId.baseirpf" />
                                  
                                </div>

                        </div>  
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                <div class="col-sm-9">
                                       <button type="subtmit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-5">Actualizar</button>
                                </div>
                        </div>
                                
                
        </div>
</div>
</form:form>  
</div>
