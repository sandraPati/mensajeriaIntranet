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
                        <span class="step"><a href="/Intranet/pos/ActualizarfotoPostulante.htm">2</a></span>
                        <span class="title">Subir Foto / CV.</span>
                </li>

                <li data-step="3">
                        <span class="step">3</span>
                        <span class="title">Estudios</span>
                </li>

                <li data-step="4">
                        <span class="step">4</span>
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
        Actualizar Foto
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header --> 
                


<div class="row">
    <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <form:form id="form1" class="form-horizontal" enctype="multipart/form-data" action="" method="POST" commandName="postulante">
                    <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                            <div class="col-sm-9">
                            <div class="col-sm-4">
                            <div class="widget-box">
                                    <div class="widget-header">
                                            <h4 class="widget-title">Subir Fotografia</h4>

                                            <div class="widget-toolbar">
                                                    <a href="#" data-action="collapse">
                                                            <i class="ace-icon fa fa-chevron-up"></i>
                                                    </a>

                                                   
                                            </div>
                                    </div>

                                    <div class="widget-body">
                                            <div class="widget-main">
                                                    <div class="form-group">
                                                            <div class="col-xs-12">
                                                                
                                                                    <form:input id="fotografia" type="file" class="col-xs-10 col-sm-5" placeholder="Foto" path="fotografia" />
                                                                    <!-- /section:custom/file-input -->
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                            </div>
                            </div>
                    </div>
                                                                   
                   
                   <c:if test="${postulante.estadoinf==true}">                                                  
                   <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                            <div class="col-sm-9">
                                <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Subir Foto</button>
                            </div>
                   </div>
                   </c:if>
                    <c:if test="${postulante.estadoinf==false}">  
                   <div class="form-group">
                                    <div class="col-sm-9"></div>
                                        
                                        <div class="col-sm-3">
                                            <a class="btn btn-prev col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/Informacion.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                            <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-6">
                                                Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                            </button>
                                            
                                        </div>
                                </div>  
                   </c:if>
             </form:form>
    </div>
</div>


</div><!-- /.row -->