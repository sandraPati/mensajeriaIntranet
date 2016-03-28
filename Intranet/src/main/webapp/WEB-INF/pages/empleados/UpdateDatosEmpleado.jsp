<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
	
<div class="page-header">
    <h1>
        Mis Datos Personales
        <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
              
        </small>
    </h1>
</div><!-- /.page-header -->                     
 		
<div class="row">
<div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <form:form id="form1" class="form-horizontal" role="form" action="" method="POST" commandName="empleado" accept-charse='UTF-8'>
        

                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NIF/NIE/PASAPORTE </label>

                        <div class="col-sm-9">
                           ${empleado.nif}
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
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otro Email </label>

                        <div class="col-sm-9">
                            <form:input id="otro_email" type="text" class="col-xs-10 col-sm-5" placeholder="Email" path="otro_email" />
                              
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
                            <form:input id="poblacion" type="text" class="col-xs-10 col-sm-5" placeholder="Poblaci&oacute;n" path="poblacion" required="true"/>
                             
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
                            <form:input id="direccion" type="text" class="col-xs-10 col-sm-5" placeholder="Direcci&oacute;n" path="direccion" required="true"/>
                            
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Codigo Postal </label>

                        <div class="col-sm-9">
                             <form:input id="codigo_postal" type="text" class="col-xs-10 col-sm-5" placeholder="Codigo Postal" path="codigo_postal" />
                             
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Telefono </label>

                        <div class="col-sm-9">
                            <form:input id="telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="telefono" required="true"/>
                               
                        </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Otro Telefono </label>

                        <div class="col-sm-9">
                            <form:input id="otro_telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="otro_telefono" />
                               
                        </div>
                </div>
               	
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha de Nacimiento </label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="fecha_nacimiento" type="text" class="form-control" path="fecha_nacimiento" data-date-format="yyyy-mm-dd" />
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-calendar"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Numero de Seguridad Social: </label>

                        <div class="col-sm-9">
                            <form:input id="numero_seguridad_social" type="text" class="col-xs-10 col-sm-5" placeholder="NUMERO de SEGURIDAD SOCIAL" path="numero_seguridad_social" />
                              
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Doba</label>

                        <div class="col-sm-9">
                            <form:input id="doba" type="text" class="col-xs-10 col-sm-5" placeholder="Doba" path="doba"/>
                              
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fecha Alta </label>

                        <div class="col-sm-9">
                                <div class="row">
                                        <div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
                                                <div class="input-group input-group-sm">
                                                    <form:input id="fecha_alta" type="text" class="form-control" path="fecha_alta" data-date-format="yyyy-mm-dd"/>
                                                   
                                                        <span class="input-group-addon">
                                                                <i class="ace-icon fa fa-calendar"></i>
                                                        </span>
                                                </div>
                                        </div>
                                </div>
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Observaciones </label>

                        <div class="col-sm-9">
                            <form:input id="observacion" type="text" class="col-xs-10 col-sm-5" placeholder="Observacion" path="observacion" />
                              
                        </div>

                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NUMERO AFILIACION S.S </label>

                        <div class="col-sm-9">
                            <form:input id="numero_afiliacionss" type="text" class="col-xs-10 col-sm-5" placeholder="NUMERO AFILIACION S.S" path="numero_afiliacionss" />
                              
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
                                            <form:radiobutton id="permiso_conducir" path="permiso_conducir" value="SI" class="ace" />
                                              
                                                <span class="lbl"> SI</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                             <form:radiobutton id="permiso_conducir" path="permiso_conducir" value="NO" class="ace" />
                                          
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
                                             <form:radiobutton id="vehiculo_propio" path="vehiculo_propio" value="SI" class="ace" />
                                             
                                                <span class="lbl"> SI</span>
                                        </label>
                                </div>

                                <div class="radio">
                                        <label>
                                            <form:radiobutton id="vehiculo_propio" path="vehiculo_propio" value="NO" class="ace" />
                                            
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
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Perfil/Tipo de Empleado </label>

                        <div class="col-sm-9">
                                <form:select id="id_perfil" name="id_perfil" path="id_perfil.idp" class="col-xs-10 col-sm-5" data-placeholder="Choose a State...">
                                    <form:options items="${listaPerfiles}" itemValue="idp" itemLabel="nombrep" />
                                </form:select>
                                
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
                <div class="form-group">
                        <label id="labelOficio" class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                        <div class="col-sm-9">
                               <button type="submit" class="btn btn-primary col-xs-12 col-sm-4 col-md-3 col-lg-3">Actualizar</button>
                        </div>
                </div>
                         
                <br/><br/>

                <div class="hr hr-dotted hr-16"></div>

        </form:form>
</div>
</div>	

</div><!-- /.row -->
