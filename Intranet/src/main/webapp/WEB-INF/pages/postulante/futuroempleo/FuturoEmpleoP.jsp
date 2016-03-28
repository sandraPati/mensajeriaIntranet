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
                        <span class="step"><a href="/Intranet/pos/IdiomasP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Idiomas</span>
                </li>
                <li data-step="5" class="active ">
                        <span class="step"><a href="/Intranet/pos/ConocimientosP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Conocimientos</span>
                </li>
                <li data-step="6" class="active ">
                        <span class="step"><a href="/Intranet/pos/ExperienciaLaboralesP.htm"><i class="ace-icon glyphicon glyphicon-ok bigger-100 light-green"></i></a></span>
                        <span class="title">Experiencias Laborales</span>
                </li>
                <li data-step="7" class="active ">
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
        Futuro Empleo
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="futuroEmpleo" class="form-horizontal" role="form">
                               
                                    <!-- #section:elements.form -->
                                    <form:hidden path="id" value="${id}"/>
                                    <form:hidden path="postulante_doc_identidad" value="${nif}"/>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ¿Est&aacute;s buscando trabajo? </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="buscas_trabajo" path="buscas_trabajo" value="Estoy buscando trabajo activamente" class="ace" checked="true"/>
                                                                
                                                                <span class="lbl"> Estoy buscando trabajo activamente</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="buscas_trabajo" path="buscas_trabajo" value="No busco trabajo pero estoy dispuesto a escuchar ofertas" class="ace"/>
                                                               
                                                                <span class="lbl"> No busco trabajo pero estoy dispuesto a escuchar ofertas</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="buscas_trabajo" path="buscas_trabajo" value="No tengo ningun interes en un nuevo trabajo" class="ace"/>
                                                               
                                                                <span class="lbl"> No tengo ningún interés en un nuevo trabajo</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="buscas_trabajo" path="buscas_trabajo" value="Quiero mejorar mi actual puesto de trabajo" class="ace"/>
                                                               
                                                                <span class="lbl"> Quiero mejorar mi actual puesto de trabajo</span>
                                                        </label>
                                                </div>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ¿Qu&eacute; puesto prefieres ? </label>

                                        <div class="col-sm-9">
                                            <form:input id="puesto" type="text" class="col-xs-10 col-sm-5" placeholder="Puesto" path="puesto" required="true"/>
                                              
                                        </div>
                                </div>

                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿Disponibilidad para cambiar de residencia? </label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="cambiar_residencia" path="cambiar_residencia" value="SI" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> SI</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="cambiar_residencia" path="cambiar_residencia" value="NO" class="ace" />
                                                             
                                                                <span class="lbl"> NO</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>

                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Destinos preferidos </label>

                                        <div class="col-sm-9">
                                            <form:input id="destinos" type="text" class="col-xs-10 col-sm-5" placeholder="Destinos preferidos" path="destinos" />
                                              
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Disponibilidad para viajar</label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="viajar" path="viajar" value="Buena" class="ace" checked="true"/>
                                                           
                                                                <span class="lbl"> Buena</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="viajar" path="viajar" value="Depende de las condiciones" class="ace"/>
                                                              
                                                                <span class="lbl"> Depende de las condiciones</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="viajar" path="viajar" value="Mala" class="ace" />
                                                                
                                                                <span class="lbl"> Mala</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Jornada Laboral Preferida</label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="jornada_laboral_preferida" path="jornada_laboral_preferida" value="Media Jornada" class="ace" checked="true"/>
                                                            
                                                                <span class="lbl"> Media Jornada</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="jornada_laboral_preferida" path="jornada_laboral_preferida" value="Completa" class="ace"/>
                                                            
                                                                <span class="lbl"> Completa</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="jornada_laboral_preferida" path="jornada_laboral_preferida" value="Indiferente" class="ace"/>
                                                                
                                                                <span class="lbl"> Indiferente</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">¿Qu&eacute; tipo de contrato prefieres?</label>

                                        <div class="col-sm-9">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tipo_contrato" path="tipo_contrato" value="Temporal" class="ace" checked="true"/>
                                                                
                                                                <span class="lbl"> Temporal</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tipo_contrato" path="tipo_contrato" value="Indefinido" class="ace"/>
                                                             
                                                                <span class="lbl"> Indefinido</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tipo_contrato" path="tipo_contrato" value="Indiferente" class="ace" />
                                                             
                                                                <span class="lbl"> Indiferente</span>
                                                        </label>
                                                </div>


                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Expectativas salariales: minimo aceptado bruto mensual </label>

                                        <div class="col-sm-9">
                                             <form:select id="expectativas_salariales_minimo" name="expectativas_salariales_minimo" path="expectativas_salariales_minimo"  data-placeholder="Choose a State...">
                                                        <form:option value="300"></form:option>
                                                        <form:option value="400"></form:option>
                                                        <form:option value="500"></form:option>
                                                        <form:option value="600"></form:option>
                                                        <form:option value="700"></form:option>
                                                        <form:option value="800"></form:option>
                                                        <form:option value="900"></form:option>
                                                        <form:option value="1000"></form:option>
                                                        <form:option value="1100"></form:option>
                                                        <form:option value="1200"></form:option>
                                                        <form:option value="1300"></form:option>
                                                        <form:option value="1400"></form:option>
                                                        <form:option value="1500"></form:option>
                                                        <form:option value="1600"></form:option>
                                                        <form:option value="1700"></form:option>
                                                        <form:option value="1800"></form:option>
                                                        <form:option value="1900"></form:option>
                                                        <form:option value="2000"></form:option>
                                                        <form:option value="2100"></form:option>
                                                        <form:option value="2200"></form:option>
                                                        <form:option value="2300"></form:option>
                                                        <form:option value="2400"></form:option>
                                                        <form:option value="2500"></form:option>
                                                        <form:option value="2600"></form:option>
                                                        <form:option value="2700"></form:option>
                                                        <form:option value="2800"></form:option>
                                                        <form:option value="2900"></form:option>
                                                        <form:option value="3000"></form:option>
                                                </form:select>
                                               
                                        </div>

                                </div>

                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Salario deseado bruto mensual </label>

                                        <div class="col-sm-9">
                                               <form:select id="salario_deseado" name="salario_deseado" path="salario_deseado"  data-placeholder="Choose a State...">
                                                        
                                                   <form:option value="700"></form:option>
                                                        <form:option value="800"></form:option>
                                                        <form:option value="900"></form:option>
                                                        <form:option value="1000"></form:option>
                                                        <form:option value="1100"></form:option>
                                                        <form:option value="1200"></form:option>
                                                        <form:option value="1300"></form:option>
                                                        <form:option value="1400"></form:option>
                                                        <form:option value="1500"></form:option>
                                                        <form:option value="1600"></form:option>
                                                        <form:option value="1700"></form:option>
                                                        <form:option value="1800"></form:option>
                                                        <form:option value="1900"></form:option>
                                                        <form:option value="2000"></form:option>
                                                        <form:option value="2100"></form:option>
                                                        <form:option value="2200"></form:option>
                                                        <form:option value="2300"></form:option>
                                                        <form:option value="2400"></form:option>
                                                        <form:option value="2500"></form:option>
                                                        <form:option value="2600"></form:option>
                                                        <form:option value="2700"></form:option>
                                                        <form:option value="2800"></form:option>
                                                        <form:option value="2900"></form:option>
                                                        <form:option value="3000"></form:option>
                                                </form:select>
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
                                    <div class="col-sm-8"></div>
                                        
                                        <div class="col-sm-4 no-padding-right">
                                            <a class="btn btn-prev col-xs-10 col-sm-6 col-md-6 col-lg-6 "  href="/Intranet/pos/ExperienciaLaboralesP.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                            <button type="submit" class="btn btn-success col-xs-10 col-sm-6 col-md-6 col-lg-6 ">
                                                Finalizar<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                            </button>
                                        </div>
                                    </div>          
                                     </c:if>                            
                                

                            </form:form>
                    </div>
							    </div>

</div><!-- /.row -->