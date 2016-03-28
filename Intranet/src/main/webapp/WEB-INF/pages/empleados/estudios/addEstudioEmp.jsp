<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">  
<div class="page-header">
    <h1>
        Agregar Estudio
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->  
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="estudio" class="form-horizontal" role="form">
                                <form:hidden path="postulante_doc_identidad" />
                                    <!-- #section:elements.form -->
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Curso </label>

                                            <div class="col-sm-9">
                                                <form:select id="curso_id" name="curso_id" path="curso_id.id" class="col-xs-10 col-sm-5" data-placeholder="Choose a State...">
                                                    <form:options items="${listaCursos}" itemValue="id" itemLabel="nombre" />
                                                </form:select>
                                                   
                                            </div>

                                    </div>
                                    <div class="form-group" id="otroC">
                
                                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otro Curso </label>

                                        <div class="col-sm-9">
                                            <form:input type="text" id="otro_curso" name="otro_curso" path="otro_curso" class="col-xs-10 col-sm-5"/>


                                        </div>


                                </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Especificacion del Curso </label>

                                            <div class="col-sm-9">
                                                <form:input id="especificacion_curso" type="text" class="col-xs-10 col-sm-5" placeholder="Especificacion del Curso" path="especificacion_curso" required="true"/>
                                                
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha de Inicio </label>

                                            <div class="col-sm-9">
                                                    <span class="input-icon">
                                                    <form:input id="fecha_inicio_mes" type="text" class="" placeholder="Mes" path="fecha_inicio_mes" required="true"/>
                                                    
                                                    <i class="ace-icon fa fa-leaf blue"></i>
                                            </span>

                                            <span class="input-icon input-icon-right">
                                                 <form:input id="fecha_inicio_anio" type="text" class="" placeholder="Año" path="fecha_inicio_anio" required="true"/>
                                                 
                                                    <i class="ace-icon fa fa-leaf green"></i>
                                            </span>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>

                                            <div class="col-sm-9">
                                                    <div class="checkbox">
                                                            <label>
                                                                <form:checkbox id="cursando" path="cursando" />
                                                                
                                                                    <span class="lbl"> Cursando</span>
                                                            </label>
                                                    </div>
                                            </div>
                                    </div>
                                    <div id="fecha_fin"class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha de Fin </label>

                                            <div class="col-sm-9">
                                                    <span class="input-icon">
                                                    <form:input id="fecha_fin_mes" type="text" class="" placeholder="Mes" path="fecha_fin_mes"/>
                                                   
                                                    <i class="ace-icon fa fa-leaf blue"></i>
                                            </span>

                                            <span class="input-icon input-icon-right">
                                                 <form:input id="fecha_fin_anio" type="text" class="" placeholder="Año" path="fecha_fin_anio"/>
                                                 
                                                    <i class="ace-icon fa fa-leaf green"></i>
                                            </span>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Centro </label>

                                            <div class="col-sm-9">
                                                <form:input id="centro" type="text" class="col-xs-10 col-sm-5" placeholder="Centro" path="centro" required="true"/>
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