<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">   
     <c:if test="${not empty mensaje}">
                <div >
                    <p class="alert alert-success">
                        ${mensaje}
                    </p>
            </div>
            </c:if>           
<!-- #section:settings.box -->
<c:if test="${postulante.estadoinf==false}">
    
<div class="row">
    <div class="col-xs-12">
        
        <!-- #section:plugins/fuelux.wizard.steps -->
        <ul class="steps  ">
                <li data-step="1 " class="active ">
                        <span class="step ">1</span>
                        <span class="title ">Información Personal</span>
                </li>

                <li data-step="2">
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

</c:if><br/>
<div class="row">
    <div class="col-xs-12">
        
        <div>
            <div id="user-profile-1" class="user-profile row">
                
                    <div class="col-xs-12 col-sm-3 center">
                            

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                   
            </div>
    </div>
            <!-- PAGE CONTENT BEGINS -->
           
    </div>
</div>
 
<div class="page-header">
    <div class="row">
        <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
            <h1>
                Mis Datos Personales
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>

                </small>
            </h1>
        </div>
        <div class="col-xs-8 col-sm-5 col-md-5 col-lg-4">
            <div>
                <!-- #section:pages/profile.picture -->
                <span class="profile-picture">
                        <img  class="editable img-responsive" alt="${postulante.apellidos}" src="/Intranet/resources/fotosPerfil/${postulante.nombrefotografia}" />
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
        </div>
    </div>
