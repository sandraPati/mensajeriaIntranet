<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="page-content">  
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Actualizar Proveedor
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/sup/Gestion.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   
        <div class="row" >
            <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" alt="${proveedor.nombre}" src="/Intranet/resources/fotosPerfil/proveedores/${proveedor.nombreFoto}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${proveedor.nombre} </span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    <div class="col-xs-9">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="proveedor" class="form-horizontal" role="form">
                                <form:hidden id="id" path="id"/>    
                                                
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> CIF: </label>

                                            <div class="col-sm-9">
                                                <form:input id="cif" type="text" class="col-xs-10 col-sm-5" placeholder="Cif" path="cif"required="true"/>
                                            </div>
                                    </div>
                                   
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NOMBRE: </label>

                                            <div class="col-sm-9">
                                                <form:input id="nombre" type="text" class="col-xs-10 col-sm-5" placeholder="Nombre" path="nombre"required="true"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> DIRECCION: </label>

                                            <div class="col-sm-9">
                                                <form:input id="direccion" type="text" class="col-xs-10 col-sm-5" placeholder="Direccion" path="direccion"required="true"/>
                                                
                                            </div>
                                            
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">  </label>

                                            <div class="col-sm-9" >
                                                
                                                    <div id="map_canvas" style="width: 400px; height: 200px;"></div>
                                                
                                            </div>
                                            
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ACTIVIDAD: </label>

                                            <div class="col-sm-9">
                                                 <form:select id="id_actividad" name="id_actividad" path="id_actividad.id" class="col-xs-10 col-sm-4" data-placeholder="Choose a State..."required="true">
                                                    <form:options items="${allTipoActividad}" itemValue="id" itemLabel="nombre" />
                                                </form:select>
                                               
                                            </div>
                                    </div>  
                                     <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> EMAIL: </label>

                                            <div class="col-sm-9">
                                                <form:input id="email" type="text" class="col-xs-10 col-sm-5" placeholder="Email" path="email"required="true"/>
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> TELEFONO: </label>

                                            <div class="col-sm-9">
                                                <form:input id="telefono" type="text" class="col-xs-10 col-sm-5" placeholder="Telefono" path="telefono" required="true"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PERSONA CONTACTO: </label>

                                            <div class="col-sm-9">
                                                <form:input id="persona_contacto" type="text" class="col-xs-10 col-sm-5" placeholder="Persona Contacto" path="persona_contacto" required="true"/>
                                            </div>
                                    </div>           
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> LINK: </label>

                                            <div class="col-sm-9">
                                                <form:input id="link" type="text" class="col-xs-10 col-sm-5" placeholder="Link" path="link"/>
                                            </div>
                                    </div>  
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> BANCO: </label>

                                            <div class="col-sm-9">
                                                <form:input id="banco" type="text" class="col-xs-10 col-sm-5" placeholder="Banco" path="banco"required="true"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> NUMERO CUENTA: </label>

                                            <div class="col-sm-9">
                                                <form:input id="num_cuenta" type="text" class="col-xs-10 col-sm-5" placeholder="N° Cuenta" path="num_cuenta"required="true"/>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Proveedor visible?: </label>

                                            <div class="col-sm-9">
                                                <form:checkbox id="visible"   name="form-field-checkbox" value="1" class="" path="visible"/>
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