<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

                
<div class="page-content">
<div class="page-header">
    <h1>
            Nuevo Contrato

    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="profile-info-row">
                    <div class="profile-info-name"> NIF/NIE/PASAPORTE </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nif}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Nombre </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nombre}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Apellidos </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.apellidos}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> NUMERO AFILIACION S.S </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.numero_afiliacionss}" /></span>
                    </div>
                </div>



        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-6">


            <div class="profile-info-row">
                    <div class="profile-info-name">PAIS </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.pais}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> PROVINCIA </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.provincia}" /></span>
                    </div>
            </div>

            <div class="profile-info-row">
                    <div class="profile-info-name"> POBLACI&Oacute;N </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.poblacion}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> DIRECCI&Oacute;N </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.direccion}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> NIVEL FORMATIVO </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.nivel_formativo}" /></span>
                    </div>
            </div>
        </div>

        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>
						
<div class="row">
    <div class="col-xs-12">
            <h3 class="header smaller lighter blue"></h3>

            <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="contrato">
                           
                                    <!-- #section:elements.form -->
                                    <form:hidden id="nif_empleado" path="nif_empleado.nif" value="${empleado.nif}" />
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha de Contrato </label>

                                            <div class="col-sm-9">
                                                    <div class="row">
                                                            <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                                    <div class="input-group input-group-sm">
                                                                        <form:input id="fecha_contrato" type="text" class="form-control" path="fecha_contrato" data-date-format="yyyy-mm-dd" required="true"/>   
                                                                             <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-calendar"></i>
                                                                            </span>
                                                                    </div>
                                                         

                                                            </div>
                                                    </div>
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Categoria Profesional </label>

                                            <div class="col-sm-9">
                                                <form:input id="categoria_profesional" type="text" class="col-xs-10 col-sm-5" placeholder="Categoria Profesional" path="categoria_profesional" required="true"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Grupo / Categoria / Nivel Profesional </label>

                                            <div class="col-sm-9">
                                               <form:input id="nivel_profesional" type="text" class="col-xs-10 col-sm-5" placeholder="Grupo / Categoria / Nivel Profesional" path="nivel_profesional" required="true"/>
                                              
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tipo Contrato </label>

                                            <div class="col-sm-9">
                                                <form:select id="id_tipo_contrato" name="id_tipo_contrato" path="id_tipo_contrato.id"  data-placeholder="Choose a State...">
                                                    <form:options items="${allTipoContrato}" itemValue="id" itemLabel="nombre" />
                                                </form:select>
                                                 
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Jornada </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="jornadaC" path="jornada" value="Completo" class="ace"/>
                                                                <span class="lbl"> Completo</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="jornadaP" path="jornada" value="Parcial" class="ace" />
                                                                <span class="lbl"> Parcial</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Numero de Horas </label>

                                            <div class="col-sm-9">
                                                <form:input id="num_horas" type="text" class="col-xs-10 col-sm-5" placeholder="0" path="num_horas" required="true"/>
                                                
                                            </div>
                                    </div>
                                    <div id="completo" class="form-group" >
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> RANGO </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango1" path="tiempo_rango1" value="lunes - Domingo" class="ace" />
                                                                <span class="lbl"> lunes - Domingo</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango1" path="tiempo_rango1" value="Martes - Jueves" class="ace" />
                                                                <span class="lbl"> Martes - Jueves</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div id="parcial" class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> TIEMPO </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango2" path="tiempo_rango2" value="al dia" class="ace" />
                                                                <span class="lbl"> al dia</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango2" path="tiempo_rango2" value="a la semana" class="ace" />
                                                                <span class="lbl"> a la semana</span>
                                                            </label>
                                                    </div>
                                                    
                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango2" path="tiempo_rango2" value="al mes" class="ace" />
                                                                <span class="lbl">al mes</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tiempo_rango2" path="tiempo_rango2" value="al año" class="ace" />
                                                                <span class="lbl">al año</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div id="parcial2" class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CORRESPONDE CONTRATO </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="corresponde_contrato" path="corresponde_contrato" value="SI" class="ace" />
                                                                <span class="lbl">SI</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="corresponde_contrato" path="corresponde_contrato" value="NO" class="ace" />
                                                                <span class="lbl">NO</span>
                                                            </label>
                                                    </div>
                                                    
                                                    
                                            </div>
                                    </div>
                                    <div id="parcial3" class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PACTO HORAS COMPLEMENTARIAS</label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="pacto_horas_complementarias" path="pacto_horas_complementarias" value="SI" class="ace" />
                                                                <span class="lbl">SI</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="pacto_horas_complementarias" path="pacto_horas_complementarias" value="NO" class="ace" />
                                                                <span class="lbl">NO</span>
                                                            </label>
                                                    </div>
                                                    
                                                    
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Distribucion tiempo </label>

                                            <div class="col-sm-9">
                                                <form:textarea id="distribucion_tiempo" path="distribucion_tiempo"  class="form-control" placeholder="Distribucion tiempo "/>
                                               
                                            </div>
                                    </div>

                                    <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Duracion Contrato</label>
                                    <div class="col-sm-9">

                                    </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Desde </label>

                                            <div class="col-sm-9">
                                                    <div class="row">
                                                            <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                                    <div class="input-group input-group-sm">
                                                                        <form:input id="duracion_contrato_desde" type="text" class="form-control" path="duracion_contrato_desde" data-date-format="yyyy-mm-dd"/>   
                                                                             <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-calendar"></i>
                                                                            </span>
                                                                    </div>
                                                         

                                                            </div>
                                                    </div>
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Hasta </label>

                                            <div class="col-sm-9">
                                                    <div class="row">
                                                            <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                                    <div class="input-group input-group-sm">
                                                                        <form:input id="duracion_contrato_hasta" type="text" class="form-control" path="duracion_contrato_hasta" data-date-format="yyyy-mm-dd"/>   
                                                                            <span class="input-group-addon">
                                                                                    <i class="ace-icon fa fa-calendar"></i>
                                                                            </span>
                                                                    </div>
                                                            </div>
                                                    </div>
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Periodo Prueba </label>

                                            <div class="col-sm-9">
                                                <form:input id="periodo_prueba" type="text" class="col-xs-10 col-sm-5" path="periodo_prueba" placeholder="Periodo Prueba" />   
                                               
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Contrato Relevo </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="contrato_relevo" path="contrato_relevo" value="SI" class="ace" />
                                                                <span class="lbl"> SI</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                               <form:radiobutton id="contrato_relevo" path="contrato_relevo" value="NO" class="ace" /> 
                                                               <span class="lbl"> NO</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Retribucion total </label>

                                            <div class="col-sm-9">
                                                <form:input id="retribucion_total" type="text" class="col-xs-10 col-sm-5" path="retribucion_total" placeholder="0" />   
                                                
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Conceptos Salariales </label>

                                            <div class="col-sm-9">
                                                <form:input id="conceptos_salariales" type="text" class="col-xs-10 col-sm-5" path="conceptos_salariales" placeholder="Conceptos Salariales" />   
                                                
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Pago </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="fecha_pago" path="fecha_pago" value="Diarios" class="ace" /> 
                                                                 <span class="lbl"> Diarios</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="fecha_pago" path="fecha_pago" value="Semanales" class="ace" /> 
                                                                <span class="lbl"> Semanales</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="fecha_pago" path="fecha_pago" value="Mensuales" class="ace" /> 
                                                                <span class="lbl"> Mensuales</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tipo de Pago </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tipo_pago" path="tipo_pago" value="Salario Base" class="ace" /> 
                                                                <span class="lbl"> Salario Base</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tipo_pago" path="tipo_pago" value="Complementarios Salariales" class="ace" /> 
                                                                 <span class="lbl"> Complementarios Salariales</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="tipo_pago" path="tipo_pago" value="Pluses" class="ace" /> 
                                                                <span class="lbl"> Pluses</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Vacaciones </label>

                                            <div class="col-sm-9">
                                                <form:input id="vacaciones" type="text" class="col-xs-10 col-sm-5" path="vacaciones" placeholder="Vacaciones" />   
                                                
                                            </div>

                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Clausulas </label>

                                            <div class="col-sm-9">
                                                <form:textarea id="clausulas" path="clausulas"  class="form-control" placeholder="Clausulas"/>
                                            </div>
                                            
                                    </div>
                                           
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                            <div class="col-sm-9">
                                                    <button type="submit" class="btn btn-info col-xs-12 col-sm-4 col-md-3 col-lg-2">Insertar</button>
                                            </div>
                                    </div>
                            </form:form>
                    </div>
            </div>



    </div>

</div>
</div>             
                    
                    
                    