</div><!-- /.page-header -->  
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="postulante">
        

                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NIF/NIE/PASAPORTE </label>

                        <div class="col-sm-9">
                            <form:hidden id="id" path="id"/>
                            <form:input id="docuemnto_identidad" type="text" class="col-xs-10 col-sm-5" placeholder="NIF / NIE / PASAPORTE" path="docuemnto_identidad" readonly="true"/>
                            <form:hidden id="estadoinf" path="estadoinf" value="${postulante.estadoinf}"/>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nombre </label>

                        <div class="col-sm-9">
                            <form:input id="nombre" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre" path="nombre" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Apellidos </label>

                        <div class="col-sm-9">
                             <form:input id="apellidos" type="text" class="col-xs-10 col-sm-5" placeholder="Apellidos" path="apellidos" required="true"/>
                                
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Email </label>

                        <div class="col-sm-9">
                            <form:input id="email" type="text" class="col-xs-10 col-sm-5" placeholder="Email" path="email" required="true"/>
                              
                        </div>
                </div>
                
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Pais </label>

                        <div class="col-sm-9">
                            <form:input id="pais" type="text" class="col-xs-10 col-sm-5" placeholder="Pais" path="pais" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Provincia </label>

                        <div class="col-sm-9">
                            <form:input id="provincia" type="text" class="col-xs-10 col-sm-5" placeholder="Provincia" path="provincia" required="true"/>
                           
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Poblaci&oacute;n </label>

                        <div class="col-sm-9">
                            <form:input id="poblacion" type="text" class="col-xs-10 col-sm-5" placeholder="Población" path="poblacion" required="true"/>
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nacionalidad </label>

                        <div class="col-sm-9">
                             <form:input id="nacionalidad" type="text" class="col-xs-10 col-sm-5" placeholder="Nacionalidad" path="nacionalidad" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Direcci&oacute;n </label>

                        <div class="col-sm-9">
                            <form:input id="direccion" type="text" class="col-xs-10 col-sm-5" placeholder="Direccion" path="direccion" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Codigo Postal </label>

                        <div class="col-sm-9">
                             <form:input id="codigo_postal" type="text" class="col-xs-10 col-sm-5" placeholder="Codigo Postal" path="codigo_postal" required="true"/>
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Telefono </label>

                        <div class="col-sm-9">
                            <form:input id="telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="telefono" required="true"/>
                               
                        </div>
                </div>
                
               	
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha de Nacimiento </label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="fecha_nacimiento" type="text" class="form-control" path="fecha_nacimiento" data-date-format="yyyy-mm-dd"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-calendar"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NUMERO AFILIACION S.S </label>

                        <div class="col-sm-9">
                            <form:input id="numero_afiliacionss" type="text" class="col-xs-10 col-sm-5" placeholder="NUMERO AFILIACION S.S" path="numero_afiliacionss" required="true"/>
                              
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NIVEL FORMATIVO </label>

                        <div class="col-sm-9">
                            <form:input id="nivel_formativo" type="text" class="col-xs-10 col-sm-5" placeholder="NIVEL FORMATIVO" path="nivel_formativo"/>
                              
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> GENERO </label>

                        <div class="col-sm-9">

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="genero" path="genero" value="MASCULINO" class="ace" />
                                              
                                                <span class="lbl"> MASCULINO</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="genero" path="genero" value="FEMENINO" class="ace" />
                                           
                                                <span class="lbl"> FEMENINO</span>
                                        </label>
                                </div>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PERMISO CONDUCIR </label>

                        <div class="col-sm-9">

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="permisoconducir" path="permisoconducir" value="SI" class="ace" />
                                              
                                                <span class="lbl"> SI</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                             <form:radiobutton id="permisoconducir" path="permisoconducir" value="NO" class="ace" />
                                          
                                                <span class="lbl"> NO</span>
                                        </label>
                                </div>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> VEHICULO PROPIO </label>

                        <div class="col-sm-9">

                                <div class="radio">
                                        <label>
                                             <form:radiobutton id="vehiculopropio" path="vehiculopropio" value="SI" class="ace" />
                                             
                                                <span class="lbl"> SI</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="vehiculopropio" path="vehiculopropio" value="NO" class="ace" />
                                            
                                                <span class="lbl"> NO</span>
                                        </label>
                                </div>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> AUTONOMO </label>

                        <div class="col-sm-9">

                                <div class="radio">
                                        <label>
                                             <form:radiobutton id="autonomo" path="autonomo" value="SI" class="ace" />
                                              
                                                <span class="lbl"> SI</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="autonomo" path="autonomo" value="NO" class="ace" />
                                            
                                                <span class="lbl"> NO</span>
                                        </label>
                                </div>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PRESENCIA EN </label>

                        <div class="col-sm-9">

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="presencia" path="presencia" value="En Twitter" class="ace" />
                                            
                                                <span class="lbl">En Twitter</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="presencia" path="presencia" value="En Facebook" class="ace" />
                                             
                                                <span class="lbl"> En Facebook</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="presencia" path="presencia" value="Blog o Portfolio" class="ace" />
                                              
                                                <span class="lbl"> Blog o Portfolio</span>
                                        </label>
                                </div>
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nombre de Busqueda </label>

                        <div class="col-sm-9">
                            <form:input id="nombrepresencia" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre de Busqueda" path="nombrepresencia" />
                             
                        </div>

                </div>
               
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Perfil Profesional </label>

                        <div class="col-sm-9">
                                <form:select id="perfilprof" name="perfilprof" path="perfilprof.id" class="col-xs-10 col-sm-5" data-placeholder="Choose a State...">
                                    <form:options items="${listaPerfilProfesional}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                                
                        </div>
                </div>
            <div class="form-group" id="labelOficio">
                
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1"> Oficio </label>

                        <div class="col-sm-9">
                                 <form:select id="oficio" name="oficio" path="oficio.id" class="col-xs-10 col-sm-5" data-placeholder="Choose a State..." >
                                    <form:options items="${listaOficios}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                               
                        </div>
              
                

                </div>
                <div class="form-group" id="otroP">
                
                        <label id="" class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otro Perfil Profesional </label>

                        <div class="col-sm-9">
                            <form:input type="text" id="otroperfilprofesional" name="otroperfilprofesional" path="otroperfilprofesional" class="col-xs-10 col-sm-5"/>
                            
                               
                        </div>
                

                </div>   
                <c:if test="${postulante.estadoinf==true}">            
                <div class="form-group">
                        <label id="labelOficio" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-5">Guardar</button>
                        </div>
                </div>
                </c:if>
                <c:if test="${postulante.estadoinf==false}">
                <div class="form-group">
                        <label id="labelOficio" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-5">
                                   Siguiente<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                               </button>
                        </div>
                </div>
                
                </c:if>
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

              


<!--<button type="submit" class="btn btn-success col-xs-12 col-sm-4 col-md-3 col-lg-5">Next</button>-->
					</div><!-- /.row -->
