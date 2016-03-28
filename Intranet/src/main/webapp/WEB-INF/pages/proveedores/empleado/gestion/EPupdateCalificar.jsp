<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="page-content">  

<div class="page-header">
    <div class="row">
        <div class="col-lg-8">  
        <h1>
            Calificación General
            <small>
                    <i class="ace-icon fa fa-angle-double-right"></i>
                    
            </small>
        </h1>
        </div>
         <div class="col-lg-4 align-right">
            
            <a class=" btn btn-white btn-warning" href="/Intranet/emp/EPGestion.htm" data-rel="tooltip">
                <i class="ace-icon fa fa-reply icon-only"></i>
            </a> 
        </div>
        
             
             
    </div>        
</div><!-- /.page-header -->   

        <div class="row">
            <div class="col-xs-12 col-sm-3 center">
                            <div>
                                    <!-- #section:pages/profile.picture -->
                                    <span class="profile-picture">
                                            <img id="avatar" class="editable img-responsive" alt="${pro.nombre}" src="/Intranet/resources/fotosPerfil/proveedores/${pro.nombreFoto}" />
                                    </span>

                                    <!-- /section:pages/profile.picture -->
                                    <div class="space-4"></div>

                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                            <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                                            <i class="ace-icon fa fa-circle light-green"></i>
                                                            &nbsp;
                                                            <span class="white">${pro.nombre} </span>
                                                    </a>

                                                   
                                            </div>
                                    </div>
                            </div>

                            <div class="space-6"></div>

                            <!-- #section:pages/profile.contact -->
                         

                    </div>
                    <div class="col-xs-9">
                            <!-- PAGE CONTENT BEGINS -->
                            <form:form id="form1" action="" method="POST" commandName="calificar" class="form-horizontal" role="form">
                                <form:hidden id="id" path="id" />
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> EMPLEADO:</label>

                                            <div class="col-sm-9">
                                                <form:hidden id="empleado_nif" path="empleado_nif.nif" value="${empl.nif}"/>
                                                <label class="col-sm-9" >
                                                    ${empl.nif} ${empl.apellidos}, ${empl.nombre}
                                                </label>
                                            </div>
                                    </div>
                                   
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> PROVEEDOR: </label>

                                            <div class="col-sm-9">
                                                <form:hidden id="proveedor_numcuenta" path="proveedor_numcuenta.id" value="${pro.id}"/>
                                                <label class="col-sm-9 " >
                                                    ${pro.num_cuenta} ${pro.nombre}
                                                </label>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-top"> Calificación General: </label>

                                            <div class="col-sm-9">
                                                <div id="calificacion" data-rating="${calificar.calificacion}"><form:hidden name="rating" path="calificacion"/></div>
                                            </div>
                                    </div>
                                  
                                     <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> COMENTARIO: </label>

                                            <div class="col-sm-9">
                                                <form:textarea id="comentario" type="text" class="col-xs-10 col-sm-5" placeholder="Comentario" path="comentario"/>
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-top"> Calidad de los Trabajos </label>

                                            <div class="col-sm-9">
                                                <div id="calidadtrabajo" data-rating="${calificar.calidadtrabajo}"><form:hidden name="rating" path="calidadtrabajo"/></div>
                                            </div>
                                    </div>
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-top"> Limpieza y Orden</label>

                                            <div class="col-sm-9">
                                                <div id="limpiezaorden" data-rating="${calificar.limpiezaorden}"><form:hidden name="rating" path="limpiezaorden"/></div>
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-top"> Plazos de Ejecucion </label>

                                            <div class="col-sm-9">
                                                <div id="plazos" data-rating="${calificar.plazos}"><form:hidden name="rating" path="plazos"/></div>
                                            </div>
                                    </div> 
                                    <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-top">Cumplimiento Normativo </label>

                                            <div class="col-sm-9">
                                                <div id="cumplimiento" data-rating="${calificar.cumplimiento}"><form:hidden name="rating" path="cumplimiento"/></div>
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