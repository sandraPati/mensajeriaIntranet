<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">        
<div class="page-header">
    <h1>
        Actualizar Idioma
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="idioma" class="form-horizontal" role="form">
                                <form:hidden path="id" value="id"/>
                                <form:hidden path="postulante_doc_identidad" />
                                    <!-- #section:elements.form -->
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Curso </label>

                                            <div class="col-sm-9">
                                                <form:select id="tipoidioma_id" name="tipoidioma_id" path="tipoidioma_id.id" class="col-xs-10 col-sm-5" data-placeholder="Choose a State...">
                                                    <form:options items="${listaTipoIdioma}" itemValue="id" itemLabel="nombre" />
                                                </form:select>
                                                   
                                            </div>

                                    </div>
                                   
                              <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel de Hablado </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelhablado" path="nivelhablado" value="Basico" class="ace"/>
                                                             
                                                                <span class="lbl"> Basico</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelhablado" path="nivelhablado" value="Medio" class="ace"/>
                                                               
                                                                <span class="lbl"> Medio</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelhablado" path="nivelhablado" value="Alto" class="ace"/>
                                                            
                                                                <span class="lbl"> Alto</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelhablado" path="nivelhablado" value="Excelente" class="ace"/>
                                                            
                                                                <span class="lbl"> Excelente</span>
                                                        </label>
                                                </div>
                                        </div>
                                </div>	
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel de Escrito </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelescrito" path="nivelescrito" value="Basico" class="ace"/>
                                                             
                                                                <span class="lbl"> Basico</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                             <form:radiobutton id="nivelescrito" path="nivelescrito" value="Medio" class="ace"/>
                                                           
                                                                <span class="lbl"> Medio</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                             <form:radiobutton id="nivelescrito" path="nivelescrito" value="Alto" class="ace"/>
                                                           
                                                                <span class="lbl"> Alto</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                              <form:radiobutton id="nivelescrito" path="nivelescrito" value="Excelente" class="ace"/>
                                                          
                                                                <span class="lbl"> Excelente</span>
                                                        </label>
                                                </div>
                                        </div>
                                </div>	
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel de Leido </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelleido" path="nivelleido" value="Basico" class="ace"/>
                                                            
                                                                <span class="lbl"> Basico</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelleido" path="nivelleido" value="Medio" class="ace"/>
                                                            
                                                                <span class="lbl"> Medio</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelleido" path="nivelleido" value="Alto" class="ace"/>
                                                            
                                                                <span class="lbl"> Alto</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="nivelleido" path="nivelleido" value="Excelente" class="ace"/>
                                                           
                                                                <span class="lbl"> Excelente</span>
                                                        </label>
                                                </div>
                                                            
                                        </div>
                                </div>	
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                                            </div>
                                    </div> 

                            </form:form>
                    </div>
							    </div>


					</div><!-- /.row -->
