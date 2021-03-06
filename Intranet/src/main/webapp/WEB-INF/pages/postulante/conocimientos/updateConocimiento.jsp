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
                    <span class="step"><a href="/Intranet/pos/ConocimientosP.htm">5</a></span>
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
        Actualizar Conocimiento
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->   
        <div class="row">
                    <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="conocimiento" class="form-horizontal" role="form">
                                <form:hidden path="id" value="id"/>
                                <form:hidden path="postulante_doc_identidad" value="${nif}"/>
                                    <!-- #section:elements.form -->
                                    
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Descripci&oacute;n</label>

                                            <div class="col-sm-9">
                                                <form:input id="descripcion" type="text" class="col-xs-10 col-sm-5" placeholder="Descripcion" path="descripcion" required="true"/>
                                                 
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nivel </label>

                                            <div class="col-sm-9">

                                                    <div class="radio">
                                                            <label>
                                                                <form:radiobutton id="nivel" path="nivel" value="Basico" class="ace"/>
                                                                
                                                                    <span class="lbl"> Basico</span>
                                                            </label>
                                                    </div>

                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Medio" class="ace"/>
                                                                    <span class="lbl"> Medio</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                    <form:radiobutton id="nivel" path="nivel" value="Alto" class="ace"/>
                                                                    <span class="lbl"> Alto</span>
                                                            </label>
                                                    </div>
                                                    <div class="radio">
                                                            <label>
                                                                 <form:radiobutton id="nivel" path="nivel" value="Excelente" class="ace"/>
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
                                            <a class="btn btn-prev col-xs-10 col-sm-6 col-md-6 col-lg-6 "  href="/Intranet/pos/ConocimientosP.htm">
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

					