<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">
<c:if test="${postulante.estadoinf==false}">
<div class="row">
    <div class="col-xs-12">
        
        <!-- #section:plugins/fuelux.wizard.steps -->
        <ul class="steps  ">
                <li data-step="1" class="active">
                    <span class="step "><a href="/Intranet/pos/Informacion.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title ">Información Personal</span>
                </li>

                <li data-step="2" class="active ">
                        <span class="step"><a href="/Intranet/pos/ActualizarfotoPostulante.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Subir Foto / CV.</span>
                </li>

                <li data-step="3" class="active ">
                        <span class="step"><a href="/Intranet/pos/EstudiosP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Estudios</span>
                </li>

                <li data-step="4" class="active ">
                    <span class="step"><a href="/Intranet/pos/IdiomasP.htm">4</a></span>
                        <span class="title">Idiomas</span>
                </li>
                <li data-step="5">
                        <span class="step">5</span>
                        <span class="title">Conocimientos</span>
                </li>
                <li data-step="6">
                        <span class="step">6</span>
                        <span class="title">Experiencias Laborales</span>
                </li>
                <li data-step="7">
                        <span class="step">7</span>
                        <span class="title">Futuro Empleo</span>
                </li>
        </ul>

    </div>

</div>
<br/>
</c:if>
<br/>             
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
                                <form:hidden path="postulante_doc_identidad" value="${nif}"/>
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
                                <c:if test="${postulante.estadoinf==true}">                            
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9">
                                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                                            </div>
                                    </div> 
                                </c:if>     
                            <c:if test="${postulante.estadoinf==false}">   
                                <div class="form-group">
                                    <div class="col-sm-7 col-md-8"></div>
                                        
                                        <div class="col-sm-5 col-md-4 no-padding-right">
                                            <a class="btn btn-prev col-xs-10 col-sm-6 col-md-6 col-lg-6 "  href="/Intranet/pos/IdiomasP.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                             
                                            <button type="submit" class="btn btn-success col-xs-10 col-sm-6 col-md-6 col-lg-6 ">
                                                Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                            </button>
                                        </div>
                                    </div> 
                                
                            </c:if>         
                            </form:form>
                    </div>
							    </div>

</div><!-- /.row -->
                
                