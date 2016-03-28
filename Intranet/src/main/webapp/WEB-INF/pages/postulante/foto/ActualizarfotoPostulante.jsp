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
                        <span class="step">2</span>
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
    <div class="row">
        <div class="col-lg-4">
        <h1>
                Actualizar Tamaño Foto
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                     
                </small>
        </h1>
        </div>
         <div class="col-lg-4 ">
             <c:if test="${postulante.estadoinf==true}"> 
            <a class=" btn btn-white btn-warning" href="/Intranet/pos/fotoPostulante.htm" data-rel="tooltip">
               <i class="ace-icon fa fa-cloud-upload bigger-150"></i> Subir Foto
            </a>
             </c:if>
        </div>
             
             
    </div>
</div><!-- /.page-header -->                


<div class="row">
    <div class="col-xs-12">
        
        <div>
            <div id="user-profile-1" class="user-profile row">
                
                    <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" alt="${postulante.apellidos}" src="/Intranet/resources/fotosPerfil/${postulante.nombrefotografia}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${postulante.nombre} ${postulante.apellidos}</span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    <div class="col-xs-12 col-sm-9 ">
                         <form:form id="form1" class="form-horizontal"  action="" method="POST" commandName="postulante">
                            <form:hidden id="id" path="id"/>
                             <form:hidden id="docuemnto_identidad" path="docuemnto_identidad"/>

                                <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tama&ntilde;o de Foto </label>

                                        <div class="col-sm-3">

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Carnet /Primer plano" class="ace" checked="true"/>
                                                                <span class="lbl"> Carnet /Primer plano</span>
                                                        </label>
                                                </div>

                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Cuerpo completo" class="ace" />                                                
                                                                <span class="lbl"> Cuerpo completo</span>
                                                        </label>
                                                </div>
                                                <div class="radio">
                                                        <label>
                                                            <form:radiobutton id="tamanofoto" path="tamanofoto" value="Otras" class="ace" />                                                
                                                                <span class="lbl"> Otras</span>
                                                        </label>
                                                </div>
                                        </div>
                                </div>
                                <c:if test="${postulante.estadoinf==true}">                                
                               <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
                                        <div class="col-sm-9">
                                            <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                                        </div>
                               </div>
                               </c:if>
                               <c:if test="${postulante.estadoinf==false}">
                               <div class="form-group">
                                    <div class="col-sm-8"></div>
                                        
                                        <div class="col-sm-4">
                                            <a class="btn btn-prev col-xs-12 col-sm-4 col-md-3 col-lg-6 "  href="/Intranet/pos/fotoPostulante.htm">
                                                  <i class="ace-icon fa fa-arrow-left"></i> Anterior
                                            </a> 
                                            <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-6 ">
                                                Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                            </button>
                                            
                                        </div>
                                </div>                                     
                                </c:if>
                         </form:form>
                    </div>                
                    
            </div>
    </div>
            <!-- PAGE CONTENT BEGINS -->
           
    </div>
</div>


</div><!-- /.row -->