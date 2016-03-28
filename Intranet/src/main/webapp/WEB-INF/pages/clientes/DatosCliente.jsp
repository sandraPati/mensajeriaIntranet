<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<div class="page-content">  
<!-- #section:settings.box -->
<div class="page-header">
    <div class="row">
        <div class="col-lg-8">
        <h1>
                Empleado:
                <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                       ${empleado.nif} ${empleado.nombre}, ${empleado.apellidos}
                </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            <a class=" btn btn-white btn-warning" href="/Intranet/cli/CupdateDatosCliente.htm" data-rel="tooltip">
               <i class="ace-icon fa fa-undo bigger-130"></i> Actualizar
            </a>
            
        </div>
             
             
    </div>
</div><!-- /.page-header -->						
<div class="row">
    <div class="col-xs-12">

        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">
                <div class="profile-info-row">
                    <div class="profile-info-name"> NIF/NIE/PASAPORTE </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nif}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Nombre </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.nombre}" /></span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> Apellidos </div>

                    <div class="profile-info-value">
                        <span class="editable" id="username"><c:out value="${empleado.apellidos}" /></span>
                    </div>
                </div>
                
            <div class="profile-info-row">
                    <div class="profile-info-name"> DIRECCI&Oacute;N </div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.direccion}" /></span>
                    </div>
            </div>
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">            
            <div class="profile-info-row">
                    <div class="profile-info-name"> PAIS</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.pais}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> PAIS</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.pais}" /></span>
                    </div>
            </div>
            <div class="profile-info-row">
                    <div class="profile-info-name"> PROVINCIA</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.provincia}" /></span>
                    </div>
            </div>        
            
            <div class="profile-info-row">
                    <div class="profile-info-name"> POBLACION</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.poblacion}" /></span>
                    </div>
            </div>        
        </div>
        <div class="profile-striped col-xs-12 col-sm-6 col-md-6 col-lg-4">           
            <div class="profile-info-row">
                    <div class="profile-info-name"> NACIONALIDAD</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.nacionalidad}" /></span>
                    </div>
            </div>  
           <div class="profile-info-row">
                    <div class="profile-info-name"> COD. POSTAL</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.codigo_postal}" /></span>
                    </div>
            </div>  
            <div class="profile-info-row">
                    <div class="profile-info-name"> TELEFONO</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.telefono}" /></span>
                    </div>
            </div>          
             <div class="profile-info-row">
                    <div class="profile-info-name"> Otro Telefono</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.otro_telefono}" /></span>
                    </div>
            </div>          
             <div class="profile-info-row">
                    <div class="profile-info-name"> Email</div>

                    <div class="profile-info-value">
                            <span class="editable" id="username"><c:out value="${empleado.email}" /></span>
                    </div>
            </div>  
                      
            
        </div>
                    
       
        <div class="hr hr-dotted hr-16"></div>
										


    </div>
</div>

<!-- /section:settings.box -->


                            
                            
					</div><!-- /.row -->